/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.ni.Frame.panels;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


/**
 *
 * @author Pablo
 */
public class PnlVehicleShowInfo extends javax.swing.JPanel {

    /**
     * Creates new form PnlVehicleShowInfo
     */
    public PnlVehicleShowInfo() {
        initComponents();
    }

    public JComboBox<String> getCmbSearch() {
        return CmbSearch;
    }

    public void setCmbSearch(JComboBox<String> CmbSearch) {
        this.CmbSearch = CmbSearch;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getTableInfo() {
        return TableInfo;
    }

    public void setTableInfo(JTable TableInfo) {
        this.TableInfo = TableInfo;
    }


    public JTextField getjTextFieldSearch() {
        return TextSearch;
    }

    public void setjTextFieldSearch(JTextField jTextFieldSearch) {
        this.TextSearch = jTextFieldSearch;
    }

   

    public JTextField getTextSearch() {
        return TextSearch;
    }

    public void setTextSearch(JTextField TextSearch) {
        this.TextSearch = TextSearch;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableInfo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        CmbSearch = new javax.swing.JComboBox<>();
        TextSearch = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        TableInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N° Record", "Stock number", "Year", "Make", "Model", "Style", "VIN", "Exterior color", "Interior color", "Miles", "Price", "Transmission", "Engine", "Path Image", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableInfo.setRowHeight(30);
        jScrollPane1.setViewportView(TableInfo);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        CmbSearch.setBackground(new java.awt.Color(204, 204, 204));
        CmbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nº Records", "Stock Number", "Year", "Make", "Model", "Style", "VIN", "Exterior Color", "Interior Color", "Miles", "Price", "Transmission", "Engine", "Imagen Path", "Status" }));

        TextSearch.setBackground(new java.awt.Color(204, 204, 204));
        TextSearch.setForeground(new java.awt.Color(102, 102, 102));
        TextSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        TextSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(CmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(377, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void TextSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        // Evento de para buscar el elemeento
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnShowAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbSearch;
    private javax.swing.JTable TableInfo;
    private javax.swing.JTextField TextSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
