USE [master]
GO
/****** Object:  Database [product]    Script Date: 12/5/2022 1:17:26 PM ******/
CREATE DATABASE [product]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'product', FILENAME = N'F:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\product.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'product_log', FILENAME = N'F:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\product_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [product] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [product].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [product] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [product] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [product] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [product] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [product] SET ARITHABORT OFF 
GO
ALTER DATABASE [product] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [product] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [product] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [product] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [product] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [product] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [product] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [product] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [product] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [product] SET  DISABLE_BROKER 
GO
ALTER DATABASE [product] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [product] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [product] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [product] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [product] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [product] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [product] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [product] SET RECOVERY FULL 
GO
ALTER DATABASE [product] SET  MULTI_USER 
GO
ALTER DATABASE [product] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [product] SET DB_CHAINING OFF 
GO
ALTER DATABASE [product] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [product] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [product] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [product] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'product', N'ON'
GO
ALTER DATABASE [product] SET QUERY_STORE = ON
GO
ALTER DATABASE [product] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [test]    Script Date: 12/5/2022 1:17:26 PM ******/
CREATE LOGIN [test] WITH PASSWORD=N'MkXyJl0hmZlCMII6GCdUIn6C1w7H7fkFi18XvzDhNiU=', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [test] DISABLE
GO
/****** Object:  Login [NT SERVICE\Winmgmt]    Script Date: 12/5/2022 1:17:26 PM ******/
CREATE LOGIN [NT SERVICE\Winmgmt] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/****** Object:  Login [NT SERVICE\SQLWriter]    Script Date: 12/5/2022 1:17:26 PM ******/
CREATE LOGIN [NT SERVICE\SQLWriter] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/****** Object:  Login [NT SERVICE\SQLTELEMETRY]    Script Date: 12/5/2022 1:17:26 PM ******/
CREATE LOGIN [NT SERVICE\SQLTELEMETRY] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/****** Object:  Login [NT SERVICE\SQLSERVERAGENT]    Script Date: 12/5/2022 1:17:26 PM ******/
CREATE LOGIN [NT SERVICE\SQLSERVERAGENT] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/****** Object:  Login [NT Service\MSSQLSERVER]    Script Date: 12/5/2022 1:17:26 PM ******/
CREATE LOGIN [NT Service\MSSQLSERVER] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/****** Object:  Login [NT AUTHORITY\SYSTEM]    Script Date: 12/5/2022 1:17:26 PM ******/
CREATE LOGIN [NT AUTHORITY\SYSTEM] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [long]    Script Date: 12/5/2022 1:17:26 PM ******/
CREATE LOGIN [long] WITH PASSWORD=N'3I8E2yPi5YafVdP+uKUg9ep5zp8VfBMg3Gg9/Xb0BsE=', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [long] DISABLE
GO
/****** Object:  Login [DESKTOP-70B731I\coder6622]    Script Date: 12/5/2022 1:17:26 PM ******/
CREATE LOGIN [DESKTOP-70B731I\coder6622] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [coder6622]    Script Date: 12/5/2022 1:17:26 PM ******/
CREATE LOGIN [coder6622] WITH PASSWORD=N'acK7EA/PPoWe1BAK5yT1mmVENkhvbPB8ramN25ewv8Q=', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [coder6622] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [admin]    Script Date: 12/5/2022 1:17:26 PM ******/
CREATE LOGIN [admin] WITH PASSWORD=N'/VSSYMntIm+/omzoLkDMz1Kt+X8b6qM3QaweVoYXbh4=', DEFAULT_DATABASE=[sanpham], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [admin] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [##MS_PolicyTsqlExecutionLogin##]    Script Date: 12/5/2022 1:17:26 PM ******/
CREATE LOGIN [##MS_PolicyTsqlExecutionLogin##] WITH PASSWORD=N'4EGvT2H6A23WhxgU/VO5a39xr8pGVygqONszC+c+/jE=', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=ON
GO
ALTER LOGIN [##MS_PolicyTsqlExecutionLogin##] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [##MS_PolicyEventProcessingLogin##]    Script Date: 12/5/2022 1:17:26 PM ******/
CREATE LOGIN [##MS_PolicyEventProcessingLogin##] WITH PASSWORD=N'HYU44C18p3yQNV6Dfg1s77cv/Q7AupdEf5g17SGFKdI=', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=ON
GO
ALTER LOGIN [##MS_PolicyEventProcessingLogin##] DISABLE
GO
ALTER AUTHORIZATION ON DATABASE::[product] TO [test]
GO
ALTER SERVER ROLE [sysadmin] ADD MEMBER [test]
GO
ALTER SERVER ROLE [dbcreator] ADD MEMBER [test]
GO
ALTER SERVER ROLE [sysadmin] ADD MEMBER [NT SERVICE\Winmgmt]
GO
ALTER SERVER ROLE [sysadmin] ADD MEMBER [NT SERVICE\SQLWriter]
GO
ALTER SERVER ROLE [sysadmin] ADD MEMBER [NT SERVICE\SQLSERVERAGENT]
GO
ALTER SERVER ROLE [sysadmin] ADD MEMBER [NT Service\MSSQLSERVER]
GO
ALTER SERVER ROLE [sysadmin] ADD MEMBER [long]
GO
ALTER SERVER ROLE [dbcreator] ADD MEMBER [long]
GO
ALTER SERVER ROLE [sysadmin] ADD MEMBER [DESKTOP-70B731I\coder6622]
GO
ALTER SERVER ROLE [sysadmin] ADD MEMBER [coder6622]
GO
ALTER SERVER ROLE [dbcreator] ADD MEMBER [coder6622]
GO
ALTER SERVER ROLE [sysadmin] ADD MEMBER [admin]
GO
ALTER SERVER ROLE [dbcreator] ADD MEMBER [admin]
GO
USE [product]
GO
/****** Object:  User [test]    Script Date: 12/5/2022 1:17:26 PM ******/
CREATE USER [test] FOR LOGIN [test] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[Product_TBL]    Script Date: 12/5/2022 1:17:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product_TBL](
	[MaSP] [char](4) NOT NULL,
	[TenSP] [nvarchar](200) NOT NULL,
	[DVT] [nvarchar](10) NOT NULL,
	[DonGiaBan] [int] NOT NULL,
	[NhaCungCap] [nvarchar](200) NOT NULL,
 CONSTRAINT [PK_Product_TBL] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER AUTHORIZATION ON [dbo].[Product_TBL] TO  SCHEMA OWNER 
GO
INSERT [dbo].[Product_TBL] ([MaSP], [TenSP], [DVT], [DonGiaBan], [NhaCungCap]) VALUES (N'SP01', N'Dau goi dau Head ', N'Chai', 340000, N'Unilevers')
INSERT [dbo].[Product_TBL] ([MaSP], [TenSP], [DVT], [DonGiaBan], [NhaCungCap]) VALUES (N'SP02', N'Xa bong Omil', N'Thung', 124000, N'Unilevers')
INSERT [dbo].[Product_TBL] ([MaSP], [TenSP], [DVT], [DonGiaBan], [NhaCungCap]) VALUES (N'SP04', N'Mi an lien Hao Hao', N'Thung', 750000, N'AceCook')
INSERT [dbo].[Product_TBL] ([MaSP], [TenSP], [DVT], [DonGiaBan], [NhaCungCap]) VALUES (N'SP05', N'Duong tinh luyn', N'Kg', 14000, N'Duong Bien Hoa')
INSERT [dbo].[Product_TBL] ([MaSP], [TenSP], [DVT], [DonGiaBan], [NhaCungCap]) VALUES (N'SP06', N'Sua Ong Tho', N'Lon', 13000, N'VinaMilk')
INSERT [dbo].[Product_TBL] ([MaSP], [TenSP], [DVT], [DonGiaBan], [NhaCungCap]) VALUES (N'SP07', N'Ruou nho nguyen chat', N'Chai', 130000, N'Cty Huong Nhien')
GO
USE [master]
GO
ALTER DATABASE [product] SET  READ_WRITE 
GO
