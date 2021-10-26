import { Setting } from './../objetos/Setting';
import { Anunciante } from 'src/app/objetos/Anunciante';
import { Anuncio } from './../objetos/Anuncio';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnuncioServiceService {
  readonly API_URL = "http://localhost:8080/backendRevistas/";

  anuncianteActivo!: Anunciante;

  constructor(private httpClient: HttpClient) { }

  public crearAnunciante(anunciante: Anunciante): Observable<Anunciante> {
    return this.httpClient.post<Anunciante>(this.API_URL + "CrearAnunciante", anunciante);
  }
  public crearAnuncio(anuncio: Anuncio, img: String, anunciante: Anunciante): Observable<Anuncio> {

    anuncio.archivo = img;
    anuncio.anuncianteCodigo = anunciante.codigo;
    return this.httpClient.post<Anuncio>(this.API_URL + "CrearAnuncio", anuncio);
  }

  public obtenerPrecio(): Observable<Setting> {
    return this.httpClient.get<Setting>(this.API_URL + "CrearAnuncio");
  }
  public obtenerAnunciantes(): Observable<Anunciante[]> {
    return this.httpClient.get<Anunciante[]>(this.API_URL + "CrearAnunciante");
  }
  
  public obtenerAnuncio(): Observable<Anuncio> {
    return this.httpClient.get<Anuncio>(this.API_URL + "MostrarAnuncio");
  }
}
