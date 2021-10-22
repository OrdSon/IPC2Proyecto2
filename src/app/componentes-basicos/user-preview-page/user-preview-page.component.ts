import { Router } from '@angular/router';
import { Preview } from './../../objetos/Preview';
import { CurrentPreviewService } from './../../services/current-preview.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-preview-page',
  templateUrl: './user-preview-page.component.html',
  styleUrls: ['./user-preview-page.component.css']
})
export class UserPreviewPageComponent implements OnInit {
  preview!:Preview;
  constructor(public currentPreview:CurrentPreviewService, private router:Router) { 
    
  }

  ngOnInit(): void {
    this.preview = this.currentPreview.preview;
  }

  leer(){
    this.router.navigate(['']);
  }
  validar(){
    if(this.preview != null){
      return true;
    }
    return false;
  }

}
