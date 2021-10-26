import { RevistaActivaService } from './../../services/revista-activa.service';
import { Revista } from './../../objetos/Revista';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-magazine-descriptor',
  templateUrl: './magazine-descriptor.component.html',
  styleUrls: ['./magazine-descriptor.component.css']
})
export class MagazineDescriptorComponent implements OnInit {
  revista:Revista;
  constructor(public revistaActivaService:RevistaActivaService) { 
    this.revista = revistaActivaService.revistaActiva;
  }
  
  ngOnInit(): void {
  }

  cambiarPagina(){
    this.revistaActivaService.verRevistas = false;
  }
}
