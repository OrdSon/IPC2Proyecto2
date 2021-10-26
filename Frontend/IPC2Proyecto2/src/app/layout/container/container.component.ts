import { NavService } from './../../services/nav.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.css']
})
export class ContainerComponent implements OnInit {

  constructor(public navService:NavService) { }

  ngOnInit(): void {
  }

  getNavEleccion(){
    return this.navService.getEleccion();
  }

}
