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
MaLoaiPhong int PRIMARY KEY IDENTITY(1,1),
TenLoaiPhong nvarchar(40),
DonGia money,
SucChua tinyint,

);

CREATE TABLE PHONG
(
SoPhong int PRIMARY KEY , -- Dinh danh 
MaLoaiPhong int,
TinhTrang int DEFAULT(0),
GhiChu nvarchar(40),
);

CREATE TABLE PHIEUTHUEPHONG
(
SoPTP int PRIMARY KEY IDENTITY(1,1), -- Dinh danh 
NgayLap date,
DinhDanh nvarchar (12)
);

CREATE TABLE CT_PTP
(
MaCT_PTP int PRIMARY KEY IDENTITY(1,1), -- Dinh danh 
SoPTP int,
SoPhong int,
MaDV int,
GhiChu nvarchar(40),
);


CREATE TABLE KHACHHANG
(

DinhDanh nvarchar (12) PRIMARY KEY,
TenKH nvarchar(40),
SoDT varchar(12),

);

CREATE TABLE PHIEUTHANHTOAN
(
SoPTT int PRIMARY KEY IDENTITY(1,1),
NgayTT date,
DinhDanh nvarchar (12),
);

CREATE TABLE CT_PTT
(
MaCT_PTT int PRIMARY KEY IDENTITY(1,1),
SoPTT int,
SoPhong int,
SoNgayThue int default(0),
MaDV int,
ThanhTien int default(-1),
);

CREATE TABLE DICHVU 
(
MaDV int PRIMARY KEY IDENTITY(1,1),
TenDV nvarchar(40),
DonGia int,

);

CREATE TABLE BAOCAO
(
Ma_BC int PRIMARY KEY IDENTITY(1,1),
Thang int,
Nam int,

);

CREATE TABLE CT_BAOCAO
(
Ma_CTBC int PRIMARY KEY IDENTITY(1,1),
Ma_BC int,
SoPhong int,
DoanhThu int,
);

CREATE TABLE CHUCVU
(
MaCV int PRIMARY KEY IDENTITY(1,1),
TenCV nvarchar(40) UNIQUE,
LuongCoBan int,
);

CREATE TABLE NHANVIEN
(
MaNV int PRIMARY KEY IDENTITY(1,1),
TenNV nvarchar(40),
MaCV int,
DinhDanh nvarchar(12),
DiaChi nvarchar(40),
);

CREATE TABLE BAOCAO_LUONG
(
Ma_BC int PRIMARY KEY IDENTITY(1,1),
Thang int,
Nam int,
);

CREATE TABLE BAOCAOCT_LUONG
(
MaCT_BC int PRIMARY KEY IDENTITY(1,1),
Ma_BC int,
MaNV int,
PhatSinh int default (0),
Thanh_Tien int,
GhiChu nvarchar(40),
)

---------------------------------------------------------------------------------------------------------------------------------
-- PHAN TAO KHOA NGOAI --
ALTER TABLE PHONG ADD
CONSTRAINT FK_PHONG_MaLoaiPhong FOREIGN KEY (MaLoaiPhong) REFERENCES LOAIPHONG(MaLoaiPhong)

ALTER TABLE CT_PTP ADD
CONSTRAINT FK_CTPTP_SoPTP FOREIGN KEY (SoPTP) REFERENCES PHIEUTHUEPHONG(SoPTP),
CONSTRAINT FK_CTPTP_SoPhong FOREIGN KEY (SoPhong) REFERENCES PHONG(SoPhong),
CONSTRAINT FK_CTPTP_MaDV FOREIGN KEY (MaDV) REFERENCES DICHVU(MaDV)

ALTER TABLE PHIEUTHANHTOAN ADD
CONSTRAINT FK_PHIEUTHANHTOAN_DD FOREIGN KEY (DinhDanh) REFERENCES KHACHHANG(DinhDanh)

ALTER TABLE PHIEUTHUEPHONG ADD
CONSTRAINT FK_PHIEUTHUEPHONG_DD FOREIGN KEY (DinhDanh) REFERENCES KHACHHANG(DinhDanh)


ALTER TABLE CT_PTT ADD
CONSTRAINT FK_CTPTT_SoPTT FOREIGN KEY (SoPTT) REFERENCES PHIEUTHANHTOAN(SoPTT),
CONSTRAINT FK_CTPTT_SoPhong FOREIGN KEY (SoPhong) REFERENCES PHONG(SoPhong),
CONSTRAINT FK_CTPTT_MaDV FOREIGN KEY (MaDV) REFERENCES DICHVU(MaDV)

ALTER TABLE CT_BAOCAO ADD
CONSTRAINT FK_CTBAOCAO_MaBC FOREIGN KEY (Ma_BC) REFERENCES BAOCAO(Ma_BC),
CONSTRAINT FK_CTBAOCAO_SoPhong FOREIGN KEY (SoPhong) REFERENCES Phong(SoPhong)

ALTER TABLE BAOCAOCT_LUONG ADD
CONSTRAINT FK_BAOCAOCTLUONG_MaBC FOREIGN KEY (Ma_BC) REFERENCES BAOCAO_LUONG(Ma_BC),
CONSTRAINT FK_BAOCAOCTLUONG_MaNV FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV)

ALTER TABLE NHANVIEN ADD
CONSTRAINT FK_NHANVIEN_MaCV FOREIGN KEY (MaCV) REFERENCES CHUCVU(MaCV)
------------------------------------------------------------------------------------------------------------------
-- Tao Cac Tham So Mac Dinh --
INSERT INTO NGUOIDUNG VALUES ('admin','123456',1) --admin




INSERT INTO CHUCVU(TenCV,LUONGCOBAN) VALUES(N'Quản lý',10000000)
INSERT INTO CHUCVU(TenCV,LUONGCOBAN) VALUES(N'Lễ tân',5000000)
INSERT INTO CHUCVU(TenCV,LUONGCOBAN) VALUES(N'Phục vụ',2000000)

INSERT INTO LOAIPHONG(TenLoaiPhong, DonGia, SucChua) values(N'Đơn', 200000,2)
INSERT INTO LOAIPHONG(TenLoaiPhong, DonGia, SucChua) values(N'Đôi', 380000,4)
INSERT INTO LOAIPHONG(TenLoaiPhong, DonGia, SucChua) values(N'VIP', 500000,4)

INSERT INTO PHONG(SoPhong,MaLoaiPhong,TinhTrang) values(1,1, 0)
INSERT INTO PHONG(SoPhong,MaLoaiPhong,TinhTrang) values(2,1, 3)
INSERT INTO PHONG(SoPhong,MaLoaiPhong,TinhTrang) values(3,2, 3)
INSERT INTO PHONG(SoPhong,MaLoaiPhong,TinhTrang) values(4,2, 0)
INSERT INTO PHONG(SoPhong,MaLoaiPhong,TinhTrang) values(5,3, 3)
INSERT INTO PHONG(SoPhong,MaLoaiPhong,TinhTrang) values(6,3, 0)
INSERT INTO PHONG(SoPhong,MaLoaiPhong,TinhTrang) values(7,1, 0)

INSERT INTO DICHVU(TenDV,DonGia) values(N'Spa',10000)
INSERT INTO DICHVU(TenDV,DonGia) values(N'Bar',50000)


-- Chuc Nang Nhap Du Lieu --



Go
CREATE PROC ThemLoaiPhong -- Nhap them loai phong
@tenloaiphong nvarchar(40), @dongia money, @succhua tinyint
as
begin
insert into LOAIPHONG(TenLoaiPhong, DonGia, SucChua) values(@tenloaiphong, @dongia, @succhua)
end


Go
CREATE PROC ThemPhieuThuePhong -- Them phieu theu phong
@dinhdanh nvarchar(12)
as
begin
declare @ngay date
set @ngay = getdate()
insert into PHIEUTHUEPHONG(NgayLap,DinhDanh) values(@ngay,@dinhdanh)
end

Go
CREATE PROC ThemChiTietPhieuThuePhong -- Them chi tiet phieu thue phong tuong ung
@soptp int,@sophong int,@madv int
as 
begin
insert into CT_PTP(SoPTP,SoPhong, MaDV) values(@soptp,@sophong, @madv)
end

 SELECT * FROM PHIEUTHUEPHONG
 SELECT * FROM  CT_PTP



Go
CREATE PROC ThemKhachHang -- Them vao du lieu khach hang
@tenkh nvarchar(40), @dinhdanh nvarchar(40), @dienthoai varchar(12)
as
begin
if not exists(select TenKH from KHACHHANG where DinhDanh = @dinhdanh )
begin
insert into KHACHHANG(TenKH, DinhDanh,SoDT) values(@tenkh, @dinhdanh,@dienthoai)
end
end




Go
CREATE PROC ThemPhieuThanhToan -- Them phieu thanh toan
@dinhdanh nvarchar(12)
as
begin
insert into PHIEUTHANHTOAN(DinhDanh) values(@dinhdanh)
end

Go
CREATE PROC ThemChiTietPTT -- Them chi tiet phieu thanh toan --dang chinh sua--
@soptt int, @sophong int,  @madv int
as
begin
insert into CT_PTT(SoPTT, SoPhong, MaDV) values(@soptt, @sophong,  @madv)

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
@tencv nvarchar(40), @luongcoban int
as
begin
insert into CHUCVU(TenCV,LuongCoBan) values(@tencv, @luongcoban)
end

Go
CREATE PROC ThemPhong --- Them phong moi
@sophong int, @maloaiphong int, @tinhtrang int, @ghichu nvarchar(40)
as
begin
declare @mabc int
set @mabc = (select Ma_BC from BAOCAO where Thang = MONTH(getdate()) and Nam = YEAR(getdate()))
Insert into PHONG values(@sophong,@maloaiphong,@tinhtrang,@ghichu)
Insert into CT_BAOCAO values(@mabc,@sophong,0) 
end

--Xoa Phong----
Go 
Create proc XoaPhong
@sophong int 
as
begin
declare @mabc int
set @mabc = (select Ma_BC from BAOCAO where Thang = MONTH(getdate()) and Nam = YEAR(getdate()))
delete from CT_BAOCAO where Ma_BC=@mabc and SoPhong = @sophong
delete from PHONG where SoPhong = @sophong

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
if not exists(select Ma_BC from BAOCAO where Thang=MONTH(@time) and Nam=Year(@time))
begin
insert into BAOCAO(Thang,Nam) values(MONTH(@time),YEAR(@time))
set @mabc= (select Ma_BC from BAOCAO where Thang=MONTH(@time) and Nam=Year(@time))
insert into CT_BAOCAO(Ma_BC,SoPhong,DoanhThu) 
select @mabc, PHONG.SoPhong, 0
from PHONG
end
end

Go 
CREATE PROC KT_BCL  -- Tu dong tao bao cao luong khi qua thang moi
as
begin
declare @time date, @mabc int;
set @time = getdate();
if not exists(select Ma_BC from BAOCAO_LUONG where Thang=MONTH(@time) and Nam=Year(@time))
begin
insert into BAOCAO_LUONG(Thang,Nam) values(MONTH(@time),YEAR(@time))
set @mabc= (select Ma_BC from BAOCAO_LUONG where Thang=MONTH(@time) and Nam=Year(@time))
insert into BAOCAOCT_LUONG(Ma_BC, MaNV, Thanh_Tien) 
select @mabc, NHANVIEN.MaNV, LuongCoBan 
from CHUCVU, NHANVIEN
where NHANVIEN.MaCV = CHUCVU.MaCV
end
end

-----------------------------------------------------------------------------------------------
-- PHAN HIEN THI --


Go
CREATE PROC HienThiChiTietBaoCao -- hien thi chi tiet bao cao
@mabc int
as
begin
select SoPhong, DoanhThu 
from CT_BAOCAO
where CT_BAOCAO.Ma_BC = @mabc
end


Go 
CREATE PROC HienThiChiTietBaoCaoLuong -- hien thi chi tiet bao cao luong
@mabv int
as
begin
select TenNV as 'Tên Nhân Viên', CHUCVU.TenCV , LuongCoBan as 'Lương Cơ Bản', PhatSinh as 'Phát Sinh', Thanh_Tien as 'Thành Tiền', GhiChu as 'Ghi Chú'
from NHANVIEN, BAOCAOCT_LUONG, CHUCVU
where BAOCAOCT_LUONG.Ma_BC=@mabv  and NHANVIEN.MaNV = BAOCAOCT_LUONG.MaNV and NHANVIEN.MaCV = CHUCVU.MaCV
end
--------------------------------------------------------------------------------------------------

-- PHAN UPDATE --

Go
CREATE PROC UpdatePhatSinhBangCTLuong -- cap nhat phan phat sinh cong tru luong
@phatsinh int, @mabc int, @manv int, @ghichu nvarchar(40)
as
begin
update BAOCAOCT_LUONG 
set PhatSinh = @phatsinh,Thanh_Tien = Thanh_Tien + @phatsinh , GhiChu = @ghichu
where MaNV = @manv and Ma_BC = @mabc 
end

Go 
CREATE PROC UpdateLuongCoBan -- cap nhat luong co ban trong bang chuc vu
@luongsau int, @chechlechluong int, @macv int, @tencv nvarchar(20)
as
begin
declare @thang int, @nam int, @phatsinh int;

set @thang = MONTH(getdate())
set @nam = YEAR(getdate())
update CHUCVU
set LuongCoBan = @luongsau, TenCV = @tencv
where MaCV = @macv
update BAOCAOCT_LUONG
set Thanh_Tien = Thanh_Tien + @chechlechluong
where MaNV in (select MaNV from NHANVIEN where MaCV = @macv) and Ma_BC in (select Ma_BC from BAOCAO_LUONG where Thang=@thang and Nam =@nam)

end

Go
CREATE PROC Update_BangLuong -- cap nhat bang luong
as
begin
update BAOCAOCT_LUONG 
set Thanh_Tien = PhatSinh + (select LuongCoBan from CHUCVU,BAOCAO_LUONG,NHANVIEN WHERE NHANVIEN.MaNV = BAOCAOCT_LUONG.MaNV and CHUCVU.MaCV = NHANVIEN.MaCV and BAOCAOCT_LUONG.Ma_BC = BAOCAO_LUONG.Ma_BC and Thang = MONTH(getdate()) and Nam = YEAR(getdate()))
end


Go
CREATE PROC CapNhapPhieuThanhToan
@sophong int, @madv int, @songay int
as
begin
declare @sophieuthanhtoan int, @tamtien int
set @tamtien = (select DonGia From DICHVU where DICHVU.MaDV = @madv)
set @sophieuthanhtoan = (select  DISTINCT SoPTT from CT_PTT where SoPhong = @sophong and ThanhTien = -1)
UPDATE PHIEUTHANHTOAN set NgayTT = getdate() where SoPTT = @sophieuthanhtoan
if (@madv is null)
begin 
UPDATE CT_PTT set ThanhTien=@tamtien, SoNgayThue = @songay where SoPTT = @sophieuthanhtoan and SoPhong = @sophong
end
else
begin
UPDATE CT_PTT set ThanhTien=@tamtien, SoNgayThue = @songay where MaDV = @madv and SoPTT = @sophieuthanhtoan and SoPhong = @sophong
end
UPDATE PHONG set TinhTrang = 0 where SoPhong =  @sophong
end


Go
CREATE PROC CapNhatBaoCao
@sophong int, @doanhthu int
as
begin
declare @mabc int
set @mabc = (select Ma_BC from BAOCAO where Thang = MONTH(getdate()) and Nam = YEAR(getdate()))
UPDATE CT_BAOCAO set DoanhThu = DoanhThu + @doanhthu where SoPhong = @sophong and Ma_BC = @mabc
end






-----------------------------------------------
--- Mot so ham ho tro

Go
CREATE PROC LayThongTinPhongDaChoThue
@sophong int
as
begin
SELECT DISTINCT TenKH, NgayLap, KHACHHANG.DinhDanh, DonGia, TenLoaiPhong, PHONG.SoPhong
FROM PHIEUTHANHTOAN, CT_PTT, KHACHHANG, PHONG, LOAIPHONG, PHIEUTHUEPHONG, CT_PTP
WHERE PHONG.SoPhong = @sophong and PHONG.SoPhong = CT_PTP.SoPhong and PHONG.SoPhong = CT_PTT.SoPhong and ThanhTien = -1  and PHIEUTHANHTOAN.SoPTT = CT_PTT.SoPTT and KHACHHANG.DinhDanh = PHIEUTHANHTOAN.DinhDanh and PHONG.MaLoaiPhong = LOAIPHONG.MaLoaiPhong and  CT_PTP.SoPTP = PHIEUTHUEPHONG.SoPTP

end




Go
Create Proc LayThongTinDichVuCuaPhong
@sophong int
as
begin
SELECT TenDV, DonGia, DICHVU.MaDV
FROM DICHVU, CT_PTT
WHERE ThanhTien = -1 and SoPhong = @sophong and  CT_PTT.MaDV = DICHVU.MaDV
end




