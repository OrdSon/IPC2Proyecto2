import { Injectable } from '@angular/core';
import { Revista } from '../objetos/Revista';

@Injectable({
  providedIn: 'root'
})
export class RevistaActivaService {
  _revistaActiva!:Revista;

  constructor() { }

  get revistaActiva(){
    return this._revistaActiva;
  }

  set revistaActiva(revistaActiva:Revista){
    this.revistaActiva = revistaActiva;
  }
}
