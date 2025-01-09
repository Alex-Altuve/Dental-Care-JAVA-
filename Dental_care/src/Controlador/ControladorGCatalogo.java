/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Conexion;
import Modelo.ServiciosOdontologicos;
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
 * @author Yustin Chacon
 */
public class ControladorGCatalogo {
    JTextField textNombre,textPrecio,textDescripcion; 
    JTextField Error_Nombre, Error_Precio;
    JTable TablaServicios;
    ///////////////////////////////
    ArrayList<ServiciosOdontologicos> Servicios = new ArrayList<>();
   
    
    
    //////////Registrar Pacientes///
    public ControladorGCatalogo(JTextField textNombre, JTextField textPrecio, JTextField textDescripcion, JTextField Error_Nombre, JTextField Error_Precio) {
        this.textNombre = textNombre;
        this.textPrecio = textPrecio;
        this.textDescripcion = textDescripcion;
        this.Error_Nombre = Error_Nombre;
        this.Error_Precio = Error_Precio;        
    }
    
    //////GESTION PACIENTES ////////
    public ControladorGCatalogo(JTable TablaServicios) {
        this.TablaServicios = TablaServicios;
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
    
    public boolean VerificarVaciosTextServ(){
         return  ("".equals(textNombre.getText()) || "".equals(textPrecio.getText())) ;
    }
   ////////////////////////////////////////////////////////////////
   public void VaciarDatos(){
        textNombre.setText("");
        textPrecio.setText("");
        textDescripcion.setText("");
        
        Error_Nombre.setText("");
        Error_Precio.setText("");        
   }
   
    public boolean RegistrarServicio(){ 
        boolean a= false;
        //LlenarArrayListServiciosconBD();
        ServiciosOdontologicos serv = new ServiciosOdontologicos();
        if (VerificarVaciosTextServ() !=true){                     
                     
           if(serv.ValidarDatosIngresado(textNombre.getText().trim(), Float.parseFloat(textPrecio.getText().trim()))){
               
                serv.ingresarDatos(textNombre.getText().trim(), Float.parseFloat(textPrecio.getText().trim()), textDescripcion.getText().trim()); 
                InsertarUsuarioBDServicio(serv);               
                VaciarDatos();   
                a=true;
            }else{              
                LLenarCamposErroresServ(serv);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se puede agregar el servicio si hay campos vacios o no seleccionados","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            if(serv.validarNombre(textNombre.getText().trim())== false){
                CrearFuentetoErrores(Error_Nombre);
                Error_Nombre.setText("*El campo no puede estar vacío");
            }        
            if(serv.validarPrecio(textPrecio.getText().trim())==false){
                CrearFuentetoErrores(Error_Precio);
                Error_Precio.setText("*El campo no puede estar vacío");
            }
        }       
        return a;
    }
    
     public void LLenarCamposErroresServ(ServiciosOdontologicos serv){  
    
        LlenarArrayListServiciosconBD();
        if(serv.validarNombre(textNombre.getText().trim())== false){
            CrearFuentetoErrores(Error_Nombre);
            Error_Nombre.setText("*No pueden haber caracteres especiales en el nombre");
        }        
        if(serv.validarPrecio(textPrecio.getText().trim())==false){
            CrearFuentetoErrores(Error_Precio);
            Error_Precio.setText("*El precio ha de ser un valor numerico");
        }  
    }
    
    
  public void InsertarUsuarioBDServicio(ServiciosOdontologicos serv){
      String Nombre= serv.getNombre();
      String Precio= Float.toString(serv.getPrecio());
      String Descripcion= serv.getDescripcion();      
      
        try {
            Connection cn = Conexion.conectarBD();
            PreparedStatement pst1 = cn.prepareStatement("select Nombre from servicios where Nombre = '"+Nombre+"'");
            ResultSet rs1 = pst1.executeQuery();          
            
            if(rs1.next()){
                textNombre.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "El nombre del servicio ingresado ya existe en la base de datos.","Servicio existente", JOptionPane.ERROR_MESSAGE);
                cn.close();
            }
            else{
                cn.close();
                Connection cn2 = Conexion.conectarBD();
                Statement stm= (Statement) cn2.createStatement();

                
        
                String insert="INSERT INTO servicios VALUES('"+Nombre+"','"+Precio+"','"+Descripcion+"');";
         
                stm.executeUpdate(insert);
                cn2.close();
                JOptionPane.showMessageDialog(null, "Registro exitoso.");}
        }catch(SQLException e) {
             System.err.println("Error al ingresarlo en la BD " + e);
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
    
    public void ConsultarSC(String Nombre){
       
        try{   
             Connection cn = Conexion.conectarBD();
             PreparedStatement pst = cn.prepareStatement("select * from servicios where Nombre = '" + Nombre + "'");

             ResultSet rs = pst.executeQuery();             
             
             if(rs.next()){

                textNombre.setText(rs.getString("Nombre"));
                textPrecio.setText(rs.getString("Precio"));
                textDescripcion.setText(rs.getString("Descripcion"));                
             }

            cn.close();
        }catch(Exception e){
             System.out.println("Error en cargar servicio " + e);

        }
    }
    
    public void LLenarTablaServicios(){
        
        LlenarArrayListServiciosconBD();
        String[] columna = {"Nombre","Precio", "Descripcion"}; // se modifico
        TablaServicios.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel dtm = new DefaultTableModel(null, columna){
          @Override
          public boolean isCellEditable(int row, int column){
              return false; 
          }
        };  
        for (int i=0; i<Servicios.size(); i++) { 
           String[] row = {Servicios.get(i).getNombre(), Float.toString(Servicios.get(i).getPrecio()), Servicios.get(i).getDescripcion()};
           dtm.addRow(row);
        }
        TablaServicios.setModel(dtm); 

       
    }
    
    /////Eliminar y Modificar
    public boolean EliminarServicio(){        
        String name=textNombre.getText();
        boolean a=false;
        if(JOptionPane.showConfirmDialog(null, "¿Seguro de que desea eliminar el servicio "+name+" ?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){ 
            a=true;
            try {
                Connection cn = Conexion.conectarBD();
                String sql = "DELETE FROM servicios WHERE Nombre = '" + name + "'"; // le indico cual debe borra pasandole el nombre
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.executeUpdate();
                cn.close();
                VaciarDatos();
                JOptionPane.showMessageDialog(null,"¡El servicio fue eliminado satisfactoriament!");
           
            } catch (Exception e) {
               System.err.println("Error al eliminar el servicio de la tabla." + e);
               JOptionPane.showMessageDialog(null, "Debe estar activa la base de datos, ¡Contacte al administrador!");
            }
        }   
        return a;  
    }
    public void ModificarServicio(String nameOriginal){              
        String nombre, precio, descripcion;
        ServiciosOdontologicos serv= new ServiciosOdontologicos();
        
        nombre = textNombre.getText().trim();
        precio = textPrecio.getText().trim();        
        descripcion = textDescripcion.getText().trim();       
      
        if(JOptionPane.showConfirmDialog(null, "¿Seguro de que desea modificar el servicio "+nameOriginal+" ?", "Confirmar Modificacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){ 
            if (VerificarVaciosTextServ() !=true){
                if(serv.validarNombre(nombre)==true && serv.validarPrecio(precio)==true){
               
                 try{
                    Connection cn = Conexion.conectarBD();
                    String Ssql = "UPDATE servicios SET Nombre= ?, Precio= ?, Descripcion= ? " + "WHERE Nombre = '" + nameOriginal + "'";
                    PreparedStatement pst2 = cn.prepareStatement(Ssql);

                    pst2.setString(1,nombre);
                    pst2.setString(2, precio);
                    pst2.setString(3,descripcion );
                    
                    pst2.executeUpdate();
                    cn.close();
                    JOptionPane.showMessageDialog(null,"Se han guardado los cambios.");

                }catch (Exception e){
                    System.out.println("Error al actulizar la BD"+e);
                }
            }else{
                if(serv.validarNombre(textNombre.getText().trim())== false){
                    CrearFuentetoErrores(Error_Nombre);
                    Error_Nombre.setText("*No se aceptan caracteres especiales");
                }
                if(serv.validarPrecio(precio)== false){
                    CrearFuentetoErrores(Error_Precio);
                    Error_Precio.setText("*Formato: '4.00'");
                }
                                                 
            }}else{
                JOptionPane.showMessageDialog(null, "No se puede modificar el servicio si hay campos vacios o no seleccionados","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                if(serv.validarNombre(textNombre.getText().trim())== false){
                    CrearFuentetoErrores(Error_Nombre);
                    Error_Nombre.setText("*El campo no puede estar vacío");
                }        
                if(serv.validarPrecio(textPrecio.getText().trim())==false){
                    CrearFuentetoErrores(Error_Precio);
                    Error_Precio.setText("*El campo no puede estar vacío");
                }
            }
        }
    
    }
    
    /*
        try{   
             Connection cn = Conexion.conectarBD();
             PreparedStatement pst = cn.prepareStatement("select * from servicios where Nombre = '" + Nombre + "'");

             ResultSet rs = pst.executeQuery();             
             
             if(rs.next()){

                textNombre.setText(rs.getString("Nombre"));
                textPrecio.setText(rs.getString("Precio"));
                textDescripcion.setText(rs.getString("Descripcion"));                
             }

            cn.close();
        }catch(Exception e){
             System.out.println("Error en cargar servicio " + e);

        }
    */
}
