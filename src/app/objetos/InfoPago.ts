export class InfoPago{
    constructor(){}
    _tarjeta!:String;
    _vencimiento!:String;
    _usuarioCodigo!:number;

    get tarjeta(){
        return this._tarjeta;
    }

    set tarjeta(tarjeta:String){
        this._tarjeta = tarjeta;
    }

    get vencimiento(){
        return this._vencimiento;
    }

    set vencimiento(vencimiento:String){
        this._vencimiento = vencimiento;
    }

    get usuarioCodigo(){
        return this._usuarioCodigo;
    }

    set usuarioCodigo(usuarioCodigo:number){
        this._usuarioCodigo = usuarioCodigo;
    }

}