import { AccessEditorProfileService } from 'src/app/services/access-editor-profile.service';
import { BuscarRevistasService } from './../../services/buscar-revistas.service';
import { NewMagazineService } from 'src/app/services/new-magazine.service';
import { Revista } from './../../objetos/Revista';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-editor-magazine-list',
  templateUrl: './editor-magazine-list.component.html',
  styleUrls: ['./editor-magazine-list.component.css']
})
export class EditorMagazineListComponent implements OnInit {

  listaRevistasEditor:Revista[] = [];
  constructor(private editorProfileService:AccessEditorProfileService,
    private magazineService:NewMagazineService, private buscarService:BuscarRevistasService) {
      this.obtenerLista();
   }
  
  ngOnInit(): void {
    
  }
  obtenerLista() {
    this.buscarService.buscarPorAutor(this.editorProfileService.usuario)
    .subscribe((lista: Revista[]) => {
      this.listaRevistasEditor = lista;
      console.log(this.listaRevistasEditor);
    })
  }
}
