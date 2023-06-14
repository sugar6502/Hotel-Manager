/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hotelmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admins
 */
public class Worker extends javax.swing.JFrame {

    /**
     * Creates new form Worker
     */
    private final Source_code model = new Source_code();
    private final List<Integer> ChucVu = model.LayMaChucVu();
    private int Active = 0; 
    private int MaNV = -1;
    
    public Worker() {
        initComponents();
         List<String> TenChucVu = new ArrayList<>();
         for(int i:ChucVu) {
         TenChucVu.add(model.LayTenChucVu(i));
         }
        combob_ChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(TenChucVu.toArray(String[]::new)));
        
    }
    
    public Worker(String s,String TenCV,String s1,String s2,int MaNV) {
        initComponents();
        Active=1;
        txb_TenNV.setText(s);
        List<String> TenChucVu = new ArrayList<>();
        for(int i:ChucVu) {
            TenChucVu.add(model.LayTenChucVu(i));
        }
        combob_ChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(TenChucVu.toArray(String[]::new)));
        combob_ChucVu.setSelectedItem(TenCV);
        txb_CCCD.setText(s1);
        txb_DiaChi.setText(s2);
        this.MaNV = MaNV;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txb_TenNV = new javax.swing.JTextField();
        txb_CCCD = new javax.swing.JTextField();
        txb_DiaChi = new javax.swing.JTextField();
        combob_ChucVu = new javax.swing.JComboBox<>();
        btn_Yes = new javax.swing.JButton();
        btn_No = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("SVN-Nexa Rush Handmade Extended", 1, 48)); // NOI18N
        jLabel1.setText("Nhân viên");

        jLabel2.setFont(new java.awt.Font("SVN-Nexa Light", 0, 28)); // NOI18N
        jLabel2.setText("Tên nhân viên:");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("SVN-Nexa Light", 0, 28)); // NOI18N
        jLabel3.setText("Chức vụ:");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("SVN-Nexa Light", 0, 28)); // NOI18N
        jLabel4.setText("CCCD:");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("SVN-Nexa Light", 0, 28)); // NOI18N
        jLabel5.setText("Địa chỉ:");
        jLabel5.setToolTipText("");

        txb_TenNV.setFont(new java.awt.Font("SVN-Nexa Light", 0, 28)); // NOI18N

        txb_CCCD.setFont(new java.awt.Font("SVN-Nexa Light", 0, 28)); // NOI18N

        txb_DiaChi.setFont(new java.awt.Font("SVN-Nexa Light", 0, 28)); // NOI18N

        combob_ChucVu.setFont(new java.awt.Font("SVN-Nexa Light", 0, 28)); // NOI18N
        combob_ChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combob_ChucVuActionPerformed(evt);
            }
        });

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
        btn_No.setText("Hủy");
        btn_No.setBorder(null);
        btn_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txb_CCCD)
                            .addComponent(txb_DiaChi)
                            .addComponent(txb_TenNV, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(combob_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 134, Short.MAX_VALUE)))
                        .addGap(64, 64, 64))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btn_Yes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_No)
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combob_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_No)
                    .addComponent(btn_Yes))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NoActionPerformed
       setVisible(false);
       
       new Admin().setVisible(true);
    }//GEN-LAST:event_btn_NoActionPerformed
        //Hàm đẩy dữ liệu vào sql
    private void btn_YesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_YesActionPerformed

        String TenNV = txb_TenNV.getText();
        String CCCD  = txb_CCCD.getText();
        String DiaChi = txb_DiaChi.getText();
    
        int index = combob_ChucVu.getSelectedIndex();
        int MaCV = ChucVu.get(index);
        if(Active==0) {
            int ret = JOptionPane.showConfirmDialog(null,"Bạn có muốn lưu","lưu dữ liệu",JOptionPane.YES_NO_OPTION);
            if(ret == JOptionPane.NO_OPTION) return;
            NhanVien_source newNV = new NhanVien_source(TenNV,MaCV, CCCD,DiaChi);
            newNV.AddNV();
            setVisible(false);
            new Admin().setVisible(true);
        }
        else{
            int ret = JOptionPane.showConfirmDialog(null,"Bạn có muốn sửa","Sửa dữ liệu",JOptionPane.YES_NO_OPTION);
            if(ret == JOptionPane.NO_OPTION) return;
            Connection con = model.GetCon();
            String sql = "Update NHANVIEN SET TenNV=?,MaCV=?,DinhDanh=?,DiaChi=? WHERE MaNV=?";
            try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setString(1,TenNV);
            pres.setInt(2,MaCV);
            pres.setString(3,CCCD);
            pres.setString(4,DiaChi);
            pres.setInt(5,MaNV);
            pres.executeUpdate();
            }
            catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi");}
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            setVisible(false);
            new Admin().setVisible(true);
        }
    }//GEN-LAST:event_btn_YesActionPerformed

    private void combob_ChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combob_ChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combob_ChucVuActionPerformed

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
            java.util.logging.Logger.getLogger(Worker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Worker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Worker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Worker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Worker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_No;
    private javax.swing.JButton btn_Yes;
    private javax.swing.JComboBox<String> combob_ChucVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txb_CCCD;
    private javax.swing.JTextField txb_DiaChi;
    private javax.swing.JTextField txb_TenNV;
    // End of variables declaration//GEN-END:variables
}
