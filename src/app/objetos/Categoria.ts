export class Categoria{
    _codigo:number;
    _nombre:String;
    
    constructor(nombre:String, codigo:number){
        this._nombre = nombre;
        this._codigo = codigo;
    }

    get nombre(){
        return this.nombre;
    }

    set nombre(nombre:String){
        this._nombre = nombre;
    }
    get codigo(){
        return this._codigo;
    }

    set codigo(codigo:number){
        this._codigo = codigo;
    }
}