/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hotelmanager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author netpr
 */
public class CheckIn_2 extends javax.swing.JFrame {
    Source_code model = new Source_code();
    public CheckIn_2() {
        initComponents();
        //System.out.println("2");
        Khach_source newKhach = new Khach_source();
        // Thông tin khách sẽ checkin
        lb_cusname.setText(newKhach.getTenKhach());
        lb_cccd.setText(newKhach.getCCCD());
        lb_sdt.setText(newKhach.getSDT());
        
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
        jLabel6 = new javax.swing.JLabel();
        cb_Phong = new javax.swing.JComboBox<>();
        List<String> tenPhong = new ArrayList<String>();
        try{//Lấy phòng từ CSDL
            ResultSet rs_P = model.LayPhong(1,0);
            while(rs_P.next())
            tenPhong.add(rs_P.getString(1));
        }
        catch(SQLException e){System.out.print(e);};
        cb_Phong.setModel(new javax.swing.DefaultComboBoxModel<>(tenPhong.toArray(String[]::new)));
        cb_LoaiPhong = new javax.swing.JComboBox<>();
        List<String> tenLoaiPhong = new ArrayList<String>();
        try{//Lấy loại phòng từ CSDL
            ResultSet rs_LP = model.LayLoaiPhong();
            while(rs_LP.next())
            tenLoaiPhong.add(rs_LP.getString(2));
        }
        catch(SQLException e){System.out.print(e);};
        txb_Note = new javax.swing.JTextField();
        btn_Yes = new javax.swing.JButton();
        btn_No = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lb_cccd = new javax.swing.JLabel();
        btn_Add = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lb_sdt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Room = new javax.swing.JTable();
        btn_Delete = new javax.swing.JButton();

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

        jLabel6.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        jLabel6.setText("Ghi chú:");
        jLabel6.setToolTipText("");

        cb_Phong.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N

        cb_LoaiPhong.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        //Thêm loại phòng vào combo box
        cb_LoaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(tenLoaiPhong.toArray(String[]::new)));
        cb_LoaiPhong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_LoaiPhongItemStateChanged(evt);
            }
        });

        txb_Note.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        txb_Note.setText("....");

        btn_Yes.setBackground(new java.awt.Color(255, 204, 204));
        btn_Yes.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_Yes.setForeground(new java.awt.Color(0, 204, 0));
        btn_Yes.setText("Xác nhận");
        btn_Yes.setBorder(null);

        btn_No.setBackground(new java.awt.Color(255, 204, 204));
        btn_No.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_No.setForeground(new java.awt.Color(255, 0, 51));
        btn_No.setText("HỦy");
        btn_No.setBorder(null);

        jLabel7.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        jLabel7.setText("CCCD: ");
        jLabel7.setToolTipText("");

        lb_cccd.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        lb_cccd.setText("*cccd*");
        lb_cccd.setToolTipText("");

        btn_Add.setBackground(new java.awt.Color(255, 204, 204));
        btn_Add.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_Add.setForeground(new java.awt.Color(153, 0, 204));
        btn_Add.setText("Thêm");
        btn_Add.setToolTipText("");
        btn_Add.setBorder(null);
        btn_Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AddMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        jLabel8.setText("SĐT: ");
        jLabel8.setToolTipText("");

        lb_sdt.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        lb_sdt.setText("*sdt*");
        lb_sdt.setToolTipText("");

        tb_Room.setBackground(new java.awt.Color(255, 204, 204));
        tb_Room.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tb_Room.setFont(new java.awt.Font("SVN-Nexa Light", 0, 12)); // NOI18N
        tb_Room.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Loại phòng", "Phòng", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tb_Room);

        btn_Delete.setBackground(new java.awt.Color(255, 204, 204));
        btn_Delete.setFont(new java.awt.Font("SVN-Nexa Rush Sans Black", 0, 36)); // NOI18N
        btn_Delete.setForeground(new java.awt.Color(153, 0, 204));
        btn_Delete.setText("Xóa");
        btn_Delete.setToolTipText("");
        btn_Delete.setBorder(null);
        btn_Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn_CheckInLayout = new javax.swing.GroupLayout(pn_CheckIn);
        pn_CheckIn.setLayout(pn_CheckInLayout);
        pn_CheckInLayout.setHorizontalGroup(
            pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_CheckInLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pn_CheckInLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_CheckInLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_CheckInLayout.createSequentialGroup()
                                        .addComponent(btn_No)
                                        .addGap(75, 75, 75))
                                    .addComponent(btn_Yes, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(pn_CheckInLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btn_Add)
                                .addGap(33, 33, 33)
                                .addComponent(btn_Delete))))
                    .addGroup(pn_CheckInLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txb_Note, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addGroup(pn_CheckInLayout.createSequentialGroup()
                        .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_Phong, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_LoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_CheckInLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(285, 285, 285))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_LoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_Phong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_Note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_CheckInLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pn_CheckInLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(pn_CheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Add)
                            .addComponent(btn_Delete))
                        .addGap(18, 18, 18)
                        .addComponent(btn_Yes)
                        .addGap(29, 29, 29)
                        .addComponent(btn_No)
                        .addGap(22, 22, 22))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_CheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_CheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CapNhatPhong(){ // Cập nhật thông tin cho combo box Phòng
        //System.out.print(cb_LoaiPhong.getSelectedItem().toString());
        int maloaiphong = model.LayMaLoaiPhong(cb_LoaiPhong.getSelectedItem().toString());
        //System.out.print(maloaiphong);
        List<String> tenPhong = new ArrayList<String>();
        try{//Lấy phòng từ CSDL
            ResultSet rs_P = model.LayPhong(maloaiphong,0);
            while(rs_P.next())
            tenPhong.add(rs_P.getString(1));
        }
        catch(SQLException e){System.out.print(e);};
        cb_Phong.setModel(new javax.swing.DefaultComboBoxModel<>(tenPhong.toArray(String[]::new)));
    }
    
    private void cb_LoaiPhongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_LoaiPhongItemStateChanged
        CapNhatPhong();
    }//GEN-LAST:event_cb_LoaiPhongItemStateChanged

    private void btn_AddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AddMouseClicked
        model.XetTinhTrangPhong(Integer.parseInt(cb_Phong.getSelectedItem().toString()),2);
        ResultSet rs_P2 = model.PhongTinhTrang2();
        int i=1;
        try {
            DefaultTableModel model = (DefaultTableModel)tb_Room.getModel();
            model.setRowCount(0);
            while(rs_P2.next()){
                Object[] rowData = {i,rs_P2.getString(1),rs_P2.getInt(2),rs_P2.getString(3)};
                i++;
                model.addRow(rowData);
            }
        } catch (SQLException ex) {}
        CapNhatPhong();
    }//GEN-LAST:event_btn_AddMouseClicked

    private void btn_DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DeleteMouseClicked
        int indexTb = tb_Room.getSelectedRow();
        try{
            var sophong = tb_Room.getValueAt(indexTb, 2);
            model.XetTinhTrangPhong((int) sophong,0);}
        catch(Exception e){}
        int i=1;
        try {
            ResultSet rs_P2 = model.PhongTinhTrang2();
            DefaultTableModel model = (DefaultTableModel)tb_Room.getModel();
            model.setRowCount(0);
            while(rs_P2.next()){
                Object[] rowData = {i,rs_P2.getString(1),rs_P2.getInt(2),rs_P2.getString(3)};
                i++;
                model.addRow(rowData);
            }
        } catch (SQLException ex) {}
        CapNhatPhong();
        
    }//GEN-LAST:event_btn_DeleteMouseClicked

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
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_No;
    private javax.swing.JButton btn_Yes;
    private javax.swing.JComboBox<String> cb_LoaiPhong;
    private javax.swing.JComboBox<String> cb_Phong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_cccd;
    private javax.swing.JLabel lb_cusname;
    private javax.swing.JLabel lb_sdt;
    private javax.swing.JPanel pn_CheckIn;
    private javax.swing.JTable tb_Room;
    private javax.swing.JTextField txb_Note;
    // End of variables declaration//GEN-END:variables
}
