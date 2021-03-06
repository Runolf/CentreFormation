USE [master]
GO
/****** Object:  Database [CentreFormation]    Script Date: 09/02/2021 10:01:37 ******/
CREATE DATABASE [CentreFormation]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'CentreFormation', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL12.GULDUR\MSSQL\DATA\CentreFormation.mdf' , SIZE = 4288KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'CentreFormation_log', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL12.GULDUR\MSSQL\DATA\CentreFormation_log.ldf' , SIZE = 1072KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [CentreFormation] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [CentreFormation].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [CentreFormation] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [CentreFormation] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [CentreFormation] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [CentreFormation] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [CentreFormation] SET ARITHABORT OFF 
GO
ALTER DATABASE [CentreFormation] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [CentreFormation] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [CentreFormation] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [CentreFormation] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [CentreFormation] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [CentreFormation] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [CentreFormation] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [CentreFormation] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [CentreFormation] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [CentreFormation] SET  ENABLE_BROKER 
GO
ALTER DATABASE [CentreFormation] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [CentreFormation] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [CentreFormation] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [CentreFormation] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [CentreFormation] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [CentreFormation] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [CentreFormation] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [CentreFormation] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [CentreFormation] SET  MULTI_USER 
GO
ALTER DATABASE [CentreFormation] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [CentreFormation] SET DB_CHAINING OFF 
GO
ALTER DATABASE [CentreFormation] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [CentreFormation] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [CentreFormation] SET DELAYED_DURABILITY = DISABLED 
GO
USE [CentreFormation]
GO
/****** Object:  Table [dbo].[Formateurs]    Script Date: 09/02/2021 10:01:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Formateurs](
	[IdFormateur] [int] IDENTITY(1,1) NOT NULL,
	[Nom] [varchar](50) NULL,
	[Prenom] [varchar](50) NULL,
	[Adresse] [varchar](100) NULL,
	[Telephone] [varchar](50) NULL,
	[Email] [varchar](100) NULL,
	[CodeId] [int] NULL,
	[NationnalId] [varchar](100) NULL,
	[Compte] [varchar](100) NULL,
	[GestAjout] [int] NULL,
	[GestModif] [int] NULL,
	[GestDelete] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFormateur] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Formations]    Script Date: 09/02/2021 10:01:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Formations](
	[IdFormation] [int] IDENTITY(1,1) NOT NULL,
	[Intitule] [varchar](50) NULL,
	[Duree] [int] NULL,
	[PrixBase] [decimal](18, 0) NULL,
	[MaxInscription] [int] NULL,
	[MinEleve] [int] NULL,
	[DateCrea] [date] NULL,
	[DateCloture] [date] NULL,
	[GestAjout] [int] NULL,
	[GestModif] [int] NULL,
	[GestDelete] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFormation] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FormationsPrerequises]    Script Date: 09/02/2021 10:01:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FormationsPrerequises](
	[IdFormationPrerequise] [int] NULL,
	[IdFormationActuel] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Gestionnaires]    Script Date: 09/02/2021 10:01:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Gestionnaires](
	[IdGestionnaire] [int] IDENTITY(1,1) NOT NULL,
	[Nom] [varchar](50) NULL,
	[Prenom] [varchar](50) NULL,
	[Adresse] [varchar](100) NULL,
	[Telephone] [varchar](50) NULL,
	[Email] [varchar](100) NULL,
	[CodeId] [int] NULL,
	[NationnalId] [varchar](100) NULL,
	[Compte] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdGestionnaire] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Inscriptions]    Script Date: 09/02/2021 10:01:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Inscriptions](
	[IdInscription] [int] IDENTITY(1,1) NOT NULL,
	[EstPayee] [bit] NULL,
	[PrixActuel] [decimal](18, 0) NULL,
	[IdStagiaire] [int] NULL,
	[IdSession] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdInscription] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Locaux]    Script Date: 09/02/2021 10:01:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Locaux](
	[IdLocal] [int] IDENTITY(1,1) NOT NULL,
	[Nom] [varchar](50) NULL,
	[Etage] [int] NULL,
	[EstPermanent] [bit] NULL,
	[IdType] [int] NULL,
	[GestAjout] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Secretaires]    Script Date: 09/02/2021 10:01:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Secretaires](
	[IdSecretaire] [int] IDENTITY(1,1) NOT NULL,
	[Nom] [varchar](50) NULL,
	[Prenom] [varchar](50) NULL,
	[Adresse] [varchar](100) NULL,
	[Telephone] [varchar](50) NULL,
	[Email] [varchar](100) NULL,
	[CodeId] [int] NULL,
	[NationnalId] [varchar](100) NULL,
	[Compte] [varchar](100) NULL,
	[GestAjout] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSecretaire] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Sessions]    Script Date: 09/02/2021 10:01:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sessions](
	[IdSession] [int] IDENTITY(1,1) NOT NULL,
	[StartDate] [date] NULL,
	[EndDate] [date] NULL,
	[IdFormateur] [int] NULL,
	[IdLocal] [int] NULL,
	[IdFormation] [int] NULL,
	[GestAjout] [int] NULL,
	[GestModif] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSession] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Stagiaires]    Script Date: 09/02/2021 10:01:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Stagiaires](
	[IdStagiaire] [int] IDENTITY(1,1) NOT NULL,
	[Nom] [varchar](50) NULL,
	[Prenom] [varchar](50) NULL,
	[Adresse] [varchar](100) NULL,
	[Telephone] [varchar](50) NULL,
	[Email] [varchar](100) NULL,
	[CodeId] [int] NULL,
	[IdStatut] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdStagiaire] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Statuts]    Script Date: 09/02/2021 10:01:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Statuts](
	[IdStatut] [int] IDENTITY(1,1) NOT NULL,
	[Nom] [varchar](50) NULL,
	[GestAjout] [int] NULL,
	[GestModif] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdStatut] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Types]    Script Date: 09/02/2021 10:01:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Types](
	[IdType] [int] IDENTITY(1,1) NOT NULL,
	[Nom] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdType] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Formateurs] ON 

INSERT [dbo].[Formateurs] ([IdFormateur], [Nom], [Prenom], [Adresse], [Telephone], [Email], [CodeId], [NationnalId], [Compte], [GestAjout], [GestModif], [GestDelete]) VALUES (1, N'Daigle', N'Serre', N'rue de Hogwart, 45, London', N'7774444111', N'ser@hotmail.uk', 41, N'96314', N'12321354641', 1, 1, NULL)
SET IDENTITY_INSERT [dbo].[Formateurs] OFF
SET IDENTITY_INSERT [dbo].[Formations] ON 

INSERT [dbo].[Formations] ([IdFormation], [Intitule], [Duree], [PrixBase], [MaxInscription], [MinEleve], [DateCrea], [DateCloture], [GestAjout], [GestModif], [GestDelete]) VALUES (2, N'JAVA', 5, CAST(1000 AS Decimal(18, 0)), 12, 1, CAST(N'2021-02-15' AS Date), NULL, 1, NULL, NULL)
INSERT [dbo].[Formations] ([IdFormation], [Intitule], [Duree], [PrixBase], [MaxInscription], [MinEleve], [DateCrea], [DateCloture], [GestAjout], [GestModif], [GestDelete]) VALUES (3, N'.NET', 5, CAST(1000 AS Decimal(18, 0)), 12, 1, CAST(N'2021-02-07' AS Date), CAST(N'2021-02-07' AS Date), 1, NULL, NULL)
INSERT [dbo].[Formations] ([IdFormation], [Intitule], [Duree], [PrixBase], [MaxInscription], [MinEleve], [DateCrea], [DateCloture], [GestAjout], [GestModif], [GestDelete]) VALUES (4, N'PHP', 3, CAST(750 AS Decimal(18, 0)), 12, 1, CAST(N'2021-02-08' AS Date), NULL, 1, NULL, NULL)
INSERT [dbo].[Formations] ([IdFormation], [Intitule], [Duree], [PrixBase], [MaxInscription], [MinEleve], [DateCrea], [DateCloture], [GestAjout], [GestModif], [GestDelete]) VALUES (5, N'javascript', 2, CAST(500 AS Decimal(18, 0)), 12, 1, CAST(N'2021-02-08' AS Date), NULL, 1, 1, NULL)
INSERT [dbo].[Formations] ([IdFormation], [Intitule], [Duree], [PrixBase], [MaxInscription], [MinEleve], [DateCrea], [DateCloture], [GestAjout], [GestModif], [GestDelete]) VALUES (6, N'Python', 5, CAST(1250 AS Decimal(18, 0)), 12, 1, CAST(N'2021-02-08' AS Date), CAST(N'2021-02-08' AS Date), 1, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Formations] OFF
SET IDENTITY_INSERT [dbo].[Gestionnaires] ON 

INSERT [dbo].[Gestionnaires] ([IdGestionnaire], [Nom], [Prenom], [Adresse], [Telephone], [Email], [CodeId], [NationnalId], [Compte]) VALUES (1, N'Liskiewicz', N'Alexandre', N'Chaussée du Roeulx', N'064744444', N'alex@hotmail.com', 1, N'0101010101', N'7777777')
SET IDENTITY_INSERT [dbo].[Gestionnaires] OFF
SET IDENTITY_INSERT [dbo].[Inscriptions] ON 

INSERT [dbo].[Inscriptions] ([IdInscription], [EstPayee], [PrixActuel], [IdStagiaire], [IdSession]) VALUES (9, 0, CAST(90 AS Decimal(18, 0)), 2, 3)
INSERT [dbo].[Inscriptions] ([IdInscription], [EstPayee], [PrixActuel], [IdStagiaire], [IdSession]) VALUES (10, 0, CAST(40 AS Decimal(18, 0)), 2, 3)
SET IDENTITY_INSERT [dbo].[Inscriptions] OFF
SET IDENTITY_INSERT [dbo].[Locaux] ON 

INSERT [dbo].[Locaux] ([IdLocal], [Nom], [Etage], [EstPermanent], [IdType], [GestAjout]) VALUES (1, N'Cracovie', 0, 0, NULL, NULL)
INSERT [dbo].[Locaux] ([IdLocal], [Nom], [Etage], [EstPermanent], [IdType], [GestAjout]) VALUES (2, N'Varsovie', 0, 0, NULL, NULL)
INSERT [dbo].[Locaux] ([IdLocal], [Nom], [Etage], [EstPermanent], [IdType], [GestAjout]) VALUES (3, N'test', 0, 0, NULL, 1)
INSERT [dbo].[Locaux] ([IdLocal], [Nom], [Etage], [EstPermanent], [IdType], [GestAjout]) VALUES (4, N'test update full', 4, 1, 2, 1)
SET IDENTITY_INSERT [dbo].[Locaux] OFF
SET IDENTITY_INSERT [dbo].[Secretaires] ON 

INSERT [dbo].[Secretaires] ([IdSecretaire], [Nom], [Prenom], [Adresse], [Telephone], [Email], [CodeId], [NationnalId], [Compte], [GestAjout]) VALUES (1, N'Droit', N'Angle', N'rue de l''angle, 84, Paris', N'04718145', N'angle@hotmail.fr', 45, N'4987612158', N'7444444444', 1)
SET IDENTITY_INSERT [dbo].[Secretaires] OFF
SET IDENTITY_INSERT [dbo].[Sessions] ON 

INSERT [dbo].[Sessions] ([IdSession], [StartDate], [EndDate], [IdFormateur], [IdLocal], [IdFormation], [GestAjout], [GestModif]) VALUES (1, CAST(N'2021-02-08' AS Date), CAST(N'2021-02-12' AS Date), 1, 4, 2, 1, NULL)
INSERT [dbo].[Sessions] ([IdSession], [StartDate], [EndDate], [IdFormateur], [IdLocal], [IdFormation], [GestAjout], [GestModif]) VALUES (2, CAST(N'2021-02-08' AS Date), CAST(N'2021-02-12' AS Date), 1, 2, 4, 1, NULL)
INSERT [dbo].[Sessions] ([IdSession], [StartDate], [EndDate], [IdFormateur], [IdLocal], [IdFormation], [GestAjout], [GestModif]) VALUES (3, CAST(N'2021-02-08' AS Date), CAST(N'2021-02-12' AS Date), 1, 2, 4, 1, NULL)
SET IDENTITY_INSERT [dbo].[Sessions] OFF
SET IDENTITY_INSERT [dbo].[Stagiaires] ON 

INSERT [dbo].[Stagiaires] ([IdStagiaire], [Nom], [Prenom], [Adresse], [Telephone], [Email], [CodeId], [IdStatut]) VALUES (1, N'anonyme', N'anonyme', N'anonyme', N'anonyme', N'anonyme', 7741, NULL)
INSERT [dbo].[Stagiaires] ([IdStagiaire], [Nom], [Prenom], [Adresse], [Telephone], [Email], [CodeId], [IdStatut]) VALUES (2, N'anonyme', N'anonyme', N'anonyme', N'anonyme', N'anonyme', 7741, 3)
SET IDENTITY_INSERT [dbo].[Stagiaires] OFF
SET IDENTITY_INSERT [dbo].[Statuts] ON 

INSERT [dbo].[Statuts] ([IdStatut], [Nom], [GestAjout], [GestModif]) VALUES (3, N'Demandeur d''emploi', 1, NULL)
INSERT [dbo].[Statuts] ([IdStatut], [Nom], [GestAjout], [GestModif]) VALUES (4, N'Salarié', 1, 1)
INSERT [dbo].[Statuts] ([IdStatut], [Nom], [GestAjout], [GestModif]) VALUES (5, N'Étudiants', 1, 1)
INSERT [dbo].[Statuts] ([IdStatut], [Nom], [GestAjout], [GestModif]) VALUES (6, N'Test modif', 1, 1)
SET IDENTITY_INSERT [dbo].[Statuts] OFF
SET IDENTITY_INSERT [dbo].[Types] ON 

INSERT [dbo].[Types] ([IdType], [Nom]) VALUES (1, N'interne')
INSERT [dbo].[Types] ([IdType], [Nom]) VALUES (2, N'extérieur')
INSERT [dbo].[Types] ([IdType], [Nom]) VALUES (3, N'TEST PUT ID 3')
SET IDENTITY_INSERT [dbo].[Types] OFF
ALTER TABLE [dbo].[Formateurs]  WITH CHECK ADD FOREIGN KEY([GestAjout])
REFERENCES [dbo].[Gestionnaires] ([IdGestionnaire])
GO
ALTER TABLE [dbo].[Formateurs]  WITH CHECK ADD FOREIGN KEY([GestDelete])
REFERENCES [dbo].[Gestionnaires] ([IdGestionnaire])
GO
ALTER TABLE [dbo].[Formateurs]  WITH CHECK ADD FOREIGN KEY([GestModif])
REFERENCES [dbo].[Gestionnaires] ([IdGestionnaire])
GO
ALTER TABLE [dbo].[Formations]  WITH CHECK ADD FOREIGN KEY([GestAjout])
REFERENCES [dbo].[Gestionnaires] ([IdGestionnaire])
GO
ALTER TABLE [dbo].[Formations]  WITH CHECK ADD FOREIGN KEY([GestDelete])
REFERENCES [dbo].[Gestionnaires] ([IdGestionnaire])
GO
ALTER TABLE [dbo].[Formations]  WITH CHECK ADD FOREIGN KEY([GestModif])
REFERENCES [dbo].[Gestionnaires] ([IdGestionnaire])
GO
ALTER TABLE [dbo].[FormationsPrerequises]  WITH CHECK ADD FOREIGN KEY([IdFormationPrerequise])
REFERENCES [dbo].[Formations] ([IdFormation])
GO
ALTER TABLE [dbo].[FormationsPrerequises]  WITH CHECK ADD FOREIGN KEY([IdFormationActuel])
REFERENCES [dbo].[Formations] ([IdFormation])
GO
ALTER TABLE [dbo].[Inscriptions]  WITH CHECK ADD FOREIGN KEY([IdSession])
REFERENCES [dbo].[Sessions] ([IdSession])
GO
ALTER TABLE [dbo].[Inscriptions]  WITH CHECK ADD FOREIGN KEY([IdStagiaire])
REFERENCES [dbo].[Stagiaires] ([IdStagiaire])
GO
ALTER TABLE [dbo].[Locaux]  WITH CHECK ADD FOREIGN KEY([GestAjout])
REFERENCES [dbo].[Gestionnaires] ([IdGestionnaire])
GO
ALTER TABLE [dbo].[Locaux]  WITH CHECK ADD FOREIGN KEY([IdType])
REFERENCES [dbo].[Types] ([IdType])
GO
ALTER TABLE [dbo].[Secretaires]  WITH CHECK ADD FOREIGN KEY([GestAjout])
REFERENCES [dbo].[Gestionnaires] ([IdGestionnaire])
GO
ALTER TABLE [dbo].[Sessions]  WITH CHECK ADD FOREIGN KEY([GestAjout])
REFERENCES [dbo].[Gestionnaires] ([IdGestionnaire])
GO
ALTER TABLE [dbo].[Sessions]  WITH CHECK ADD FOREIGN KEY([GestModif])
REFERENCES [dbo].[Gestionnaires] ([IdGestionnaire])
GO
ALTER TABLE [dbo].[Sessions]  WITH CHECK ADD FOREIGN KEY([IdFormateur])
REFERENCES [dbo].[Formateurs] ([IdFormateur])
GO
ALTER TABLE [dbo].[Sessions]  WITH CHECK ADD FOREIGN KEY([IdFormation])
REFERENCES [dbo].[Formations] ([IdFormation])
GO
ALTER TABLE [dbo].[Sessions]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[Locaux] ([IdLocal])
GO
ALTER TABLE [dbo].[Stagiaires]  WITH CHECK ADD FOREIGN KEY([IdStatut])
REFERENCES [dbo].[Statuts] ([IdStatut])
GO
ALTER TABLE [dbo].[Statuts]  WITH CHECK ADD FOREIGN KEY([GestAjout])
REFERENCES [dbo].[Gestionnaires] ([IdGestionnaire])
GO
ALTER TABLE [dbo].[Statuts]  WITH CHECK ADD FOREIGN KEY([GestModif])
REFERENCES [dbo].[Gestionnaires] ([IdGestionnaire])
GO
USE [master]
GO
ALTER DATABASE [CentreFormation] SET  READ_WRITE 
GO
