
import java.awt.CardLayout;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
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
public class MyOfferings extends javax.swing.JPanel {

    /**
     * Creates new form MyOfferings
     */
    public MyOfferings(ServiceDatabase database, Connection connect) {
        //this.parent=parent;
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
        serviceTable = new javax.swing.JTable();
        createButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        informLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0,204,204));
        setPreferredSize(new java.awt.Dimension(1009, 469));

        Object[][] data=database.getServiceOfferingsByProvider();
        serviceTable.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        serviceTable.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "ID", "Name", "Location", "Cost", "Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        for (int column = 0; column < serviceTable.getColumnCount(); column++)
        {
            TableColumn tableColumn = serviceTable.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < serviceTable.getRowCount(); row++)
            {
                TableCellRenderer cellRenderer = serviceTable.getCellRenderer(row, column);
                Component c = serviceTable.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + serviceTable.getIntercellSpacing().width;
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
        serviceTable.setShowHorizontalLines(false);
        serviceTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(serviceTable);

        createButton.setBackground(new java.awt.Color(32,33,55));
        createButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        createButton.setForeground(new java.awt.Color(255, 255, 255));
        createButton.setText("Create Service");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(32,33,55));
        editButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit Service");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(32,33,55));
        deleteButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete Service");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(createButton)
                        .addGap(94, 94, 94)
                        .addComponent(editButton)
                        .addGap(105, 105, 105)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(informLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteButton)
                        .addComponent(editButton)
                        .addComponent(createButton)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
        /*CardLayout cLayout=(CardLayout) parent.getLayout();
        parent.add(new CreateServiceOffering(database,connect,parent),"Create Offering");
        cLayout.show(parent,"Create Offering");*/
        JTabbedPane homePane=(JTabbedPane) getParent();
        homePane.setComponentAt(0,new CreateServiceOffering(database,connect));
    }//GEN-LAST:event_createButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
       // TODO add your handling code here:
        int selectedIndex = serviceTable.getSelectedRow();
        if (selectedIndex!=-1) { //there's a row selected
            int serviceID=(int)serviceTable.getValueAt(selectedIndex,0);
            ServiceOffering service= database.getServiceOffering(serviceID);
            /*parent.add(new EditServiceOffering(database,connect,parent,service),"Edit Offering");
            CardLayout cLayout=(CardLayout) parent.getLayout();
            cLayout.show(parent,"Edit Offering");*/
             JTabbedPane homePane=(JTabbedPane) getParent();
            homePane.setComponentAt(0,new EditServiceOffering(database,connect,service));
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = serviceTable.getSelectedRow();
        if (selectedIndex!=-1) { //there's a row selected
            int serviceID=(int)serviceTable.getModel().getValueAt(selectedIndex,0);
            ServiceProvider provider = database.getProvider(database.getCurrentUser());
            database.removeServiceOffering(serviceID);
            try {
                statement = connect.prepareStatement("delete from serviceoffering where serviceID=?");
                statement.setInt(1,serviceID);
                int result1=statement.executeUpdate();
                if (result1!=1) {
                    JOptionPane.showMessageDialog(this,"Unable to delete");
                }
                else {
                    double newProviderRating=database.calculateProviderRating(provider);
                    statement= connect.prepareStatement("update provider set rating=? where username=?");
                    statement.setDouble(1,newProviderRating);
                    statement.setString(2,provider.getUsername());
                    int result2=statement.executeUpdate();
                    if (result2!=1) {
                        JOptionPane.showMessageDialog(this,"Cannot update rating");
                    }
                    DefaultTableModel model=(DefaultTableModel) serviceTable.getModel();
                    model.removeRow(selectedIndex);
                }
                
            }
            catch(Exception e) {
                //informLabel.setText("Unable to delete");
                System.out.println(e);
                JOptionPane.showMessageDialog(this,"Unable to delete");
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel informLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable serviceTable;
    // End of variables declaration//GEN-END:variables
    private ServiceDatabase database;
    private Connection connect;
    //private JFrame parent;
    private PreparedStatement statement;
}
