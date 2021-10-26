import { Revista } from './../objetos/Revista';
import { Usuario } from './../objetos/Usuario';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AccessEditorProfileService {
  _usuario!:Usuario;
  validator:boolean = false;
  constructor() { }
  validar(){
    if(this._usuario == null){
      this.validator = false;
    }else{
      this.validator=true;
    }
  }

  get usuario(){
    return this._usuario;
  }

  set usuario(usuario:Usuario){
    this._usuario = usuario;
  }


  
}
