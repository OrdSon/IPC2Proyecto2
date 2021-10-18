import { AccessAdminProfileService } from './../../services/access-admin-profile.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-profile-viewer',
  templateUrl: './admin-profile-viewer.component.html',
  styleUrls: ['./admin-profile-viewer.component.css']
})
export class AdminProfileViewerComponent implements OnInit {

  constructor(public accessProfile:AccessAdminProfileService) {
    
   }

  ngOnInit(): void {
  }

}
