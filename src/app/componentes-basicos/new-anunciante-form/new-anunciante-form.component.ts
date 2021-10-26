import { AnuncioServiceService } from './../../services/anuncio-service.service';
import { RevistaActivaService } from './../../services/revista-activa.service';
import { AccessEditorProfileService } from 'src/app/services/access-editor-profile.service';
import { Router} from '@angular/router';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { NewMagazineService } from 'src/app/services/new-magazine.service';
import { Revista } from 'src/app/objetos/Revista';
import { Anunciante } from 'src/app/objetos/Anunciante';

@Component({
  selector: 'app-new-anunciante-form',
  templateUrl: './new-anunciante-form.component.html',
  styleUrls: ['./new-anunciante-form.component.css']
})
export class NewAnuncianteFormComponent implements OnInit {
  @Output() cambio = new EventEmitter<number>();
  _router: Router;
  messageFlag: boolean = false;
  registrationForm!: FormGroup;
  constructor(router:Router, private formBuilder:FormBuilder, public anuncioService:AnuncioServiceService) {
    this._router = router;
   }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      nombre: [null, Validators.required]
    });
  }

  crearAnunciante(){
    if (this.registrationForm.valid) {
      console.log("algo");
      console.log(this.registrationForm.value);
      console.log("Enviar los datos al servidor");
      this.anuncioService.crearAnunciante(this.registrationForm.value)
      .subscribe((created: Anunciante) => {
        this.registrationForm.reset({
          "nombre": null
        });
        console.log("created");
        console.log(created);
        if(created!=null){
          this._router.navigate(["profile/admin/view"]);
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
      console.log("no estuvo bien");
    }
  }

}
