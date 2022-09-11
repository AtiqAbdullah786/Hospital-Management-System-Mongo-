/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package HMS;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.types.ObjectId;


/**
 *
 * @author FTC
 */
public class Admin_Home_Screen extends javax.swing.JFrame {
    

    /**
     * Creates new form Doctor_Home_Screen
     */
   
   
    
    public void ShowDataDoctor(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    try{
           MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           DBCollection mycoll = mydbl.getCollection("Staff");
	   BasicDBObject whereQuery = new BasicDBObject();
	   whereQuery.put("Type", "Doctor");
           DBCursor it = mycoll.find(whereQuery);
            while(it.hasNext()){
             DBObject obj = it.next();
             Object id = obj.get("_id");
             String name = (String)obj.get("Name");
             Object age = obj.get("Age");
             String d_email = (String)obj.get("Email");
             String password = (String)obj.get("Password");
             String gender = (String)obj.get("Gender");
             String contact = (String)obj.get("Contact No");
             Object tbData[] = {id,name,age,gender,contact,password,d_email};

                DefaultTableModel tb1Model = (DefaultTableModel)jTable1.getModel();
                tb1Model.addRow(tbData); 
                mongoclient.close();
            }  
        }     
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
        public void ShowDataFeedback(){
        DefaultTableModel model = (DefaultTableModel) Feedback_Table.getModel();
        model.setRowCount(0);
        try{
             MongoClient mongoclient = new MongoClient("localhost",27017);
             DB mydbl =mongoclient.getDB("HMS");
             DBCollection mycoll = mydbl.getCollection("Patients");
	  
		DBObject query = new BasicDBObject("Feedback", new BasicDBObject(
				"$exists", true));
             DBCursor it = mycoll.find(query);
             
                while(it.hasNext()){
                DBObject obj = it.next();
                Object id = obj.get("_id");
                String name = (String)obj.get("Name");
                String feedback = (String)obj.get("Feedback");
                Object tbData[] = {id,name,feedback};
  
                DefaultTableModel tb1Model = (DefaultTableModel)Feedback_Table.getModel();
                tb1Model.addRow(tbData); 
  
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
    } 
    
    public void ShowDataRec(){
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
    try{
                MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           DBCollection mycoll = mydbl.getCollection("Staff");
	   BasicDBObject whereQuery = new BasicDBObject();
	   whereQuery.put("Type", "Receptionist");
           DBCursor it = mycoll.find(whereQuery);
            while(it.hasNext()){
             DBObject obj = it.next();
             Object id = obj.get("_id");
             String name = (String)obj.get("Name");
             Object age = obj.get("Age");
             String d_email = (String)obj.get("Email");
             String password = (String)obj.get("Password");
             String gender = (String)obj.get("Gender");
             String contact = (String)obj.get("Contact No");
             System.out.println(age);
             Object tbData[] = {id,name,age,gender,contact,password,d_email};
                
                
                DefaultTableModel tb1Model = (DefaultTableModel)jTable2.getModel();
                tb1Model.addRow(tbData); 
                
                
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
   public void ShowDataNurse(){
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
    try{
          
           MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           DBCollection mycoll = mydbl.getCollection("Staff");
	   BasicDBObject whereQuery = new BasicDBObject();
	   whereQuery.put("Type", "Nurse");
           DBCursor it = mycoll.find(whereQuery);
            while(it.hasNext()){
             DBObject obj = it.next();
             Object id = obj.get("_id");
             String name = (String)obj.get("Name");
             Object age = obj.get("Age");
             String gender = (String)obj.get("Gender");
             String contact = (String)obj.get("Contact No");
             String WardName = (String)obj.get("Ward Name");

                Object tbData[] = {id,name,age,gender,contact,WardName};
                
                
                DefaultTableModel tb1Model = (DefaultTableModel)jTable3.getModel();
                tb1Model.addRow(tbData);  
                
                
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        } 
    } 
    
    public Admin_Home_Screen() {
        initComponents();
        Image icon = new ImageIcon(this.getClass().getResource("/Images+icons/HMS_logo.png")).getImage();
       this.setIconImage(icon);
       this.setTitle("Hospital Management System");
       this.setResizable(false);
       
       tab3.setVisible(false);
       tab2.setVisible(false);
       tab1.setVisible(true);
       p1_doctor.setBackground(new Color(0,102,102));
       
       ShowDataDoctor();
       ShowDataRec();
       ShowDataNurse();
      ShowDataFeedback();
       
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        p1_doctor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        p2_nurse = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        p3_receptionist = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        p4_feedbacks = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tab1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Delete_doctor = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        Add_doctor = new javax.swing.JButton();
        Search_Button = new javax.swing.JButton();
        Search_Field = new javax.swing.JTextField();
        Update_doctor = new javax.swing.JButton();
        tab2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Add_Nurse = new javax.swing.JButton();
        Delete_Nurse = new javax.swing.JButton();
        Update_Nurse = new javax.swing.JButton();
        Refresh_Nurse = new javax.swing.JButton();
        Search_Nurse = new javax.swing.JButton();
        Search_Field2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        tab3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Delete_Rec = new javax.swing.JButton();
        Refresh_Rec = new javax.swing.JButton();
        Add_Rec = new javax.swing.JButton();
        Update_Rec = new javax.swing.JButton();
        Search_Rec = new javax.swing.JButton();
        Search_Field1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        tab4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        Feedback_Table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));

        p1_doctor.setBackground(new java.awt.Color(0, 153, 153));
        p1_doctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p1_doctorMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images+icons/Doctor1.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Doctor");

        javax.swing.GroupLayout p1_doctorLayout = new javax.swing.GroupLayout(p1_doctor);
        p1_doctor.setLayout(p1_doctorLayout);
        p1_doctorLayout.setHorizontalGroup(
            p1_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1_doctorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        p1_doctorLayout.setVerticalGroup(
            p1_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        p2_nurse.setBackground(new java.awt.Color(0, 153, 153));
        p2_nurse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p2_nurseMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images+icons/Nurse.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nurse");

        javax.swing.GroupLayout p2_nurseLayout = new javax.swing.GroupLayout(p2_nurse);
        p2_nurse.setLayout(p2_nurseLayout);
        p2_nurseLayout.setHorizontalGroup(
            p2_nurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p2_nurseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        p2_nurseLayout.setVerticalGroup(
            p2_nurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        p3_receptionist.setBackground(new java.awt.Color(0, 153, 153));
        p3_receptionist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p3_receptionistMouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images+icons/Secteray (1).png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Receptionist");

        javax.swing.GroupLayout p3_receptionistLayout = new javax.swing.GroupLayout(p3_receptionist);
        p3_receptionist.setLayout(p3_receptionistLayout);
        p3_receptionistLayout.setHorizontalGroup(
            p3_receptionistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p3_receptionistLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        p3_receptionistLayout.setVerticalGroup(
            p3_receptionistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 51));
        jLabel12.setText("Admin");

        jSeparator4.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator4.setOpaque(true);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images+icons/back_white.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        p4_feedbacks.setBackground(new java.awt.Color(0, 153, 153));
        p4_feedbacks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p4_feedbacksMouseClicked(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images+icons/Feedback.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Feedbacks");

        javax.swing.GroupLayout p4_feedbacksLayout = new javax.swing.GroupLayout(p4_feedbacks);
        p4_feedbacks.setLayout(p4_feedbacksLayout);
        p4_feedbacksLayout.setHorizontalGroup(
            p4_feedbacksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p4_feedbacksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        p4_feedbacksLayout.setVerticalGroup(
            p4_feedbacksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p1_doctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p2_nurse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p3_receptionist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(p4_feedbacks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(p1_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(p2_nurse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(p3_receptionist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p4_feedbacks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        tab1.setBackground(new java.awt.Color(219, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel9.setText("Doctor");

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOpaque(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Gender", "Contact No", "Password", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setDragEnabled(true);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(40);
        jTable1.setRowMargin(5);
        jTable1.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane1.setViewportView(jTable1);

        Delete_doctor.setBackground(new java.awt.Color(0, 153, 153));
        Delete_doctor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Delete_doctor.setForeground(new java.awt.Color(255, 255, 255));
        Delete_doctor.setText("Delete Doctor");
        Delete_doctor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Delete_doctor.setBorderPainted(false);
        Delete_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_doctorActionPerformed(evt);
            }
        });

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        Add_doctor.setBackground(new java.awt.Color(0, 153, 153));
        Add_doctor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Add_doctor.setForeground(new java.awt.Color(255, 255, 255));
        Add_doctor.setText("Add Doctor");
        Add_doctor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Add_doctor.setBorderPainted(false);
        Add_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_doctorActionPerformed(evt);
            }
        });

        Search_Button.setBackground(new java.awt.Color(0, 153, 153));
        Search_Button.setForeground(new java.awt.Color(255, 255, 255));
        Search_Button.setText("Search");
        Search_Button.setBorder(null);
        Search_Button.setPreferredSize(new java.awt.Dimension(40, 20));
        Search_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_ButtonActionPerformed(evt);
            }
        });

        Update_doctor.setBackground(new java.awt.Color(0, 153, 153));
        Update_doctor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Update_doctor.setForeground(new java.awt.Color(255, 255, 255));
        Update_doctor.setText("Update Doctor");
        Update_doctor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Update_doctor.setBorderPainted(false);
        Update_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_doctorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Add_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(Delete_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(Update_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Search_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Search_Field)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(347, 347, 347))
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Refresh)
                        .addGap(54, 54, 54))))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Refresh)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Search_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Update_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );

        tab2.setBackground(new java.awt.Color(219, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel10.setText("Nurse");

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setOpaque(true);

        Add_Nurse.setBackground(new java.awt.Color(0, 153, 153));
        Add_Nurse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Add_Nurse.setForeground(new java.awt.Color(255, 255, 255));
        Add_Nurse.setText("Add Nuse");
        Add_Nurse.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Add_Nurse.setBorderPainted(false);
        Add_Nurse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_NurseActionPerformed(evt);
            }
        });

        Delete_Nurse.setBackground(new java.awt.Color(0, 153, 153));
        Delete_Nurse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Delete_Nurse.setForeground(new java.awt.Color(255, 255, 255));
        Delete_Nurse.setText("Delete Nurse");
        Delete_Nurse.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Delete_Nurse.setBorderPainted(false);
        Delete_Nurse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_NurseActionPerformed(evt);
            }
        });

        Update_Nurse.setBackground(new java.awt.Color(0, 153, 153));
        Update_Nurse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Update_Nurse.setForeground(new java.awt.Color(255, 255, 255));
        Update_Nurse.setText("Update Nurse");
        Update_Nurse.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Update_Nurse.setBorderPainted(false);
        Update_Nurse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_NurseActionPerformed(evt);
            }
        });

        Refresh_Nurse.setText("Refresh");
        Refresh_Nurse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Refresh_NurseActionPerformed(evt);
            }
        });

        Search_Nurse.setBackground(new java.awt.Color(0, 153, 153));
        Search_Nurse.setForeground(new java.awt.Color(255, 255, 255));
        Search_Nurse.setText("Search");
        Search_Nurse.setBorder(null);
        Search_Nurse.setPreferredSize(new java.awt.Dimension(40, 20));
        Search_Nurse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_NurseActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Gender", "Contact No", "Ward Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setDragEnabled(true);
        jTable3.setGridColor(new java.awt.Color(255, 255, 255));
        jTable3.setRowHeight(40);
        jTable3.setRowMargin(5);
        jTable3.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Search_Nurse, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Search_Field2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Add_Nurse, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(Delete_Nurse, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Update_Nurse, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(239, 239, 239)
                .addComponent(Refresh_Nurse)
                .addGap(44, 44, 44))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Refresh_Nurse)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab2Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(Search_Nurse, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Search_Field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 206, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Add_Nurse, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Delete_Nurse, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Update_Nurse, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93))))
        );

        tab3.setBackground(new java.awt.Color(219, 255, 255));
        tab3.setPreferredSize(new java.awt.Dimension(750, 605));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel11.setText("Receptionist");

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOpaque(true);

        Delete_Rec.setBackground(new java.awt.Color(0, 153, 153));
        Delete_Rec.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Delete_Rec.setForeground(new java.awt.Color(255, 255, 255));
        Delete_Rec.setText("Delete Receptionist");
        Delete_Rec.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Delete_Rec.setBorderPainted(false);
        Delete_Rec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_RecActionPerformed(evt);
            }
        });

        Refresh_Rec.setText("Refresh");
        Refresh_Rec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Refresh_RecActionPerformed(evt);
            }
        });

        Add_Rec.setBackground(new java.awt.Color(0, 153, 153));
        Add_Rec.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Add_Rec.setForeground(new java.awt.Color(255, 255, 255));
        Add_Rec.setText("Add Receptionist");
        Add_Rec.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Add_Rec.setBorderPainted(false);
        Add_Rec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_RecActionPerformed(evt);
            }
        });

        Update_Rec.setBackground(new java.awt.Color(0, 153, 153));
        Update_Rec.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Update_Rec.setForeground(new java.awt.Color(255, 255, 255));
        Update_Rec.setText("Update Receptioist");
        Update_Rec.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Update_Rec.setBorderPainted(false);
        Update_Rec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_RecActionPerformed(evt);
            }
        });

        Search_Rec.setBackground(new java.awt.Color(0, 153, 153));
        Search_Rec.setForeground(new java.awt.Color(255, 255, 255));
        Search_Rec.setText("Search");
        Search_Rec.setBorder(null);
        Search_Rec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_RecActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Gender", "Contact No", "Password", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setDragEnabled(true);
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setRowHeight(40);
        jTable2.setRowMargin(5);
        jTable2.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(161, 161, 161)
                        .addComponent(Refresh_Rec)
                        .addGap(48, 48, 48))
                    .addGroup(tab3Layout.createSequentialGroup()
                        .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tab3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(Add_Rec, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(Delete_Rec, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(Update_Rec, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tab3Layout.createSequentialGroup()
                                .addComponent(Search_Rec, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Search_Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(tab3Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(Refresh_Rec))
                    .addGroup(tab3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab3Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(Search_Rec, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Search_Field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Rec, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete_Rec, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Update_Rec, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        tab4.setBackground(new java.awt.Color(219, 255, 255));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel15.setText("Feedbacks");

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOpaque(true);

        Feedback_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Patient Name", "Patient Feedback"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Feedback_Table.setDragEnabled(true);
        Feedback_Table.setGridColor(new java.awt.Color(255, 255, 255));
        Feedback_Table.setRowHeight(40);
        Feedback_Table.setRowMargin(5);
        Feedback_Table.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane4.setViewportView(Feedback_Table);

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addGroup(tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator5)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(309, Short.MAX_VALUE))
            .addGroup(tab4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tab3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 515, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(tab2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 508, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 508, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(tab4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 511, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab3, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(tab2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 27, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 27, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(tab4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 53, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1038, 637));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void p3_receptionistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p3_receptionistMouseClicked
        // TODO add your handling code here:
        p3_receptionist.setBackground(new Color(0,102,102));
        p1_doctor.setBackground(new Color(0,153,153));
        p2_nurse.setBackground(new Color(0,153,153));
        p4_feedbacks.setBackground(new Color(0,153,153));
        tab4.setVisible(false);       
        tab1.setVisible(false);
        tab2.setVisible(false);
        tab3.setVisible(true);
    }//GEN-LAST:event_p3_receptionistMouseClicked

    private void p1_doctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p1_doctorMouseClicked
        // TODO add your handling code here:
        p1_doctor.setBackground(new Color(0,102,102));
        p2_nurse.setBackground(new Color(0,153,153));
        p3_receptionist.setBackground(new Color(0,153,153));
        p4_feedbacks.setBackground(new Color(0,153,153));
        tab4.setVisible(false);
        tab1.setVisible(true);
        tab2.setVisible(false);
        tab3.setVisible(false);
        
        
       
    }//GEN-LAST:event_p1_doctorMouseClicked

    private void p2_nurseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p2_nurseMouseClicked
        // TODO add your handling code here:
        p2_nurse.setBackground(new Color(0,102,102));
        p3_receptionist.setBackground(new Color(0,153,153));
        p1_doctor.setBackground(new Color(0,153,153));
        p4_feedbacks.setBackground(new Color(0,153,153));
        tab4.setVisible(false);
        tab1.setVisible(false);
        tab2.setVisible(true);
        tab3.setVisible(false);
    }//GEN-LAST:event_p2_nurseMouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        Admin_login DL = new Admin_login();
        this.dispose();
        DL.setVisible(true);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void p4_feedbacksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p4_feedbacksMouseClicked
        // TODO add your handling code here:
        p1_doctor.setBackground(new Color(0,153,153));
        p2_nurse.setBackground(new Color(0,153,153));
        p3_receptionist.setBackground(new Color(0,153,153));
        p4_feedbacks.setBackground(new Color(0,102,102));
        tab1.setVisible(false);
        tab2.setVisible(false);
        tab3.setVisible(false);
        tab4.setVisible(true);
    }//GEN-LAST:event_p4_feedbacksMouseClicked

    private void Delete_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_doctorActionPerformed
        // TODO add your handling code here:
        try{
            DefaultTableModel tb1Model = (DefaultTableModel)jTable1.getModel();            
            if(jTable1.getSelectedRowCount()==1){               
           String id = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString();
           MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           DBCollection mycoll = mydbl.getCollection("Staff");
	   BasicDBObject whereQuery = new BasicDBObject();
	   whereQuery.put("Type", "Doctor");
           whereQuery.put("_id", new ObjectId(id));
           mycoll.remove(whereQuery);
           System.out.println(id);

            }
            else if (jTable1.getRowCount()==0){
            
            JOptionPane.showMessageDialog(this,"Table is Empty");
            }
            else{
                JOptionPane.showMessageDialog(this,"Please select single Row from the table");
            
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
        
        ShowDataDoctor();   
     
    }//GEN-LAST:event_Delete_doctorActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        ShowDataDoctor();   
    }//GEN-LAST:event_RefreshActionPerformed

    private void Add_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_doctorActionPerformed
        // TODO add your handling code here:
        Add_Doctor ad  = new Add_Doctor();
        ad.setVisible(true);
        
        
    }//GEN-LAST:event_Add_doctorActionPerformed

    private void Search_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_ButtonActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    try{ 
            String value = Search_Field.getText();

           MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           DBCollection mycoll = mydbl.getCollection("Staff");
	   BasicDBObject whereQuery = new BasicDBObject();
	   whereQuery.put("Type", "Doctor");
           whereQuery.put("Name", value);
           DBCursor it = mycoll.find(whereQuery);
            while(it.hasNext()){
             DBObject obj = it.next();
             Object id = obj.get("_id");
             String name = (String)obj.get("Name");
             Object age = obj.get("Age");
             String d_email = (String)obj.get("Email");
             String password = (String)obj.get("Password");
             String gender = (String)obj.get("Gender");
             String contact = (String)obj.get("Contact No");
             Object tbData[] = {id,name,age,gender,contact,password,d_email};
             DefaultTableModel tb1Model = (DefaultTableModel)jTable1.getModel();
             tb1Model.addRow(tbData); 
                
                
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }  
    }//GEN-LAST:event_Search_ButtonActionPerformed

    private void Update_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_doctorActionPerformed
        // TODO add your handling code here:
        
        try{
            DefaultTableModel tb1Model = (DefaultTableModel)jTable1.getModel();
            
            if(jTable1.getSelectedRowCount()==1){
                
               String s_Id = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString();
               String name = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1).toString();
               String age = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 2).toString();
               String gender = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 3).toString();
               String number = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 4).toString();
               String password = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 5).toString();
               String email = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 6).toString();

               Update_Doctor ud = new Update_Doctor();
               ud.setVisible(true);
               ud.TF_ID.setText(s_Id);
               ud.TF_NAME.setText(name);
               ud.TF_NUMBER.setText(number);
               ud.TF_Email.setText(email);
               ud.TF_PASSWORD.setText(password);
               ud.TF_AGE.setText(age);
               ud.GENDER_BOX.setSelectedItem(gender);
            }
            else if (jTable1.getRowCount()==0){
            
            JOptionPane.showMessageDialog(this,"Table is Empty");
            }
            else{
                JOptionPane.showMessageDialog(this,"Please select single Row from the table");
            
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }   
        
    }//GEN-LAST:event_Update_doctorActionPerformed

    private void Delete_RecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_RecActionPerformed
        // TODO add your handling code here:
        try{
            DefaultTableModel tb1Model = (DefaultTableModel)jTable2.getModel();
            
            if(jTable2.getSelectedRowCount()==1){    
            String r_id = jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 0).toString();
           MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           DBCollection mycoll = mydbl.getCollection("Staff");
	   BasicDBObject whereQuery = new BasicDBObject();
	   whereQuery.put("Type", "Receptionist");
           whereQuery.put("_id", new ObjectId(r_id));
           mycoll.remove(whereQuery);
          


            }
            else if (jTable2.getRowCount()==0){   
            JOptionPane.showMessageDialog(this,"Table is Empty");
            }
            else{
                JOptionPane.showMessageDialog(this,"Please select single Row from the table");
            
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
        
        ShowDataRec();    
    }//GEN-LAST:event_Delete_RecActionPerformed

    private void Refresh_RecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Refresh_RecActionPerformed
        // TODO add your handling code here:
        ShowDataRec();
    }//GEN-LAST:event_Refresh_RecActionPerformed

    private void Add_RecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_RecActionPerformed
        // TODO add your handling code here:
        Add_Receptionist ad  = new Add_Receptionist();
        ad.setVisible(true);
    }//GEN-LAST:event_Add_RecActionPerformed

    private void Update_RecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_RecActionPerformed
        // TODO add your handling code here:
        
        try{
            DefaultTableModel tb1Model = (DefaultTableModel)jTable2.getModel();
            
            if(jTable2.getSelectedRowCount()==1){
                
               String s_Id = jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 0).toString();
               String name = jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 1).toString();
               String s_age = jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 2).toString();
               String gender = jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 3).toString();
               String number = jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 4).toString();
               String password = jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 5).toString();
               String email = jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 6).toString();

               Update_Receptionist ud = new Update_Receptionist();
               ud.setVisible(true);
               ud.TF_ID.setText(s_Id);
               ud.TF_NAME.setText(name);
               ud.TF_NUMBER.setText(number);
               ud.TF_Email.setText(email);
               ud.TF_PASSWORD.setText(password);
               ud.TF_AGE.setText(s_age);
               ud.GENDER_BOX.setSelectedItem(gender);

            }
            else if (jTable2.getRowCount()==0){
            
            JOptionPane.showMessageDialog(this,"Table is Empty");
            }
            else{
                JOptionPane.showMessageDialog(this,"Please select single Row from the table");
            
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());  
        } 
    }//GEN-LAST:event_Update_RecActionPerformed

    private void Search_RecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_RecActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
     try{
            
            String value = Search_Field1.getText();
           MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           DBCollection mycoll = mydbl.getCollection("Staff");
	   BasicDBObject whereQuery = new BasicDBObject();
	   whereQuery.put("Type", "Receptionist");
           whereQuery.put("Name", value);
           DBCursor it = mycoll.find(whereQuery);
            while(it.hasNext()){
             DBObject obj = it.next();
             Object id = obj.get("_id");
             String name = (String)obj.get("Name");
             Object age = obj.get("Age");
             String d_email = (String)obj.get("Email");
             String password = (String)obj.get("Password");
             String gender = (String)obj.get("Gender");
             String contact = (String)obj.get("Contact No");
             System.out.println(age);
             Object tbData[] = {id,name,age,gender,contact,password,d_email};
                DefaultTableModel tb1Model = (DefaultTableModel)jTable2.getModel();
                tb1Model.addRow(tbData); 
            }  
        }     
        catch(Exception e){
            System.out.println(e.toString());
        } 
    }//GEN-LAST:event_Search_RecActionPerformed

    private void Add_NurseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_NurseActionPerformed
        // TODO add your handling code here:
        Add_Nurse AN = new Add_Nurse();
        AN.setVisible(true);
    }//GEN-LAST:event_Add_NurseActionPerformed

    private void Delete_NurseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_NurseActionPerformed
        // TODO add your handling code here:
        
        try{
            DefaultTableModel tb1Model = (DefaultTableModel)jTable3.getModel();
            
            if(jTable3.getSelectedRowCount()==1){     
                
           String n_id = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 0).toString();
           MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           DBCollection mycoll = mydbl.getCollection("Staff");
	   BasicDBObject whereQuery = new BasicDBObject();
	   whereQuery.put("Type", "Nurse");
           whereQuery.put("_id", new ObjectId(n_id));
           mycoll.remove(whereQuery);
            }
            else if (jTable3.getRowCount()==0){   
            JOptionPane.showMessageDialog(this,"Table is Empty");
            }
            else{
                JOptionPane.showMessageDialog(this,"Please select single Row from the table");
            
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
        
        ShowDataNurse();  
    }//GEN-LAST:event_Delete_NurseActionPerformed

    private void Update_NurseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_NurseActionPerformed
        // TODO add your handling code here:
        
        try{
            DefaultTableModel tb1Model = (DefaultTableModel)jTable3.getModel();
            
            if(jTable3.getSelectedRowCount()==1){
                
               String s_Id = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 0).toString();
               String name = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 1).toString();
               String s_age = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 2).toString();
               String gender = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 3).toString();
               String number = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 4).toString();
               String ward = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 5).toString();
               
               Update_Nurse ud = new Update_Nurse();
               ud.setVisible(true);
               ud.TF_ID.setText(s_Id);
               ud.TF_NAME.setText(name);
               ud.TF_NUMBER.setText(number);
               ud.TF_AGE.setText(s_age);
               ud.GENDER_BOX.setSelectedItem(gender);
               ud.WARD_BOX.setSelectedItem(ward);
 
            }
            else if (jTable2.getRowCount()==0){
            
            JOptionPane.showMessageDialog(this,"Table is Empty");
            }
            else{
                JOptionPane.showMessageDialog(this,"Please select single Row from the table");
            
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }  
    }//GEN-LAST:event_Update_NurseActionPerformed

    private void Refresh_NurseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Refresh_NurseActionPerformed
        // TODO add your handling code here:
        ShowDataNurse();
    }//GEN-LAST:event_Refresh_NurseActionPerformed

    private void Search_NurseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_NurseActionPerformed
        // TODO add your handling code here:
        
    
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
    try{
           
           String value = Search_Field2.getText();         
           MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           DBCollection mycoll = mydbl.getCollection("Staff");
	   BasicDBObject whereQuery = new BasicDBObject();
	   whereQuery.put("Type", "Nurse");
           whereQuery.put("Name", value);
           DBCursor it = mycoll.find(whereQuery);
            while(it.hasNext()){
             DBObject obj = it.next();
             Object id = obj.get("_id");
             String name = (String)obj.get("Name");
             Object age = obj.get("Age");
             String gender = (String)obj.get("Gender");
             String contact = (String)obj.get("Contact No");
             String WardName = (String)obj.get("Ward Name");

                Object tbData[] = {id,name,age,gender,contact,WardName};
                
                
                DefaultTableModel tb1Model = (DefaultTableModel)jTable3.getModel();
                tb1Model.addRow(tbData);  
                
                
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }  
    
    }//GEN-LAST:event_Search_NurseActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Home_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Home_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Home_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Home_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Home_Screen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_Nurse;
    private javax.swing.JButton Add_Rec;
    private javax.swing.JButton Add_doctor;
    private javax.swing.JButton Delete_Nurse;
    private javax.swing.JButton Delete_Rec;
    private javax.swing.JButton Delete_doctor;
    public javax.swing.JTable Feedback_Table;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton Refresh_Nurse;
    private javax.swing.JButton Refresh_Rec;
    private javax.swing.JButton Search_Button;
    private javax.swing.JTextField Search_Field;
    private javax.swing.JTextField Search_Field1;
    private javax.swing.JTextField Search_Field2;
    private javax.swing.JButton Search_Nurse;
    private javax.swing.JButton Search_Rec;
    private javax.swing.JButton Update_Nurse;
    private javax.swing.JButton Update_Rec;
    private javax.swing.JButton Update_doctor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    public javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    public javax.swing.JTable jTable3;
    private javax.swing.JPanel p1_doctor;
    private javax.swing.JPanel p2_nurse;
    private javax.swing.JPanel p3_receptionist;
    private javax.swing.JPanel p4_feedbacks;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    // End of variables declaration//GEN-END:variables
}
