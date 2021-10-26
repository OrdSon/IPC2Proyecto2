export class Preview {

    _codigo!: number;
    _nombre!: String;
    _descripcion!: String;
    _fechaPublicacion!: String;
    _numero!: number;
    _likes!: number;
    _revistaCodigo!: number;
    _archivo!: any;
    _precio!: number;
    _autor!: String;
    _email!: String;
    _revista!:String;

    constructor(){
        
    }

    get codigo() {
        return this._codigo;
    }
    get numero() {
        return this._numero;
    }
    get likes() {
        return this._likes;
    }
    get revistaCodigo() {
        return this._revistaCodigo;
    }
    get precio() {
        return this._precio;
    }

    set codigo(numero: number) {
        this._codigo = numero;
    }
    set numero(numero: number) {
        this._numero = numero;
    }
    set likes(numero: number) {
        this._likes = numero;
    }
    set revistaCodigo(numero: number) {
        this._revistaCodigo = numero;
    }
    set precio(numero: number) {
        this._precio = numero;
    }

    get nombre() {
        return this._nombre;
    }
    get descripcion() {
        return this._descripcion;
    }
    get fechaPublicacion() {
        return this._fechaPublicacion;
    }
    get autor() {
        return this._autor;
    }
    get email() {
        return this._email;
    }

    set nombre(cadena: String) {
        this._nombre = cadena;
    }
    set descripcion(cadena: String) {
        this._descripcion = cadena;
    }
    set fechaPublicacion(cadena: String) {
        this._fechaPublicacion = cadena;
    }
    set autor(cadena: String) {
        this._autor = cadena;
    }
    set email(cadena: String) {
        this._email = cadena;
    }

    get archivo(){
        return this._archivo;
    }

    set archivo(archivo:any){
        this._archivo = archivo;
    }

    get revista(){
        return this._revista;
    }

    set revista(cadena:String){
        this._revista = cadena;
    }
}