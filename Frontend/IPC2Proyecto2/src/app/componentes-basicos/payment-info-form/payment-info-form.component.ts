import { SuscriptionAdministrationService } from './../../services/suscription-administration.service';
import { Usuario } from 'src/app/objetos/Usuario';
import { AccessUserProfileService } from 'src/app/services/access-user-profile.service';
import { PaymentService } from './../../services/payment.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { InfoPago } from 'src/app/objetos/InfoPago';

@Component({
  selector: 'app-payment-info-form',
  templateUrl: './payment-info-form.component.html',
  styleUrls: ['./payment-info-form.component.css']
})
export class PaymentInfoFormComponent implements OnInit {
  registrationForm!: FormGroup;
  edicionHabilitada:boolean=false;
  validado:boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router, public payment:PaymentService, public accessProfile:AccessUserProfileService,
    private suscriptionService:SuscriptionAdministrationService) { 
    this.validarInfoPago();
  }

  ngOnInit(): void {
    this.formReboot();
  }

  habilitarEdicion(){
    this.edicionHabilitada = !this.edicionHabilitada;
    this.formReboot();
  }

  formReboot(){
    this.registrationForm = this.formBuilder.group({
      tarjeta:[null, Validators.required],
      vencimiento:[null, Validators.required]
    });
  }
  validarInfoPago(){
    if(this.accessProfile.usuario != null){
      this.payment.verificarInfoPago(this.accessProfile.usuario).subscribe((created:InfoPago)=>{
        if(created != null && created.tarjeta!=""){
          this.payment.infoPago = created;
          console.log("info de pago true");
           this.validado=true;
           console.log(created+"INFO DE PAGO");
           return;
        }
          console.log("info de pago FALSE");
         this.validado = false;
      })
    }

  }
  enviarInformacion() {
    if (this.registrationForm.valid) {
      console.log("algo");
      console.log(this.registrationForm.value);
      console.log("Enviar los datos al servidor");
      console.log("usuario codigo:"+ this.accessProfile.usuario.codigo);
      this.payment.crearInfoPago(this.registrationForm.value, this.accessProfile.usuario)
        .subscribe((created: InfoPago) => {
          this.registrationForm.reset({
            "tarjeta": null,
            "vencimiento": null
          });
          console.log("created");
          console.log(created);
          if (created != null) {
            Swal.fire({
              icon: 'success',
              title: 'Su información se ha añadido exitosamente'
            });
            if(this.suscriptionService.wantToSubscribe){
              this.suscriptionService.wantToSubscribe = false;
              this.router.navigate(['view/magazine-preview']);

            }else{
              this.router.navigate(['profile/view']);

            }
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

  editarInformacion() {
    if (this.registrationForm.valid) {
      console.log("algo");
      console.log(this.registrationForm.value);
      console.log("Enviar los datos al servidor");
      this.payment.editarInfoPago(this.registrationForm.value, this.accessProfile.usuario)
        .subscribe((created: InfoPago) => {
          this.registrationForm.reset({
            "tarjeta": null,
            "vencimiento": null
          });
          console.log("created");
          console.log(created);
          if (created != null && created.tarjeta!="") {
            Swal.fire({
              icon: 'success',
              title: 'Su información se ha editado exitosamente'
            });
            this.router.navigate(['profile/view']);
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

}
