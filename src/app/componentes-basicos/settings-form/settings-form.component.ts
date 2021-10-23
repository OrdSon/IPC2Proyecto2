import { SettingsAdministrationService } from './../../services/settings-administration.service';
import { Setting } from './../../objetos/Setting';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, RouteReuseStrategy } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-settings-form',
  templateUrl: './settings-form.component.html',
  styleUrls: ['./settings-form.component.css']
})
export class SettingsFormComponent implements OnInit {
  
  registrationForm!: FormGroup;
  existe:boolean = false;
  edicionHabilitada:boolean = false;
  setting!:Setting;
  constructor(private formBuilder: FormBuilder, private settingService:SettingsAdministrationService,private router:Router) { 
    this.validarSettings();
  }

  ngOnInit(): void {
    this.rebootForm();
  }

  rebootForm(){
    this.registrationForm = this.formBuilder.group({
      porcentajeCobro: [null, Validators.required],
      cuotaDiaria: [null, Validators.required],
      precioHoraAnuncio: [null, Validators.required],
    });
  }
  habilitarEdicion(){
    this.edicionHabilitada = !this.edicionHabilitada;
    this.rebootForm();
  }
  validarSettings(){

      this.settingService.verificarSettings().subscribe((created:Setting)=>{
        if(created != null){
          this.settingService.setting = created;
          this.setting = created;
          console.log("settings");
           this.existe=true;
           console.log(created+"SETTINGS");
           return;
        }
          console.log("settings falseeeee");
         this.existe = false;
         this.rebootForm();
      })
    }
    
  enviarSettings() {
    if (this.registrationForm.valid) {
      console.log("algo");
      console.log(this.registrationForm.value);
      console.log("Enviar los datos al servidor");
      this.settingService.enviarSettings(this.registrationForm.value)
        .subscribe((created: Setting) => {
          this.registrationForm.reset({
            "porcentajeCobro": null,
            "cuotaDiaria":null,
            "precioHoraAnuncio":null
          });
          console.log("created");
          console.log(created);
          if (created != null) {
            Swal.fire({
              icon: 'success',
              title: 'Informacion guardada exitosamente'
            });
            this.existe = true;
            this.setting = created;
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

  regresar(){
    this.edicionHabilitada = false;
    this.router.navigate(['profile/admin/view']);
  }
}
