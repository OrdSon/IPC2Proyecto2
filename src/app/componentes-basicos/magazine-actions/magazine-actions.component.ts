import { RevistaActivaService } from './../../services/revista-activa.service';
import { Router } from '@angular/router';
import { AccessEditorProfileService } from 'src/app/services/access-editor-profile.service';
import { NewMagazineService } from './../../services/new-magazine.service';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Revista } from 'src/app/objetos/Revista';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-magazine-actions',
  templateUrl: './magazine-actions.component.html',
  styleUrls: ['./magazine-actions.component.css']
})
export class MagazineActionsComponent implements OnInit {

  constructor(private formBuilder:FormBuilder,private magazineService:NewMagazineService, 
    public accessEditorProfileService:AccessEditorProfileService,private Router: Router, private revistaActivaService:RevistaActivaService) { }
  @Input() revista!: Revista;
  @Output("obtenerLista") obtenerLista: EventEmitter<any> = new EventEmitter();
  editionReady:boolean = false;
  registrationForm!: FormGroup;

  ngOnInit(): void {
  }
  mostrarDetalles(){
    this.revistaActivaService.verRevistas = true;
  }
  habilitarEdicion(){
    this.registrationForm = this.formBuilder.group({
      nombre: [null, Validators.required],
      precio: [null, Validators.required],
      descripcion: [null, Validators.required]
    });
    this.editionReady = !this.editionReady;
  }
  nuevoNumero(){
    this.setRevistaActiva();
    this.Router.navigate(["new/title"]);
  }
  editarRevista(){
    if(this.revista != null && this.registrationForm.valid){

      this.magazineService.editarRevista(this.registrationForm.value,this.revista).subscribe((created:Revista)=>{
        this.registrationForm.reset({
          "nombreRevista": null,
          "precioRevista": null,
          "descripcion":null
        });
        this.obtenerLista.emit();
        console.log(created);
      });
    }else{
      Swal.fire({
        icon:'warning',
        title:'Error',
        text:'Hubo un problema al obtener los datos de esta revista'
      });
    }
    
    this.editionReady = false;
  }
  eliminarRevista(){
    Swal.fire({
      title: '¿Eliminar la revista: '+this.revista.nombre+'?',
      text: "Este cambio sera irreversible",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Eliminar'
    }).then((result) => {
      if (result.isConfirmed && this.revista != null) {
        this.magazineService.eliminarRevista(this.revista).subscribe((created:Revista)=>{
          Swal.fire({
            icon:'success',
            title:'Revista eliminada'
          });
          this.obtenerLista.emit();
        });
      }
    });
    
    this.editionReady = false;
  }

  setRevistaActiva(){
    this.revistaActivaService.revistaActiva=this.revista;
  }

}
