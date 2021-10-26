import { Suscripcion } from 'src/app/objetos/Suscripcion';
import { Usuario } from './../objetos/Usuario';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SuscriptionAdministrationService {
  wantToSubscribe:boolean=false;
  chekingPayInfo:boolean=false;
  readonly API_URL = "http://localhost:8080/backendRevistas/";

  constructor(private httpClient:HttpClient) { }

  public verificarSuscripcion(suscripcion:Suscripcion):Observable<Suscripcion>{
    return this.httpClient.post<Suscripcion>(this.API_URL+"VerificarSuscripcion", suscripcion);
  }

  public crearSuscripcion(suscripcion:Suscripcion, usuarioCodigo: number, revistaCodigo: number):Observable<Suscripcion>{
    suscripcion.usuarioCodigo = usuarioCodigo;
    suscripcion.revistaCodigo = revistaCodigo;
    return this.httpClient.post<Suscripcion>(this.API_URL+"Suscribirse", suscripcion);
  }
  public getSuscripciones(usuario:Usuario): Observable<Suscripcion[]> {
    return this.httpClient.post<Suscripcion[]>(this.API_URL + "ListaSuscripciones",usuario);
  } 

  public cancelarSuscripcion(suscripcion:Suscripcion):Observable<Suscripcion>{
    return this.httpClient.post<Suscripcion>(this.API_URL+"CancelarSuscripcion", suscripcion);
  }
}
