import { Preview } from './../objetos/Preview';
import { Usuario } from './../objetos/Usuario';
import { HttpClient } from '@angular/common/http';
import { Review } from './../objetos/Review';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  review!:Review;
  constructor(private httpClient:HttpClient) { }
  readonly API_URL = "http://localhost:8080/backendRevistas/";

  public verificarReview(review:Review):Observable<Review>{
    console.log(review)
    return this.httpClient.post<Review>(this.API_URL+"VerificarReview", review);
  }

  public crearReview(review:Review, usuario:Usuario, preview:Preview, opinion:number):Observable<Review>{
    review.usuarioCodigo = usuario.codigo;
    review.numeroCodigo = preview.codigo;
    review.likes = opinion;
    return this.httpClient.post<Review>(this.API_URL+"DejarLike", review);
  }
}
