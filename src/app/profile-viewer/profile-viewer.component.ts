import { AccessUserProfileService } from './../services/access-user-profile.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile-viewer',
  templateUrl: './profile-viewer.component.html',
  styleUrls: ['./profile-viewer.component.css']
})
export class ProfileViewerComponent implements OnInit {

  constructor(public accessProfile:AccessUserProfileService) { }

  ngOnInit(): void {
  }

}
