
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class CreateRequest extends javax.swing.JPanel {

    /**
     * Creates new form CreateService
     */
    public CreateRequest(ServiceDatabase database, Connection connect, JPanel parent, ServiceOffering service) {
        this.database=database;
        this.connect=connect;
        this.parent=parent;
        this.service=service;
        provider=database.getProvider(service);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        costField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        locationArea = new javax.swing.JTextArea();
        providerRatingField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        providerNameField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        providerPhoneField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        dayField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        timeField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        hourField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        addressArea = new javax.swing.JTextArea();
        submitButton = new javax.swing.JButton();
        atHomeButton = new javax.swing.JRadioButton();
        atLocationButton = new javax.swing.JRadioButton();
        atNewButton = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        minuteField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(0,204,204));
        setPreferredSize(new java.awt.Dimension(1009, 468));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setText("Name");

        nameField.setEditable(false);
        nameField.setText(service.getServiceName());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel2.setText("PROVIDER");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("Location");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setText("Description");

        descriptionArea.setEditable(false);
        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        jScrollPane1.setViewportView(descriptionArea);
        descriptionArea.setText(service.getDescription());

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setText("Cost");

        costField.setEditable(false);
        costField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costFieldActionPerformed(evt);
            }
        });
        costField.setText(Double.toString(service.getServiceCost()));

        locationArea.setEditable(false);
        locationArea.setColumns(20);
        locationArea.setRows(5);
        jScrollPane2.setViewportView(locationArea);
        locationArea.setText(service.getLocation());

        providerRatingField.setEditable(false);
        providerRatingField.setText(Double.toString(provider.getProviderRating()));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setText("Rating");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setText("Name");

        providerNameField.setEditable(false);
        providerNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerNameFieldActionPerformed(evt);
            }
        });
        providerNameField.setText(provider.getName());

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setText("Phone");

        providerPhoneField.setEditable(false);
        providerPhoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerPhoneFieldActionPerformed(evt);
            }
        });
        providerPhoneField.setText(provider.getPhoneNumber());

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setText("Service Day");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setText("Service Time");

        timeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeFieldActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setText("Duration");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setText("Address");

        addressArea.setEditable(false);
        addressArea.setColumns(20);
        addressArea.setRows(5);
        jScrollPane4.setViewportView(addressArea);
        addressArea.setText(database.getCurrentUser().getAddress());

        submitButton.setBackground(new java.awt.Color(32,33,55));
        submitButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit Request");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        atHomeButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        atHomeButton.setSelected(true);
        atHomeButton.setText("At home");
        buttonGroup1.add(atHomeButton);
        atHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atHomeButtonActionPerformed(evt);
            }
        });

        atLocationButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        atLocationButton.setText("At location");
        buttonGroup1.add(atLocationButton);
        atLocationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atLocationButtonActionPerformed(evt);
            }
        });

        atNewButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        atNewButton.setText("At new place");
        atNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atNewButtonActionPerformed(evt);
            }
        });
        buttonGroup1.add(atNewButton);

        jLabel14.setText(":");

        minuteField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minuteFieldActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(backButton)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(46, 46, 46)
                                                .addComponent(hourField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(minuteField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(submitButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(providerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(providerPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(providerRatingField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(atHomeButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(atLocationButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(atNewButton)))))
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(224, 224, 224))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(providerRatingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(providerPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(atHomeButton)
                                    .addComponent(atLocationButton)
                                    .addComponent(atNewButton))
                                .addGap(4, 4, 4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(providerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(164, 164, 164)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(hourField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(minuteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitButton)
                            .addComponent(backButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(318, 318, 318))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void costFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costFieldActionPerformed

    private void providerNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_providerNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_providerNameFieldActionPerformed

    private void providerPhoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_providerPhoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_providerPhoneFieldActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        User user=database.getCurrentUser();
        String address;
        if (atHomeButton.isSelected()) {
            address=user.getAddress()+", "+user.getCity()+", "+user.getState()+", "+user.getPostcode();
        }
        else if (atLocationButton.isSelected()) {
            address=service.getLocation();
        }
        else {
            address=addressArea.getText();
        }
        String day = dayField.getText();
        String time= timeField.getText();
        String hour=hourField.getText();
        String minute=minuteField.getText();
        if (day.equals("") || !Pattern.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$",day)) {
            JOptionPane.showMessageDialog(this,"Wrong date. Format is dd/MM/yyyy");
            dayField.setText("");
            dayField.requestFocus();
        }
        else if (time.equals("") || !Pattern.matches("^[0-2][0-3]:[0-5][0-9]$",time)) {
            JOptionPane.showMessageDialog(this,"Wrong time. Format is HH:mm");
            timeField.setText("");
            timeField.requestFocus();
        }
        else if (!Pattern.matches("^[0-9]+$",hour)) {
            JOptionPane.showMessageDialog(this,"Duration Hour is required");
            hourField.setText("");
            hourField.requestFocus();
        }
        else if (!Pattern.matches("^[0-5][0-9]$",minute)) {
            JOptionPane.showMessageDialog(this,"Wrong format. From 00 to 59");
            minuteField.setText("");
            minuteField.requestFocus();
        }
        else if (address.equals("")) {
            JOptionPane.showMessageDialog(this,"Location Required");
            addressArea.requestFocus();
        }
        else {
            try {
                int durHour = Integer.parseInt(hour);
                int durMinute=Integer.parseInt(minute);
                String dateTime=day+" "+time;
                DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                LocalDateTime requestTime=LocalDateTime.now();
                LocalDateTime serviceTime=LocalDateTime.parse(dateTime,formatter);

                int requestID=database.getCurrentRequestID()+1;
                ServiceRequest request =new ServiceRequest(requestID,service.getServiceID(),user.getUsername(),requestTime, serviceTime, durHour, durMinute, address);
                CardLayout cLayout=(CardLayout) parent.getLayout();
                parent.removeAll();
                parent.add(new Payment(database,connect,parent,request,provider),"Make Payment");
                cLayout.show(parent,"Make Payment");
            }
            catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this,"Cannot create request");
            }
        }
        
    }//GEN-LAST:event_submitButtonActionPerformed

    private void timeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeFieldActionPerformed

    private void atNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atNewButtonActionPerformed
        // TODO add your handling code here:
         addressArea.setEditable(true);
         addressArea.setText("");
    }//GEN-LAST:event_atNewButtonActionPerformed

    private void minuteFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minuteFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minuteFieldActionPerformed

    private void atHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atHomeButtonActionPerformed
        // TODO add your handling code here:
        addressArea.setEditable(false);
        addressArea.setText(database.getCurrentUser().getAddress());
    }//GEN-LAST:event_atHomeButtonActionPerformed

    private void atLocationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atLocationButtonActionPerformed
        // TODO add your handling code here:
         addressArea.setEditable(false);
         addressArea.setText(service.getLocation());
    }//GEN-LAST:event_atLocationButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        CardLayout cLayout=(CardLayout) parent.getLayout();
        parent.removeAll();
        parent.add(new SearchService(database,connect,parent),"Search Service");
        cLayout.show(parent,"Search Service");
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressArea;
    private javax.swing.JRadioButton atHomeButton;
    private javax.swing.JRadioButton atLocationButton;
    private javax.swing.JRadioButton atNewButton;
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField costField;
    private javax.swing.JTextField dayField;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JTextField hourField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea locationArea;
    private javax.swing.JTextField minuteField;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField providerNameField;
    private javax.swing.JTextField providerPhoneField;
    private javax.swing.JTextField providerRatingField;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField timeField;
    // End of variables declaration//GEN-END:variables
    private ServiceDatabase database;
    private Connection connect;
    private PreparedStatement statement;
    private JPanel parent;
    private ServiceOffering service;
    private ServiceProvider provider;
}
