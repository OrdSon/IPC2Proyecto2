export class Setting{
    _codigo!:number;
    _porcentajeCobro!:number;
    _cuotaDiaria!:number;
    _precioHoraAnuncio!:number;
    constructor(){}
    
    get codigo(){
        return this._codigo;
    }
    set codigo(codigo:number){
        this._codigo = codigo;
    }
    get porcentajeCobro(){
        return this._porcentajeCobro;
    }
    set porcentajeCobro(porcentajeCobro:number){
        this._porcentajeCobro = porcentajeCobro;
    }
    get cuotaDiaria(){
        return this._cuotaDiaria;
    }
    set cuotaDiaria(cuotaDiaria:number){
        this._cuotaDiaria= cuotaDiaria;
    }
    get precioHoraAnuncio(){
        return this._precioHoraAnuncio;
    }
    set precioHoraAnuncio(precioHoraAnuncio:number){
        this._precioHoraAnuncio = precioHoraAnuncio;
    }
}