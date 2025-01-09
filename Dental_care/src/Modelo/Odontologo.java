
package Modelo;


public class Odontologo extends Persona{
    private String Especialidad;
    private String Observacion;
    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

 
    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }



    public Odontologo() {
        super();
        Especialidad = null;
        Observacion=null;
    }

    public Odontologo(String Especialidad, String Observacion, String DireccionC, String Cedula, String Nombre, String Telefono, String Correo, String Cargo, String User, String Clave, String Fecha_Ingreso) {
        super(DireccionC, Cedula, Nombre, Telefono, Correo, Cargo, User, Clave, Fecha_Ingreso);
        this.Especialidad = Especialidad;
        this.Observacion = Observacion;
    }
    
    
   
        public void IngresarDatos(String DireccionC, String Cedula, String Nombre, String Telefono, String Correo, String Cargo, String User, String Clav, String Especi, String Obser ){
        this.DireccionC = DireccionC;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Cargo = Cargo;
        this.User = User;
        this.Clave = Clav;
        this.Especialidad=Especi;
        this.Observacion=Obser;
    }
    
}
