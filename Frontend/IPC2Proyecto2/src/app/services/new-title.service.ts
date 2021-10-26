import { Revista } from './../objetos/Revista';
import { HttpClient } from '@angular/common/http';
import { Numero } from './../objetos/Numero';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewTitleService {

  constructor(private httpClient: HttpClient) { }
  readonly API_URL = "http://localhost:8080/backendRevistas/";

  public crearNumero(numero: Numero, image:any ,revista:Revista): Observable<Numero> {
    numero.revistaCodigo = revista.codigo;
    numero.archivo = image;
    return this.httpClient.post<Numero>(this.API_URL + "NuevoNumero", numero);
  }
  public editarNumero(numero: Numero, image:any, original:Numero): Observable<Numero> {
    numero.archivo = image;
    numero.codigo = original.codigo;
    return this.httpClient.post<Numero>(this.API_URL + "EditarNumero", numero);
  }

  public eliminarNumero(numero:Numero):Observable<Numero>{
    return this.httpClient.post<Numero>(this.API_URL+"EliminarNumero", numero);
  }
  
}
