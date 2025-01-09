/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.GPrincipal;

import Vista.GCobro.GestiondeCobros;
import Vista.GCatalogo.GestiondeCatalogo;
import Vista.GOdontologo.GestionOdontologos;
import Vista.GPerfil.GestionPerfil;
import Vista.GPaciente.GestionPacientes;
import Controlador.ControladorGPerfil;
import Vista.GCitas.GestionCitas;
import Vista.GCitas.VerCitas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Menu extends javax.swing.JFrame {
    
    
    ControladorGPerfil control;
    String CeduCar;
    String Car;
    String nombre;
    
    
    
    
    public Menu() {
        initComponents();
        control = new ControladorGPerfil();
        control.iniciaVentana(this,"src/Imagenes/logoC.png");
        
        
    }
    
    public Menu(String CeduCar) {
        this.CeduCar=CeduCar;
        String Cedul[]= CeduCar.split("-");
        this.Car=Cedul[1];
        initComponents();
        this.nombre=Cedul[2];
        control = new ControladorGPerfil();
        control.iniciaVentana(this,"src/Imagenes/logoC.png");
        if ("Secretaria".equals(Car)) {
            
        } else {
            Odontologos.setEnabled(false);
            Catalogo.setEnabled(false);
            Cobros.setEnabled(false);
        }
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSScaleLabel1 = new rsscalelabel.RSScaleLabel();
        jPanel1 = new javax.swing.JPanel();
        PanelTitutlo = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        Perfil = new rsbuttom.RSButtonMetro();
        Pacientes = new rsbuttom.RSButtonMetro();
        Odontologos = new rsbuttom.RSButtonMetro();
        Catalogo = new rsbuttom.RSButtonMetro();
        Cobros = new rsbuttom.RSButtonMetro();
        Citas = new rsbuttom.RSButtonMetro();
        CerrarSesion = new rsbuttom.RSButtonMetro();
        Salir = new rsbuttom.RSButtonMetro();
        Principal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelTitutlo.setBackground(new java.awt.Color(140, 197, 255));
        PanelTitutlo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelTitutlo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 70, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("D        E        N       T       A       L                                 C       A       R         E");
        PanelTitutlo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 610, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("C O N S U L T O R I O    D E N T A L");
        PanelTitutlo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 190, 60));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("_________________________________");
        PanelTitutlo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, 40));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo1.png"))); // NOI18N
        PanelTitutlo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, 70, 60));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("___________________________");
        PanelTitutlo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, -20, 360, 40));

        jPanel1.add(PanelTitutlo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        pnlMenu.setBackground(new java.awt.Color(226, 240, 255));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Perfil.setBackground(new java.awt.Color(229, 242, 255));
        Perfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Perfil.png"))); // NOI18N
        Perfil.setText("P  E R  F  I  L");
        Perfil.setColorHover(new java.awt.Color(153, 255, 153));
        Perfil.setColorNormal(new java.awt.Color(229, 242, 255));
        Perfil.setColorPressed(new java.awt.Color(204, 204, 204));
        Perfil.setColorTextNormal(new java.awt.Color(51, 51, 51));
        Perfil.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Perfil.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerfilActionPerformed(evt);
            }
        });
        pnlMenu.add(Perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 230, 60));

        Pacientes.setBackground(new java.awt.Color(229, 242, 255));
        Pacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Paciente.png"))); // NOI18N
        Pacientes.setText("P A C I E N T E S");
        Pacientes.setColorHover(new java.awt.Color(153, 255, 153));
        Pacientes.setColorNormal(new java.awt.Color(229, 242, 255));
        Pacientes.setColorPressed(new java.awt.Color(204, 204, 204));
        Pacientes.setColorTextNormal(new java.awt.Color(51, 51, 51));
        Pacientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Pacientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Pacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PacientesActionPerformed(evt);
            }
        });
        pnlMenu.add(Pacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 230, 60));

        Odontologos.setBackground(new java.awt.Color(229, 242, 255));
        Odontologos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/odontologo.png"))); // NOI18N
        Odontologos.setActionCommand("Odontólogos");
        Odontologos.setColorHover(new java.awt.Color(153, 255, 153));
        Odontologos.setColorNormal(new java.awt.Color(229, 242, 255));
        Odontologos.setColorPressed(new java.awt.Color(204, 204, 204));
        Odontologos.setColorTextNormal(new java.awt.Color(51, 51, 51));
        Odontologos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Odontologos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Odontologos.setLabel("O D O N T Ó L O G O S");
        Odontologos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OdontologosActionPerformed(evt);
            }
        });
        pnlMenu.add(Odontologos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 230, 60));

        Catalogo.setBackground(new java.awt.Color(229, 242, 255));
        Catalogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Catalogo.png"))); // NOI18N
        Catalogo.setText("C Á T A L O G O");
        Catalogo.setColorHover(new java.awt.Color(153, 255, 153));
        Catalogo.setColorNormal(new java.awt.Color(229, 242, 255));
        Catalogo.setColorPressed(new java.awt.Color(204, 204, 204));
        Catalogo.setColorTextNormal(new java.awt.Color(51, 51, 51));
        Catalogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Catalogo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Catalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatalogoActionPerformed(evt);
            }
        });
        pnlMenu.add(Catalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 230, 60));

        Cobros.setBackground(new java.awt.Color(229, 242, 255));
        Cobros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cobro.png"))); // NOI18N
        Cobros.setText(" C O B R O S");
        Cobros.setColorHover(new java.awt.Color(153, 255, 153));
        Cobros.setColorNormal(new java.awt.Color(229, 242, 255));
        Cobros.setColorPressed(new java.awt.Color(204, 204, 204));
        Cobros.setColorTextNormal(new java.awt.Color(51, 51, 51));
        Cobros.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Cobros.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Cobros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CobrosActionPerformed(evt);
            }
        });
        pnlMenu.add(Cobros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 230, 60));

        Citas.setBackground(new java.awt.Color(229, 242, 255));
        Citas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/citas.png"))); // NOI18N
        Citas.setText(" C I T A S");
        Citas.setToolTipText("");
        Citas.setColorHover(new java.awt.Color(153, 255, 153));
        Citas.setColorNormal(new java.awt.Color(229, 242, 255));
        Citas.setColorPressed(new java.awt.Color(204, 204, 204));
        Citas.setColorTextNormal(new java.awt.Color(51, 51, 51));
        Citas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Citas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Citas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CitasActionPerformed(evt);
            }
        });
        pnlMenu.add(Citas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 230, 60));

        CerrarSesion.setText("Cerrar Sesión");
        CerrarSesion.setColorHover(new java.awt.Color(102, 204, 255));
        CerrarSesion.setColorNormal(new java.awt.Color(153, 255, 204));
        CerrarSesion.setColorTextNormal(new java.awt.Color(0, 0, 0));
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });
        pnlMenu.add(CerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 170, -1));

        Salir.setText("SALIR");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        pnlMenu.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 595, -1, 20));

        jPanel1.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 650));

        Principal.setBackground(new java.awt.Color(255, 255, 255));
        Principal.setLayout(new java.awt.BorderLayout());
        jPanel1.add(Principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 970, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int posicion = pnlMenu.getX();
        if(posicion > -1){
            Animacion.Animacion.mover_izquierda(0, -264, 2, 2, pnlMenu);
        }else{
            Animacion.Animacion.mover_derecha(-264, 0, 2, 2, pnlMenu);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void PerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilActionPerformed
    
        GestionPerfil destino = new GestionPerfil(CeduCar);
        control.ConectarPanel(Principal, destino, 970, 650, 0, 0); 

    }//GEN-LAST:event_PerfilActionPerformed

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        Login destino = new Login();
        control.activaVentana(destino, this);
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void PacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PacientesActionPerformed
       GestionPacientes destino = new GestionPacientes();
       control.ConectarPanel(Principal, destino, 800, 650, 230, 60);
    }//GEN-LAST:event_PacientesActionPerformed

    private void OdontologosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OdontologosActionPerformed
      
        GestionOdontologos destino = new GestionOdontologos();
        control.ConectarPanel(Principal, destino, 800, 650, 230, 60);
    }//GEN-LAST:event_OdontologosActionPerformed

    private void CitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CitasActionPerformed
        if ("Secretaria".equals(Car)) {
            GestionCitas destino = new GestionCitas(CeduCar);
            control.ConectarPanel(Principal, destino, 800, 650, 230, 60);
        } else {
            VerCitas destino = new VerCitas(nombre, CeduCar,null);
            control.ConectarPanel(Principal, destino, 800, 650, 230, 60);
        }
     
    }//GEN-LAST:event_CitasActionPerformed

    private void CatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatalogoActionPerformed
        GestiondeCatalogo destino = new GestiondeCatalogo();
        control.ConectarPanel(Principal, destino, 800, 650, 230, 60);
    }//GEN-LAST:event_CatalogoActionPerformed

    private void CobrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CobrosActionPerformed
       GestiondeCobros destino = new GestiondeCobros();
        control.ConectarPanel(Principal, destino, 800, 650, 230, 60);
    }//GEN-LAST:event_CobrosActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
       System.exit(0); 
       //AGRADEZCO NO VUELVAN A PONER this.dispose(), ES ESTE EL QUE CIERRA EL PROGRAMA
    }//GEN-LAST:event_SalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro Catalogo;
    private rsbuttom.RSButtonMetro CerrarSesion;
    private rsbuttom.RSButtonMetro Citas;
    private rsbuttom.RSButtonMetro Cobros;
    private rsbuttom.RSButtonMetro Odontologos;
    private rsbuttom.RSButtonMetro Pacientes;
    private javax.swing.JPanel PanelTitutlo;
    private rsbuttom.RSButtonMetro Perfil;
    private javax.swing.JPanel Principal;
    private rsbuttom.RSButtonMetro Salir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlMenu;
    private rsscalelabel.RSScaleLabel rSScaleLabel1;
    // End of variables declaration//GEN-END:variables
}
