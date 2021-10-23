import { AccessUserProfileService } from './../../services/access-user-profile.service';
import { PaymentService } from './../../services/payment.service';
import { SuscriptionAdministrationService } from './../../services/suscription-administration.service';
import { Router } from '@angular/router';
import { Preview } from './../../objetos/Preview';
import { CurrentPreviewService } from './../../services/current-preview.service';
import { Component, OnInit } from '@angular/core';
import { InfoPago } from 'src/app/objetos/InfoPago';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-user-preview-page',
  templateUrl: './user-preview-page.component.html',
  styleUrls: ['./user-preview-page.component.css']
})
export class UserPreviewPageComponent implements OnInit {
  preview!:Preview;
  validado:boolean = false;
  constructor(public currentPreview:CurrentPreviewService, private router:Router, public subscriptionService:SuscriptionAdministrationService,
    public payment:PaymentService, public accessProfile:AccessUserProfileService) { 
    
  }

  ngOnInit(): void {
    this.preview = this.currentPreview.preview;
  }

  leer(){
    this.checkearInfoPago();
    this.router.navigate(['read/magazine']);
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
           return;
        }
          
          console.log("info de pago FALSE");
         this.validado = false;
         this.subscriptionService.wantToSubscribe = true;
         this.router.navigate(['view/payment-info']);
      })
    }

  }

}
