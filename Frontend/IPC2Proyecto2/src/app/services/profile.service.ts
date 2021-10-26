import { Usuario } from './../objetos/Usuario';
import { Profile } from './../objetos/Profile';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  readonly API_URL = "http://localhost:8080/backendRevistas/";

  constructor(private httpClient: HttpClient) { }

  public createProfile(profile: Profile, img:String, usuario:Usuario): Observable<Profile> {
    profile.img = img;
    profile.usuarioCodigo = usuario.codigo;
    console.log("El archivo seleccionado es: " +img);
    console.log("El usuario activo es:"+profile.usuarioCodigo);
    return this.httpClient.post<Profile>(this.API_URL + "ProfileServlet", profile) ;
  }

  public obtainProfile(usuario: Usuario): Observable<Profile> {
    return this.httpClient.post<Profile>(this.API_URL + "LoginProfileServlet", usuario) ;
  }
}
