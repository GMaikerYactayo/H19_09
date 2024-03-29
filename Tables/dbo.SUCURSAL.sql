CREATE TABLE [dbo].[SUCURSAL]
(
[CODSUC] [int] NOT NULL IDENTITY(1, 1),
[NOMSUC] [varchar] (40) COLLATE Modern_Spanish_CI_AS NOT NULL,
[DIRSUC] [varchar] (30) COLLATE Modern_Spanish_CI_AS NOT NULL,
[CODPER] [int] NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[SUCURSAL] ADD CONSTRAINT [PK__SUCURSAL__B76057D50AFDD1DF] PRIMARY KEY CLUSTERED  ([CODSUC]) ON [PRIMARY]
GO
ALTER TABLE [dbo].[SUCURSAL] ADD CONSTRAINT [SUCURSAL_PERSONA] FOREIGN KEY ([CODPER]) REFERENCES [dbo].[PERSONA] ([CODPER])
GO
