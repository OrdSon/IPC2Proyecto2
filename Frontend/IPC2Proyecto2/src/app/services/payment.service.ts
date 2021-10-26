import { Usuario } from './../objetos/Usuario';
import { InfoPago } from './../objetos/InfoPago';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  infoPago!:InfoPago;
    
  readonly API_URL = "http://localhost:8080/backendRevistas/";
  constructor(private httpClient :HttpClient) { }


  public crearInfoPago(info:InfoPago, usuario:Usuario):Observable<InfoPago>{
    info.usuarioCodigo = usuario.codigo;
    return this.httpClient.post<InfoPago>(this.API_URL+"CrearInfoPago", info);
  }

  public verificarInfoPago(usuario:Usuario):Observable<InfoPago>{
    return this.httpClient.post<InfoPago>(this.API_URL+"VerificarInfoPago", usuario);
  }

  public editarInfoPago(info:InfoPago, usuario:Usuario):Observable<InfoPago>{
    info.usuarioCodigo = usuario.codigo;
    return this.httpClient.post<InfoPago>(this.API_URL+"CrearInfoPago", info);
  }

}
