import { RevistaActivaService } from './../../services/revista-activa.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccessEditorProfileService } from 'src/app/services/access-editor-profile.service';

@Component({
  selector: 'app-editor-profile-view',
  templateUrl: './editor-profile-view.component.html',
  styleUrls: ['./editor-profile-view.component.css']
})
export class EditorProfileViewComponent implements OnInit {
  router:Router;
  constructor(router:Router, public accessProfile:AccessEditorProfileService, public revistaActivaService:RevistaActivaService) { 
    this.router = router;
  }

  ngOnInit(): void {
  }
  navegar(){
    this.router.navigate(["new/revista"]);
    console.log(this.router.url);
  }

  validar(){
    if(this.revistaActivaService.revistaActiva != null){
      return true;
    }
    return false;
  }

  verReportes(){
    this.router.navigate(['profile/editor/view/reports']);
  }
}
