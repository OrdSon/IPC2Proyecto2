import { ViewMagazineNumbersService } from './../../services/view-magazine-numbers.service';
import { RevistaActivaService } from './../../services/revista-activa.service';
import { Numero } from './../../objetos/Numero';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-number-magazine-list',
  templateUrl: './number-magazine-list.component.html',
  styleUrls: ['./number-magazine-list.component.css']
})
export class NumberMagazineListComponent implements OnInit {

  listaNumeros:Numero[] = [];
  constructor(public revistaActivaService:RevistaActivaService, public viewMagazineNumbersService:ViewMagazineNumbersService) {
    this.obtenerLista();
  } 

  ngOnInit(): void {
  }
  obtenerLista() {
    this.viewMagazineNumbersService.buscarPorAutor(this.revistaActivaService.revistaActiva)
    .subscribe((lista: Numero[]) => {
      this.listaNumeros = lista;
      console.log(this.listaNumeros);
    })
  }
}
