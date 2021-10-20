import { Router } from '@angular/router';
import { AccessUserProfileService } from './../services/access-user-profile.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile-viewer',
  templateUrl: './profile-viewer.component.html',
  styleUrls: ['./profile-viewer.component.css']
})
export class ProfileViewerComponent implements OnInit {
  bandera:boolean=false;
  nombre!:String;
  email!:String;
  constructor(public accessProfile:AccessUserProfileService, private router:Router) { 
    this.validar();
    this.nombre = accessProfile.usuario.nombre;
    this.email = accessProfile.usuario.email;
  }

  ngOnInit(): void {
    this.validar();
  }

  crearPerfil(){
    this.router.navigate(["new/member/profile"]);
  }

  validar(){
    if(this.accessProfile.profile != null){
      this.bandera = true;
    }
  }

  mensaje(){
    if(this.accessProfile.profile == null || this.accessProfile.profile.descripcion == ""){
      return 'Aqui falta algo, ¡Crea un perfil!';
    }
    return '';
  }
}
