import { AccessEditorProfileService } from './../../services/access-editor-profile.service';
import { ReporteService } from './../../services/reporte.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-reporte-comentarios',
  templateUrl: './reporte-comentarios.component.html',
  styleUrls: ['./reporte-comentarios.component.css']
})
export class ReporteComentariosComponent implements OnInit {
  image!:any;
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
      this.reporteService.reporteDeComentarios(this.registrationForm.value, this.editorProfile.usuario);
      this.image = this.reporteService.getArchivo();
    } else {
      console.log("no estuvo bien"); 
    }
  }
}