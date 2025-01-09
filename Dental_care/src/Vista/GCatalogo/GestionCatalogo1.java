/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.GCatalogo;

import Controlador.ControladorGCatalogo;
import java.awt.Color;

/**
 *
 * @author tinti
 */
public class GestionCatalogo1 extends javax.swing.JPanel {
    ControladorGCatalogo control;
    String nameOriginal;
    public static String Nombre_new = "";
    /**
     * Creates new form GestionCatalogo1
     */
    public GestionCatalogo1(String nombre) {
        initComponents();
        control = new ControladorGCatalogo(Nombre1, Precio,TextDescripcion,Error_Nombre, Error_Precio);
        nameOriginal = nombre;
        control.ConsultarSC(nombre);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        BModificar = new javax.swing.JButton();
        BEliminar = new javax.swing.JButton();
        CerrarSesion5 = new rsbuttom.RSButtonMetro();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Nombre1 = new javax.swing.JTextField();
        Error_Nombre = new javax.swing.JTextField();
        Precio = new javax.swing.JTextField();
        Error_Precio = new javax.swing.JTextField();
        TextDescripcion = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CATÁLOGO DE SERVICIOS");

        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });
        Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombreKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(254, 219, 254));

        BModificar.setBackground(new java.awt.Color(0, 0, 102));
        BModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BModificar.setForeground(new java.awt.Color(255, 255, 255));
        BModificar.setText("Modificar");
        BModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BModificarMouseExited(evt);
            }
        });
        BModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BModificarActionPerformed(evt);
            }
        });

        BEliminar.setBackground(new java.awt.Color(153, 0, 0));
        BEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BEliminar.setForeground(new java.awt.Color(255, 255, 255));
        BEliminar.setText("Eliminar");
        BEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BEliminarMouseExited(evt);
            }
        });
        BEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEliminarActionPerformed(evt);
            }
        });

        CerrarSesion5.setText("Regresar");
        CerrarSesion5.setColorHover(new java.awt.Color(102, 204, 255));
        CerrarSesion5.setColorNormal(new java.awt.Color(153, 255, 204));
        CerrarSesion5.setColorTextNormal(new java.awt.Color(0, 0, 0));
        CerrarSesion5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesion5ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("GESTIÓN DE SERVICIOS");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/catalogoimg.png"))); // NOI18N

        Nombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre1ActionPerformed(evt);
            }
        });
        Nombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Nombre1KeyTyped(evt);
            }
        });

        Error_Nombre.setEditable(false);
        Error_Nombre.setBackground(new java.awt.Color(0,0,0,1));
        Error_Nombre.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Error_Nombre.setForeground(new java.awt.Color(255, 0, 0));
        Error_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Error_Nombre.setBorder(null);

        Precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecioActionPerformed(evt);
            }
        });
        Precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PrecioKeyTyped(evt);
            }
        });

        Error_Precio.setEditable(false);
        Error_Precio.setBackground(new java.awt.Color(0,0,0,1));
        Error_Precio.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Error_Precio.setForeground(new java.awt.Color(255, 0, 0));
        Error_Precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Error_Precio.setBorder(null);
        Error_Precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Error_PrecioActionPerformed(evt);
            }
        });

        TextDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextDescripcionActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 204));
        jLabel21.setText("Nombre");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 204));
        jLabel22.setText("Precio (expresado en dólares)");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 204));
        jLabel25.setText("Descripción detallada del servicio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(CerrarSesion5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(BModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(Nombre1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Precio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Error_Nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Error_Precio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TextDescripcion, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Error_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Error_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CerrarSesion5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addComponent(BEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BEliminarMouseEntered
        BEliminar.setBackground(new Color(249,16,0));
    }//GEN-LAST:event_BEliminarMouseEntered

    private void BEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BEliminarMouseExited
        BEliminar.setBackground(new Color(153,0,0));
    }//GEN-LAST:event_BEliminarMouseExited

    private void BEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEliminarActionPerformed
        if(control.EliminarServicio()){
            GestiondeCatalogo destino = new GestiondeCatalogo();
            control.ConectarPanel(this, destino, 960, 639, 1, 0);
        }

    }//GEN-LAST:event_BEliminarActionPerformed

    private void BModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BModificarMouseEntered
        BModificar.setBackground(new Color(4,119,255));
    }//GEN-LAST:event_BModificarMouseEntered

    private void BModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BModificarMouseExited
        BModificar.setBackground(new Color(0,0,102));
    }//GEN-LAST:event_BModificarMouseExited

    private void BModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BModificarActionPerformed
        control.ModificarServicio(nameOriginal);
    }//GEN-LAST:event_BModificarActionPerformed

    private void CerrarSesion5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesion5ActionPerformed
        GestiondeCatalogo destino = new GestiondeCatalogo();
        control.ConectarPanel(this, destino, 960, 639, 1, 0);
    }//GEN-LAST:event_CerrarSesion5ActionPerformed

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed

    }//GEN-LAST:event_NombreActionPerformed

    private void NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreKeyTyped

    }//GEN-LAST:event_NombreKeyTyped

    private void Nombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre1ActionPerformed

    }//GEN-LAST:event_Nombre1ActionPerformed

    private void Nombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nombre1KeyTyped
        int key = evt.getKeyChar();

        boolean numeros = ((key == 46) || (key >= 48 && key <= 57)) || key==127 || key==8 || key==32 || (key >= 97 && key <= 122) || (key >= 65 && key <= 90);

        if (!numeros)
        {
            Error_Nombre.setText("No se aceptan caracteres especiales");
            //JOptionPane.showMessageDialog(null, "ADVERTENCIA no se aceptan caracteres especiales ni letras","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_Nombre1KeyTyped

    private void PrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecioActionPerformed

    private void PrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrecioKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = (key >= 48 && key <= 57) || key==127 || key==8;

        if (!numeros)
        {
            Error_Precio.setText("No se aceptan caracteres especiales ni letras");
            //JOptionPane.showMessageDialog(null, "ADVERTENCIA no se aceptan caracteres especiales ni letras","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_PrecioKeyTyped

    private void Error_PrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Error_PrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Error_PrecioActionPerformed

    private void TextDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextDescripcionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BEliminar;
    private javax.swing.JButton BModificar;
    private rsbuttom.RSButtonMetro CerrarSesion5;
    private javax.swing.JTextField Error_Nombre;
    private javax.swing.JTextField Error_Precio;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField Nombre1;
    private javax.swing.JTextField Precio;
    private javax.swing.JTextField TextDescripcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}