import { Numero } from './../../objetos/Numero';
import { NewTitleService } from './../../services/new-title.service';
import { RevistaActivaService } from './../../services/revista-activa.service';
import { UploadPdfService } from './../../services/upload-pdf.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { NewMagazineService } from 'src/app/services/new-magazine.service';
import { Revista } from 'src/app/objetos/Revista';
import { pdfDefaultOptions } from 'ngx-extended-pdf-viewer';

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

  constructor(router: Router, private formBuilder: FormBuilder, public uploadPdfService: UploadPdfService,
    private revistaActivaService: RevistaActivaService, private titleService: NewTitleService) {
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


  fileUploadInAngular(event: Event) {
    console.log("pues si")
    const files = (event.target as  HTMLInputElement).files;
    if (files != null) {
      let archivo = files.item(0);
      if(archivo != null){
        this.selectedFile = archivo;
        this.bandera = true;
        console.log(archivo.name);
      }
    }
  }



  crearTitulo() {
    if (this.registrationForm.valid && this.selectedFile != null) {
      console.log("algo");
      console.log(this.registrationForm.value);
      console.log("Enviar los datos al servidor");
      this.titleService.crearNumero(this.registrationForm.value, this.revistaActivaService.revistaActiva)
        .subscribe((created: Numero) => {
          this.registrationForm.reset({
            "nombre": null,
            "descripcion": null,
            "fechaPublicacion": null
          });
          console.log("created number");
          console.log(created);
          if (created != null) {
            this.subirArchivo();
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

  subirArchivo(){
    this.uploadPdfService.subirArchivo(this.selectedFile).subscribe((data)=>{
      this.bandera = true;
    })
  }

}
