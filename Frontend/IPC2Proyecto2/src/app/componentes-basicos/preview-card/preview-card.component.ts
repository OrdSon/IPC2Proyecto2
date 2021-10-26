import { Router } from '@angular/router';
import { CurrentPreviewService } from './../../services/current-preview.service';
import { Preview } from './../../objetos/Preview';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-preview-card',
  templateUrl: './preview-card.component.html',
  styleUrls: ['./preview-card.component.css']
})
export class PreviewCardComponent implements OnInit {

  @Input() preview!:Preview

  constructor(public currentPreviewService:CurrentPreviewService, private router:Router) { }

  ngOnInit(): void {
  }

  verPreview(){
    this.currentPreviewService.preview = this.preview;
    this.router.navigate(['view/magazine-preview']);
  }

}
