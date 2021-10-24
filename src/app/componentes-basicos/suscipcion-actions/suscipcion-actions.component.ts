import { SuscriptionAdministrationService } from './../../services/suscription-administration.service';
import { Suscripcion } from 'src/app/objetos/Suscripcion';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-suscipcion-actions',
  templateUrl: './suscipcion-actions.component.html',
  styleUrls: ['./suscipcion-actions.component.css']
})
export class SuscipcionActionsComponent implements OnInit {
  @Input() suscripcion!: Suscripcion;
  @Output("obtenerLista") obtenerLista: EventEmitter<any> = new EventEmitter();

  constructor(private suscripcionService:SuscriptionAdministrationService) { }
  
  ngOnInit(): void {
  }

  cancelar(){
    Swal.fire({
      title: '¿Cancelar suscripcion a '+this.suscripcion.Revista+'?',
      text: "Puede volver a suscribirse mas tarde",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'cancelar'
    }).then((result) => {
      if (result.isConfirmed && this.suscripcion != null) {

        this.suscripcionService.cancelarSuscripcion(this.suscripcion).subscribe((created:Suscripcion)=>{
          if(created != null && created.estado == "false"){
            Swal.fire({
              icon:'success',
              title:'Suscripcion cancelada'
            });
          }
        })
    
        this.obtenerLista.emit();
      }
    });
    this.suscripcionService.cancelarSuscripcion(this.suscripcion).subscribe((created:Suscripcion)=>{
      if(created != null && created.estado == "false"){
        Swal.fire({
          icon:'success',
          title:'Suscripcion cancelada'
        });
      }
    })

    this.obtenerLista.emit();
  }

}
