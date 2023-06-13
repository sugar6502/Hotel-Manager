/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hotelmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Admins
 */
public class Menu extends javax.swing.JFrame {

    Source_code model = new Source_code();
    
    int temp = 0;
    
    public Menu() {
        initComponents();
        Global chucvu = new Global();
        int quyen = chucvu.getChucVu();
        if (quyen == 1){btn_Admin.setVisible(true);} // Phân quyền Admin
        else {btn_Admin.setVisible(false);} // Phân quyền nhân viên thu ngân
        LoadTable();
        LoadComboBoxThongTinPhong();
        LoadRoomInfo();
    }
    
    public void LoadTable(){
       try{//Lấy các tất cả các phòng trong cơ sở dữ liệu và load lên table tb_Room1
            ResultSet rs = model.LayPhongVaLoaiPhong();
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
       catch(SQLException e){System.out.print(e);};
    }
    
    public void LoadComboBoxThongTinPhong(){
        List<String> tenLoaiPhong = new ArrayList<String>();
        try{//Lấy tất cả loại phòng trong csdl load lên combobox comb_ThongTinPhong
        ResultSet rs_LP = model.LayLoaiPhong();
        while(rs_LP.next())
        tenLoaiPhong.add(rs_LP.getString(2));
        }
        catch(SQLException e){System.out.print(e);};
        //Thêm loại phòng vào combo box
        comb_ThongTinPhong.setModel(new javax.swing.DefaultComboBoxModel<>(tenLoaiPhong.toArray(String[]::new)));
    }
    
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
       catch(SQLException e){System.out.print(e);};
    }
    
    public void LoadRoomInfo(){
        try{//Lấy  tất cả phòng hiện đang cho thuê từ CSDL load lên table tb_Roominfo
            ResultSet rs = model.LayPhongDangChoThue();
             DefaultTableModel tb_RoomInfo_model = (DefaultTableModel) tb_RoomInfo.getModel();

            int col1 = 1;
            String col2, col3, col4, col5;
            while(rs.next()){
                col2 = rs.getString(1);
                col3 = rs.getString(2);
                col4 = rs.getString(3);
                col5 = rs.getString(4);
                String[] row = {Integer.toString(col1), col2, col3, col4, col5};
                tb_RoomInfo_model.addRow(row);
                col1++;
            }
          }
       catch(SQLException e){System.out.print(e);};
    }
    
    public void TimPhongChoThue(){
        try{
            ResultSet rs = null;
            DefaultTableModel tb_RoomInfo_model = (DefaultTableModel) tb_RoomInfo.getModel();
            tb_RoomInfo_model.setRowCount(0);

            if(comb_ThongTin.getSelectedIndex() == 0)//Search theo số phòng
                rs = model.LayPhongDangChoThueTheoSoPhong(txb_TimKiem.getText().toString());
            else if(comb_ThongTin.getSelectedIndex() == 1)//Search theo tên khách
                rs = model.LayPhongDangChoThueTheoTenKhach(txb_TimKiem.getText().toString());
            else//Search theo ngày thuê
                rs = model.LayPhongDangChoThueTheoNgay(txb_TimKiem.getText().toString());
                
            int col1 = 1;
            String col2, col3, col4, col5;
            while(rs.next()){
                col2 = rs.getString(1);
                col3 = rs.getString(2);
                col4 = rs.getString(3);
                col5 = rs.getString(4);
                String[] row = {Integer.toString(col1), col2, col3, col4, col5};
                tb_RoomInfo_model.addRow(row);
                col1++;
            }
        }
       catch(SQLException e){System.out.print(e);};
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

        javax.swing.GroupLayout pn_NameLayout = new javax.swing.GroupLayout(pn_Name);
        pn_Name.setLayout(pn_NameLayout);
        pn_NameLayout.setHorizontalGroup(
            pn_NameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_NameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_NameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_NameLayout.setVerticalGroup(
            pn_NameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_NameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pn_Main.setBackground(new java.awt.Color(255, 204, 204));

        btn_CheckIN.setBackground(new java.awt.Color(255, 204, 204));
        btn_CheckIN.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_CheckIN.setText("Nhận phòng");
        btn_CheckIN.setBorder(null);
        btn_CheckIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CheckINMouseClicked(evt);
            }
        });

        btn_CheckOUT.setBackground(new java.awt.Color(255, 204, 204));
        btn_CheckOUT.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_CheckOUT.setText(" Trả phòng");
        btn_CheckOUT.setBorder(null);

        btn_CheckOUT1.setBackground(new java.awt.Color(255, 204, 204));
        btn_CheckOUT1.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_CheckOUT1.setText("Báo cáo");
        btn_CheckOUT1.setBorder(null);

        btn_Admin.setBackground(new java.awt.Color(255, 204, 204));
        btn_Admin.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_Admin.setText("AD");
        btn_Admin.setBorder(null);

        jTabbedPane1.setBackground(new java.awt.Color(242, 102, 102));
        jTabbedPane1.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 24)); // NOI18N

        tabpn_PhongThue.setBackground(new java.awt.Color(252, 204, 204));

        comb_ThongTin.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        String[] filter = {"Phòng", "Tên khách", "Thời gian thuê"};
        comb_ThongTin.setModel(new javax.swing.DefaultComboBoxModel<>(filter));
        comb_ThongTin.setBorder(null);

        tb_RoomInfo.setBackground(new java.awt.Color(255, 204, 204));
        tb_RoomInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tb_RoomInfo.setFont(new java.awt.Font("SVN-Nexa Light", 0, 12)); // NOI18N
        tb_RoomInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Phòng", "Tên khách", "Thời gian thuê", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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
        btn_Find.setText("T");
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
                .addComponent(txb_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comb_ThongTin, 0, 152, Short.MAX_VALUE)
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
                .addGap(0, 524, Short.MAX_VALUE))
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
        tb_Room1.setFont(new java.awt.Font("SVN-Nexa Light", 0, 12)); // NOI18N
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
        btn_Filter.setText("T");
        btn_Filter.setBorder(null);
        btn_Filter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_FilterMouseClicked(evt);
            }
        });
        btn_Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FilterActionPerformed(evt);
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
                .addGap(0, 7, Short.MAX_VALUE)
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
    }//GEN-LAST:event_btn_CheckINMouseClicked

    private void btn_FilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_FilterActionPerformed

    private void btn_FilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_FilterMouseClicked
        // TODO add your handling code here:
        LocTheoLoaiPhong(comb_ThongTinPhong.getSelectedItem().toString());
    }//GEN-LAST:event_btn_FilterMouseClicked

    private void btn_FindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_FindMouseClicked
        // TODO add your handling code here:
        if(txb_TimKiem.getText().isEmpty())
            LoadRoomInfo();//Nếu ô tìm kiếm trống thì cho hiện lại tất cả phòng đang cho thuê
        else
            TimPhongChoThue();
    }//GEN-LAST:event_btn_FindMouseClicked

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
