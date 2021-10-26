import { Component, OnInit } from '@angular/core';
import { ReporteService } from './../../services/reporte.service';
import { FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-reporte-ganancias-totales',
  templateUrl: './reporte-ganancias-totales.component.html',
  styleUrls: ['./reporte-ganancias-totales.component.css']
})
export class ReporteGananciasTotalesComponent implements OnInit {
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
      this.reporteService.reporteGananciasTotales(this.registrationForm.value);
      this.archivo = this.reporteService.getArchivo();
    } else {
      console.log("no estuvo bien"); 
    }
  }
}
