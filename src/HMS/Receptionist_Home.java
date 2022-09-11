/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package HMS;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;

/**
 *
 * @author FTC
 */
public class Receptionist_Home extends javax.swing.JFrame {
    
    public static String patient_id=null;
    

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
                
                
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
   
    
    public void ShowDataPatient(){
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
    try{
           MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           DBCollection mycoll = mydbl.getCollection("Patients");
	  
             DBCursor it = mycoll.find();
             while(it.hasNext()){
             DBObject obj = it.next();
             Object id = obj.get("_id");
             String name = (String)obj.get("Name");
             String age = (String)obj.get("Age");
             String address = (String)obj.get("Address");
             String date = (String)obj.get("Admit Date");
             String gender = (String)obj.get("Gender");
             String contact = (String)obj.get("Contact No");
             String ward = (String)obj.get("Ward Name");
         
                
                Object tbData[] = {id,name,age,gender,contact,address,date,ward};

                DefaultTableModel tb1Model = (DefaultTableModel)jTable3.getModel();
                tb1Model.addRow(tbData);  
  
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
    
    }
    
    public void ShowDataPFB(){
        DefaultTableModel model = (DefaultTableModel) Feedback_Table.getModel();
        model.setRowCount(0);
    try{
           MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           DBCollection mycoll = mydbl.getCollection("Patients");
	  
             DBCursor it = mycoll.find();
             while(it.hasNext()){
             DBObject obj = it.next();
             Object id = obj.get("_id");
             String name = (String)obj.get("Name");
             String age = (String)obj.get("Age");
             String address = (String)obj.get("Address");
             String date = (String)obj.get("Admit Date");
             String gender = (String)obj.get("Gender");
             String contact = (String)obj.get("Contact No");
            
                Object tbData[] = {id,name,age,gender,contact,address,date};

                DefaultTableModel tb1Model = (DefaultTableModel)Feedback_Table.getModel();
                tb1Model.addRow(tbData);  
  
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
    
    }
    
    
    
     public void ShowDataPatientAp(){
        DefaultTableModel model = (DefaultTableModel) Patient_Table.getModel();
        model.setRowCount(0);
    try{
           MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           DBCollection mycoll = mydbl.getCollection("Patients");
	  
           BasicDBObject whereQuery = new BasicDBObject();
	   whereQuery.put("Appointment_Status", "No");
           DBCursor it = mycoll.find(whereQuery);
            while(it.hasNext()){
             DBObject obj = it.next();
             Object id = obj.get("_id");
             String name = (String)obj.get("Name");
             String gender = (String)obj.get("Gender");
             Object tbData[] = {id,name,gender};

            DefaultTableModel tb1Model = (DefaultTableModel)Patient_Table.getModel();
            tb1Model.addRow(tbData);  
  
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
     
     public void ShowDataDoctorAp(){
        DefaultTableModel model = (DefaultTableModel) Doctor_Table.getModel();
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
               String gender = (String)obj.get("Gender");
                Object tbData[] = {id,name,gender};
                DefaultTableModel tb1Model = (DefaultTableModel)Doctor_Table.getModel();
                tb1Model.addRow(tbData);   
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public Receptionist_Home() {
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
       ShowDataDoctorAp();
       ShowDataPatientAp();
       ShowDataPatient();
       ShowDataPFB();
       
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        Refresh = new javax.swing.JButton();
        Search_Button = new javax.swing.JButton();
        Search_Field = new javax.swing.JTextField();
        tab2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Add_Patient = new javax.swing.JButton();
        Delete_Patient = new javax.swing.JButton();
        Update_Patient = new javax.swing.JButton();
        Refresh_Patient = new javax.swing.JButton();
        Search_Patient = new javax.swing.JButton();
        Search_Field2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        Medical_Report = new javax.swing.JButton();
        tab3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Fix_Appointment = new javax.swing.JButton();
        Refresh_Rec = new javax.swing.JButton();
        Search_Rec = new javax.swing.JButton();
        Search_Field1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Patient_Table = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Doctor_Table = new javax.swing.JTable();
        Search_Rec1 = new javax.swing.JButton();
        Search_Field3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tab4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        Feedback_Table = new javax.swing.JTable();
        Feedback_button = new javax.swing.JButton();

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
        jLabel6.setText("Patients");

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
        jLabel8.setText("Appointments");

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
        jLabel12.setText("Receptionist");

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
            .addComponent(p4_feedbacks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(29, 29, 29)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(42, 42, 42)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
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

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
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

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Search_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Search_Field)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                .addContainerGap(292, Short.MAX_VALUE)
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
                .addGap(169, 169, 169))
        );

        tab2.setBackground(new java.awt.Color(219, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel10.setText("Patients");

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setOpaque(true);

        Add_Patient.setBackground(new java.awt.Color(0, 153, 153));
        Add_Patient.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Add_Patient.setForeground(new java.awt.Color(255, 255, 255));
        Add_Patient.setText("Add Patient");
        Add_Patient.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Add_Patient.setBorderPainted(false);
        Add_Patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_PatientActionPerformed(evt);
            }
        });

        Delete_Patient.setBackground(new java.awt.Color(0, 153, 153));
        Delete_Patient.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Delete_Patient.setForeground(new java.awt.Color(255, 255, 255));
        Delete_Patient.setText("Discharge Patient");
        Delete_Patient.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Delete_Patient.setBorderPainted(false);
        Delete_Patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_PatientActionPerformed(evt);
            }
        });

        Update_Patient.setBackground(new java.awt.Color(0, 153, 153));
        Update_Patient.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Update_Patient.setForeground(new java.awt.Color(255, 255, 255));
        Update_Patient.setText("Update Patient");
        Update_Patient.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Update_Patient.setBorderPainted(false);
        Update_Patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_PatientActionPerformed(evt);
            }
        });

        Refresh_Patient.setText("Refresh");
        Refresh_Patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Refresh_PatientActionPerformed(evt);
            }
        });

        Search_Patient.setBackground(new java.awt.Color(0, 153, 153));
        Search_Patient.setForeground(new java.awt.Color(255, 255, 255));
        Search_Patient.setText("Search");
        Search_Patient.setBorder(null);
        Search_Patient.setPreferredSize(new java.awt.Dimension(40, 20));
        Search_Patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_PatientActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Gender", "Contact No", "Address", "Admit Date", "Ward Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
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

        Medical_Report.setBackground(new java.awt.Color(0, 153, 153));
        Medical_Report.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Medical_Report.setForeground(new java.awt.Color(255, 255, 255));
        Medical_Report.setText("Medical Report");
        Medical_Report.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Medical_Report.setBorderPainted(false);
        Medical_Report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Medical_ReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Search_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Search_Field2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(239, 239, 239)
                .addComponent(Refresh_Patient)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tab2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Delete_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tab2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(Add_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(Medical_Report, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(98, 98, 98)
                .addComponent(Update_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Refresh_Patient)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab2Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(Search_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(Search_Field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Medical_Report, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(Delete_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        tab3.setBackground(new java.awt.Color(219, 255, 255));
        tab3.setPreferredSize(new java.awt.Dimension(750, 605));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel11.setText("Appointments");

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOpaque(true);

        Fix_Appointment.setBackground(new java.awt.Color(0, 153, 153));
        Fix_Appointment.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Fix_Appointment.setForeground(new java.awt.Color(255, 255, 255));
        Fix_Appointment.setText("Fix Appointment");
        Fix_Appointment.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Fix_Appointment.setBorderPainted(false);
        Fix_Appointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fix_AppointmentActionPerformed(evt);
            }
        });

        Refresh_Rec.setText("Refresh");
        Refresh_Rec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Refresh_RecActionPerformed(evt);
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

        Patient_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Patient_Table.setDragEnabled(true);
        Patient_Table.setGridColor(new java.awt.Color(255, 255, 255));
        Patient_Table.setRowHeight(40);
        Patient_Table.setRowMargin(5);
        Patient_Table.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane2.setViewportView(Patient_Table);

        Doctor_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Doctor_Table.setDragEnabled(true);
        Doctor_Table.setGridColor(new java.awt.Color(255, 255, 255));
        Doctor_Table.setRowHeight(40);
        Doctor_Table.setRowMargin(5);
        Doctor_Table.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane4.setViewportView(Doctor_Table);

        Search_Rec1.setBackground(new java.awt.Color(0, 153, 153));
        Search_Rec1.setForeground(new java.awt.Color(255, 255, 255));
        Search_Rec1.setText("Search");
        Search_Rec1.setBorder(null);
        Search_Rec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_Rec1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Patient");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Doctor");

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab3Layout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator3)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(161, 161, 161)
                .addComponent(Refresh_Rec)
                .addGap(48, 48, 48))
            .addGroup(tab3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tab3Layout.createSequentialGroup()
                        .addComponent(Search_Rec, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Search_Field1)
                        .addGap(93, 93, 93)
                        .addComponent(Search_Rec1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Search_Field3))
                    .addGroup(tab3Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)))
                .addGap(74, 74, 74))
            .addGroup(tab3Layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(Fix_Appointment, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Search_Field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Search_Rec, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Search_Field3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Search_Rec1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Fix_Appointment, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
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
                "ID", "Name", "Age", "Gender", "Contact No", "Address", "Admit Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jScrollPane5.setViewportView(Feedback_Table);

        Feedback_button.setBackground(new java.awt.Color(0, 153, 153));
        Feedback_button.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Feedback_button.setForeground(new java.awt.Color(255, 255, 255));
        Feedback_button.setText("Add Feedback");
        Feedback_button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Feedback_button.setBorderPainted(false);
        Feedback_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Feedback_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addGroup(tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE))
                    .addGroup(tab4Layout.createSequentialGroup()
                        .addGroup(tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tab4Layout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addGroup(tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator5)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(tab4Layout.createSequentialGroup()
                                .addGap(277, 277, 277)
                                .addComponent(Feedback_button, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(Feedback_button, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
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
        
        ShowDataPatientAp();
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
        Receptionist_Login DL = new Receptionist_Login();
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

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        ShowDataDoctor();   
    }//GEN-LAST:event_RefreshActionPerformed

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

    private void Fix_AppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fix_AppointmentActionPerformed
        // TODO add your handling code here:
        try{
            DefaultTableModel tb1Model = (DefaultTableModel)Patient_Table.getModel();
            DefaultTableModel tb2Model = (DefaultTableModel)Doctor_Table.getModel();
            
            if(Patient_Table.getSelectedRowCount()==1 && Doctor_Table.getSelectedRowCount()==1){
               patient_id = Patient_Table.getModel().getValueAt(Patient_Table.getSelectedRow(), 0).toString(); 
               String patient_name = Patient_Table.getModel().getValueAt(Patient_Table.getSelectedRow(), 1).toString();
               String doctor_name = Doctor_Table.getModel().getValueAt(Doctor_Table.getSelectedRow(), 1).toString();
               Add_Appointment AA = new Add_Appointment();
               AA.setVisible(true);
               AA.TF_Doctor.setText(doctor_name);
               AA.TF_Patient.setText(patient_name);
              
               

            }
            else if (Patient_Table.getRowCount()==0){   
            JOptionPane.showMessageDialog(this,"Patient Table is Empty");
            }
            else if (Doctor_Table.getRowCount()==0){   
            JOptionPane.showMessageDialog(this,"Doctor Table is Empty");
            }
            else{
                JOptionPane.showMessageDialog(this,"Please Select Single Row From Each table");
            
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_Fix_AppointmentActionPerformed

    private void Refresh_RecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Refresh_RecActionPerformed
        // TODO add your handling code here:
        ShowDataDoctorAp();
        ShowDataPatientAp();
    }//GEN-LAST:event_Refresh_RecActionPerformed

    private void Search_RecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_RecActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) Patient_Table.getModel();
        model.setRowCount(0);
    try{
            
           String value = Search_Field1.getText();
           MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           DBCollection mycoll = mydbl.getCollection("Patients");
	   BasicDBObject whereQuery = new BasicDBObject();          
           whereQuery.put("Name", value);
           whereQuery.put("Appointment_Status", "No");
           DBCursor it = mycoll.find(whereQuery);
            while(it.hasNext()){
             DBObject obj = it.next();
             Object id = obj.get("_id");
             String name = (String)obj.get("Name");
             String gender = (String)obj.get("Gender");
                

                Object tbData[] = {id,name,gender};
                DefaultTableModel tb1Model = (DefaultTableModel)Patient_Table.getModel();
                tb1Model.addRow(tbData); 
            }  
        }     
        catch(Exception e){
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_Search_RecActionPerformed

    private void Add_PatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_PatientActionPerformed
        // TODO add your handling code here:
        Add_Patient AN = new Add_Patient();
        AN.setVisible(true);
    }//GEN-LAST:event_Add_PatientActionPerformed

    private void Delete_PatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_PatientActionPerformed
        // TODO add your handling code here:
        
        try{
            DefaultTableModel tb1Model = (DefaultTableModel)jTable3.getModel();
            if(jTable3.getSelectedRowCount()==1){   
                
           String id = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 0).toString();
           MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           
           DBCollection mycoll = mydbl.getCollection("Patients");
	   BasicDBObject whereQuery = new BasicDBObject();
           whereQuery.put("_id", new ObjectId(id));
           mycoll.remove(whereQuery);
           
           System.out.println(id);

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
        
        ShowDataPatient();
    }//GEN-LAST:event_Delete_PatientActionPerformed

    private void Update_PatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_PatientActionPerformed
        // TODO add your handling code here:
        
        try{
            DefaultTableModel tb1Model = (DefaultTableModel)jTable3.getModel();
            
            if(jTable3.getSelectedRowCount()==1){
                
               String s_Id = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 0).toString();
               String name = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 1).toString();
               String s_age = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 2).toString();
               String gender = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 3).toString();
               String number = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 4).toString();
               String address = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 5).toString();
               String date = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 6).toString();
               String ward = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 7).toString();
               
               Update_Patient ud = new Update_Patient();
               ud.setVisible(true);
               ud.id = s_Id;
               ud.TF_NAME.setText(name);
               ud.TF_NUMBER.setText(number);
               ud.TF_AGE.setText(s_age);
               ud.TF_Address.setText(address);
               ud.GENDER_BOX.setSelectedItem(gender);
               ud.WARD_BOX.setSelectedItem(ward);
               ud.Date_chooser.setDateFormatString(date);            
            }
            else if (Patient_Table.getRowCount()==0){
            
            JOptionPane.showMessageDialog(this,"Table is Empty");
            }
            else{
                JOptionPane.showMessageDialog(this,"Please select single Row from the table");
            
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_Update_PatientActionPerformed

    private void Refresh_PatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Refresh_PatientActionPerformed
        // TODO add your handling code here:
        ShowDataPatient();
    }//GEN-LAST:event_Refresh_PatientActionPerformed

    private void Search_PatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_PatientActionPerformed
        // TODO add your handling code here:
        
    
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
    try{
            
           String value = Search_Field2.getText();
           MongoClient mongoclient = new MongoClient("localhost",27017);
           DB mydbl =mongoclient.getDB("HMS");
           DBCollection mycoll = mydbl.getCollection("Patients");
	   BasicDBObject whereQuery = new BasicDBObject();
           whereQuery.put("Name", value);
           DBCursor it = mycoll.find(whereQuery);
            while(it.hasNext()){
             DBObject obj = it.next();
             Object id = obj.get("_id");
             String name = (String)obj.get("Name");
             String age = (String)obj.get("Age");
             String address = (String)obj.get("Address");
             String date = (String)obj.get("Admit Date");
             String gender = (String)obj.get("Gender");
             String contact = (String)obj.get("Contact No");
             String ward = (String)obj.get("Ward Name");
                Object tbData[] = {id,name,age,gender,contact,address,date};
                
                
                DefaultTableModel tb1Model = (DefaultTableModel)jTable3.getModel();
                tb1Model.addRow(tbData);  
                
                
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
    
    }//GEN-LAST:event_Search_PatientActionPerformed

    private void Search_Rec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_Rec1ActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) Doctor_Table.getModel();
        model.setRowCount(0);
    try{  
            String value = Search_Field3.getText();
          
          
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
             String gender = (String)obj.get("Gender");

                Object tbData[] = {id,name,gender};               
                DefaultTableModel tb1Model = (DefaultTableModel)Doctor_Table.getModel();
                tb1Model.addRow(tbData);            
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_Search_Rec1ActionPerformed

    private void Feedback_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Feedback_buttonActionPerformed
        // TODO add your handling code here:
        try{
            DefaultTableModel tb1Model = (DefaultTableModel)Feedback_Table.getModel();
            
            if(Feedback_Table.getSelectedRowCount()==1){ 
               String s_Id = Feedback_Table.getModel().getValueAt(Feedback_Table.getSelectedRow(), 0).toString();
               Add_Feedback ud = new Add_Feedback();
               ud.setVisible(true);
               ud.TF_ID.setText(s_Id);
        
            }
            else if (Feedback_Table.getRowCount()==0){
            
            JOptionPane.showMessageDialog(this,"Table is Empty");
            }
            else{
                JOptionPane.showMessageDialog(this,"Please select single Row from the table");
            
            }  
        }   
            
        catch(Exception e){
            System.out.println(e.toString());
        }
        
    }//GEN-LAST:event_Feedback_buttonActionPerformed

    private void Medical_ReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Medical_ReportActionPerformed
        // TODO add your handling code here:
        try{
  
            
            DefaultTableModel tb1Model = (DefaultTableModel)jTable3.getModel();
            
            if(jTable3.getSelectedRowCount()==1){
                
               String id = jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 0).toString();
               MongoClient mongoclient = new MongoClient("localhost",27017);
               DB mydbl =mongoclient.getDB("HMS");
               DBCollection mycoll = mydbl.getCollection("Patients");
	  

               BasicDBObject whereQuery = new BasicDBObject();
	       whereQuery.put("_id", new ObjectId(id));
               DBCursor it = mycoll.find(whereQuery);
               while(it.hasNext()){
               DBObject obj = it.next();
               String name = (String)obj.get("Name");
               String age = (String)obj.get("Age"); 
               String gender = (String)obj.get("Gender");
               String disease = (String)obj.get("Disease");
               String medicine = (String)obj.get("Medicine");
               String test = (String)obj.get("Test");
               String feedback = (String)obj.get("Feedback");
               String details = (String)obj.get("Prescriptions");
     
               
                
                Medical_Report mr = new Medical_Report();
                mr.setVisible(true);
                mr.Lab_ID.setText(id);
                mr.Lab_Name.setText(name);
                mr.Lab_Age.setText(age);
                mr.Lab_Gender.setText(gender);
                mr.Lab_Disease.setText(disease);
                mr.Lab_Medicine.setText(medicine);
                mr.Lab_Test.setText(test);
                mr.Lab_Feedback.setText(feedback);
                mr.Lab_Precaution.setText(details);
          
            }  

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
    }//GEN-LAST:event_Medical_ReportActionPerformed

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
            java.util.logging.Logger.getLogger(Receptionist_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receptionist_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receptionist_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receptionist_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receptionist_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_Patient;
    private javax.swing.JButton Delete_Patient;
    public javax.swing.JTable Doctor_Table;
    public javax.swing.JTable Feedback_Table;
    private javax.swing.JButton Feedback_button;
    private javax.swing.JButton Fix_Appointment;
    private javax.swing.JButton Medical_Report;
    public javax.swing.JTable Patient_Table;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton Refresh_Patient;
    private javax.swing.JButton Refresh_Rec;
    private javax.swing.JButton Search_Button;
    private javax.swing.JTextField Search_Field;
    private javax.swing.JTextField Search_Field1;
    private javax.swing.JTextField Search_Field2;
    private javax.swing.JTextField Search_Field3;
    private javax.swing.JButton Search_Patient;
    private javax.swing.JButton Search_Rec;
    private javax.swing.JButton Search_Rec1;
    private javax.swing.JButton Update_Patient;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    public javax.swing.JTable jTable1;
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
