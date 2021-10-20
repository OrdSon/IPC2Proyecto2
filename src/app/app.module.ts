import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { NavBarComponent } from './layout/nav-bar/nav-bar.component';
import { FooterComponent } from './layout/footer/footer.component';
import { SideBarComponent } from './layout/side-bar/side-bar.component';
import { ContainerComponent } from './layout/container/container.component';
import { LoginFormComponent } from './Registro/login-form/login-form.component';
import { RegistrationFormComponent } from './Registro/registration-form/registration-form.component';
import { ProfileCreationFormComponent } from './Registro/profile-creation-form/profile-creation-form.component';
import { EditorRegistrationFormComponent } from './Registro/editor-registration-form/editor-registration-form.component';
import { CategoryRegistrationFormComponent } from './Registro/category-registration-form/category-registration-form.component';
import { CategoryElementComponent } from './componentes-basicos/category-element/category-element.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AdministratorRegistrationFormComponent } from './Registro/administrator-registration-form/administrator-registration-form.component';
import { ProfileViewerComponent } from './profile-viewer/profile-viewer.component';
import { EditorProfileViewComponent } from './profile-viewer/editor-profile-view/editor-profile-view.component';
import { NewMagazineFormComponent } from './componentes-basicos/new-magazine-form/new-magazine-form.component';
import { NewTitleFormComponent } from './componentes-basicos/new-title-form/new-title-form.component';
import { NotFoundComponent } from './componentes-basicos/not-found/not-found.component';
import { AdminProfileViewerComponent } from './profile-viewer/admin-profile-viewer/admin-profile-viewer.component';
import { CategoryAdministrationFormComponent } from './componentes-basicos/category-administration-form/category-administration-form.component';
import { MagazineActionsComponent } from './componentes-basicos/magazine-actions/magazine-actions.component';
import { EditorMagazineListComponent } from './componentes-basicos/editor-magazine-list/editor-magazine-list.component';
import { PdfViewerModule } from 'ng2-pdf-viewer';
import { NgxExtendedPdfViewerModule } from 'ngx-extended-pdf-viewer';
import { NumberMagazineListComponent } from './componentes-basicos/number-magazine-list/number-magazine-list.component';
import { MagazineDescriptorComponent } from './componentes-basicos/magazine-descriptor/magazine-descriptor.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,
    SideBarComponent,
    ContainerComponent,
    LoginFormComponent,
    RegistrationFormComponent,
    ProfileCreationFormComponent,
    EditorRegistrationFormComponent,
    CategoryRegistrationFormComponent,
    CategoryElementComponent,
    AdministratorRegistrationFormComponent,
    ProfileViewerComponent,
    EditorProfileViewComponent,
    NewMagazineFormComponent,
    NewTitleFormComponent,
    NotFoundComponent,
    AdminProfileViewerComponent,
    CategoryAdministrationFormComponent,
    MagazineActionsComponent,
    EditorMagazineListComponent,
    NumberMagazineListComponent,
    MagazineDescriptorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    PdfViewerModule,
    NgxExtendedPdfViewerModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
