/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisbanco2;

import java.rmi.Naming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlos
 */
public class Interfaz_Cliente extends javax.swing.JFrame {
    
    public Interfaz_Cliente() {
        initComponents();
    }
    
    public String capturarid(){
        String id = tfidcliente.getText();
        return id;
    }
    
    public void limpiar_tabla(){
        DefaultTableModel dftable = (DefaultTableModel) tabla_factura_pendiente.getModel();
        for (int i = 0; i < tabla_factura_pendiente.getRowCount(); i++) {
        dftable.removeRow(i);
        i-=1;
        }
    }
    
    public void conexion_banco(int idcliente){
        ///////////////////////////////////////////////////////////////////////////////////
      IOperacionesEmpresa operaciones;
      String pago="";
	try {
	    operaciones=(IOperacionesEmpresa)Naming.lookup("rmi://localhost/Operaciones");

	    Factura [] pendientes=operaciones.calcular(idcliente);
            llenar_tabla(pendientes);
            if (pendientes.length!=0)
            {
                pago=operaciones.pagar(pendientes);
                lblpagoresultado.setText("Se llamo a pagar con exito "+pago);
            }
                System.out.println();
	}
	catch (Exception e){
	    e.printStackTrace();
	}
///////////////////////////////////////////////////////////////////////////////////
    }

    public void llenar_tabla(Factura[] pendientes){
        
        limpiar_tabla();
        for(Factura f:pendientes){
        String Empresa = f.getEmpresa()+"";
        String IdFactura = f.getIdFactura()+"";
        String Monto = f.getMonto()+"";
        DefaultTableModel dftable = (DefaultTableModel) tabla_factura_pendiente.getModel();
        Object obj[] = {Empresa,IdFactura,Monto};
        dftable.addRow(obj);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfpagoresultado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfidcliente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_factura_pendiente = new javax.swing.JTable();
        lblpagoresultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Banco Central");

        jLabel2.setText("Id de Cliente : ");

        jButton1.setText("Facturas Pendientes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabla_factura_pendiente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Empresa", "Id Factura", "Monto(Bs)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_factura_pendiente);
        if (tabla_factura_pendiente.getColumnModel().getColumnCount() > 0) {
            tabla_factura_pendiente.getColumnModel().getColumn(0).setResizable(false);
            tabla_factura_pendiente.getColumnModel().getColumn(1).setResizable(false);
        }

        lblpagoresultado.setText("                        ");

        javax.swing.GroupLayout tfpagoresultadoLayout = new javax.swing.GroupLayout(tfpagoresultado);
        tfpagoresultado.setLayout(tfpagoresultadoLayout);
        tfpagoresultadoLayout.setHorizontalGroup(
            tfpagoresultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tfpagoresultadoLayout.createSequentialGroup()
                .addGroup(tfpagoresultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tfpagoresultadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(tfpagoresultadoLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(tfpagoresultadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(tfpagoresultadoLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(lblpagoresultado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tfpagoresultadoLayout.setVerticalGroup(
            tfpagoresultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tfpagoresultadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(tfpagoresultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblpagoresultado)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfpagoresultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfpagoresultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int id = Integer.parseInt(capturarid());
        //probar_conexion();
        conexion_banco(id);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Interfaz_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblpagoresultado;
    private javax.swing.JTable tabla_factura_pendiente;
    private javax.swing.JTextField tfidcliente;
    private javax.swing.JPanel tfpagoresultado;
    // End of variables declaration//GEN-END:variables
}
