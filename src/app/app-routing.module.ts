import { LoginFormComponent } from './Registro/login-form/login-form.component';
import { ProfileViewerComponent } from './profile-viewer/profile-viewer.component';
import { AdministratorRegistrationFormComponent } from './Registro/administrator-registration-form/administrator-registration-form.component';
import { ProfileCreationFormComponent } from './Registro/profile-creation-form/profile-creation-form.component';
import { SideBarComponent } from './layout/side-bar/side-bar.component';
import { EditorRegistrationFormComponent } from './Registro/editor-registration-form/editor-registration-form.component';
import { RegistrationFormComponent } from './Registro/registration-form/registration-form.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ContainerComponent } from './layout/container/container.component';

const routes: Routes = [
  {
    path: '',
    component: SideBarComponent
  },
  {
    path: 'new/member',
    component: RegistrationFormComponent
  }, 
  {
    path: 'new/member/profile',
    component: ProfileCreationFormComponent
  }, 
  {
    path: 'new/editor',
    component: EditorRegistrationFormComponent
  },
  {
    path: 'new/administrator',
    component: AdministratorRegistrationFormComponent
  }, 
  {
    path: 'profile/view',
    component:ProfileViewerComponent
  },
  {
    path: 'login',
    component:LoginFormComponent
  },
  {
    path: 'profile/:username',
    component: EditorRegistrationFormComponent
  }, 
  {
    path: '**',
    component: SideBarComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
