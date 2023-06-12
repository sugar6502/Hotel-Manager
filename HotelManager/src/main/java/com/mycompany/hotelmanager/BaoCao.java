/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hotelmanager;

/**
 *
 * @author Admins
 */
public class BaoCao extends javax.swing.JFrame {

    /**
     * Creates new form Salary
     */
    public BaoCao() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_DoanhThuPhong = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btn_Back = new javax.swing.JButton();
        btn_In = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lb_TongPhong = new javax.swing.JLabel();
        lb_Month = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_DoanhThuPhong1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lb_TongDV = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(252, 204, 204));

        jLabel1.setFont(new java.awt.Font("SVN-Nexa Rush Handmade Extended", 1, 48)); // NOI18N
        jLabel1.setText(" Báo cáo doanh thu");

        jScrollPane1.setFont(new java.awt.Font("SVN-Nexa Light", 0, 24)); // NOI18N

        tb_DoanhThuPhong.setBackground(new java.awt.Color(255, 204, 204));
        tb_DoanhThuPhong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tb_DoanhThuPhong.setFont(new java.awt.Font("SVN-Nexa Light", 0, 12)); // NOI18N
        tb_DoanhThuPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "STT", "Loại phòng", "Thành tiền", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
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
        tb_DoanhThuPhong.setGridColor(new java.awt.Color(0, 0, 0));
        tb_DoanhThuPhong.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tb_DoanhThuPhong.setShowGrid(false);
        tb_DoanhThuPhong.setShowHorizontalLines(true);
        tb_DoanhThuPhong.setShowVerticalLines(true);
        tb_DoanhThuPhong.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tb_DoanhThuPhong);

        jLabel2.setFont(new java.awt.Font("SVN-Nexa Light", 1, 30)); // NOI18N
        jLabel2.setText("Tháng:");

        btn_Back.setBackground(new java.awt.Color(252, 204, 204));
        btn_Back.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        btn_Back.setText("Back");

        btn_In.setBackground(new java.awt.Color(252, 204, 204));
        btn_In.setFont(new java.awt.Font("SVN-Nexa Light", 0, 36)); // NOI18N
        btn_In.setText("In");

        jLabel3.setFont(new java.awt.Font("SVN-Nexa Light", 1, 30)); // NOI18N
        jLabel3.setText("Tổng:");

        lb_TongPhong.setFont(new java.awt.Font("SVN-Nexa Light", 1, 30)); // NOI18N
        lb_TongPhong.setText("...");

        lb_Month.setFont(new java.awt.Font("SVN-Nexa Light", 1, 30)); // NOI18N
        lb_Month.setText("...");

        jScrollPane2.setFont(new java.awt.Font("SVN-Nexa Light", 0, 24)); // NOI18N

        tb_DoanhThuPhong1.setBackground(new java.awt.Color(255, 204, 204));
        tb_DoanhThuPhong1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tb_DoanhThuPhong1.setFont(new java.awt.Font("SVN-Nexa Light", 0, 12)); // NOI18N
        tb_DoanhThuPhong1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "STT", "Dịch vụ", "Thành tiền", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
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
        tb_DoanhThuPhong1.setGridColor(new java.awt.Color(0, 0, 0));
        tb_DoanhThuPhong1.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tb_DoanhThuPhong1.setShowGrid(false);
        tb_DoanhThuPhong1.setShowHorizontalLines(true);
        tb_DoanhThuPhong1.setShowVerticalLines(true);
        tb_DoanhThuPhong1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tb_DoanhThuPhong1);

        jLabel4.setFont(new java.awt.Font("SVN-Nexa Light", 1, 30)); // NOI18N
        jLabel4.setText("Tổng:");

        lb_TongDV.setFont(new java.awt.Font("SVN-Nexa Light", 1, 30)); // NOI18N
        lb_TongDV.setText("...");

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
                        .addComponent(btn_In)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Back))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_Month))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lb_TongPhong)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(lb_TongDV))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Back)
                        .addComponent(btn_In)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lb_Month))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lb_TongPhong)
                    .addComponent(jLabel4)
                    .addComponent(lb_TongDV))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JButton btn_In;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_Month;
    private javax.swing.JLabel lb_TongDV;
    private javax.swing.JLabel lb_TongPhong;
    private javax.swing.JTable tb_DoanhThuPhong;
    private javax.swing.JTable tb_DoanhThuPhong1;
    // End of variables declaration//GEN-END:variables
}
