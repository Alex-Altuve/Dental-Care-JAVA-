
package Controlador;

import Modelo.Conexion;
import Modelo.Historia;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author sofiaarasme
 */

public class ControladorGHistoriaM {
    JTextField textNombre, Txt_Cedula, textEdad, textSexo, textTelefono, textDireccion, textObservaciones, Txt_NomContacto,Txt_TelContacto, Txt_Parentesco, Txt_Especificacion1, Txt_Especificacion2, Txt_Especificacion3, Txt_Especificacion4, Txt_Especificacion5, Txt_Especificacion6, Txt_Habito, Txt_Motivo;
    JTextPane  Txt_Otras_Obs;
    JRadioButton RB1, RB11, RB2, RB22, RB3, RB33, RB4, RB44, RB5, RB55, RB6, RB66, RB7, RB77, RB8, RB88, RB9, RB99, RBA, RBAA, RBB, RBBB;
    JCheckBox check_boca, check_cara, check_cuello, check_ortodoncia, check_cirugia, check_periodoncia, check_implantes, check_endodoncia, check_restauracion;
    ButtonGroup buttonGroup1, buttonGroup10, buttonGroup11, buttonGroup2, buttonGroup3, buttonGroup4, buttonGroup5, buttonGroup6, buttonGroup7, buttonGroup8, buttonGroup9;
    ArrayList<Historia> Historias = new ArrayList<>();
     
   

    public ControladorGHistoriaM(JTextField textNombre, JTextField Txt_Cedula, JTextField textEdad, JTextField textSexo, JTextField textTelefono, JTextField textDireccion, JTextField textObservaciones, JTextField Txt_NomContacto, JTextField Txt_TelContacto, JTextField Txt_Parentesco, JTextField Txt_Especificacion1, JTextField Txt_Especificacion2, JTextField Txt_Especificacion3, JTextField Txt_Especificacion4, JTextField Txt_Especificacion5, JTextField Txt_Especificacion6, JTextField Txt_Habito, JTextField Txt_Motivo, JRadioButton RB1, JRadioButton RB11, JRadioButton RB2, JRadioButton RB22, JRadioButton RB3, JRadioButton RB33, JRadioButton RB4, JRadioButton RB44, JRadioButton RB5, JRadioButton RB55, JRadioButton RB6, JRadioButton RB66, JRadioButton RB7, JRadioButton RB77, JRadioButton RB8, JRadioButton RB88, JRadioButton RB9, JRadioButton RB99, JRadioButton RBA, JRadioButton RBAA, JRadioButton RBB, JRadioButton RBBB,ButtonGroup buttonGroup1, ButtonGroup buttonGroup10, ButtonGroup buttonGroup11, ButtonGroup buttonGroup2, ButtonGroup buttonGroup3, ButtonGroup buttonGroup4, ButtonGroup buttonGroup5, ButtonGroup buttonGroup6, ButtonGroup buttonGroup7, ButtonGroup buttonGroup8, ButtonGroup buttonGroup9,JCheckBox check_boca, JCheckBox check_cara, JCheckBox check_cuello, JCheckBox check_ortodoncia, JCheckBox check_cirugia, JCheckBox check_periodoncia, JCheckBox check_implantes, JCheckBox check_endodoncia, JCheckBox check_restauracion, JTextPane Txt_Otras_Obs) {
        
        this.textNombre = textNombre;
        this.Txt_Cedula = Txt_Cedula;
        this.textEdad = textEdad;
        this.textSexo = textSexo;
        this.textTelefono = textTelefono;
        this.textDireccion = textDireccion;
        this.textObservaciones = textObservaciones;
        this.Txt_NomContacto = Txt_NomContacto;
        this.Txt_TelContacto = Txt_TelContacto;
        this.Txt_Parentesco = Txt_Parentesco;
        this.Txt_Especificacion1 = Txt_Especificacion1;
        this.Txt_Especificacion2 = Txt_Especificacion2;
        this.Txt_Especificacion3 = Txt_Especificacion3;
        this.Txt_Especificacion4 = Txt_Especificacion4;
        this.Txt_Especificacion5 = Txt_Especificacion5;
        this.Txt_Especificacion6 = Txt_Especificacion6;
        this.Txt_Habito = Txt_Habito;
        this.Txt_Motivo = Txt_Motivo;
        this.RB1 = RB1;
        this.RB11 = RB11;
        this.RB2 = RB2;
        this.RB22 = RB22;
        this.RB3 = RB3;
        this.RB33 = RB33;
        this.RB4 = RB4;
        this.RB44 = RB44;
        this.RB5 = RB5;
        this.RB55 = RB55;
        this.RB6 = RB6;
        this.RB66 = RB66;
        this.RB7 = RB7;
        this.RB77 = RB77;
        this.RB8 = RB8;
        this.RB88 = RB88;
        this.RB9 = RB9;
        this.RB99 = RB99;
        this.RBA = RBA;
        this.RBAA = RBAA;
        this.RBB = RBB;
        this.RBBB = RBBB;
        this.buttonGroup1 = buttonGroup1;
        this.buttonGroup2 = buttonGroup2;
        this.buttonGroup3 = buttonGroup3;
        this.buttonGroup4 = buttonGroup4;
        this.buttonGroup5 = buttonGroup5;
        this.buttonGroup6 = buttonGroup6;
        this.buttonGroup7 = buttonGroup7;
        this.buttonGroup8 = buttonGroup8;
        this.buttonGroup9 = buttonGroup9;
        this.buttonGroup10 = buttonGroup10;
        this.buttonGroup11 = buttonGroup11;
        this.check_boca = check_boca;
        this.check_cara = check_cara;
        this.check_cuello = check_cuello;
        this.check_ortodoncia = check_ortodoncia;
        this.check_cirugia = check_cirugia;
        this.check_periodoncia = check_periodoncia;
        this.check_implantes = check_implantes;
        this.check_endodoncia = check_endodoncia;
        this.check_restauracion = check_restauracion;
        this.Txt_Otras_Obs = Txt_Otras_Obs;

    }
    
      
    ///////////////////////////////////////////////////////////////
    
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
    
    ////////////////////////////////////////////////////////////////
    
    
    ////Metodo que devuelve el string de la opción seleccionada en un grupos de botones////
    public String SetStringRetornoRB(ButtonGroup group, JRadioButton RBOP1, JRadioButton RBOP2){

        String RetornoRB = "";
        group.add(RBOP1);
        group.add(RBOP2);
        
        if (RBOP1.isSelected()) {
            RetornoRB = "Si";
        } else if (RBOP2.isSelected()) {
            RetornoRB = "No";
        }
        return RetornoRB;
    }
    
    ////Método para registrar una nueva historia o modificar en caso de que ya exista////
    public void Registrar_GuardarHistoria(){   
      
           LlenarArrayListHistoriasconBD();
           Historia historia = new Historia();
           if(historia.ValidarHistoriaCreada(Historias, Txt_Cedula.getText().trim())== false){
               historia.CrearHistoria(Txt_Cedula.getText().trim(), Txt_NomContacto.getText().trim(), Txt_TelContacto.getText().trim() , Txt_Parentesco.getText().trim() , SetStringRetornoRB(buttonGroup1,RB1,RB11), Txt_Especificacion1.getText().trim(), SetStringRetornoRB(buttonGroup2, RB2, RB22), Txt_Especificacion2.getText().trim(), SetStringRetornoRB(buttonGroup3, RB3, RB33), Txt_Especificacion3.getText().trim(), SetStringRetornoRB(buttonGroup4, RB4, RB44), Txt_Especificacion4.getText().trim(), SetStringRetornoRB(buttonGroup5, RB5, RB55), Txt_Especificacion5.getText().trim(),  SetStringRetornoRB(buttonGroup6, RB6, RB66), Txt_Especificacion6.getText().trim(), SetStringRetornoRB(buttonGroup7, RB7, RB77), SetStringRetornoRB(buttonGroup8, RB8, RB88), SetStringRetornoRB(buttonGroup9, RB9, RB99), SetStringRetornoRB(buttonGroup10, RBA, RBAA), SetStringRetornoRB(buttonGroup11, RBB, RBBB), Txt_Habito.getText().trim(), Txt_Motivo.getText().trim(), check_boca.isSelected(), check_cara.isSelected(), check_cuello.isSelected(), check_ortodoncia.isSelected(), check_cirugia.isSelected(), check_periodoncia.isSelected(), check_implantes.isSelected(), check_endodoncia.isSelected(), check_restauracion.isSelected(),Txt_Otras_Obs.getText().trim()); 
               InsertarHistoriaEnBD(historia);
           }else{
               GuardarCambiosHistoriaEnBD(historia,Txt_Cedula.getText().trim()); 
           }         
    }
    
    public static int convertirCheckATinyInt(boolean checkbox){
        return checkbox ? 1 : 0;
    }
    
    public static boolean convertirIntABoolean(int numero){
        if(numero==0){
            return false;
        } else {
            return true;
        }
    }
    
    ////Método para llenar el arraylist de historias////
    public void  LlenarArrayListHistoriasconBD(){
     
      try{
            Connection cn = Conexion.conectarBD();
            Historias.clear();
            Statement pst = cn.createStatement();
            ResultSet rs= pst.executeQuery("SELECT * FROM historias");
            String datos[]= new String[24];
            int datos2[]= new int[9];
            
            while (rs.next()) {
                Historia his = new Historia();
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4); 
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6); 
                datos[6]=rs.getString(7); 
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
                datos[11]=rs.getString(12); 
                datos[12]=rs.getString(13);
                datos[13]=rs.getString(14); 
                datos[14]=rs.getString(15); 
                datos[15]=rs.getString(16); 
                datos[16]=rs.getString(17);
                datos[17]=rs.getString(18);
                datos[18]=rs.getString(19);
                datos[19]=rs.getString(20); 
                datos[20]=rs.getString(21);
                datos[21]=rs.getString(22); 
                datos[22]=rs.getString(23); 
                datos2[0]=rs.getInt(24);
                datos2[1]=rs.getInt(25);
                datos2[2]=rs.getInt(26);
                datos2[3]=rs.getInt(27);
                datos2[4]=rs.getInt(28);
                datos2[5]=rs.getInt(29);
                datos2[6]=rs.getInt(30);
                datos2[7]=rs.getInt(31);
                datos2[8]=rs.getInt(32);
                datos[23]=rs.getString(33); 
                his.CrearHistoria(datos[0], datos[1],datos[2], datos[3], datos[4], datos[5], datos[6], datos[7], datos[8], datos[9], datos[10], datos[11], datos[12], datos[13], datos[14], datos[15], datos[16], datos[17], datos[18], datos[19], datos[20], datos[21], datos[22], convertirIntABoolean(datos2[0]), convertirIntABoolean(datos2[1]), convertirIntABoolean(datos2[2]), convertirIntABoolean(datos2[3]), convertirIntABoolean(datos2[4]), convertirIntABoolean(datos2[5]), convertirIntABoolean(datos2[6]), convertirIntABoolean(datos2[7]), convertirIntABoolean(datos2[8]), datos[23]);
                Historias.add(his);
            }
         
        cn.close();
        }catch(Exception e){
           
            System.err.println("Error al llenar arraylist." + e);
             JOptionPane.showMessageDialog(null, "Debe estar activo la base de datos, ¡Contacte al administrador!");
        } 
    }
      
    
    ////Método para insertar la historia médica del paciente por primera vez////
    public void InsertarHistoriaEnBD(Historia historia){
        
        try {
            Connection cn = Conexion.conectarBD();
            Statement stm= (Statement) cn.createStatement();

            String cedula_paciente = historia.getCedula_paciente();
            String nombre_contacto = historia.getNombre_contacto();
            String telefono_contacto = historia.getTelefono_contacto();
            String parentesco_contacto = historia.getParentesco_contacto();
            String RB1 = historia.getRB1();
            String ESP1 = historia.getESP1();
            String RB2 = historia.getRB2();
            String ESP2 = historia.getESP2();
            String RB3 = historia.getRB3();
            String ESP3 = historia.getESP3();
            String RB4 = historia.getRB4();
            String ESP4 = historia.getESP4();
            String RB5 = historia.getRB5();
            String ESP5 = historia.getESP5();
            String RB6 = historia.getRB6();
            String ESP6 = historia.getESP6();
            String RB7 = historia.getRB7();
            String RB8 = historia.getRB8();
            String RB9 = historia.getRB9();
            String RBA = historia.getRBA();
            String RBB = historia.getRBB();
            String text_habito = historia.getText_habito();
            String text_motivo = historia.getText_motivo();
            boolean check_boca = historia.isCheck_boca();
            boolean check_cara = historia.isCheck_cara();
            boolean check_cuello = historia.isCheck_cuello();
            boolean check_ortodoncia = historia.isCheck_ortodoncia();
            boolean check_cirugia = historia.isCheck_cirugia();
            boolean check_periodoncia = historia.isCheck_periodoncia();
            boolean check_implantes = historia.isCheck_implantes();
            boolean check_endodoncia = historia.isCheck_endodoncia();
            boolean check_restauracion = historia.isCheck_restauracion();
            String text_otras_obs = historia.getText_otras_obs();
            
        
            String insert="INSERT INTO historias VALUES('"+cedula_paciente+"','"+nombre_contacto+"','"+telefono_contacto+"','"+parentesco_contacto+"','"+RB1+"','"+ESP1+"','"+RB2+"','"+ESP2+"','"+RB3+"','"+ESP3+"','"+RB4+"','"+ESP4+"','"+RB5+"','"+ESP5+"','"+RB6+"','"+ESP6+"','"+RB7+"','"+RB8+"','"+RB9+"','"+RBA+"','"+RBB+"','"+text_habito+"','"+text_motivo+"','"+convertirCheckATinyInt(check_boca)+"','"+convertirCheckATinyInt(check_cara)+"','"+convertirCheckATinyInt(check_cuello)+"','"+convertirCheckATinyInt(check_ortodoncia)+"','"+convertirCheckATinyInt(check_cirugia)+"','"+convertirCheckATinyInt(check_periodoncia)+"','"+convertirCheckATinyInt(check_implantes)+"','"+convertirCheckATinyInt(check_endodoncia)+"','"+convertirCheckATinyInt(check_restauracion)+"','"+text_otras_obs+"');";
         
            stm.executeUpdate(insert);
            cn.close();
            JOptionPane.showMessageDialog(null, "Historia guardada satisfactoriamente.");
        }catch(SQLException e) {
             System.err.println("Error al ingresar la Historia en la BD " + e);
             JOptionPane.showMessageDialog(null, "¡Contacte al administrador!");
        }
        
    }
    
    
    ////Método para guardar los cambios de la historia médica previamente creada de un paciente////
    public void GuardarCambiosHistoriaEnBD(Historia historia, String ci){
        
        try{
            
            Connection cn = Conexion.conectarBD();
            String Ssql = "UPDATE historias SET nombre_contacto = ?, telefono_contacto = ?, parentesco_contacto = ?, RB1 = ?, ESP1= ?, RB2= ?, ESP2= ?, RB3= ?, ESP3= ?, RB4= ?, ESP4= ?, RB5= ?, ESP5= ?, RB6= ?, ESP6= ?, RB7= ?, RB8= ?, RB9= ?, RBA= ?, RBB= ?, text_habito= ?, text_motivo= ?, check_boca= ?, check_cara= ?, check_cuello= ?, check_ortodoncia= ?, check_cirugia= ?, check_periodoncia= ?, check_implantes= ?, check_endodoncia= ?, check_restauracion= ?, text_otras_obs= ? " + "WHERE cedula_paciente = '" +ci+ "'";
            PreparedStatement pst2 = cn.prepareStatement(Ssql);

            pst2.setString(1, Txt_NomContacto.getText().trim());
            pst2.setString(2, Txt_TelContacto.getText().trim());
            pst2.setString(3,Txt_Parentesco.getText().trim());
            pst2.setString(4,SetStringRetornoRB(buttonGroup1, RB1, RB11));
            pst2.setString(5,Txt_Especificacion1.getText().trim());
            pst2.setString(6,SetStringRetornoRB(buttonGroup2, RB2, RB22));
            pst2.setString(7, Txt_Especificacion2.getText().trim());
            pst2.setString(8,SetStringRetornoRB(buttonGroup3, RB3, RB33));
            pst2.setString(9, Txt_Especificacion3.getText().trim());
            pst2.setString(10,SetStringRetornoRB(buttonGroup4, RB4, RB44));
            pst2.setString(11, Txt_Especificacion4.getText().trim());
            pst2.setString(12,SetStringRetornoRB(buttonGroup5, RB5, RB55));
            pst2.setString(13, Txt_Especificacion5.getText().trim());
            pst2.setString(14,SetStringRetornoRB(buttonGroup6, RB6, RB66));
            pst2.setString(15, Txt_Especificacion6.getText().trim());
            pst2.setString(16, SetStringRetornoRB(buttonGroup7, RB7, RB77));
            pst2.setString(17, SetStringRetornoRB(buttonGroup8, RB8, RB88));
            pst2.setString(18, SetStringRetornoRB(buttonGroup9, RB9, RB99));
            pst2.setString(19, SetStringRetornoRB(buttonGroup10, RBA, RBAA));
            pst2.setString(20, SetStringRetornoRB(buttonGroup11, RBB, RBBB));
            pst2.setString(21, Txt_Habito.getText().trim());
            pst2.setString(22, Txt_Motivo.getText().trim());
            pst2.setInt(23, convertirCheckATinyInt(check_boca.isSelected()));
            pst2.setInt(24, convertirCheckATinyInt(check_cara.isSelected()));
            pst2.setInt(25, convertirCheckATinyInt(check_cuello.isSelected()));
            pst2.setInt(26, convertirCheckATinyInt(check_ortodoncia.isSelected()));
            pst2.setInt(27, convertirCheckATinyInt(check_cirugia.isSelected()));
            pst2.setInt(28, convertirCheckATinyInt(check_periodoncia.isSelected()));
            pst2.setInt(29, convertirCheckATinyInt(check_implantes.isSelected()));
            pst2.setInt(30, convertirCheckATinyInt(check_endodoncia.isSelected()));
            pst2.setInt(31, convertirCheckATinyInt(check_restauracion.isSelected()));
            pst2.setString(32, Txt_Otras_Obs.getText().trim());

                    
            pst2.executeUpdate();
            cn.close();
            JOptionPane.showMessageDialog(null,"Se han guardado los cambios de manera satisfactoria.");

            }catch (Exception e){
                System.out.println("Error al actulizar la BD "+e);
            }
          
        
    }
    
    
    ////Método para cargar los datos personales del paciente en la historia médica////
    public void CargarDatosPacienteHM(String ci){
       
        try{   
             Connection cn = Conexion.conectarBD();
             PreparedStatement pst = cn.prepareStatement("select * from pacientes where Cedula = '" + ci + "'");

             ResultSet rs = pst.executeQuery();
             
             if(rs.next()){

                textNombre.setText(rs.getString("Nombre"));
                Txt_Cedula.setText(rs.getString("Cedula"));
                textDireccion.setText(rs.getString("Direccion"));
                textEdad.setText(rs.getString("Edad"));
                textSexo.setText(rs.getString("Sexo"));
                textTelefono.setText(rs.getString("Telefono"));
                textObservaciones.setText(rs.getString("Observaciones"));

             }

            cn.close();
        }catch(Exception e){
             System.out.println("Error en cargar datos del paciente " + e);

        }
        
    }
    
    ////Método seleccionar o deseleccionar un RadioButton según su valor guardado en la Base de Datos////
    public void SeleccionarSegunString(String string, ButtonGroup group, JRadioButton RBOP1, JRadioButton RBOP2){
        if(string.equals("Si")){
            RBOP1.setSelected(true);
        }else {
           RBOP2.setSelected(true); 
        }
    }
    
    ////Método seleccionar o deseleccionar un CheckBox según su valor guardado en la Base de Datos////
    public void SeleccionarCheck(int numero, JCheckBox check){
        if(numero==1){
            check.setSelected(true);
        }else {
           check.setSelected(false); 
        }
    }
    
    
    ////Método para llenar los datos de la historia previamente guardados en la historia médica////
    public void CargarDatosHistoria(String ci){
       
        try{   
             Connection cn = Conexion.conectarBD();
             PreparedStatement pst = cn.prepareStatement("select * from historias where cedula_paciente = '" + ci + "'");

             ResultSet rs = pst.executeQuery();
             
             if(rs.next()){

                Txt_NomContacto.setText(rs.getString("nombre_contacto"));
                Txt_TelContacto.setText(rs.getString("telefono_contacto"));
                Txt_Parentesco.setText(rs.getString("parentesco_contacto"));
                SeleccionarSegunString(rs.getString("RB1"),buttonGroup1,RB1,RB11);
                Txt_Especificacion1.setText(rs.getString("ESP1"));
                SeleccionarSegunString(rs.getString("RB2"),buttonGroup2,RB2,RB22);
                Txt_Especificacion2.setText(rs.getString("ESP2"));
                SeleccionarSegunString(rs.getString("RB3"),buttonGroup3,RB3,RB33);
                Txt_Especificacion3.setText(rs.getString("ESP3"));
                SeleccionarSegunString(rs.getString("RB4"),buttonGroup4,RB4,RB44);
                Txt_Especificacion4.setText(rs.getString("ESP4"));
                SeleccionarSegunString(rs.getString("RB5"),buttonGroup5,RB5,RB55);
                Txt_Especificacion5.setText(rs.getString("ESP5"));
                SeleccionarSegunString(rs.getString("RB6"),buttonGroup6,RB6,RB66);
                Txt_Especificacion6.setText(rs.getString("ESP6"));
                SeleccionarSegunString(rs.getString("RB7"),buttonGroup7,RB7,RB77);
                SeleccionarSegunString(rs.getString("RB8"),buttonGroup8,RB8,RB88);
                SeleccionarSegunString(rs.getString("RB9"),buttonGroup9,RB9,RB99);
                SeleccionarSegunString(rs.getString("RBA"),buttonGroup10,RBA,RBAA);
                SeleccionarSegunString(rs.getString("RBB"),buttonGroup11,RBB,RBBB);
                Txt_Habito.setText(rs.getString("text_habito"));
                Txt_Motivo.setText(rs.getString("text_motivo"));
                SeleccionarCheck(rs.getInt("check_boca"), check_boca);
                SeleccionarCheck(rs.getInt("check_cara"), check_cara);
                SeleccionarCheck(rs.getInt("check_cuello"), check_cuello);
                SeleccionarCheck(rs.getInt("check_ortodoncia"), check_ortodoncia);
                SeleccionarCheck(rs.getInt("check_cirugia"), check_cirugia);
                SeleccionarCheck(rs.getInt("check_periodoncia"), check_periodoncia);
                SeleccionarCheck(rs.getInt("check_implantes"), check_implantes);
                SeleccionarCheck(rs.getInt("check_endodoncia"), check_endodoncia);
                SeleccionarCheck(rs.getInt("check_restauracion"), check_restauracion);
                Txt_Otras_Obs.setText(rs.getString("text_otras_obs"));
                
                
             }

            cn.close();
        }catch(Exception e){
             System.out.println("Error en cargar datos de la Historia " + e);

        }
    }
    
    
    ////Método para generar PDF con odontograma y periodontograma////
    public void DescargarDiagramasPaciente(){
        
        Document documento = new Document();
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta +"/Desktop/"+textNombre.getText().trim()+".pdf"));
            
            //Título general
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("\nDiagramas dentales para: "+textNombre.getText().trim()+"\n");
            parrafo.setFont(FontFactory.getFont("Times New Roman", 18, Font.BOLD, BaseColor.BLACK));
            
            //Título del odontograma
            Paragraph parrafo1 = new Paragraph();
            parrafo1.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo1.add("\nOdontograma\n");
            parrafo1.setFont(FontFactory.getFont("Times New Roman", 16, Font.CENTER_BASELINE, BaseColor.BLACK));
            
            
            //Imagen del odontograma
            com.itextpdf.text.Image odontograma = com.itextpdf.text.Image.getInstance("src/Imagenes/odontograma.jpg");
            odontograma.scaleToFit(400, 400);
            odontograma.setAlignment(Chunk.ALIGN_CENTER);
            
            documento.open();
            documento.add(parrafo);
            documento.add(parrafo1);
            documento.add(odontograma);
            
            //Título del periodontograma
            Paragraph parrafo2 = new Paragraph();
            parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo2.add("\nPeriodontograma\n");
            parrafo2.setFont(FontFactory.getFont("Times New Roman", 16, Font.CENTER_BASELINE, BaseColor.BLACK));
                
            
            //Imagen del periodontograma
            com.itextpdf.text.Image periodontograma = com.itextpdf.text.Image.getInstance("src/Imagenes/periodontograma.jpeg");
            periodontograma.scaleToFit(400, 400);
            periodontograma.setAlignment(Chunk.ALIGN_CENTER);

            documento.add(parrafo2);
            documento.add(periodontograma);
            documento.close();
            JOptionPane.showMessageDialog(null, "Diagramas de "+textNombre.getText().trim()+" descargados correctamente.");
            
            
        }catch (DocumentException | IOException e) {
            System.err.print("Error en PDF"+e);
            JOptionPane.showMessageDialog(null, "Error al descargar diagramas.");
        }
    }
    
    
    
    
}

   
