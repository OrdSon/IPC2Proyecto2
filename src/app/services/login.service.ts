import { LoginCheck } from './../objetos/LoginCheck';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../objetos/Usuario';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  readonly API_URL = "http://localhost:8080/backendRevistas/";

  constructor(private httpClient: HttpClient) { }

  public crearUsuario(loginCheck: LoginCheck): Observable<Usuario> {
    return this.httpClient.post<Usuario>(this.API_URL + "LoginServlet", loginCheck) ;
  }
}
