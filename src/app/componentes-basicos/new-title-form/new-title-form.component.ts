import { RevistaActivaService } from './../../services/revista-activa.service';
import { UploadPdfService } from './../../services/upload-pdf.service';
import { Router} from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { NewMagazineService } from 'src/app/services/new-magazine.service';
import { Revista } from 'src/app/objetos/Revista';

@Component({
  selector: 'app-new-title-form',
  templateUrl: './new-title-form.component.html',
  styleUrls: ['./new-title-form.component.css']
})
export class NewTitleFormComponent implements OnInit {
  _router: Router;
  archivoSeleccionado!:File | null;
  registrationForm!: FormGroup;

  constructor(router:Router, private formBuilder:FormBuilder, public uploadPdfService: UploadPdfService, private revistaActivaService:RevistaActivaService) {
    this._router = router;
   }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      nombre: [null, Validators.required],
      archivo:[null, Validators.required]
    });
  }
  subirArchivo(event: Event) {
    const files = (event.target as  HTMLInputElement).files;
    if (files != null) {
      this.archivoSeleccionado = files.item(0);
      if(this.archivoSeleccionado != null){
        Swal.fire(this.archivoSeleccionado.name);
      }
    }
  }
  crearTitulo(){
    
    if(this.registrationForm.valid && this.archivoSeleccionado!=null){
      this.uploadPdfService.subirArchivo(this.archivoSeleccionado).subscribe((data) => {
        Swal.fire('archivo subido al servidor')
      }, (error:any)=>{
        Swal.fire('error al subir al servidor');
      })
    }else{
      Swal.fire('ups '+ this.archivoSeleccionado?.name);
    }
  }

}
