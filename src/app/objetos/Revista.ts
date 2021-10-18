export class Revista{
    _codigo!:number;
    _nombre:String;
    _fecha:String;
    _precio:number;
    _descripcion:String;
    _autor:String;

    constructor(nombre: String, precio:number, fecha:String, descripcion:String, autor:String){
    this._nombre=nombre;
    this._precio= precio;
    this._fecha = fecha;
    this._descripcion = descripcion;
    this._autor = autor;
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
    get fecha(){
        return this._fecha;
    }
    set fecha(fecha:String){
        this.fecha = fecha;
    }

    get descripcion(){
        return this._descripcion;
    }
    set descripcion(descripcion:String){
        this._descripcion = descripcion;
    }
    get autor(){
        return this._autor;
    }
    set autor(autor:String){
        this._autor = autor;
    }
    get codigo(){
        return this._codigo;
    }
}