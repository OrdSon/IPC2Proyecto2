import { AccessUserProfileService } from './../../services/access-user-profile.service';
import { ProfileService } from './../../services/profile.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Profile } from './../../objetos/Profile';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-profile-creation-form',
  templateUrl: './profile-creation-form.component.html',
  styleUrls: ['./profile-creation-form.component.css']
})
export class ProfileCreationFormComponent implements OnInit {

  

  _profile: Profile;
  _router: Router;
  file!: File | null;
  registrationForm!: FormGroup;
  constructor(private formBuilder: FormBuilder, private profileService: ProfileService, private accessProfile: AccessUserProfileService,private router: Router) {
    this._profile = new Profile(0, "", "");
    this._router = router;
  }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      descripcion: [null, Validators.required],
      hobbies: [null, Validators.required]
    });
  }




  public crearPerfil() {
    console.log('por lo menos, aqui si paso')
    if (this.registrationForm.valid) {
      console.log("algo mas");
      console.log(this.registrationForm.value);
      console.log("Enviar las cosas al backend");
      this.profileService.createProfile(this.registrationForm.value)
        .subscribe((created: Profile) => {
          this.registrationForm.reset({
            "descripcion": null,
            "hobbies": null
          });
          console.log("created");
          console.log(created);
          if (created != null) {
            this.accessProfile.profile=created;
            this.accessProfile.validar();
            console.log('si paso por aqui');
            this._router.navigate(['new/member/profile']);
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
            footer:error
          })
        });
    } else {
      Swal.fire({
        icon: 'info',
        title: 'Algo aún no cuadra ',
        text: 'Debes rellenar todos los campos para continuar ;)',
      })
    }
  }

}
