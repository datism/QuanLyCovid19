-- Tao database QuanLycovid
CREATE DATABASE Quanlycovid19
GO

USE QuanLycovid19
GO

--Tao table

-----Quan Ly nhan khau, ho khau
CREATE TABLE Sohokhau
(
    Mahokhau INT          NOT NULL,
    Sonha    CHAR(10)     NOT NULL,
    DuongID  INT          NOT NULL,
    Chuho    NVARCHAR(50) NOT NULL,
    Ngaycap  DATE         NOT NULL
)
GO

CREATE TABLE NhanKhau
(
    Manhankhau          INT           NOT NULL,
    Hovaten             NVARCHAR(50)  NOT NULL,
    CCCD                VARCHAR(15)   NOT NULL,
    Ngaysinh            DATE          NULL,
    Noisinh             NVARCHAR(50)  NOT NULL,
    Dantoc              NVARCHAR(30)  NULL,
    Tongiao             NVARCHAR(30)  NULL,
    Gioitinh            BIT           NOT NULL,
    Trinhdovanhoa       NVARCHAR(30)  NULL,
    Nghenghiep          NVARCHAR(50)  NULL,
    Noilamviec          NVARCHAR(50)  NULL,
    Ngaydangkithuongtru DATE          NULL,
    Quanhevoichuho      NVARCHAR(20)  NULL,
    Mahokhau            INT           NOT NULL,
    Ghichu              NVARCHAR(MAX) NULL
)--Thong tin nhan khau
GO

CREATE TABLE Giaytamvang
(
    Magiaytamvang NVARCHAR(20) NOT NULL,
    Manhankhau    INT          NOT NULL,
    Ngaytamvang   DATE         NOT NULL,
    Noidi         NVARCHAR(50) NULL
)
GO

CREATE TABLE Sotamtru
(
    Matamtru        INT          NOT NULL,
    Mahokhau        INT          NOT NULL,
    Diachithuongtru NVARCHAR(50) NOT NULL,
    Manhankhau      INT          NOT NULL,
    Ngaytamtru      DATE         NOT NULL,
    Thoihan         DATE         NULL,
)
GO

CREATE TABLE PhieuChuyenDi
(
    Maphieuchuyendi INT           NOT NULL,
    Noichuyenden    NVARCHAR(100) NULL,
    Ngaychuyendi    DATE          NOT NULL,
    Lydochuyendi    NVARCHAR(MAX) NULL,
    Mahankhau       INT           NOT NULL
)
GO

CREATE TABLE PhieuChuyenDen
(
    Maphieuchuyenden INT           NOT NULL,
    Manhankhau       INT           NOT NULL,
    Noichuyendi      NVARCHAR(100) NULL,
    Ngaychuyenden    DATE          NOT NULL,
    Lydochuyenden    NVARCHAR(MAX) NOT NULL

)
GO

CREATE TABLE Phieuthaydoichuho
(
    Maphieuthaydoichuho INT           NOT NULL,
    Lydothaydoi         NVARCHAR(MAX) NULL,
    Ngaythaydoi         DATE          NOT NULL,
    Machuhocu           INT           NOT NULL,
    Machuhomoi          INT           NOT NULL
)
GO


CREATE TABLE ACCOUNT
(
    Username INT NOT NULL,
    Password VARCHAR(100)
)
GO

CREATE TABLE Benhnhancovidquocgia
(
    Hovaten         NVARCHAR(50) NOT NULL,
    CCCD            VARCHAR(15)  NOT NULL,
    Tuoi            INT          NOT NULL,
    Gioitinh        BIT          NULL,
    Thoidiemnhiem   DATE         NOT NULL,
    Mabenhnhannhiem INT          NOT NULL
)
GO

CREATE TABLE Thongtinkhaibaoyte
(
    Hovaten         NVARCHAR(50)  NOT NULL,
    CCCD            VARCHAR(15)   NOT NULL,
    Manhankhau      INT           NOT NULL,
    Sodienthoai     VARCHAR(11)   NOT NULL,
    Email           VARCHAR(20)   NULL,
    Noidichuyen     NVARCHAR(MAX) NOT NULL,
    Trieuchung      NVARCHAR(MAX) NULL,
    Thoidiemkhaibao DATE          NULL,
    Tiensumacbanh   NVARCHAR(MAX) NULL
)
GO

CREATE TABLE Thongtintestcovid
(
    Hovaten      NVARCHAR(100) NOT NULL,
    CCCD         VARCHAR(15)   NOT NULL,
    Manhankhau   INT           NOT NULL,
    Sodienthoai  VARCHAR(11)   NOT NULL,
    Solantest    INT           NOT NULL,
    Hinhthuctest NVARCHAR(50)  NOT NULL,
    Ketqua       BIT           NOT NULL,
    Mucdonhiem_F INT           NULL,
    Candicachly  BIT           NOT NULL
)
GO

CREATE TABLE Nguoicachly
(
    Hovaten           NVARCHAR(50)  NOT NULL,
    Manhankhau        INT           NOT NULL,
    Mucdocachly_F     INT           NULL,
    Thoidiemcachly    DATE          NOT NULL,
    Tinhtrang         BIT           NOT NULL,
    Khuvuccachly      NVARCHAR(100) NULL
)
GO

--Primary key

ALTER TABLE dbo.Sohokhau
    ADD CONSTRAINT PK_Sohokhau PRIMARY KEY (Mahokhau)
GO

ALTER TABLE dbo.NhanKhau
    ADD CONSTRAINT PK_Nhankhau PRIMARY KEY (Manhankhau)
GO

ALTER TABLE dbo.Giaytamvang
    ADD CONSTRAINT PK_Giaytamvang PRIMARY KEY (Magiaytamvang)
GO

ALTER TABLE dbo.Sotamtru
    ADD CONSTRAINT PK_Sotamtru PRIMARY KEY (Matamtru)
GO

ALTER TABLE dbo.PhieuChuyenDi
    ADD CONSTRAINT PK_Phieuchuyendi PRIMARY KEY (Maphieuchuyendi)
GO

ALTER TABLE dbo.Phieuthaydoichuho
    ADD CONSTRAINT PK_Phieuthaydoichuho PRIMARY KEY (Maphieuthaydoichuho)
GO

ALTER TABLE dbo.Benhnhancovidquocgia
    ADD CONSTRAINT PK_Manhiem PRIMARY KEY (Mabenhnhannhiem)
GO


-- Foreign key
ALTER TABLE dbo.NhanKhau
    ADD CONSTRAINT FK_Nhankhau_Sohokhau FOREIGN KEY (Mahokhau) REFERENCES dbo.Sohokhau (Mahokhau)
GO

ALTER TABLE dbo.Giaytamvang
    ADD CONSTRAINT FK_Giaytamvang_NhanKhau FOREIGN KEY (Manhankhau) REFERENCES dbo.NhanKhau (Manhankhau)
GO

ALTER TABLE dbo.Sotamtru
    ADD CONSTRAINT FK_Sotamtru_Sohokhau FOREIGN KEY (Mahokhau) REFERENCES dbo.Sohokhau (Mahokhau)
GO

ALTER TABLE dbo.Sotamtru
    ADD CONSTRAINT FK_Sotamtru_nhankhau FOREIGN KEY (Manhankhau) REFERENCES dbo.NhanKhau (Manhankhau)
GO


ALTER TABLE dbo.PhieuChuyenDi
    ADD CONSTRAINT FK_Sohokhau_Phieuchuyendi FOREIGN KEY (Mahankhau) REFERENCES dbo.NhanKhau (Manhankhau)
GO

ALTER TABLE dbo.PhieuChuyenDen
    ADD CONSTRAINT FK_PhieuChuyenDen_Nhankhau FOREIGN KEY (Manhankhau) REFERENCES dbo.NhanKhau (Manhankhau)
GO

ALTER TABLE dbo.Phieuthaydoichuho
    ADD CONSTRAINT FK_Phieuthaydoichuho_Nhankhau1 FOREIGN KEY (Machuhocu) REFERENCES dbo.NhanKhau (Manhankhau)
GO

ALTER TABLE dbo.Phieuthaydoichuho
    ADD CONSTRAINT FK_Phieuthaydoichuho_Nhankhau2 FOREIGN KEY (Machuhomoi) REFERENCES dbo.NhanKhau (Manhankhau)
GO


ALTER TABLE dbo.ACCOUNT
    ADD CONSTRAINT FK_account FOREIGN KEY (Username) REFERENCES dbo.NhanKhau (Manhankhau)
GO


ALTER TABLE dbo.Thongtinkhaibaoyte
    ADD CONSTRAINT FK_Thongtin_Nhankhau FOREIGN KEY (Manhankhau) REFERENCES dbo.NhanKhau (Manhankhau)
GO


ALTER TABLE dbo.Thongtintestcovid
    ADD CONSTRAINT FK_tt2 FOREIGN KEY (Manhankhau) REFERENCES dbo.NhanKhau (Manhankhau)
GO

ALTER TABLE dbo.Nguoicachly
    ADD CONSTRAINT FK_cl1 FOREIGN KEY (Manhankhau) REFERENCES dbo.NhanKhau (Manhankhau)
GO

ALTER TABLE dbo.Nguoicachly
    ADD CONSTRAINT FK_cl2 FOREIGN KEY (Mabenhnhantiepxuc) REFERENCES dbo.Benhnhancovidquocgia (Mabenhnhannhiem)
GO
