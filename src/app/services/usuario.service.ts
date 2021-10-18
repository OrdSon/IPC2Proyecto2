import { Admin } from './../objetos/Admin';
import { Usuario } from '../objetos/Usuario';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  readonly API_URL = "http://localhost:8080/backendRevistas/";

  constructor(private httpClient: HttpClient) { }

  public crearUsuario(usuario: Usuario): Observable<Usuario> {
    return this.httpClient.post<Usuario>(this.API_URL + "UsuarioServlet", usuario) ;
  }

  public crearAdministrador(admin:Admin ): Observable<Usuario> {
    return this.httpClient.post<Usuario>(this.API_URL + "AdminServlet", admin) ;
  }
}

