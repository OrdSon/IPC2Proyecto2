import { Numero } from './../../objetos/Numero';
import { NewTitleService } from './../../services/new-title.service';
import { RevistaActivaService } from './../../services/revista-activa.service';
import { UploadPdfService } from './../../services/upload-pdf.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { Revista } from 'src/app/objetos/Revista';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-new-title-form',
  templateUrl: './new-title-form.component.html',
  styleUrls: ['./new-title-form.component.css']
})
export class NewTitleFormComponent implements OnInit {
  _router: Router;
  archivoSeleccionado!: File | null;
  registrationForm!: FormGroup;
  nombreRevista!: String;
  revista: Revista;
  pdfSrc!: String;
  bandera: boolean = false;
  selectedFile!: File;
  image!:any;

  constructor(router: Router, private formBuilder: FormBuilder, public uploadPdfService: UploadPdfService,
    private revistaActivaService: RevistaActivaService, private titleService: NewTitleService, private sanitizer:DomSanitizer) {
    this._router = router;
    this.revista = revistaActivaService.revistaActiva;
  }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      nombre: [null, Validators.required],
      descripcion: [null, Validators.required],
      fechaPublicacion: [null, Validators.required]
    });
  }


  fileUploadInAngular(event: any) {
    const file = event.target.files[0];
    this.getBase64(file).then((image:any)=>{
      this.selectedFile = file;
      this.image = image.base;
      this.bandera = true;
      console.log(this.image);
    })
  }

  getBase64 = async ($event: any) => new Promise((resolve, reject) => {
    try {
      const unsafeImg = window.URL.createObjectURL($event);
      const image = this.sanitizer.bypassSecurityTrustUrl(unsafeImg);
      const reader = new FileReader();
      reader.readAsDataURL($event);
      reader.onload = () => {
        resolve({
          base: reader.result
        });
      };
      reader.onerror = _error => {
        resolve({
          base: null
        });
      };
      return;
    } catch (e) {
      return null;
    }
  })
  
  crearTitulo() {
    if (this.registrationForm.valid && this.image != null && this.image != "") {
      console.log("algo");
      console.log(this.registrationForm.value);
      console.log("Enviar los datos al servidor");
      this.titleService.crearNumero(this.registrationForm.value, this.image ,this.revistaActivaService.revistaActiva)
        .subscribe((created: Numero) => {
          this.registrationForm.reset({
            "nombre": null,
            "descripcion": null,
            "fechaPublicacion": null
          });
          console.log("created number");
          console.log(created);
          if (created != null) {
            Swal.fire({
              icon:'success',
              title:'conseguido'
            })
          } else {

            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: '¡Error en el servidor!',
            })

          }
        }, (error: any) => {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Algo salio mal >_<',
            footer: error
          })
        });
    } else {
      console.log("no estuvo bien");
    }
  }


}
