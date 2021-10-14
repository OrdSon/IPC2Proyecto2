import { Numero } from './../objetos/Numero';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UploadPdfService {

  readonly API_URL =
    "http://localhost:8080/backendRevistas/";
    

 // readonly DOWNLOAD_FILE_URL =
   // "http://localhost:8081/calc-app-api/files/download-servlet";

  constructor(private httpClient: HttpClient) { }
  public crearNumero(numero:Numero){
    return this.httpClient.post<Numero>(this.API_URL + "NuevoNumero", numero) ;
  }
  public subirArchivo(archivo: File): Observable<void> {
    const formData: FormData = new FormData();

    formData.append("datafile", archivo, archivo.name);

    return this.httpClient.post<void>(this.API_URL+"UploadPdf", formData);
  }
  /*
      public downloadFile(): string {
          return this.DOWNLOAD_FILE_URL;
      }
  
      public downloadImage(): string {
          return this.DOWNLOAD_FILE_URL + "?image=1";
      }*/
}
