import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-reportes',
  templateUrl: './lista-reportes.component.html',
  styleUrls: ['./lista-reportes.component.css']
})
export class ListaReportesComponent implements OnInit {

  constructor() { }
  eleccion:number= 0;
  ngOnInit(): void {
  }

  comentarios(){
    this.eleccion = 1;
  }
  suscripciones(){
    this.eleccion = 2;
  }
  gustadas(){
    this.eleccion = 3;
  }
  ganancias(){
    this.eleccion = 4;
  }

}
