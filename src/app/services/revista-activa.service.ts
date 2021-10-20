import { Injectable } from '@angular/core';
import { Revista } from '../objetos/Revista';

@Injectable({
  providedIn: 'root'
})
export class RevistaActivaService {
  _revistaActiva!:Revista;
  _verRevistas:boolean = false;

  constructor() { }

  get revistaActiva(){
    return this._revistaActiva;
  }

  set revistaActiva(revistaActiva:Revista){
    this._revistaActiva = revistaActiva;
  }

  get verRevistas(){
    return this._verRevistas;
  }
  set verRevistas(verRevistas:boolean){
    this._verRevistas = verRevistas;
  }

  
}
