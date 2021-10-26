import { AnuncioServiceService } from './../../services/anuncio-service.service';
import { Component, OnInit } from '@angular/core';
import { Anuncio } from 'src/app/objetos/Anuncio';

@Component({
  selector: 'app-anuncio',
  templateUrl: './anuncio.component.html',
  styleUrls: ['./anuncio.component.css']
})
export class AnuncioComponent implements OnInit {
bandera:boolean = false;
  constructor(private anuncioService:AnuncioServiceService) {
    this.obtenerAnuncio();
    
   }
anuncio!:Anuncio;
  ngOnInit(): void {
  }
  obtenerAnuncio(){
    this.anuncioService.obtenerAnuncio().subscribe((created:Anuncio)=>{
      if(created != null){
        this.anuncio = created;
        this.bandera = true;
        console.log("Exito")
      }

    });
  }


}
