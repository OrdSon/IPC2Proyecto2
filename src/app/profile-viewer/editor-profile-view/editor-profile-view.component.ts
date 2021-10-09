import { Component, OnInit } from '@angular/core';
import { AccessEditorProfileService } from 'src/app/services/access-editor-profile.service';

@Component({
  selector: 'app-editor-profile-view',
  templateUrl: './editor-profile-view.component.html',
  styleUrls: ['./editor-profile-view.component.css']
})
export class EditorProfileViewComponent implements OnInit {

  constructor(public accessProfile:AccessEditorProfileService) { }

  ngOnInit(): void {
  }

}
