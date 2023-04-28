-- CREATE DATABASE Hotel_Manager
USE Hotel_Manager

--DROP DATABASE Hotel_Manager

SET DATEFORMAT DMY

-- PHAN TAO BANG --
CREATE TABLE NGUOIDUNG
(
TenDangNhap nvarchar(20) COLLATE Latin1_General_CS_AS PRIMARY KEY, 
MatKhau nvarchar(20) COLLATE Latin1_General_CS_AS,
LoaiNguoiDung int,
);

CREATE TABLE LOAIPHONG -- Tao bang loai phong de thuc hien viec  phat trien nhieu loai phong.
(
MaLoaiPhong int PRIMARY KEY IDENTITY,
TenLoaiPhong nvarchar(40),
DonGia money,
SucChua tinyint,

);

CREATE TABLE PHONG
(
SoPhong int PRIMARY KEY IDENTITY, -- Dinh danh 
MaLoaiPhong int,
TinhTrang nvarchar(40) DEFAULT('TRONG'),
GhiChu nvarchar(40),
);

CREATE TABLE PHIEUTHUEPHONG
(
SoPTP int PRIMARY KEY IDENTITY, -- Dinh danh 
NgayLap date,
);

CREATE TABLE CT_PTP
(
MaCT_PTP int PRIMARY KEY IDENTITY, -- Dinh danh 
SoPTP int,
SoPhong int,
MaKH int,
GhiChu nvarchar(40),
);


CREATE TABLE KHACHHANG
(
MaKH int PRIMARY KEY IDENTITY,
TenKH nvarchar(40),
DinhDanh nvarchar (40),
);

CREATE TABLE PHIEUTHANHTOAN
(
SoPTT int PRIMARY KEY IDENTITY,
NgayTT date,
MaKH int,
);

CREATE TABLE CT_PTT
(
MaCT_PTT int PRIMARY KEY IDENTITY,
SoPTT int,
SoPhong int,
SoNgayThue int,
MaDV int,
ThanhTien money,
);

CREATE TABLE DICHVU 
(
MaDV int PRIMARY KEY IDENTITY,
TenDV nvarchar(40),
DonGia money,

);

CREATE TABLE BAOCAO
(
Ma_BC int PRIMARY KEY IDENTITY,
Thang int,

);

CREATE TABLE CT_BAOCAO
(
Ma_CTBC int PRIMARY KEY IDENTITY,
Ma_BC int,
MaLoaiPhong int,
DoanhThu money,
);

CREATE TABLE CHUCVU
(
MaCV int PRIMARY KEY IDENTITY,
TenCV nvarchar(40),
LuongCoBan money,
);

CREATE TABLE NHANVIEN
(
MaNV int PRIMARY KEY IDENTITY,
TenNV nvarchar(40),
MaCV int,
DinhDanh int,
DiaChi nvarchar(40),
);

CREATE TABLE BAOCAO_LUONG
(
Ma_BC int PRIMARY KEY IDENTITY,
Thang int,
);

CREATE TABLE BAOCAOCT_LUONG
(
MaCT_BC int PRIMARY KEY IDENTITY,
Ma_BC int,
MaNV int,
PhatSinh money default (0),
Thanh_Tien money,
GhiChu nvarchar(40),
)
---------------------------------------------------------------------------------------------------------------------------------
-- PHAN TAO KHOA NGOAI --
ALTER TABLE PHONG ADD
CONSTRAINT FK_PHONG_MaLoaiPhong FOREIGN KEY (MaLoaiPhong) REFERENCES LOAIPHONG(MaLoaiPhong)

ALTER TABLE CT_PTP ADD
CONSTRAINT FK_CTPTP_SoPTP FOREIGN KEY (SoPTP) REFERENCES PHIEUTHUEPHONG(SoPTP),
CONSTRAINT FK_CTPTP_SoPhong FOREIGN KEY (SoPhong) REFERENCES PHONG(SoPhong),
CONSTRAINT FK_CTPTP_MaKH FOREIGN KEY (MaKH) REFERENCES KHACHHANG(MaKH)

ALTER TABLE PHIEUTHANHTOAN ADD
CONSTRAINT FK_PHIEUTHANHTOAN_MaKH FOREIGN KEY (MaKH) REFERENCES KHACHHANG(MaKH)

ALTER TABLE CT_PTT ADD
CONSTRAINT FK_CTPTT_SoPTT FOREIGN KEY (SoPTT) REFERENCES PHIEUTHANHTOAN(SoPTT),
CONSTRAINT FK_CTPTT_SoPhong FOREIGN KEY (SoPhong) REFERENCES PHONG(SoPhong),
CONSTRAINT FK_CTPTT_MaDV FOREIGN KEY (MaDV) REFERENCES DICHVU(MaDV)

ALTER TABLE CT_BAOCAO ADD
CONSTRAINT FK_CTBAOCAO_MaBC FOREIGN KEY (Ma_BC) REFERENCES BAOCAO(Ma_BC),
CONSTRAINT FK_CTBAOCAO_MaLoaiPhong FOREIGN KEY (MaLoaiPhong) REFERENCES LoaiPhong(MaLoaiPhong)

ALTER TABLE BAOCAOCT_LUONG ADD
CONSTRAINT FK_BAOCAOCTLUONG_MaBC FOREIGN KEY (Ma_BC) REFERENCES BAOCAO_LUONG(Ma_BC),
CONSTRAINT FK_BAOCAOCTLUONG_MaNV FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV)

ALTER TABLE NHANVIEN ADD
CONSTRAINT FK_NHANVIEN_MaCV FOREIGN KEY (MaCV) REFERENCES CHUCVU(MaCV)
------------------------------------------------------------------------------------------------------------------
-- Tao Cac Tham So Mac Dinh --
INSERT INTO NGUOIDUNG VALUES ('admin','123456',1) --admin

------------------------------------------------------------------------------------------------------------------

-- Chuc Nang Nhap Du Lieu --

Go
CREATE PROC ThemLoaiPhong -- Nhap them loai phong
@tenloaiphong nvarchar(40), @dongia money, @succhua tinyint
as
begin
insert into LOAIPHONG(TenLoaiPhong, DonGia, SucChua) values(@tenloaiphong, @dongia, @succhua)
end

Go
CREATE PROC ThemPhong -- Phat sinh them so phong ( khi phat sinh phong tu dong tinh trang la TRONG )
@maloaiphong int, @ghichu nvarchar(40)
as
begin
insert into PHONG(MaLoaiPhong,GhiChu) values(@maloaiphong, @ghichu)
end

Go
CREATE PROC ThemPhieuThuePhong -- Them phieu theu phong
as
begin
declare @ngay date
set @ngay = getdate()
insert into PHIEUTHUEPHONG(NgayLap) values(@ngay)
end

Go
CREATE PROC ThemChiTietPhieuThuePhong -- Them chi tiet phieu thue phong tuong ung
@soptp int, @sophong int, @makh int, @ghichu nvarchar(40)
as 
begin
insert into CT_PTP(SoPTP, SoPhong, MaKH, GhiChu) values(@soptp, @sophong, @makh, @ghichu)
end

Go
CREATE PROC ThemKhachHang -- Them vao du lieu khach hang
@tenkh nvarchar(40), @dinhdanh nvarchar(40)
as
begin
insert into KHACHHANG(TenKH, DinhDanh) values(@tenkh, @dinhdanh)
end

Go
CREATE PROC ThemPhieuThanhToan -- Them phieu thanh toan
@makh int
as
begin
declare @ngay date
set @ngay = getdate()
insert into PHIEUTHANHTOAN(NgayTT, MaKH) values(@ngay, @makh)
end

Go
CREATE PROC ThemChiTietPTT -- Them chi tiet phieu thanh toan --dang chinh sua--
@soptt int, @sophong int, @songaythue int, @madv int, @thanhtien money
as
begin
insert into CT_PTT(SoPTT, SoPhong, SoNgayThue, MaDV, ThanhTien) values(@soptt, @sophong, @songaythue, @madv, @thanhtien)
begin --Update doanh thu cho chi tiet bao cao
declare @tongtien money, @mactbc int, @maloaiphong int
set @mactbc = (select Ma_CTBC from CT_BAOCAO, BAOCAO where BAOCAO.Ma_BC = CT_BAOCAO.Ma_BC and Thang = MONTH(GETDATE()))
set @maloaiphong = (select PHONG.MaLoaiPhong from PHONG, CT_PTT where @sophong = PHONG.SoPhong)
set @tongtien = @thanhtien + (select DoanhThu from CT_BAOCAO, BAOCAO where BAOCAO.Ma_BC = CT_BAOCAO.Ma_BC and Thang = MONTH(GETDATE()) and MaLoaiPhong = @maloaiphong)

update CT_BAOCAO set DoanhThu = @tongtien where Ma_CTBC = @mactbc and MaLoaiPhong = @maloaiphong
end
end

Go
CREATE PROC ThemDichVu -- Them dich vu
@tendv nvarchar(40), @dongia money
as
begin
insert into DICHVU(TenDV, DonGia) values(@tendv,@dongia)
end

Go
CREATE PROC ThemNhanVien -- Them nhan vien
@tennv nvarchar(40), @macv int, @dinhdanh nvarchar(40), @diachi nvarchar(40)
as
begin
insert into NHANVIEN(TenNV, MaCV, DinhDanh, DiaChi) values(@tennv, @macv, @dinhdanh, @diachi)
end

Go
CREATE PROC ThemChucVu -- Them mot chuc vu moi
@tencv nvarchar(40), @luongcoban money
as
begin
insert into CHUCVU(TenCV,LuongCoBan) values(@tencv, @luongcoban)
end

--------------------------------------------------------------------------------------------------------------------------
-- 2 cai bao cao se tu dong sinh ra khi ket thuc thang, duoc tu dong kiem tra khi dang nhap
-- PHAN LOGIN --
Go
CREATE PROC Login --kiem tra ten dang nhap va mat khau, neu dung thi se lay loai nguoi dung de phan cap
@username nvarchar(20), @pass varchar(20)
as 
begin
select LoaiNguoiDung from NGUOIDUNG where TenDangNhap=@username and MatKhau=@pass
end

Go 
CREATE PROC KT_BC  -- Tu dong tao bao cao doanh thu khi qua thang moi
as
begin
declare @time date, @mabc int;
set @time = getdate();
if not exists(select Ma_BC from BAOCAO where Thang=MONTH(@time))
begin
insert into BAOCAO(Thang) values(MONTH(@time))
set @mabc= (select Ma_BC from BAOCAO where Thang=MONTH(@time))
insert into CT_BAOCAO(Ma_BC,MaLoaiPhong,DoanhThu) 
select Ma_BC + 1, MaLoaiPhong, 0
from CT_BAOCAO
where CT_BAOCAO.Ma_BC = @mabc-1
end
end

Go 
CREATE PROC KT_BCL  -- Tu dong tao bao cao luong khi qua thang moi
as
begin
declare @time date, @mabc int;
set @time = getdate();
if not exists(select Ma_BC from BAOCAO_LUONG where Thang=MONTH(@time))
begin
insert into BAOCAO_LUONG(Thang) values(MONTH(@time))
set @mabc= (select Ma_BC from BAOCAO_LUONG where Thang=MONTH(@time))
insert into BAOCAOCT_LUONG(Ma_BC, MaNV, Thanh_Tien) 
select Ma_BC + 1, BAOCAOCT_LUONG.MaNV, LuongCoBan 
from BAOCAOCT_LUONG, CHUCVU, NHANVIEN
where BAOCAOCT_LUONG.Ma_BC = @mabc-1 AND BAOCAOCT_LUONG.MaNV = NHANVIEN.MaNV AND NHANVIEN.MaCV = CHUCVU.MaCV
end
end

-----------------------------------------------------------------------------------------------
-- PHAN HIEN THI --
Go
CREATE PROC HienThiChiTietBaoCao -- hien thi chi tiet bao cao
@thang int
as
begin
select TenLoaiPhong as 'Loại Phòng', DoanhThu as 'Doanh Thu' 
from LOAIPHONG, CT_BAOCAO, BAOCAO
where Thang = @thang and CT_BAOCAO.Ma_BC = BAOCAO.Ma_BC and CT_BAOCAO.MaLoaiPhong = LOAIPHONG.MaLoaiPhong

--------------------------------------------------------------------------------------------------

-- PHAN UPDATE --


