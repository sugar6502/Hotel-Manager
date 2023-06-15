/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hotelmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Admins
 */
public final class Menu extends javax.swing.JFrame {
    private final String pattern = "MM/dd/yyyy";  //set định dạng ngày tháng năm
    private final DateFormat df = new SimpleDateFormat(pattern);
    
    private final Source_code model = new Source_code();

    private List<Integer> SoPhongDaChoThue;
    private List<String> DinhDanh_PhongThue;
    private DefaultTableModel tb_RoomInfo_temp;
    

    public Menu() {
        initComponents();
        restart();
        int quyen = Source_code.getChucVu();
        if (quyen == 1){
            btn_Admin.setVisible(true);
            btn_CheckOUT1.setVisible(true);} // Phân quyền Admin
        else {
            btn_Admin.setVisible(false);
            btn_CheckOUT1.setVisible(false);} // Phân quyền nhân viên thu ngân

        LoadComboBoxThongTinPhong();
 
    }
    //--------------------------------------------------------------
       //Hàm reset lại dữ liệu
    public void restart(){

        SoPhongDaChoThue = model.LayMaPhongDaChoThue();

        DinhDanh_PhongThue = new ArrayList<>();
        DefaultTableModel tmodel = (DefaultTableModel) tb_RoomInfo.getModel();
        tmodel.setRowCount(0);
        Connection con = model.GetCon();
        
        String sql = "EXEC LayThongTinPhongDaChoThue ?";
        for(int sophong : SoPhongDaChoThue) {
            String row[] = new String[4];
         try{
                PreparedStatement pres = con.prepareStatement(sql);
                pres.setInt(1,sophong);
                ResultSet rs = pres.executeQuery();
                while(rs.next()){
                   row[0] = Integer.toString(tmodel.getRowCount()+1);
                   row[1] = Integer.toString(sophong);
                   row[2] = rs.getString(1);
                   row[3] = df.format(rs.getDate(2));
                   
                   DinhDanh_PhongThue.add(rs.getString(3));

                   tmodel.addRow(row);
                }
            }
            catch(SQLException e) {JOptionPane.showMessageDialog(null,"Lỗi");}
        }
        tb_RoomInfo_temp = (DefaultTableModel) tb_RoomInfo.getModel();
        
        LoadTable();
    
    
    }
    
    //--------------------------------------------------------------
    //Hàm lấy tất cả các phòng trong cơ sở dữ liệu
    public void LoadTable(){
       try{
            ResultSet rs = model.LayPhongVaLoaiPhong();
            DefaultTableModel tb_Room1_model = (DefaultTableModel) tb_Room1.getModel();
            tb_Room1_model.setRowCount(0);
            int col1 = 1;
            String col2, col3, col4, col5;
            while(rs.next()){
                col2 = rs.getString(1);
                col3 = rs.getString(2);
                col4 = rs.getString(3);
                col5 = rs.getString(4);
                String[] row = {Integer.toString(col1), col2, col3, col4, col5};
                tb_Room1_model.addRow(row);
                col1++;
            }
          }
       catch(SQLException e){System.out.print(e);}
    }
    
    //--------------------------------------------------------------
    //Hàm lấy loại phòng đưa vào comboBox
    public void LoadComboBoxThongTinPhong(){
        List<String> tenLoaiPhong = new ArrayList<>();
        try{//Lấy tất cả loại phòng trong csdl load lên combobox comb_ThongTinPhong
            ResultSet rs_LP = model.LayLoaiPhong();
            while(rs_LP.next()) tenLoaiPhong.add(rs_LP.getString(2));
            
        }
        catch(SQLException e){System.out.print(e);}
        //Thêm loại phòng vào combo box
        comb_ThongTinPhong.setModel(new javax.swing.DefaultComboBoxModel<>(tenLoaiPhong.toArray(String[]::new)));
    }
    //--------------------------------------------------------------
    // Hàm lọc theo loại phòng
    public void LocTheoLoaiPhong(String loaiphong){
        try{//Lấy các tất cả các phòng trong cơ sở dữ liệu theo loại được chỉ định và load lên table tb_Room1
            ResultSet rs = model.LayPhongVaLoaiPhong(loaiphong);
            DefaultTableModel tb_Room1_model = (DefaultTableModel) tb_Room1.getModel();
            int col1 = 1;
            String col2, col3, col4, col5;
            while(rs.next()){
                col2 = rs.getString(1);
                col3 = rs.getString(2);
                col4 = rs.getString(3);
                col5 = rs.getString(4);
                String[] row = {Integer.toString(col1), col2, col3, col4, col5};
                tb_Room1_model.addRow(row);
                col1++;
            }
          }
       catch(SQLException e){System.out.print(e);}
    }
    
    //--------------------------------------------------------------
    
    //Hàm tìm phòng cho thuê
    
    public void GetTable(String find,int yc){
        DefaultTableModel tb_RoomInfo_model = tb_RoomInfo_temp;
        List <Integer> index = new ArrayList<>();
        if(tb_RoomInfo.getRowCount()==0) return;
        for(int i=0;i<tb_RoomInfo.getRowCount();i++) {
            String s1 = (String) tb_RoomInfo.getValueAt(i, yc+1);
            if(s1.equals(find)) ;  
            else index.add(i);
        }
        if(index.isEmpty()) return;
        int t = 0;
        for(int i: index) {
            tb_RoomInfo_model.removeRow(i-t);
            t++;
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

        pn_Name = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_Back = new javax.swing.JButton();
        pn_Main = new javax.swing.JPanel();
        btn_CheckIN = new javax.swing.JButton();
        btn_CheckOUT = new javax.swing.JButton();
        btn_CheckOUT1 = new javax.swing.JButton();
        btn_Admin = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabpn_PhongThue = new javax.swing.JPanel();
        comb_ThongTin = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_RoomInfo = new javax.swing.JTable();
        txb_TimKiem = new javax.swing.JTextField();
        btn_Find = new javax.swing.JButton();
        tabpn_Phong = new javax.swing.JPanel();
        Scrollpn_Phong1 = new javax.swing.JScrollPane();
        tb_Room1 = new javax.swing.JTable();
        comb_ThongTinPhong = new javax.swing.JComboBox<>();
        btn_Filter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Màn hình chính");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 204, 204));
        setLocation(new java.awt.Point(0, 0));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setName("fMenu"); // NOI18N
        setResizable(false);

        pn_Name.setBackground(new java.awt.Color(255, 153, 153));

        jLabel1.setFont(new java.awt.Font("SVN-Nexa Rush Handmade Extended", 0, 24)); // NOI18N
        jLabel1.setText("KHÁCH SẠN ");

        jLabel2.setFont(new java.awt.Font("SVN-Nexa Rush Handmade Extended", 0, 36)); // NOI18N
        jLabel2.setText("PHÙ HỢP TIÊU CHUẨN CỘNG ĐỒNG");

        btn_Back.setBackground(new java.awt.Color(252, 204, 204));
        btn_Back.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        btn_Back.setIcon(new javax.swing.ImageIcon("D:\\Hotel_Manager\\HotelManager\\src\\main\\java\\Icon\\352020_arrow_back_icon.png")); // NOI18N
        btn_Back.setBorder(null);
        btn_Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_BackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn_NameLayout = new javax.swing.GroupLayout(pn_Name);
        pn_Name.setLayout(pn_NameLayout);
        pn_NameLayout.setHorizontalGroup(
            pn_NameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_NameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_NameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Back)
                .addContainerGap())
        );
        pn_NameLayout.setVerticalGroup(
            pn_NameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_NameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_NameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Back)
                    .addGroup(pn_NameLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pn_Main.setBackground(new java.awt.Color(255, 204, 204));

        btn_CheckIN.setBackground(new java.awt.Color(255, 204, 204));
        btn_CheckIN.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_CheckIN.setIcon(new javax.swing.ImageIcon("D:\\Hotel_Manager\\HotelManager\\src\\main\\java\\Icon\\2931188_door_enter_exit_leave_out_icon.png")); // NOI18N
        btn_CheckIN.setText("Nhận phòng");
        btn_CheckIN.setBorder(null);
        btn_CheckIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CheckINMouseClicked(evt);
            }
        });
        btn_CheckIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CheckINActionPerformed(evt);
            }
        });

        btn_CheckOUT.setBackground(new java.awt.Color(255, 204, 204));
        btn_CheckOUT.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_CheckOUT.setIcon(new javax.swing.ImageIcon("D:\\Hotel_Manager\\HotelManager\\src\\main\\java\\Icon\\2931187_door_enter_exit_in_leave_icon.png")); // NOI18N
        btn_CheckOUT.setText(" Trả phòng");
        btn_CheckOUT.setBorder(null);
        btn_CheckOUT.setEnabled(false);
        btn_CheckOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CheckOUTActionPerformed(evt);
            }
        });

        btn_CheckOUT1.setBackground(new java.awt.Color(255, 204, 204));
        btn_CheckOUT1.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_CheckOUT1.setIcon(new javax.swing.ImageIcon("D:\\Hotel_Manager\\HotelManager\\src\\main\\java\\Icon\\3586362_checklist_document_list_paper_icon.png")); // NOI18N
        btn_CheckOUT1.setText("Báo cáo");
        btn_CheckOUT1.setBorder(null);
        btn_CheckOUT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CheckOUT1ActionPerformed(evt);
            }
        });

        btn_Admin.setBackground(new java.awt.Color(255, 204, 204));
        btn_Admin.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_Admin.setIcon(new javax.swing.ImageIcon("D:\\Hotel_Manager\\HotelManager\\src\\main\\java\\Icon\\2203549_admin_avatar_human_login_user_icon.png")); // NOI18N
        btn_Admin.setBorder(null);
        btn_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdminActionPerformed(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(242, 102, 102));
        jTabbedPane1.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 24)); // NOI18N

        tabpn_PhongThue.setBackground(new java.awt.Color(252, 204, 204));

        comb_ThongTin.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        String[] filter = {"Phòng", "Tên khách", "Thời gian thuê"};
        comb_ThongTin.setModel(new javax.swing.DefaultComboBoxModel<>(filter));
        comb_ThongTin.setBorder(null);

        tb_RoomInfo.setBackground(new java.awt.Color(255, 204, 204));
        tb_RoomInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tb_RoomInfo.setFont(new java.awt.Font("SVN-Nexa Light", 0, 14)); // NOI18N
        tb_RoomInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Phòng", "Tên khách", "Thời gian thuê"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_RoomInfo.setGridColor(new java.awt.Color(0, 0, 0));
        tb_RoomInfo.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tb_RoomInfo.setShowGrid(false);
        tb_RoomInfo.setShowHorizontalLines(true);
        tb_RoomInfo.setShowVerticalLines(true);
        tb_RoomInfo.getTableHeader().setReorderingAllowed(false);
        tb_RoomInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_RoomInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_RoomInfo);
        if (tb_RoomInfo.getColumnModel().getColumnCount() > 0) {
            tb_RoomInfo.getColumnModel().getColumn(0).setResizable(false);
            tb_RoomInfo.getColumnModel().getColumn(1).setResizable(false);
            tb_RoomInfo.getColumnModel().getColumn(2).setResizable(false);
            tb_RoomInfo.getColumnModel().getColumn(3).setResizable(false);
        }

        txb_TimKiem.setFont(new java.awt.Font("SVN-Nexa Light", 0, 24)); // NOI18N
        txb_TimKiem.setBorder(null);

        btn_Find.setBackground(new java.awt.Color(255, 204, 204));
        btn_Find.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        btn_Find.setIcon(new javax.swing.ImageIcon("D:\\Hotel_Manager\\HotelManager\\src\\main\\java\\Icon\\172546_search_icon.png")); // NOI18N
        btn_Find.setBorder(null);
        btn_Find.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_FindMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tabpn_PhongThueLayout = new javax.swing.GroupLayout(tabpn_PhongThue);
        tabpn_PhongThue.setLayout(tabpn_PhongThueLayout);
        tabpn_PhongThueLayout.setHorizontalGroup(
            tabpn_PhongThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabpn_PhongThueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txb_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comb_ThongTin, 0, 199, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Find)
                .addContainerGap())
            .addGroup(tabpn_PhongThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tabpn_PhongThueLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        tabpn_PhongThueLayout.setVerticalGroup(
            tabpn_PhongThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpn_PhongThueLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(tabpn_PhongThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txb_TimKiem)
                    .addComponent(btn_Find, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comb_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 527, Short.MAX_VALUE))
            .addGroup(tabpn_PhongThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabpn_PhongThueLayout.createSequentialGroup()
                    .addContainerGap(79, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Phòng cho thuê", tabpn_PhongThue);

        tabpn_Phong.setBackground(new java.awt.Color(255, 204, 204));

        tb_Room1.setBackground(new java.awt.Color(255, 204, 204));
        tb_Room1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tb_Room1.setFont(new java.awt.Font("SVN-Nexa Light", 0, 14)); // NOI18N
        tb_Room1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Loại phòng", "Phòng", "Sức chứa", "Tình trạng", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Room1.setGridColor(new java.awt.Color(0, 0, 0));
        tb_Room1.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tb_Room1.setShowGrid(false);
        tb_Room1.setShowHorizontalLines(true);
        tb_Room1.setShowVerticalLines(true);
        tb_Room1.getTableHeader().setReorderingAllowed(false);
        Scrollpn_Phong1.setViewportView(tb_Room1);
        if (tb_Room1.getColumnModel().getColumnCount() > 0) {
            tb_Room1.getColumnModel().getColumn(0).setResizable(false);
            tb_Room1.getColumnModel().getColumn(1).setResizable(false);
            tb_Room1.getColumnModel().getColumn(2).setResizable(false);
            tb_Room1.getColumnModel().getColumn(3).setResizable(false);
        }

        comb_ThongTinPhong.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N

        btn_Filter.setBackground(new java.awt.Color(255, 204, 204));
        btn_Filter.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        btn_Filter.setIcon(new javax.swing.ImageIcon("D:\\Hotel_Manager\\HotelManager\\src\\main\\java\\Icon\\172546_search_icon.png")); // NOI18N
        btn_Filter.setBorder(null);
        btn_Filter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_FilterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tabpn_PhongLayout = new javax.swing.GroupLayout(tabpn_Phong);
        tabpn_Phong.setLayout(tabpn_PhongLayout);
        tabpn_PhongLayout.setHorizontalGroup(
            tabpn_PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpn_PhongLayout.createSequentialGroup()
                .addComponent(Scrollpn_Phong1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(tabpn_PhongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comb_ThongTinPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Filter)
                .addGap(142, 142, 142))
        );
        tabpn_PhongLayout.setVerticalGroup(
            tabpn_PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabpn_PhongLayout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(tabpn_PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Filter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comb_ThongTinPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Scrollpn_Phong1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Phòng", tabpn_Phong);

        javax.swing.GroupLayout pn_MainLayout = new javax.swing.GroupLayout(pn_Main);
        pn_Main.setLayout(pn_MainLayout);
        pn_MainLayout.setHorizontalGroup(
            pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_MainLayout.createSequentialGroup()
                .addGroup(pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_MainLayout.createSequentialGroup()
                        .addContainerGap(103, Short.MAX_VALUE)
                        .addGroup(pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_CheckIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_CheckOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_CheckOUT1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(pn_MainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        pn_MainLayout.setVerticalGroup(
            pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btn_CheckIN, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btn_CheckOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btn_CheckOUT1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_MainLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CheckINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CheckINMouseClicked
        // Click chuột nút Nhận phòng
        new CheckIn().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btn_CheckINMouseClicked

       
    private void btn_FilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_FilterMouseClicked
        // Action khi nhấn vào Filter
        DefaultTableModel Tablemodel = (DefaultTableModel) tb_Room1.getModel();
        Tablemodel.setRowCount(0);
        LocTheoLoaiPhong(comb_ThongTinPhong.getSelectedItem().toString());
    }//GEN-LAST:event_btn_FilterMouseClicked

    //Hàm lọc theo yêu cầu
    private void btn_FindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_FindMouseClicked
            restart();
            String find = txb_TimKiem.getText();
            if(find.equals("")) restart();
            else GetTable(find,comb_ThongTin.getSelectedIndex());
           
    }//GEN-LAST:event_btn_FindMouseClicked

    //Check out
    private void btn_CheckOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CheckOUTActionPerformed
        int index = tb_RoomInfo.getSelectedRow();
        String SoPhong = (String) tb_RoomInfo.getValueAt(index, 1);
        setVisible(false);
        new CheckOUT(DinhDanh_PhongThue.get(index),Integer.parseInt(SoPhong)).setVisible(true);
    }//GEN-LAST:event_btn_CheckOUTActionPerformed

    //Vào checkin
    private void btn_CheckINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CheckINActionPerformed
        setVisible(true);
    }//GEN-LAST:event_btn_CheckINActionPerformed

    //Hàm check table để check out
    private void tb_RoomInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_RoomInfoMouseClicked
 
       if(evt.getClickCount()>=2) {
       tb_RoomInfo.clearSelection();
        btn_CheckOUT.setEnabled(false);
       }
       else {
       btn_CheckOUT.setEnabled(true);

       }

    }//GEN-LAST:event_tb_RoomInfoMouseClicked
    // Vào phần báo cáo doanh thu
    private void btn_CheckOUT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CheckOUT1ActionPerformed
        new BaoCao().setVisible(true);
    }//GEN-LAST:event_btn_CheckOUT1ActionPerformed
    
    //Vào phần admin
    private void btn_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdminActionPerformed
        new Admin().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btn_AdminActionPerformed
    
    //Đăng xuất
    private void btn_BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BackMouseClicked
        int ret = JOptionPane.showConfirmDialog(null,"Bạn có muốn đăng xuất","Đăng xuất",JOptionPane.YES_NO_OPTION);
        if(ret == JOptionPane.YES_OPTION ) {
        new Login().setVisible(true);
        this.dispose();
         }
    }//GEN-LAST:event_btn_BackMouseClicked

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
             
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scrollpn_Phong1;
    private javax.swing.JButton btn_Admin;
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_CheckIN;
    private javax.swing.JButton btn_CheckOUT;
    private javax.swing.JButton btn_CheckOUT1;
    private javax.swing.JButton btn_Filter;
    private javax.swing.JButton btn_Find;
    private javax.swing.JComboBox<String> comb_ThongTin;
    private javax.swing.JComboBox<String> comb_ThongTinPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pn_Main;
    private javax.swing.JPanel pn_Name;
    private javax.swing.JPanel tabpn_Phong;
    private javax.swing.JPanel tabpn_PhongThue;
    private javax.swing.JTable tb_Room1;
    private javax.swing.JTable tb_RoomInfo;
    private javax.swing.JTextField txb_TimKiem;
    // End of variables declaration//GEN-END:variables
}
