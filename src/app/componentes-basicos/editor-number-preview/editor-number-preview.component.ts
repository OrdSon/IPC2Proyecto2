import { Numero } from './../../objetos/Numero';
import { NewTitleService } from './../../services/new-title.service';
import { Router } from '@angular/router';
import { NumberService } from './../../services/number.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-editor-number-preview',
  templateUrl: './editor-number-preview.component.html',
  styleUrls: ['./editor-number-preview.component.css']
})
export class EditorNumberPreviewComponent implements OnInit {
  registrationForm!: FormGroup;
  habilitarEdicion:boolean = false;
  bandera: boolean = false;
  selectedFile!: File;
  image!:any;

  constructor(public numberService:NumberService, private formBuilder: FormBuilder, private router:Router,
    private sanitizer:DomSanitizer, private titleService:NewTitleService) { }

  ngOnInit(): void {
  }

  editionReady(){
    this.registrationForm = this.formBuilder.group({
      nombre: [null, Validators.required],
      descripcion: [null, Validators.required],
      fechaPublicacion: [null, Validators.required]
    });

    this.habilitarEdicion = true;
  }

  validar(){
    if(this.numberService.numeroActivo != null){
      return true;
    }
    return false;
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
  
  editarNumero() {
    if (this.registrationForm.valid) {
      console.log("algo");
      console.log(this.registrationForm.value);
      console.log("Enviar los datos al servidor");
      this.titleService.editarNumero(this.registrationForm.value, this.image, this.numberService.numeroActivo)
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
      Swal.fire({
        icon:'info',
        title:'Parece que falta algo',
        text:'Llena todos los campos para continuar'
      });
    }
  }

  eliminar(){
    Swal.fire({
      title: '¿Eliminar la entrega: '+this.numberService.numeroActivo.nombre+'?',
      text: "Este cambio sera irreversible",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Eliminar'
    }).then((result) => {
      if (result.isConfirmed && this.numberService.numeroActivo != null) {
        this.titleService.eliminarNumero(this.numberService.numeroActivo).subscribe((created:Numero)=>{
          Swal.fire({
            icon:'success',
            title:'Revista eliminada'
          });
          this.router.navigate(['profile/editor/view']);
        });
      }
    });
    
  }
}
