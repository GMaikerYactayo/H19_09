CREATE TABLE [dbo].[VENTA]
(
[CODVEN] [int] NOT NULL IDENTITY(1, 1),
[CANBOL] [int] NULL,
[CODPER] [int] NULL,
[CODPRO] [int] NULL,
[CODCLI] [int] NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[VENTA] ADD CONSTRAINT [PK__VENTA__CB9EAF0F1DF65307] PRIMARY KEY CLUSTERED  ([CODVEN]) ON [PRIMARY]
GO
ALTER TABLE [dbo].[VENTA] ADD CONSTRAINT [VENTA_CLIENTE] FOREIGN KEY ([CODCLI]) REFERENCES [dbo].[CLIENTE] ([CODCLI])
GO
ALTER TABLE [dbo].[VENTA] ADD CONSTRAINT [VENTA_PERSONA] FOREIGN KEY ([CODPER]) REFERENCES [dbo].[PERSONA] ([CODPER])
GO
ALTER TABLE [dbo].[VENTA] ADD CONSTRAINT [VENTA_PRODUCTO] FOREIGN KEY ([CODPRO]) REFERENCES [dbo].[PRODUCTO] ([CODPRO])
GO
