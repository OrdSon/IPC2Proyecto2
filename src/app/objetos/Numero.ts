import { Revista } from './Revista';
export class Numero {
    _codigo!:number;
    _nombre:String;
    _descripcion!:String;
    _fechaPublicacion!:String;
    _numero!:number;
    _revistaCodigo!:number;

    constructor(nombre: String, descripcion:String, fechaPublicacion:String) {
        this._nombre = nombre;
        this._descripcion = descripcion;
        this._fechaPublicacion = fechaPublicacion;
    }


    get numero(){
        return this._numero;
    }

    set nombre(nombre:String){
        this._nombre = nombre;
    }

    get nombre(){
        return this._nombre;
    }

    get descripcion(){
        return this._descripcion;
    }

    set descripcion(descripcion:String){
        this._descripcion = descripcion;
    }

    get fechaPublicacion(){
        return this._fechaPublicacion;
    }

    set fechaPublicacion(fechaPublicacion:String){
        this._fechaPublicacion = fechaPublicacion;
    }

    get revistaCodigo(){
        return this._revistaCodigo;
    }

    set revistaCodigo(revistaCodigo:number){
        this._revistaCodigo = revistaCodigo;
    }

    get codigo(){
        return this._codigo;
    }

    set codigo(codigo:number){
        this._codigo = codigo;
    }
}