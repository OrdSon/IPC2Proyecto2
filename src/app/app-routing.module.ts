import { ListaReportesComponent } from './Componentes de reportes/lista-reportes/lista-reportes.component';
import { EditorNumberPreviewComponent } from './componentes-basicos/editor-number-preview/editor-number-preview.component';
import { CategoryAdministrationFormComponent } from './componentes-basicos/category-administration-form/category-administration-form.component';
import { AdminProfileViewerComponent } from './profile-viewer/admin-profile-viewer/admin-profile-viewer.component';
import { NotFoundComponent } from './componentes-basicos/not-found/not-found.component';
import { NewTitleFormComponent } from './componentes-basicos/new-title-form/new-title-form.component';
import { NewMagazineFormComponent } from './componentes-basicos/new-magazine-form/new-magazine-form.component';
import { EditorProfileViewComponent } from './profile-viewer/editor-profile-view/editor-profile-view.component';
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
import { UserPreviewPageComponent } from './componentes-basicos/user-preview-page/user-preview-page.component';
import { MagazineReaderComponent } from './componentes-basicos/magazine-reader/magazine-reader.component';
import { PaymentInfoFormComponent } from './componentes-basicos/payment-info-form/payment-info-form.component';

const routes: Routes = [
  {
    path: '',
    component: SideBarComponent
  },
  {
    path: 'profile/editor/view/reports',
    component: ListaReportesComponent
  },
  {
    path: 'new/member/profile',
    component: ProfileCreationFormComponent
  },
 
  {
    path: 'view/magazine-preview',
    component:UserPreviewPageComponent
  }, 
  {
    path: 'view/payment-info',
    component:PaymentInfoFormComponent
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
    path: 'new/title',
    component: NewTitleFormComponent
  }, 
  {
    path: 'new/revista',
    component: NewMagazineFormComponent
  }, 
  {
    path: 'new/member',
    component: RegistrationFormComponent
  }, 
  {
    path: 'profile/admin/view',
    component:AdminProfileViewerComponent
  },
  {
    path: 'profile/editor/view/numero',
    component:EditorNumberPreviewComponent
  },
  {
    path: 'profile/editor/view',
    component:EditorProfileViewComponent
  },
  {
    path: 'profile/view',
    component:ProfileViewerComponent
  },
  {
    path: 'read/magazine',
    component:MagazineReaderComponent
  },
  {
    path: 'manejar/categorias',
    component: CategoryAdministrationFormComponent
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
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }