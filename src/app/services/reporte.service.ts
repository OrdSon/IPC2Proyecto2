import { DomSanitizer } from '@angular/platform-browser';
import { Usuario } from './../objetos/Usuario';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SolicitudReporteComentarios } from '../objetos/SolicitudReporteComentarios';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class ReporteService {
  readonly API_URL = "http://localhost:8080/backendRevistas/";
  archivo!:any;
  constructor(private httpClient :HttpClient, private sanitizer:DomSanitizer) { }
  public  crearReporteComentarios(solicitud:SolicitudReporteComentarios, usuario:Usuario):Blob{
    solicitud.autor = usuario.codigo;
    this.httpClient.post(this.API_URL+"ReporteComentarios", solicitud, {responseType:'blob'}).subscribe((created:Blob)=>{
      if(created == null){
        Swal.fire("no es digno");
        return;
      }else{
        Swal.fire("tiene talento");
        return created;
      }
    });
    return new Blob;
  }
  public downloadPDF(solicitud:SolicitudReporteComentarios, usuario:Usuario): any {
    var mediaType = 'application/pdf';
    solicitud.autor = usuario.codigo;
    this.httpClient.post(this.API_URL+"ReporteComentarios", solicitud,{ responseType: 'blob' }).subscribe(
        (response:any) => {
            let blob = new Blob([response], { type: mediaType });
             this.archivo = blob;
        },
    );
}
  fileUploadInAngular(archivo:Blob) {
      this.getBase64(archivo).then((image:any)=>{
      let imag = image.base;
      archivo = imag;
      console.log(archivo);
    })
  }

getArchivo(){
  return this.archivo;
}

  getBase64 = async ($event: any) => new Promise((resolve, reject) => {
    try {
      const unsafeImg = window.URL.createObjectURL($event);
      const image = this.sanitizer.bypassSecurityTrustUrl(unsafeImg);
      const reader = new FileReader();
      reader.readAsDataURL($event);
      reader.onload = () => {
        resolve({
          base: reader.result
        });
      };
      reader.onerror = _error => {
        resolve({
          base: null
        });
      };
      return;
    } catch (e) {
      return null;
    }
  })
}
