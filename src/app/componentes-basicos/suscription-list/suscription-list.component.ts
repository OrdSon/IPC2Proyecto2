import { AccessUserProfileService } from './../../services/access-user-profile.service';
import { SuscriptionAdministrationService } from './../../services/suscription-administration.service';
import { Component, OnInit } from '@angular/core';
import { Suscripcion } from 'src/app/objetos/Suscripcion';

@Component({
  selector: 'app-suscription-list',
  templateUrl: './suscription-list.component.html',
  styleUrls: ['./suscription-list.component.css']
})
export class SuscriptionListComponent implements OnInit {

  listaSuscripciones:Suscripcion[]=[];

  constructor(private suscriptionService:SuscriptionAdministrationService, private accessProfile:AccessUserProfileService) {
    this.obtenerLista();
   }

  ngOnInit(): void {
  }

  obtenerLista() {
    this.suscriptionService.getSuscripciones(this.accessProfile.usuario).subscribe((lista: Suscripcion[]) => {
      this.listaSuscripciones= lista;
      console.log(this.listaSuscripciones);
    })
  }
}
