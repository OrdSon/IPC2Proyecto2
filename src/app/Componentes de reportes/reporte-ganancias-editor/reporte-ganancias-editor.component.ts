import { Component, OnInit } from '@angular/core';
import { AccessEditorProfileService } from './../../services/access-editor-profile.service';
import { ReporteService } from './../../services/reporte.service';
import { FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-reporte-ganancias-editor',
  templateUrl: './reporte-ganancias-editor.component.html',
  styleUrls: ['./reporte-ganancias-editor.component.css']
})
export class ReporteGananciasEditorComponent implements OnInit {

  archivo!:any;
  constructor(public reporteService:ReporteService, private formBuilder:FormBuilder,private editorProfile:AccessEditorProfileService) { }
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
      this.reporteService.reporteDeGananciasEditor(this.registrationForm.value, this.editorProfile.usuario);
      this.archivo = this.reporteService.getArchivo();
    } else {
      console.log("no estuvo bien"); 
    }
  }
}
