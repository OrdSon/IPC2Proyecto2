export class Revista{
    _codigo!:number;
    _nombre:String;

    _precio:number;

    constructor(nombre: String, precio:number){
    this._nombre=nombre;
    this._precio= precio;

    }

    set nombre(nombre:String){
        this.nombre = nombre;
    }

    get nombre(){
        return this.nombre;
    }

    set precio(precio:number){
        this._precio = precio;
    }

    get precio(){
        return this._precio;
    }
    set codigo(codigo:number){
        this._codigo = codigo;
    }

    get codigo(){
        return this._codigo;
    }
}