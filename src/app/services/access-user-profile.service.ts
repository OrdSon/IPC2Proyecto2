import { Usuario } from './../objetos/Usuario';
import { Injectable } from '@angular/core';
import { Profile } from '../objetos/Profile';

@Injectable({
  providedIn: 'root'
})
export class AccessUserProfileService {
  _usuario!:Usuario;
  _profile!:Profile;
  validator:boolean = false;
  constructor() { }

  validar(){
    if(this.usuario != null){
      this.validator = true;
    }
  }
  set usuario(usuario:Usuario){
    this._usuario=usuario;
  }
  get usuario(){
    return this._usuario;
  }
  set profile(profile:Profile){
    this._profile=profile;
  }
  get profile(){
    return this._profile;
  }

}
