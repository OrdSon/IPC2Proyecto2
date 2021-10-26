import { Review } from './../../objetos/Review';
import { AccessUserProfileService } from './../../services/access-user-profile.service';
import { ReviewService } from './../../services/review.service';
import { CurrentPreviewService } from './../../services/current-preview.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-magazine-reader',
  templateUrl: './magazine-reader.component.html',
  styleUrls: ['./magazine-reader.component.css']
})
export class MagazineReaderComponent implements OnInit {
  registrationForm!: FormGroup;
  bandera:boolean = false;
  reviewRealizada:boolean = false;
  review!:Review;
  mensaje:Review = new Review();
  opinion:number = 0;
  constructor(public currentPreview:CurrentPreviewService,  private formBuilder: FormBuilder, 
    private router: Router, public reviewService:ReviewService, private accesProfile:AccessUserProfileService) { }

  ngOnInit(): void {
    this.verificarReview();
  }
  opinar(){
    if(this.opinion == 0){
      this.opinion = 1;
    }else{
      this.opinion = 0;
    }
  }
  habilitarReview(){
    this.verificarReview();
    this.bandera = !this.bandera;
    this.registrationForm = this.formBuilder.group({
      comentario: [null, Validators.required],
      fecha:[null, Validators.required]
    });
  }
verificarReview(){
  this.mensaje.usuarioCodigo = this.accesProfile.usuario.codigo;
  this.mensaje.numeroCodigo = this.currentPreview.preview.codigo;
  this.reviewService.verificarReview(this.mensaje).
  subscribe((created:Review)=>{
    if(created != null){
      this.reviewRealizada = true;
      this.review = created;
      console.log("la review existe");
    }else{
      this.reviewRealizada = false;
      console.log("la review es nula");
    }
  })
}

  crearReview() {
    if (this.registrationForm.valid) {
      this.reviewService.crearReview(this.registrationForm.value, this.accesProfile.usuario, this.currentPreview.preview, this.opinion)
        .subscribe((created: Review) => {
          this.registrationForm.reset({
            "comentario": null,
            "fecha":null
          });
          console.log("created");
          console.log(created);
          if (created != null) {
            Swal.fire({
              icon: 'success',
              title: 'Review realizada'
            });
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
  }

}
