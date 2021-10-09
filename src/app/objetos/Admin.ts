export class Admin {
    _nombre: String;
    _email: String;
    _password: String;

    constructor(nombre: String, email: String, password: String) {
        this._nombre = nombre;
        this._email = email;
        this._password = password;
    }
}