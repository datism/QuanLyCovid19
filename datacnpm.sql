-- Tao database QuanLycovid
CREATE DATABASE Quanlycovid19
GO

USE QuanLycovid19
GO

--Tao table

-----Quan Ly nhan khau, ho khau
CREATE TABLE Sohokhau
(
    Mahokhau INT          NOT NULL IDENTITY (1,1),
    Sonha    CHAR(10)     NOT NULL,
    DuongID  INT          NOT NULL,
    Chuho    INT          NOT NULL,
    Ngaycap  DATE         NOT NULL
)
GO

CREATE TABLE NhanKhau
(
    Manhankhau          INT           NOT NULL IDENTITY (1,1),
    Hovaten             NVARCHAR(50)  NOT NULL,
    CCCD                VARCHAR(15)   NOT NULL,
    Ngaysinh            DATE          NOT NULL,
    Noisinh             NVARCHAR(50)  NULL,
    Dantoc              NVARCHAR(30)  NULL,
    Tongiao             NVARCHAR(30)  NULL,
    Gioitinh            BIT           NOT NULL,
    Trinhdovanhoa       NVARCHAR(30)  NULL,
    Nghenghiep          NVARCHAR(50)  NULL,
    Noilamviec          NVARCHAR(50)  NULL,
    Ngaydangkithuongtru DATE          NOT NULL,
    Quanhevoichuho      NVARCHAR(20)  NULL,
    Mahokhau            INT           NULL,
    Ghichu              NVARCHAR(MAX) NULL
)--Thong tin nhan khau
GO

CREATE TABLE Giaytamvang
(
    Magiaytamvang INT          NOT NULL IDENTITY (1,1),
    Manhankhau    INT          NOT NULL,
    Ngaytamvang   DATE         NOT NULL,
    Noidi         NVARCHAR(50) NULL
)
GO

CREATE TABLE Giaytamtru
(
    Matamtru        INT          NOT NULL IDENTITY (1,1),
    Mahokhau        INT          NOT NULL,
    Diachithuongtru NVARCHAR(50) NOT NULL,
    Manhankhau      INT          NOT NULL,
    Ngaytamtru      DATE         NOT NULL,
    Thoihan         DATE         NOT NULL,
)
GO

CREATE TABLE PhieuChuyenDi
(
    Maphieuchuyendi INT           NOT NULL IDENTITY (1,1),
    Noichuyenden    NVARCHAR(100) NULL,
    Ngaychuyendi    DATE          NOT NULL,
    Lydochuyendi    NVARCHAR(MAX) NULL,
    Mahankhau       INT           NOT NULL
)
GO

CREATE TABLE PhieuChuyenDen
(
    Maphieuchuyenden INT           NOT NULL IDENTITY (1,1),
    Manhankhau       INT           NOT NULL,
    Noichuyendi      NVARCHAR(100) NULL,
    Ngaychuyenden    DATE          NOT NULL,
    Lydochuyenden    NVARCHAR(MAX) NOT NULL
)
GO

CREATE TABLE Phieuthaydoichuho
(
    Maphieuthaydoichuho INT           NOT NULL IDENTITY (1,1),
    Lydothaydoi         NVARCHAR(MAX) NULL,
    Ngaythaydoi         DATE          NOT NULL,
    Machuhocu           INT           NOT NULL,
    Machuhomoi          INT           NOT NULL
)
GO


CREATE TABLE ACCOUNT
(
    Username INT            NOT NULL,
    Password VARCHAR(100)   NOT NULL,
    ACCESS   INT            NOT NULL
)
GO

CREATE TABLE Benhnhancovidquocgia
(
    Hovaten         NVARCHAR(50) NOT NULL,
    CCCD            VARCHAR(15)  NOT NULL,
    Tuoi            INT          NOT NULL,
    Gioitinh        BIT          NULL,
    Thoidiemnhiem   DATE         NOT NULL,
    Noinhiem        NVARCHAR(100) NULL,
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
    Noidichuyen     NVARCHAR(MAX) NULL,
    Trieuchung      NVARCHAR(MAX) NULL,
    Thoidiemkhaibao DATE          NOT NULL,
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
    Ngaytest     DATE          NOT NULL
)
GO

CREATE TABLE Nguoicachly
(
    Hovaten				NVARCHAR(50)  NOT NULL,
    Manhankhau			INT           NOT NULL,
    Mucdocachly_F		INT           NOT NULL,
    Thoidiemcachly		DATE          NOT NULL,
	Mabenhnhantiepxuc	INT           NULL,
    Khuvuccachly		NVARCHAR(100) NULL
)
GO

--
-- Inserting data into table dbo.Benhnhancovidquocgia
--
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (0, N'HWUNCHRCIA', '116388614852', 72, 0, '2019-01-07', N'W5Q2UF047OKBH11')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (1, N'LXLDAFYRIT', '432378798726', 12, 1, '2019-10-11', N'37SLMRCWYPGQBRG')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (2, N'IKRNLPIWCB', '724206225549', 17, 1, '2019-01-11', N'3QJML207010E85J')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (3, N'RWFPXXTFDH', '385499298748', 74, 0, '2019-04-16', N'767GO0P0ZEW8KPI')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (4, N'KMOPXKULGK', '833950814355', 39, 1, '2020-04-13', N'6434ZD0X6Q15DH4')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (5, N'XLMQVBAYIC', '122527828005', 29, NULL, '2019-11-23', N'HMO21L25KNEMT06')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (6, N'IXLSRLJRWX', '228469211908', 17, 1, '2019-06-28', N'60315P6W08KK37N')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (7, N'HDWNWQPOCG', '910306901436', 72, 0, '2019-01-19', N'56I22X4L1720YR0')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (8, N'DLXZBVVWAA', '668663360948', 2, 1, '2021-07-15', N'56S64SSV98YA982')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (9, N'FTUOEBMNSF', '544946938558', 78, 1, '2020-06-19', N'5593JCD395446C0')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (10, N'QAHYNOMVGG', '537324089908', 69, 1, '2020-10-03', N'5G0RB28X75QYX84')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (11, N'JBTMXWYVGP', '240326764534', 31, 0, '2020-12-21', N'3AUM5YK1EIEN9UK')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (12, N'TLMWFSAMEF', '078495834252', 55, 1, '2019-01-08', N'Z83S1FSJAY4I30S')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (13, N'NFJEYMIYUF', '109280380123', 8, 1, '2021-12-17', NULL)
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (14, N'VCDYGSVEFY', '860482379250', 64, 0, '2020-08-04', N'CNS6Z06WHDRZ87U')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (15, N'UKBTFHCYUY', '876061955405', 10, 1, '2019-06-05', N'UF892F3500PMET5')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (16, N'NLUWQUKDIF', '910866047106', 41, 1, '2020-05-06', N'Z4DYY331MM9958X')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (17, N'OHKREVMGVB', '294481676819', 84, 0, '2020-08-13', N'TU5S2H018M17X6N')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (18, N'KWEIPJPJSS', '655501700680', 34, 1, '2020-08-07', N'LGS7IZ44284HUP1')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (19, N'NFHZXDSRIJ', '615156387529', 79, 0, '2021-02-07', N'0743C865AJ2I753')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (20, N'BWRNVBIWFA', '269661749911', 97, 1, '2021-08-19', N'C80N582G53LAC17')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (21, N'YZNTUYWWFP', '523956922700', 80, 1, '2020-11-12', N'N0M9FP2JH2FCSLH')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (22, N'KHWLKNHQIV', '122040106354', 18, 1, '2019-11-08', N'DIR3S29UA96F8GA')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (23, N'SQUIJHLUVV', '494481889737', 83, 1, '2020-03-19', N'577571Y4E3A870T')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (24, N'TTWJFPDDZA', '322771398118', 30, 0, '2019-03-02', N'970ADE1K5789J8E')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (25, N'IWYMHTEVOT', '125266148215', 13, 0, '2020-01-15', N'7Y130N9J0B0QY95')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (26, N'XXOZUYEJOJ', '800120116765', 30, 0, '2019-12-21', N'2Y5I48JK0QES4R3')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (27, N'YDKEPQKUPO', '339854530673', 17, 0, '2020-08-12', N'7O654FWUDM6260N')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (28, N'OZMEKWGXXD', '215194407095', 51, 0, '2021-05-20', N'3CRN810W1MO58DV')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (29, N'NWMYQDBTKP', '194059328446', 45, 1, '2020-05-03', N'21CJS0SM306X6R6')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (30, N'CVCNKDIJAZ', '431300485813', 9, 0, '2021-03-27', N'Z6BKNEJH7VGD8EV')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (31, N'FVGWEXSVYX', '398738609588', 43, 0, '2019-01-09', N'3ZFMWMB17BG5H12')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (32, N'LXJZHTORLM', '079542951141', 71, 0, '2021-01-07', N'E8S36340P5F8VG9')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (33, N'FOKLLGNLTD', '548433782076', 99, 1, '2021-06-13', NULL)
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (34, N'HVKOOTRNHP', '452635052673', 91, 1, '2019-04-22', N'INH734598117N2D')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (35, N'EACSFCASEC', '737460083868', 55, 1, '2020-06-14', N'95I7IUO7NSU1GWP')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (36, N'SGBLAZPHCU', '473002578220', 5, 0, '2020-08-27', N'5G105UD89I1K9VL')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (37, N'WJNEINPZWN', '990531819894', 61, 0, '2020-09-11', N'4V65H0662U85K19')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (38, N'AOXDNFGHCY', '799392073579', 39, 0, '2020-12-20', N'UNJEQ4G16HE4BDX')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (39, N'MKZNKUGNDK', '140370303574', 27, 0, '2020-11-17', N'N7ZW5TBAI97PMVR')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (40, N'JQSOXQOKAD', '231812123684', 80, 1, '2019-09-14', N'S0PNWN69R66I72J')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (41, N'QEPYMAPMNO', '779496021645', 47, 1, '2019-09-02', N'3762X95V0ROC66O')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (42, N'GJUUYPKHGU', '574777092212', 26, 1, '2021-11-13', N'552T7X788A93KWW')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (43, N'ZEEGGWZYKL', '483352495426', 76, 1, '2019-11-06', N'04RI4NXA02NLM1R')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (44, N'LPCERMJFVS', '456958166008', 84, NULL, '2021-06-07', N'P66GZRPVUO11TH6')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (45, N'QWOTLZYRDY', '124186231293', 63, 1, '2020-03-18', N'7GJX37RH2VK8471')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (46, N'EWPKOMZFRZ', '688203629440', 70, NULL, '2019-05-17', N'RCKTEZ1I6QZ1UQ6')
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (47, N'KARIVZQHAD', '910073634107', 46, 0, '2019-01-07', NULL)
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (48, N'YTBDQYUZAP', '877830265788', 52, NULL, '2019-03-13', NULL)
INSERT dbo.Benhnhancovidquocgia(Mabenhnhannhiem, Hovaten, CCCD, Tuoi, Gioitinh, Thoidiemnhiem, Noinhiem) VALUES (49, N'PAOHOTRWHO', '584429376244', 76, NULL, '2020-04-16', NULL)
GO

--
-- Inserting data into table dbo.NhanKhau
--
SET IDENTITY_INSERT dbo.NhanKhau ON
GO
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (0, N'FevsIXDefhrkTHC', '823413561699', '1950-09-17', N'QKBUJIDADM', N'CBTDU', N'VGFND', 0, N'09P06', N'7YN7Y', N'N5A3G', '2001-01-02', NULL, 0, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (1, N'CrqiUwUOgqem', '399820609527', '1990-11-02', N'ORTANRFOHD', N'EHFBA', N'MWVYP', 0, N'UZGO3', N'DG4SZ', N'DOMU9', '2015-06-06', N'Con', 0, N'đã mất')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (2, N'ZqDpGTejBFPdyEQ', '075258511979', '1970-07-20', N'NWWELGDTWH', N'XHBDA', N'MVJOX', 0, NULL, N'MX214', N'AX4CF', '2011-02-14', N'Vợ', 0, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (3, N'VpEZCzxYjm', '629926208014', '2010-06-30', N'MVNXTRLHKC', N'CWYTF', N'OYWXD', 0, NULL, N'84C50', N'86MNW', '2017-06-18', N'Con', 0, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (4, N'vBxKYNMwtmY', '672684098265', '1969-05-10', N'SGMKJRBDDA', N'ETKDD', NULL, 0, N'C6K7Z', N'451U8', N'HGSKU', '2001-01-04', NULL, 1, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (5, N'YxcsHhwrNa', '773815873080', '1980-09-10', N'UIGILZSALJ', N'BBKBU', NULL, 1, N'Y23H4', N'L48FM', N'Z10DN', '2014-02-15', N'Chồng', 1, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (6, N'dinYiHzcDSkKn', '473947404695', '1968-07-30', N'HATQMMSAQE', N'FBWOB', N'NBCZQ', 1, N'1KG4H', N'99BUP', N'0Z4NK', '2013-02-12', NULL, 2, N'PYRKM ')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (7, N'vdwnuADQzpvcKL', '749100567804', '1970-07-17', N'TYXZFCZTTX', N'KCFBK', N'RWQEN', 1, N'UHZ57', N'QW2RO', N'9QR6Z', '2001-05-31', NULL, 3, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (8, N'mdexdtFbeNT', '238832802785', '2000-07-12', N'TFQJXSEJRZ', N'EFNZF', N'NKFYY', 1, N'T4937', N'DU5I2', N'H64F6', '2015-07-03', NULL, 4, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (9, N'jftxjcMpBk', '609379967709', '2005-10-02', N'CPTVMOSZJG', N'PNWMO', N'SDGZF', 0, N'D6M29', N'9OH4W', N'P5AT9', '2008-10-02', N'Em', 4, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (10, N'NkeZCKYSJmuEANb', '005410482664', '1993-01-07', N'CYWWTWGTTT', N'ZGTWI', N'QGHMH', 0, N'0C14N', N'22634', N'KTFFF', '2002-08-12', NULL, 5, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (11, N'qHzSznoelmR', '495432315701', '2010-10-26', N'GLKUODWJBZ', N'KBXUJ', N'RWCNP', 1, NULL, N'XCFFC', N'200ZW', '2001-07-26', N'Con', 5, N'đã mất')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (12, N'fNSrvyjKUXV', '423395678249', '1979-11-12', N'UOGPHSGTAL', N'FYNHI', N'DXEXV', 1, N'99HUW', N'J1V73', N'O5Q94', '2001-02-27', NULL, 6, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (13, N'wsKyuWzMbXnRfZG', '157519834640', '1986-08-23', N'KXXKFRRMZG', N'VIPLP', N'LUIMJ', 0, N'UCO0C', N'4M2YF', N'E7955', '2006-10-29', NULL, 7, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (14, N'XtAHlSkGaB', '928379423155', '1991-02-09', N'EKROCVXUWA', N'PRNJV', N'BWVJG', 0, N'5K877', N'48N3K', N'89M6Q', '2020-01-12', NULL, 8, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (15, N'AkFYxisVoN', '030386000780', '1993-08-08', N'GBZRBJCSYK', N'YVDUX', N'OEUJU', 1, N'N3290', N'7L6S9', N'0I241', '2003-03-04', NULL, 9, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (16, N'EyufOZeITTbCeTA', '202869631689', '2012-09-23', N'XZMWMBLWLS', NULL, N'KOVGR', 1, N'XY83O', N'8O3AR', N'MW2VX', '2013-12-01', N'Em', 9, N'KARJW ')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (17, N'cAFGQMQGIbk', '778934103033', '1998-03-17', N'DXAXQBWNOP', NULL, N'YTVNI', 1, N'41KNS', N'V2674', N'I42EG', '2013-11-05', NULL, 10, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (18, N'MWVlPvTOcwUiUF', '790550330489', '1977-02-08', N'EXFDEXGDWC', N'TOJVV', N'ASSZT', 0, N'J82CY', N'JISIM', N'RG899', '2018-10-15', NULL, 11, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (19, N'LESWwcbFilRqSvb', '243511911015', '1981-07-19', N'SJSBURAOOF', N'RLIYK', N'TCBXN', 1, N'LL51C', N'486XK', N'5XZ38', '2001-05-30', NULL, 12, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (20, N'eFQRtgCkJDm', '032965651823', '2000-02-28', N'TXPKTXRWNZ', N'WXGPB', N'BWFLP', 1, N'L03G7', N'NFHC1', N'6699L', '2001-01-05', NULL, 12, N'DAXJZ ')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (21, N'UGLawQEMLrPvUNe', '355169371055', '1970-01-10', N'NZDYZBYPAW', N'JDVWH', N'EITTD', 1, N'MXZ8Z', N'FM5EA', N'44QF2', '2001-01-02', NULL, 13, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (22, N'ItuWAxWJzQ', '305680203506', '2000-10-08', N'QZOKQPUWYY', N'QRTUX', N'KEHBU', 0, N'7ZE33', N'EXUIZ', N'5P8CP', '2003-03-13', NULL, 14, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (23, N'znrJbmDKtNVaUlc', '911562083299', '2013-10-04', N'DSOVXJTMTD', N'JXOQA', N'JLZFJ', 0, N'X0TML', NULL, N'N5GCH', '2001-03-14', N'Em', 14, N'đã mất')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (24, N'lndjccgVQYGjzPL', '949555908004', '1978-01-20', N'LPOUCJAPJD', N'AKYWG', N'VYKZU', 0, N'VE85G', N'4RXX3', N'K3RR1', '2008-06-05', NULL, 15, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (25, N'MbcUJlkWXpNmNU', '496067399607', '1989-12-23', NULL, N'JBYPI', NULL, 0, N'NV7KE', N'01D8K', NULL, '2011-12-23', NULL, 16, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (26, N'xujQgVrvaSPSpkU', '310976084237', '2000-04-01', N'BUILHJQFEA', N'UIXSR', N'UQFZL', 0, NULL, N'282F3', N'556Y8', '2017-12-01', NULL, 17, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (27, N'wQvolfrzIOQLxCM', '488846806770', '1974-02-17', N'RTXIHRODRO', N'CGFVY', N'PDPFJ', 0, N'K06Q5', N'U58H1', NULL, '2003-12-21', NULL, 18, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (28, N'JmhVChugvKo', '190474773394', '2000-10-12', NULL, N'VRFGR', N'IALXD', 1, N'653X8', N'G1QMH', N'FE2U3', '2020-06-18', NULL, 19, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (29, N'mxHcKWBPBhDV', '421350826261', '1970-05-21', N'WPWUJUKAHI', N'RLBMF', N'UIGVK', 1, N'P5F5K', NULL, N'4D2Y4', '2007-06-27', NULL, 20, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (30, N'FormVIZRYaonW', '095048742880', '2000-02-15', N'HZFAIHMJGK', N'BLXQI', N'VEMKK', 0, N'C5R42', N'Q76T8', N'6BA01', '2018-06-12', NULL, 21, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (31, N'eTzVQrsCbysTOTb', '453433925601', '2000-04-06', N'VVXSZDIYWW', N'HCXEF', N'PRWFI', 1, N'NNQ2B', N'CT0KU', N'30VAK', '2012-05-05', NULL, 22, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (32, N'SsvQiCITANbJa', '532884511612', '2018-02-07', N'YNPAYHQWQX', N'QLVEU', N'OQRAU', 1, NULL, N'9RS0C', N'27PQ6', '2002-05-27', N'Cháu', 22, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (33, N'CVUrNjfyVmf', '139541464920', '1991-06-11', N'VTSYOIJLQQ', N'YJQYB', N'CNBXS', 1, N'2B28A', N'2D06G', N'GASSB', '2006-02-25', NULL, 23, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (34, N'vVhHqKuiwUVx', '733656383284', '1997-01-07', N'MTXOZRZZEF', NULL, N'HRXJP', 1, N'0DB57', N'7FM60', N'ZBE8J', '2018-08-22', NULL, 24, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (35, N'OIpmfhYzUyINTUV', '049516035230', '1982-12-28', N'IMVMEPWIMM', N'GJHLT', N'WDIZK', 1, N'9UC47', N'806Y4', N'5731A', '2001-01-08', NULL, 25, N'GCPCR ')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (36, N'GKpQUZrQAbph', '090691814387', '2003-08-21', N'FXNPCYACBD', N'UMAWZ', N'MZCKC', 1, N'2M2V4', N'574P8', N'62116', '2008-01-03', NULL, 26, N'CCSPF ')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (37, N'xNNTEvaGbN', '273150059546', '1975-07-02', N'FNUKYMHRTK', N'NVAHW', N'AQPKZ', 1, N'I9B51', N'8ACJ8', N'146OM', '2015-10-11', NULL, 27, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (38, N'sTVGevcXDsldu', '582633093963', '2007-12-04', N'JKEOVIWKNZ', N'DYTCM', N'VFISK', 1, N'8P13P', N'9201F', N'248A7', '2013-04-18', 'Con', 27, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (39, N'UkkIyTXSUAKwE', '992312641293', '1970-01-04', N'CUMYFDEZHT', N'AXKBZ', N'OZNXZ', 0, N'EI32I', N'28O21', N'7T63B', '2004-05-24', NULL, 28, N'UCYPI ')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (40, N'EnJMSuFnVZq', '993733506356', '1983-02-27', N'REAOFMQBMF', N'JKBKG', N'JFFKT', 1, N'N9H3O', N'4N1U2', N'68027', '2001-01-10', NULL, 29, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (41, N'qgBlCTNzBxik', '541200220412', '1971-01-25', N'SSNWHXHGKP', N'WQPOB', N'SECOI', 1, N'00306', N'RC5KZ', N'BRG26', '2016-03-17', N'Vợ', 29, N'đã mất')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (42, N'XOOOFEHUYVgmwnF', '758482452038', '2001-09-02', N'RZXESVJMRP', N'MXKER', N'HARSY', 0, N'9S3G4', N'74581', N'58RR9', '2006-05-08', N'Con', 29, N'đã mất')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (43, N'kksXDjNytI', '937072083565', '1972-07-30', N'XJGSMLOPGO', N'THVWM', N'ZTGUZ', 1, N'UM8GI', N'7266L', N'1C9CE', '2001-02-18', NULL, NULL, NULL)
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (44, N'iFTyCuqiPTNuM', '365485983616', '2010-04-28', N'CANIHKABWB', NULL, NULL, 1, N'2F1W5', N'38300', N'143G1', '2006-03-02', NULL, NULL, N'đã mất')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (45, N'LRXJludRFYMHq', '595730769472', '1970-01-04', N'TGIEAFHJMI', N'QIBAR', N'RGDFM', 0, N'ANI6H', N'JM208', NULL, '2002-09-04', NULL, NULL, N'đã mất')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (46, N'GGtoyCYXDkgaRf', '135087474679', '2005-07-16', N'ITFLCNKLWC', N'WSCIM', N'HDCVP', 0, N'88PS5', N'31821', N'8K5BT', '2006-02-23', NULL, NULL, N'JDGVK ')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (47, N'gjONHIVVLQfHV', '920063134623', '1971-07-09', NULL, N'AUACD', N'XHBXG', 0, N'15949', NULL, N'X1X2E', '2020-12-08', NULL, NULL, N'UDUCE ')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (48, N'NmPvGamwQefiC', '153305140825', '2013-06-29', NULL, N'SWUTN', N'UYQNZ', 1, N'NWO7B', NULL, NULL, '2021-02-03', NULL, NULL, N'QDYPS ')
INSERT dbo.NhanKhau(Manhankhau, Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa, Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) VALUES (49, N'nZTVhXHojFEWIm', '558606137413', '1970-10-18', NULL, NULL, NULL, 0, N'XK73L', NULL, NULL, '2020-05-18', NULL, NULL, N'BEMVM ')
GO
SET IDENTITY_INSERT dbo.NhanKhau OFF
GO

--
-- Inserting data into table dbo.Sohokhau
--
SET IDENTITY_INSERT dbo.Sohokhau ON
GO
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (0, '0V', 8238, 0, '1992-11-03')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (1, '3V', 1203, 4, '2018-07-21')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (2, '0Z', 9525, 6, '1984-08-12')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (3, '5R', 8222, 7, '1971-11-09')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (4, '0W', 7359, 8, '1991-03-16')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (5, '7N', 8388, 10, '1971-04-11')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (6, '2K', 1211, 12, '1977-03-28')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (7, '8B', 6561, 13, '1980-10-16')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (8, '6S', 8745, 14, '1972-09-19')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (9, '0H', 8776, 15, '2015-10-24')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (10, '8P', 3511, 17, '1975-11-15')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (11, '8O', 1768, 18, '1991-10-03')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (12, '5A', 8739, 19, '1979-02-07')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (13, '2R', 3508, 21, '2002-08-28')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (14, '0W', 7686, 22, '2001-11-24')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (15, '6R', 5849, 24, '1970-03-24')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (16, '8M', 1852, 25, '1972-04-20')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (17, '9A', 3793, 26, '2005-07-27')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (18, '0R', 9159, 27, '2011-07-31')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (19, '4Z', 9939, 28, '1972-04-13')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (20, '6O', 2055, 29, '1992-02-20')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (21, '7R', 2417, 30, '1970-01-16')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (22, '2J', 8643, 31, '1977-09-18')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (23, '9N', 1672, 33, '2016-03-08')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (24, '1R', 2447, 34, '1990-07-24')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (25, '8A', 7562, 35, '2004-11-15')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (26, '6F', 4656, 36, '2013-10-08')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (27, '2X', 8931, 37, '1970-01-01')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (28, '6K', 2251, 39, '1973-07-25')
INSERT dbo.Sohokhau(Mahokhau, Sonha, DuongID, Chuho, Ngaycap) VALUES (29, '8L', 2417, 40, '1979-12-16')
GO
SET IDENTITY_INSERT dbo.Sohokhau OFF
GO

--
-- Inserting data into table dbo.ACCOUNT
--
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (28, N'00A848KWUQ74', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (23, N'T3NO40JEX3LQ8SI15W4575I527TR7', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (25, N'D76X', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (1, N'E9DL2Q507C02627871M5', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (12, N'U1V6N9SG2NVDS533QY504HS12T6S09DCX7JHN4N3USVKCUE720Y0KCZD65Y4N545K4X0R7Y67CRQ', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (8, N'375M54', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (30, N'0E85J6W', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (49, N'5W4CL4223', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (5, N'I7H', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (45, N'DXG4M0URM6UIXN059MTLU99367KD9216JD8VU80I57QU41H49474I0WHSO7SGD3428T1A', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (32, N'F3CLW0U217ZX2J9SXI353FTIF7UNCF2P7CN8', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (39, N'9L207Y4F2D3O6EMT4PK3WA6GIIR6GOGUM54SAW41LO0UKL5814IX1O71ZC96A9', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (18, N'8Z8S9IGU6O50U1IAA', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (43, N'777F', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (13, N'2SB01O1IT330O21X15M0B4QEAX49EH211YJL4H341LZ40TC5C7PG5N4YS7F6ZIXT149K942QUZ6N3G7632CLG33C8EE2IX4I0Y0K', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (24, N'K7N7N7W76R03385QKV4Y', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (19, N'P6EAYX81HP58SXI1W66OIN82PZ672ZD41GMFJ5X131S5E68A803V45F97UC0PS35C8V922V59AHM56V5XSII893325QRXI8671X6', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (35, N'D2Y07D2SLT9', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (15, N'10K25D', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (15, N'WU', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (3, N'6JXJIE33671X1SYAN31Y62537MI7W', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (28, N'KJ88AJ71118K9291CAK98MAKR327GX76O30515FR6V21US4', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (32, N'369982FY8J9493Q4OW5W9H7W01EWCTQ3Q06829O6NJJ9', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (9, N'37LQX4M9S3W5ML6QB4922R6EGRC1J5TUCI1D', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (29, N'37NG8KK9DQSDML1X5621446AH1PC228921LT0892EZWC9LS7150185VP7KS9O657P92URTVWPH8KAOZYD', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (37, N'366HMZWUOJB4ND1NLQD83TF2NY', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (33, N'HG4VX7L5HK9MB', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (8, N'U0Y3417YNW0V52D7S186131E2HS3W176X29J36NM8WW0G18K2PNX3LE42K573AD99653', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (12, N'G5WLZ3T58W9P34', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (6, N'5', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (22, N'A30OLKM537RI1VITOZL0564S6R4', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (29, N'O0R372SJ3Y0LO4UVB3IY53MQ', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (24, N'L2Q8T42UC16NI2B88LR1KQ62896IH2E448AH0P53M9', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (45, N'630QHR78VAERTYKRW042M8501XSUXFPFOWZHEQ', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (40, N'0IO9T', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (39, N'LH8A4NPRE1UI45', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (14, N'2ND875OJHB69A88HR', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (21, N'3JG09I', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (3, N'42ZUW8L', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (2, N'2V4JLQV7247V3J6LV8B3T9Q5KCEZJ3CX2I26706L44J19GEK459699YX9M0NLLEU86CS1L3TE5SZ899A0S24Q6CX03BGSY', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (22, N'54Q25CW0SLCCQC0HRL1714T2MIL722I50484GHYA1ECB5F5A2SR5YRZE35C9VPX59D2CFTKM', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (28, N'B7DEQACWB5S9G8U342G5619474919313O276303QC6432RI1U79A0T9Q9HQHB9N79FQ1BCA587X58', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (31, N'QNELA45272SM30561B982TEVCKDC8', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (21, N'PG51', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (8, N'30SWCC8V88B8MH2CJR43KK1BZ00Y9770L55RSXTQ5N4CV0', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (33, N'V48ISL250179R38MPYV08C06U2O886U75070BJ2', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (31, N'0B98O5', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (5, N'3738SMMB1TIE33UQG9456S662GT6S16YT86229RNN843V48U8C2B', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (21, N'2OR1VSSC5B29TPXL038MA20584G8ZB8V', 1)
INSERT dbo.ACCOUNT(Username, Password, ACCESS) VALUES (28, N'9XJ8TZX9M4O81WIFY99PF49TRJT', 1)
GO

--
-- Inserting data into table dbo.Giaytamtru
--
SET IDENTITY_INSERT dbo.Giaytamtru ON
GO
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (0, 6, N'70G8E5C66B0777U', 21, '1986-01-31', '1991-12-19')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (1, 7, N'14366CA54E9I9FD', 0, '1970-01-07', '1981-10-21')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (2, 26, N'T06SZ2U7G3PC1U8', 26, '1970-01-09', '2013-03-08')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (3, 24, N'39FVFI4T57W21NQ', 21, '1975-03-15', '1992-02-18')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (4, 0, N'CCQ1Q2854IGH2RN', 38, '1970-01-01', '1975-06-21')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (5, 27, N'10HX7LN72R1046U', 29, '1976-11-28', '2001-07-02')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (6, 20, N'GXS16548BMMNN01', 45, '1998-02-02', '2010-01-17')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (7, 2, N'64X05Z0A326625S', 37, '1978-07-21', '1985-06-25')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (8, 11, N'H9KWM4JERNIA61R', 16, '1995-03-17', '2019-10-20')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (9, 20, N'33002B0J93ZQHWG', 45, '1996-03-24', '2005-06-03')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (10, 13, N'6994H5EI8097P20', 47, '2006-12-04', '1990-12-31')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (11, 26, N'46UEEWR3Q08Q8J1', 15, '2006-03-16', '2011-10-16')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (12, 7, N'K0KJ36MPJN1GG82', 2, '1971-11-21', '2018-04-04')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (13, 10, N'01P0VN59J16J07Y', 9, '1973-10-15', '1972-07-11')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (14, 11, N'1A8C84F0H6K6849', 42, '2009-10-28', '2017-12-08')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (15, 22, N'J3168749HFK7135', 46, '1972-02-02', '2016-06-29')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (16, 24, N'KO274E83NDH5CPK', 22, '2005-06-04', '2011-03-05')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (17, 23, N'WY3030PY7F41764', 7, '1970-01-03', '2019-04-29')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (18, 22, N'623662HDY9CU1XE', 31, '2008-09-26', '2003-10-31')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (19, 2, N'5MCA0Z679YR53EA', 44, '2014-01-09', '2008-12-11')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (20, 13, N'W2VEO818PTR78Q2', 0, '1971-06-09', '1973-04-26')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (21, 11, N'SK3E1HLK31NY00H', 35, '1970-01-05', '1975-12-07')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (22, 11, N'8O07UJG754OT298', 7, '1970-01-02', '1992-09-25')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (23, 12, N'5K474Y10TH72VJQ', 11, '1989-02-06', '2019-11-29')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (24, 6, N'2HUM861YXR68T2V', 23, '2013-08-27', '2017-09-19')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (25, 12, N'6RB34T5P806RHLD', 26, '1987-01-31', '2001-04-20')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (26, 10, N'4JBI6OUI315M6X2', 33, '1972-06-06', '1994-11-20')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (27, 9, N'RYM37Y08R1ZXAM7', 14, '1970-01-02', '2017-10-12')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (28, 26, N'000M64B8L9K9V7G', 11, '1971-07-02', '1975-02-13')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (29, 26, N'7RBR1F20P5GH974', 20, '1974-09-04', '1974-08-29')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (30, 2, N'M02QW20I1Q06X1F', 1, '1988-02-05', '1992-02-23')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (31, 25, N'VEX224VUP2MOS44', 43, '1973-11-24', '1999-12-14')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (32, 8, N'94AF782805AJ2KO', 16, '1971-06-09', '1993-06-07')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (33, 27, N'9Z13008B1ZVT39E', 8, '1997-10-31', '1970-06-25')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (34, 28, N'O30F18X976U80IM', 6, '1970-02-23', '1981-07-13')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (35, 18, N'4XEOQ07PZ2B4AH5', 33, '1972-06-10', '1973-11-14')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (36, 3, N'SW568V1U9K6W09R', 43, '1978-11-29', '1996-10-24')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (37, 19, N'74H718YWT835CW3', 39, '1970-01-07', '1977-03-06')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (38, 22, N'E26A56709L868Y2', 5, '1975-04-03', '2020-06-03')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (39, 10, N'PF2CUELB30R98H3', 33, '1970-04-08', '2013-07-19')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (40, 29, N'S8EB2LPKLYFQ9N2', 24, '1982-01-22', '1990-09-22')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (41, 26, N'BHP1ZT065O10MJR', 13, '1975-04-02', '1979-02-27')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (42, 1, N'HXJ21S2CU6GC2F8', 8, '1971-06-16', '1977-04-17')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (43, 14, N'783UQH9C8Z2PWH5', 49, '1986-12-06', '1970-08-15')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (44, 13, N'65H0EQB11O2A684', 2, '2010-07-02', '1983-04-27')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (45, 6, N'UF9QA4G6DW99HK8', 34, '1995-11-07', '1970-01-08')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (46, 7, N'6L3NQP0RCL8XO7I', 46, '1970-11-01', '1971-04-14')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (47, 7, N'5ZL24000H8P0170', 46, '1988-03-11', '1970-01-07')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (48, 21, N'GA3KP9YQ78NZ775', 7, '1975-05-10', '1970-04-06')
INSERT dbo.Giaytamtru(Matamtru, Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (49, 6, N'501RNK1Z5KV6YVR', 24, '2009-03-23', '1982-10-04')
GO
SET IDENTITY_INSERT dbo.Giaytamtru OFF
GO

--
-- Inserting data into table dbo.Giaytamvang
--
SET IDENTITY_INSERT dbo.Giaytamvang ON
GO
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (0, 45, '2005-06-15', N'HKASTXACBB')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (1, 43, '1994-04-07', N'TTPQDKBZGL')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (2, 25, '1989-10-16', N'RBRDMRNQGR')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (3, 32, '1992-12-21', N'MLSHYZQLSP')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (4, 27, '2018-07-19', N'HUJRYCJFLO')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (5, 4, '1992-04-28', N'SJCBXCOTWY')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (6, 22, '1971-07-21', N'GWAWAZCAMX')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (7, 34, '1972-07-03', N'JHUXFCLVHY')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (8, 45, '1979-09-06', N'ETPNGDBYGS')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (9, 31, '2002-09-07', N'IYZFHEFMFD')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (10, 38, '2014-04-21', N'YEUTKPPQOL')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (11, 12, '1970-01-31', N'BLNHAQBABE')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (12, 7, '1982-12-17', N'BYQDEVPEVD')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (13, 27, '1979-11-04', N'VCJUIOZNRA')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (14, 6, '1970-01-14', N'WPLLPADTKB')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (15, 22, '1983-12-08', N'IPERLJPHAG')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (16, 46, '2009-04-22', N'JZFLWMMGZN')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (17, 25, '1991-06-09', N'TOMGKGFNZZ')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (18, 31, '1970-01-06', N'YJKARVXUHD')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (19, 37, '1977-12-06', N'EOSVOAHAAP')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (20, 48, '1992-05-20', N'KPDTDTHONU')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (21, 27, '1979-05-27', N'NTYAAEFICL')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (22, 36, '2008-05-02', N'DHXJTVVDJR')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (23, 12, '1971-10-09', N'FKKSJKGGDQ')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (24, 31, '2000-03-29', N'QAUBMRFOSO')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (25, 24, '2008-03-29', N'ZWPPICOSGQ')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (26, 48, '1994-05-15', N'FZIBIJLERS')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (27, 5, '1994-04-02', N'URXFYWWIVT')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (28, 3, '1990-11-29', N'NNRPBIVAFJ')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (29, 5, '1970-12-05', N'ZEJJQELXSP')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (30, 19, '1973-10-10', N'WWCBEWSMZS')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (31, 0, '1971-09-15', N'EZZBMYYSOV')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (32, 43, '1989-04-02', N'QVSUCCRATV')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (33, 11, '1987-05-02', N'MHSEDRGCHT')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (34, 3, '2006-09-14', N'YBZOUTHAMW')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (35, 36, '1970-01-05', N'WIUASIUSEA')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (36, 44, '1997-08-12', N'VGEUXNYCKF')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (37, 3, '1970-04-08', N'NEMZLSXAGZ')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (38, 30, '1989-05-12', N'HZELJHBVBQ')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (39, 19, '2020-05-26', N'BQMDXKJIKR')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (40, 43, '1970-02-27', N'SOWZWYJQDE')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (41, 0, '1978-06-15', N'VHCWSONWDX')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (42, 26, '1970-02-23', N'HNPSRIVVEV')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (43, 39, '1971-01-18', N'JTFTMUSZKH')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (44, 36, '1970-09-01', N'NGUVAFUPUQ')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (45, 30, '2004-12-20', N'JFBLRFZMQW')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (46, 24, '1984-04-25', N'OZKGPGWWAO')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (47, 13, '2006-10-18', N'FDGPTIXHHE')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (48, 35, '2011-05-09', N'WGSUDQNFMR')
INSERT dbo.Giaytamvang(Magiaytamvang, Manhankhau, Ngaytamvang, Noidi) VALUES (49, 11, '1992-04-21', N'ECFZDKAXHD')
GO
SET IDENTITY_INSERT dbo.Giaytamvang OFF
GO

--
-- Inserting data into table dbo.Nguoicachly
--
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'EXONZKPPSI', 12, 0, '2020-03-01', 32, N'EQGYQJKWCYXIHSY')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'LGHUDINILB', 28, 3, '2021-05-04', 36, N'SVVNLXEZKXGWMBD')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'ZVULUHXRRD', 31, 0, '2020-05-31', NULL, NULL)
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'PXRFALCSOR', 47, 1, '2021-01-26', 38, N'MNJWWOHMFEOMIVA')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'DEJCFKTYCI', 11, 1, '2020-05-05', 37, N'YMPDKYQQOINIKMA')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'PXMGEFONUN', 32, 2, '2021-07-16', 32, N'ZFQVSVNLLXZFUFI')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'XPQWJCUFAM', 3, 3, '2019-03-15', 3, N'YFNCJIRDDIKTBZV')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'MADWIKLXPO', 3, 1, '2020-11-06', 14, N'FKFOKIEBRTGPTEI')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'GBUUIWUJTU', 18, 2, '2021-06-25', 41, N'ICWTWOFNJMBEYQL')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'XCBLJQKXIU', 0, 0, '2020-09-12', 40, N'BSHKXWQTSZZKNCY')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'NGLTFLRSLI', 47, 1, '2019-03-09', 30, N'SWQFWUNTUJYHBEI')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'FWNCMFOHMT', 45, 2, '2020-08-31', 22, N'VBTYIFWLMOYXJQT')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'CCUKBGWHZG', 46, 3, '2020-09-04', 5, N'QUSRGYBFAMZTKZP')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'QUSGXZQNYX', 25, 0, '2020-10-11', 28, N'PTHPEYPJKNKCERB')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'NQWQBNDPWP', 9, 3, '2021-04-01', 21, N'MFTUOQTUZLIVPOV')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'VQLZFGCFNH', 38, 0, '2021-04-10', 16, N'HDLGMSZZKHUOIAX')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'UOBPYPSPUO', 18, 1, '2021-12-01', 48, N'PGXPFETQFJSRIGC')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'BHSLWAFABN', 23, 0, '2019-01-03', NULL, NULL)
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'WDGJWXCQQL', 10, 1, '2021-05-11', NULL, NULL)
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'VVBVPWJDZO', 41, 3, '2021-03-07', NULL, NULL)
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'OIWBTNCLSV', 0, 3, '2021-11-20', 0, N'ZFUHPOLRXCWBFDV')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'TZOKGZKWHS', 22, 3, '2021-06-07', 6, N'BOBYRBNIGZTVXPC')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'CTZRULWEOK', 24, 2, '2019-06-17', 31, N'JDAOSEWJCUZPMOQ')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'DKBNZEGIEM', 23, 1, '2021-09-01', 20, N'TWKWCXMVVXDZMHQ')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'LNQGHICEXX', 31, 0, '2019-09-21', NULL, NULL)
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'NVVRNQUTXC', 6, 1, '2021-05-12', 29, N'DRFSZVJPSGCKWXS')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'EBSDUVFLEB', 33, 1, '2021-03-19', 48, N'FTSBMGVSRDTKBER')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'FTENKQMXMZ', 23, 1, '2020-04-29', 30, N'UVHFRXFAVILFRHJ')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'GCKRMSJJZX', 24, 1, '2020-10-22', 31, N'XMIMBYCJBRNQSYR')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'IWYNUQZVAA', 1, 3, '2019-04-08', 36, N'QRUHNRFHTCVWMJJ')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'WBLSPBWDKR', 15, 1, '2020-10-03', 31, N'CZAJWSKWTKIJJAE')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'SVQIGXFBDY', 24, 3, '2020-11-06', 18, N'YKQNXPUXIFRUTHM')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'HZNNSVSFMR', 24, 1, '2019-10-25', 37, N'JCOLLENFJVKVUMT')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'FLFKPXBOQE', 23, 1, '2019-07-22', 30, N'LUMTQNOUIUNVZYL')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'YYBGYTMDGX', 27, 0, '2019-03-28', 24, N'GKELATJJERZWNTR')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'DXOGMLSWAX', 23, 1, '2020-12-28', 41, N'YIVIFFWPPLUHVMF')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'BPCJFFWHUB', 10, 0, '2019-08-30', 3, N'OZLRIQHNPKLBKNW')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'NATQZFLGXM', 22, 2, '2019-06-30', 36, N'WYRLPHRPPWMNHTW')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'FDVMRPSTKU', 38, 0, '2019-04-18', 23, N'HSBPSRDUWQVQDUE')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'HHZLJJNGXP', 26, 3, '2021-02-14', 42, N'RBFLXCGNNEODFOB')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'DFFOKQAJON', 42, 3, '2019-03-26', 43, N'CEYHRNHZNGGQJXC')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'FHMVSDOTMK', 48, 2, '2019-01-09', 43, N'NXRWOWMGFZHYILG')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'DLGOQSMXNW', 13, 1, '2019-03-27', 24, N'QEYOAIAQTRFJZLR')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'LQUPJNZCDH', 6, 0, '2020-07-02', 49, N'WLFTUHKMWLEOWAC')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'VTXUDZKLME', 9, 2, '2019-10-30', 49, N'RTJLKBSGUPTQVRT')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'GIIIGJBUBA', 12, 2, '2020-11-08', 29, N'RKHYAGUHKVFWFHL')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'ILJRUJPNEF', 19, 1, '2019-11-26', 7, N'KWDTDJBZVDKYDNN')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'SACBZERAFY', 25, 3, '2021-03-08', 36, N'VSJNJMODIIOJJOH')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'HRWWOXIHNY', 36, 2, '2019-12-25', 28, N'ZASEHDPUSKUEABI')
INSERT dbo.Nguoicachly(Hovaten, Manhankhau, Mucdocachly_F, Thoidiemcachly, Mabenhnhantiepxuc, Khuvuccachly) VALUES (N'VRGIPMYTXH', 5, 0, '2020-05-12', 23, N'KTYNPOETKVRXPBZ')
GO

--
-- Inserting data into table dbo.PhieuChuyenDen
--
SET IDENTITY_INSERT dbo.PhieuChuyenDen ON
GO
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (0, 33, N'XTWPILHEGHLUQBK', '1970-01-01', N'JJQWHKTOUU')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (1, 12, N'JZNXZHWPDIQGJVN', '2003-07-07', N'IFXMHWDCFT')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (2, 40, N'QLTBGBJPJPDLNHM', '1993-09-10', N'OAQKCHGQBI')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (3, 6, N'UASBSVTXCBKGEUP', '1997-04-27', N'FWXUKSMAGW')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (4, 42, N'TUONPKFQAFJXHJM', '1981-02-18', N'UZAUITNLSI')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (5, 27, N'DOKQWRYAYZPKUAT', '1983-10-31', N'VHKIHGOGPO')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (6, 3, N'JRCEVNXJSBEXUYQ', '2001-09-01', N'UIDJBSRLNS')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (7, 27, N'NTSQUJCDUIHXTZN', '1970-01-06', N'DEKECPBROL')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (8, 44, N'VOVXTHAHZJBWNGZ', '1970-01-09', N'QBCUEZJNNU')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (9, 31, N'YJLIZXEYLEKIRIQ', '2016-08-27', N'RDUDNMDFQB')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (10, 23, NULL, '1970-03-04', N'JGYGGBMUAI')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (11, 27, N'ZHCTOZPRJSZHWOX', '2005-10-21', N'WNGZLZLEQZ')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (12, 18, N'HPRRMCPPNJHGNUN', '2021-12-21', N'LVZIONVNPC')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (13, 17, NULL, '1976-07-05', N'EBOSGSVFHT')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (14, 8, N'HCRWVOJZDOSRAWM', '1981-03-19', N'EIRBZHPVPQ')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (15, 1, N'HTQAGAUYTOILZUV', '1970-01-11', N'WCBJDEDWQB')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (16, 27, N'WKPKCENYDFIFOEG', '1973-10-19', N'OUGHOKDYVR')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (17, 39, NULL, '2008-08-23', N'JBVQPFUYFH')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (18, 13, N'FAKWVSXAFOQFUJX', '2010-01-18', N'VXQQSJNPRC')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (19, 33, N'CFTIWHFTBPPQGEH', '1970-02-12', N'TBOFECRZEZ')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (20, 47, N'CCFPNEPUUOWMEUH', '2000-08-23', N'RXTEREFJPL')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (21, 38, N'SIINWSGYFWOKKQD', '1989-05-27', N'YJGNBMCKRN')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (22, 19, N'WMSECXJKAZCJBOO', '2002-05-24', N'XYHCIERLJQ')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (23, 15, NULL, '1979-05-19', N'GZUDMBVYXZ')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (24, 22, N'OOWZTOLKNQIPWJP', '1998-04-19', N'KALISKWYGH')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (25, 24, N'ZKVCJXRVXNXRFTO', '2003-06-23', N'LBLPSNCMTU')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (26, 33, NULL, '1972-07-25', N'WHQPJMVBVT')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (27, 44, N'CMBUBJCSAVYZMCU', '2001-12-22', N'WLJXRWTCDI')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (28, 15, N'YGKIKGXBQBBPNVR', '2003-02-22', N'TGVMHBVTKJ')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (29, 10, N'GJIPGZRKINVEWXN', '1993-06-09', N'NYKPWGPRYI')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (30, 24, N'AMSFEPLYEPUQYOO', '1971-12-12', N'EQHKVVLOJE')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (31, 33, N'JQSPYCLGRZLVGXQ', '2009-12-23', N'QVJYOFIYHR')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (32, 17, N'YKOVYAFSBRUFVSH', '1995-11-04', N'LJQJWMJSTZ')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (33, 44, N'LYHEROCHHVLLWXU', '2017-07-05', N'IVWVZUWTYG')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (34, 27, N'XYTSDPQJNSSESWR', '1991-09-13', N'SPUOQARVRD')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (35, 48, N'BEKPFPVSMAQDSHE', '2012-09-23', N'IFYHZQIRUP')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (36, 31, N'UQZMAVZCJWJSFKX', '1970-01-09', N'PLZDEJCNQO')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (37, 24, N'GWKVQHDFNTCXPQD', '1971-12-21', N'ATOIRSNXSY')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (38, 15, N'CYGWWHUPUZSBVKZ', '1976-07-25', N'USTOTNGCCY')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (39, 37, N'HNRZFCZDGVNKZYG', '1970-01-02', N'RSJMPUZVIA')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (40, 45, N'MRZHTRUOCRYLDPC', '1980-04-21', N'QODJOYHPKV')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (41, 23, N'BFNBCYLMCPBBVUO', '1970-01-05', N'GFEJGMZCWQ')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (42, 46, N'ZCXWNGLCMWGNTRM', '1970-02-26', N'AJGQJCHCFY')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (43, 22, N'BDDBNYDCOLYFRZJ', '1986-08-04', N'DFYBELUDCQ')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (44, 43, N'TCETKPFYBBSWCRX', '1996-03-11', N'WHQFSSIBEE')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (45, 19, N'JBLIPCPVROUQUBA', '1992-05-10', N'ZAMGTECHMM')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (46, 32, N'VZZVEAVWVAOJSGA', '2007-04-06', N'MDWJPGGPHP')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (47, 31, N'DBUFLOHFCTUCOZB', '1989-06-16', N'EAXYTKVFOZ')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (48, 42, N'YWFSNCWQKKFPORX', '2015-12-04', N'NVKJHXIDGJ')
INSERT dbo.PhieuChuyenDen(Maphieuchuyenden, Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (49, 32, N'HSAAAOHUACUUTSE', '2018-01-06', N'ZLRALSMPVT')
GO
SET IDENTITY_INSERT dbo.PhieuChuyenDen OFF
GO

--
-- Inserting data into table dbo.PhieuChuyenDi
--
SET IDENTITY_INSERT dbo.PhieuChuyenDi ON
GO
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (0, N'JUDMBWMOHGBHZHI', '1992-11-06', N'CDZFEQNLIQVHMHZ', 26)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (1, N'FLMETAXEQFMMDUF', '1997-08-05', N'XMPDHCZXMPHALXS', 38)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (2, N'ILJYQCLRBSXAUBT', '1979-10-22', N'FJCDMGHFQFUWYSR', 5)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (3, N'JZREBEYBPJPFRXF', '1972-04-28', N'KJGFLPRJXCZYSBI', 8)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (4, N'FRXFJYLKUINLNPT', '2011-12-17', N'GTMLERXAROOCOXK', 35)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (5, N'GIVJZVCQAMJDTTS', '2011-11-18', N'NGGYQZJZJLQTXLF', 31)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (6, N'JOPGRTPDJUPHXKQ', '1987-01-12', N'YFJLPQJUAPHVYWE', 25)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (7, N'TQYCUPSQJHWWJMO', '1998-02-21', N'TWHXRYITMGYNERW', 39)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (8, NULL, '1980-04-20', N'YKMTIECSMLPOHQN', 24)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (9, N'GCJISOHRIZZEJUZ', '2010-04-12', N'YTFOZQIDTMOZRJH', 4)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (10, N'TLNXCNVRLGSFTXT', '1972-12-16', N'FECUMMZGHQQPNDO', 17)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (11, N'BYXOJDDWWLMCOJI', '1980-12-17', N'DPHUBVMPKVVQZTS', 34)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (12, N'LNCVYWHKWLNWCJQ', '1978-03-21', N'PYOLUHGRSEILXGK', 20)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (13, N'MEMBRJKPMZFFMNO', '1976-03-27', N'QTKVQYIENBIFMRN', 2)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (14, N'FJRQPCXCXXHLZNJ', '2003-08-21', N'PVLAKESMMWKJHMT', 3)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (15, N'MVSYTQTZNMJHACE', '1971-11-20', N'PRPJWHVAAWKIYXB', 43)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (16, N'DFOMPHYBNSUAUJS', '1972-06-07', N'GZSVZEIHURMTPVK', 35)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (17, N'NTHOBLEXCXSOGVC', '1996-04-01', N'XKNTITOUPPGODZU', 41)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (18, N'MGEVKJAQRHJUCRR', '1978-06-30', N'ANFTWPMLAXIEOTF', 38)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (19, N'CUFQTEJMMDLCSPO', '1983-09-24', N'JNCINQPDRCYWNRX', 28)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (20, N'QHDDGENUBTPWLKP', '2000-09-10', N'RQCIJQHRPDYOMPS', 43)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (21, NULL, '2014-03-06', N'ZPLMZMRFMIKJPYE', 12)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (22, N'ZIZMRAMFGMEHBXF', '1988-05-30', N'NVXWQKWQOAJDEIC', 30)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (23, N'XDTLVAMJRMVJXPG', '2009-07-28', N'UTWQBDSPMZUIVQB', 31)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (24, N'FTENYWOEJFFAKYU', '2014-03-03', N'HXCUTYILCJGPTVN', 1)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (25, N'GCADDABRNYVQTRY', '1988-09-08', N'ZNLZHDTQOIUBVTB', 4)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (26, N'EOLVDSCTRRRMQRE', '2016-07-08', N'HHXFOCJYSQBRWWN', 41)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (27, N'QVWSCTUISEKHSDS', '1970-03-09', N'NFNBZOULVAJQGFK', 39)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (28, N'GMBEQXVDHUMJLXN', '1970-01-04', N'TXJAKWQPRWHPPSC', 19)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (29, N'XZJZELOAKSQDHZU', '1972-11-02', N'PAKDLBMPPNRAMDS', 9)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (30, N'WQGKOFZBWSZRXLR', '1990-03-08', NULL, 17)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (31, N'HQQJODQJEBNPJNL', '1974-08-20', N'RLLYLUFYKBSNLBW', 26)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (32, NULL, '1970-04-05', N'NEYSRJSRORNWCLE', 3)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (33, N'AWUIBDGDNVKLMUZ', '1970-11-27', N'SOBIEYLEHEQEYGS', 17)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (34, NULL, '2003-07-31', N'WXMVBONCMKODUCG', 46)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (35, N'REWPNLJBPBWFNUJ', '2013-08-26', NULL, 35)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (36, N'VEPFALCMTBWTPWW', '1975-02-06', N'DBSIEGLGEQKVEBU', 30)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (37, N'QKCBUTRTKYSCLBB', '2009-11-25', N'KQPUZQNVHVDJWLZ', 9)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (38, NULL, '1972-08-02', NULL, 1)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (39, N'IUTLBDBFEFWRLYY', '1970-12-24', N'FNZLQSAHCOCHZDS', 42)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (40, N'ADWHQQETGVPYNWY', '2008-03-14', NULL, 47)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (41, N'PYJXHHNIHQPTDYD', '1987-04-18', N'WLEFFYGSRXRSISJ', 19)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (42, N'DORPYVMLQVKXHYH', '1971-03-13', N'GPJBEOKCEUDIIKS', 26)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (43, N'BDCMXNYDGNMHOMC', '2020-01-06', NULL, 9)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (44, N'OUPKKGCNWARZYOY', '1970-03-25', N'DYDPVEOLZLHQPYN', 0)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (45, N'NWHEOBVVQTNKRTF', '1986-08-30', N'UEPLRYHLXYSPRTN', 19)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (46, N'YWQRGRTDRHGMIIL', '1971-02-20', N'LLLIJNXPOAHRCYS', 5)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (47, N'BYYLQELZVFOPJWV', '1970-03-14', N'PTORXXPBHIRMGNL', 29)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (48, N'WDRYHPJOYGTZKKH', '2003-01-10', N'QBHUWZTCXNJQXZV', 11)
INSERT dbo.PhieuChuyenDi(Maphieuchuyendi, Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (49, N'KIHFXTRGMRTNRZG', '2020-12-22', N'RFKPDUURJGRKYJE', 1)
GO
SET IDENTITY_INSERT dbo.PhieuChuyenDi OFF
GO

--
-- Inserting data into table dbo.Thongtinkhaibaoyte
--
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'OELWTGWHUGVTSSQ', N'385214729523', 39, N'07161011609', N'ArnoldG.Ambrose455@e', '2021-02-08', N'OELWTGWHUG', N', khó thở, bwbui', N'QRXCDUBAWH')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'GWOPRDLFSOWJIJX', N'896989704164', 22, N'03106806999', NULL, '2020-09-20', N'VTSSQGWOPR', N', xbsby', N'JAQUYJCHWC')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'GIOGRINREAOLQWF', N'237473023749', 42, N'00395379358', N'Donohue@example.com', '2019-03-18', N'DLFSOWJIJX', N', xindw', N'HTMASNVEPF')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'EVXZFMLDVHLEHUL', N'526894771072', 40, N'09792737050', N'ijxgor627@nowhere.co', '2021-04-13', N'GIOGRINREA', N'sốt, khó thở, coysy', N'NSZBGDISOT')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'UBTGHKIIXPBHJWO', N'780464095533', 25, N'05978683785', N'Simpson68@example.co', '2021-03-08', N'OLQWFEVXZF', N', wknrk', N'YWFFCWXIAR')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'ZFZUOJGWTEWYJLI', N'748095349115', 0, N'09564867307', N'Shepard247@example.c', '2019-03-06', N'MLDVHLEHUL', N'sốt, khó thở, whvcu', N'VFGRYJCWWT')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'LUKYKWIZXYKBLXI', N'830792092483', 6, N'08884287375', N'Baum@nowhere.com', '2019-07-28', N'UBTGHKIIXP', N', nqpcm', N'JIWYFMZIDB')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'FSPYECEPCYKGJCV', N'339392416701', 39, N'07901010424', N'StefanySoto784@nowhe', '2019-12-26', N'BHJWOZFZUO', N', otvol', N'PUGVVMLYTP')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'UTXTUVILZILOTJD', N'934408599392', 37, N'05232207008', N'TommyeBussey@nowhere', '2021-10-24', N'JGWTEWYJLI', N', dmiby', NULL)
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'YPTPRAVHZONZCHE', N'720836776503', 46, N'07949972453', N'ddaub3@example.com', '2020-09-09', N'LUKYKWIZXY', N', khó thở, oqenk', N'OHLLEGZSQV')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'AFDNPGDYNGJPTKN', N'569180844802', 46, N'00294931364', N'LenNaquin948@example', '2021-04-18', N'KBLXIFSPYE', N', yummt', N'OPGGOKTWOQ')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'FXBUOAZZTWBAGQS', N'155404532724', 3, N'08604629965', N'LeroyWLoomis@nowhere', '2021-01-13', N'CEPCYKGJCV', N', tpkvh', N'MPTTKKPUMJ')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'GNKCPRAPMIUKEDZ', N'697659781214', 42, N'04605555522', N'Hartley@nowhere.com', '2020-09-12', N'UTXTUVILZI', N'sốt, khó thở, ydare', N'KSSHRJNLNN')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'QXJCBWRGAWOVVEH', N'191560423129', 40, N'09392921200', N'Abernathy@nowhere.co', '2021-01-12', N'LOTJDYPTPR', N', jyfgd', N'RDZAAFRPUD')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'URJPUQEKONJBJVP', N'845218484158', 14, N'00692923382', NULL, '2019-03-25', N'AVHZONZCHE', N', khó thở, grfrx', N'OZWZAYPCUW')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'KIZVAIUJQFLSCOM', N'318922712297', 35, N'04102702763', N'Delma.Oconnell@examp', '2019-12-16', N'AFDNPGDYNG', NULL, N'JMNABIXZBY')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'QKYMJJMFXLLTFMU', N'180938581019', 26, N'00970663257', N'Kelley@example.com', '2021-03-04', N'JPTKNFXBUO', N'sốt, khó thở, izves', N'PVNJQSTTUO')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'SYUISJFETUMJTMX', N'569895661723', 33, N'02534339595', N'CarlCronin@example.c', '2019-08-14', N'AZZTWBAGQS', N', ocvma', N'KMNTOVYABK')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'PINNRDPHCPSFYVU', N'037627916493', 15, N'09608496640', NULL, '2021-04-18', N'GNKCPRAPMI', N', khó thở, mroal', N'RUZKYTRBGG')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'XJRJAFMNRYUJDLV', N'267046319439', 25, N'04461581111', N'Henry.ZAltman@exampl', '2019-09-23', N'UKEDZQXJCB', N', iqorq', N'IMHNPMTXZF')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'SYXADKWXQGTKQTE', N'982485931337', 8, N'02629620250', N'TristanCisneros44@ex', '2021-03-06', N'WRGAWOVVEH', N', ho, khó thở, ngvjo', N'JSWCKGCKZZ')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'LNSHMDZJBFZNQDE', N'708469934224', 7, N'03907305637', N'Hyman.Creamer@nowher', '2021-04-07', N'URJPUQEKON', N'sốt, utywj', NULL)
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'YWDDMAQDMUZMTBU', N'190146092633', 35, N'05475174513', N'AlfredDuarte9@exampl', '2021-07-20', N'JBJVPKIZVA', N', lmvoe', N'OFIJLAARQS')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'UZKBTFIKNWYENMT', N'624839010375', 41, N'05927561496', N'gxyp844@nowhere.com', '2019-12-18', N'IUJQFLSCOM', N', onfas', N'LUYEJWXGOP')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'DCBGMOFWUMVBLBF', N'103617923872', 45, N'02073906131', NULL, '2021-01-12', N'QKYMJJMFXL', N', xvvpn', N'NUMXWZVIEY')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'PUPIKGWAQRNXUSK', N'853983759752', 20, N'09927112300', NULL, '2020-01-01', N'LTFMUSYUIS', N', ofzij', NULL)
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'OGFBMVHZHAHDVID', N'107446397384', 35, N'03372986383', N'Ackerman@example.com', '2020-02-05', N'JFETUMJTMX', N'sốt, jdnxi', N'STFTXRMIPA')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'RPZIVJFFAUGZSSD', N'329921085001', 28, N'08028217258', N'Benitez@example.com', '2021-12-01', N'PINNRDPHCP', N', khó thở, mjdpu', N'OFYDVGPICD')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'ZJUACAWVWVSECMX', N'243970579830', 8, N'05120348900', N'AriannaOjeda8@nowher', '2020-09-28', N'SFYVUXJRJA', N', nfdrw', NULL)
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'NCJXCBLMMOSJXRI', N'067551742824', 9, N'04490137366', N'wqax5623@example.com', '2019-01-05', N'FMNRYUJDLV', N', fpglr', N'ZCYVDCANFU')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'WZNWNFGELKQORRD', N'028126230878', 7, N'02086872225', N'RolandGerman@example', '2019-12-04', N'SYXADKWXQG', N', tyjkn', N'BASRUTODYI')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'VQTHAZJNTECNGUD', N'340401447228', 16, N'06403288742', N'Rojas@example.com', '2021-04-10', N'TKQTELNSHM', N', jflqy', N'SIGXJGPFXV')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'EFTFZEJJBFQJRYL', N'550388717060', 14, N'02341292972', N'yotoftpj4@example.co', '2021-05-17', N'DZJBFZNQDE', N', plkra', N'YIYWZVVXHV')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'WOVUIGYPMEVNOOI', N'264607418762', 46, N'05844516035', N'Allan@example.com', '2021-06-21', N'YWDDMAQDMU', N', khó thở, gzxmh', N'TTTGTOQNQS')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'ETDJOEEVFZBTYEA', N'623083722156', 22, N'02114805125', N'Abdul_Alarcon@exampl', '2019-01-20', N'ZMTBUUZKBT', N', khó thở, jwjdt', N'XNASTLAITL')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'RKYHJIKUYMMWDXM', N'532149847502', 17, N'08905115641', N'mtdcgowm.gqxl@exampl', '2019-01-05', N'FIKNWYENMT', N', gswir', NULL)
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'DGZJTDURWMCDHGI', N'295784008300', 49, N'03957788516', N'Halsey59@example.com', '2019-03-24', N'DCBGMOFWUM', N', tfkfj', N'ODHGWRITVN')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'LAARDEUXOKFXUBD', N'027276972300', 11, N'09829943293', N'Ferraro729@example.c', '2021-01-26', N'VBLBFPUPIK', N', ho, orsxn', N'OVQYNBIPRI')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'WJQKEVVZPHRTSNX', N'378598995635', 10, N'07049508786', N'Boothe@example.com', '2021-10-01', N'GWAQRNXUSK', NULL, N'WVDGKQHYEK')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'MBBSASSTDNAFMBB', N'146569817300', 6, N'00112000148', N'Adena_Ellison257@exa', '2021-06-02', N'OGFBMVHZHA', N', khó thở, ciwaf', N'BFDRCSPRAF')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'JEDTFFQHWIIVMTZ', N'681968351122', 45, N'01106401182', N'Tracy@example.com', '2020-11-22', N'HDVIDRPZIV', N', vhtfu', N'NICYBJVCOO')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'LWEHVXLVYUVAGHX', N'560227476723', 47, N'08634556628', N'pxajygbj.gelk@nowher', '2019-03-19', N'JFFAUGZSSD', N', ho, qapga', N'AMMOXOWMVX')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'MQXJTFJXTOKKMUJ', N'145470599107', 19, N'09406892010', N'JanieceBurchett@exam', '2021-04-21', N'ZJUACAWVWV', N', zenrx', N'RFXLCIQYOV')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'ERMYDGQEXEDOFWG', N'249071956882', 3, N'08078102925', N'Audra_Seifert@nowher', '2020-08-06', N'SECMXNCJXC', N', khó thở, omdxx', N'HRKOLCHTJF')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'BTRIRTVPMFOLQNI', N'650807195934', 42, N'08117108983', N'Norman@example.com', '2019-08-23', N'BLMMOSJXRI', N'sốt, rqouc', N'GZQWVRIACM')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'ANFIISJNDNYBGNI', N'940505611791', 24, N'08930031348', N'kzjyz4440@example.co', '2019-03-16', N'WZNWNFGELK', N', yvbjb', N'PEHMMHPDIW')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'VZQWYCRPGBCVOCU', N'166966846367', 19, N'03784273397', N'SuzetteAckerman@nowh', '2021-01-08', N'QORRDVQTHA', NULL, N'QMJHROEBYJ')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'MGNBQPAXURDGYNV', N'427500504599', 40, N'04686534802', N'Abbott@example.com', '2020-01-12', N'ZJNTECNGUD', N', jkjwq', N'WLRYGONLXU')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'PGVMAIGNWJBWAXH', N'293402904090', 5, N'00496816307', N'TommieStack@example.', '2019-11-10', N'EFTFZEJJBF', NULL, N'KQUVWUAVRM')
INSERT dbo.Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Thoidiemkhaibao, Noidichuyen, Trieuchung, Tiensumacbanh) VALUES (N'FJVIKLRFOGXQTMI', N'280992303855', 35, N'08863490600', N'QuintinHeadley664@ex', '2021-06-17', N'QJRYLWOVUI', NULL, N'IXSXCTIMRS')
GO

--
-- Inserting data into table dbo.Thongtintestcovid
--
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'JOBUDQCKTP', N'511677627205', 15, N'01351980419', 1, N'CSNOM', 1, '2021-04-23')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'KJIMEMFCFR', N'233917459770', 41, N'07206014963', 2, N'NPCBU', 1, '2019-03-05')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'VEHOJYIJKM', N'589585058523', 43, N'09267660743', 3, N'XHDID', 1, '2021-01-29')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'QTVIGOUVXH', N'544413646377', 41, N'02599341811', 2, N'INVRN', 1, '2021-10-13')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'SONBHDITPL', N'826336820735', 23, N'07801753755', 2, N'VENLB', 0, '2021-05-18')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'RKNPNPMYFI', N'595317412903', 15, N'05733072580', 1, N'EXKWV', 0, '2019-11-26')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'TETZUGRTFM', N'987746033455', 48, N'06604623225', 1, N'HFXRG', 1, '2020-08-17')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'TSTKLNPGBX', N'101121807473', 46, N'01461399006', 1, N'GXLGO', 1, '2020-07-02')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'TIPGNHPGTC', N'573599497873', 40, N'03145947105', 1, N'YHQBX', 0, '2019-08-03')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'IIUJXLDGGW', N'623792049868', 45, N'01925752747', 1, N'BTVUA', 1, '2019-01-24')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'GCQAQRSBXZ', N'975823787295', 44, N'08398532878', 2, N'AGECA', 0, '2021-03-14')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'ZCIKPQBJAH', N'614271009948', 47, N'07074228743', 2, N'MYOJN', 1, '2019-01-25')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'YWZJENUKQE', N'767889691394', 27, N'01344537047', 3, N'GTNYI', 0, '2020-07-25')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'HHGYARLVPF', N'552793833225', 33, N'06882898373', 1, N'ODJMN', 1, '2020-12-13')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'NDMHIHQYSK', N'677260483534', 44, N'08977130063', 3, N'LYBNU', 1, '2021-03-28')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'XPNQCUZYEW', N'144884098345', 32, N'04211902524', 3, N'WKYLT', 1, '2021-11-17')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'BKMCKLHUYF', N'741201039694', 46, N'00306918092', 1, N'EJGBQ', 1, '2020-01-21')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'OKUCBMSZMI', N'416524354633', 13, N'06516796080', 2, N'YZIHI', 0, '2019-08-12')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'QJYNRTNCCK', N'840625969286', 27, N'04603359597', 3, N'ZURHP', 0, '2021-08-20')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'QZNYNWKHFU', N'788331482381', 6, N'03287753517', 1, N'AEJXE', 0, '2019-10-22')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'TYCGLEREWT', N'858777275330', 41, N'07889661587', 1, N'BRQAJ', 1, '2019-01-06')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'WMMKWRNYZM', N'869481871442', 22, N'01831242249', 2, N'IZYXH', 0, '2021-04-16')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'OEICURMCSV', N'093729933139', 48, N'05622187685', 1, N'STUXL', 1, '2021-06-03')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'LLDDPXPENZ', N'921455136926', 46, N'04141024952', 3, N'SSAXF', 1, '2019-11-23')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'NWLHRTUKRP', N'502865305879', 45, N'04422483357', 3, N'AJIPK', 0, '2020-01-17')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'RWZLJIWMEC', N'792803413372', 15, N'06947041485', 2, N'BLVEF', 1, '2020-06-04')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'BFVWLNEVRC', N'302806712493', 34, N'02043605028', 2, N'AOVPO', 1, '2019-03-06')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'ANGCWVKINH', N'981767484934', 36, N'06167204021', 3, N'LGLCE', 0, '2021-06-24')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'KRLAEIYXOR', N'132453034880', 18, N'06331014195', 1, N'ARWHB', 1, '2021-03-22')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'JVXGJZMGOT', N'706104363495', 45, N'09062936541', 2, N'MZJPJ', 0, '2021-01-06')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'VVYJACSOIV', N'651483165900', 24, N'09485606120', 1, N'XOUHK', 1, '2020-08-24')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'XCPNELPPGB', N'066811531990', 37, N'06813916817', 1, N'WNRXD', 0, '2019-02-02')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'QUWIDPXYFH', N'008815231283', 6, N'05443432891', 1, N'UNUUL', 1, '2021-07-13')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'NRSWFMGJEX', N'675273129517', 44, N'08648192055', 2, N'JHMCD', 0, '2019-05-07')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'VDTRNTRSBT', N'134690056259', 33, N'00564488912', 2, N'JNYHB', 0, '2020-04-15')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'WQGXIZHZVD', N'503560704843', 23, N'09533416591', 3, N'CVWAH', 1, '2019-04-05')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'TGGSDZCVSG', N'887011514927', 13, N'09243657145', 3, N'MQPHA', 0, '2019-07-30')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'TQULCEICKJ', N'416854258006', 43, N'07027144540', 2, N'AVPGW', 1, '2020-09-27')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'JZHTYOWGXD', N'946206536078', 2, N'00506919441', 3, N'AZCLD', 0, '2021-04-01')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'DBXDFMIRKF', N'385937279317', 13, N'00628421189', 1, N'NKUUV', 1, '2019-03-28')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'ATYQTDDRTT', N'236675553893', 31, N'09902322065', 2, N'DLJYM', 1, '2020-05-13')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'PGLYLLHUCH', N'320462390831', 11, N'03027758858', 1, N'LTZQD', 0, '2020-01-15')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'RJCVZVBQIH', N'127799310411', 6, N'06957349161', 1, N'YDOVD', 1, '2019-01-26')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'SYVJXSNWAQ', N'486520710478', 12, N'07175527923', 3, N'HEUTB', 0, '2019-03-24')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'WVQWFJRSKR', N'569021883892', 3, N'08766401049', 1, N'IBJYZ', 0, '2020-05-13')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'RMUSRSTKPL', N'701731010353', 31, N'04123010640', 2, N'ILQAK', 0, '2019-03-02')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'CQDQIGUNEN', N'569182239238', 34, N'04549084382', 2, N'WVDKE', 1, '2021-09-21')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'SSQUFUYXXV', N'161834877453', 3, N'04514673580', 3, N'WOOVM', 0, '2020-04-29')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'EEYXCYYIOQ', N'047932191751', 21, N'03682109190', 1, N'WAVOG', 1, '2019-02-13')
INSERT dbo.Thongtintestcovid(Hovaten, CCCD, Manhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) VALUES (N'VONRZOLUAC', N'258637238302', 7, N'01389884830', 2, N'JMLUP', 1, '2020-03-11')
GO

INSERT INTO Quanlycovid19.dbo.NhanKhau (Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa,
                                        Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu)
VALUES (N'CanBoYTe', N'012345678910', N'1969-06-09', null, null, null, 1, null, null, null, N'1969-06-09', null, null,
        null);

INSERT INTO Quanlycovid19.dbo.NhanKhau (Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, Trinhdovanhoa,
                                        Nghenghiep, Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu)
VALUES (N'ToTruong', N'012345678910', N'1969-06-09', null, null, null, 0, null, null, null, N'1969-06-09', null, null,
        null);

INSERT INTO Quanlycovid19.dbo.ACCOUNT (Username, Password, ACCESS)
VALUES (50, N'1', 2);

INSERT INTO Quanlycovid19.dbo.ACCOUNT (Username, Password, ACCESS)
VALUES (51, N'1', 3);



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

ALTER TABLE dbo.Giaytamtru
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
ALTER TABLE dbo.Sohokhau
    ADD CONSTRAINT FK_Sohokhau_Nhankhau FOREIGN KEY (Chuho) REFERENCES dbo.Nhankhau (Manhankhau)

ALTER TABLE dbo.NhanKhau
    ADD CONSTRAINT FK_Nhankhau_Sohokhau FOREIGN KEY (Mahokhau) REFERENCES dbo.Sohokhau (Mahokhau)
GO

ALTER TABLE dbo.Giaytamvang
    ADD CONSTRAINT FK_Giaytamvang_NhanKhau FOREIGN KEY (Manhankhau) REFERENCES dbo.NhanKhau (Manhankhau)
GO

ALTER TABLE dbo.Giaytamtru
    ADD CONSTRAINT FK_Giaytamtru_Sohokhau FOREIGN KEY (Mahokhau) REFERENCES dbo.Sohokhau (Mahokhau)
GO

ALTER TABLE dbo.Giaytamtru
    ADD CONSTRAINT FK_Giaytamtru_nhankhau FOREIGN KEY (Manhankhau) REFERENCES dbo.NhanKhau (Manhankhau)
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
