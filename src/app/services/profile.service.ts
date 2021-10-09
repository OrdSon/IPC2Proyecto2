import { Usuario } from 'src/app/objetos/Usuario';
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

  public createProfile(profile: Profile): Observable<Profile> {
    return this.httpClient.post<Profile>(this.API_URL + "ProfileServlet", profile) ;
  }

  public obtainProfile(usuario: Usuario): Observable<Profile> {
    return this.httpClient.post<Profile>(this.API_URL + "LoginProfileServlet", usuario) ;
  }
}
