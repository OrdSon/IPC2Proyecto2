import { DomSanitizer } from '@angular/platform-browser';
import { Usuario } from './../objetos/Usuario';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SolicitudReporte } from '../objetos/SolicitudReporte';

@Injectable({
  providedIn: 'root'
})
export class ReporteService {
  readonly API_URL = "http://localhost:8080/backendRevistas/";
  archivo!:any;
  constructor(private httpClient :HttpClient, private sanitizer:DomSanitizer) { }


  public reporteDeComentarios(solicitud:SolicitudReporte, usuario:Usuario): any {
    var mediaType = 'application/pdf';
    solicitud.autor = usuario.codigo;
    this.httpClient.post(this.API_URL+"ReporteComentarios", solicitud,{ responseType: 'blob' }).subscribe(
        (response:any) => {
            let blob = new Blob([response], { type: mediaType });
             this.archivo = blob;
        },
    );
}

public reporteDeSuscripciones(solicitud:SolicitudReporte, usuario:Usuario): any {
  var mediaType = 'application/pdf';
  solicitud.autor = usuario.codigo;
  this.httpClient.post(this.API_URL+"ReporteSuscripciones", solicitud,{ responseType: 'blob' }).subscribe(
      (response:any) => {
          let blob = new Blob([response], { type: mediaType });
           this.archivo = blob;
      },
  );
}

public reporteDeLikes(solicitud:SolicitudReporte, usuario:Usuario): any {
  var mediaType = 'application/pdf';
  solicitud.autor = usuario.codigo;
  this.httpClient.post(this.API_URL+"ReporteLikes", solicitud,{ responseType: 'blob' }).subscribe(
      (response:any) => {
          let blob = new Blob([response], { type: mediaType });
           this.archivo = blob;
      },
  );
}

public reporteDeGananciasEditor(solicitud:SolicitudReporte, usuario:Usuario): any {
  var mediaType = 'application/pdf';
  solicitud.autor = usuario.codigo;
  this.httpClient.post(this.API_URL+"ReporteGananciasEditor", solicitud,{ responseType: 'blob' }).subscribe(
      (response:any) => {
          let blob = new Blob([response], { type: mediaType });
           this.archivo = blob;
      },
  );
}

public reporteLikesAdmin(solicitud:SolicitudReporte): any {
  var mediaType = 'application/pdf';
  this.httpClient.post(this.API_URL+"ReporteLikesAdmin", solicitud,{ responseType: 'blob' }).subscribe(
      (response:any) => {
          let blob = new Blob([response], { type: mediaType });
           this.archivo = blob;
      },
  );
}

public reporteComentariosAdmin(solicitud:SolicitudReporte): any {
  var mediaType = 'application/pdf';
  this.httpClient.post(this.API_URL+"ReporteComentariosAdmin", solicitud,{ responseType: 'blob' }).subscribe(
      (response:any) => {
          let blob = new Blob([response], { type: mediaType });
           this.archivo = blob;
      },
  );
}
public reporteGananciasRevistas(solicitud:SolicitudReporte): any {
  var mediaType = 'application/pdf';
  this.httpClient.post(this.API_URL+"ReporteGananciasRevistas", solicitud,{ responseType: 'blob' }).subscribe(
      (response:any) => {
          let blob = new Blob([response], { type: mediaType });
           this.archivo = blob;
      },
  );
}
getArchivo(){
  return this.archivo;
}

}
