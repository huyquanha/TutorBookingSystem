
import java.awt.CardLayout;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class MyRequest extends javax.swing.JPanel {

    /**
     * Creates new form MyRequest
     */
    public MyRequest(ServiceDatabase database, Connection connect) {
        this.database=database;
        this.connect=connect;
        //this.parent=parent;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        requestTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        rateButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 204));
        setPreferredSize(new java.awt.Dimension(1009, 469));

        Object[][] data = database.getRequestByUser();
        requestTable.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "ID", "Service Name", "Request Time", "Service Time", "Duration", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        for (int column = 0; column < requestTable.getColumnCount(); column++)
        {
            TableColumn tableColumn = requestTable.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < requestTable.getRowCount(); row++)
            {
                TableCellRenderer cellRenderer = requestTable.getCellRenderer(row, column);
                Component c = requestTable.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + requestTable.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

                //  We've exceeded the maximum width, no need to check other rows

                if (preferredWidth >= maxWidth)
                {
                    preferredWidth = maxWidth;
                    break;
                }
            }

            tableColumn.setPreferredWidth( preferredWidth );
        }
        requestTable.setShowHorizontalLines(false);
        requestTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(requestTable);

        deleteButton.setBackground(new java.awt.Color(32,33,55));
        deleteButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete Request");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        rateButton.setBackground(new java.awt.Color(32,33,55));
        rateButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        rateButton.setForeground(new java.awt.Color(255, 255, 255));
        rateButton.setText("Rate Service");
        rateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(deleteButton)
                .addGap(188, 188, 188)
                .addComponent(rateButton)
                .addGap(292, 292, 292))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(rateButton))
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = requestTable.getSelectedRow();
        if (selectedIndex!=-1) { //there's a row selected
            int requestID=(int)requestTable.getValueAt(selectedIndex,0);
            ServiceRequest request=database.getServiceRequest(requestID);
            JTabbedPane homePane=(JTabbedPane) getParent();
            RateRequest rateRequestPanel=new RateRequest(database,connect,request);
            homePane.setComponentAt(1, rateRequestPanel);
            /*parent.removeAll();
            parent.add(new RateRequest(database,connect,parent,request),"Rate Request");
            CardLayout cLayout=(CardLayout) parent.getLayout();
            cLayout.show(parent,"Rate Request");*/
        }
    }//GEN-LAST:event_rateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex=requestTable.getSelectedRow();
        if (selectedIndex!=-1) {
            int requestID=(int) requestTable.getValueAt(selectedIndex,0);
            try {
                statement = connect.prepareStatement("delete from servicerequest where requestID=?");
                statement.setInt(1,requestID);
                int result=statement.executeUpdate();
                if (result!=1) {
                    JOptionPane.showMessageDialog(this,"Cannot delete selected request");
                }
                else {
                    database.removeServiceOffering(requestID);
                    DefaultTableModel model=(DefaultTableModel) requestTable.getModel();
                    model.removeRow(selectedIndex);
                }
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(this,"Unable to delete");
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    public javax.swing.JTable getRequestTable() {
        return requestTable;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rateButton;
    private javax.swing.JTable requestTable;
    // End of variables declaration//GEN-END:variables
    private ServiceDatabase database;
    private Connection connect;
    private PreparedStatement statement;
    private JPanel parent;
}
