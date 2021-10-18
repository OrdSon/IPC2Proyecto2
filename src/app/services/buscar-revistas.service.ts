import { BuscarRevista } from './../objetos/BuscarRevista';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class BuscarRevistasService {

  readonly API_URL = "http://localhost:8080/backendRevistas/";

  constructor(private httpClient: HttpClient) { }

  public crearUsuario(): Observable<BuscarRevista> {
    return this.httpClient.post<BuscarRevista>(this.API_URL + "BuscarRevistas", new BuscarRevista("prueba de sonido")) ;
  }
}
