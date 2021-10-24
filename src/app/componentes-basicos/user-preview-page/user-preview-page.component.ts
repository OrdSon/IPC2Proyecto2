import { AccessUserProfileService } from './../../services/access-user-profile.service';
import { PaymentService } from './../../services/payment.service';
import { SuscriptionAdministrationService } from './../../services/suscription-administration.service';
import { Router } from '@angular/router';
import { Preview } from './../../objetos/Preview';
import { CurrentPreviewService } from './../../services/current-preview.service';
import { Component, OnInit } from '@angular/core';
import { InfoPago } from 'src/app/objetos/InfoPago';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { Suscripcion } from 'src/app/objetos/Suscripcion';

@Component({
  selector: 'app-user-preview-page',
  templateUrl: './user-preview-page.component.html',
  styleUrls: ['./user-preview-page.component.css']
})
export class UserPreviewPageComponent implements OnInit {
  preview!:Preview;
  validado:boolean = false;
  wantToSuscribe:boolean = false;
  registrationForm!: FormGroup;

  constructor(public currentPreview:CurrentPreviewService, private router:Router, public subscriptionService:SuscriptionAdministrationService,
    public payment:PaymentService, public accessProfile:AccessUserProfileService, private formBuilder:FormBuilder) { 
    
  }

  ngOnInit(): void {
    this.preview = this.currentPreview.preview;
  }

  leer(){
    if(this.accessProfile.usuario == null){
      Swal.fire({
        icon:'warning',
        title:'Necesitas registrarte para acceder aqui',

      });
      return;
    }
    this.checkearInfoPago();
   
  }
  validar(){
    if(this.preview != null){
      return true;
    }
    return false;
  }

  checkearInfoPago(){
    if(this.accessProfile.usuario != null){
      this.payment.verificarInfoPago(this.accessProfile.usuario).subscribe((created:InfoPago)=>{
        if(created != null && created.tarjeta!=""){
          this.payment.infoPago = created;
          console.log("info de pago true");
           this.validado=true;
           console.log(created+"INFO DE PAGO");
           this.verificarSuscripcion();
           return;
        }
          
          console.log("info de pago FALSE");
         this.validado = false;
         this.subscriptionService.wantToSubscribe = true;
         this.router.navigate(['view/payment-info']);
      })
    }

  }

  verificarSuscripcion(){
    let temporal = new Suscripcion();
    if(this.accessProfile.usuario == null){
      return;
    }
    temporal.usuarioCodigo = this.accessProfile.usuario.codigo;
    temporal.revistaCodigo = this.preview.revistaCodigo;
    this.subscriptionService.verificarSuscripcion(temporal).subscribe((created:Suscripcion)=>{
      if(created == null){
        this.wantToSuscribe = true;
        this.rebootForm();
        return;
      }else{
        this.router.navigate(['read/magazine']);
      }
    })
  }
  crearSucripcion() {
    if (this.registrationForm.valid) {
      console.log("algo");
      console.log(this.registrationForm.value);
      console.log("Enviar los datos al servidor");
      this.subscriptionService.crearSuscripcion(this.registrationForm.value, this.accessProfile.usuario.codigo , this. preview.revistaCodigo)
        .subscribe((created: Suscripcion) => {
          this.registrationForm.reset({
            "nombre": null
          });
          console.log("created");
          console.log(created);
          if (created != null) {
            Swal.fire({
              icon: 'success',
              title: 'Te has suscrito con exito',
              text:'Puedes revisar los detalles en tu perfil'
            });
            this.router.navigate(['read/magazine']);
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
      console.log("no estuvo bien")
    }
  }

  rebootForm(){
    this.registrationForm = this.formBuilder.group({
      fecha: [null, Validators.required]
    });
  }
}
