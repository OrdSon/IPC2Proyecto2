import { PreviewService } from './../../services/preview.service';
import { Preview } from './../../objetos/Preview';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-preview-list',
  templateUrl: './preview-list.component.html',
  styleUrls: ['./preview-list.component.css']
})
export class PreviewListComponent implements OnInit {

  previewList:Preview[]=[];
  constructor(public previewService:PreviewService) { 
    this.obtenerLista();
  }

  ngOnInit(): void {
  }
  obtenerLista() {
    this.previewService.getPreviews().subscribe((lista: Preview[]) => {
      this.previewList = lista;
      console.log(this.previewList);
    })
  }
}
