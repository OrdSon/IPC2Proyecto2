import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NavService {

  eleccion:number = 0;
  constructor() {
  }

  setEleccion(eleccion:number){
    this.eleccion = eleccion;
  }
  getEleccion(){
    return this.eleccion;
  }
}
