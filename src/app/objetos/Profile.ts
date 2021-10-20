import { THIS_EXPR } from "@angular/compiler/src/output/output_ast";

export class Profile {
    _codigo: number;
    _descripcion: String;
    _hobbies: String;
    _img!:String;
    _usuarioCodigo!:number;



    constructor(codigo: number, descripcion: String, hobbies: String) {
        this._codigo = codigo;
        this._descripcion = descripcion;
        this._hobbies = hobbies;
    }

    get codigo() {
        return this._codigo;
    }

    set codigo(codigo: number) {
        this._codigo = codigo;
    }

    get descripcion(){
        return this._descripcion;
    }

    set descripcion(descripcion:String){
        this._descripcion = descripcion;
    }

    get hobbies(){
        return this._hobbies;
    }

    set hobbies(hobbies:String){
        this._hobbies = hobbies;
    }

    get img(){
        return this._img;
    }

    set img(img:String){
        this._img = img;
    }

    get usuarioCodigo(){
        return this._usuarioCodigo;
    }

    set usuarioCodigo(usuarioCodigo: number){
        this._usuarioCodigo = usuarioCodigo;
    }
}