/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.practica_05_ssuquilanda_jabad.vista.compositor;

import ec.edu.ups.practica_05_ssuquilanda_jabad.controlador.ControladorCompositor;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Cantante;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Compositor;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author samanthasuquilandaquilli
 */
public class VentanaEliminarCompositor extends javax.swing.JInternalFrame {
    private ControladorCompositor controladorCompositor;
    private ResourceBundle mensajes;
    /**
     * Creates new form VentanaEliminarCompositor
     */
    public VentanaEliminarCompositor(ControladorCompositor controladorCompositor) {
        initComponents();
        this.controladorCompositor =  controladorCompositor;
    }
    public void cambiarIdioma(Locale localizacion){
        mensajes = ResourceBundle.getBundle("mensajes.mensaje", localizacion);
        jLabel1.setText(mensajes.getString("txtEliminarCompositor"));
        lblNombreCrearPersona2.setText(mensajes.getString("txtCódigo"));
        lblNombreCrearPersona1.setText(mensajes.getString("txtNombre"));        
        lblFechaNacimientoCrearPersona.setText(mensajes.getString("txtApellido"));        
        lblNombreCrearPersona3.setText(mensajes.getString("txtEdad"));        
        lblNombreCrearPersona4.setText(mensajes.getString("txtNacionalidad"));       
        lblNombreCrearPersona6.setText(mensajes.getString("txtNúmeroDeComposiciónes"));        
        lblNombreCrearPersona10.setText(mensajes.getString("txtSalarioBase"));
        btnBuscarCompositor.setText(mensajes.getString("txtBuscar"));
        btnAceptarEliminarCompositor.setText(mensajes.getString("txtEliminar"));
        btnCancelarCompositor.setText(mensajes.getString("txtCancelar"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCantante = new javax.swing.JPanel();
        lblFechaNacimientoCrearPersona = new javax.swing.JLabel();
        txtCodigoCompositor = new javax.swing.JTextField();
        txtNombreCompositor = new javax.swing.JTextField();
        btnAceptarEliminarCompositor = new javax.swing.JButton();
        btnCancelarCompositor = new javax.swing.JButton();
        lblicono = new javax.swing.JLabel();
        lblcantantaFondo = new javax.swing.JLabel();
        lblCantante = new javax.swing.JLabel();
        lblNombreCrearPersona1 = new javax.swing.JLabel();
        lblNombreCrearPersona2 = new javax.swing.JLabel();
        lblNombreCrearPersona3 = new javax.swing.JLabel();
        lblNombreCrearPersona4 = new javax.swing.JLabel();
        lblNombreCrearPersona6 = new javax.swing.JLabel();
        txtNumComposicionesCompositor = new javax.swing.JTextField();
        txtApellidoCompositor = new javax.swing.JTextField();
        txtEdadCompositor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblNombreCrearPersona10 = new javax.swing.JLabel();
        txtSalarioCompositor = new javax.swing.JTextField();
        btnBuscarCompositor = new javax.swing.JButton();
        txtEdadCompositor1 = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        panelCantante.setBackground(new java.awt.Color(255, 255, 255));
        panelCantante.setToolTipText("Crear Nueva Persona");
        panelCantante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFechaNacimientoCrearPersona.setFont(new java.awt.Font("AkayaTelivigala", 0, 24)); // NOI18N
        lblFechaNacimientoCrearPersona.setText("Apellido:");
        panelCantante.add(lblFechaNacimientoCrearPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 160, 30));

        txtCodigoCompositor.setToolTipText("Ingrese el codigo del cantante");
        txtCodigoCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoCompositorActionPerformed(evt);
            }
        });
        panelCantante.add(txtCodigoCompositor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 240, 30));

        txtNombreCompositor.setToolTipText("Ingrese el nombre del cantante");
        txtNombreCompositor.setEnabled(false);
        txtNombreCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCompositorActionPerformed(evt);
            }
        });
        panelCantante.add(txtNombreCompositor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 240, 30));

        btnAceptarEliminarCompositor.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnAceptarEliminarCompositor.setText("Eliminar");
        btnAceptarEliminarCompositor.setEnabled(false);
        btnAceptarEliminarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarEliminarCompositorActionPerformed(evt);
            }
        });
        panelCantante.add(btnAceptarEliminarCompositor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 110, 32));

        btnCancelarCompositor.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnCancelarCompositor.setText("Cancelar");
        btnCancelarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCompositorActionPerformed(evt);
            }
        });
        panelCantante.add(btnCancelarCompositor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 100, 32));

        lblicono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/silue h.png"))); // NOI18N
        panelCantante.add(lblicono, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 200, 430));

        lblcantantaFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.jpeg"))); // NOI18N
        lblcantantaFondo.setText("jLabel1");
        panelCantante.add(lblcantantaFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 270, 460));

        lblCantante.setFont(new java.awt.Font("AkayaTelivigala", 1, 36)); // NOI18N
        lblCantante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/My project-1-3.png"))); // NOI18N
        lblCantante.setText("UPS Musik");
        lblCantante.setPreferredSize(new java.awt.Dimension(200, 400));
        panelCantante.add(lblCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 330, 50));

        lblNombreCrearPersona1.setFont(new java.awt.Font("AkayaTelivigala", 0, 24)); // NOI18N
        lblNombreCrearPersona1.setText("Nombre:");
        panelCantante.add(lblNombreCrearPersona1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 140, 30));

        lblNombreCrearPersona2.setFont(new java.awt.Font("AkayaKanadaka", 0, 24)); // NOI18N
        lblNombreCrearPersona2.setText("Codigo:");
        panelCantante.add(lblNombreCrearPersona2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, 30));

        lblNombreCrearPersona3.setFont(new java.awt.Font("AkayaKanadaka", 0, 24)); // NOI18N
        lblNombreCrearPersona3.setText("Edad:");
        panelCantante.add(lblNombreCrearPersona3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 110, 30));

        lblNombreCrearPersona4.setFont(new java.awt.Font("AkayaKanadaka", 0, 24)); // NOI18N
        lblNombreCrearPersona4.setText("Nacionalidad:");
        panelCantante.add(lblNombreCrearPersona4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 170, 30));

        lblNombreCrearPersona6.setFont(new java.awt.Font("AkayaKanadaka", 0, 24)); // NOI18N
        lblNombreCrearPersona6.setText("Num. Composiciones:");
        panelCantante.add(lblNombreCrearPersona6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 290, 30));

        txtNumComposicionesCompositor.setToolTipText("Ingrese el numero de composiciones ");
        txtNumComposicionesCompositor.setEnabled(false);
        txtNumComposicionesCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumComposicionesCompositorActionPerformed(evt);
            }
        });
        panelCantante.add(txtNumComposicionesCompositor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 240, 30));

        txtApellidoCompositor.setToolTipText("Ingrese el apellido del cantante");
        txtApellidoCompositor.setEnabled(false);
        txtApellidoCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoCompositorActionPerformed(evt);
            }
        });
        panelCantante.add(txtApellidoCompositor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 240, 30));

        txtEdadCompositor.setToolTipText("Ingrese le edad del cantante");
        txtEdadCompositor.setEnabled(false);
        txtEdadCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadCompositorActionPerformed(evt);
            }
        });
        panelCantante.add(txtEdadCompositor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 240, 30));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setText("Eliminar Compositor:");
        panelCantante.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 150, 30));

        lblNombreCrearPersona10.setFont(new java.awt.Font("AkayaKanadaka", 0, 24)); // NOI18N
        lblNombreCrearPersona10.setText("Salario :");
        panelCantante.add(lblNombreCrearPersona10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 220, 30));

        txtSalarioCompositor.setToolTipText("Ingrese el salario del Cantante");
        txtSalarioCompositor.setEnabled(false);
        txtSalarioCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioCompositorActionPerformed(evt);
            }
        });
        panelCantante.add(txtSalarioCompositor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 240, 30));

        btnBuscarCompositor.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnBuscarCompositor.setText("Buscar");
        btnBuscarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCompositorActionPerformed(evt);
            }
        });
        panelCantante.add(btnBuscarCompositor, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 90, -1));

        txtEdadCompositor1.setToolTipText("Ingrese le edad del cantante");
        txtEdadCompositor1.setEnabled(false);
        txtEdadCompositor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadCompositor1ActionPerformed(evt);
            }
        });
        panelCantante.add(txtEdadCompositor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 240, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCantante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCantante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        this.limpiarCampos();
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtCodigoCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoCompositorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoCompositorActionPerformed

    private void txtNombreCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCompositorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCompositorActionPerformed

    private void btnAceptarEliminarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarEliminarCompositorActionPerformed
        int codigo = Integer.parseInt(txtCodigoCompositor.getText());
        Compositor compositor = controladorCompositor.buscarCompositor(codigo);

        //Confirmación de si quiere eliminar
        if (controladorCompositor.eliminarCompositor(compositor)) {
            JOptionPane.showMessageDialog(this, "El compositor ha sido eliminado exitosamente! :)");
            this.limpiarCampos();
            this.cambiarEstadoCampos(false);
            this.txtCodigoCompositor.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "El compositor no ha sido eliminado! :(");
        }
    }//GEN-LAST:event_btnAceptarEliminarCompositorActionPerformed

    private void btnCancelarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCompositorActionPerformed
        // TODO add your handling code here:
        this.limpiarCampos();
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarCompositorActionPerformed

    private void txtNumComposicionesCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumComposicionesCompositorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumComposicionesCompositorActionPerformed

    private void txtApellidoCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoCompositorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoCompositorActionPerformed

    private void txtEdadCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadCompositorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadCompositorActionPerformed

    private void txtSalarioCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioCompositorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioCompositorActionPerformed

    private void btnBuscarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCompositorActionPerformed
        if (!camposObligatoriosConDatos()) {
            JOptionPane.showMessageDialog(this, "El codigo de busqueda es obligatorio de llenar. ");
        } else {
            txtCodigoCompositor.setEnabled(false);
            String codigo = txtCodigoCompositor.getText();
            int codiguito = Integer.parseInt(codigo);
            Compositor compositor = controladorCompositor.buscarCompositor(codiguito);
            if (compositor != null) {
                JOptionPane.showMessageDialog(this, "Se ha encontrado un compositor :D ");
                cambiarEstadoCampos(false);
                txtNombreCompositor.setText(compositor.getNombre());
                txtApellidoCompositor.setText(compositor.getApellido());
                txtEdadCompositor1.setText(String.valueOf(compositor.getEdad()));
                txtEdadCompositor.setText(compositor.getNacionalidad());
                txtNumComposicionesCompositor.setText(String.valueOf(compositor.getNumeroDeComposiciones()));
                txtSalarioCompositor.setText(String.valueOf(compositor.getSalarioFinal()));
                btnAceptarEliminarCompositor.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "No se ha encontrado el compositor :C ");
            }
        }
    }//GEN-LAST:event_btnBuscarCompositorActionPerformed

    private void txtEdadCompositor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadCompositor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadCompositor1ActionPerformed
    private void limpiarCampos() {
        this.txtCodigoCompositor.setText("");
        this.txtNombreCompositor.setText("");
        this.txtApellidoCompositor.setText("");
        this.txtEdadCompositor.setText("");
        this.txtEdadCompositor.setText("");
        this.txtSalarioCompositor.setText("");

    }

    private boolean camposObligatoriosConDatos() {
        if (!this.txtCodigoCompositor.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public void cambiarEstadoCampos(boolean estado) {
        txtNombreCompositor.setEditable(estado);
        txtApellidoCompositor.setEditable(estado);
        txtEdadCompositor.setEditable(estado);
        txtEdadCompositor.setEditable(estado);
        txtNumComposicionesCompositor.setEnabled(estado);
        txtSalarioCompositor.setEditable(estado);

    }
    public List<String> generarPaises() {
        List<String> paises = new ArrayList<>();
        paises.add("Afganistán");
        paises.add("Alemania");
        paises.add("Arabia Saudita");
        paises.add("Argentina");
        paises.add("Australia");
        paises.add("Brasil");
        paises.add("Canadá");
        paises.add("China");
        paises.add("Colombia");
        paises.add("Corea del Sur");
        paises.add("Cuba");
        paises.add("Egipto");
        paises.add("España");
        paises.add("Estados Unidos");
        paises.add("Francia");
        paises.add("India");
        paises.add("Indonesia");
        paises.add("Italia");
        paises.add("Japón");
        paises.add("México");
        paises.add("Nigeria");
        paises.add("Pakistán");
        paises.add("Perú");
        paises.add("Reino Unido");
        paises.add("Rusia");
        paises.add("Sudáfrica");
        paises.add("Turquía");
        paises.add("Venezuela");
        return paises;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarEliminarCompositor;
    private javax.swing.JButton btnBuscarCompositor;
    private javax.swing.JButton btnCancelarCompositor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCantante;
    private javax.swing.JLabel lblFechaNacimientoCrearPersona;
    private javax.swing.JLabel lblNombreCrearPersona1;
    private javax.swing.JLabel lblNombreCrearPersona10;
    private javax.swing.JLabel lblNombreCrearPersona2;
    private javax.swing.JLabel lblNombreCrearPersona3;
    private javax.swing.JLabel lblNombreCrearPersona4;
    private javax.swing.JLabel lblNombreCrearPersona6;
    private javax.swing.JLabel lblcantantaFondo;
    private javax.swing.JLabel lblicono;
    private javax.swing.JPanel panelCantante;
    private javax.swing.JTextField txtApellidoCompositor;
    private javax.swing.JTextField txtCodigoCompositor;
    private javax.swing.JTextField txtEdadCompositor;
    private javax.swing.JTextField txtEdadCompositor1;
    private javax.swing.JTextField txtNombreCompositor;
    private javax.swing.JTextField txtNumComposicionesCompositor;
    private javax.swing.JTextField txtSalarioCompositor;
    // End of variables declaration//GEN-END:variables
}
