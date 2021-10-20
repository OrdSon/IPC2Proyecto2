import { AccessUserProfileService } from './../../services/access-user-profile.service';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { Usuario } from './../../objetos/Usuario';
import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {

  _usuario: Usuario;
  _router: Router;
  registrationForm!: FormGroup;

  constructor(private formBuilder:FormBuilder,private usuarioService:UsuarioService,  private accessProfile: AccessUserProfileService,private router:Router) { 
    this._usuario = new Usuario(0,"","","",1,"");
    this._router = router;
  }

  ngOnInit(): void {
    
    this.registrationForm = this.formBuilder.group({
      nombre: [null, Validators.required],
      nombre_usuario: [null, Validators.required],
      email: [null, Validators.required],
      password: [null, Validators.required],
      tipo:["1",Validators.required]
    });
  }

  public crearUsuario() {

    if (this.registrationForm.valid) {
      console.log("algo");
      console.log(this.registrationForm.value);
      console.log("Enviar los datos al servidor");
      this.usuarioService.crearUsuario(this.registrationForm.value)
      .subscribe((created: Usuario) => {
        this.registrationForm.reset({
          "nombre": null,
          "email": null,
          "nombre_usuario": null,
          "password": null
        });
        console.log("created user");
        console.log(created);
        if(created!=null){
          this.accessProfile.usuario=created;
          this.accessProfile.validar();
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


  mensajeDeExito() {

    Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: '¡Registro exitoso!',
      showConfirmButton: false,
      timer: 1500
    })
  }

}
