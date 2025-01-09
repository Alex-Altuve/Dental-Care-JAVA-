/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

import javax.swing.JComboBox;

import Modelo.Conexion;

import Modelo.Persona;
import Modelo.Secretaria;
import Modelo.Odontologo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javax.swing.JTable;


/**
 *
 * @author Alex Altuve
 */
public final class ControladorGPerfil {
    JTextField textNombre, textSexo,textCedula,textDireccion, textTelefono, textCorreo, textCargo, textUsuario, textClave, textEspecialidad, txtObservaciones,textEdad; 
    JTextField Error_Nombre, Error_Cedula, Error_Correo, Error_Especialidad, Error_Edad, Error_Usuario, Error_Telefono;
    JComboBox ListTel, CbCargo;

///////////////////////////    
    JTable TablaPerfiles;
   /////////////////////////////         
    ArrayList<Persona> Perfiles = new ArrayList<>();
  
  /////////////////////////////
    
  
    public ControladorGPerfil() {
   
    }

 
    /////////////////////PERFIL///////////////////////////////////////////////
    public ControladorGPerfil(JTextField Nombre, JTextField Cedula, JTextField Direccion, JTextField Telefono, JTextField Correo, JTextField textCargo, JTextField Usuario, JTextField Clave,JTextField Error_Nombre, JTextField Error_Cedula, JTextField Error_Correo, JComboBox listTel, JTextField Error_Usuario,JTextField Error_Telefono){
        this.textNombre = Nombre;
        this.textCedula = Cedula;
        this.textDireccion = Direccion;
        this.textTelefono = Telefono;
        this.textCorreo = Correo;
        this.textCargo = textCargo;
        this.textUsuario = Usuario;
        this.textClave = Clave;
        
        this.Error_Nombre = Error_Nombre;
        this.Error_Cedula = Error_Cedula;
        this.Error_Correo = Error_Correo;
        this.Error_Usuario= Error_Usuario;
        this.Error_Telefono=Error_Telefono;
        
        this.ListTel = listTel;
    }
    
    ///////GESTION PERFIL///////////////////////////////

    public ControladorGPerfil(JTextField textNombre, JTextField textCedula, JTextField textDireccion, JTextField textTelefono, JTextField textCorreo, JComboBox CbCargo, JTextField textUsuario, JTextField textClave, JTextField Error_Nombre, JTextField Error_Cedula, JTextField Error_Correo, JComboBox ListTel, JTextField Error_Usuario, JTextField Error_Telefono) {
        this.textNombre = textNombre;
        this.textCedula = textCedula;
        this.textDireccion = textDireccion;
        this.textTelefono = textTelefono;
        this.textCorreo = textCorreo;
        this.textUsuario = textUsuario;
        this.textClave = textClave;
        
        this.Error_Nombre = Error_Nombre;
        this.Error_Cedula = Error_Cedula;
        this.Error_Correo = Error_Correo;
        this.Error_Usuario = Error_Usuario;
        this.Error_Telefono=Error_Telefono;
          
        this.ListTel = ListTel;
        this.CbCargo = CbCargo;
    }
    
    
//////////////////Métodos de control///////////////////////
    
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
    public boolean VerificarVaciosText(){
         return "".equals(textUsuario.getText()) || "".equals(textTelefono.getText()) || "".equals(textNombre.getText()) || "".equals(textCedula.getText()) || "".equals(textDireccion.getText()) || "".equals(textCorreo.getText()) || "".equals(textClave.getText());
    }
    
    
 /////////////Metodos de RegistrarPerfilN//////////////////  
    
    
    
    public void LLenarCamposErrores(Persona Per){  
    /// Metodo para llenar los campos que denominamos errores... para que al momento que se identifique 
    //se mostrara en letras rojas debajo del campo con el error un error en alguno de esos campos,

        String Partenum=ListTel.getSelectedItem().toString().trim()+textTelefono.getText().trim();
        LlenarArrayLisUsuariosconBD();
        if(Per.ValidarNombre(textNombre.getText().trim())== false){
            CrearFuentetoErrores(Error_Nombre);
            Error_Nombre.setText("*Cumplir formato [(A)riel (M)ax]");
          
        }
        if(Per.ValidarCedula(textCedula.getText().trim())== false){
            CrearFuentetoErrores(Error_Cedula);
            Error_Cedula.setText("*Numeros entre 6 y 8 digitos");
           
        }
        if(Per.ValidarTelefono(Partenum)== false){
            CrearFuentetoErrores(Error_Telefono);
            Error_Telefono.setText("*Debe tener 7 digitos");
           
        }
        if(Per.ValidarCorreo(textCorreo.getText().trim())== false){
            CrearFuentetoErrores(Error_Correo);
            Error_Correo.setText("*Debe cumplir con el formato nombre@correo.com");
          
        }
        if(Per.ValidarCedulaRep(Perfiles,textCedula.getText().trim())== true){
            CrearFuentetoErrores(Error_Cedula);
            Error_Cedula.setText("*Cedula ya registrada");
           
        }
        if(Per.ValidarUsuario(Perfiles, textUsuario.getText().trim())== true ){
            CrearFuentetoErrores(Error_Usuario);
            Error_Usuario.setText("*Usuario ya registrado, intente con otro");
           
        }

    }
    

    public void VaciarDatos(){
        ListTel.setSelectedIndex(0);
        
   
        textNombre.setText("");
        textCedula.setText(""); 
        textDireccion.setText(""); 
        textTelefono.setText(""); 
        textCorreo.setText("");        
        textUsuario.setText(""); 
        textClave.setText(""); 
        
        Error_Nombre.setText("");
        Error_Correo.setText("");
        Error_Cedula.setText("");
        Error_Usuario.setText("");
        Error_Telefono.setText("");
    }
    public void InsertarUsuarioBDSecretaria(Secretaria sec){
        /// Ingresa al usuario en la base de datos
        try {
            Connection cn = Conexion.conectarBD();
            Statement stm= (Statement) cn.createStatement();

            String Nombre= sec.getNombre();
            String Cedula= sec.getCedula();
            String Telefono= sec.getTelefono();
            String Correo=sec.getCorreo();
            String Cargo=sec.getCargo();
            String Direccion= sec.getDireccionC();
            String Usuario=sec.getUser();
            String Clave= sec.getClave();
            String Fecha_Ingreso= sec.getFechaIngreso();
        
            String insert="INSERT INTO secretarias VALUES('"+Nombre+"','"+Cedula+"','"+Direccion+"','"+Telefono+"','"+Correo+"','"+Cargo+"','"+Usuario+"','"+Clave+"','"+Fecha_Ingreso+"');";
         
            stm.executeUpdate(insert);
            cn.close();
            JOptionPane.showMessageDialog(null, "Registro exitoso.");
        }catch(SQLException e) {
             System.err.println("Error al ingresarlo en la BD " + e);
             JOptionPane.showMessageDialog(null, "¡Contacte al administrador!");
        }
        
    }
        
    public boolean RegistrarPerfil(){ // se modifico
        boolean a=false;
        LlenarArrayLisUsuariosconBD();
       
       if (VerificarVaciosText() !=true && ListTel.getSelectedIndex()!=0){
           Secretaria sec = new Secretaria(); 
           String Partenum=ListTel.getSelectedItem().toString().trim()+textTelefono.getText().trim();  /// une el combo box lista de numeros y el text field telefono
                     
           if(sec.ValidarDatosIngresado(textCedula.getText().trim(), textCorreo.getText().trim(), textNombre.getText().trim(),Partenum.trim() )== true && sec.ValidarCedulaRep(Perfiles, textCedula.getText().trim())==false && sec.ValidarUsuario(Perfiles, textUsuario.getText().trim())==false ){
             
                sec.IngresarDatos(textDireccion.getText().trim(), textCedula.getText().trim(), textNombre.getText().trim(), Partenum, textCorreo.getText().trim(), "Secretaria", textUsuario.getText().trim(), textClave.getText().trim()); 
                InsertarUsuarioBDSecretaria(sec);              
                VaciarDatos();
                a=true;
            }else{              
                LLenarCamposErrores(sec);
            }
       }else{
            JOptionPane.showMessageDialog(null, "Se deben llenar y seleccionar todos los campos","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
       }            
       return a;
    }
    
//////////////////METODOS GESTION PERFIL /////////////////////////////////////////
    

 public void  LlenarArrayLisUsuariosconBD(){
      //Metodo para tener un control de los usuario (este lee de la base de datos todos lo usuarios 
      // y los agregar a un arraylist (Perfiles) que se encuentra al inicio de esta clase para
      //asi poder verfiicar que ninla cedula ni el suario se repitan desde la clase perfil (solo para no dejarla sin metodos)
      // ademas de ue se necetita una lista para poder llenar las tablas
      
      try{
            Connection cn = Conexion.conectarBD();
            Perfiles.clear();
            Statement pst = cn.createStatement();
            ResultSet rs= pst.executeQuery("SELECT * FROM secretarias");
            String datos[]= new String[9]; 
            
            while (rs.next()) {
                Secretaria sec = new Secretaria();
                datos[0]=rs.getString(1); //nombre
                datos[1]=rs.getString(2); //cedula 
                datos[2]=rs.getString(3); //direccion
                datos[3]=rs.getString(4); //telefono
                datos[4]=rs.getString(5); //correo
                datos[5]=rs.getString(6); //cargo
                datos[6]=rs.getString(7); //usuario
                datos[7]=rs.getString(8); //clave
                datos[8]=rs.getString(9); //fecha ingreso
                
                sec.IngresarDatos(datos[2], datos[1],datos[0], datos[3], datos[4], datos[5], datos[6], datos[7]);
                sec.setFechaIngreso(datos[8]);
                Perfiles.add(sec);
            }
         
            Statement st = cn.createStatement();
           
            ResultSet res= st.executeQuery("SELECT * FROM odontologos");
            
            String info[]= new String[12]; 
            
            while (res.next()) {
                Odontologo doc = new Odontologo();
                info[0]=res.getString(1); 
                info[1]=res.getString(2);
                info[2]=res.getString(3);
                info[3]=res.getString(4); 
                info[4]=res.getString(5); 
                info[5]=res.getString(6); 
                info[6]=res.getString(7); 
                info[7]=res.getString(8); 
                info[8]=res.getString(9); 
                info[9]=res.getString(10); //especialidad
                info[10]=res.getString(11); // observaciones
              
                doc.IngresarDatos(info[2], info[1],info[0], info[3], info[4], info[5], info[6], info[7], info[9],  info[10]);
                doc.setFechaIngreso(info[8]);
                Perfiles.add(doc);
            }
            cn.close();
        }catch(Exception e){
           
            System.err.println("Error al llenar arraylist." + e);
             JOptionPane.showMessageDialog(null, "Debe estara ctivo la base de datos, ¡Contacte al administrador!");
        }   
    }
 


public boolean EliminarUsuario(String Cedula, String Cargo){
    boolean a=false;
    if(  JOptionPane.showConfirmDialog(null, "¿Seguro de que desea eliminar su perfil C.I "+Cedula+"? \n(Esta acción no se podrá deshacer)", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
        a=true;
        if ("Secretaria".equals(Cargo)) {
            try {
                Connection cn = Conexion.conectarBD();
                String sql = "DELETE FROM secretarias WHERE Cedula= "+Cedula; // le indico a quien debe borra pasandole la cedula
                PreparedStatement ps = cn.prepareStatement(sql);

                if(ps.executeUpdate()>0){
                    cn.close();
                    JOptionPane.showMessageDialog(null, "Eliminacion exitosa ");  
                }   

            } catch (Exception e) {
               System.err.println("Error al eliminar al usuario de la tabla." + e);
               JOptionPane.showMessageDialog(null, "Debe estara ctivo la base de datos, ¡Contacte al administrador!");
            }            
        } else {
            try {
                Connection cn = Conexion.conectarBD();
                String sql = "DELETE FROM odontologos WHERE Cedula= "+Cedula; // le indico a quien debe borra pasandole la cedula
                PreparedStatement ps = cn.prepareStatement(sql);
                if(ps.executeUpdate()>0){
                cn.close();
                JOptionPane.showMessageDialog(null, "Eliminacion exitosa ");  
                } 
            } catch (Exception e) {
               System.err.println("Error al eliminar al usuario de la tabla." + e);
               JOptionPane.showMessageDialog(null, "Debe estara ctivo la base de datos, ¡Contacte al administrador!");
            } 
        }
         
                            
    }
     return a;
}
 
public void ConsultarPerfil(String Cedula,String Cargo){
  

        Persona per = new Persona();
        if ("Secretaria".equals(Cargo)) {
            try {
                Connection cn = Conexion.conectarBD();
                Statement pst = cn.createStatement();
                ResultSet rs= pst.executeQuery("SELECT * FROM secretarias WHERE Cedula= "+Cedula);
                String datos[]= new String[9]; 

                while (rs.next()) {

                    datos[0]=rs.getString(1); //nombre
                    datos[1]=rs.getString(2);//cedula
                    datos[2]=rs.getString(3);//direccion
                    datos[3]=rs.getString(4); //telefono
                    datos[4]=rs.getString(5); //correo
                    datos[5]=rs.getString(6); //cargo
                    datos[6]=rs.getString(7); //usuario
                    datos[7]=rs.getString(8); //clave
                    datos[8]=rs.getString(9); //fecha_ingreso
                    per.IngresarDatos(datos[2], datos[1],datos[0], datos[3], datos[4], datos[5], datos[6], datos[7]);
                    per.setFechaIngreso(datos[8]);
                }  
                cn.close();
            } catch (Exception e) {
                System.err.println("Error al consultar al usuario de la tabla." + e);
                JOptionPane.showMessageDialog(null, "Debe estara ctivo la base de datos, ¡Contacte al administrador!");
            }
        } else {
            try {
                Connection cn = Conexion.conectarBD();
                Statement pst = cn.createStatement();
                ResultSet rs= pst.executeQuery("SELECT * FROM odontologos WHERE Cedula= "+Cedula);
                String datos[]= new String[9]; 

                while (rs.next()) {

                    datos[0]=rs.getString(1); //nombre
                    datos[1]=rs.getString(2);//cedula
                    datos[2]=rs.getString(3);//direccion
                    datos[3]=rs.getString(4); //telefono
                    datos[4]=rs.getString(5); //correo
                    datos[5]=rs.getString(6); //cargo
                    datos[6]=rs.getString(7); //usuario
                    datos[7]=rs.getString(8); //clave
                    datos[8]=rs.getString(9); //fecha_ingreso
                    per.IngresarDatos(datos[2], datos[1],datos[0], datos[3], datos[4], datos[5], datos[6], datos[7]);
                    per.setFechaIngreso(datos[8]);
                }    
                cn.close();
            } catch (Exception e) {
                System.err.println("Error al consultar al usuario de la tabla." + e);
                JOptionPane.showMessageDialog(null, "Debe estar activo la base de datos, ¡Contacte al administrador!");
            }             
        }
        textNombre.setText(per.getNombre()) ;
        textCedula.setText(per.getCedula()) ;
        textDireccion.setText(per.getDireccionC());
        String num=per.getTelefono().substring(0, 4).trim();
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
        textTelefono.setText(per.getTelefono().substring(4, 11)) ;
        textCorreo.setText(per.getCorreo()) ;
        textUsuario.setText(per.getUser()) ;
        textClave.setText(per.getClave()) ; 
        if ("Secretaria".equals(per.getCargo())) {
            CbCargo.setSelectedIndex(1);
        } else {
            CbCargo.setSelectedIndex(2);
        }        
        
        
        
 
}

 public void ModificarPerfil(String Cedula, String Cargo){  
     try {
        Connection cn = Conexion.conectarBD();
        if (VerificarVaciosText() !=true && ListTel.getSelectedIndex()!=0){
           Persona per = new Persona(); 
           String Partenum=ListTel.getSelectedItem().toString().trim()+textTelefono.getText().trim();  /// une el combo box lista de numeros y el text field telefono

           if(per.ValidarDatosIngresado(textCedula.getText().trim(), textCorreo.getText().trim(), textNombre.getText().trim(),Partenum.trim() )== true && per.ValidarUsuario(Perfiles, textUsuario.getText().trim())==false ){
                if(  JOptionPane.showConfirmDialog(null, "¿Seguro de que desea modificar su perfil C.I "+Cedula+" ?", "Confirmar Modificacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){             
                    ///////////////////////////////
                    if ("Secretaria".equals(Cargo)) {
                        String Ssql = "UPDATE secretarias SET Nombre= ?, Direccion= ?, Telefono= ?, Correo= ?, Usuario= ?, Clave= ? "+" WHERE Cedula= ?";
                        PreparedStatement prest = cn.prepareStatement(Ssql);

                        prest.setString(1, textNombre.getText().trim());
                        prest.setString(2, textDireccion.getText().trim());
                        prest.setString(3, Partenum);
                        prest.setString(4, textCorreo.getText().trim());
                        prest.setString(5, textUsuario.getText().trim());
                        prest.setString(6, textClave.getText().trim());
                        prest.setString(7, Cedula);

                        prest.executeUpdate();
                        cn.close();
                        ///////////////////////////////////
                        VaciarDatos();
                    } else {
                        String Ssql = "UPDATE odontologos SET Nombre= ?, Direccion= ?, Telefono= ?, Correo= ?, Usuario= ?, Clave= ? "+" WHERE Cedula= ?";
                        PreparedStatement prest = cn.prepareStatement(Ssql);

                        prest.setString(1, textNombre.getText().trim());
                        prest.setString(2, textDireccion.getText().trim());
                        prest.setString(3, Partenum);
                        prest.setString(4, textCorreo.getText().trim());
                        prest.setString(5, textUsuario.getText().trim());
                        prest.setString(6, textClave.getText().trim());
                        prest.setString(7, Cedula);

                        prest.executeUpdate();
                        cn.close();
                        ///////////////////////////////////
                        VaciarDatos();
                    }

                }
            }else{              
                LLenarCamposErrores(per);
           }    
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar Consultar antes de modificar","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }   
                
         
    }catch(Exception e){
        System.err.println("Error al actualizar la tabla." + e);
        JOptionPane.showMessageDialog(null, "Debe estar activo la base de datos, ¡Contacte al administrador!");
    }
 }
 ///////////////////METODO LOGIN//////////////////////  
    public int Logueo(String Usuario, String Clave){
        LlenarArrayLisUsuariosconBD();
      
        if(Perfiles.isEmpty() == false){        
        
            for(int i=0; i< Perfiles.size(); i++){
              
                if(Perfiles.get(i).getClave().trim().equals(Clave.trim()) && Perfiles.get(i).getUser().trim().equals(Usuario.trim())){                  
                    return 1;
                } else if (Perfiles.get(i).getUser().trim().equals(Usuario.trim())){
                    return 2;
                } else if (Perfiles.get(i).getClave().trim().equals(Clave.trim())){
                    return 3;
                }  
                         
            }
    
        }
        return 4;
    }
   
    
    public String CedulaCargo(String Usuario, String Clave){
       String CedGlobal, NomGlobal,Nombre;
        LlenarArrayLisUsuariosconBD();
        if(Perfiles.isEmpty() == false){        
        
            for(int i=0; i< Perfiles.size(); i++){
              
                if(Perfiles.get(i).getClave().trim().equals(Clave.trim()) && Perfiles.get(i).getUser().trim().equals(Usuario.trim())){                  
                    CedGlobal=Perfiles.get(i).getCedula().trim();
                    NomGlobal=Perfiles.get(i).getCargo().trim();
                    Nombre=Perfiles.get(i).getNombre().trim();
                    String nom=CedGlobal+"-"+NomGlobal+"-"+Nombre;
                    return nom;
                }
            }
        }
        return null;
    }
    public void ActualizarFechaIngreso(String Usuario){
        try {
            Connection cn = Conexion.conectarBD();
            LocalDate fecha = LocalDate.now();
          
            String Ssql = "UPDATE secretarias SET Fecha_Ingreso= ?"+" WHERE Usuario= ?";
            PreparedStatement prest = cn.prepareStatement(Ssql);
            
            prest.setString(1, fecha.toString().trim());
            prest.setString(2, Usuario);
            prest.executeUpdate();
            //////////
            String Sql = "UPDATE odontologos SET Fecha_Ingreso= ?"+" WHERE Usuario= ?";
            PreparedStatement prst = cn.prepareStatement(Sql);
            
            prst.setString(1, fecha.toString().trim());
            prst.setString(2, Usuario);
            prst.executeUpdate();
            cn.close();
        }catch(Exception e){
             System.err.println("Error al actualizar la tabla." + e);
             JOptionPane.showMessageDialog(null, "Debe estara ctivo la base de datos, ¡Contacte al administrador!");
        }
    }
    
    
    
    } 
    


