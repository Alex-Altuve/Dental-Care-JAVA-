package Controlador;

import Modelo.Cobro;
import Modelo.Conexion;
import Modelo.Factura;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Alex Altuve
 */
public class ControladorGCobro {
    JTextField Nombre, Cedula, Direccion, NumTar, NumTrans, Nota, Telefono, Monto, Servicios;
    JTextField Error_Nombre, Error_Cedula, Error_NumTar, Error_NumTrans, Error_Telefono;
    JComboBox ListTel;
    JRadioButton Tarjeta, Transferencia, Efectivo;
    JTable ListaCobros;
    ButtonGroup Valida;
    

    public ControladorGCobro(JTable ListaCobros) {
        this.ListaCobros = ListaCobros;
    }

    public ControladorGCobro(JTextField Nombre, JTextField Cedula, JTextField Direccion, JTextField NumTar, JTextField NumTRans, JTextField Nota, JTextField Telefono, JTextField Error_Nombre, JTextField Error_Cedula, JTextField Error_NumTar, JTextField Error_NumTrans, JTextField Error_Telefono, JComboBox ListTel, JRadioButton Tarjeta, JRadioButton Transferencia, JRadioButton Efectivo, ButtonGroup Valida, JTextField Monto,JTextField Servicios) {
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.Direccion = Direccion;
        this.NumTar = NumTar;
        this.NumTrans = NumTRans;
        this.Nota = Nota;
        this.Telefono = Telefono;
        this.Monto=Monto;
        this.Servicios= Servicios;
        this.Error_Nombre = Error_Nombre;
        this.Error_Cedula = Error_Cedula;
        this.Error_NumTar = Error_NumTar;
        this.Error_NumTrans = Error_NumTrans;
        this.Error_Telefono = Error_Telefono;
        this.ListTel = ListTel;
        this.Tarjeta = Tarjeta;
        this.Transferencia = Transferencia;
        this.Efectivo = Efectivo;
        this.Valida = Valida;
    }

    public ControladorGCobro(JTextField Nombre, JTextField Cedula, JTextField Direccion, JTextField NumTar, JTextField NumTRans, JTextField Nota, JTextField Telefono, JComboBox ListTel, JRadioButton Tarjeta, JRadioButton Transferencia, JRadioButton Efectivo, ButtonGroup Valida, JTextField Monto,JTextField Servicios) {
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.Direccion = Direccion;
        this.NumTar = NumTar;
        this.NumTrans = NumTRans;
        this.Nota = Nota;
        this.Telefono = Telefono;
        this.Monto=Monto;
        this.Servicios= Servicios;
        this.ListTel = ListTel;
        this.Tarjeta = Tarjeta;
        this.Transferencia = Transferencia;
        this.Efectivo = Efectivo;
        this.Valida = Valida;
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
    
   
    
   
    
  /////////////////////////////////////////////////////////
  
    public void LlenarCampoErrores(Cobro Cli){
        String Partenum=ListTel.getSelectedItem().toString().trim()+Telefono.getText().trim(); 
        if(Cli.ValidarCedula(Cedula.getText().trim())==false){
            CrearFuentetoErrores(Error_Cedula);          
            Error_Cedula.setText("*Numeros entre 6 y 8 digitos");
        }
       
        if(Cli.ValidarNombre(Nombre.getText().trim())== false){
            CrearFuentetoErrores(Error_Nombre);
            Error_Nombre.setText("*Cumplir formato [(N)ombre (A)pellido]");
        }
        if(Cli.ValidarTelefono(Partenum.trim())== false){
            CrearFuentetoErrores(Error_Telefono);
            Error_Telefono.setText("*Debe completar los 7 digitos faltantes");
        }
        
        if((NumTar.getText().trim().length()>18 ||NumTar.getText().trim().length()<16) && (Tarjeta.isSelected()==true) ){
            CrearFuentetoErrores(Error_NumTar);
            Error_NumTar.setText("*El N° tarjeta debe contener entre 16 y 18 digitos");
        }
        if((NumTrans.getText().trim().length()>9 ||NumTar.getText().trim().length()<9) && (Transferencia.isSelected()==true) ){
            CrearFuentetoErrores(Error_NumTrans);
            Error_NumTrans.setText("*El N° transferencia debe contener 9 digitos");
        }
    }
    public boolean VerificarVaciostxt(){
       return "".equals(Nombre.getText().trim()) || "".equals(Cedula.getText().trim()) ||  "".equals(Direccion.getText().trim()) ||  "".equals(Telefono.getText().trim()) || "".equals(Monto.getText().trim()) ||  "".equals(Servicios.getText().trim()) ; 
    }
    
    public boolean VaciosFormaPago(){
        return (Tarjeta.isSelected()==true && "".equals(NumTar.getText().trim())== true) || (Transferencia.isSelected()==true && "".equals(NumTrans.getText().trim())== true);
    }
    public boolean ValidarDatosFPago(){
        return (Tarjeta.isSelected()==true && NumTar.getText().trim().length()>=16 && NumTar.getText().trim().length()>=18) || (Transferencia.isSelected()==true && NumTrans.getText().trim().length()==9);
    }
    
    public String FormaPago(){
        if(Tarjeta.isSelected()==true){
            return "Tarjeta";
        }
        if(Transferencia.isSelected()==true){
            return "Transferencia";
        }
        if(Efectivo.isSelected()==true){
            return "Efectivo";
        }
        return null;
    }
    public String FormaPagoNumero(){
        if(Tarjeta.isSelected()==true){
            return NumTar.getText().trim();
        }
        if(Transferencia.isSelected()==true){
            return NumTrans.getText().trim();
        }
        if(Efectivo.isSelected()==true){
            return "No Aplica";
        }
        return null;
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
    public boolean RegistrarCobro(){
        boolean a=false;
        Cobro Cliente = new Cobro();
        String Partenum=ListTel.getSelectedItem().toString().trim()+Telefono.getText().trim(); 
        if(VerificarVaciostxt()== false && VaciosFormaPago()==false && (Tarjeta.isSelected()==true || Transferencia.isSelected()==true || Efectivo.isSelected()==true)){

            if(Cliente.ValidarDatosIngresados(Partenum.trim(), Nombre.getText().trim(), Cedula.getText().trim(), Monto.getText().trim())==true &&(ValidarDatosFPago()==true || Efectivo.isSelected()==true)){
             
                Cliente.IngresarDatos(Nombre.getText().trim(), Cedula.getText().trim(), Direccion.getText().trim(),Partenum, FormaPago(),FormaPagoNumero(), Nota.getText().trim(), Monto.getText().trim(), Servicios.getText().trim());
                try {
                  
                    Connection cn = Conexion.conectarBD();
                    Statement stm= (Statement) cn.createStatement();

                    String Name=Cliente.getNombre();
                    String Cedu= Cliente.getCedula();
                    String Direcc= Cliente.getDireccion();
                    String Telefono= Cliente.getTelefono();
                    String ServicioAplicado= Cliente.getServicios();
                    String TipoPago= Cliente.getTipoPago();
                    String NumT= Cliente.getNumTarjeta_Transferencia();
                    String MontoCobrado= Cliente.getMonto();
                    String Observacion= Cliente.getNota();
                    String FechaCobro= Cliente.getFechaCobro();

                    String insert="INSERT INTO cobros VALUES('"+Name+"','"+Cedu+"','"+Direcc+"','"+Telefono+"','"+ServicioAplicado+"','"+TipoPago+"','"+NumT+"','"+MontoCobrado+"','"+Observacion+"','"+FechaCobro+"');";

                    stm.executeUpdate(insert);
                    cn.close();
                     a=true;
                    JOptionPane.showMessageDialog(null, "Registro exitoso.");
                }catch(SQLException e) {
                     System.err.println("Error al ingresarlo en la BD " + e);
                     JOptionPane.showMessageDialog(null, "¡Contacte al administrador!");
                }
        
            }else{
               LlenarCampoErrores(Cliente);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Se deben llenar todos lo campos, no se ingresaran campos vacios","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
        return a;
    }
    public void SeleccionarRadioButton(String FormaP, String Num){
        if("Tarjeta".equals(FormaP)){
            Tarjeta.setSelected(true);
            NumTar.setText(Num);
        }
        if("Transferencia".equals(FormaP)){
            Transferencia.setSelected(true);
            NumTrans.setText(Num);
        }
        if("Efectivo".equals(FormaP)){
            Efectivo.setSelected(true);
        }
    }
    public void ConsultarCobro(String ci){
        try{   
             Connection cn = Conexion.conectarBD();
             PreparedStatement pst = cn.prepareStatement("select * from cobros where Cedula = '" + ci + "'");

             ResultSet rs = pst.executeQuery();
             String Telef="";
             
             if(rs.next()){

                Nombre.setText(rs.getString("Nombre"));
                Cedula.setText(rs.getString("Cedula"));
                Direccion.setText(rs.getString("Direccion"));               
                PasarNumaCombo(rs.getString("Telefono"));
                Telef=rs.getString("Telefono").substring(4);
                Telefono.setText(Telef); 
                Servicios.setText(rs.getString("ServicioAplicado"));
                SeleccionarRadioButton(rs.getString("TipoPago").trim(),rs.getString("NumT").trim() );
                Monto.setText(rs.getString("MontoCobrado"));
                Nota.setText(rs.getString("Nota"));

             }

            cn.close();
        }catch(Exception e){
             System.out.println("Error en cargar los datos " + e);

        }
    }
    public void LlenarTabla(){
         String[] columna = {"Nombre","Cedula", "Telefono", "TipoPágo", "MontoCobrado", "Fecha" };
        String[] registros = new String[6];
        ListaCobros.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel dtm = new DefaultTableModel(null, columna) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        try {
           Connection cn = Conexion.conectarBD();
            Statement pst = cn.createStatement();
            ResultSet res= pst.executeQuery("SELECT * FROM cobros");

            while (res.next()) {

                registros[0] = res.getString(1); //nombre
                registros[1] = res.getString(2); //cedula
                registros[2] = res.getString(4); //telefono
                registros[3] = res.getString(6); //TipoPago
                registros[4] = res.getString(8); //MontoCobrado              
                registros[5] = res.getString(10); //fecha
 
                dtm.addRow(registros);
            }
            ListaCobros.setModel(dtm);
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al filtrar desde la BD " + e);
            JOptionPane.showMessageDialog(null, "¡Contacte al administrador!");
        }
    }
    public void BuscarCliente(int Fila, Cobro Cb){
        try {
            int i=0;
            Connection cn = Conexion.conectarBD();
            Statement pst = cn.createStatement();
            ResultSet rs= pst.executeQuery("SELECT * FROM cobros");
             
            while (rs.next()) {
                if(i==Fila){
                    Cb.IngresarDatos(rs.getString("Nombre"), rs.getString("Cedula"),rs.getString("Direccion"), rs.getString("Telefono"), rs.getString("TipoPago").trim(), rs.getString("NumT").trim(), rs.getString("Nota"), rs.getString("MontoCobrado"), rs.getString("ServicioAplicado"));                
                }
               i++;
            }
           
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al filtrar desde la BD " + e);
            JOptionPane.showMessageDialog(null, "¡Contacte al administrador!");
        }   
    }
    public void GenerarPDF(){
        Factura bill= new Factura();
        Cobro Cb= new Cobro();
        int fila=ListaCobros.getSelectedRow(); //llamar tabla odontologo
        if (fila>-1) {
            String Cedula_new= ListaCobros.getValueAt(fila, 1).toString().trim();
            BuscarCliente(fila, Cb);
            bill.Factura(Cb, fila);
        }else{
            bill.GenerarPDF();
        }
    }
}
