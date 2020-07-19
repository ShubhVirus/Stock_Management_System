/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftware.LogIn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import login.CPU;
import login.HARDDISK;
import login.KEYBOARD;
import login.LAPTOP;
import login.MOUSE;
import login.Repairable;
import login.ROUTER1;
import login.MONITOR;
import login.MOTHERBOARD1;
import login.PRINTER;
import login.PROJECTOR;
import login.RAM;
import login.SERVER;
import inventorysoftware.LogIn.Bystem;
import javax.swing.table.TableModel;

/**
 *
 * @author Nilesh Naik
 */
public class MAIN112 extends javax.swing.JFrame {

    /**
     * Creates new form ADMIN
     */
    public MAIN112() {
        initComponents();
        HOME.setOpaque(false);
        jTabbedPane1.setVisible(false);
        jTabbedPane2.setVisible(false);
        //jPanel4.setVisible(false);
        show_bystem();
        show_rystem();
        show_tystem();
        show_Nystem();
    }
    public ArrayList<Bystem>bystemList(){
        ArrayList<Bystem> bystemList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            String query1 = "SELECT * FROM Repaired ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Bystem bystem;//int
            while(rs.next()){
                bystem = new Bystem(rs.getInt("Bills_id"),rs.getString("Shop_Name"),rs.getString("Quantity"),rs.getString("Category"),rs.getString("Total_Amount"),rs.getDate("Date_Of_Given"),rs.getDate("Date_Of_Received"),rs.getString("Remark"));
                bystemList.add(bystem);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return bystemList;
    }

    public final void show_bystem(){
        ArrayList<Bystem> list = bystemList();
        DefaultTableModel model = (DefaultTableModel)jTable3.getModel();
        Object[] row = new Object[8];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getBills_id();
            row[1]=list.get(i).getShop_Name();
            row[2]=list.get(i).getQuantity();
            row[3]=list.get(i).getCategory();
            row[4]=list.get(i).getTotal_Amount();
            row[5]=list.get(i).getDate_Of_Given();
            row[6]=list.get(i).getDate_Of_Received();
            row[7]=list.get(i).getRemark();
            model.addRow(row);
            
            
        }
        
    }
    
    public ArrayList<Nystem>nystemList(){
        ArrayList<Nystem> nystemList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            String query1 = "SELECT * FROM New_Stock ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Nystem nystem;
            while(rs.next()){
                nystem = new Nystem(rs.getInt("Bills_id"),rs.getString("Shop_Name"),rs.getString("Quantity"),rs.getString("Category"),rs.getString("Total_Amount"),rs.getDate("Date_Of_Purchase"),rs.getString("Remark"));
                nystemList.add(nystem);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return nystemList;
    }

    public void show_Nystem(){
        ArrayList<Nystem> list = nystemList();
        DefaultTableModel model1 = (DefaultTableModel)jTable2.getModel();
        Object[] row = new Object[7];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getBills_id();
            row[1]=list.get(i).getShop_Name();
            row[2]=list.get(i).getQuantity();
            row[3]=list.get(i).getCategory();
            row[4]=list.get(i).getTotal_Amount();
            row[5]=list.get(i).getDate_Of_Purchase();
            row[6]=list.get(i).getRemark();
            model1.addRow(row);
            
            
        }
        
    }
    public ArrayList<Rystem>rystemList(){
        ArrayList<Rystem> rystemList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            String query1 = "SELECT * FROM Repairable ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Rystem rystem;
            while(rs.next()){
                rystem = new Rystem(rs.getInt("Serial_No"),rs.getString("Component_id"),rs.getString("Lab_No"),rs.getString("Category"),rs.getString("PC_No"),rs.getDate("Date_Of_Fault"),rs.getString("Remark"));
                rystemList.add(rystem);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rystemList;
    }

    public final void show_rystem(){
        ArrayList<Rystem> list = rystemList();
        DefaultTableModel model = (DefaultTableModel)jTable4.getModel();
        Object[] row = new Object[7];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getSerial_No();
            row[1]=list.get(i).getComponent_id();
            row[2]=list.get(i).getLab_No();
            row[3]=list.get(i).getCategory();
            row[4]=list.get(i).getPC_No();
            row[5]=list.get(i).getDate_Of_Fault();
            row[6]=list.get(i).getRemark();
            model.addRow(row);
            
            
        }
        
    }
    public ArrayList<Tystem>tystemList(){
        ArrayList<Tystem> tystemList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            String query1 = "SELECT * FROM Trash ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Tystem tystem;
            while(rs.next()){
                tystem = new Tystem(rs.getInt("Serial_No"),rs.getString("Component_id"),rs.getString("Lab_No"),rs.getString("Category"),rs.getString("PC_No"),rs.getDate("Date_Of_Fault"),rs.getString("Remark"));
                tystemList.add(tystem);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return tystemList;
    }

    public void show_tystem(){
        ArrayList<Tystem> list = tystemList();
        DefaultTableModel model = (DefaultTableModel)jTable5.getModel();
        Object[] row = new Object[7];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getSerial_No();
            row[1]=list.get(i).getComponent_id();
            row[2]=list.get(i).getLab_No();
            row[3]=list.get(i).getCategory();
            row[4]=list.get(i).getPC_No();
            row[5]=list.get(i).getDate_Of_Fault();
            row[6]=list.get(i).getRemark();
            model.addRow(row);
            
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        HOME = new javax.swing.JButton();
        USER = new javax.swing.JButton();
        DPRODUCT = new javax.swing.JButton();
        TRASH = new javax.swing.JButton();
        BILLS = new javax.swing.JButton();
        SETTING = new javax.swing.JButton();
        EXIT = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        keyboard = new javax.swing.JButton();
        mouse = new javax.swing.JButton();
        cpu = new javax.swing.JButton();
        printer = new javax.swing.JButton();
        projector = new javax.swing.JButton();
        monitor = new javax.swing.JButton();
        router = new javax.swing.JButton();
        harddisk = new javax.swing.JButton();
        laptop = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ram = new javax.swing.JButton();
        server = new javax.swing.JButton();
        motherboard = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        reset1 = new javax.swing.JButton();
        add1 = new javax.swing.JButton();
        update1 = new javax.swing.JButton();
        delete1 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        reset = new javax.swing.JButton();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        reset2 = new javax.swing.JButton();
        add2 = new javax.swing.JButton();
        update2 = new javax.swing.JButton();
        delete2 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        reset3 = new javax.swing.JButton();
        add3 = new javax.swing.JButton();
        update3 = new javax.swing.JButton();
        delete3 = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1400, 720));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 650));

        HOME.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.disabledForeground"));
        HOME.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/home.png"))); // NOI18N
        HOME.setText("Home");
        HOME.setOpaque(false);
        HOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HOMEActionPerformed(evt);
            }
        });

        USER.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.disabledForeground"));
        USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Twitter_32px_2.png"))); // NOI18N
        USER.setText("User");
        USER.setOpaque(false);
        USER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USERActionPerformed(evt);
            }
        });

        DPRODUCT.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.disabledForeground"));
        DPRODUCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/wrench.png"))); // NOI18N
        DPRODUCT.setText("Default Products");
        DPRODUCT.setOpaque(false);
        DPRODUCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DPRODUCTActionPerformed(evt);
            }
        });

        TRASH.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.disabledForeground"));
        TRASH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/trash.png"))); // NOI18N
        TRASH.setText("Trash");
        TRASH.setOpaque(false);
        TRASH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRASHActionPerformed(evt);
            }
        });

        BILLS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/invoice.png"))); // NOI18N
        BILLS.setText("Bills");
        BILLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BILLSActionPerformed(evt);
            }
        });

        SETTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/settings.png"))); // NOI18N
        SETTING.setOpaque(false);
        SETTING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SETTINGActionPerformed(evt);
            }
        });

        EXIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/exit.png"))); // NOI18N
        EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXITActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(169, 224, 49));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_DOT_100px.png"))); // NOI18N
        jLabel18.setText("RSS QbiSoft");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TRASH, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BILLS, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DPRODUCT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(USER, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HOME, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(SETTING)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EXIT)
                .addGap(43, 43, 43))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(HOME, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(USER, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(DPRODUCT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(TRASH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(BILLS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SETTING)
                    .addComponent(EXIT))
                .addGap(46, 46, 46))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 660));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg/Stellar.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 660));

        jLabel16.setBackground(new java.awt.Color(51, 153, 255));
        jLabel16.setOpaque(true);
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 1110, 30));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spl pro/icons8-restart-32.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 40, 30, 30));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spl pro/icons8-shutdown-32.png"))); // NOI18N
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 40, 30, 30));

        jScrollPane1.setAlignmentX(0.0F);
        jScrollPane1.setAlignmentY(110.0F);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(819, 550));
        jScrollPane1.setWheelScrollingEnabled(false);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        keyboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/electronics.png"))); // NOI18N
        keyboard.setBorder(null);
        keyboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyboardActionPerformed(evt);
            }
        });

        mouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/computer.png"))); // NOI18N
        mouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mouseActionPerformed(evt);
            }
        });

        cpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/cpu.png"))); // NOI18N
        cpu.setBorder(null);
        cpu.setBorderPainted(false);
        cpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpuActionPerformed(evt);
            }
        });

        printer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/print.png"))); // NOI18N
        printer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printerActionPerformed(evt);
            }
        });

        projector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/projector.png"))); // NOI18N
        projector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectorActionPerformed(evt);
            }
        });

        monitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/monitor (1).png"))); // NOI18N
        monitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitorActionPerformed(evt);
            }
        });

        router.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/router.png"))); // NOI18N
        router.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routerActionPerformed(evt);
            }
        });

        harddisk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spl pro/icons8-hdd-100.png"))); // NOI18N
        harddisk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harddiskActionPerformed(evt);
            }
        });

        laptop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/computer (2).png"))); // NOI18N
        laptop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laptopActionPerformed(evt);
            }
        });

        jLabel3.setText("                          C.P.U");

        jLabel5.setText("Printer");

        jLabel6.setText("                          Mouse");

        jLabel7.setText("                       Keyboard");

        jLabel8.setText("                        Laptop");

        jLabel9.setText("                       Hard Disk");

        jLabel10.setText("                        Monitor");

        jLabel12.setText("                       Projector");

        jLabel13.setText("                         Router");

        ram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/icons8-smartphone-ram-100.png"))); // NOI18N
        ram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramActionPerformed(evt);
            }
        });

        server.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/server.png"))); // NOI18N
        server.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverActionPerformed(evt);
            }
        });

        motherboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/icons8-motherboard-100.png"))); // NOI18N
        motherboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motherboardActionPerformed(evt);
            }
        });

        jLabel14.setText("                            RAM");

        jLabel15.setText("                         Server");

        jLabel17.setText("                     Mother Board");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(laptop, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(cpu, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(projector, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(motherboard, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(86, 86, 86)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(monitor, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(keyboard, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(router, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(ram, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(server, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(printer, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(mouse, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(harddisk, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(155, 155, 155))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mouse, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cpu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(keyboard, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laptop, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monitor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projector, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(router, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(harddisk, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(motherboard, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ram, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(server, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 1000, -1));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1060, 550));

        jPanel4.setMinimumSize(new java.awt.Dimension(1060, 550));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setBackground(new java.awt.Color(0, 204, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("REPAIRED");
        jLabel19.setOpaque(true);
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 11, -1, -1));

        jTable3.setBackground(new java.awt.Color(85, 85, 85));
        jTable3.setForeground(new java.awt.Color(0, 153, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bills_id", "Shop_Name", "Quantity", "Category", "Total_Amount", "Date_Of_Given", "Date_Of_Received", "Remark"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable3.setFocusable(false);
        jTable3.setGridColor(new java.awt.Color(0, 204, 204));
        jTable3.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable3.setRowHeight(25);
        jTable3.setSelectionBackground(new java.awt.Color(255, 102, 102));
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 640, 475));

        jLabel20.setBackground(new java.awt.Color(0, 204, 255));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Bills_id                          :");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 40, 160, 35));

        jLabel21.setBackground(new java.awt.Color(0, 204, 255));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Shop_Name                 :");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 86, 160, 35));

        jLabel22.setBackground(new java.awt.Color(0, 204, 255));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Quantity                      :");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 139, 160, 35));

        jLabel23.setBackground(new java.awt.Color(0, 204, 255));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Category                      :");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 192, 160, 35));

        jLabel24.setBackground(new java.awt.Color(0, 204, 255));
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Total_Amount              :");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 241, 160, 35));

        jLabel25.setBackground(new java.awt.Color(0, 204, 255));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Date_Of_Given             :");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 298, 160, 35));

        jTextField13.setBackground(new java.awt.Color(0, 204, 255));
        jTextField13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 40, 140, 35));

        jTextField14.setBackground(new java.awt.Color(0, 204, 255));
        jTextField14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 86, 139, 35));

        jLabel26.setBackground(new java.awt.Color(0, 204, 255));
        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Remark                         :");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 452, 160, 35));

        jComboBox3.setBackground(new java.awt.Color(0, 204, 255));
        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MONITOR", "CPU", "MOUSE", "MOTHERBOARD", "HARDDISK", "KEYBOARD", "PRINTER", "PROJECTOR", "LAPTOP", "SERVER", "ROUTER", " " }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 195, 139, 28));

        jTextField15.setBackground(new java.awt.Color(0, 204, 255));
        jTextField15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 241, 139, 35));

        jTextField16.setBackground(new java.awt.Color(0, 204, 255));
        jTextField16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 298, 139, 35));

        jTextField17.setBackground(new java.awt.Color(0, 204, 255));
        jTextField17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 430, 139, 70));

        jTextField18.setBackground(new java.awt.Color(0, 204, 255));
        jTextField18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 139, 139, 35));

        reset1.setBackground(new java.awt.Color(0, 204, 255));
        reset1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reset1.setText("Reset");
        reset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset1ActionPerformed(evt);
            }
        });
        jPanel6.add(reset1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, 82, 36));

        add1.setBackground(new java.awt.Color(0, 204, 255));
        add1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add1.setText("Add");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        jPanel6.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 82, 36));

        update1.setBackground(new java.awt.Color(0, 204, 255));
        update1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        update1.setText("Update");
        update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update1ActionPerformed(evt);
            }
        });
        jPanel6.add(update1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 82, 36));

        delete1.setBackground(new java.awt.Color(0, 204, 255));
        delete1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete1.setText("Delete");
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });
        jPanel6.add(delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 530, 82, 36));

        jLabel27.setBackground(new java.awt.Color(0, 204, 255));
        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Date_Of_Received         :");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 359, 160, 35));

        jTextField19.setBackground(new java.awt.Color(0, 204, 255));
        jTextField19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 359, 139, 35));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, -1));

        jTabbedPane1.addTab("Repaired", jPanel4);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setBackground(new java.awt.Color(0, 204, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("NEW STOCK");
        jLabel11.setOpaque(true);

        jTable2.setBackground(new java.awt.Color(85, 85, 85));
        jTable2.setForeground(new java.awt.Color(0, 153, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bills_id", "Shop_Name", "Quantity", "Category", "Total_Amount", "Date_Of_Purchase", "Remark"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setFocusable(false);
        jTable2.setGridColor(new java.awt.Color(0, 204, 204));
        jTable2.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable2.setRowHeight(25);
        jTable2.setSelectionBackground(new java.awt.Color(255, 102, 102));
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel28.setBackground(new java.awt.Color(0, 204, 255));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Bills_id                        :");

        jLabel29.setBackground(new java.awt.Color(0, 204, 255));
        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Shop_Name                 :");

        jLabel30.setBackground(new java.awt.Color(0, 204, 255));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Quantity                       :");

        jLabel31.setBackground(new java.awt.Color(0, 204, 255));
        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Category                      :");

        jLabel32.setBackground(new java.awt.Color(0, 204, 255));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Total_Amount             :");

        jLabel33.setBackground(new java.awt.Color(0, 204, 255));
        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Date_Of_Purchase       :");

        jTextField7.setBackground(new java.awt.Color(0, 204, 255));
        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField8.setBackground(new java.awt.Color(0, 204, 255));
        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel34.setBackground(new java.awt.Color(0, 204, 255));
        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Remark                         :");

        jComboBox2.setBackground(new java.awt.Color(0, 204, 255));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MONITOR", "CPU", "MOUSE", "MOTHERBOARD", "HARDDISK", "KEYBOARD", "PRINTER", "PROJECTOR", "LAPTOP", "SERVER", "ROUTER", " " }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTextField9.setBackground(new java.awt.Color(0, 204, 255));
        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField10.setBackground(new java.awt.Color(0, 204, 255));
        jTextField10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField11.setBackground(new java.awt.Color(0, 204, 255));
        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField12.setBackground(new java.awt.Color(0, 204, 255));
        jTextField12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        reset.setBackground(new java.awt.Color(0, 204, 255));
        reset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(0, 204, 255));
        add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(0, 204, 255));
        update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(0, 204, 255));
        delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField11)))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(31, 31, 31)
                                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jTextField8)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(45, 45, 45))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("New Stock", jPanel7);

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Others", jPanel9);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 1040, 600));

        jTabbedPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(1060, 550));

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));
        jPanel13.setMinimumSize(new java.awt.Dimension(1060, 550));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/wrench (1).png"))); // NOI18N
        jLabel43.setText("REPAIRABLE");

        jTable4.setBackground(new java.awt.Color(85, 85, 85));
        jTable4.setForeground(new java.awt.Color(0, 153, 255));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial_No", "Componet_id", "Lab_No", "Category", "PC_No", "Date_Of_Fault", "Remark"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable4.setFocusable(false);
        jTable4.setGridColor(new java.awt.Color(0, 204, 204));
        jTable4.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable4.setRowHeight(25);
        jTable4.setSelectionBackground(new java.awt.Color(255, 102, 102));
        jTable4.getTableHeader().setReorderingAllowed(false);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jLabel44.setBackground(new java.awt.Color(0, 204, 255));
        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setText("Serial_No                     :");

        jLabel45.setBackground(new java.awt.Color(0, 204, 255));
        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setText("Component_id             :");

        jLabel46.setBackground(new java.awt.Color(0, 204, 255));
        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setText("Lab_No                        :");

        jLabel47.setBackground(new java.awt.Color(0, 204, 255));
        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setText("Category                      :");

        jLabel48.setBackground(new java.awt.Color(0, 204, 255));
        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("PC_No.                         :");

        jLabel49.setBackground(new java.awt.Color(0, 204, 255));
        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setText("Date_Of_Fault              :");

        jTextField26.setBackground(new java.awt.Color(0, 204, 255));
        jTextField26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField20.setBackground(new java.awt.Color(0, 204, 255));
        jTextField20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel50.setBackground(new java.awt.Color(0, 204, 255));
        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setText("Remark                         :");

        jComboBox4.setBackground(new java.awt.Color(0, 204, 255));
        jComboBox4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MONITOR", "CPU", "MOUSE", "MOTHERBOARD", "HARDDISK", "KEYBOARD", "PRINTER", "PROJECTOR", "LAPTOP", "SERVER", "ROUTER", " " }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4jComboBox3ActionPerformed(evt);
            }
        });

        jTextField21.setBackground(new java.awt.Color(0, 204, 255));
        jTextField21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField22.setBackground(new java.awt.Color(0, 204, 255));
        jTextField22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField23.setBackground(new java.awt.Color(0, 204, 255));
        jTextField23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField24.setBackground(new java.awt.Color(0, 204, 255));
        jTextField24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        reset2.setBackground(new java.awt.Color(0, 204, 255));
        reset2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reset2.setText("Reset");
        reset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset2reset1ActionPerformed(evt);
            }
        });

        add2.setBackground(new java.awt.Color(0, 204, 255));
        add2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add2.setText("Add");
        add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add2add1ActionPerformed(evt);
            }
        });

        update2.setBackground(new java.awt.Color(0, 204, 255));
        update2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        update2.setText("Update");
        update2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update2update1ActionPerformed(evt);
            }
        });

        delete2.setBackground(new java.awt.Color(0, 204, 255));
        delete2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete2.setText("Delete");
        delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete2delete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField21)
                                    .addComponent(jTextField22)
                                    .addComponent(jTextField23, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jTextField26))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField20)
                                    .addComponent(jTextField24, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(35, 35, 35))
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(add2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(update2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(reset2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reset2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 102, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Repairable", jPanel11);

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));

        jPanel15.setBackground(new java.awt.Color(204, 204, 204));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro/trash (1).png"))); // NOI18N
        jLabel51.setText("TRASH");

        jTable5.setBackground(new java.awt.Color(85, 85, 85));
        jTable5.setForeground(new java.awt.Color(0, 153, 255));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial_No", "Componet_id", "Lab_No", "Category", "PC_No", "Date_Of_Fault", "Remark"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable5.setFocusable(false);
        jTable5.setGridColor(new java.awt.Color(0, 204, 204));
        jTable5.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable5.setRowHeight(25);
        jTable5.setSelectionBackground(new java.awt.Color(255, 102, 102));
        jTable5.getTableHeader().setReorderingAllowed(false);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jLabel52.setBackground(new java.awt.Color(0, 204, 255));
        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setText("Serial_No                     :");

        jLabel53.setBackground(new java.awt.Color(0, 204, 255));
        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel53.setText("Component_id             :");

        jLabel54.setBackground(new java.awt.Color(0, 204, 255));
        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setText("Lab_No                        :");

        jLabel55.setBackground(new java.awt.Color(0, 204, 255));
        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel55.setText("Category                      :");

        jLabel56.setBackground(new java.awt.Color(0, 204, 255));
        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel56.setText("PC_No.                         :");

        jLabel57.setBackground(new java.awt.Color(0, 204, 255));
        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel57.setText("Date_Of_Fault              :");

        jTextField27.setBackground(new java.awt.Color(0, 204, 255));
        jTextField27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField28.setBackground(new java.awt.Color(0, 204, 255));
        jTextField28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel58.setBackground(new java.awt.Color(0, 204, 255));
        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setText("Remark                         :");

        jComboBox5.setBackground(new java.awt.Color(0, 204, 255));
        jComboBox5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MONITOR", "CPU", "MOUSE", "MOTHERBOARD", "HARDDISK", "KEYBOARD", "PRINTER", "PROJECTOR", "LAPTOP", "SERVER", "ROUTER", " " }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jTextField29.setBackground(new java.awt.Color(0, 204, 255));
        jTextField29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField30.setBackground(new java.awt.Color(0, 204, 255));
        jTextField30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField31.setBackground(new java.awt.Color(0, 204, 255));
        jTextField31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField32.setBackground(new java.awt.Color(0, 204, 255));
        jTextField32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        reset3.setBackground(new java.awt.Color(0, 204, 255));
        reset3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reset3.setText("Reset");
        reset3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset3ActionPerformed(evt);
            }
        });

        add3.setBackground(new java.awt.Color(0, 204, 255));
        add3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add3.setText("Add");
        add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add3ActionPerformed(evt);
            }
        });

        update3.setBackground(new java.awt.Color(0, 204, 255));
        update3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        update3.setText("Update");
        update3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update3ActionPerformed(evt);
            }
        });

        delete3.setBackground(new java.awt.Color(0, 204, 255));
        delete3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete3.setText("Delete");
        delete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField29)
                                            .addComponent(jTextField30)
                                            .addComponent(jTextField31, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jTextField27))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField28)
                                            .addComponent(jTextField32, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(26, 26, 26))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(add3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(delete3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(update3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(reset3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(358, 358, 358))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reset3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 1126, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Trash", jPanel14);

        jPanel1.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 1050, 610));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1420, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HOMEActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setVisible(false);
        jScrollPane1.setVisible(true);
        jTabbedPane1.setVisible(false);
        
    }//GEN-LAST:event_HOMEActionPerformed

    private void USERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USERActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_USERActionPerformed

    private void TRASHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRASHActionPerformed
        // TODO add your handling code here:
        //TRASH TR = new TRASH();
        //TR.setVisible(true);
    }//GEN-LAST:event_TRASHActionPerformed

    private void SETTINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SETTINGActionPerformed
        // TODO add your handling code here:
        //jPanel4.setVisible(true);
    }//GEN-LAST:event_SETTINGActionPerformed

    private void DPRODUCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DPRODUCTActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setVisible(true);
        jScrollPane1.setVisible(false);
        jTabbedPane1.setVisible(false);
        
    }//GEN-LAST:event_DPRODUCTActionPerformed

    private void BILLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BILLSActionPerformed
        // TODO add your handling code here:
        //BILLS bl = new BILLS();
        //bl.setVisible(true);
        jTabbedPane1.setVisible(true);
        jScrollPane1.setVisible(false);
        jTabbedPane2.setVisible(false);
    }//GEN-LAST:event_BILLSActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void keyboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyboardActionPerformed
        // TODO add your handling code here:
        KEYBOARD KB = new KEYBOARD();
        KB.setVisible(true);
    }//GEN-LAST:event_keyboardActionPerformed

    private void mouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mouseActionPerformed
        // TODO add your handling code here:
        MOUSE MO = new MOUSE();
        MO.setVisible(true);
    }//GEN-LAST:event_mouseActionPerformed

    private void cpuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpuActionPerformed
        // TODO add your handling code here:
        CPU.setDefaultLookAndFeelDecorated(rootPaneCheckingEnabled);
        CPU cp = new CPU();
        cp.setVisible(true);
    }//GEN-LAST:event_cpuActionPerformed

    private void printerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printerActionPerformed
        // TODO add your handling code here:
        PRINTER MO = new PRINTER();
        MO.setVisible(true);
    }//GEN-LAST:event_printerActionPerformed

    private void projectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectorActionPerformed
        // TODO add your handling code here:
        PROJECTOR PR = new PROJECTOR();
        PR.setVisible(true);
    }//GEN-LAST:event_projectorActionPerformed

    private void monitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitorActionPerformed
        // TODO add your handling code here:
        MONITOR MN = new MONITOR();
        MN.setVisible(true);
    }//GEN-LAST:event_monitorActionPerformed

    private void routerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routerActionPerformed
        // TODO add your handling code here:
        ROUTER1 RO = new ROUTER1();
        RO.setVisible(true);
    }//GEN-LAST:event_routerActionPerformed

    private void harddiskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harddiskActionPerformed
        // TODO add your handling code here:
        HARDDISK HD = new HARDDISK();
        HD.setVisible(true);
    }//GEN-LAST:event_harddiskActionPerformed

    private void laptopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laptopActionPerformed
        // TODO add your handling code here:
        LAPTOP LP = new LAPTOP();
        LP.setVisible(true);
    }//GEN-LAST:event_laptopActionPerformed

    private void ramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramActionPerformed
        // TODO add your handling code here:
        RAM RM = new RAM();
        RM.setVisible(true);
    }//GEN-LAST:event_ramActionPerformed

    private void serverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverActionPerformed
        // TODO add your handling code here:
        SERVER SR = new SERVER();
        SR.setVisible(true);
    }//GEN-LAST:event_serverActionPerformed

    private void motherboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motherboardActionPerformed
        // TODO add your handling code here:
        MOTHERBOARD1 MB = new MOTHERBOARD1();
        MB.setVisible(true);
    }//GEN-LAST:event_motherboardActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        int i = jTable3.getSelectedRow();
        TableModel model = jTable3.getModel();
        jTextField14.setText(model.getValueAt(i, 1).toString());
        jTextField18.setText(model.getValueAt(i, 2).toString());
        String category1 = model.getValueAt(i, 3).toString();
            switch (category1){
                case "MONITOR":
                    jComboBox3.setSelectedIndex(0);
                    break;
                case "CPU":
                    jComboBox3.setSelectedIndex(1);
                    break;
                case "MOUSE":
                    jComboBox3.setSelectedIndex(2);
                    break;
                case "MOTHERBOARD":
                    jComboBox3.setSelectedIndex(3);
                    break;    
                case "HARDDISK":
                    jComboBox3.setSelectedIndex(4);
                    break;
                case "KEYBOARD":
                    jComboBox3.setSelectedIndex(5);
                    break;
                case "PRINTER":
                    jComboBox3.setSelectedIndex(6);
                    break;
                case "PROJECTOR":
                    jComboBox3.setSelectedIndex(7);
                    break;
                case "LAPTOP":
                    jComboBox3.setSelectedIndex(8);
                    break;
                case "SERVER":
                    jComboBox3.setSelectedIndex(9);
                    break;
                case "ROUTER":
                    jComboBox3.setSelectedIndex(10);
                    break;    
            
            }
        jTextField15.setText(model.getValueAt(i, 4).toString());
        jTextField16.setText(model.getValueAt(i, 5).toString());
        jTextField19.setText(model.getValueAt(i, 6).toString());
        jTextField17.setText(model.getValueAt(i, 7).toString());
        
    }//GEN-LAST:event_jTable3MouseClicked

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void reset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset1ActionPerformed
        // TODO add your handling code here:
        //jTextField13.setText("");
        jTextField14.setText("");
        jTextField18.setText("");
        jComboBox3.setSelectedIndex(0);
        jTextField15.setText("");
        jTextField16.setText("");
        jTextField19.setText("");
        jTextField17.setText("");
    }//GEN-LAST:event_reset1ActionPerformed

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO CPUedit your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            String query = "INSERT INTO REPAIRED(Bills_id,Shop_Name,_Quantity,Category,Total_Amount,Date_Of_Given,Date_Of_Received,Remark)values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(0, jTextField13.getText());
            pst.setString(1, jTextField14.getText());
            pst.setString(2, jTextField18.getText());
            String category;
            category=jComboBox3.getSelectedItem().toString();
            pst.setString(3,category);
            pst.setString(4, jTextField15.getText());
            pst.setString(5, jTextField16.getText());
            pst.setString(6, jTextField19.getText());
            pst.setString(7, jTextField17.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable3.getModel();
            model.setRowCount(0);
            show_bystem();
            //jTextField13.setText("");
            jTextField14.setText("");
            jTextField18.setText("");
            jComboBox3.setSelectedIndex(0);
            jTextField15.setText("");
            jTextField16.setText("");
            jTextField19.setText("");
            jTextField17.setText("");
            JOptionPane.showMessageDialog(null, "Inserted Successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
    }//GEN-LAST:event_add1ActionPerformed

    private void update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            int row = jTable3.getSelectedRow();
            String value = (jTable3.getModel().getValueAt(row, 0).toString());
            String query = "UPDATE REPAIRED SET Shop_Name=?,_Quantity=?,Category=?,Total_Amount=?,Date_Of_Given=?,Date_Of_Received=?,Remark=? WHERE Bills_id="+value;
            PreparedStatement pst=con.prepareStatement(query);
            //pst.setString(0, jTextField13.getText());
            pst.setString(1, jTextField14.getText());
            pst.setString(2, jTextField18.getText());
            String category;
            category=jComboBox3.getSelectedItem().toString();
            pst.setString(3,category);
            pst.setString(4, jTextField15.getText());
            pst.setString(5, jTextField16.getText());
            pst.setString(6, jTextField19.getText());
            pst.setString(7, jTextField17.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable3.getModel();
            model.setRowCount(0);
            show_bystem();
            //jTextField13.setText("");
            jTextField14.setText("");
            jTextField18.setText("");
            jComboBox3.setSelectedIndex(0);
            jTextField15.setText("");
            jTextField16.setText("");
            jTextField19.setText("");
            jTextField17.setText("");
            JOptionPane.showMessageDialog(null, "Updated Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
    }//GEN-LAST:event_update1ActionPerformed

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            int row = jTable3.getSelectedRow();
            String value = (jTable3.getModel().getValueAt(row, 0).toString());
            String query = "Delete FROM REPAIRED WHERE Bills_id="+value;
            PreparedStatement pst=con.prepareStatement(query);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable3.getModel();
            model.setRowCount(0);
            show_bystem(); 
            //jTextField13.setText("");
            jTextField14.setText("");
            jTextField18.setText("");
            jComboBox3.setSelectedIndex(0);
            jTextField15.setText("");
            jTextField16.setText("");
            jTextField19.setText("");
            jTextField17.setText("");
            JOptionPane.showMessageDialog(null, "Deleted Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
    }//GEN-LAST:event_delete1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int i = jTable2.getSelectedRow();
        TableModel model = jTable2.getModel();
        jTextField7.setText(model.getValueAt(i, 0).toString());
        jTextField8.setText(model.getValueAt(i, 1).toString());
        jTextField12.setText(model.getValueAt(i, 2).toString());
        String category1 = model.getValueAt(i, 3).toString();
            switch (category1){
                case "MONITOR":
                    jComboBox2.setSelectedIndex(0);
                    break;
                case "CPU":
                    jComboBox2.setSelectedIndex(1);
                    break;
                case "MOUSE":
                    jComboBox2.setSelectedIndex(2);
                    break;
                case "MOTHERBOARD":
                    jComboBox2.setSelectedIndex(3);
                    break;    
                case "HARDDISK":
                    jComboBox2.setSelectedIndex(4);
                    break;
                case "KEYBOARD":
                    jComboBox2.setSelectedIndex(5);
                    break;
                case "PRINTER":
                    jComboBox2.setSelectedIndex(6);
                    break;
                case "PROJECTOR":
                    jComboBox2.setSelectedIndex(7);
                    break;
                case "LAPTOP":
                    jComboBox2.setSelectedIndex(8);
                    break;
                case "SERVER":
                    jComboBox2.setSelectedIndex(9);
                    break;
                case "ROUTER":
                    jComboBox2.setSelectedIndex(10);
                    break;    
            
            }
        jTextField9.setText(model.getValueAt(i, 4).toString());
        jTextField10.setText(model.getValueAt(i, 5).toString());
        jTextField11.setText(model.getValueAt(i, 6).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField12.setText("");
        jComboBox2.setSelectedIndex(0);
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try {
            // TODO CPUedit your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            String query = "INSERT INTO NEW_STOCK(Bills_id,Shop_Name,Quantity,Category,Total_Amount,Date_Of_Purchase,Remark)values(?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(0, jTextField7.getText());
            pst.setString(1, jTextField8.getText());
            pst.setString(2, jTextField12.getText());
            String category;
            category=jComboBox2.getSelectedItem().toString();
            pst.setString(3,category);
            pst.setString(4, jTextField9.getText());
            pst.setString(5, jTextField10.getText());
            pst.setString(6, jTextField11.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
            model.setRowCount(0);
            show_Nystem();
            jTextField7.setText("");
            jTextField8.setText("");
            jTextField12.setText("");
            jComboBox2.setSelectedIndex(0);
            jTextField9.setText("");
            jTextField10.setText("");
            jTextField11.setText("");
            JOptionPane.showMessageDialog(null, "Inserted Successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            int row = jTable2.getSelectedRow();
            String value = (jTable2.getModel().getValueAt(row, 0).toString());
            String query = "UPDATE NEW_STOCK SET Shop_Name=?,Quantity=?,Category=?,Total_Amount=?,Date_Of_Purchase=?,Remark=? WHERE Bills_id="+value;
            PreparedStatement pst=con.prepareStatement(query);
            //pst.setString(0, jTextField7.getText());
            pst.setString(1, jTextField8.getText());
            pst.setString(2, jTextField12.getText());
            String category;
            category=jComboBox2.getSelectedItem().toString();
            pst.setString(3,category);
            pst.setString(4, jTextField9.getText());
            pst.setString(5, jTextField10.getText());
            pst.setString(6, jTextField11.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
            model.setRowCount(0);
            show_Nystem();
            jTextField7.setText("");
            jTextField8.setText("");
            jTextField12.setText("");
            jComboBox2.setSelectedIndex(0);
            jTextField9.setText("");
            jTextField10.setText("");
            jTextField11.setText("");
            JOptionPane.showMessageDialog(null, "Updated Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            int row = jTable2.getSelectedRow();
            String value = (jTable2.getModel().getValueAt(row, 0).toString());
            String query = "Delete FROM NEW_STOCK WHERE Bills_id="+value;
            PreparedStatement pst=con.prepareStatement(query);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
            model.setRowCount(0);
            show_Nystem();
            jTextField7.setText("");
            jTextField8.setText("");
            jTextField12.setText("");
            jComboBox2.setSelectedIndex(0);
            jTextField9.setText("");
            jTextField10.setText("");
            jTextField11.setText("");
            JOptionPane.showMessageDialog(null, "Deleted Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void jTable4jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4jTable3MouseClicked
        // TODO add your handling code here:
        int i = jTable4.getSelectedRow();
        TableModel model = jTable4.getModel();
        jTextField26.setText(model.getValueAt(i, 0).toString());
        jTextField20.setText(model.getValueAt(i, 1).toString());
        jTextField24.setText(model.getValueAt(i, 2).toString());
        String category1 = model.getValueAt(i, 3).toString();
            switch (category1){
                case "MONITOR":
                    jComboBox4.setSelectedIndex(0);
                    break;
                case "CPU":
                    jComboBox4.setSelectedIndex(1);
                    break;
                case "MOUSE":
                    jComboBox4.setSelectedIndex(2);
                    break;
                case "MOTHERBOARD":
                    jComboBox4.setSelectedIndex(3);
                    break;    
                case "HARDDISK":
                    jComboBox4.setSelectedIndex(4);
                    break;
                case "KEYBOARD":
                    jComboBox4.setSelectedIndex(5);
                    break;
                case "PRINTER":
                    jComboBox4.setSelectedIndex(6);
                    break;
                case "PROJECTOR":
                    jComboBox4.setSelectedIndex(7);
                    break;
                case "LAPTOP":
                    jComboBox4.setSelectedIndex(8);
                    break;
                case "SERVER":
                    jComboBox4.setSelectedIndex(9);
                    break;
                case "ROUTER":
                    jComboBox4.setSelectedIndex(10);
                    break;    
            
            }
        jTextField21.setText(model.getValueAt(i, 4).toString());
        jTextField22.setText(model.getValueAt(i, 5).toString());
        jTextField23.setText(model.getValueAt(i, 6).toString());
    }//GEN-LAST:event_jTable4jTable3MouseClicked

    private void jComboBox4jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4jComboBox3ActionPerformed

    private void reset2reset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset2reset1ActionPerformed
        // TODO add your handling code here:
        jTextField26.setText("");
        jTextField20.setText("");
        jTextField24.setText("");
        jComboBox4.setSelectedIndex(0);
        jTextField21.setText("");
        jTextField22.setText("");
        jTextField23.setText("");
        
    }//GEN-LAST:event_reset2reset1ActionPerformed

    private void add2add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add2add1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO CPUedit your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            String query = "INSERT INTO REPAIRABLE(Serial_No,Component_id,Lab_No,Category,PC_No,Date_Of_Fault,Remark)values(?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(0, jTextField26.getText());
            pst.setString(1, jTextField20.getText());
            pst.setString(2, jTextField24.getText());
            String category;
            category=jComboBox4.getSelectedItem().toString();
            pst.setString(3,category);
            pst.setString(4, jTextField21.getText());
            pst.setString(5, jTextField22.getText());
            pst.setString(6, jTextField23.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable4.getModel();
            model.setRowCount(0);
            show_rystem();
            jTextField26.setText("");
            jTextField20.setText("");
            jTextField24.setText("");
            jComboBox4.setSelectedIndex(0);
            jTextField21.setText("");
            jTextField22.setText("");
            jTextField23.setText("");
            JOptionPane.showMessageDialog(null, "Inserted Successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
        
    }//GEN-LAST:event_add2add1ActionPerformed

    private void update2update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update2update1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            int row = jTable4.getSelectedRow();
            String value = (jTable4.getModel().getValueAt(row, 0).toString());
            String query = "UPDATE REPAIRABLE SET Component_id=?,Lab_No=?,Category=?,PC_No=?,Date_Of_Fault=?,Remark=? WHERE Serial_No="+value;
            PreparedStatement pst=con.prepareStatement(query);
            //pst.setString(0, jTextField26.getText());
            pst.setString(1, jTextField20.getText());
            pst.setString(2, jTextField24.getText());
            String category;
            category=jComboBox4.getSelectedItem().toString();
            pst.setString(3,category);
            pst.setString(4, jTextField21.getText());
            pst.setString(5, jTextField22.getText());
            pst.setString(6, jTextField23.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable4.getModel();
            model.setRowCount(0);
            show_rystem();
            jTextField26.setText("");
            jTextField20.setText("");
            jTextField24.setText("");
            jComboBox4.setSelectedIndex(0);
            jTextField21.setText("");
            jTextField22.setText("");
            jTextField23.setText("");
            JOptionPane.showMessageDialog(null, "Updated Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
    }//GEN-LAST:event_update2update1ActionPerformed

    private void delete2delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete2delete1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            int row = jTable4.getSelectedRow();
            //String value = jTextField26.getText();
            String value = (jTable4.getModel().getValueAt(row, 0).toString());
            String query = "Delete FROM REPAIRABLE WHERE Serial_No="+value;
            PreparedStatement pst=con.prepareStatement(query);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable4.getModel();
            model.setRowCount(0);
            show_rystem();
            jTextField26.setText("");
            jTextField20.setText("");
            jTextField24.setText("");
            jComboBox4.setSelectedIndex(0);
            jTextField21.setText("");
            jTextField22.setText("");
            jTextField23.setText("");
            JOptionPane.showMessageDialog(null, "Deleted Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
        
    }//GEN-LAST:event_delete2delete1ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
        int i = jTable5.getSelectedRow();
        TableModel model = jTable5.getModel();
        jTextField27.setText(model.getValueAt(i, 0).toString());
        jTextField28.setText(model.getValueAt(i, 1).toString());
        jTextField32.setText(model.getValueAt(i, 2).toString());
        String category1 = model.getValueAt(i, 3).toString();
            switch (category1){
                case "MONITOR":
                    jComboBox5.setSelectedIndex(0);
                    break;
                case "CPU":
                    jComboBox5.setSelectedIndex(1);
                    break;
                case "MOUSE":
                    jComboBox5.setSelectedIndex(2);
                    break;
                case "MOTHERBOARD":
                    jComboBox5.setSelectedIndex(3);
                    break;    
                case "HARDDISK":
                    jComboBox5.setSelectedIndex(4);
                    break;
                case "KEYBOARD":
                    jComboBox5.setSelectedIndex(5);
                    break;
                case "PRINTER":
                    jComboBox5.setSelectedIndex(6);
                    break;
                case "PROJECTOR":
                    jComboBox5.setSelectedIndex(7);
                    break;
                case "LAPTOP":
                    jComboBox5.setSelectedIndex(8);
                    break;
                case "SERVER":
                    jComboBox5.setSelectedIndex(9);
                    break;
                case "ROUTER":
                    jComboBox5.setSelectedIndex(10);
                    break;    
            
            }
        //jComboBox5.setText(model.getValueAt(i, 3).toString());
        jTextField29.setText(model.getValueAt(i, 4).toString());
        jTextField30.setText(model.getValueAt(i, 5).toString());
        jTextField31.setText(model.getValueAt(i, 6).toString());
        
        
    }//GEN-LAST:event_jTable5MouseClicked

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void reset3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset3ActionPerformed
        // TODO add your handling code here:
        jTextField27.setText("");
        jTextField28.setText("");
        jTextField32.setText("");
        jComboBox5.setSelectedIndex(0);
        jTextField29.setText("");
        jTextField30.setText("");
        jTextField31.setText("");
    }//GEN-LAST:event_reset3ActionPerformed

    private void add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add3ActionPerformed
        try {
            // TODO CPUedit your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            String query = "INSERT INTO TRASH(Serial_No,Component_id,Lab_No,Category,PC_No,Date_Of_Fault,Remark)values(?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(0, jTextField27.getText());
            pst.setString(1, jTextField28.getText());
            pst.setString(2, jTextField32.getText());
            String category;
            category=jComboBox5.getSelectedItem().toString();
            pst.setString(3,category);
            pst.setString(4, jTextField29.getText());
            pst.setString(5, jTextField30.getText());
            pst.setString(6, jTextField31.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable5.getModel();
            model.setRowCount(0);
            show_tystem();
            jTextField27.setText("");
            jTextField28.setText("");
            jTextField32.setText("");
            jComboBox5.setSelectedIndex(0);
            jTextField29.setText("");
            jTextField30.setText("");
            jTextField31.setText("");
            JOptionPane.showMessageDialog(null, "Inserted Successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
    }//GEN-LAST:event_add3ActionPerformed

    private void update3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update3ActionPerformed
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            int row = jTable5.getSelectedRow();
            String value = (jTable5.getModel().getValueAt(row, 0).toString());
            String query = "UPDATE TRASH SET Component_id=?,Lab_No=?,Category=?,PC_No=?,Date_Of_Fault=?,Remark=? WHERE Serial_No="+value;
            PreparedStatement pst=con.prepareStatement(query);
            ///pst.setString(0, jTextField27.getText());
            pst.setString(1, jTextField28.getText());
            pst.setString(2, jTextField32.getText());
            String category;
            category=jComboBox5.getSelectedItem().toString();
            pst.setString(3,category);
            pst.setString(4, jTextField29.getText());
            pst.setString(5, jTextField30.getText());
            pst.setString(6, jTextField31.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable5.getModel();
            model.setRowCount(0);
            show_tystem();
            jTextField27.setText("");
            jTextField28.setText("");
            jTextField32.setText("");
            jComboBox5.setSelectedIndex(0);
            jTextField29.setText("");
            jTextField30.setText("");
            jTextField31.setText("");
            JOptionPane.showMessageDialog(null, "Updated Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
    }//GEN-LAST:event_update3ActionPerformed

    private void delete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete3ActionPerformed
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            int row = jTable5.getSelectedRow();
            String value = (jTable5.getModel().getValueAt(row, 0).toString());
            String query = "Delete FROM TRASH WHERE Serial_No="+value;
            PreparedStatement pst=con.prepareStatement(query);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable5.getModel();
            model.setRowCount(0);
            show_tystem();
            jTextField27.setText("");
            jTextField28.setText("");
            jTextField32.setText("");
            jComboBox5.setSelectedIndex(0);
            jTextField29.setText("");
            jTextField30.setText("");
            jTextField31.setText("");
            JOptionPane.showMessageDialog(null, "Deleted Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
    }//GEN-LAST:event_delete3ActionPerformed

    private void EXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXITActionPerformed
        // TODO add your handling code here:
        NewSignin nm = new NewSignin();
        nm.setVisible(true);
    }//GEN-LAST:event_EXITActionPerformed

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
            java.util.logging.Logger.getLogger(MAIN112.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MAIN112.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MAIN112.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MAIN112.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new MAIN112().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BILLS;
    private javax.swing.JButton DPRODUCT;
    private javax.swing.JButton EXIT;
    private javax.swing.JButton HOME;
    private javax.swing.JButton SETTING;
    private javax.swing.JButton TRASH;
    private javax.swing.JButton USER;
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private javax.swing.JButton add2;
    private javax.swing.JButton add3;
    private javax.swing.JButton cpu;
    private javax.swing.JButton delete;
    private javax.swing.JButton delete1;
    private javax.swing.JButton delete2;
    private javax.swing.JButton delete3;
    private javax.swing.JButton harddisk;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton keyboard;
    private javax.swing.JButton laptop;
    private javax.swing.JButton monitor;
    private javax.swing.JButton motherboard;
    private javax.swing.JButton mouse;
    private javax.swing.JButton printer;
    private javax.swing.JButton projector;
    private javax.swing.JButton ram;
    private javax.swing.JButton reset;
    private javax.swing.JButton reset1;
    private javax.swing.JButton reset2;
    private javax.swing.JButton reset3;
    private javax.swing.JButton router;
    private javax.swing.JButton server;
    private javax.swing.JButton update;
    private javax.swing.JButton update1;
    private javax.swing.JButton update2;
    private javax.swing.JButton update3;
    // End of variables declaration//GEN-END:variables
}
