import { Usuario } from './../../objetos/Usuario';
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


  _selectedFile!: File;
  _profile: Profile;
  _router: Router;
  _usuario: Usuario;
  imageError!: string;
  isImageSaved!: boolean;
  cardImageBase64!: string;

  registrationForm!: FormGroup;
  constructor(private formBuilder: FormBuilder, private profileService: ProfileService, private router: Router, private accessProfile: AccessUserProfileService) {
    this._profile = new Profile(0, "", "");
    this._router = router;
    this._usuario = accessProfile.usuario;
  }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      descripcion: [null, Validators.required],
      hobbies: [null, Validators.required]
    });
  }

  onFileChanged(fileInput: any) {
    this.imageError = "";
    if (fileInput.target.files && fileInput.target.files[0]) {
        // Size Filter Bytes
        const max_size = 20971520;
        if (fileInput.target.files[0].size > max_size) {
            this.imageError =
                'Maximum size allowed is ' + max_size / 1000 + 'Mb';

            return false;
        }
        const reader = new FileReader();
        reader.onload = (e: any) => {
            const image = new Image();
            image.src = e.target.result;
            image.onload = rs => {
                
                    const imgBase64Path = e.target.result;
                    this.cardImageBase64 = imgBase64Path;
                    this.isImageSaved = true;
                    // this.previewImagePath = imgBase64Path;
                
            };
        };

        reader.readAsDataURL(fileInput.target.files[0]);
    }
    return true;
}

removeImage() {
  this.cardImageBase64 = "";
  this.isImageSaved = false;
}


  public crearPerfil() {

    if (this.registrationForm.valid) {
      console.log("algo mas");
      console.log(this.registrationForm.value);
      console.log("Enviar las cosas al backend");
      this.profileService.createProfile(this.registrationForm.value, this.cardImageBase64, this.accessProfile.usuario)
        .subscribe((created: Profile) => {
          this.registrationForm.reset({
            "descripcion": null,
            "hobbies": null
          });

          console.log("created");
          console.log(created);
          if (created != null) {
            this.accessProfile.profile = created;
            Swal.fire({
              icon: 'success',
              title: '¡Perfil creado!'
            });
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
            footer: error
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
