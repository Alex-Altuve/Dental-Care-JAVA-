/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JOptionPane;

/**
 *
 * @author Alex Altuve
 */
public class Factura {
   
      public void GenerarPDF(){
        LocalDate fecha = LocalDate.now();
        try{
            Document documento = new Document();
            String ruta = "ListadeCobros.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();
            Image image1=null;
            try{
                image1=Image.getInstance("src/Imagenes/Imagen1.png");
                image1.scaleAbsolute(200,150);
                image1.setAbsolutePosition(25, 680);
            }catch(Exception e){
                System.out.println("error 1"+e);
            }
            documento.add(image1);
            
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            
            Paragraph titulo2 = new Paragraph();
            titulo2.setAlignment(Paragraph.ALIGN_RIGHT);
            titulo2.setFont(FontFactory.getFont("Tahoma", 18, com.itextpdf.text.Font.BOLD));
            titulo2.add("\n\nListado de todos los cobros realizados\n");            
            titulo2.add("---------------------"+fecha.toString()+"-----------------------\n\n");
            documento.add(titulo2);
            
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            
            Paragraph titulo3 = new Paragraph();
            titulo3.setAlignment(Paragraph.ALIGN_CENTER);
            titulo3.setFont(FontFactory.getFont("Tahoma", 18, com.itextpdf.text.Font.BOLD));
            titulo3.add("------Lista de Cobros------\n\n");    
            documento.add(titulo3);
            
            PdfPCell nombreC = new PdfPCell(new Phrase("Nombre"));         
            nombreC.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell ced= new PdfPCell(new Phrase("Cedula"));
            ced.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell Direccion = new PdfPCell(new Phrase("Direccion"));
            Direccion.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell Telefono = new PdfPCell(new Phrase("Telefono"));
            Telefono.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell Servicio = new PdfPCell(new Phrase("Servicios"));
            Servicio.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell TPago = new PdfPCell(new Phrase("Tipo Pago"));
            TPago.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell Monto = new PdfPCell(new Phrase("Monto Cobrado"));
            Monto.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell Numero= new PdfPCell(new Phrase("N° Tarjeta/Transferencia"));
            Numero.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell date = new PdfPCell(new Phrase("Fecha"));
            date.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell Nota = new PdfPCell(new Phrase("Nota"));
            Nota.setBackgroundColor(BaseColor.LIGHT_GRAY);
            
            PdfPTable tabla = new PdfPTable(10);
            com.itextpdf.text.Font fuente= new com.itextpdf.text.Font();
            fuente.setSize(10);
            
            tabla.setWidthPercentage(100);
            tabla.addCell(nombreC);
            tabla.addCell(ced);
            tabla.addCell(Direccion);
            tabla.addCell(Telefono);
            tabla.addCell(Servicio);
            tabla.addCell(TPago);
            tabla.addCell(Numero);
            tabla.addCell(Monto);
            tabla.addCell(Nota);
            tabla.addCell(date);
            
            try{
               Connection cn = Conexion.conectarBD();
                System.out.println("Conexion establecida...");
                Statement stmt=cn.createStatement();  
                ResultSet rs=stmt.executeQuery("select * from cobros");
               
                while(rs.next()){
                        tabla.addCell(rs.getString(1)); //Nombre
                        tabla.addCell(rs.getString(2)); //Ced
                        tabla.addCell(rs.getString(3)); //Direccion
                        tabla.addCell(rs.getString(4));//Telefono
                        tabla.addCell(rs.getString(5));//Servicio
                        tabla.addCell(rs.getString(6));//TipoPago
                        tabla.addCell(rs.getString(7));//Numero de transferecnia o factura 
                        tabla.addCell(rs.getString(8)); // Monto
                        tabla.addCell(rs.getString(9));//nota
                        tabla.addCell(rs.getString(10));//Fecha
                    
                }
            
                cn.close(); 
            }catch(Exception e){
                 System.out.println("error 2"+e);
            }
            documento.add(tabla);
            documento.close();
             JOptionPane.showMessageDialog(null,  "Se creo el archivo 'ListadeCobros.pdf' en la carpeta del proyecto");
        }catch(Exception e){
             System.out.println("error 3"+e);
        }
    }    
   
     public void Factura(Cobro DatosCliente, int NumFactura){
        
        LocalDate fecha = LocalDate.now();
        
        try{
            Document documento = new Document();
            String ruta = "FacturaCobro.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();
            Image image1=null;
            try{
                image1=Image.getInstance("src/Imagenes/Imagen1.png");
                image1.scaleAbsolute(200,150);
                image1.setAbsolutePosition(25, 680);
            }catch(Exception e){
                System.out.println("error 1"+e);
            }
            documento.add(image1);
            
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
      
            
            Paragraph texto2= new Paragraph();          
            texto2.setAlignment(Paragraph.ALIGN_RIGHT);     
            texto2.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD));
            texto2.add("\n\nFactura del Cobro N ("+NumFactura+")         "); 
            texto2.add("\n---------------------"+fecha.toString()+"-----------------------\n\n"); 
            documento.add(texto2);
            
            Paragraph texto3= new Paragraph();          
            texto3.setAlignment(Paragraph.ALIGN_CENTER);     
            texto3.setFont(FontFactory.getFont("Tahoma", 15, Font.BOLD));
           
            texto3.add("    R.I.F.: J-00012255-5\n\n"); 
            documento.add(texto3);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
       
            
            Paragraph texto1= new Paragraph();
           
             texto1.setAlignment(Paragraph.ALIGN_LEFT);
            texto1.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD));
            texto1.add("\nDATOS DEL CLIENTE\n");          
            texto1.add("\nNOMBRE -> "+DatosCliente.getNombre());
            texto1.add("\nCEDULA -> "+DatosCliente.getCedula()); 
            texto1.add("\nTELEFONO -> "+DatosCliente.getTelefono());
            texto1.add("\nDIRECCION-> "+DatosCliente.getDireccion());
            texto1.add("\nTIPO DE PAGO-> "+DatosCliente.getTipoPago());
            if("Tarjeta".equals(DatosCliente.getTipoPago()) ){              
                texto1.add("\nNÚMERO DE TARJETA-> "+DatosCliente.getNumTarjeta_Transferencia());
            }
            if("Tranferencia".equals(DatosCliente.getTipoPago()) ){
                texto1.add("\nNÚMERO DE TRANSFERENCIA-> "+DatosCliente.getNumTarjeta_Transferencia()); 
            }
            documento.add(texto1);
            documento.add(Chunk.NEWLINE);
          
            Paragraph titulo3 = new Paragraph();
            titulo3.setAlignment(Paragraph.ALIGN_CENTER);
            titulo3.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD));
            titulo3.add("\n\n------Servicio Odontologico Aplicados------\n\n");  
          
            documento.add(titulo3);
            PdfPTable tabla = new PdfPTable(1);
            
            PdfPCell nombreProd = new PdfPCell(new Phrase("Servicio Aplicado"));          
            nombreProd.setBackgroundColor(BaseColor.LIGHT_GRAY);          

            tabla.setWidthPercentage(100);
            tabla.addCell(nombreProd);
            tabla.addCell(DatosCliente.getServicios());
            documento.add(tabla);
            /////////////////////////////////
            documento.add(Chunk.NEWLINE);
            Paragraph titulo4 = new Paragraph();
            titulo4.setAlignment(Paragraph.ALIGN_LEFT);
            titulo4.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD));
            titulo4.add("----> TOTAL COBRADO "+DatosCliente.getMonto()+ " $");
            documento.add(titulo4);
            ////////////////////////////////////////////////
            documento.close();
             JOptionPane.showMessageDialog(null,  "Se creo el archivo 'FacturaCobro.pdf' en la carpeta del proyecto");
      
        }catch(Exception e){
             System.out.println("error 3"+e);
        }
    }    
}
