
export class Usuario {
    _codigo: number;
    _nombre: String;
    _email: String;
    _nombre_usuario: String;
    _tipo: number;
    _password: String;


    constructor(codigo: number, nombre: String, email: String, nombre_usuario: String, tipo: number, password: String) {
        this._codigo = codigo;
        this._nombre = nombre;
        this._email = email;
        this._nombre_usuario = nombre_usuario;
        this._tipo = tipo;
        this._password= password;
    }

    get codigo() {
        return this._codigo;
    }

    set codigo(codigo: number) {
        this._codigo = codigo;
    }

    get nombre() {
        return this._codigo;
    }

    set nombre(codigo: number) {
        this._codigo = codigo;
    }

    get email(){
        return this._email;
    }

    set email(email:String){
        this._email=email;
    }


}