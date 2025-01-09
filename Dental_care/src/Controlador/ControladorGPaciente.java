/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Paciente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex Altuve
 */
public class ControladorGPaciente {
    JTextField textNombre,textCedula,textDireccion, textTelefono, textCorreo, txtObservaciones,textEdad; 
    JTextField Error_Nombre, Error_Cedula, Error_Correo, Error_Especialidad, Error_Edad, Error_Usuario, Error_Telefono;
    JComboBox Sexo, ListTel;
    JTable TablaPacientes;
    ///////////////////////////////
    ArrayList<Paciente> Pacientes = new ArrayList<>();
   
    
    
    //////////Registrar Pacientes///
    public ControladorGPaciente(JTextField textNombre, JTextField textCedula, JTextField textDireccion ,JTextField textTelefono, JTextField textCorreo, JTextField txtObservaciones, JTextField Error_Nombre, JTextField Error_Cedula, JTextField Error_Edad, JComboBox ListTel,JTextField Error_Telefono,JComboBox SexoF,JTextField textEdad, JTextField Error_Correo) {
        this.textNombre = textNombre;
        this.textCedula = textCedula;
        this.textTelefono = textTelefono;
        this.textDireccion = textDireccion;
        this.textCorreo = textCorreo;       
        this.txtObservaciones = txtObservaciones;
        this.Sexo= SexoF;            
        
        this.Error_Telefono=Error_Telefono;
        this.Error_Correo= Error_Correo;
        this.Error_Nombre = Error_Nombre;
        this.Error_Cedula = Error_Cedula;
        this.Error_Edad = Error_Edad;
        this.textEdad=textEdad;
        
        this.ListTel = ListTel;
    }
    
    //////GESTION PACIENTES ////////
    public ControladorGPaciente(JTable TablaPacientes) {
        this.TablaPacientes = TablaPacientes;
    }
      
    ///////////////////////////////////////
     public void iniciaVentana(JFrame ventana, String ruta) {
        ventana.setLocationRelativeTo(null);
        ventana.setIconImage(new ImageIcon(ruta).getImage());
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
      
    public void activaVentana(JFrame ventana,JFrame ventana2) {
        
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana2.dispose(); 
    }
    public void ConectarPanel(JPanel origen, JPanel destino, int ancho, int alto, int x, int y){ // Metodo que permite mostrar un panel dentro de otro
          
        destino.setSize(ancho, alto);
        destino.setLocation(x,y);
        origen.removeAll();
        origen.add(destino, BorderLayout.CENTER);
        origen.revalidate();
        origen.repaint();
    }
    public void CrearFuentetoErrores(JTextField copy){
        Font fuente = new Font("", Font.BOLD, 9);
        copy.setForeground(Color.red);
        copy.setFont(fuente);
    }
    
    public boolean VerificarVaciosTextPac(){
         return  "".equals(textTelefono.getText()) || "".equals(textNombre.getText()) || "".equals(textCedula.getText()) || "".equals(textDireccion.getText()) || "".equals(textCorreo.getText())|| "".equals(textEdad.getText()) ;
    }
   ////////////////////////////////////////////////////////////////
   public void VaciarDatos(){
        textNombre.setText("");
        textCedula.setText("");
        textTelefono.setText("");
        textDireccion.setText("");
        textCorreo.setText("");
        textEdad.setText("");
        txtObservaciones.setText("");
        
        Error_Nombre.setText("");
        Error_Edad.setText("");
        Error_Cedula.setText("");
        Error_Correo.setText("");
        
        Sexo.setSelectedIndex(0);
        ListTel.setSelectedIndex(0);
   }
   public String ConseguirSexoSelect(){
       if(Sexo.getSelectedIndex()==1){
           return "Femenino";
       }
       if(Sexo.getSelectedIndex()==2){
           return "Masculino";
       }
        return null;
   }
    public boolean RegistrarPaciente(){ 
        boolean a= false;
        LlenarArrayListPacientesconBD();
       
        if (VerificarVaciosTextPac() !=true && ListTel.getSelectedIndex()!=0  ){
           Paciente pac = new Paciente(); 
           String Partenum=ListTel.getSelectedItem().toString().trim()+textTelefono.getText().trim();  /// une el combo box lista de numeros y el text field telefono
                     
           if(pac.ValidarDatosIngresado(textCedula.getText().trim(), textCorreo.getText().trim(), textNombre.getText().trim(),Partenum.trim(),Integer.parseInt(textEdad.getText().trim()) )== true && pac.ValidarCedulaRep(Pacientes, textCedula.getText().trim())==false){
               
                pac.IngresarDatos(textDireccion.getText().trim(), textCedula.getText().trim(), textNombre.getText().trim(), Partenum, textCorreo.getText().trim(),Integer.parseInt(textEdad.getText().trim()), ConseguirSexoSelect().trim() ,txtObservaciones.getText().trim()); 
                InsertarUsuarioBDPaciente(pac);               
                VaciarDatos();   
                a=true;
            }else{              
                LLenarCamposErroresPac(pac);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se puede agregar al usuario si hay campos vacios o no seleccionados","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }       
        return a;
    }
    
     public void LLenarCamposErroresPac(Paciente pac){  
    
       String Partenum=ListTel.getSelectedItem().toString().trim()+textTelefono.getText().trim();
        LlenarArrayListPacientesconBD();
        if(pac.ValidarNombre(textNombre.getText().trim())== false){
            CrearFuentetoErrores(Error_Nombre);
            Error_Nombre.setText("*Cumplir formato [(A)riel (M)ax]");
        }
        if(pac.ValidarCedula(textCedula.getText().trim())== false){
            CrearFuentetoErrores(Error_Cedula);
            Error_Cedula.setText("*Numeros entre 6 y 8 digitos");
        }
        if(pac.ValidarTelefono(Partenum)== false){
            CrearFuentetoErrores(Error_Telefono);
            Error_Telefono.setText("*Debe tener 11 digitos");
        }
        if(pac.ValidarCorreo(textCorreo.getText().trim())== false){
            CrearFuentetoErrores(Error_Correo);
            Error_Correo.setText("*Debe cumplir con el formato nombre@correo.com");
        }
        if(pac.ValidarCedulaRep(Pacientes,textCedula.getText().trim())== true){
            CrearFuentetoErrores(Error_Cedula);
            Error_Cedula.setText("*Cedula ya registrada");
        }
        if(pac.ValidarEdad(Integer.parseInt(textEdad.getText().trim()))==false){
            CrearFuentetoErrores(Error_Edad);
            Error_Edad.setText("*La edad debe ser un numero entre 1-105");
        }  
    }
    
    
  public void InsertarUsuarioBDPaciente(Paciente pac){
        
        try {
            Connection cn = Conexion.conectarBD();
            Statement stm= (Statement) cn.createStatement();

            String Nombre= pac.getNombre();
            String Cedula= pac.getCedula();
            String Telefono= pac.getTelefono();
            String Correo=pac.getCorreo();
            String Direccion= pac.getDireccionC();
            String Observaciones= pac.getObservacion();
            String Edad=Integer.toString(pac.getEdad());
            String Sexo=pac.getSexo();
        
            String insert="INSERT INTO pacientes VALUES('"+Nombre+"','"+Cedula+"','"+Direccion+"','"+Telefono+"','"+Correo+"','"+Edad+"','"+Sexo+"','"+Observaciones+"');";
         
            stm.executeUpdate(insert);
            cn.close();
            JOptionPane.showMessageDialog(null, "Registro exitoso.");
        }catch(SQLException e) {
             System.err.println("Error al ingresarlo en la BD " + e);
             JOptionPane.showMessageDialog(null, "¡Contacte al administrador!");
        }
        
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
    
    public int pasarBD(String Sex){
        if("Femenino".equals(Sex.trim())){
           return 1;
       }
       if("Masculino".equals(Sex.trim())){
           return 2;
       }
        return 0;
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
    public void ConsultarPC(String ci){
       
        try{   
             Connection cn = Conexion.conectarBD();
             PreparedStatement pst = cn.prepareStatement("select * from pacientes where Cedula = '" + ci + "'");

             ResultSet rs = pst.executeQuery();
             String Telefono="";
             
             if(rs.next()){

                textNombre.setText(rs.getString("Nombre"));
                textCedula.setText(rs.getString("Cedula"));
                textDireccion.setText(rs.getString("Direccion"));
                textEdad.setText(rs.getString("Edad"));
                Sexo.setSelectedIndex(pasarBD(rs.getString("Sexo")));
                PasarNumaCombo(rs.getString("Telefono"));
                Telefono=rs.getString("Telefono").substring(4);
                textTelefono.setText(Telefono);
                textCorreo.setText(rs.getString("Correo"));
                txtObservaciones.setText(rs.getString("Observaciones"));

             }

            cn.close();
        }catch(Exception e){
             System.out.println("Error en cargar usuario " + e);

        }
    }
    
    public void LLenarTablaPacientes(){
        
        LlenarArrayListPacientesconBD();
        String[] columna = {"Nombre","Cedula", "Direccion", "Telefono", "Correo", "Edad", "Sexo" }; // se modifico
        TablaPacientes.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel dtm = new DefaultTableModel(null, columna){
          @Override
          public boolean isCellEditable(int row, int column){
              return false; 
          }
        };  
        for (int i=0; i<Pacientes.size(); i++) { 
           String[] row = {Pacientes.get(i).getNombre(), Pacientes.get(i).getCedula(), Pacientes.get(i).getDireccionC(), Pacientes.get(i).getTelefono(), Pacientes.get(i).getCorreo(), Integer.toString(Pacientes.get(i).getEdad()), Pacientes.get(i).getSexo()};
           dtm.addRow(row);
        }
        TablaPacientes.setModel(dtm); 

       
    }
    
    /////Eliminar y Modificar
    public boolean EliminarPaciente(){
        String ci= textCedula.getText();
        String name=textNombre.getText();
        boolean a=false;
        if(JOptionPane.showConfirmDialog(null, "¿Seguro de que desea eliminar al paciente "+name+" C.I "+ci+" ?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){ 
            a=true;
            try {
                Connection cn = Conexion.conectarBD();
                String sql = "DELETE FROM pacientes WHERE Cedula = '" + ci + "'"; // le indico a quien debe borra pasandole la cedula
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.executeUpdate();
                
                String sql1 = "DELETE FROM historias WHERE cedula_paciente = '" + ci + "'"; // le indico a quien debe borra pasandole la cedula
                PreparedStatement ps1 = cn.prepareStatement(sql1);
                ps1.executeUpdate();
                
                cn.close();
                VaciarDatos();
                JOptionPane.showMessageDialog(null,"¡El paciente fue eliminado con éxito!");
           
            } catch (Exception e) {
               System.err.println("Error al eliminar al paciente de la tabla." + e);
               JOptionPane.showMessageDialog(null, "Debe estar activo la base de datos, ¡Contacte al administrador!");
            }
        }   
        return a;  
    }
    public void ModificarPaciente(){
        
        String ci= textCedula.getText();
        String nombre, direccion, telefono,correo, edad,observaciones;
        Paciente pac= new Paciente();
        
        nombre = textNombre.getText().trim();
        direccion = textDireccion.getText().trim();
        telefono = ListTel.getSelectedItem().toString().trim()+textTelefono.getText().trim();
        correo = textCorreo.getText().trim();
        edad = textEdad.getText().trim();
        observaciones = txtObservaciones.getText().trim();
      
        if(JOptionPane.showConfirmDialog(null, "¿Seguro de que desea modificar al paciente "+nombre+" C.I "+ci+" ?", "Confirmar Modificacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){ 
             if(pac.ValidarCorreo(correo)== true && pac.ValidarNombre(nombre)==true && pac.ValidarEdad(Integer.parseInt(edad))==true && pac.ValidarTelefono(telefono)==true ){
               
                 try{
                    Connection cn = Conexion.conectarBD();
                    String Ssql = "UPDATE pacientes SET Nombre= ?, Direccion= ?, Telefono= ?, Correo= ?, Edad= ?, Observaciones= ? " + "WHERE Cedula = '" + ci + "'";
                    PreparedStatement pst2 = cn.prepareStatement(Ssql);

                    pst2.setString(1,nombre );

                    pst2.setString(2, direccion);
                    pst2.setString(3,telefono );
                    pst2.setString(4,correo );
                    pst2.setString(5, edad);
                    pst2.setString(6, observaciones);

                    
                    pst2.executeUpdate();
                    cn.close();
                    JOptionPane.showMessageDialog(null,"Se han guardado los cambios.");

                }catch (Exception e){
                    System.out.println("Error al actulizar la BD"+e);
                }
            }else{
                if(pac.ValidarNombre(textNombre.getText().trim())== false){
                    CrearFuentetoErrores(Error_Nombre);
                    Error_Nombre.setText("*Cumplir formato [(A)riel (M)ax]");
                }
                if(pac.ValidarTelefono(telefono)== false){
                    CrearFuentetoErrores(Error_Telefono);
                    Error_Telefono.setText("*Debe tener 11 digitos");
                }
                if(pac.ValidarCorreo(textCorreo.getText().trim())== false){
                    CrearFuentetoErrores(Error_Correo);
                    Error_Correo.setText("*Debe cumplir con el formato nombre@correo.com");
                }               
                if(pac.ValidarEdad(Integer.parseInt(textEdad.getText().trim()))==false){
                    CrearFuentetoErrores(Error_Edad);
                    Error_Edad.setText("*La edad debe ser un numero entre 1-105");
                }  
            }
        }
    
    }
}
