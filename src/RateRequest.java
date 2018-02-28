
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class RateRequest extends javax.swing.JPanel {

    /**
     * Creates new form RateRequest
     */
    public RateRequest(ServiceDatabase database, Connection connect, ServiceRequest request) {
        this.database=database;
        this.connect=connect;
        //this.parent=parent;
        this.request=request;
        service=database.getServiceOffering(request.getServiceID());
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

        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        serviceNameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rateField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        feedbackArea = new javax.swing.JTextArea();
        submitButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        informLabel = new javax.swing.JLabel();

        jCheckBox2.setText("jCheckBox2");

        jCheckBox1.setText("jCheckBox1");

        setBackground(new java.awt.Color(0,204,204));
        setPreferredSize(new java.awt.Dimension(1009, 469));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setText("Service Name");

        serviceNameField.setEditable(false);
        serviceNameField.setText(service.getServiceName());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setText("Rating");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("Feedback");

        feedbackArea.setColumns(20);
        feedbackArea.setRows(5);
        jScrollPane1.setViewportView(feedbackArea);

        submitButton.setBackground(new java.awt.Color(32,33,55));
        submitButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(32,33,55));
        backButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        informLabel.setText("Cannot rate service");
        informLabel.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rateField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(serviceNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(353, 353, 353)
                        .addComponent(backButton)
                        .addGap(92, 92, 92)
                        .addComponent(submitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)))
                .addGap(271, 271, 271))
            .addGroup(layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(informLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(serviceNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel3)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(submitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(informLabel)
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        JTabbedPane homePane=(JTabbedPane) getParent();
        MyRequest myRequestPanel=new MyRequest(database,connect);
        homePane.setComponentAt(1,myRequestPanel);
        /*parent.removeAll();
        parent.add(new MyRequest(database,connect),"My Request");
        CardLayout cLayout=(CardLayout) parent.getLayout();
        cLayout.show(parent,"My Request");*/
    }//GEN-LAST:event_backButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        String rating=rateField.getText();
        if (!Pattern.matches("^[1-5]$",rating)) {
            JOptionPane.showMessageDialog(this,"Rating (1-5) required");
        }
        else {
            try {
                int userRating=Integer.parseInt(rateField.getText());
                String userFeedback=feedbackArea.getText();
                LocalDateTime finishTime = request.getServiceTime().plusHours(request.getHour()).plusMinutes(request.getMinute());
                CompletedRequest compRequest = new CompletedRequest(request,finishTime,userRating,userFeedback);

                provider = database.getProvider(service);
                int ratingOccur=service.getRatingOccur()+1;
                double newServiceRating=(service.getServiceRating()*service.getRatingOccur()+compRequest.getRequestRating())/ratingOccur;
                statement=connect.prepareStatement("insert into completedrequest values(?,?,?,?)");
                statement.setInt(1,compRequest.getID());
                statement.setTimestamp(2, Timestamp.valueOf(compRequest.getFinishTime()));
                statement.setString(3, userFeedback);
                statement.setInt(4,userRating);
                int result1=statement.executeUpdate();

                statement=connect.prepareStatement("update serviceoffering set serviceRating=?,ratingOccur=? where serviceID=?");
                statement.setDouble(1,newServiceRating);
                statement.setInt(2,ratingOccur);
                statement.setInt(3,service.getServiceID());
                int result2=statement.executeUpdate();


                if (result1 !=1 || result2!=1) {
                    JOptionPane.showMessageDialog(this,"Cannot complete rating");
                }
                else {
                    database.addCompletedRequest(compRequest);
                    service.setRating(newServiceRating);
                    /*parent.removeAll();
                    parent.add(new MyRequest(database,connect),"My Request");
                    CardLayout cLayout=(CardLayout) parent.getLayout();
                    cLayout.show(parent,"My Request");*/
                    JTabbedPane homePane=(JTabbedPane) getParent();
                    MyRequest myRequestPanel=new MyRequest(database,connect);
                    homePane.setComponentAt(1,myRequestPanel);

                    MyHistory myHistoryPanel = new MyHistory(database,connect);
                    homePane.setComponentAt(2,myHistoryPanel);

                    JPanel servicePanel=(JPanel) homePane.getComponentAt(0);
                    servicePanel.removeAll();
                    servicePanel.add(new SearchService(database,connect,servicePanel),"Search Service");
                    CardLayout cl= (CardLayout) servicePanel.getLayout();
                    cl.show(servicePanel,"Search Service");
                }
            }
            catch(Exception e) {
                informLabel.setText(e.toString());
                informLabel.setVisible(true);
            }
            try {
                double newProviderRating=database.calculateProviderRating(provider);
                statement=connect.prepareStatement("update provider set rating=? where username=?");
                statement.setDouble(1,newProviderRating);
                statement.setString(2,provider.getUsername());
                int result3=statement.executeUpdate();
                if (result3!=1) {
                    informLabel.setVisible(true);
                }
                else {
                    provider.setProviderRating(newProviderRating);
                }
            }
            catch(Exception e) {
                informLabel.setText(e.toString());
                informLabel.setVisible(true);
            }
        }
    }//GEN-LAST:event_submitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextArea feedbackArea;
    private javax.swing.JLabel informLabel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField rateField;
    private javax.swing.JTextField serviceNameField;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
    private ServiceDatabase database;
    private Connection connect;
    private PreparedStatement statement;
    private JPanel parent;
    private ServiceRequest request;
    private ServiceOffering service;
    private ServiceProvider provider;
}