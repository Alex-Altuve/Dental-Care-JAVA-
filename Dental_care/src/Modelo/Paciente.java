
package Modelo;

import java.util.ArrayList;

public class Paciente {
    
    private  String DireccionC;
    private  String Cedula;
    private  String Nombre;
    private  String Telefono;
    private  String Correo;
    private int Edad;
    private  String Sexo;
    private  String Observacion;

    public Paciente(String DireccionC, String Cedula, String Nombre, String Telefono, String Correo, int Edad, String Sexo, String Observacion) {
        this.DireccionC = DireccionC;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Edad = Edad;
        this.Sexo = Sexo;
        this.Observacion = Observacion;
    }
   
    
    public Paciente() {
        DireccionC = null;
        Cedula = null;
        Nombre = null;
        Telefono = null;
        Correo = null;
        Edad = 0;
        Sexo = null;
        Observacion = null;
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

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }
    
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
    
    public boolean ValidarEdad(int Edad){ 
        return Edad>0 && Edad<=105;
    }
    
    public boolean ValidarDatosIngresado(String Cedula, String Correo, String Nombre,String Telefono,int Edad){
       return ValidarCorreo(Correo) && ValidarCedula(Cedula) && ValidarNombre(Nombre) && ValidarTelefono(Telefono)&& ValidarEdad(Edad) ;          
    }
    
    public void IngresarDatos(String DireccionC, String Cedula, String Nombre, String Telefono, String Correo, int Edad, String Sexo, String Observacion){
        this.DireccionC = DireccionC;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Edad=Edad;
        this.Sexo=Sexo;
        this.Observacion=Observacion;
    }
    
    public boolean ValidarCedulaRep(ArrayList<Paciente> Pacientes, String Cedula){ // Metodo que verifica si el paciente esta repetido o no 
        if(Pacientes.isEmpty() == false){

            for(int i=0; i< Pacientes.size(); i++){
                if(Pacientes.get(i).getCedula().trim().equals(Cedula.trim())){
                    return true;
                }
            }
        }
        return false;
    }
    
}
