export class Numero {

    _nombre: String;
    _fecha = new Date().toLocaleDateString();
    _numero = 1;

    constructor(nombre: String, numero: number) {
        this._nombre = nombre
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

}