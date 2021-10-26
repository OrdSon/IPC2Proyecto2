import { Admin } from './../../objetos/Admin';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UsuarioService } from 'src/app/services/usuario.service';
import { AccessUserProfileService } from 'src/app/services/access-user-profile.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Usuario } from 'src/app/objetos/Usuario';

@Component({
  selector: 'app-administrator-registration-form',
  templateUrl: './administrator-registration-form.component.html',
  styleUrls: ['./administrator-registration-form.component.css']
})
export class AdministratorRegistrationFormComponent implements OnInit {
  registrationForm!: FormGroup;
  _router: Router;
  _admin: Admin;
  constructor(private formBuilder:FormBuilder,private usuarioService:UsuarioService,  private accessProfile: AccessUserProfileService,private router:Router) {
    this._router = router;
    this._admin = new Admin("","","");
   }
  
  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      nombre: [null, Validators.required],
      email: [null, Validators.required],
      password: [null, Validators.required]
    });
  }

  crearAdmin(){
    console.log("mmmmmmm");
    if (this.registrationForm.valid) {
      console.log("algo");
      console.log(this.registrationForm.value);
      console.log("Enviar los datos al servidor");
      this.usuarioService.crearAdministrador(this.registrationForm.value)
      .subscribe((created: Usuario) => {
        this.registrationForm.reset({
          "nombre": null,
          "email": null,
          "password": null
        });
        console.log("created");
        console.log(created);
        if(created!=null){
          this.accessProfile.usuario=created;
          this._router.navigate(['new/member/profile']);
        }else{
          
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
          footer:error
        })
      });
    }else{
      console.log("no estuvo bien")
    }
  }
  
}
