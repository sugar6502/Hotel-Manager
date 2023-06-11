/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanager;

/**
 *
 * @author netpr
 */
public class Global {
    public static int ChucVu = 0; //Lưu chức vụ thành biến toàn cục để tiến hành phân chia quyền
    public Global(){};
    
    public static int getChucVu(){return ChucVu;}
    public static void setChucVu(int chucvu){ChucVu = chucvu;}
}
