import { AccessAdminProfileService } from './../../services/access-admin-profile.service';
import { BuscarRevista } from './../../objetos/BuscarRevista';
import { BuscarRevistasService } from './../../services/buscar-revistas.service';
import { AccessEditorProfileService } from './../../services/access-editor-profile.service';
import { AccessUserProfileService } from './../../services/access-user-profile.service';
import { NavService } from './../../services/nav.service';
import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/objetos/Usuario';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  
  validator:boolean = false;
  constructor(public navService:NavService, public acccesProfile:AccessUserProfileService, public accesEditorProfile:AccessEditorProfileService,
    public buscarRevistasService: BuscarRevistasService, public accessAdminProfile:AccessAdminProfileService) { 

  }

  ngOnInit(): void {
  }
  prueba(){
    this.buscarRevistasService.crearUsuario().subscribe((creado:BuscarRevista) =>{
      if(creado != null){
        console.log(creado);
      }
    })
  }
  setNavEleccion(eleccion:number){
    this.navService.setEleccion(eleccion);
  }

  getUsuario(){
    return this.acccesProfile.usuario;
  }

  
}
