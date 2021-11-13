-- Tao database QuanLycovid
CREATE DATABASE Quanlycovid19
GO

USE QuanLycovid19
GO



--Tao table

           -----Quan Ly nhan khau, ho khau
CREATE TABLE Sohokhau (
	Masohokhau INT NOT NULL,
	Sonha CHAR(10) NOT NULL,
	DuongID INT NOT NULL,
	ChuHo NVARCHAR(50) NULL,
	Ngaycap DATE
	)
GO

CREATE TABLE NhanKhau(
   Manhankhau INT NOT NULL,
   Hovaten NVARCHAR(50)NOT NULL,
   CMND_CCCD INT NOT NULL, 
   Ngaythangnamsinh DATE NULL,
   Noisinh NVARCHAR(50) NOT NULL,
   Dantoc NVARCHAR(30) NULL,
   Tongiao NVARCHAR(30) NULL,
   Gioitinh BIT NOT NULL,
   Trinhdovanhoa NVARCHAR(30) NULL,
   Nghenghiep NVARCHAR(50) NULL,
   Noilamviec NVARCHAR(50) NOT NULL,
   Ngaydangkithuongtru DATE NULL,
   Quanhevoichuho NVARCHAR(20) NULL,
   Masohokhau INT NOT NULL,
   Ghichu NTEXT
   )--Thong tin nhan khau
GO 

CREATE TABLE Giaytamvang(
   Magiaytamvang NVARCHAR(20) NOT NULL,
   Manhankhau INT NOT NULL,
   Ngaytamvang DATE,
   Noidi NVARCHAR(50)
   )
GO

CREATE TABLE Sotamtru(
   Masotamtru INT NOT NULL,
   Masohokhau INT NOT NULL,
   Diachithuongtru NVARCHAR(50)NULL,
   Manhankhau INT NOT NULL,
   Ngaytamtru DATE NULL,
   Thoihan DATE NULL,
)
GO



CREATE TABLE PhieuChuyenDi(
   Sophieuchuyendi INT NOT NULL,
   Noichuyenden NVARCHAR(100) NULL,
   Ngaychuyendi DATE NOT NULL,
   Lydochuyendi TEXT NULL,
   Mahankhau INT NOT NULL
)
GO

CREATE TABLE PhieuChuyenDen(
   Sophieuchuyenden INT NOT NULL,
   Manhankhau INT NOT NULL,
   Noichuyendi NVARCHAR(100) NULL,
   Ngaychuyenden DATE NOT NULL,
   Lydochuyenden NTEXT

)
GO

CREATE TABLE Phieuthaydoichuho(
   Sophieuthaydoichuho INT NOT NULL,
   Lydothaydoi NTEXT,
   Ngaythaydoi DATE,
   Machuhocu INT NULL,
   Machuhomoi INT NULL
)
GO


CREATE TABLE ACCOUNT(
   Username INT NOT NULL,
   Password VARCHAR(100)
)
GO

CREATE TABLE Danhsachbenhnhancovid19quocgia(
   Hovaten NVARCHAR(50) NOT NULL,
   SoCMND_CCCD INT NOT NULL,
   Tuoi INT NOT NULL,
   Gioitinh BIT NOT NULL,
   Noinhiem NVARCHAR(100)NOT NULL,
   Thoidiemnhiemvirus DATE NOT NULL,
   Mabenhnhannhiem INT NOT NULL
)
GO

CREATE TABLE Thongtinkhaibaoyte(
   Hovatennguoikhaibao NVARCHAR(50) NOT NULL,
   SoCMND_CCCD INT NOT NULL,
   Manhankhau INT NOT NULL,
   Sodienthoailienhe INT NOT NULL,
   Email VARCHAR(20) NULL,
   Noidichuyentrong16ngay NTEXT,
   Trieuchung NTEXT NULL,
   Thoigiankhaibao DATE NULL,
   Tiensumacbanh NTEXT
)
GO

CREATE TABLE Thongtintestcovid(
  Hovatennguoitest NVARCHAR(100) NOT NULL,
  SoCMND_CCCD INT NOT NULL,
  Manhankhau INT NOT NULL,
  Sodienthoai INT NOT NULL,
  Solantest INT NOT NULL,
  Hinhthuctest NVARCHAR(50) NOT NULL,
  Mucdonhiem_F INT NULL,
  Candicachly BIT
)
GO

CREATE TABLE Danhsachnguoicachly(
   Hovaten NVARCHAR(50) NOT NULL,
   Manhankhau INT NOT NULL,
   Mucdocachly_F INT NULL,
   Thoidiemcachly DATE NOT NULL,
   Mabenhnhantiepxuc INT NULL,
   Khuvuccachly NVARCHAR(100)
)
 GO 

--Primary key

ALTER TABLE dbo.Sohokhau
ADD CONSTRAINT PK_Sohokhau PRIMARY KEY(Masohokhau)
GO

ALTER TABLE dbo.NhanKhau
ADD CONSTRAINT PK_Nhankhau PRIMARY KEY(Manhankhau)
GO

ALTER TABLE dbo.Giaytamvang
ADD CONSTRAINT PK_Giaytamvang PRIMARY KEY(Magiaytamvang)
GO

ALTER TABLE dbo.Sotamtru
ADD CONSTRAINT PK_Sotamtru PRIMARY KEY(Masotamtru)
GO


ALTER TABLE dbo.PhieuChuyenDi
ADD CONSTRAINT PK_Phieuchuyendi PRIMARY KEY(Sophieuchuyendi)
GO

ALTER TABLE dbo.Phieuthaydoichuho
ADD CONSTRAINT PK_Phieuthaydoichuho PRIMARY KEY(Sophieuthaydoichuho)
GO

ALTER TABLE dbo.Danhsachbenhnhancovid19quocgia
ADD CONSTRAINT PK_Manhiem PRIMARY KEY(Mabenhnhannhiem)
GO


-- Foreign key

ALTER TABLE dbo.NhanKhau
ADD CONSTRAINT FK_Nhankhau_Sohokhau FOREIGN KEY(Masohokhau) REFERENCES dbo.Sohokhau(Masohokhau)
GO

ALTER TABLE dbo.Giaytamvang
ADD CONSTRAINT FK_Giaytamvang_NhanKhau FOREIGN KEY(Manhankhau) REFERENCES dbo.NhanKhau(Manhankhau)
GO

ALTER TABLE dbo.Sotamtru
ADD CONSTRAINT FK_Sotamtru_Sohokhau FOREIGN KEY(Masohokhau) REFERENCES dbo.Sohokhau(Masohokhau)
GO

ALTER TABLE dbo.Sotamtru 
ADD CONSTRAINT FK_Sotamtru_nhankhau FOREIGN KEY(Manhankhau) REFERENCES dbo.NhanKhau(Manhankhau)
GO


ALTER TABLE dbo.PhieuChuyenDi
ADD CONSTRAINT FK_Sohokhau_Phieuchuyendi FOREIGN KEY(Mahankhau) REFERENCES dbo.NhanKhau(Manhankhau)
GO

ALTER TABLE dbo.PhieuChuyenDen
ADD CONSTRAINT FK_PhieuChuyenDen_Nhankhau FOREIGN KEY(Manhankhau) REFERENCES dbo.NhanKhau(Manhankhau)
GO

ALTER TABLE dbo.Phieuthaydoichuho
ADD CONSTRAINT FK_Phieuthaydoichuho_Nhankhau1 FOREIGN KEY(Machuhocu) REFERENCES dbo.NhanKhau(Manhankhau)
GO

ALTER TABLE dbo.Phieuthaydoichuho
ADD CONSTRAINT FK_Phieuthaydoichuho_Nhankhau2 FOREIGN KEY(Machuhomoi) REFERENCES dbo.NhanKhau(Manhankhau)
GO


 ALTER TABLE dbo.ACCOUNT 
 ADD CONSTRAINT FK_account FOREIGN KEY(Username) REFERENCES dbo.NhanKhau(Manhankhau)
 GO


ALTER TABLE dbo.Thongtinkhaibaoyte
ADD CONSTRAINT FK_Thongtin_Nhankhau FOREIGN KEY(Manhankhau) REFERENCES dbo.NhanKhau(Manhankhau)
GO


ALTER TABLE dbo.Thongtintestcovid
ADD CONSTRAINT FK_tt2 FOREIGN KEY(Manhankhau) REFERENCES dbo.NhanKhau(Manhankhau)
GO

ALTER TABLE dbo.Danhsachnguoicachly
ADD CONSTRAINT FK_cl1 FOREIGN KEY(Manhankhau) REFERENCES dbo.NhanKhau(Manhankhau)
GO

ALTER TABLE dbo.Danhsachnguoicachly
ADD CONSTRAINT FK_cl2 FOREIGN KEY(Mabenhnhantiepxuc) REFERENCES dbo.Danhsachbenhnhancovid19quocgia(Mabenhnhannhiem)
GO
