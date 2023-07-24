/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.practica_05_ssuquilanda_jabad.vista.disco;

import ec.edu.ups.practica_05_ssuquilanda_jabad.controlador.ControladorCantante;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Cantante;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Compositor;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Disco;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samanthasuquilandaquilli
 */
public class VentanaListarDisco extends javax.swing.JInternalFrame {
    private ControladorCantante controladorCantante;
    private ResourceBundle mensajes;
    /**
     * Creates new form VentanaListarDisco
     */
    public VentanaListarDisco(ControladorCantante controladorCantante) {
        initComponents();
        this.controladorCantante = controladorCantante;
    }
    
    public void cambiarIdioma(Locale localizacion){
        mensajes = ResourceBundle.getBundle("mensajes.mensaje", localizacion);
        jLabel1.setText(mensajes.getString("txtIngresarCódigoDelCompositorParaListarSusCanciones"));
        
        lblNombreCrearPersona2.setText(mensajes.getString("txtCódigo"));
        lblNombreCrearPersona1.setText(mensajes.getString("txtNombre"));        
        lblFechaNacimientoCrearPersona.setText(mensajes.getString("txtApellido"));        
        lblNombreCrearPersona3.setText(mensajes.getString("txtEdad"));        
        lblNacionalidadBuscarCantante.setText(mensajes.getString("txtNacionalidad"));   
        lblNomArtisticoBuscarCantante.setText(mensajes.getString("txtNombreArtístico"));        
        lblGenMusicalBuscarCantante.setText(mensajes.getString("txtGéneroMusical"));        
        lblNumSencillosBuscarCantante.setText(mensajes.getString("txtNúmeroDeSencillos"));        
        lblNumConciertosBuscarCantante.setText(mensajes.getString("txtNúmeroDeConciertos"));
        lblNumGirasBuscarCantante.setText(mensajes.getString("txtNúmeroDeGiras"));        
        lblSalarioBaseBuscarCantante1.setText(mensajes.getString("txtSalarioBase"));
        lblSalarioFinalBuscarCantante.setText(mensajes.getString("txtSalarioFinal"));
        btnBuscarBuscarCantante.setText(mensajes.getString("txtBuscar"));
        btnCancelarBuscarCantante.setText(mensajes.getString("txtCancelar"));
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
        lblNumGirasBuscarCantante = new javax.swing.JLabel();
        txtCodigoCantante = new javax.swing.JTextField();
        txtNombreCantante = new javax.swing.JTextField();
        btnBuscarBuscarCantante = new javax.swing.JButton();
        btnCancelarBuscarCantante = new javax.swing.JButton();
        lblCantante = new javax.swing.JLabel();
        lblNombreCrearPersona1 = new javax.swing.JLabel();
        lblNombreCrearPersona2 = new javax.swing.JLabel();
        lblNombreCrearPersona3 = new javax.swing.JLabel();
        lblNacionalidadBuscarCantante = new javax.swing.JLabel();
        lblNomArtisticoBuscarCantante = new javax.swing.JLabel();
        lblGenMusicalBuscarCantante = new javax.swing.JLabel();
        lblNumSencillosBuscarCantante = new javax.swing.JLabel();
        lblNumConciertosBuscarCantante = new javax.swing.JLabel();
        txtNomArtisticoCantante = new javax.swing.JTextField();
        txtApellidoCantante = new javax.swing.JTextField();
        txtEdadCantante = new javax.swing.JTextField();
        txtNumSencillosCantante = new javax.swing.JTextField();
        txtNumConciertosCantante = new javax.swing.JTextField();
        txtNumGirasCantante = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblSalarioFinalBuscarCantante = new javax.swing.JLabel();
        txtSalarioFinalCantante = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        lblSalarioBaseBuscarCantante1 = new javax.swing.JLabel();
        txtSalarioBaseCantante = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListarDiscoListarCantante = new javax.swing.JTable();
        cbxPaisesActualizarCantante = new javax.swing.JComboBox<>();
        cbxGeneroMusicalCantante = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCantante.setBackground(new java.awt.Color(255, 255, 255));
        panelCantante.setToolTipText("");
        panelCantante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFechaNacimientoCrearPersona.setFont(new java.awt.Font("AkayaTelivigala", 0, 24)); // NOI18N
        lblFechaNacimientoCrearPersona.setText("Apellido:");
        panelCantante.add(lblFechaNacimientoCrearPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 160, 30));

        lblNumGirasBuscarCantante.setFont(new java.awt.Font("AkayaKanadaka", 0, 24)); // NOI18N
        lblNumGirasBuscarCantante.setText("Num. Giras:");
        panelCantante.add(lblNumGirasBuscarCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 320, 30));

        txtCodigoCantante.setToolTipText("Ingrese el codigo del cantante");
        txtCodigoCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoCantanteActionPerformed(evt);
            }
        });
        panelCantante.add(txtCodigoCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 220, 30));

        txtNombreCantante.setToolTipText("Este es el Nombre del cantante");
        txtNombreCantante.setEnabled(false);
        txtNombreCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCantanteActionPerformed(evt);
            }
        });
        panelCantante.add(txtNombreCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 220, 30));

        btnBuscarBuscarCantante.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnBuscarBuscarCantante.setText("Buscar");
        btnBuscarBuscarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarBuscarCantanteActionPerformed(evt);
            }
        });
        panelCantante.add(btnBuscarBuscarCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, 106, 32));

        btnCancelarBuscarCantante.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnCancelarBuscarCantante.setText("Cancelar");
        btnCancelarBuscarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarBuscarCantanteActionPerformed(evt);
            }
        });
        panelCantante.add(btnCancelarBuscarCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 104, 32));

        lblCantante.setFont(new java.awt.Font("AkayaTelivigala", 1, 36)); // NOI18N
        lblCantante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/My project-1-3.png"))); // NOI18N
        lblCantante.setText("UPS Musik");
        lblCantante.setPreferredSize(new java.awt.Dimension(200, 400));
        panelCantante.add(lblCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 330, 50));

        lblNombreCrearPersona1.setFont(new java.awt.Font("AkayaTelivigala", 0, 24)); // NOI18N
        lblNombreCrearPersona1.setText("Nombre:");
        panelCantante.add(lblNombreCrearPersona1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 130, 30));

        lblNombreCrearPersona2.setFont(new java.awt.Font("AkayaKanadaka", 0, 24)); // NOI18N
        lblNombreCrearPersona2.setText("Codigo:");
        panelCantante.add(lblNombreCrearPersona2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, 30));

        lblNombreCrearPersona3.setFont(new java.awt.Font("AkayaKanadaka", 0, 24)); // NOI18N
        lblNombreCrearPersona3.setText("Edad:");
        panelCantante.add(lblNombreCrearPersona3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 230, 30));

        lblNacionalidadBuscarCantante.setFont(new java.awt.Font("AkayaKanadaka", 0, 24)); // NOI18N
        lblNacionalidadBuscarCantante.setText("Nacionalidad:");
        panelCantante.add(lblNacionalidadBuscarCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 280, 30));

        lblNomArtisticoBuscarCantante.setFont(new java.awt.Font("AkayaKanadaka", 0, 24)); // NOI18N
        lblNomArtisticoBuscarCantante.setText("Nombre Artístico:");
        lblNomArtisticoBuscarCantante.setToolTipText("");
        panelCantante.add(lblNomArtisticoBuscarCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 320, 30));

        lblGenMusicalBuscarCantante.setFont(new java.awt.Font("AkayaKanadaka", 0, 24)); // NOI18N
        lblGenMusicalBuscarCantante.setText("Género Musical:");
        panelCantante.add(lblGenMusicalBuscarCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 340, 30));

        lblNumSencillosBuscarCantante.setFont(new java.awt.Font("AkayaKanadaka", 0, 24)); // NOI18N
        lblNumSencillosBuscarCantante.setText("Num. Sencillos:");
        panelCantante.add(lblNumSencillosBuscarCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 570, 30));

        lblNumConciertosBuscarCantante.setFont(new java.awt.Font("AkayaKanadaka", 0, 24)); // NOI18N
        lblNumConciertosBuscarCantante.setText("Num. Conciertos:");
        panelCantante.add(lblNumConciertosBuscarCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 330, 30));

        txtNomArtisticoCantante.setToolTipText("Este es el nombre artístico del Cantante");
        txtNomArtisticoCantante.setEnabled(false);
        txtNomArtisticoCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomArtisticoCantanteActionPerformed(evt);
            }
        });
        panelCantante.add(txtNomArtisticoCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 220, 30));

        txtApellidoCantante.setToolTipText("Este es el Apellido del Cantante");
        txtApellidoCantante.setEnabled(false);
        txtApellidoCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoCantanteActionPerformed(evt);
            }
        });
        panelCantante.add(txtApellidoCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 220, 30));

        txtEdadCantante.setToolTipText("Esta es la edad del Cantante");
        txtEdadCantante.setEnabled(false);
        txtEdadCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadCantanteActionPerformed(evt);
            }
        });
        panelCantante.add(txtEdadCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 220, 30));

        txtNumSencillosCantante.setToolTipText("Este es el numero de Sencillos del Cantante");
        txtNumSencillosCantante.setEnabled(false);
        txtNumSencillosCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumSencillosCantanteActionPerformed(evt);
            }
        });
        panelCantante.add(txtNumSencillosCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 220, 30));

        txtNumConciertosCantante.setToolTipText("Este es el numero de Conciertos del Cantante");
        txtNumConciertosCantante.setEnabled(false);
        txtNumConciertosCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumConciertosCantanteActionPerformed(evt);
            }
        });
        panelCantante.add(txtNumConciertosCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 220, 30));

        txtNumGirasCantante.setToolTipText("Este es el numero de Giras del Cantante");
        txtNumGirasCantante.setEnabled(false);
        txtNumGirasCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumGirasCantanteActionPerformed(evt);
            }
        });
        panelCantante.add(txtNumGirasCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 220, 30));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setText("Ingrese el codigo del cantante del cual se va a listar los discos:");
        panelCantante.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 510, 30));

        lblSalarioFinalBuscarCantante.setFont(new java.awt.Font("AkayaKanadaka", 0, 24)); // NOI18N
        lblSalarioFinalBuscarCantante.setText("Salario Final:");
        panelCantante.add(lblSalarioFinalBuscarCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 490, 30));

        txtSalarioFinalCantante.setToolTipText("Este es el salario del Cantante");
        txtSalarioFinalCantante.setEnabled(false);
        txtSalarioFinalCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioFinalCantanteActionPerformed(evt);
            }
        });
        panelCantante.add(txtSalarioFinalCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 220, 30));

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setResizable(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelCantante.add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblSalarioBaseBuscarCantante1.setFont(new java.awt.Font("AkayaKanadaka", 0, 24)); // NOI18N
        lblSalarioBaseBuscarCantante1.setText("Salario Base:");
        panelCantante.add(lblSalarioBaseBuscarCantante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 340, 30));

        txtSalarioBaseCantante.setToolTipText("Este es el salario del Cantante");
        txtSalarioBaseCantante.setEnabled(false);
        txtSalarioBaseCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioBaseCantanteActionPerformed(evt);
            }
        });
        panelCantante.add(txtSalarioBaseCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 220, 30));

        tblListarDiscoListarCantante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Año de Lanzamiento"
            }
        ));
        jScrollPane2.setViewportView(tblListarDiscoListarCantante);

        panelCantante.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 630, -1));

        cbxPaisesActualizarCantante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecciona un País--" }));
        cbxPaisesActualizarCantante.setToolTipText("Puede cambiar la nacionalidad");
        cbxPaisesActualizarCantante.setEnabled(false);
        cbxPaisesActualizarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPaisesActualizarCantanteActionPerformed(evt);
            }
        });
        panelCantante.add(cbxPaisesActualizarCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 220, 30));

        cbxGeneroMusicalCantante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecciona un Género--" }));
        cbxGeneroMusicalCantante.setToolTipText("Puede cambiar el género musical");
        cbxGeneroMusicalCantante.setEnabled(false);
        cbxGeneroMusicalCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGeneroMusicalCantanteActionPerformed(evt);
            }
        });
        panelCantante.add(cbxGeneroMusicalCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 220, 30));

        getContentPane().add(panelCantante, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        
    }//GEN-LAST:event_formInternalFrameActivated

    private void txtSalarioBaseCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioBaseCantanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioBaseCantanteActionPerformed

    private void txtNumGirasCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumGirasCantanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumGirasCantanteActionPerformed

    private void txtNumConciertosCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumConciertosCantanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumConciertosCantanteActionPerformed

    private void txtNumSencillosCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumSencillosCantanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumSencillosCantanteActionPerformed

    private void txtEdadCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadCantanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadCantanteActionPerformed

    private void txtApellidoCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoCantanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoCantanteActionPerformed

    private void txtNomArtisticoCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomArtisticoCantanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomArtisticoCantanteActionPerformed

    private void btnCancelarBuscarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarBuscarCantanteActionPerformed
        this.limpiarCampos();
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarBuscarCantanteActionPerformed

    private void btnBuscarBuscarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarBuscarCantanteActionPerformed
        String codigo = txtCodigoCantante.getText();
        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El codigo del cantante a buscar no ha sido ingresado!");
        } else {
            int codiguito = Integer.parseInt(codigo);

            Cantante cantante = controladorCantante.buscarCantante(codiguito);
            if (cantante != null) {
                txtNombreCantante.setText(cantante.getNombre());
                txtApellidoCantante.setText(cantante.getApellido());
                String edad = String.valueOf(cantante.getEdad());
                txtEdadCantante.setText(edad);
                cbxPaisesActualizarCantante.setSelectedItem(cantante.getNacionalidad());
                txtNomArtisticoCantante.setText(cantante.getNombreArtistico());
                cbxGeneroMusicalCantante.setSelectedItem(cantante.getGeneroMusical());
                String numSencillos = String.valueOf(cantante.getNumeroDeSencillos());
                txtNumSencillosCantante.setText(numSencillos);
                String numConciertos = String.valueOf(cantante.getNumeroDeConciertos());
                txtNumConciertosCantante.setText(numConciertos);
                String numGiras = String.valueOf(cantante.getNumeroDeGiras());
                txtNumGirasCantante.setText(numGiras);
                String salarioCan = String.valueOf(cantante.getSalario());
                String salarioCanF = String.valueOf(cantante.getSalarioFinal());
                txtSalarioFinalCantante.setText(salarioCanF);
                txtSalarioBaseCantante.setText(salarioCan);
                JOptionPane.showMessageDialog(this, "El/La cantante con codigo " + codiguito + " ha sido encontrado !:)");
                this.cargarDatosTablaDiscos();
            } else {
                JOptionPane.showMessageDialog(this, "El/La cantante con codigo " + codiguito + " no ha sido encontrada !:(");

                this.limpiarCampos();
            }
        }
    }//GEN-LAST:event_btnBuscarBuscarCantanteActionPerformed

    private void txtNombreCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCantanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCantanteActionPerformed

    private void txtCodigoCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoCantanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoCantanteActionPerformed

    private void cbxPaisesActualizarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPaisesActualizarCantanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPaisesActualizarCantanteActionPerformed

    private void cbxGeneroMusicalCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGeneroMusicalCantanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxGeneroMusicalCantanteActionPerformed

    private void txtSalarioFinalCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioFinalCantanteActionPerformed

    }//GEN-LAST:event_txtSalarioFinalCantanteActionPerformed
    private void cargarDatosTablaDiscos() {
        DefaultTableModel modelo = (DefaultTableModel) this.tblListarDiscoListarCantante.getModel();
        modelo.setNumRows(0);
        String codigoCantante = txtCodigoCantante.getText();
        int codiguito = Integer.parseInt(codigoCantante);
        Cantante cantanteSeleccionado = controladorCantante.buscarCantante(codiguito);
        
        
        List<Disco> discografia = controladorCantante.discografia(cantanteSeleccionado);
        
        
        System.out.println(discografia.size());
        
        for (Disco disco : discografia) {
            if(disco.getCodigo() != 0){
            String codigo = String.valueOf(disco.getCodigo());
            String nombre = disco.getNombre();
            String anioLanzamiento = String.valueOf(disco.getAnioDeLanzamiento());

            Object[] rowData = {codigo, nombre, anioLanzamiento};
            modelo.addRow(rowData);
            }
        }
        this.tblListarDiscoListarCantante.setModel(modelo);
    }
    
    
    
    private void limpiarCampos() {
        this.txtCodigoCantante.setText("");
        this.txtNombreCantante.setText("");
        this.txtApellidoCantante.setText("");
        this.txtEdadCantante.setText("");
        this.cbxPaisesActualizarCantante.setSelectedItem("--Selecciona un País--");
        this.cbxGeneroMusicalCantante.setSelectedItem("--Selecciona un Género--");
        this.txtNomArtisticoCantante.setText("");
        this.txtNumSencillosCantante.setText("");
        this.txtNumConciertosCantante.setText("");
        this.txtNumGirasCantante.setText("");
        this.txtSalarioBaseCantante.setText("");
        this.txtSalarioFinalCantante.setText("");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarBuscarCantante;
    private javax.swing.JButton btnCancelarBuscarCantante;
    private javax.swing.JComboBox<String> cbxGeneroMusicalCantante;
    private javax.swing.JComboBox<String> cbxPaisesActualizarCantante;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCantante;
    private javax.swing.JLabel lblFechaNacimientoCrearPersona;
    private javax.swing.JLabel lblGenMusicalBuscarCantante;
    private javax.swing.JLabel lblNacionalidadBuscarCantante;
    private javax.swing.JLabel lblNomArtisticoBuscarCantante;
    private javax.swing.JLabel lblNombreCrearPersona1;
    private javax.swing.JLabel lblNombreCrearPersona2;
    private javax.swing.JLabel lblNombreCrearPersona3;
    private javax.swing.JLabel lblNumConciertosBuscarCantante;
    private javax.swing.JLabel lblNumGirasBuscarCantante;
    private javax.swing.JLabel lblNumSencillosBuscarCantante;
    private javax.swing.JLabel lblSalarioBaseBuscarCantante1;
    private javax.swing.JLabel lblSalarioFinalBuscarCantante;
    private javax.swing.JPanel panelCantante;
    private javax.swing.JTable tblListarDiscoListarCantante;
    private javax.swing.JTextField txtApellidoCantante;
    private javax.swing.JTextField txtCodigoCantante;
    private javax.swing.JTextField txtEdadCantante;
    private javax.swing.JTextField txtNomArtisticoCantante;
    private javax.swing.JTextField txtNombreCantante;
    private javax.swing.JTextField txtNumConciertosCantante;
    private javax.swing.JTextField txtNumGirasCantante;
    private javax.swing.JTextField txtNumSencillosCantante;
    private javax.swing.JTextField txtSalarioBaseCantante;
    private javax.swing.JTextField txtSalarioFinalCantante;
    // End of variables declaration//GEN-END:variables
}
