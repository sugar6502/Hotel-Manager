/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Source_code {
    private Connection con = new ConnectionSQL().getCon();
    
    public Source_code(){}
    
    public ResultSet LayLoaiPhong(){ // Lấy thông tin loại phòng
    String sql = "select MaLoaiPhong, TenLoaiPhong from LOAIPHONG";
    ResultSet rs = null;
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            rs = pres.executeQuery();   
        }
        catch(Exception e) {JOptionPane.showMessageDialog(null, "Lỗi");}
        return rs;
    }
    
    public int LayMaLoaiPhong(String tenLP){
    String sql = "select MaLoaiPhong from LOAIPHONG where TenLoaiPhong = N'?'";
    int ketqua=0;
    try{
        PreparedStatement pres = con.prepareStatement(sql);
        pres.setString(1,tenLP);       
        ResultSet rs = pres.executeQuery();   
        ketqua = rs.getInt(1);
        }
    catch(Exception e) {JOptionPane.showMessageDialog(null, "Lỗi");}
    return ketqua;
    }
    
    public ResultSet LayPhong(int maloaiphong,int tinhtrang){ // Lấy thông tin loại phòng
    String sql = "select SoPhong from Phong where MaLoaiPhong = ? and TinhTrang = ?";
    ResultSet rs = null;
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setString(1,Integer.toString(maloaiphong));  
            pres.setString(2,Integer.toString(tinhtrang));  
            rs = pres.executeQuery();   
        }
        catch(Exception e) {JOptionPane.showMessageDialog(null, "Lỗi");}
        return rs;
    }
}
