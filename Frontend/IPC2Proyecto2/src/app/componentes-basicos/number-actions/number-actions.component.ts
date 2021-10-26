import { Router } from '@angular/router';
import { NumberService } from './../../services/number.service';
import { Numero } from './../../objetos/Numero';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-number-actions',
  templateUrl: './number-actions.component.html',
  styleUrls: ['./number-actions.component.css']
})
export class NumberActionsComponent implements OnInit {
  @Input() numero!:Numero;
  editionReady:boolean = false;
  registrationForm!: FormGroup;

  constructor(private formBuilder:FormBuilder, private numberService:NumberService, private router:Router) { }
  ngOnInit(): void {
  }

  habilitarEdicion(){
    this.registrationForm = this.formBuilder.group({
      nombre: [null, Validators.required],
      precio: [null, Validators.required],
      descripcion: [null, Validators.required]
    });
    this.editionReady = !this.editionReady;
  }

  mostrarDetalles(){
    if(this.numero != null){
      this.numberService.numeroActivo = this.numero;
      this.router.navigate(['profile/editor/view/numero']);
    }
  }
  eliminarNumero(){
    Swal.fire({
      title: '¿Eliminar la revista: '+this.numero.nombre+'?',
      text: "Este cambio sera irreversible",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Eliminar',
      cancelButtonText:'Cancelar'
    }).then((result) => {
      if (result.isConfirmed && this.numero != null) {
        this.numberService.eliminarNumero(this.numero).subscribe((created:Numero)=>{
          Swal.fire({
            icon:'success',
            title:'Revista eliminada'
          });
        });
      }
    });
    
    this.editionReady = false;
  }

}
