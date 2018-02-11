USE [master]
GO
/****** Object:  Database [bupa1000]    Script Date: 23.12.2017 20:42:52 ******/
CREATE DATABASE [bupa1000]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'bupa1000', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\bupa1000.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'bupa1000_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\bupa1000_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [bupa1000] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [bupa1000].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [bupa1000] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [bupa1000] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [bupa1000] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [bupa1000] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [bupa1000] SET ARITHABORT OFF 
GO
ALTER DATABASE [bupa1000] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [bupa1000] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [bupa1000] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [bupa1000] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [bupa1000] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [bupa1000] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [bupa1000] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [bupa1000] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [bupa1000] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [bupa1000] SET  DISABLE_BROKER 
GO
ALTER DATABASE [bupa1000] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [bupa1000] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [bupa1000] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [bupa1000] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [bupa1000] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [bupa1000] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [bupa1000] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [bupa1000] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [bupa1000] SET  MULTI_USER 
GO
ALTER DATABASE [bupa1000] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [bupa1000] SET DB_CHAINING OFF 
GO
ALTER DATABASE [bupa1000] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [bupa1000] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [bupa1000] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [bupa1000] SET QUERY_STORE = OFF
GO
USE [bupa1000]
GO
ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [bupa1000]
GO
/****** Object:  Table [dbo].[breastfeeding]    Script Date: 23.12.2017 20:42:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[breastfeeding](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[breastfeeding] [bit] NULL,
	[description] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[category]    Script Date: 23.12.2017 20:42:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[biomarker]    Script Date: 23.12.2017 20:42:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[biomarker](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[description] [varchar](255) NULL,
	[biomarker] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[category_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[mr]    Script Date: 23.12.2017 20:42:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[mr](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[description] [varchar](255) NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[person]    Script Date: 23.12.2017 20:42:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[person](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[prefix] [varchar](255) NULL,
	[suffix] [varchar](255) NULL,
	[type_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[person_person]    Script Date: 23.12.2017 20:42:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[person_person](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[baby_id] [bigint] NULL,
	[breastfeeding_id] [bigint] NULL,
	[mother_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 23.12.2017 20:42:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[description] [varchar](255) NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role_uzers]    Script Date: 23.12.2017 20:42:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role_uzers](
	[roles_id] [bigint] NOT NULL,
	[uzers_id] [bigint] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[source]    Script Date: 23.12.2017 20:42:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[source](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[state]    Script Date: 23.12.2017 20:42:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[state](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[description] [varchar](255) NULL,
	[null_allowed] [bit] NOT NULL,
	[text] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[type]    Script Date: 23.12.2017 20:42:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[type](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[character] [varchar](255) NULL,
	[type] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[uzer]    Script Date: 23.12.2017 20:42:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[uzer](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[password] [varchar](255) NULL,
	[username] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[value]    Script Date: 23.12.2017 20:42:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[value](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[value] [numeric](19, 2) NULL,
	[biomarker_id] [bigint] NULL,
	[mr_id] [bigint] NULL,
	[person_id] [bigint] NULL,
	[source_id] [bigint] NULL,
	[state_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[biomarker]  WITH CHECK ADD  CONSTRAINT [FKrqlbx9u653qwkhm7ux3f7eomb] FOREIGN KEY([category_id])
REFERENCES [dbo].[category] ([id])
GO
ALTER TABLE [dbo].[biomarker] CHECK CONSTRAINT [FKrqlbx9u653qwkhm7ux3f7eomb]
GO
ALTER TABLE [dbo].[person]  WITH CHECK ADD  CONSTRAINT [FKpngiv2fv3sg8y4eimkpyebpfy] FOREIGN KEY([type_id])
REFERENCES [dbo].[type] ([id])
GO
ALTER TABLE [dbo].[person] CHECK CONSTRAINT [FKpngiv2fv3sg8y4eimkpyebpfy]
GO
ALTER TABLE [dbo].[person_person]  WITH CHECK ADD  CONSTRAINT [FK86h63avauvfgpx3d2t1c44gc1] FOREIGN KEY([baby_id])
REFERENCES [dbo].[person] ([id])
GO
ALTER TABLE [dbo].[person_person] CHECK CONSTRAINT [FK86h63avauvfgpx3d2t1c44gc1]
GO
ALTER TABLE [dbo].[person_person]  WITH CHECK ADD  CONSTRAINT [FKgaksn748qjp8bx69i30vay2o0] FOREIGN KEY([mother_id])
REFERENCES [dbo].[person] ([id])
GO
ALTER TABLE [dbo].[person_person] CHECK CONSTRAINT [FKgaksn748qjp8bx69i30vay2o0]
GO
ALTER TABLE [dbo].[person_person]  WITH CHECK ADD  CONSTRAINT [FKtjc87m2r4nyhv6gjevid8r3hf] FOREIGN KEY([breastfeeding_id])
REFERENCES [dbo].[breastfeeding] ([id])
GO
ALTER TABLE [dbo].[person_person] CHECK CONSTRAINT [FKtjc87m2r4nyhv6gjevid8r3hf]
GO
ALTER TABLE [dbo].[role_uzers]  WITH CHECK ADD  CONSTRAINT [FK8npyb56yxtkgdh0ed11ivmslc] FOREIGN KEY([uzers_id])
REFERENCES [dbo].[uzer] ([id])
GO
ALTER TABLE [dbo].[role_uzers] CHECK CONSTRAINT [FK8npyb56yxtkgdh0ed11ivmslc]
GO
ALTER TABLE [dbo].[role_uzers]  WITH CHECK ADD  CONSTRAINT [FKt3ovmj1y9kmv9arsdp8614sry] FOREIGN KEY([roles_id])
REFERENCES [dbo].[role] ([id])
GO
ALTER TABLE [dbo].[role_uzers] CHECK CONSTRAINT [FKt3ovmj1y9kmv9arsdp8614sry]
GO
ALTER TABLE [dbo].[value]  WITH CHECK ADD  CONSTRAINT [FK2as0hy2m5aue39epefyyjxxkf] FOREIGN KEY([person_id])
REFERENCES [dbo].[person] ([id])
GO
ALTER TABLE [dbo].[value] CHECK CONSTRAINT [FK2as0hy2m5aue39epefyyjxxkf]
GO
ALTER TABLE [dbo].[value]  WITH CHECK ADD  CONSTRAINT [FK3pk4jlfv1b3rd9rc6mio4wnil] FOREIGN KEY([state_id])
REFERENCES [dbo].[state] ([id])
GO
ALTER TABLE [dbo].[value] CHECK CONSTRAINT [FK3pk4jlfv1b3rd9rc6mio4wnil]
GO
ALTER TABLE [dbo].[value]  WITH CHECK ADD  CONSTRAINT [FK51vwdmtm8plrj4p2s4nxypcpj] FOREIGN KEY([source_id])
REFERENCES [dbo].[source] ([id])
GO
ALTER TABLE [dbo].[value] CHECK CONSTRAINT [FK51vwdmtm8plrj4p2s4nxypcpj]
GO
ALTER TABLE [dbo].[value]  WITH CHECK ADD  CONSTRAINT [FK8md9egdbyxk57ixk3t7hnwiid] FOREIGN KEY([biomarker_id])
REFERENCES [dbo].[biomarker] ([id])
GO
ALTER TABLE [dbo].[value] CHECK CONSTRAINT [FK8md9egdbyxk57ixk3t7hnwiid]
GO
ALTER TABLE [dbo].[value]  WITH CHECK ADD  CONSTRAINT [FK9gwcxy161xvxluny0n2f9n8a0] FOREIGN KEY([mr_id])
REFERENCES [dbo].[mr] ([id])
GO
ALTER TABLE [dbo].[value] CHECK CONSTRAINT [FK9gwcxy161xvxluny0n2f9n8a0]
GO
USE [master]
GO
ALTER DATABASE [bupa1000] SET  READ_WRITE 
GO
