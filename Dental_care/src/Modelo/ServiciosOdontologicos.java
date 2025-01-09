/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Yustin Chacon
 */
public class ServiciosOdontologicos {
    private String nombre;
    private float precio;
    private String descripcion;
    
    public ServiciosOdontologicos(String Nombre, float Precio, String Descripcion) {

        this.nombre = Nombre;
        this.precio = Precio;
        this.descripcion = Descripcion;      
    }
    
    public ServiciosOdontologicos() {              
        nombre = null;
        precio = 0;
        descripcion = null;      
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public float getPrecio(){
        return precio;
    }
    
    public void setPrecio(float precio){
        this.precio = precio;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public boolean validarNombre(String nombre){     
        return nombre.matches("^[a-zA-Z0-9 ]+$");
        //return nombre.matches("([A-Z]{1}[a-z]+[ ]*?){1,4}$");  
    }
    
    public boolean validarPrecio(String precio){
        if (precio.equals(""))
            return false;
        return precio.matches("^([+-]?\\d*\\.?\\d*)$");
    }
    
    public void ingresarDatos(String nombre, float precio, String descripcion){
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    
    public boolean ValidarDatosIngresado(String Nombre, float Precio){
       return  validarNombre(Nombre) && validarPrecio(Float.toString(Precio));     
    }
}
