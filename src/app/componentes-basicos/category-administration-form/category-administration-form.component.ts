import { Router } from '@angular/router';
import { Categoria } from './../../objetos/Categoria';
import { CategoryAdministrationService } from './../../services/category-administration.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-category-administration-form',
  templateUrl: './category-administration-form.component.html',
  styleUrls: ['./category-administration-form.component.css']
})
export class CategoryAdministrationFormComponent implements OnInit {
  editionReady:boolean = false;
  registrationForm!: FormGroup;
  listaCategorias: Categoria[] = [];
  constructor(private categoryService: CategoryAdministrationService, private formBuilder: FormBuilder, private router: Router) {
    this.obtenerLista();
  }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      nombre: [null, Validators.required]
    });
    this.obtenerLista();
  }

  triggered(accion:boolean){
    this.editionReady = accion;
  }
  crearCategoria() {
    if (this.registrationForm.valid) {
      console.log("algo");
      console.log(this.registrationForm.value);
      console.log("Enviar los datos al servidor");
      this.categoryService.crearCategoria(this.registrationForm.value)
        .subscribe((created: Categoria) => {
          this.registrationForm.reset({
            "nombre": null
          });
          console.log("created");
          console.log(created);
          if (created != null) {
            Swal.fire({
              icon: 'success',
              title: 'categoría creada exitosamente'
            });
            this.obtenerLista();
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
      console.log("no estuvo bien")
    }
    this.obtenerLista();
  }


  obtenerLista() {
    this.categoryService.getAllCategories().subscribe((lista: Categoria[]) => {
      this.listaCategorias = lista;
      console.log(this.listaCategorias);
    })
  }
}
