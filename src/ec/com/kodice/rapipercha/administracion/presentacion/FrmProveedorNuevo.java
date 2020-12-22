/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.presentacion;

import ec.com.kodice.rapipercha.administracion.negocio.PerfilBO;
import ec.com.kodice.rapipercha.administracion.negocio.ProveedorBO;
import ec.com.kodice.rapipercha.administracion.negocio.UsuarioBO;
import ec.com.kodice.rapipercha.administracion.persistencia.PerfilVO;
import ec.com.kodice.rapipercha.administracion.persistencia.ProveedorVO;
import ec.com.kodice.rapipercha.administracion.persistencia.UsuarioVO;
import ec.com.kodice.rapipercha.util.UtilPresentacion;
import javax.swing.JOptionPane;

/**
 *
 * Esta clase contiene atributos y métodos del formulario FrmPerfilAdministracion
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/06
 */
public class FrmProveedorNuevo extends javax.swing.JDialog {
    private int codigoActual = 0;

    public void setCodigoActual(int codigoActual) {
        this.codigoActual = codigoActual;
    }

    /** Creates new form FrmPerfilAdministracion */
    public FrmProveedorNuevo(int codigoActual, boolean soloLectura) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.codigoActual = codigoActual;
        if (soloLectura)
            seteaControles(soloLectura);
        cargarDatos();
    }
    
    public FrmProveedorNuevo() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.codigoActual = 0;
        cargarDatos();
    }
    private void seteaControles(boolean soloLectura){
        btnGrabar.setEnabled(!soloLectura);
    }
    private void cargarDatos(){
        ProveedorVO proveedorVO = null;
        ProveedorBO proveedorBO = new ProveedorBO();
        String nombrePerfil;
        try {
            if (codigoActual!=0){
                proveedorVO=proveedorBO.buscar(codigoActual);
            }
        }
        catch ( Exception e) {
            UtilPresentacion.mostrarMensajeError(this, e.getMessage());
        }
        finally{
            if (proveedorVO != null){
                        txtCodigo.setText(String.valueOf(proveedorVO.getCodigo()));
                        txtRuc.setText(proveedorVO.getRuc());
                        txtRazonSocial.setText(proveedorVO.getRazonSocial());
                        txtNombreComercial.setText(proveedorVO.getNombreComercial());
                        txtNombreContacto.setText(proveedorVO.getNombreContacto());
                        txtApellidoContacto.setText(proveedorVO.getApellidoContacto());
                        txtTelefonoContacto.setText(proveedorVO.getTelefonoContacto());
                        txtCorreoContacto.setText(proveedorVO.getCorreoContacto());
            }
            proveedorVO = null;
            proveedorBO = null;
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenedor = new javax.swing.JPanel();
        pnlCabecera = new javax.swing.JPanel();
        lblLogoRapipercha = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        pnlDetalle = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblRuc = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        lblRazonSocial = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        lblNombreComercial = new javax.swing.JLabel();
        txtNombreComercial = new javax.swing.JTextField();
        lblNombreContacto = new javax.swing.JLabel();
        txtNombreContacto = new javax.swing.JTextField();
        lblApellidoContacto = new javax.swing.JLabel();
        txtApellidoContacto = new javax.swing.JTextField();
        lblTelefonoContacto = new javax.swing.JLabel();
        txtTelefonoContacto = new javax.swing.JTextField();
        lblCorreoContacto = new javax.swing.JLabel();
        txtCorreoContacto = new javax.swing.JTextField();
        pnlPie = new javax.swing.JPanel();
        btnGrabar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblLogoKodice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        pnlContenedor.setAlignmentX(0.0F);
        pnlContenedor.setAlignmentY(0.0F);
        pnlContenedor.setPreferredSize(new java.awt.Dimension(800, 600));

        pnlCabecera.setBackground(new java.awt.Color(64, 124, 202));
        pnlCabecera.setAlignmentX(0.0F);
        pnlCabecera.setAlignmentY(0.0F);
        pnlCabecera.setMaximumSize(new java.awt.Dimension(32767, 90));
        pnlCabecera.setMinimumSize(new java.awt.Dimension(0, 90));
        pnlCabecera.setPreferredSize(new java.awt.Dimension(518, 90));

        lblLogoRapipercha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/logo-rapipercha.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("PROVEEDOR");

        javax.swing.GroupLayout pnlCabeceraLayout = new javax.swing.GroupLayout(pnlCabecera);
        pnlCabecera.setLayout(pnlCabeceraLayout);
        pnlCabeceraLayout.setHorizontalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addComponent(lblLogoRapipercha)
                .addGap(202, 202, 202)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlCabeceraLayout.setVerticalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogoRapipercha)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(30, 30, 30))
        );

        pnlDetalle.setAlignmentX(0.0F);
        pnlDetalle.setAlignmentY(0.0F);

        lblCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCodigo.setText("Código:");

        txtCodigo.setEnabled(false);
        txtCodigo.setMinimumSize(new java.awt.Dimension(7, 22));
        txtCodigo.setPreferredSize(new java.awt.Dimension(7, 22));

        lblRuc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRuc.setText("Ruc:");

        txtRuc.setMinimumSize(new java.awt.Dimension(7, 22));
        txtRuc.setPreferredSize(new java.awt.Dimension(7, 22));

        lblRazonSocial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRazonSocial.setText("Razón social:");

        txtRazonSocial.setMinimumSize(new java.awt.Dimension(7, 22));
        txtRazonSocial.setPreferredSize(new java.awt.Dimension(7, 22));

        lblNombreComercial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNombreComercial.setText("Nombre comercial:");

        txtNombreComercial.setMinimumSize(new java.awt.Dimension(7, 22));
        txtNombreComercial.setPreferredSize(new java.awt.Dimension(7, 22));

        lblNombreContacto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNombreContacto.setText("Nombre contacto:");

        txtNombreContacto.setMinimumSize(new java.awt.Dimension(7, 22));
        txtNombreContacto.setPreferredSize(new java.awt.Dimension(7, 22));

        lblApellidoContacto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblApellidoContacto.setText("Apellido contacto:");

        txtApellidoContacto.setMinimumSize(new java.awt.Dimension(7, 22));
        txtApellidoContacto.setPreferredSize(new java.awt.Dimension(7, 22));

        lblTelefonoContacto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTelefonoContacto.setText("Teléfono contacto:");

        txtTelefonoContacto.setMinimumSize(new java.awt.Dimension(7, 22));
        txtTelefonoContacto.setPreferredSize(new java.awt.Dimension(7, 22));

        lblCorreoContacto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCorreoContacto.setText("Correo contacto:");

        txtCorreoContacto.setMinimumSize(new java.awt.Dimension(7, 22));
        txtCorreoContacto.setPreferredSize(new java.awt.Dimension(7, 22));

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createSequentialGroup()
                        .addComponent(lblTelefonoContacto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefonoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createSequentialGroup()
                        .addComponent(lblRazonSocial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblApellidoContacto)
                            .addComponent(lblNombreComercial)
                            .addComponent(lblRuc)
                            .addComponent(lblNombreContacto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createSequentialGroup()
                        .addComponent(lblCorreoContacto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCorreoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRuc)
                            .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRazonSocial))
                        .addGap(16, 16, 16)
                        .addComponent(lblNombreComercial))
                    .addComponent(txtNombreComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombreContacto)
                    .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblApellidoContacto)
                    .addComponent(txtApellidoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTelefonoContacto)
                    .addComponent(txtTelefonoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCorreoContacto)
                    .addComponent(txtCorreoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPie.setMaximumSize(new java.awt.Dimension(32767, 90));
        pnlPie.setMinimumSize(new java.awt.Dimension(0, 90));
        pnlPie.setPreferredSize(new java.awt.Dimension(780, 90));

        btnGrabar.setBackground(new java.awt.Color(64, 124, 202));
        btnGrabar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGrabar.setForeground(new java.awt.Color(255, 255, 255));
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/Disquette.png"))); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.setToolTipText("");
        btnGrabar.setAlignmentY(0.0F);
        btnGrabar.setBorderPainted(false);
        btnGrabar.setPreferredSize(new java.awt.Dimension(125, 57));
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(64, 124, 202));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/Badge-cancel.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setAlignmentY(0.0F);
        btnSalir.setBorderPainted(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblLogoKodice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/logo-kodice.png"))); // NOI18N

        javax.swing.GroupLayout pnlPieLayout = new javax.swing.GroupLayout(pnlPie);
        pnlPie.setLayout(pnlPieLayout);
        pnlPieLayout.setHorizontalGroup(
            pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPieLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogoKodice)
                .addGap(48, 48, 48))
        );
        pnlPieLayout.setVerticalGroup(
            pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogoKodice, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPie, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addComponent(pnlCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 418, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        ProveedorVO proveedorVO = null;
        ProveedorBO proveedorBO = null;
        int respuestaOperacion = 0;
        boolean camposValidos;
        camposValidos = 
            (!txtRuc.getText().isEmpty() && 
                !txtRuc.getText().trim().equals("") && 
                !txtRazonSocial.getText().isEmpty() && 
                !txtRazonSocial.getText().trim().equals("") &&                 
                !txtNombreComercial.getText().isEmpty() && 
                !txtNombreComercial.getText().trim().equals("") &&                 
                !txtNombreContacto.getText().isEmpty() && 
                !txtNombreContacto.getText().trim().equals("") &&                 
                !txtApellidoContacto.getText().isEmpty() && 
                !txtApellidoContacto.getText().trim().equals("") &&                 
                !txtTelefonoContacto.getText().isEmpty() && 
                !txtTelefonoContacto.getText().trim().equals("") &&                 
                !txtCorreoContacto.getText().isEmpty() && 
                !txtCorreoContacto.getText().trim().equals("") 
                );                
        if (camposValidos){
                proveedorBO = new ProveedorBO();
                proveedorVO = new ProveedorVO(codigoActual, txtRuc.getText(),
                    txtNombreComercial.getText(), txtRazonSocial.getText(),
                    txtNombreContacto.getText(), txtApellidoContacto.getText(),
                    txtTelefonoContacto.getText(), txtCorreoContacto.getText()
                );                            
                try{
                    if (codigoActual==0){
                        respuestaOperacion = proveedorBO.crear(proveedorVO);
                        txtCodigo.setText(String.valueOf(respuestaOperacion));
                    }else
                        respuestaOperacion = proveedorBO.actualizar(proveedorVO);
                    if (respuestaOperacion>0)
                        JOptionPane.showMessageDialog(null, "Registro guardado con éxito");
                }
                catch(Exception e){
                    UtilPresentacion.mostrarMensajeError(this, e.getMessage());
                }
                finally{
                    proveedorVO = null;
                    proveedorBO = null;
                    this.setVisible(false);
                    this.dispose();
                }
        }else {
            UtilPresentacion.mostrarMensajeValidacionIncorrecta(this, 
                "Ingrese los datos requeridos en el formulario");
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(FrmProveedorNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProveedorNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProveedorNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProveedorNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProveedorNuevo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblApellidoContacto;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCorreoContacto;
    private javax.swing.JLabel lblLogoKodice;
    private javax.swing.JLabel lblLogoRapipercha;
    private javax.swing.JLabel lblNombreComercial;
    private javax.swing.JLabel lblNombreContacto;
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JLabel lblTelefonoContacto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlCabecera;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JPanel pnlPie;
    private javax.swing.JTextField txtApellidoContacto;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreoContacto;
    private javax.swing.JTextField txtNombreComercial;
    private javax.swing.JTextField txtNombreContacto;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelefonoContacto;
    // End of variables declaration//GEN-END:variables

}
