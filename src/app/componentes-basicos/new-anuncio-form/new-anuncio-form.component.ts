import { Setting } from './../../objetos/Setting';
import { AnuncioServiceService } from './../../services/anuncio-service.service';
import { Usuario } from './../../objetos/Usuario';
import { AccessUserProfileService } from './../../services/access-user-profile.service';
import { ProfileService } from './../../services/profile.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Profile } from './../../objetos/Profile';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Anunciante } from 'src/app/objetos/Anunciante';
import { Anuncio } from 'src/app/objetos/Anuncio';

@Component({
  selector: 'app-new-anuncio-form',
  templateUrl: './new-anuncio-form.component.html',
  styleUrls: ['./new-anuncio-form.component.css']
})
export class NewAnuncioFormComponent implements OnInit {


  _selectedFile!: File;
  _profile: Profile;
  _router: Router;
  _anunciante:Anunciante;
  imageError!: string;
  isImageSaved!: boolean;
  cardImageBase64!: string;
  registrationForm!: FormGroup;
  precioDia!:number;
  constructor(private formBuilder: FormBuilder, private router: Router, public anuncioService:AnuncioServiceService) {
    this._profile = new Profile(0, "", "");
    this._router = router;
    this._anunciante = anuncioService.anuncianteActivo;
    this.obtenerPrecio();
  }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      nombre: [null, Validators.required],
      horas: [null, Validators.required],
      fecha:[null, Validators.required]
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

public obtenerPrecio(){
  this.anuncioService.obtenerPrecio().subscribe((created:Setting)=>{
    if(created != null){
      this.precioDia = created.precioHoraAnuncio;
    }
  });
}
  public crearAnuncio() {
    if(this.cardImageBase64 == null || this.cardImageBase64 == ''){
      Swal.fire({
        icon:'warning',
        title:'Cassi...',
        text:'¡Debes subir la imagen de tu anuncio!'
      });
      return;
    }

    if (this.registrationForm.valid) {
      console.log("algo mas");
      console.log(this.registrationForm.value);
      console.log("Enviar las cosas al backend");
      this.anuncioService.crearAnuncio(this.registrationForm.value, this.cardImageBase64, this.anuncioService.anuncianteActivo)
        .subscribe((created: Anuncio) => {
          this.registrationForm.reset({
            "nombre": null,
            "horas": null,
            "fecha":null
          });
          if(created != null){
            Swal.fire({
              icon:'success',
              title:'Anuncio creado'
            })
            this.router.navigate(['profile/admin/view']);
          }
          console.log("created");
          console.log(created);

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
