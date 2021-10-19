import { CategoryAdministrationService } from './../../services/category-administration.service';
import { Categoria } from './../../objetos/Categoria';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-category-element',
  templateUrl: './category-element.component.html',
  styleUrls: ['./category-element.component.css']
})
export class CategoryElementComponent implements OnInit {
  editionReady:boolean = false;
  
  constructor(private formBuilder:FormBuilder,private categoryService:CategoryAdministrationService) { }
  @Input() categoria!: Categoria;
  @Output("obtenerLista") obtenerLista: EventEmitter<any> = new EventEmitter();
  registrationForm!: FormGroup;
  ngOnInit(): void {
    
  }

  habilitarEdicion(){
    this.registrationForm = this.formBuilder.group({
      nombre: [null, Validators.required]
    });
    this.editionReady = !this.editionReady;
  }

  editarCategoria(){
    if(this.categoria != null && this.registrationForm.valid){

      this.categoryService.editarCategoria(this.registrationForm.value,this.categoria).subscribe((created:Categoria)=>{
        this.registrationForm.reset({
          "nombre": null
        });
        this.obtenerLista.emit();
        console.log(created);
      });
    }else{
      Swal.fire({
        icon:'warning',
        title:'Error',
        text:'Hubo un problema al obtener los datos de esta categoría'
      });
    }
    
    this.editionReady = false;
  }

  eliminarCategoria(){
    Swal.fire({
      title: '¿Eliminar categoria '+this.categoria.nombre+'?',
      text: "Este cambio sera irreversible",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Eliminar'
    }).then((result) => {
      if (result.isConfirmed && this.categoria != null) {
        this.categoryService.eliminarCategoria(this.categoria).subscribe((created:Categoria)=>{
          Swal.fire({
            icon:'success',
            title:'Categoria eliminada'
          });
          this.obtenerLista.emit();
        });
      }
    });
    
    this.editionReady = false;
  }
}
