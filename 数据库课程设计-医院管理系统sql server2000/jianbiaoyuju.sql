/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2000                    */
/* Created on:     2010-12-23 9:41:30                           */
/*==============================================================*/


if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('bed') and o.name = 'FK_BED_RELATIONS_PATIENT')
alter table bed
   drop constraint FK_BED_RELATIONS_PATIENT
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('employer') and o.name = 'FK_EMPLOYER_RELATIONS_DEPT')
alter table employer
   drop constraint FK_EMPLOYER_RELATIONS_DEPT
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('patient') and o.name = 'FK_PATIENT_RELATIONS_BED')
alter table patient
   drop constraint FK_PATIENT_RELATIONS_BED
go

if exists (select 1
            from  sysobjects
           where  id = object_id('admin')
            and   type = 'U')
   drop table admin
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('bed')
            and   name  = 'Relationship_4_FK'
            and   indid > 0
            and   indid < 255)
   drop index bed.Relationship_4_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('bed')
            and   type = 'U')
   drop table bed
go

if exists (select 1
            from  sysobjects
           where  id = object_id('dept')
            and   type = 'U')
   drop table dept
go

if exists (select 1
            from  sysobjects
           where  id = object_id('drug')
            and   type = 'U')
   drop table drug
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('employer')
            and   name  = 'Relationship_2_FK'
            and   indid > 0
            and   indid < 255)
   drop index employer.Relationship_2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('employer')
            and   type = 'U')
   drop table employer
go

if exists (select 1
            from  sysobjects
           where  id = object_id('instrument')
            and   type = 'U')
   drop table instrument
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('patient')
            and   name  = 'Relationship_4_FK'
            and   indid > 0
            and   indid < 255)
   drop index patient.Relationship_4_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('patient')
            and   type = 'U')
   drop table patient
go

if exists (select 1
            from  sysobjects
           where  id = object_id('salary')
            and   type = 'U')
   drop table salary
go

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin (
   id                   int   identity(1,1),
   name                 varchar(20)          null,
   password             varchar(20)          null,
   power                varchar(20)          null,
   constraint PK_ADMIN primary key nonclustered (id)
)
go

/*==============================================================*/
/* Table: bed                                                   */
/*==============================================================*/
create table bed (
   room                 varchar(20)          not null,
   id                   int                  null,
   bed                  int                  null,
   constraint PK_BED primary key nonclustered (room)
)
go

/*==============================================================*/
/* Index: Relationship_4_FK                                     */
/*==============================================================*/
create index Relationship_4_FK on bed (
id ASC
)
go

/*==============================================================*/
/* Table: dept                                                  */
/*==============================================================*/
create table dept (
   name                 varchar(20)          not null,
   kind                 varchar(20)          null,
   constraint PK_DEPT primary key nonclustered (name)
)
go

/*==============================================================*/
/* Table: drug                                                  */
/*==============================================================*/
create table drug (
   replace              varchar(20)          not null,
   name                 varchar(20)          null,
   price                float(10)            null,
   num                  int                  null,
   remarks              varchar(100)         null,
   constraint PK_DRUG primary key nonclustered (replace)
)
go

/*==============================================================*/
/* Table: employer                                              */
/*==============================================================*/
create table employer (
   id                   varchar(200)         not null,
   dept                 varchar(20)          null,
   name                 varchar(20)          null,
   sex                  varchar(20)          null,
   idcard               varchar(40)          null,
   birthday             datetime             null,
   origo                varchar(5)           null,
   nationlity           varchar(5)           null,
   nation               varchar(5)           null,
   marriage             varchar(5)           null,
   health               varchar(20)          null,
   worktime             datetime             null,
   address              varchar(100)         null,
   tel                  varchar(20)          null,
   constraint PK_EMPLOYER primary key nonclustered (id)
)
go

/*==============================================================*/
/* Index: Relationship_2_FK                                     */
/*==============================================================*/
create index Relationship_2_FK on employer (
dept ASC
)
go

/*==============================================================*/
/* Table: instrument                                            */
/*==============================================================*/
create table instrument (
   replace              varchar(20)          not null,
   name                 varchar(20)          null,
   price                float(10)            null,
   num                  int                  null,
   remarks              varchar(100)         null,
   constraint PK_INSTRUMENT primary key nonclustered (replace)
)
go

/*==============================================================*/
/* Table: patient                                               */
/*==============================================================*/
create table patient (
   id                   int              identity(1,1),
   room                 varchar(20)          null,
   name                 varchar(20)          null,
   sex                  varchar(20)          null,
   entertime            datetime             null,
   doctor               varchar(20)          null,
   section              varchar(20)          null,
   cation               varchar(200)         null,
   constraint PK_PATIENT primary key nonclustered (id)
)
go

/*==============================================================*/
/* Index: Relationship_4_FK                                     */
/*==============================================================*/
create index Relationship_4_FK on patient (
room ASC
)
go

/*==============================================================*/
/* Table: salary                                                */
/*==============================================================*/
create table salary (
   employid             char(10)             ,
   level                int                  ,
   money                int                  null,
   constraint PK_SALARY primary key nonclustered (employid,level)
) 
go

alter table bed
   add constraint FK_BED_RELATIONS_PATIENT foreign key (id)
      references patient (id)
go

alter table employer
   add constraint FK_EMPLOYER_RELATIONS_DEPT foreign key (dept)
      references dept (name)
go

alter table patient
   add constraint FK_PATIENT_RELATIONS_BED foreign key (room)
      references bed (room)
go

