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
import { EditorNumberPreviewComponent } from './componentes-basicos/editor-number-preview/editor-number-preview.component';
import { NumberActionsComponent } from './componentes-basicos/number-actions/number-actions.component';
import { NotFoundPageComponent } from './componentes-basicos/not-found-page/not-found-page.component';
import { PreviewCardComponent } from './componentes-basicos/preview-card/preview-card.component';
import { PreviewListComponent } from './componentes-basicos/preview-list/preview-list.component';
import { UserPreviewPageComponent } from './componentes-basicos/user-preview-page/user-preview-page.component';
import { MagazineReaderComponent } from './componentes-basicos/magazine-reader/magazine-reader.component';
import { PaymentInfoFormComponent } from './componentes-basicos/payment-info-form/payment-info-form.component';
import { SettingsFormComponent } from './componentes-basicos/settings-form/settings-form.component';
import { SuscipcionActionsComponent } from './componentes-basicos/suscipcion-actions/suscipcion-actions.component';
import { SuscriptionListComponent } from './componentes-basicos/suscription-list/suscription-list.component';
import { ReporteComentariosComponent } from './Componentes de reportes/reporte-comentarios/reporte-comentarios.component';
import { ListaReportesComponent } from './Componentes de reportes/lista-reportes/lista-reportes.component';
import { ReporteSuscripcionesComponent } from './Componentes de reportes/reporte-suscripciones/reporte-suscripciones.component';
import { ReporteLikesComponent } from './Componentes de reportes/reporte-likes/reporte-likes.component';

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
    MagazineDescriptorComponent,
    EditorNumberPreviewComponent,
    NumberActionsComponent,
    NotFoundPageComponent,
    PreviewCardComponent,
    PreviewListComponent,
    UserPreviewPageComponent,
    MagazineReaderComponent,
    PaymentInfoFormComponent,
    SettingsFormComponent,
    SuscipcionActionsComponent,
    SuscriptionListComponent,
    ReporteComentariosComponent,
    ListaReportesComponent,
    ReporteSuscripcionesComponent,
    ReporteLikesComponent,
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
