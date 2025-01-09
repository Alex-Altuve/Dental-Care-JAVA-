/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Odontologo;


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
import javax.swing.JFrame;import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex Altuve
 */
public class ControladorGOdontologo {
    JTextField TextNombre,TextCedula,TextDireccion, TextTelefono, TextCorreo, TextCargo, TextUsuario, TextClave, TextEspecialidad, TextObservaciones; 
    JTextField Error_Nombre, Error_Cedula, Error_Correo, Error_Usuario, Error_Telefono,Error_Direccion,Error_Especialidad;
    JComboBox Sexo, ListTel;
    ////////////////////////////
    JTable TablaOdontologos;
    ArrayList<Odontologo> Doctores = new ArrayList<>();
    
    
        public ControladorGOdontologo(JTextField TextNombre, JTextField TextCedula, JTextField TextDireccion, JTextField TextCorreo, JTextField TextTelefono, JTextField TextCargo, JTextField TextUsuario, JTextField TextClave, JTextField TextEspecialidad, JTextField Error_Nombre, JTextField Error_Cedula, JTextField Error_Correo, JTextField Error_Telefono, JComboBox ListTel, JTextField Error_Usuario,JTextField TextObservaciones,JTextField Error_Direccion,JTextField Error_Especialidad) {
        this.TextNombre = TextNombre;
        this.TextCedula = TextCedula;
        this.TextDireccion = TextDireccion;
        this.TextTelefono = TextTelefono;
        this.TextCorreo = TextCorreo;
        this.TextCargo = TextCargo;
        this.TextUsuario = TextUsuario;
        this.TextClave = TextClave;
        this.TextEspecialidad = TextEspecialidad;
        this.TextObservaciones=TextObservaciones;
       
        this.Error_Nombre = Error_Nombre;
        this.Error_Cedula = Error_Cedula;
        this.Error_Correo = Error_Correo;
        this.Error_Usuario= Error_Usuario;
        this.Error_Telefono=Error_Telefono;
        this.Error_Direccion= Error_Direccion;
        this.Error_Especialidad=Error_Especialidad;
       
        this.ListTel = ListTel;
    }
        
    public ControladorGOdontologo(JTable TablaOdontologos){
        this.TablaOdontologos=TablaOdontologos;
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
    public void Limpiar(){
        TextNombre.setText("");
        TextCedula.setText("");
        TextTelefono.setText("");
        TextDireccion.setText("");
        TextUsuario.setText("");
        TextClave.setText("");
        TextObservaciones.setText("");
        TextCorreo.setText("");
        TextEspecialidad.setText("");
        Error_Nombre.setText("");
        Error_Cedula.setText("");
        Error_Correo.setText("");
        Error_Telefono.setText("");
        Error_Direccion.setText("");
        Error_Especialidad.setText("");
        Error_Usuario.setText("");
    }
    
    public boolean AgregarOdontologo(){
        boolean a=false;
        int  validacion = 0;
        String nombre,telefono,cedula,direccion, correo,observaciones, usuario, clave, especialidad;
        
        nombre = TextNombre.getText().trim();
        cedula = TextCedula.getText().trim();
        telefono = ListTel.getSelectedItem().toString().trim()+TextTelefono.getText().trim();
        direccion = TextDireccion.getText().trim();
        correo = TextCorreo.getText().trim();
        usuario = TextUsuario.getText().trim();
        clave = TextClave.getText().trim();
        especialidad = TextEspecialidad.getText().trim();
        observaciones = TextObservaciones.getText().trim();
        //tipo_cmb = cmbx_cliente.getSelectedIndex()+1; //Se le suma uno para trabajar contando a partir de 1 y no de 0.
        
        if(nombre.equals("")){
            TextNombre.setBackground(Color.red);
            validacion ++;
        }
        
        if(telefono.equals("")){
            TextTelefono.setBackground(Color.red);
            validacion ++;
        }
        
        if(cedula.equals("")){
            TextCedula.setBackground(Color.red);
            validacion ++;
        }
        
        if(direccion.equals("")){
            TextDireccion.setBackground(Color.red);
            validacion ++;
        }
        
        if(correo.equals("")){
            TextCorreo.setBackground(Color.red);
            validacion ++;
        }
        
        if(usuario.equals("")){
            TextUsuario.setBackground(Color.red);
            validacion ++;
        }
        
         if(clave.equals("")){
            TextClave.setBackground(Color.red);
            validacion ++;
        }
        
        if(especialidad.equals("")){
            TextEspecialidad.setBackground(Color.red);
            validacion ++;
        }
        
        if(observaciones.equals("")){
            TextObservaciones.setBackground(Color.red);
            validacion ++;
        }
      
        try {
            Connection cn = Conexion.conectarBD();
            PreparedStatement pst1 = cn.prepareStatement("select Cedula from odontologos where Cedula = '"+cedula+"'");
            ResultSet rs1 = pst1.executeQuery();
            
            PreparedStatement pstSec = cn.prepareStatement("select Cedula from secretarias where Cedula = '"+cedula+"'");
            ResultSet rs2 = pstSec.executeQuery();
            
            if(rs1.next() || rs2.next()){
                TextCedula.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "El número de cédula ingresado ya existe en la base de datos.","Odontólogo existente", JOptionPane.ERROR_MESSAGE);
                cn.close();
            }else{
                
                cn.close();
                
                if(validacion == 0){
                    
                    try {
                        Connection cn2 = Conexion.conectarBD();
                        PreparedStatement pst2 = cn2.prepareStatement("insert into odontologos values (?,?,?,?,?,?,?,?,?,?,?)");
                        
                        pst2.setString(1, nombre);
                        pst2.setString(2, cedula);
                        pst2.setString(3, direccion);
                        pst2.setString(4, telefono);
                        pst2.setString(5, correo);
                        pst2.setString(6, "Odontologo");
                        pst2.setString(7, usuario);
                        pst2.setString(8, clave);
                        pst2.setString(9, "No ha ingresado");
                        pst2.setString(10, especialidad);
                        pst2.setString(11, observaciones);
                        
                        
                        pst2.executeUpdate();
                        cn2.close();
                        JOptionPane.showMessageDialog(null, "Registro exitoso.");
                        
                        Limpiar();
                        a=true;
                        
                    } catch (SQLException e) {
                        System.err.println("Error en ingresar odontólogo."+e);
                        JOptionPane.showMessageDialog(null, "Error al ingresar odontólogo.");
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Se deben llenar todos los campos.");
                }
                
                
            }
            
        } catch (SQLException e) {
            System.err.println("Error en validar cédula del odontólogo."+e);
            JOptionPane.showMessageDialog(null, "Error en comparar cédula del odontólogo.");
        }
        return a;
    }
    
    public void LlenarArrayDocconBD(){
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
        LlenarArrayDocconBD();
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
    public void ConsultarOdontologo(String ci){
         try{
         Connection cn = Conexion.conectarBD();
         PreparedStatement pst = cn.prepareStatement("select * from odontologos where Cedula = '" + ci + "'");

         ResultSet rs = pst.executeQuery();
         String Telef="";
         if(rs.next()){
            
             TextNombre.setText(rs.getString("Nombre"));
             TextCedula.setText(rs.getString("Cedula"));
             TextDireccion.setText(rs.getString("Direccion"));
             TextCargo.setText(rs.getString("Cargo"));
             TextEspecialidad.setText(rs.getString("Especialidad"));
             Telef=rs.getString("Telefono").substring(4,11);
             TextTelefono.setText(Telef);
             TextUsuario.setText(rs.getString("Usuario"));
             TextCorreo.setText(rs.getString("Correo"));
             TextClave.setText(rs.getString("Clave"));
             TextObservaciones.setText(rs.getString("Observaciones"));
             String num=rs.getString("Telefono").substring(0, 4).trim();
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
         System.out.println("Error en cargar odontólogo" + e);
        // JOptionPane.showMessageDialog(null), "ESCRIBALE A ANDI");
     }

    }
    
    /*public boolean ModificarOdontologo(){
        boolean a= false;
        int permisos, estatus, validacion =0;
        String nombre, cargo, mail, telefono, ci, direccion, usuario, especialidad, clave, observaciones;

        cargo = TextCargo.getText().trim();
        mail = TextCorreo.getText().trim();
        nombre = TextNombre.getText().trim();
        ci = TextCedula.getText().trim();
        direccion = TextDireccion.getText().trim();
        telefono = TextTelefono.getText().trim();
        usuario = TextUsuario.getText().trim();
        especialidad = TextEspecialidad.getText().trim();
        clave = TextClave.getText().trim();
        observaciones = TextObservaciones.getText().trim();

        if(mail.equals("")){
            TextCorreo.setBackground(Color.red);
            validacion++;
        }
        if(nombre.equals("")){
            TextNombre.setBackground(Color.red);
            validacion++;
        }
        if(ci.equals("")){
            TextCedula.setBackground(Color.red);
            validacion++;
        }
        if(direccion.equals("")){
            TextDireccion.setBackground(Color.red);
            validacion++;
        }
        if(telefono.equals("")){
            TextTelefono.setBackground(Color.red);
            validacion++;
        }
        if(usuario.equals("")){
            TextUsuario.setBackground(Color.red);
            validacion++;
        }
        if(especialidad.equals("")){
            TextEspecialidad.setBackground(Color.red);
            validacion++;
        }
        if(clave.equals("")){
            TextClave.setBackground(Color.red);
            validacion++;
        }

        if(validacion==0){

            try {
                Connection cn2 = Conexion.conectarBD();
                String Ssql = "UPDATE odontologos SET Nombre= ?, Direccion= ?, Telefono= ?, Correo= ?, Usuario= ?, Clave= ?, Especialidad= ?, Observaciones= ? " + "WHERE Cedula = '" + ci + "'";
                PreparedStatement prest = cn2.prepareStatement(Ssql);

                prest.setString(1, nombre);
                prest.setString(2, direccion);
                prest.setString(3, telefono);
                prest.setString(4, mail);
                prest.setString(5, usuario);
                prest.setString(6, clave);
                prest.setString(7, especialidad);
                prest.setString(8, observaciones);

                prest.executeUpdate();

                cn2.close();
                JOptionPane.showMessageDialog(null, "Modificacion correcta");

            } catch (Exception e) {
                System.err.println("Error al Actualizar "+ e);
            }

        } else{
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
        return a;
    }*/
    
    public void ModificarOdontologo(){
        
        String cargo, nombre, ci, direccion, telefono, correo, usuario, especialidad, clave, observaciones;
        Odontologo od = new Odontologo();
                
        
        
        cargo = TextCargo.getText().trim();
        correo = TextCorreo.getText().trim();
        nombre = TextNombre.getText().trim();
        ci = TextCedula.getText().trim();
        direccion = TextDireccion.getText().trim();
        telefono = ListTel.getSelectedItem().toString().trim()+TextTelefono.getText().trim();
        usuario = TextUsuario.getText().trim();
        especialidad = TextEspecialidad.getText().trim();
        clave = TextClave.getText().trim();
        observaciones = TextObservaciones.getText().trim();
      
        if(JOptionPane.showConfirmDialog(null, "¿Seguro de que desea modificar al odontologo "+nombre+" C.I "+ci+" ?", "Confirmar Modificacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){ 
             if(od.ValidarCorreo(correo)== true && od.ValidarNombre(nombre)==true && od.ValidarTelefono(telefono)==true){
               
                 try{
                    Connection cn = Conexion.conectarBD();
                    String Ssql = "UPDATE odontologos SET Nombre= ?, Direccion= ?, Telefono= ?, Correo= ?, Usuario= ?, Clave= ?, Especialidad= ?, Observaciones= ? " + "WHERE Cedula = '" + ci + "'";
                    PreparedStatement pst2 = cn.prepareStatement(Ssql);
                    
                    pst2.setString(1, nombre);
                    pst2.setString(2, direccion);
                    pst2.setString(3, telefono);
                    pst2.setString(4, correo);
                    pst2.setString(5, usuario);
                    pst2.setString(6, clave);
                    pst2.setString(7, especialidad);
                    pst2.setString(8, observaciones);

                    
                    pst2.executeUpdate();
                    cn.close();
                    JOptionPane.showMessageDialog(null,"Se han guardado los cambios.");

                }catch (Exception e){
                    System.out.println("Error al actulizar la BD"+e);
                }
            }else{
                if(od.ValidarNombre(TextNombre.getText().trim())== false){
                    CrearFuentetoErrores(Error_Nombre);
                    Error_Nombre.setText("*Cumplir formato [(A)riel (M)ax]");
                }
                if(od.ValidarTelefono(telefono)== false){
                    CrearFuentetoErrores(Error_Telefono);
                    Error_Telefono.setText("*Debe tener 11 digitos");
                }
                if(od.ValidarCorreo(TextCorreo.getText().trim())== false){
                    CrearFuentetoErrores(Error_Correo);
                    Error_Correo.setText("*Debe cumplir con el formato nombre@correo.com");
                }               
                  
            }
        }
    
    }
    
    public boolean EliminarOdontologo(){
        boolean a=false;
        
         String ci= TextCedula.getText();
        String name_up= TextNombre.getText();
        if(  JOptionPane.showConfirmDialog(null, "¿Seguro de que desea eliminar al odontólogo "+name_up+" C.I "+ci+" ?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
           
            try {
                Connection cn = Conexion.conectarBD();
                String sql = "DELETE FROM odontologos WHERE Cedula = '" + ci + "'"; // le indico a quien debe borra pasandole la cedula
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.executeUpdate();
                cn.close();
                JOptionPane.showMessageDialog(null,"¡El odontólogo fue eliminado con éxito!");
                Limpiar();
                a=true;
            } catch (Exception e) {
                System.err.println("Error al eliminar al odontólogo de la tabla." + e);
                JOptionPane.showMessageDialog(null, "Debe estar activa la base de datos, ¡Contacte al administrador!");
            }
        }
        return a;
    }    
    
    
    
    
    }


