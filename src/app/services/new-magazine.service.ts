import { Revista } from './../objetos/Revista';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewMagazineService {

  readonly API_URL= "http://localhost:8080/backendRevistas/";

  constructor(private httpClient: HttpClient) { }

  public crearRevista(revista: Revista): Observable<Revista> {
    return this.httpClient.post<Revista>(this.API_URL + "New", revista) ;
  }
  public editarRevista(revista: Revista, original:Revista): Observable<Revista> {
    revista.codigo = original.codigo;
    revista.fecha = original.fecha;
    revista.autor = original.autor;
    return this.httpClient.post<Revista>(this.API_URL + "EditarRevista", revista) ;
  }
  public eliminarRevista(revista: Revista): Observable<Revista> {
    return this.httpClient.post<Revista>(this.API_URL + "EliminarRevista", revista) ;
  }

}
