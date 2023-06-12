/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class NhanVien_source {
    private static String TenNV;
    private static String Cccd;
    private static String DiaChi;
    private static int MaCV;
    private Connection con = new ConnectionSQL().getCon();
    
    public NhanVien_source(){}
    public NhanVien_source(String tenNV,int macv, String cccd,String diachi){TenNV=tenNV;MaCV=macv;Cccd=cccd;DiaChi=diachi;}

    public static String getTenNV() {
        return TenNV;
    }

    public static String getCccd() {
        return Cccd;
    }

    public static String getDiaChi() {
        return DiaChi;
    }


    public Connection getCon() {
        return con;
    }

    public static void setTenNV(String TenNV) {
        NhanVien_source.TenNV = TenNV;
    }

    public static void setCccd(String Cccd) {
        NhanVien_source.Cccd = Cccd;
    }

    public static void setDiaChi(String DiaChi) {
        NhanVien_source.DiaChi = DiaChi;
    }


    public void setCon(Connection con) {
        this.con = con;
    }

    public static int getMaCV() {
        return MaCV;
    }

    public static void setMaCV(int MaCV) {
        NhanVien_source.MaCV = MaCV;
    }
    
    
  
   
   public void AddNV(){ // Thêm khách hàng vào CSDL
   String sql = "EXEC ThemNhanVien ?,?,?,?";
        try{
       
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setString(1,TenNV);
            pres.setInt(2,MaCV);
            pres.setString(3,Cccd);
            pres.setString(4,DiaChi);
            pres.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, "Thêm không thành công");}
        
    }
}
