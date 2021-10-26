import { Component, OnInit } from '@angular/core';
import { ReporteService } from './../../services/reporte.service';
import { FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-reporte-anuncios',
  templateUrl: './reporte-anuncios.component.html',
  styleUrls: ['./reporte-anuncios.component.css']
})
export class ReporteAnunciosComponent implements OnInit {

  archivo!:any;

  constructor(public reporteService:ReporteService, private formBuilder:FormBuilder) { }
  registrationForm!: FormGroup;
  eleccionReporte:number= 0;

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      fechaInicial: [null],
      fechaFinal: [null],
      revista: [null]
    });
  }
  crearReporte() {
    if (this.registrationForm.valid) {
      console.log("algo");
      console.log(this.registrationForm.value);
      console.log("Enviar los datos al servidor");
      this.reporteService.reporteAnuncios(this.registrationForm.value);
      this.archivo = this.reporteService.getArchivo();
    } else {
      console.log("no estuvo bien"); 
    }
  }
}
