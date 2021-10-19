import { RevistaActivaService } from './../../services/revista-activa.service';
import { AccessEditorProfileService } from 'src/app/services/access-editor-profile.service';
import { Router} from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { NewMagazineService } from 'src/app/services/new-magazine.service';
import { Revista } from 'src/app/objetos/Revista';


@Component({
  selector: 'app-new-magazine-form',
  templateUrl: './new-magazine-form.component.html',
  styleUrls: ['./new-magazine-form.component.css']
})
export class NewMagazineFormComponent implements OnInit {


  _router: Router;
  messageFlag: boolean = false;
  registrationForm!: FormGroup;

  constructor(router:Router, private formBuilder:FormBuilder, public newMagazineService: NewMagazineService,
    public accessEditorProfileService: AccessEditorProfileService) {
    this._router = router;
   }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      nombre: [null, Validators.required],
      precio: [null, Validators.required],
      fecha: [null,Validators.required],
      descripcion: [null, Validators.required],
      autor:[this.accessEditorProfileService.usuario.codigo, Validators.required]
    });
  }

  
  crearRevista(){
    if (this.registrationForm.valid) {
      console.log("algo");
      console.log(this.registrationForm.value);
      console.log("Enviar los datos al servidor");
      this.newMagazineService.crearRevista(this.registrationForm.value)
      .subscribe((created: Revista) => {
        this.registrationForm.reset({
          "nombreRevista": null,
          "precioRevista": null,
          "fecha":null,
          "descripcion":null
          
        });
        console.log("created");
        console.log(created);
        if(created!=null){
          this._router.navigate(["profile/editor/view"]);
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
