import { Preview } from './../objetos/Preview';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PreviewService {

  readonly API_URL = "http://localhost:8080/backendRevistas/";

  constructor(private httpClient :HttpClient) { }

  public getPreviews(): Observable<Preview[]> {
    return this.httpClient.get<Preview[]>(this.API_URL + "ListaAleatoria");
  }
}
