
package Controlador;

import Modelo.Conexion;
import Modelo.Cita;
import Modelo.Odontologo;
import Modelo.Paciente;
import Modelo.ServiciosOdontologicos;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ControladorGCita {
    JTextField textNombre,textCedula,textDireccion, textTelefono, textDescripcion, textServicio; 
    JTextField Error_Nombre, Error_Cedula,  Error_Telefono, Error_Fecha;
    JComboBox ListTel;
    JDateChooser Fecha;
    JCalendar Fecha2;
    JTable TablaPacientes;
    JTable TablaOdontologos;
    JTable TablaServicios;
    JTable TablaCitas;
    ArrayList<Odontologo> Doctores = new ArrayList<>();
    ArrayList<Paciente> Pacientes = new ArrayList<>();
    ArrayList<ServiciosOdontologicos> Servicios = new ArrayList<>();
    ArrayList<Cita> Citas = new ArrayList<>();

    public ControladorGCita(JTextField textNombre, JTextField textCedula, JTextField textDireccion, JTextField textTelefono, JTextField textDescripcion, JTextField textServicio, JTextField Error_Nombre, JTextField Error_Cedula, JTextField Error_Telefono, JComboBox ListTel, JDateChooser Fecha, JTable TablaPacientes, JTable TablaServicios, JTextField Error_Fecha) {
        this.textNombre = textNombre;
        this.textCedula = textCedula;
        this.textDireccion = textDireccion;
        this.textTelefono = textTelefono;
        this.textDescripcion = textDescripcion;
        this.textServicio = textServicio;
        this.Error_Nombre = Error_Nombre;
        this.Error_Cedula = Error_Cedula;
        this.Error_Telefono = Error_Telefono;
        this.ListTel = ListTel;
        this.Fecha = Fecha;
        this.TablaPacientes = TablaPacientes;
        this.TablaServicios = TablaServicios;
        this.Error_Fecha=Error_Fecha;
    }
    
    
    
    
    
    public ControladorGCita(JTable TablaOdontologos){
        this.TablaOdontologos=TablaOdontologos;
    }
     public ControladorGCita(JTable TablaCitas,String NADA){
        this.TablaCitas=TablaCitas;
    }

   
     public void LlenarArrayDocconBDOdontologo(){
        try{
            Connection cn = Conexion.conectarBD();
            Doctores.clear();
            Statement pst = cn.createStatement();
            ResultSet rs= pst.executeQuery("SELECT * FROM odontologos");
            String datos[]= new String[12]; 
            
            while (rs.next()) {
                Odontologo doc = new Odontologo();
                datos[0]=rs.getString(1); //nombre
                datos[1]=rs.getString(2); //cedula 
                datos[2]=rs.getString(3); //direccion
                datos[3]=rs.getString(4); //telefono
                datos[4]=rs.getString(5); //correo
                datos[5]=rs.getString(6); //cargo
                datos[6]=rs.getString(7); //usuario
                datos[7]=rs.getString(8); //clave
                datos[8]=rs.getString(9); //Fecha_Ingreso
                datos[9]=rs.getString(10); //Especialidad
                datos[10]=rs.getString(11); //Observaciones
                
                doc.IngresarDatos(datos[2], datos[1],datos[0],datos[3], datos[4], datos[5],datos[6], datos[7], datos[9], datos[10]);
                Doctores.add(doc);
            }
         
        cn.close();
        }catch(Exception e){
           
            System.err.println("Error al llenar arraylist." + e);
             JOptionPane.showMessageDialog(null, "Debe estara ctivo la base de datos, ¡Contacte al administrador!");
        } 
    }
    public void LLenarTablaOdontologo(){
        LlenarArrayDocconBDOdontologo();
         String[] columna = {"Nombre", "Cedula", "Telefono", "Correo", "Usuario", "Clave", "F. Ingreso", "Especialidad"}; // se modifico
         TablaOdontologos.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel dtm = new DefaultTableModel(null, columna){
          @Override
          public boolean isCellEditable(int row, int column){
              return false; 
          }
        };  
        for (int i=0; i<Doctores.size(); i++) { 
           String[] row = {Doctores.get(i).getNombre(), Doctores.get(i).getCedula(), Doctores.get(i).getTelefono(), Doctores.get(i).getCorreo(), Doctores.get(i).getUser(),Doctores.get(i).getClave() ,Doctores.get(i).getFechaIngreso(), Doctores.get(i).getEspecialidad()};
           dtm.addRow(row);
        }
        TablaOdontologos.setModel(dtm); 
        
    }
       public void LLenarTablaCitas(String Cedula){
        LlenarArrayListCitasconBD();
         String[] columna = {"Nombre", "Cedula","Telefono", "Fecha", "Servicio","ID"};
         TablaCitas.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel dtm = new DefaultTableModel(null, columna){
          @Override
          public boolean isCellEditable(int row, int column){
              return false; 
          }
        };  
        for (int i=0; i<Citas.size(); i++) { 
           
           if (Citas.get(i).getCedulaDoc().trim().equals(Cedula.trim())) {
               String[] row = {Citas.get(i).getNombre(), Citas.get(i).getCedula(), Citas.get(i).getTelefono(), Citas.get(i).getFecha(), Citas.get(i).getServicio(),Integer.toString(Citas.get(i).getNCita())  }; 
               dtm.addRow(row);
           }
           
        }
        TablaCitas.setModel(dtm); 
        
    }

    public void ConsultarCita(String ci){
         try{
         Connection cn = Conexion.conectarBD();
         PreparedStatement pst = cn.prepareStatement("select * from citas where ID = '" + ci + "'");

         ResultSet rs = pst.executeQuery();
         String Telef="";
         if(rs.next()){
            
             textNombre.setText(rs.getString("Nombre"));
             textCedula.setText(rs.getString("Cedula"));
             textServicio.setText(rs.getString("Servicio"));
             textDireccion.setText(rs.getString("Direccion"));
             Telef=rs.getString("Telefono").substring(4,11);
             textTelefono.setText(Telef);
             textDescripcion.setText(rs.getString("Descripcion"));
             String num=rs.getString("Telefono").substring(0, 4).trim();
             SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
             Date fecha = formatoFecha.parse(rs.getString("Fecha"));
             Fecha.setDate(fecha);
   
            if ("0212".equals(num)) {
                ListTel.setSelectedIndex(1);
            } else {
                if ("0412".equals(num)) {
                    ListTel.setSelectedIndex(2);
                } else {
                    if ("0414".equals(num)) {
                        ListTel.setSelectedIndex(3);
                    } else {
                        if ("0424".equals(num)) {
                            ListTel.setSelectedIndex(4);
                        } else {
                            if ("0416".equals(num)) {
                                ListTel.setSelectedIndex(5);
                            } else {
                                ListTel.setSelectedIndex(6);
                            }
                        }
                    }
                }
            }             
        }
         
        cn.close();
     }catch(Exception e){
         System.out.println("Error en cargar la cita" + e);
     }

    }
    
    //COLOCAR QUE LA FECHA DEBE ESTAR LLENA
     public boolean VerificarVaciosTextCita(){
         return  "".equals(textTelefono.getText()) || "".equals(textNombre.getText()) || "".equals(textCedula.getText()) || "".equals(textDireccion.getText()) ;
    }
     
    public void  LlenarArrayListPacientesconBD(){
     
      try{
            Connection cn = Conexion.conectarBD();
            Pacientes.clear();
            Statement pst = cn.createStatement();
            ResultSet rs= pst.executeQuery("SELECT * FROM pacientes");
            String datos[]= new String[9]; 
            
            while (rs.next()) {
                Paciente pac = new Paciente();
                datos[0]=rs.getString(1); //nombre
                datos[1]=rs.getString(2); //cedula 
                datos[2]=rs.getString(3); //direccion
                datos[3]=rs.getString(4); //telefono
                datos[4]=rs.getString(5); //correo
                datos[5]=rs.getString(6); //edad
                datos[6]=rs.getString(7); //sexo
                datos[7]=rs.getString(8); //Observacion
                int edad= Integer.parseInt(datos[5]);
                pac.IngresarDatos(datos[2], datos[1],datos[0], datos[3], datos[4], edad, datos[6], datos[7]);
                Pacientes.add(pac);
            }
         
        cn.close();
        }catch(Exception e){
           
            System.err.println("Error al llenar arraylist." + e);
             JOptionPane.showMessageDialog(null, "Debe estar activo la base de datos, ¡Contacte al administrador!");
        } 
    }     
    public void LLenarTablaPacientes(){
        
        LlenarArrayListPacientesconBD();
        String[] columna = {"Nombre","Cedula", "Direccion", "Telefono" }; // se modifico
        TablaPacientes.getTableHeader().setReorderingAllowed(false);
        
        DefaultTableModel dtm = new DefaultTableModel(null, columna){
          @Override
          public boolean isCellEditable(int row, int column){
              return false; 
          }
        };  
        for (int i=0; i<Pacientes.size(); i++) { 
           String[] row = {Pacientes.get(i).getNombre(), Pacientes.get(i).getCedula(), Pacientes.get(i).getDireccionC(), Pacientes.get(i).getTelefono()};
           dtm.addRow(row);
        }
        TablaPacientes.setModel(dtm); 

       
    }
      public void InsertarCitaBD(Cita cit){
        
        try {
            Connection cn = Conexion.conectarBD();
            Statement stm= (Statement) cn.createStatement();

            String Nombre= cit.getNombre();
            String Cedula= cit.getCedula();
            String Telefono= cit.getTelefono();
            String Servicio=cit.getServicio();
            String Direccion= cit.getDireccionC();
            String Descripcion= cit.getDescripcion();
            String Fecha= cit.getFecha();
            String Cedula2=cit.getCedulaDoc();
            String NCita=Integer.toString(cit.getNCita()) ;
        
            String insert="INSERT INTO citas VALUES('"+Nombre+"','"+Cedula+"','"+Telefono+"','"+Fecha+"','"+Servicio+"','"+Descripcion+"','"+Direccion+"','"+Cedula2+"','"+NCita+"');";
         
            stm.executeUpdate(insert);
            cn.close();
            JOptionPane.showMessageDialog(null, "Registro exitoso.");
        }catch(SQLException e) {
             System.err.println("Error al ingresar en la BD " + e);
             JOptionPane.showMessageDialog(null, "¡Contacte al administrador!");
        }
        
    }  
    public void  LlenarArrayListServiciosconBD(){
     
      try{
            Connection cn = Conexion.conectarBD();
            Servicios.clear();
            Statement pst = cn.createStatement();
            ResultSet rs= pst.executeQuery("SELECT * FROM servicios");
            String datos[]= new String[3]; 
            
            while (rs.next()) {
                ServiciosOdontologicos serv = new ServiciosOdontologicos();
                datos[0]=rs.getString(1); //nombre
                datos[1]=rs.getString(2); //precio
                datos[2]=rs.getString(3); //descripcion
                float precio= Float.parseFloat(datos[1]);
                serv.ingresarDatos(datos[0], precio, datos[2]);
                Servicios.add(serv);
            }
         
        cn.close();
        }catch(Exception e){
           
            System.err.println("Error al llenar arraylist." + e);
             JOptionPane.showMessageDialog(null, "Debe estar activo la base de datos, ¡Contacte al administrador!");
        } 
    }
    public void ConectarPanel(JPanel origen, JPanel destino, int ancho, int alto, int x, int y){ // Metodo que permite mostrar un panel dentro de otro
          
        destino.setSize(ancho, alto);
        destino.setLocation(x,y);
        origen.removeAll();
        origen.add(destino, BorderLayout.CENTER);
        origen.revalidate();
        origen.repaint();
    }
     public void LLenarTablaServicios(){
        
        LlenarArrayListServiciosconBD();
        String[] columna = {"Nombre", "Descripcion"}; // se modifico
        TablaServicios.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel dtm = new DefaultTableModel(null, columna){
          @Override
          public boolean isCellEditable(int row, int column){
              return false; 
          }
        };  
        for (int i=0; i<Servicios.size(); i++) { 
           String[] row = {Servicios.get(i).getNombre(),  Servicios.get(i).getDescripcion()};
           dtm.addRow(row);
        }
        TablaServicios.setModel(dtm); 

       
    }
     
    public void PasarNumaCombo(String tel){
        String num=tel.substring(0, 4).trim();
        if ("0212".equals(num)) {
            ListTel.setSelectedIndex(1);
        } else {
            if ("0412".equals(num)) {
                ListTel.setSelectedIndex(2);
            } else {
                if ("0414".equals(num)) {
                    ListTel.setSelectedIndex(3);
                } else {
                    if ("0424".equals(num)) {
                        ListTel.setSelectedIndex(4);
                    } else {
                        if ("0416".equals(num)) {
                            ListTel.setSelectedIndex(5);
                        } else {
                            ListTel.setSelectedIndex(6);
                        }
                    }
                }
            }
        }
    }
   public void VaciarDatos(){
        textNombre.setText("");
        textCedula.setText("");
        textTelefono.setText("");
        textDireccion.setText("");
        textDescripcion.setText("");
        
        Error_Nombre.setText("");
        Error_Cedula.setText("");

        ListTel.setSelectedIndex(0);
   }    
    public boolean Registrarcita(String CedulaDoc) throws ParseException{ 
        boolean a= false;
        LlenarArrayListCitasconBD();
        
         
        if (VerificarVaciosTextCita() !=true && ListTel.getSelectedIndex()!=0 ){
           Cita cit = new Cita(); 
           String Partenum=ListTel.getSelectedItem().toString().trim()+textTelefono.getText().trim();  /// une el combo box lista de numeros y el text field telefono
            if (Fecha.getCalendar() != null) {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
                String fechaFormateada = formatoFecha.format(Fecha.getDate());
               
                Date fecha_vacia = formatoFecha.parse(fechaFormateada.trim());
                if(cit.ValidarDatosIngresado(textCedula.getText().trim(), textNombre.getText().trim(),Partenum.trim(),fechaFormateada.trim())){
                
                    cit.IngresarDatos(textDireccion.getText().trim(), textCedula.getText().trim(), textNombre.getText().trim(), Partenum ,textDescripcion.getText().trim(), textServicio.getText().trim(),fechaFormateada.trim(), CedulaDoc.trim(), AsignarNCita()); 
                    InsertarCitaBD(cit);               
                    VaciarDatos();   
                    a=true;
                }else{          
                    LLenarCamposErroresPac(cit);
                }
            }else{
                CrearFuentetoErrores(Error_Fecha);
                Error_Fecha.setText("*Formato dd-MM-yyyy");
            } 
           
        }else{
            JOptionPane.showMessageDialog(null, "No se puede agregar al usuario si hay campos vacios o no seleccionados","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }       
        return a;
    }
    public void CrearFuentetoErrores(JTextField copy){
        Font fuente = new Font("", Font.BOLD, 9);
        copy.setForeground(Color.red);
        copy.setFont(fuente);
    }      
     public void LLenarCamposErroresPac(Cita cit){  
    
       String Partenum=ListTel.getSelectedItem().toString().trim()+textTelefono.getText().trim();
        LlenarArrayListCitasconBD();
        if(cit.ValidarNombre(textNombre.getText().trim())== false){
            CrearFuentetoErrores(Error_Nombre);
            Error_Nombre.setText("*Cumplir formato [(A)riel (M)ax]");
        }
        if(cit.ValidarCedula(textCedula.getText().trim())== false){
            CrearFuentetoErrores(Error_Cedula);
            Error_Cedula.setText("*Numeros entre 6 y 8 digitos");
        }
        if(cit.ValidarTelefono(Partenum)== false){
            CrearFuentetoErrores(Error_Telefono);
            Error_Telefono.setText("*Debe tener 11 digitos");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = sdf.format(Fecha.getDate()); 
        if(cit.ValidarFecha(fecha)== false){
            CrearFuentetoErrores(Error_Fecha);
            Error_Fecha.setText("*Formato dd-MM-yyyy");
        }
    }  
    public void  LlenarArrayListCitasconBD(){
     
      try{
            Connection cn = Conexion.conectarBD();
            Citas.clear();
            Statement pst = cn.createStatement();
            ResultSet rs= pst.executeQuery("SELECT * FROM citas");
            String datos[]= new String[10]; 
            
            while (rs.next()) {
                Cita cit = new Cita();
                datos[0]=rs.getString(1); //nombre
                datos[1]=rs.getString(2); //cedula 
                datos[2]=rs.getString(3); //telefono
                datos[3]=rs.getString(4); //fecha
                datos[4]=rs.getString(5); //Servicio
                datos[5]=rs.getString(6); //Descripcion
                datos[6]=rs.getString(7); //Direccion
                datos[7]=rs.getString(8); //CedulaDoc
                datos[8]=rs.getString(9); //NCita
                int NCita = Integer.parseInt(datos[8])  ;
                cit.IngresarDatos(datos[6], datos[1],datos[0], datos[2], datos[5], datos[4], datos[3],datos[7],NCita );
                Citas.add(cit);
            }
         
        cn.close();
        }catch(Exception e){
           
            System.err.println("Error al llenar arraylist22222." + e);
             JOptionPane.showMessageDialog(null, "Debe estar activo la base de datos, ¡Contacte al administrador!");
        } 
    } 
    
    public int AsignarNCita(){
        LlenarArrayListCitasconBD();
        int NCita=0;
        boolean validar=false;
        while (validar==false) {
            boolean validar2=false;      
            NCita=(int) (Math.random() * 1000000000);
            for (int i=0; i<Citas.size(); i++) { 
                if(NCita==Citas.get(i).getNCita()){
                validar2=true;
                }
            }
            if(validar2==false){
             break;
            }
        }
        
        return NCita;
    }
    
     public void SeleccionarPaciente(){
        int fila=TablaPacientes.getSelectedRow(); //llamar tabla odontologo
        if (fila>-1) {
            String Cedula= TablaPacientes.getValueAt(fila, 1).toString().trim();
            String Nombre=TablaPacientes.getValueAt(fila, 0).toString().trim();
            String Direccion=TablaPacientes.getValueAt(fila, 2).toString().trim();
            String Telefono=TablaPacientes.getValueAt(fila, 3).toString().trim();
            textCedula.setText(Cedula);
            textNombre.setText(Nombre);
            textDireccion.setText(Direccion);
            String Telef=Telefono.substring(4,11);
            textTelefono.setText(Telef);
            String num=Telefono.substring(0, 4).trim();
            if ("0212".equals(num)) {
                ListTel.setSelectedIndex(1);
            } else {
                if ("0412".equals(num)) {
                    ListTel.setSelectedIndex(2);
                } else {
                    if ("0414".equals(num)) {
                        ListTel.setSelectedIndex(3);
                    } else {
                        if ("0424".equals(num)) {
                            ListTel.setSelectedIndex(4);
                        } else {
                            if ("0416".equals(num)) {
                                ListTel.setSelectedIndex(5);
                            } else {
                                ListTel.setSelectedIndex(6);
                            }
                        }
                    }
                }
            }              
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un paciente");
        }
    }
    
     public void SeleccionarServicio(){
        int fila=TablaServicios.getSelectedRow(); //llamar tabla odontologo
        if (fila>-1) {
            String Descripcion= TablaServicios.getValueAt(fila, 1).toString().trim();
            String Nombre=TablaServicios.getValueAt(fila, 0).toString().trim();
            textDescripcion.setText(Descripcion);
            textServicio.setText(Nombre);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un servicio");
        }
    }
    
    public boolean EliminarCita(String IDCita){
        boolean a=false;
        

        if(  JOptionPane.showConfirmDialog(null, "¿Seguro de que desea eliminar la cita?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
           
            try {
                Connection cn = Conexion.conectarBD();
                String sql = "DELETE FROM citas WHERE ID = '" + IDCita + "'"; // le indico a quien debe borra pasandole el ID
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.executeUpdate();
                cn.close();
                JOptionPane.showMessageDialog(null,"¡La Cita fue eliminada con éxito!");
                Limpiar();
                a=true;
            } catch (Exception e) {
                System.err.println("Error al eliminar la cita de la tabla." + e);
                JOptionPane.showMessageDialog(null, "Debe estar activa la base de datos, ¡Contacte al administrador!");
            }
        }
        return a;
    }     
    
    public void Limpiar(){
        textNombre.setText("");
        textCedula.setText("");
        textTelefono.setText("");
        textDireccion.setText("");
        textDescripcion.setText("");
        textServicio.setText("");
        Error_Nombre.setText("");
        Error_Cedula.setText("");
        Error_Telefono.setText("");
    }
    
    
    public boolean ValidarFechaVacia(Date fecha) {
        return fecha != null;
    }
    public boolean ModificarCita(String IDCita){
        
        String  Nombre, Cedula, Direccion, Telefono, Descripcion,Servicio;
        Cita cit = new Cita();
                
        
        
        Servicio = textServicio.getText().trim();
        Nombre = textNombre.getText().trim();
        Cedula = textCedula.getText().trim();
        Direccion = textDireccion.getText().trim();
        Telefono = ListTel.getSelectedItem().toString().trim()+textTelefono.getText().trim();
        Descripcion = textDescripcion.getText().trim();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String fechaFormateada = formatoFecha.format(Fecha.getDate());
                
        if(JOptionPane.showConfirmDialog(null, "¿Seguro de que desea modificar la cita ?", "Confirmar Modificacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){ 
             if(cit.ValidarCedula(Cedula)== true && cit.ValidarNombre(Nombre)==true && cit.ValidarTelefono(Telefono)==true && Fecha.getCalendar() != null){
                
                 try{
                    Connection cn = Conexion.conectarBD();
                    String Ssql = "UPDATE citas SET Nombre= ?, Direccion= ?, Telefono= ?, Cedula= ?, Descripcion= ?, Fecha= ?, Servicio= ? " + "WHERE ID = '" + IDCita + "'";
                    PreparedStatement pst2 = cn.prepareStatement(Ssql);
                    
                    pst2.setString(1, Nombre);
                    pst2.setString(2, Direccion);
                    pst2.setString(3, Telefono);
                    pst2.setString(4, Cedula);
                    pst2.setString(5, Descripcion);
                    pst2.setString(6, fechaFormateada.trim());
                    pst2.setString(7, Servicio);

                    
                    pst2.executeUpdate();
                    cn.close();
                    JOptionPane.showMessageDialog(null,"Se han guardado los cambios.");
                    return true;
                }catch (Exception e){
                    System.out.println("Error al actualizar la BD"+e);
                }
            }else{
                if(cit.ValidarNombre(textNombre.getText().trim())== false){
                    CrearFuentetoErrores(Error_Nombre);
                    Error_Nombre.setText("*Cumplir formato [(A)riel (M)ax]");
                }
                if(cit.ValidarTelefono(Telefono)== false){
                    CrearFuentetoErrores(Error_Telefono);
                    Error_Telefono.setText("*Debe tener 11 digitos");
                }
                if(cit.ValidarCedula(textCedula.getText().trim())== false){
                    CrearFuentetoErrores(Error_Cedula);
                    Error_Cedula.setText("*Numeros entre 6 y 8 digitos");
                }               
                if (cit.ValidarFecha(fechaFormateada.trim())) {
                    CrearFuentetoErrores(Error_Fecha);
                    Error_Fecha.setText("*Formato dd-MM-yyyy"); 
                }
                return false;
            }
        }
        return false;
    
    }
}
