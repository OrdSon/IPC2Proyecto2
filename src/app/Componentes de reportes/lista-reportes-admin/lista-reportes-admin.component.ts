import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-reportes-admin',
  templateUrl: './lista-reportes-admin.component.html',
  styleUrls: ['./lista-reportes-admin.component.css']
})
export class ListaReportesAdminComponent implements OnInit {

  constructor() { }
  eleccion:number= 0;
  ngOnInit(): void {
  }

  gananciasRevista(){
    this.eleccion = 2;
  }
  gananciasTotales(){
    this.eleccion = 1;
  }
  gustadas(){
    this.eleccion = 3;
  }
  comentarios(){
    this.eleccion = 4;
  }
}
