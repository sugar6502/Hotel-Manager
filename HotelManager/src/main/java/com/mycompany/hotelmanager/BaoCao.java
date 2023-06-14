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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admins
 */
public class BaoCao extends javax.swing.JFrame {

    /**
     * Creates new form Salary
     */
    private final Source_code model = new Source_code();
    private  List<Integer> DoanhThu ;
    
    //Hàm reset dữ liệu
    public void restart() {
    DoanhThu = model.LayMaBCDT();
    List<String> ThoiGian = new ArrayList<>();
        for(int i:DoanhThu) {
        ThoiGian.add(model.LayThangDoanhThu(i));
         }
    cb_Thang.setModel(new javax.swing.DefaultComboBoxModel<>(ThoiGian.toArray(String[]::new)));
    
   
    DefaultTableModel Tablemodel = (DefaultTableModel) tb_LP.getModel();
     Tablemodel.setRowCount(0);
    }
        
    public BaoCao() {
        initComponents();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_LP = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btn_Back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lb_Tong = new javax.swing.JLabel();
        cb_Thang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(252, 204, 204));

        jLabel1.setFont(new java.awt.Font("SVN-Nexa Rush Handmade Extended", 1, 48)); // NOI18N
        jLabel1.setText("Báo cáo doanh thu");

        jScrollPane1.setFont(new java.awt.Font("SVN-Nexa Light", 0, 24)); // NOI18N

        tb_LP.setBackground(new java.awt.Color(255, 204, 204));
        tb_LP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tb_LP.setFont(new java.awt.Font("SVN-Nexa Light", 0, 12)); // NOI18N
        tb_LP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Số phòng", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_LP.setGridColor(new java.awt.Color(0, 0, 0));
        tb_LP.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tb_LP.setShowGrid(false);
        tb_LP.setShowHorizontalLines(true);
        tb_LP.setShowVerticalLines(true);
        tb_LP.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tb_LP);

        jLabel2.setFont(new java.awt.Font("SVN-Nexa Light", 1, 30)); // NOI18N
        jLabel2.setText("Tháng:");

        btn_Back.setBackground(new java.awt.Color(252, 204, 204));
        btn_Back.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        btn_Back.setIcon(new javax.swing.ImageIcon("D:\\Hotel_Manager\\HotelManager\\src\\main\\java\\Icon\\352020_arrow_back_icon.png")); // NOI18N
        btn_Back.setBorder(null);
        btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SVN-Nexa Light", 1, 30)); // NOI18N
        jLabel3.setText("Tổng:");

        lb_Tong.setFont(new java.awt.Font("SVN-Nexa Light", 1, 30)); // NOI18N

        cb_Thang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ThangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Back))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lb_Tong))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cb_Thang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btn_Back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cb_Thang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lb_Tong))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Hàm lấy doanh thu khi chọn vào combo box
    private void cb_ThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ThangActionPerformed
        restart();
        int index = cb_Thang.getSelectedIndex();
        int DoanhThuT = 0;
        int MaBC = DoanhThu.get(index);
        String sql = "EXEC HienThiChiTietBaoCao ?";
        Connection con = model.GetCon();
        String row[] = new String[3];
        DefaultTableModel Tablemodel = (DefaultTableModel) tb_LP.getModel();
        try{
          PreparedStatement pres = con.prepareStatement(sql);
          pres.setInt(1,MaBC);
          ResultSet rs = pres.executeQuery();

          while(rs.next()) {
              row[0] = Integer.toString(Tablemodel.getRowCount()+1);
              row[1] = rs.getString(1);
              row[2] = rs.getString(2);
              DoanhThuT += rs.getInt(2);
              Tablemodel.addRow(row);
          }
        }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, e);}
        lb_Tong.setText(Integer.toString(DoanhThuT));
    }//GEN-LAST:event_cb_ThangActionPerformed

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
       setVisible(false);
    }//GEN-LAST:event_btn_BackActionPerformed

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
            java.util.logging.Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaoCao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Back;
    private javax.swing.JComboBox<String> cb_Thang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Tong;
    private javax.swing.JTable tb_LP;
    // End of variables declaration//GEN-END:variables
}
