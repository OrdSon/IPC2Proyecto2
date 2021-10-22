export class Review{
    
    _usuarioCodigo!:number;
    _numeroCodigo!:number;
    _comentario!:String;
    _likes!:number;
    
    constructor(){
        
    }

    get usuarioCodigo(){
        return this._usuarioCodigo;
    }
    get numeroCodigo(){
        return this._numeroCodigo;
    }
    get comentario(){
        return this._comentario;
    }
    get likes(){
        return this._likes;
    }

    set usuarioCodigo(usuarioCodigo:number){
        this._usuarioCodigo = usuarioCodigo;
    }
    set numeroCodigo(numeroCodigo:number){
        this._numeroCodigo = numeroCodigo;
    }

    set comentario(comentario:String){
        this._comentario = comentario;
    }

    set likes(likes:number){
        this._likes = likes;
    }
}