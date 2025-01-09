/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;



/**
 *
 * @author Alex Altuve
 */
public class Persona {
  protected String DireccionC;
  protected  String Cedula;
  protected  String Nombre;
  protected  String Telefono;
  protected  String Correo;
  protected  String Cargo;
  protected  String User;
  protected  String Clave;
  protected  String FechaIngreso;

    public Persona(){
        this.DireccionC =null;
        this.Cedula = null;
        this.Nombre =null;
        this.Telefono = null;
        this.Correo = null;
        this.Cargo = null;
        this.User = null;
        this.Clave =null;
        this.FechaIngreso= "No ha ingresado";
    }
    public Persona(String DireccionC, String Cedula, String Nombre, String Telefono, String Correo, String Cargo, String User, String Clave, String Fecha_Ingreso) {
        this.DireccionC = DireccionC;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Cargo = Cargo;
        this.User = User;
        this.Clave = Clave;
        this.FechaIngreso= Fecha_Ingreso;
    }
///////////////////////////////////////////////

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }
    
    public String getDireccionC() {
        return DireccionC;
    }

    public void setDireccionC(String DireccionC) {
        this.DireccionC = DireccionC;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }
   ////////////////////////////////////////////////////
    public boolean ValidarNombre(String nombre){     
        return nombre.matches("([A-Z]{1}[a-z]+[ ]*?){1,4}$");  
    }
    
    public boolean ValidarCorreo(String correo){
       return correo.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.([a-zA-Z]{2,4})+");     
   }
    public boolean ValidarCedula(String cedula){ 
        return cedula.matches("[0-9]{6,8}");  
    }
    public boolean ValidarTelefono(String telefono){ 
        return telefono.matches("[0-9]{11}");  
    }
//    public boolean ValidarDireccion(String direccion){
//        return direccion.matches("([A-Z0-9]{1}[a-z0-9]+[ ]*?)+$");  
//    }
    
   
    public boolean ValidarDatosIngresado(String Cedula, String Correo, String Nombre,String Telefono){
       return ValidarCorreo(Correo) && ValidarCedula(Cedula) && ValidarNombre(Nombre) && ValidarTelefono(Telefono);          
    }
    public void IngresarDatos(String DireccionC, String Cedula, String Nombre, String Telefono, String Correo, String Cargo, String User, String Clav){
        this.DireccionC = DireccionC;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Cargo = Cargo;
        this.User = User;
        this.Clave = Clav;
    }
    
    public boolean ValidarUsuario(ArrayList<Persona> Perfiles, String User){ /// Metodo que revisa si la cedula esta repetida o no
        if(Perfiles.isEmpty() == false){
         
            for(int i=0; i< Perfiles.size(); i++){
                if(Perfiles.get(i).getUser().trim().equals(User.trim())){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean ValidarCedulaRep(ArrayList<Persona> Perfiles, String Cedula){ // Metodo que verifica si el usuario esta repetido o no 
        if(Perfiles.isEmpty() == false){

            for(int i=0; i< Perfiles.size(); i++){
                if(Perfiles.get(i).getCedula().trim().equals(Cedula.trim())){
                    return true;
                }
            }
        }
        return false;
    }
    
    
}
