import { AccessAdminProfileService } from './../../services/access-admin-profile.service';
import { Profile } from './../../objetos/Profile';
import { ProfileService } from './../../services/profile.service';
import { LoginService } from './../../services/login.service';
import { AccessEditorProfileService } from './../../services/access-editor-profile.service';
import { AccessUserProfileService } from './../../services/access-user-profile.service';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { Usuario } from './../../objetos/Usuario';
import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  _usuario: Usuario;
  _router: Router;
  messageFlag: boolean = false;
  registrationForm!: FormGroup;
  constructor(private formBuilder: FormBuilder, private loginService: LoginService, private profileService: ProfileService, private accessProfile: AccessUserProfileService, private accessEditorProfile: AccessEditorProfileService, private accessAdminProfileService: AccessAdminProfileService, private router: Router) {
    this._usuario = new Usuario(0, "", "", "", 1, "");
    this._router = router;
  }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      email: [null, Validators.required],
      password: [null, Validators.required],
    });
  }
  login() {
    if (this.registrationForm.valid) {
      console.log("algo");
      console.log(this.registrationForm.value);
      console.log("Enviar los datos al servidor");
      this.loginService.crearUsuario(this.registrationForm.value)
        .subscribe((created: Usuario) => {
          this.registrationForm.reset({
            "email": null,
            "password": null
          });
          console.log("created");
          console.log(created);
          if (created != null) {

            if (created.tipo == 1) {
              console.log('usuario normal');
              this.accessProfile.usuario = created;
              this.profileService.obtainProfile(created).subscribe((perfil: Profile) => {
                console.log('estamos aqui');
                this.messageFlag = true;
                if (perfil != null) {
                  console.log('pasamos por aqui');
                  this.accessProfile.profile = perfil;
                  this.accessProfile.validar();
                  this.messageFlag = true;
                  this.mensajeDeExito();
                } else {
                  console.log("nop es nulo");
                }
              }
              );
              this.accessProfile.validar();
            } else if (created.tipo == 2) {
              this.accessEditorProfile.usuario = created;
              this.accessEditorProfile.validar();
              this.messageFlag = true;

            } else if (created.tipo == 3) {
              this.accessAdminProfileService.usuario = created;
              this.accessAdminProfileService.validar();
              this.messageFlag = true;
            }

            if (this.messageFlag == true) {
              console.log("pues si...");
              this.mensajeDeExito();
              
            }
          } else {

            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: '¡Error en el servidor!',
            })

          }
        }, (error: any) => {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Algo salio mal >_<',
            footer: error
          })
        });
    } else {
      console.log("no estuvo bien")
    }
  }

  mensajeDeExito() {

    Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: '¡Login exitoso!',
      showConfirmButton: false,
      timer: 1500
    })
    this._router.navigate(['']);
  }
}
