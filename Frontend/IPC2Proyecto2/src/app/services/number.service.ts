import { HttpClient } from '@angular/common/http';
import { Numero } from './../objetos/Numero';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NumberService {

  numeroActivo!: Numero;

  constructor(private httpClient:HttpClient) { }
  readonly API_URL= "http://localhost:8080/backendRevistas/";

  public editarNumero(numero:Numero): Observable<Numero> {
    return this.httpClient.post<Numero>(this.API_URL + "EditarNumero", numero) ;
  }

  public eliminarNumero(numero: Numero): Observable<Numero> {
    return this.httpClient.post<Numero>(this.API_URL + "EliminarNumero", numero) ;
  }
}
