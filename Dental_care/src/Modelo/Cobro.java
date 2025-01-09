/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;



/**
 *
 * @author Alex Altuve
 */
public class Cobro {
    private String Nombre, Cedula, Direccion, Telefono, TipoPago, NumTarjeta_Transferencia, Nota, FechaCobro, Servicios, Monto;
   
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getTipoPago() {
        return TipoPago;
    }

    public void setTipoPago(String TipoPago) {
        this.TipoPago = TipoPago;
    }

    public String getNumTarjeta_Transferencia() {
        return NumTarjeta_Transferencia;
    }

    public void setNumTarjeta_Transferencia(String NumTarjeta_Transferencia) {
        this.NumTarjeta_Transferencia = NumTarjeta_Transferencia;
    }

    public String getNota() {
        return Nota;
    }

    public void setNota(String Nota) {
        this.Nota = Nota;
    }

    public String getFechaCobro() {
        return FechaCobro;
    }

    public void setFechaCobro(String FechaCobro) {
        this.FechaCobro = FechaCobro;
    }

    public String getServicios() {
        return Servicios;
    }

    public void setServicios(String Servicios) {
        this.Servicios = Servicios;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String Monto) {
        this.Monto = Monto;
    }

    public boolean ValidarNombre(String nombre){     
        return nombre.matches("([A-Z]{1}[a-z]+[ ]*?){1,4}$");  
    }
    
    public boolean ValidarCedula(String cedula){ 
        return cedula.matches("[0-9]{6,8}");  
    }
    public boolean ValidarTelefono(String telefono){ 
        return telefono.matches("[0-9]{11}");  
    }
    public boolean ValidarDatosIngresados(String Telefono, String Nombre, String Cedula, String Monto){
        return ValidarTelefono(Telefono)== true && ValidarNombre(Nombre.trim())== true && ValidarCedula(Cedula.trim())==true && Monto.length()>0;
    }
    public void IngresarDatos(String Nombre,String Cedula, String Direccion, String Telefono, String TipoPago, String NumT, String Nota, String Monto, String Servicios){
        LocalDate date = LocalDate.now();
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.TipoPago = TipoPago;
        this.NumTarjeta_Transferencia= NumT;
        this.Nota = Nota;
        this.FechaCobro = date.toString();
        this.Servicios= Servicios;
        this.Monto= Monto;
        
    }
}
