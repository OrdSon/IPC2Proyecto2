export class Admin {
    _nombre: String;
    _email: String;
    _password: String;

    constructor(nombre: String, email: String, password: String) {
        this._nombre = nombre;
        this._email = email;
        this._password = password;
    }

    set nombre(nombre:String){
        this._nombre = nombre;
    }

    get nombre(){
        return this._nombre;
    }

    set email (email:String){
        this._email = email;
    }

    get email(){
        return this._email;
    }

    set password(password:String){
        this._password = password;
    }

    get password(){
        return this._password;
    }
}