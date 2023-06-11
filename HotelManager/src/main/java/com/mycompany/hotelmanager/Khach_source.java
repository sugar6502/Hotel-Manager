/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author netpr
 */
public class Khach_source { // Lớp khách hàng
    private static String TenKhach;
    private static String Cccd;
    private static String Sdt;
    private Connection con = new ConnectionSQL().getCon();
    
    public Khach_source(){}
    public Khach_source(String tenkhach,String cccd,String sdt){TenKhach=tenkhach;Cccd=cccd;Sdt=sdt;}
    
   public static void setTenKhach(String tenkhach){TenKhach = tenkhach;}
   public static void setCCCD(String cccd){Cccd = cccd;}
   public static void setInfoKhach(String sdt){Sdt = sdt;}
   
   public static String getTenKhach(){return TenKhach;}  
   public static String getCCCD(){return Cccd;}  
   public static String getSDT(){return Sdt;}  
  
   
   public void AddKhach(){ // Thêm khách hàng vào CSDL
   String sql = "EXEC ThemKhachHang ?,?,?";
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setString(1,TenKhach);
            pres.setString(2,Cccd);
            pres.setString(3,Sdt);
            ResultSet rs = pres.executeQuery();   
        }
        catch(Exception e) {JOptionPane.showMessageDialog(null, "Lỗi");}
    }
}
