import { Numero } from './../objetos/Numero';
import { Revista } from './../objetos/Revista';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ViewMagazineNumbersService {
  readonly API_URL = "http://localhost:8080/backendRevistas/";

  constructor(private httpClient:HttpClient) { }

  public buscarPorAutor(revista:Revista):Observable<Numero[]>{

    return this.httpClient.post<Numero[]>(this.API_URL + "BuscarNumerosPorRevista",revista);
 
  }
}
