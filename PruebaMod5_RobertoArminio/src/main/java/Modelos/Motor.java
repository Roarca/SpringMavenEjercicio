/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

public class Motor {
    //Creo la clase motor , fijandome en los tipos en funcion de la BBDD
    private String Modelo_pk, Fabricante;
    private int Potencia,Peso,Cantidad;

    //Genero sus correspondientes constructores , incluido uno vacio
    public Motor(String Modelo_pk, String Fabricante, int Potencia, int Peso, int Cantidad) {
        this.Modelo_pk = Modelo_pk;
        this.Fabricante = Fabricante;
        this.Potencia = Potencia;
        this.Peso = Peso;
        this.Cantidad = Cantidad;
    }
    
    public Motor(){
        //Constructor vacio
    }

    //-------GETTERS ------------
    public String getModelo_pk() {
        return Modelo_pk;
    }
    public String getFabricante() {
        return Fabricante;
    }
    public int getPotencia() {
        return Potencia;
    }
    public int getCantidad() {
        return Cantidad;
    }
    public int getPeso() {
        return Peso;
    }

    //-------SETTERS ------------
    public void setPeso(int Peso) {
        this.Peso = Peso;
    }
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
     public void setModelo_pk(String Modelo_pk) {
        this.Modelo_pk = Modelo_pk;
    }
    public void setFabricante(String Fabricante) {
        this.Fabricante = Fabricante;
    }
    public void setPotencia(int Potencia) {
        this.Potencia = Potencia;
    }
    
}
