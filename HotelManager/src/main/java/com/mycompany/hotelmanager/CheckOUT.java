/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hotelmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author netpr
 */
public class CheckOUT extends javax.swing.JFrame {

    /**
     * Creates new form CheckOUT
     */
   Source_code model = new Source_code();

    private int SoPhong;
    private int SoNgayThue=1;
    private int TongTien = 0;
    private List<Integer> MaDV; 
    
    public CheckOUT(String dinhdanh,int sophong) {
        MaDV= new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
        Date date = new Date();  
        initComponents();
        this.SoPhong = sophong;
        txb_CusName.setText(model.LayThuocTinhKH(dinhdanh, "TenKH"));
        txb_CCCD.setText(dinhdanh);
        txb_SDT.setText(model.LayThuocTinhKH(dinhdanh, "SoDT"));
        txb_NgayTra.setText(formatter.format(date));
        Connection con = model.GetCon();
        String row[] = new String[5];
        DefaultTableModel tmodel = (DefaultTableModel) tb_Room.getModel();
        String sql = "EXEC LayThongTinPhongDaChoThue ?";
         String sql1 = "EXEC LayThongTinDichVuCuaPhong ?";
        int ThanhTien = 0;
    
            try{
            PreparedStatement pres = con.prepareStatement(sql);
            PreparedStatement pres1 = con.prepareStatement(sql1);
            pres.setInt(1,sophong);
            pres1.setInt(1,sophong);
            ResultSet rs = pres.executeQuery();
            ResultSet rs1 = pres1.executeQuery();
            rs.next();
            row[0] = rs.getString(5);
            row[1] = Integer.toString(sophong);
            row[2] = Integer.toString(rs.getInt(4));
            txb_NgayNhan.setText(formatter.format(rs.getDate(2)));
            
            this.SoNgayThue=date.compareTo(rs.getDate(2));
            
            row[3] ="";
            while(rs1.next()) {
            row[3] += rs1.getString(1) +" ";
            ThanhTien += rs1.getInt(2);
            MaDV.add(rs1.getInt(3));
            }
            row[4] = Integer.toString(ThanhTien);  
             
              
            tmodel.addRow(row);
            TongTien = ThanhTien+rs.getInt(4)*this.SoNgayThue;
            txb_TotalMoney.setText(Integer.toString(ThanhTien+rs.getInt(4)*this.SoNgayThue));
            
            
        }
        catch(SQLException e) {JOptionPane.showMessageDialog(null,"Lỗi");} 
    }
    public CheckOUT() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txb_CusName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txb_NgayNhan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txb_NgayTra = new javax.swing.JTextField();
        txb_CCCD = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txb_TotalMoney = new javax.swing.JTextField();
        btn_Yes = new javax.swing.JButton();
        btn_No = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Room = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txb_SDT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("SVN-Nexa Rush Handmade Extended", 1, 48)); // NOI18N
        jLabel1.setText("CHECK OUT");

        jLabel2.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        jLabel2.setText("Tên khách:");
        jLabel2.setToolTipText("");

        txb_CusName.setEditable(false);
        txb_CusName.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N

        jLabel5.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        jLabel5.setText("CCCD: ");
        jLabel5.setToolTipText("");

        txb_NgayNhan.setEditable(false);
        txb_NgayNhan.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N

        jLabel6.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        jLabel6.setText("Ngày nhận:");
        jLabel6.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        jLabel7.setText("Tổng tiền:");
        jLabel7.setToolTipText("");

        txb_NgayTra.setEditable(false);
        txb_NgayTra.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N

        txb_CCCD.setEditable(false);
        txb_CCCD.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N

        jLabel8.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        jLabel8.setText("Ngày trả:");
        jLabel8.setToolTipText("");

        txb_TotalMoney.setEditable(false);
        txb_TotalMoney.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N

        btn_Yes.setBackground(new java.awt.Color(255, 204, 204));
        btn_Yes.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_Yes.setForeground(new java.awt.Color(0, 204, 0));
        btn_Yes.setIcon(new javax.swing.ImageIcon("D:\\Hotel_Manager\\HotelManager\\src\\main\\java\\Icon\\1398912_circle_correct_mark_success_tick_icon.png")); // NOI18N
        btn_Yes.setText("Xác nhận");
        btn_Yes.setBorder(null);
        btn_Yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_YesActionPerformed(evt);
            }
        });

        btn_No.setBackground(new java.awt.Color(255, 204, 204));
        btn_No.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_No.setForeground(new java.awt.Color(255, 0, 51));
        btn_No.setIcon(new javax.swing.ImageIcon("D:\\Hotel_Manager\\HotelManager\\src\\main\\java\\Icon\\1398917_circle_close_cross_incorrect_invalid_icon.png")); // NOI18N
        btn_No.setText("HỦy");
        btn_No.setBorder(null);
        btn_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NoActionPerformed(evt);
            }
        });

        tb_Room.setBackground(new java.awt.Color(255, 204, 204));
        tb_Room.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tb_Room.setFont(new java.awt.Font("SVN-Nexa Light", 0, 14)); // NOI18N
        tb_Room.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Loại phòng", "Phòng", "Đơn giá", "Dịch vụ", "Tổng dịch vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Long.class, java.lang.Object.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Room.setGridColor(new java.awt.Color(0, 0, 0));
        tb_Room.setRowSelectionAllowed(false);
        tb_Room.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tb_Room.setShowGrid(false);
        tb_Room.setShowHorizontalLines(true);
        tb_Room.setShowVerticalLines(true);
        tb_Room.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tb_Room);

        jLabel9.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        jLabel9.setText("SĐT: ");
        jLabel9.setToolTipText("");

        txb_SDT.setEditable(false);
        txb_SDT.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txb_CusName, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txb_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txb_NgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 3, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txb_NgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txb_TotalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_Yes)
                                .addGap(96, 96, 96)
                                .addComponent(btn_No)
                                .addGap(303, 303, 303)))))
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(409, 409, 409))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txb_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_CusName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_NgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_NgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_TotalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Yes)
                    .addComponent(btn_No))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NoActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btn_NoActionPerformed

    //Đẩy dữ liệu khi nhấn yes
    private void btn_YesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_YesActionPerformed
        int ret = JOptionPane.showConfirmDialog(null,"Bạn có muốn lưu","lưu dữ liệu",JOptionPane.YES_NO_OPTION);
        if(ret == JOptionPane.NO_OPTION) return;
        String sql = "EXEC CapNhapPhieuThanhToan ?,?,?";
        String sql1 = "EXEC CapNhatBaoCao ?,?";
        Connection con = model.GetCon();
        if (MaDV.isEmpty()) MaDV.add(-1);
            for(int madv : MaDV) {
                try{
                        PreparedStatement pres = con.prepareStatement(sql);
                        PreparedStatement pres1 = con.prepareStatement(sql1);
                        pres.setInt(1,this.SoPhong);
                        if(madv == -1 ) pres.setNull(2,0);
                        else pres.setInt(2,madv);
                        pres.setInt(3,this.SoNgayThue);
                        pres.executeUpdate();
                        pres1.setInt(1,this.SoPhong);
                        pres1.setInt(2,TongTien);
                        pres1.executeUpdate();
                    }
                    catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi");}
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
            java.util.logging.Logger.getLogger(CheckOUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckOUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckOUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckOUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CheckOUT().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_No;
    private javax.swing.JButton btn_Yes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_Room;
    private javax.swing.JTextField txb_CCCD;
    private javax.swing.JTextField txb_CusName;
    private javax.swing.JTextField txb_NgayNhan;
    private javax.swing.JTextField txb_NgayTra;
    private javax.swing.JTextField txb_SDT;
    private javax.swing.JTextField txb_TotalMoney;
    // End of variables declaration//GEN-END:variables
}
