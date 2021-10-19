import { Revista } from './../objetos/Revista';
import { Usuario } from './../objetos/Usuario';
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

  public buscarPorNombre(): Observable<BuscarRevista> {
    return this.httpClient.post<BuscarRevista>(this.API_URL + "BuscarRevistas", new BuscarRevista("prueba de sonido")) ;
  }

  public buscarPorAutor(usuario:Usuario):Observable<Revista[]>{
    console.log(usuario.codigo);
    return this.httpClient.post<Revista[]>(this.API_URL + "BuscarRevistasEditor",usuario);
 
  }
}
