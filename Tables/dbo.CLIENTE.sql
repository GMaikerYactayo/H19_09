CREATE TABLE [dbo].[CLIENTE]
(
[CODCLI] [int] NOT NULL IDENTITY(1, 1),
[NOMCLI] [varchar] (30) COLLATE Modern_Spanish_CI_AS NOT NULL,
[APECLI] [varchar] (40) COLLATE Modern_Spanish_CI_AS NOT NULL,
[DNICLI] [char] (8) COLLATE Modern_Spanish_CI_AS NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CLIENTE] ADD CONSTRAINT [PK__CLIENTE__CB6ED59778EB561F] PRIMARY KEY CLUSTERED  ([CODCLI]) ON [PRIMARY]
GO
