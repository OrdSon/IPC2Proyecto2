import { Router } from '@angular/router';
import { AnuncioServiceService } from './../../services/anuncio-service.service';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Anunciante } from 'src/app/objetos/Anunciante';

@Component({
  selector: 'app-anunciante-actions',
  templateUrl: './anunciante-actions.component.html',
  styleUrls: ['./anunciante-actions.component.css']
})
export class AnuncianteActionsComponent implements OnInit {
  @Input() anunciante!:Anunciante;
  @Output("obtenerLista") obtenerLista: EventEmitter<any> = new EventEmitter();

  constructor(public anuncioService:AnuncioServiceService, private router:Router) { }

  ngOnInit(): void {
  }

  nuevoAnuncio(){
    this.anuncioService.anuncianteActivo = this.anunciante;
    this.router.navigate(['new/anuncio']);
  }

}
