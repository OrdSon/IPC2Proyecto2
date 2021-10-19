import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from '../objetos/Categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoryAdministrationService {
  
  readonly API_URL = "http://localhost:8080/backendRevistas/";
  constructor(private httpClient :HttpClient) { }

  public getAllCategories(): Observable<Categoria[]> {
    return this.httpClient.get<Categoria[]>(this.API_URL + "MostrarCategorias");
  }

  public crearCategoria(categoria:Categoria):Observable<Categoria>{
    return this.httpClient.post<Categoria>(this.API_URL+"CrearCategoria", categoria);
  }

  public editarCategoria(categoria:Categoria, original:Categoria):Observable<Categoria>{
    categoria.codigo = original.codigo;
    return this.httpClient.post<Categoria>(this.API_URL+"EditarCategoria", categoria);
  }

  public eliminarCategoria(categoria:Categoria):Observable<Categoria>{
    return this.httpClient.post<Categoria>(this.API_URL+"EliminarCategoria", categoria);
  }
}
