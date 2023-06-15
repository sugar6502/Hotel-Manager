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
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author netpr
 */
public final class CheckIn_2 extends javax.swing.JFrame {
    Source_code model = new Source_code();
    private List<Integer> MaLP;
    private List<Integer> DichVu;
    private Map<Integer,ArrayList<Integer> > map;
    private ArrayList<Integer> TempDichVu;
    private ArrayList<String> TempSoPhong;
    private String TenKH;
    private String SDT;
    private String CCCD;
    
    //Hàm reset lại dữ liệu
    public void restart() {
        map = new  HashMap();
        TempDichVu = new ArrayList<>();
        TempSoPhong = new ArrayList<>();
        MaLP = model.LayMaLoaiPhong();
        List<String> TenLoaiPhong = new ArrayList<>();
        for(int i:MaLP) {
         TenLoaiPhong.add(model.LayThuocTinhLoaiPhong(i,"TenLoaiPhong"));
         }
     
        cb_LP.setModel(new javax.swing.DefaultComboBoxModel<>(TenLoaiPhong.toArray(String[]::new)));
        DichVu = model.LayMaDichVu();
        List<String> TenDV = new ArrayList<>();
         for(int i:DichVu) {
         TenDV.add(model.LayTenDichVu(i));
         }
        cb_DichVu.setModel(new javax.swing.DefaultComboBoxModel<>(TenDV.toArray(String[]::new)));
        cb_DichVu.setEnabled(false);
    
    }
    public CheckIn_2() {
        initComponents();
        restart();
   
    }
    
    public CheckIn_2(String tenKH, String sdt, String cccd ) {
        initComponents();
        this.TenKH = tenKH;
        lb_cusname.setText(this.TenKH);
        this.SDT = sdt;
        lb_sdt.setText(this.SDT);
        this.CCCD = cccd;
        lb_cccd.setText(this.CCCD);
        restart();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_CheckIn = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lb_cusname = new javax.swing.JLabel();
        btn_Yes = new javax.swing.JButton();
        btn_No = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lb_cccd = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lb_sdt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Room = new javax.swing.JTable();
        btn_Delete = new javax.swing.JButton();
        cb_LP = new javax.swing.JComboBox<>();
        cb_Phong = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cb_DichVu = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pn_CheckIn.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("SVN-Nexa Rush Handmade Extended", 1, 48)); // NOI18N
        jLabel1.setText("CHECK IN");

        jLabel2.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        jLabel2.setText("Tên khách:");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        jLabel3.setText("Loại phòng:");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        jLabel4.setText("Phòng:");
        jLabel4.setToolTipText("");

        lb_cusname.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        lb_cusname.setText("*ten khach*");
        lb_cusname.setToolTipText("");

        btn_Yes.setBackground(new java.awt.Color(255, 204, 204));
        btn_Yes.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_Yes.setForeground(new java.awt.Color(0, 204, 0));
        btn_Yes.setIcon(new javax.swing.ImageIcon("D:\\Hotel_Manager\\HotelManager\\src\\main\\java\\Icon\\1398912_circle_correct_mark_success_tick_icon.png")); // NOI18N
        btn_Yes.setBorder(null);
        btn_Yes.setEnabled(false);
        btn_Yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_YesActionPerformed(evt);
            }
        });

        btn_No.setBackground(new java.awt.Color(255, 204, 204));
        btn_No.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_No.setForeground(new java.awt.Color(255, 0, 51));
        btn_No.setIcon(new javax.swing.ImageIcon("D:\\Hotel_Manager\\HotelManager\\src\\main\\java\\Icon\\1398917_circle_close_cross_incorrect_invalid_icon.png")); // NOI18N
        btn_No.setBorder(null);
        btn_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        jLabel7.setText("CCCD: ");
        jLabel7.setToolTipText("");

        lb_cccd.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        lb_cccd.setText("*cccd*");
        lb_cccd.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        jLabel8.setText("SĐT: ");
        jLabel8.setToolTipText("");

        lb_sdt.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        lb_sdt.setText("*sdt*");
        lb_sdt.setToolTipText("");

        tb_Room.setBackground(new java.awt.Color(255, 204, 204));
        tb_Room.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tb_Room.setFont(new java.awt.Font("SVN-Nexa Light", 0, 14)); // NOI18N
        tb_Room.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Loại phòng", "Phòng", "Dịch vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
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
        tb_Room.setGridColor(new java.awt.Color(0, 0, 0));
        tb_Room.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tb_Room.setShowGrid(false);
        tb_Room.setShowHorizontalLines(true);
        tb_Room.setShowVerticalLines(true);
        tb_Room.getTableHeader().setReorderingAllowed(false);
        tb_Room.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_RoomMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_Room);

        btn_Delete.setBackground(new java.awt.Color(255, 204, 204));
        btn_Delete.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_Delete.setForeground(new java.awt.Color(153, 0, 204));
        btn_Delete.setIcon(new javax.swing.ImageIcon("D:\\Hotel_Manager\\HotelManager\\src\\main\\java\\Icon\\3669361_delete_ic_icon.png")); // NOI18N
        btn_Delete.setToolTipText("");
        btn_Delete.setBorder(null);
        btn_Delete.setEnabled(false);
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        cb_LP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_LPActionPerformed(evt);
            }
        });

        cb_Phong.setEnabled(false);
        cb_Phong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_PhongActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        jLabel10.setText("Dịch vụ:");
        jLabel10.setToolTipText("");

        cb_DichVu.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        cb_DichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_DichVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_CheckInLayout = new javax.swing.GroupLayout(pn_CheckIn);
        pn_CheckIn.setLayout(pn_CheckInLayout);
        pn_CheckInLayout.setHorizontalGroup(
            pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_CheckInLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_CheckInLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_CheckInLayout.createSequentialGroup()
                                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_DichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cb_LP, 0, 324, Short.MAX_VALUE)
                                        .addComponent(cb_Phong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pn_CheckInLayout.createSequentialGroup()
                                    .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lb_sdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lb_cusname, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                                        .addComponent(lb_cccd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_Yes)
                                    .addComponent(btn_Delete)
                                    .addComponent(btn_No)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_CheckInLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(219, 219, 219))
        );
        pn_CheckInLayout.setVerticalGroup(
            pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_CheckInLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_cusname, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_LP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_CheckInLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(cb_Phong)))
                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pn_CheckInLayout.createSequentialGroup()
                        .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_CheckInLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_DichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pn_CheckInLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_CheckInLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Delete)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Yes)
                        .addGap(26, 26, 26)
                        .addComponent(btn_No)
                        .addGap(41, 41, 41)))
                .addGap(0, 34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_CheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_CheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btn_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NoActionPerformed
        setVisible(false);
        
    }//GEN-LAST:event_btn_NoActionPerformed

    //Hàm xử lí khi nhấn click vào table
    private void tb_RoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_RoomMouseClicked
       
       if(evt.getClickCount()>=2) {
       
       tb_Room.clearSelection();
       btn_Yes.setEnabled(true);
       cb_DichVu.setEnabled(false);
       btn_Delete.setEnabled(false);
       cb_LP.setEnabled(true);
       int sophong =Integer.parseInt((String)cb_Phong.getSelectedItem());
       if(TempDichVu.isEmpty()) TempDichVu.add(0);
   
       map.put(sophong, TempDichVu);
       TempDichVu = new ArrayList<>();
       
       }
       else{
           btn_Delete.setEnabled(true);
            cb_DichVu.setEnabled(true);
            cb_LP.setEnabled(false);
            btn_Yes.setEnabled(false);
            cb_Phong.setEnabled(false);
    
       }
    }//GEN-LAST:event_tb_RoomMouseClicked

    //Chọn loại phòng
    private void cb_LPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_LPActionPerformed
        int index = cb_LP.getSelectedIndex();
        List<String> SoPhong = new ArrayList<>();
        int malp = MaLP.get(index);
        String sql = "SELECT SoPhong FROM PHONG WHERE MaLoaiPhong=? and TinhTrang = 0";
        Connection con = model.GetCon();
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setInt(1,malp);
            ResultSet rs = pres.executeQuery();
            while(rs.next()){
                SoPhong.add(rs.getString(1));
            }
        }
        catch(SQLException e) {JOptionPane.showMessageDialog(null,"Lỗi");}
        SoPhong.removeAll(TempSoPhong);
        cb_Phong.setModel(new javax.swing.DefaultComboBoxModel<>(SoPhong.toArray(String[]::new)));
        cb_Phong.setEnabled(true);
       
        
    }//GEN-LAST:event_cb_LPActionPerformed
    //Chọn phòng muốn đặt
    private void cb_PhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_PhongActionPerformed
        int index = cb_LP.getSelectedIndex();
        DefaultTableModel tmodel = (DefaultTableModel) tb_Room.getModel();
        int sophong =Integer.parseInt((String)cb_Phong.getSelectedItem());
        TempSoPhong.add(Integer.toString(sophong));
        int malp = MaLP.get(index);
        String row[] = new String[5];
        row[0] = Integer.toString(tmodel.getRowCount()+1);
        row[1] = model.LayThuocTinhLoaiPhong(malp,"TenLoaiPhong");
        row[2] = Integer.toString(sophong);
        row[3] = "";
        tmodel.addRow(row);
        cb_Phong.setEnabled(false);
        btn_Yes.setEnabled(true);
        map.put(sophong, TempDichVu);
        
        
        
    }//GEN-LAST:event_cb_PhongActionPerformed
    //Đưa dịch vụ từ combobox vào table
    private void cb_DichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_DichVuActionPerformed
        int index = cb_DichVu.getSelectedIndex();
        int index_table = tb_Room.getSelectedRow();
        String DichVu1 = (String) tb_Room.getValueAt(index_table, 3);   
        String t =" ";
        if(DichVu1 == "") t=" ";
        DichVu1 = DichVu1 + (String)cb_DichVu.getSelectedItem() + t;
        tb_Room.setValueAt(DichVu1,index_table, 3);
        TempDichVu.add(DichVu.get(index));
       

    }//GEN-LAST:event_cb_DichVuActionPerformed
   
    //Hàm xóa phòng đã chọn trong table
    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
      int sophong = Integer.parseInt((String)cb_Phong.getSelectedItem());
      DefaultTableModel Tablemodel = (DefaultTableModel) tb_Room.getModel();
      Tablemodel.removeRow(tb_Room.getSelectedRow());
      map.remove(sophong);
      btn_Yes.setEnabled(true);
    }//GEN-LAST:event_btn_DeleteActionPerformed

    //Khi nhấn yes thì bắt đầu đẩy dữ liệu vào sql
    private void btn_YesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_YesActionPerformed
        int ret = JOptionPane.showConfirmDialog(null,"Bạn có muốn lưu","lưu dữ liệu",JOptionPane.YES_NO_OPTION);
        if(ret == JOptionPane.NO_OPTION) return;
        String sql ="EXEC ThemPhieuThuePhong ? ";
        String sql2= "EXEC ThemPhieuThanhToan ? ";
        String sql4= "EXEC ThemKhachHang ?,?,?";
        Connection con = model.GetCon();
           // System.out.println(map);
           try{
            PreparedStatement pres2 = con.prepareStatement(sql4);   
            pres2.setString(1,this.TenKH);
            pres2.setString(2,this.CCCD);
            pres2.setString(3,this.SDT);
            pres2.executeUpdate();
           }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, e);}
           
        
        /// Them KhachHang truoc
    
       
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            PreparedStatement pres1 = con.prepareStatement(sql2);
            
            pres.setString(1,this.CCCD);       
            pres.executeUpdate();  
            pres1.setString(1,this.CCCD);
            pres1.executeUpdate();
           
            }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, e);}
        List<Integer> ds = model.LaySoPhieuThuePhong();
        List<Integer> ds_tt = model.LaySoPhieuThanhToan();
        int SoPhieu_last = ds.get(ds.size()-1);
        int SoPhieuTT_last = ds_tt.get(ds_tt.size()-1);
        String sql1 = "EXEC ThemChiTietPhieuThuePhong ?,?,?";
        String sql3 = "EXEC ThemChiTietPTT  ?,?,?";
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            String sql5 = "UPDATE PHONG SET TinhTrang = 1 WHERE SoPhong=?";
            try{
            PreparedStatement pres5 = con.prepareStatement(sql5);
            pres5.setInt(1,key);
            pres5.executeUpdate();
            }     
            catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi");}
               
      
            ArrayList<Integer> dv = map.get(key);
            if (dv.isEmpty()) dv.add(0);
            //System.out.println(dv);
            for(Integer i : dv) {
                try{
           
                 
                PreparedStatement pres = con.prepareStatement(sql1);
                PreparedStatement pres1 = con.prepareStatement(sql3);
                pres.setInt(1,SoPhieu_last);
                pres1.setInt(1,SoPhieuTT_last);   
                pres.setInt(2,key);
                 pres1.setInt(2,key); 
                if(i==0) {
                    pres.setNull(3, 0);
                    pres1.setNull(3, 0);
                }
                else {
                    pres.setInt(3,i);
                    pres1.setInt(3, i);
                } 
                pres.executeUpdate();
                pres1.executeUpdate();
                }
                catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi");}
            }
        }
       setVisible(false);
       new Menu().setVisible(true);
    }//GEN-LAST:event_btn_YesActionPerformed

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
            java.util.logging.Logger.getLogger(CheckIn_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckIn_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckIn_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckIn_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new CheckIn_2().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_No;
    private javax.swing.JButton btn_Yes;
    private javax.swing.JComboBox<String> cb_DichVu;
    private javax.swing.JComboBox<String> cb_LP;
    private javax.swing.JComboBox<String> cb_Phong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_cccd;
    private javax.swing.JLabel lb_cusname;
    private javax.swing.JLabel lb_sdt;
    private javax.swing.JPanel pn_CheckIn;
    private javax.swing.JTable tb_Room;
    // End of variables declaration//GEN-END:variables
}
