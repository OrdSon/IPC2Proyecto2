import { AnuncioServiceService } from './../../services/anuncio-service.service';
import { Component, OnInit } from '@angular/core';
import { Anunciante } from 'src/app/objetos/Anunciante';

@Component({
  selector: 'app-admin-anunciante-list',
  templateUrl: './admin-anunciante-list.component.html',
  styleUrls: ['./admin-anunciante-list.component.css']
})
export class AdminAnuncianteListComponent implements OnInit {

  listaAnunciantes:Anunciante[] = [];
  constructor(public anuncioService:AnuncioServiceService) {
    this.obtenerLista();
   }

  ngOnInit(): void {
  }

  obtenerLista() {
    this.anuncioService.obtenerAnunciantes()
    .subscribe((lista: Anunciante[]) => {
      this.listaAnunciantes = lista;
      console.log(this.listaAnunciantes);
    })
  }

}
