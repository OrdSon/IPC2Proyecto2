import { HttpClient } from '@angular/common/http';
import { Setting } from './../objetos/Setting';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SettingsAdministrationService {
  readonly API_URL = "http://localhost:8080/backendRevistas/";
  setting!: Setting;

  constructor(private httpClient:HttpClient) { }

  public enviarSettings(setting:Setting):Observable<Setting>{
    return this.httpClient.post<Setting>(this.API_URL+"EnviarSettings", setting);
  }
  public verificarSettings(): Observable<Setting>{
    return this.httpClient.get<Setting>(this.API_URL+"EnviarSettings");
  }
}
