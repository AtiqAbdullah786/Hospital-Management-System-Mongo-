
package HMS;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Random;
import org.bson.types.ObjectId;


public class Check_Appointment extends javax.swing.JFrame {
    
    public String Patient_ID = null;
    private String Test_Id = null;
    private String Med_Id=null;
    
    
    
    
    public Check_Appointment() {
        initComponents();
        Image icon = new ImageIcon(this.getClass().getResource("/Images+icons/HMS_logo.png")).getImage();
       this.setIconImage(icon);
       this.setTitle("Hospital Management System");  
       this.setResizable(false);
    }
    
    


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CONFIRM_ADD_BUTTON = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        TF_Disease = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TF_NAME = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Medicine_BOX = new javax.swing.JComboBox<>();
        Test_BOX = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TF_Details = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Patient Checkup ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Medicine");

        CONFIRM_ADD_BUTTON.setBackground(new java.awt.Color(0, 153, 153));
        CONFIRM_ADD_BUTTON.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CONFIRM_ADD_BUTTON.setForeground(new java.awt.Color(255, 255, 255));
        CONFIRM_ADD_BUTTON.setText("Confirm");
        CONFIRM_ADD_BUTTON.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CONFIRM_ADD_BUTTON.setBorderPainted(false);
        CONFIRM_ADD_BUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONFIRM_ADD_BUTTONActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images+icons/back_teal.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        TF_Disease.setBackground(new java.awt.Color(247, 247, 247));
        TF_Disease.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TF_Disease.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true));
        TF_Disease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_DiseaseActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Name");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Test");

        TF_NAME.setBackground(new java.awt.Color(247, 247, 247));
        TF_NAME.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TF_NAME.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true));
        TF_NAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_NAMEActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Disease");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Details");

        Medicine_BOX.setBackground(new java.awt.Color(247, 247, 247));
        Medicine_BOX.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Medicine_BOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N/A", "Calpol", "Paracetamol", "Antacids", "Antiseptic Cream", "Plavix", "Crestor", "Epogen", "Ibuprofen", "Antihistamine", "Panadol" }));
        Medicine_BOX.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        Medicine_BOX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Medicine_BOXActionPerformed(evt);
            }
        });

        Test_BOX.setBackground(new java.awt.Color(247, 247, 247));
        Test_BOX.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Test_BOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N/A", "Prothrombin Time", "Basic Metabolic Panel", "Lipid Panel", "Liver Panel", "Hemoglobin A1C", "Urinalysis", "Cultures", "Cardiac biomarkers", "C-reactive protein", "Complete Blood Count" }));
        Test_BOX.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        Test_BOX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Test_BOXActionPerformed(evt);
            }
        });

        TF_Details.setBackground(new java.awt.Color(247, 247, 247));
        TF_Details.setColumns(20);
        TF_Details.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TF_Details.setRows(5);
        TF_Details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jScrollPane1.setViewportView(TF_Details);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel12)))
                        .addGap(46, 46, 46)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TF_Disease, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Medicine_BOX, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Test_BOX, javax.swing.GroupLayout.Alignment.LEADING, 0, 327, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(CONFIRM_ADD_BUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_Disease, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Medicine_BOX, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Test_BOX, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(CONFIRM_ADD_BUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(664, 637));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CONFIRM_ADD_BUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONFIRM_ADD_BUTTONActionPerformed
       
       
       try{         
            String name = TF_NAME.getText();
            String medicine = Medicine_BOX.getSelectedItem().toString();
            String Disease = TF_Disease.getText();
            String Test = Test_BOX.getSelectedItem().toString();
            String details = TF_Details.getText();
            String id = Patient_ID;
            
           MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           DBCollection mycoll = mydbl.getCollection("Patients"); 
           
           
           BasicDBObject newDocument = new BasicDBObject();
	   newDocument.append("$set", new BasicDBObject()
                   .append("Check Up","Yes")
                   .append("Disease",Disease)
                   .append("Prescriptions",details)
                   .append("Medicine",medicine)
                   .append("Test",Test) );
           
            BasicDBObject query = new BasicDBObject();
            query.put("_id", new ObjectId(id));
	   
	    mycoll.update(query, newDocument);
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
       this.dispose();  
       
       
       
    
      // AHS.ShowData();
      
    
    
       
    }//GEN-LAST:event_CONFIRM_ADD_BUTTONActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        
        this.dispose();
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void TF_DiseaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_DiseaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_DiseaseActionPerformed

    private void TF_NAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_NAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_NAMEActionPerformed

    private void Medicine_BOXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Medicine_BOXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Medicine_BOXActionPerformed

    private void Test_BOXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Test_BOXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Test_BOXActionPerformed

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
            java.util.logging.Logger.getLogger(Check_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Check_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Check_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Check_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Check_Appointment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CONFIRM_ADD_BUTTON;
    private javax.swing.JComboBox<String> Medicine_BOX;
    private javax.swing.JTextArea TF_Details;
    private javax.swing.JTextField TF_Disease;
    public javax.swing.JTextField TF_NAME;
    private javax.swing.JComboBox<String> Test_BOX;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
