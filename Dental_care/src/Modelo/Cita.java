
package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Cita {
    private  String DireccionC;
    private  String Cedula;
    private  String Nombre;
    private  String Telefono;
    private  String Descripcion;
    private  String Servicio;
    private  String Fecha;
    private  String CedulaDoc;
    private int NCita;

    public Cita(String DireccionC, String Cedula, String Nombre, String Telefono, String Descripcion, String Servicio, String Fecha, String CedulaDoc, int NCita) {
        this.DireccionC = DireccionC;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Descripcion = Descripcion;
        this.Servicio = Servicio;
        this.Fecha = Fecha;
        this.CedulaDoc = CedulaDoc;
        this.NCita = NCita;
    }
 
    
    public Cita() {
        DireccionC = null;
        Cedula = null;
        Nombre = null;
        Telefono = null;
        Descripcion = null;
        Servicio = null;
        Fecha = null;
        CedulaDoc=null;
        NCita=0;
    }

    public int getNCita() {
        return NCita;
    }

    public void setNCita(int NCita) {
        this.NCita = NCita;
    }

    
    public String getCedulaDoc() {
        return CedulaDoc;
    }

    public void setCedulaDoc(String CedulaDoc) {
        this.CedulaDoc = CedulaDoc;
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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getServicio() {
        return Servicio;
    }

    public void setServicio(String Servicio) {
        this.Servicio = Servicio;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    
    public boolean ValidarCedula(String cedula){ 
           return cedula.matches("[0-9]{6,8}");  
    }
    public boolean ValidarTelefono(String telefono){ 
        return telefono.matches("[0-9]{11}");  
    }
    public boolean ValidarNombre(String nombre){     
        return nombre.matches("([A-Z]{1}[a-z]+[ ]*?){1,4}$");  
    }
    public boolean ValidarDatosIngresado(String Cedula, String Nombre,String Telefono, String Fecha){
       return ValidarCedula(Cedula) && ValidarNombre(Nombre) && ValidarTelefono(Telefono) && ValidarFecha(Fecha) ;          
    }
    
    public boolean ValidarFecha(String fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        formatoFecha.setLenient(false);
        try {
            formatoFecha.parse(fecha.trim());
        } catch (ParseException e) {
            return false;
        }
        return true;
    }


    public void IngresarDatos(String DireccionC, String Cedula, String Nombre, String Telefono, String Descripcion, String Servicio, String Fecha, String CedulaDoc, int NCita){
        this.DireccionC = DireccionC;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Fecha=Fecha;
        this.Servicio=Servicio;
        this.Descripcion=Descripcion;
        this.CedulaDoc=CedulaDoc;
        this.NCita=NCita;
    }
    
}
