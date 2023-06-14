/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Source_code {
    private final Connection con = new ConnectionSQL().getCon();
    public static int ChucVu = 0;
    
    public Source_code(){}
    
    public Connection GetCon() {
        return con;
    
    }
    
    public static int getChucVu(){return ChucVu;}
    public static void setChucVu(int chucvu){ChucVu = chucvu;}
    
    public ResultSet LayLoaiPhong(){ // Lấy thông tin loại phòng
        String sql = "select MaLoaiPhong, TenLoaiPhong from LOAIPHONG";
        ResultSet rs = null;
            try{
                PreparedStatement pres = con.prepareStatement(sql);
                rs = pres.executeQuery();   
            }
            catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi hàm LayLoaiPhong");}
        return rs;
    }
    
    
    public List<Integer> LayMaChucVu () {  //Lấy list tên chức vụ
        List<Integer> name = new ArrayList<>();
        String sql = "select MaCV from CHUCVU  ";
        try{
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()) {
            name.add(rs.getInt(1));
                    }
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        return name;
    }
    
    public String LayTenChucVu(int MaCV){ //Lấy tên chức vụ
        
        String sql = "select TenCV from CHUCVU where MaCV = ?";
        String ketqua="";
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setInt(1,MaCV);       
            ResultSet rs = pres.executeQuery(); 
            rs.next();
            ketqua = rs.getString(1);
            }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi");}
        return ketqua;
    }
    
    public int LayLuongChucVu(int MaCV){ //Lấy lương cơ bản chức vụ
        String sql = "select LuongCoBan from CHUCVU where MaCV = ?";
        int ketqua=0;
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setInt(1,MaCV);       
            ResultSet rs = pres.executeQuery(); 
            rs.next();
            ketqua = rs.getInt(1);
            }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi");}
        return ketqua;
    }
    
    public List<Integer> LayMaDichVu () {  //Lấy list tên chức vụ
        List<Integer> name = new ArrayList<>();
        String sql = "select MaDV from DICHVU";
        try{
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                name.add(rs.getInt(1));
                }
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        return name;
    }
    
     public int LayDonGiaDichVu(int MaDV){ //Lấy đơn giá dịch vụ
        
        String sql = "select DonGia from DICHVU where MaDV = ?";
        int ketqua=0;
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setInt(1,MaDV);       
            ResultSet rs = pres.executeQuery(); 
            rs.next();
            ketqua = rs.getInt(1);
            }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi");}
        return ketqua;
    }
     
    public String LayTenDichVu(int MaDV){ //Lấy tên dịch vụ
        
        String sql = "select TenDV from DICHVU where MaDV = ?";
        String ketqua="";
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setInt(1,MaDV);       
            ResultSet rs = pres.executeQuery(); 
            rs.next();
            ketqua = rs.getString(1);
            }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi");}
        return ketqua;
    }
    
    public List<Integer> LayMaNhanVien () {  //Lấy list  mã nhân viên
        List<Integer> name = new ArrayList<>();
        String sql = "select MaNV from NHANVIEN";
        try{
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                name.add(rs.getInt(1));
                }
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        return name;
    }
    

    public String LayThuocTinhNhanVien(int MaNV,String YC) { //Lấy thuộc tính nhân viên
        String sql = "Select CAST( " + YC + " AS nvarchar) from NHANVIEN where MaNV = ?";
        String ketqua="";
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setInt(1,MaNV);       
            ResultSet rs = pres.executeQuery(); 
            rs.next();
            ketqua = rs.getString(1);
            }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi");}
        return ketqua;
    }
    
     public List<Integer> LayMaBCLuong () {  //Lấy list mã bc luong
        List<Integer> name = new ArrayList<>();
        String sql = "select Ma_BC from BAOCAO_LUONG";
        try{
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                name.add(rs.getInt(1));
                }
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        return name;
    }
     
      public String LayThang(int MaBC){ //Lấy thời gian 
        
        String sql = "select Thang,Nam from BAOCAO_LUONG where Ma_BC = ?";
        String ketqua="";
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setInt(1,MaBC);       
            ResultSet rs = pres.executeQuery(); 
            rs.next();
            ketqua = rs.getString(1) +"/"+rs.getString(2);
            }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi");}
        return ketqua;
    }
      
      public List<Integer> LayMaLoaiPhong () {  //Lấy list mã loại phòng
        List<Integer> name = new ArrayList<>();
        String sql = "select MaLoaiPhong from LOAIPHONG";
        try{
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                name.add(rs.getInt(1));
                }
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        return name;
    }
      
    public String LayThuocTinhLoaiPhong(int MaLP,String YC) { //Lấy thuộc tính của loại phòng
        String sql = "Select CAST( " + YC + " AS nvarchar) from LOAIPHONG where MaLoaiPhong = ?";
  
        String ketqua="";
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setInt(1,MaLP);       
            ResultSet rs = pres.executeQuery(); 
            rs.next();
            ketqua = rs.getString(1);
            }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi");}
        return ketqua;
    
    
    }
    
      public List<Integer> LayMaPhong () {  //Lấy list so phong
        List<Integer> name = new ArrayList<>();
        String sql = "select SoPhong from PHONG";
        try{
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                name.add(rs.getInt(1));
                }
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        return name;
    }
      
       public List<Integer> LayMaPhongDaChoThue () {  //Lấy list so phong đã cho thuê
        List<Integer> name = new ArrayList<>();
        String sql = "select SoPhong from PHONG WHERE TinhTrang = 1";
        try{
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                name.add(rs.getInt(1));
                }
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        return name;
    }
       
    public String LayThuocTinhPhong(int MaP,String YC) { // Lấy thuộc tính phòng
        String sql = "Select CAST( " + YC + " AS nvarchar) from PHONG where SoPhong = ?";
  
        String ketqua="";
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setInt(1,MaP);       
            ResultSet rs = pres.executeQuery(); 
            rs.next();
            ketqua = rs.getString(1);
            }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi");}
        return ketqua;
    
    
    }
  
    public String LayThuocTinhKH(String DinhDanh,String YC) { // Lấy thuộc tính khách hàng
        String sql = "Select CAST( " + YC + " AS nvarchar) from KHACHHANG where DinhDanh = ?";
        String ketqua="";
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setString(1,DinhDanh);       
            ResultSet rs = pres.executeQuery(); 
            rs.next();
            ketqua = rs.getString(1);
            }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi");}
        return ketqua;

    }
    
      public List<Integer> LayMaBCLuong (int BC) {  //Lấy list mã ctbc luong
        List<Integer> name = new ArrayList<>();
        String sql = "select MaCT_BC from BAOCAOCT_LUONG where Ma_BC = ?";
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setInt(1,BC);
            ResultSet rs = pres.executeQuery();
            while(rs.next()) {
                name.add(rs.getInt(1));
           }
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        return name;
    }
      
      
      
        public String LayThuocTinhCTLuong(int MaBC,String YC) { //Lấy thuộc tính ctbc luong
        String sql = "Select CAST( " + YC + " AS nvarchar) from BAOCAOCT_LUONG where MaCT_BC = ?";
        String ketqua="";
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setInt(1,MaBC);       
            ResultSet rs = pres.executeQuery(); 
            rs.next();
            ketqua = rs.getString(1);
            }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi");}
        return ketqua;
   
    }
        
        
     public List<Integer> LaySoPhieuThuePhong () {  //Lấy list số phiếu thuê phòng
        List<Integer> name = new ArrayList<>();
        String sql = "select SoPTP from PHIEUTHUEPHONG";
        try{
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                name.add(rs.getInt(1));
                }
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        return name;
    }
     
    public List<Integer> LaySoPhieuThanhToan () {  //Lấy list số phiếu thanh toán
        List<Integer> name = new ArrayList<>();
        String sql = "select SoPTT from PHIEUTHANHTOAN";
        try{
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()) {
                name.add(rs.getInt(1));
                }
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        return name;
    }
    
    public String LayThangDoanhThu(int MaBC){ //Lấy thời gian
        String sql = "select Thang,Nam from BAOCAO where Ma_BC = ?";
        String ketqua="";
        try{
            PreparedStatement pres = con.prepareStatement(sql);
            pres.setInt(1,MaBC);       
            ResultSet rs = pres.executeQuery(); 
            rs.next();
            ketqua = rs.getString(1) +"/"+rs.getString(2);
            }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, e);}
        
        return ketqua;
    }
     
     public List<Integer> LayMaBCDT () {  //Lấy list mã báo cáo doanh thu
        List<Integer> name = new ArrayList<>();
        String sql = "select Ma_BC from BAOCAO";
        try{
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()) {
            name.add(rs.getInt(1));
                }
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        return name;
    }
  
    public ResultSet LayPhongVaLoaiPhong(){ //Lấy danh sách phòng và loại phòng
        String sql = """
                     Select LOAIPHONG.TenLoaiPhong, PHONG.SoPhong, LOAIPHONG.SucChua, PHONG.TinhTrang, PHONG.GhiChu
                     From PHONG inner join LOAIPHONG 
                     ON PHONG.MaLoaiPhong = LOAIPHONG.MaLoaiPhong""";
        ResultSet rs = null;
        try{
                PreparedStatement pres = con.prepareStatement(sql);
                rs = pres.executeQuery();   
           }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi hàm LayPhongVaLoaiPhong");}
        return rs;
    }
    
     public ResultSet LayPhongVaLoaiPhong(String tenloaiphong){ //Lấy danh sách phòng và loại phòng theo loại phòng
        String sql = """
                     Select LOAIPHONG.TenLoaiPhong, PHONG.SoPhong, LOAIPHONG.SucChua, PHONG.TinhTrang, PHONG.GhiChu
                     From PHONG inner join LOAIPHONG 
                     ON PHONG.MaLoaiPhong = LOAIPHONG.MaLoaiPhong
                     Where LOAIPHONG.TenLoaiPhong = N'""" + tenloaiphong + "'";
        ResultSet rs = null;
        try{
                PreparedStatement pres = con.prepareStatement(sql);
                rs = pres.executeQuery();   
           }
        catch(SQLException e) {JOptionPane.showMessageDialog(null, "Lỗi hàm LayPhongVaLoaiPhong co tham so");}
        return rs;
    }
}





    
