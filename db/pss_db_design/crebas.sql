/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/7/18 17:03:37                           */
/*==============================================================*/


drop table if exists pss_company;

drop table if exists pss_department;

drop table if exists pss_employee;

drop table if exists pss_file;

drop table if exists pss_goods;

drop table if exists pss_goods_brand;

drop table if exists pss_goods_defprop;

drop table if exists pss_goods_price;

drop table if exists pss_goods_prop;

drop table if exists pss_goods_propval;

drop table if exists pss_goods_sku;

drop table if exists pss_goods_sort;

drop table if exists pss_industry;

drop table if exists pss_inventory;

drop table if exists pss_menu;

drop table if exists pss_power;

drop table if exists pss_receipt;

drop table if exists pss_receipt_config;

drop table if exists pss_receipt_record;

drop table if exists pss_receipt_type;

drop table if exists pss_relation;

drop table if exists pss_relation_defset;

drop table if exists pss_user;

drop table if exists pss_user_group;

drop table if exists pss_warehouse;

/*==============================================================*/
/* Table: pss_company                                           */
/*==============================================================*/
create table pss_company
(
   id                   int not null auto_increment,
   name                 varchar(50) not null,
   email                varchar(50) default "",
   contact              varchar(20) not null,
   tel                  varchar(30) not null,
   fax                  varchar(30) default "",
   address              varchar(50) default "",
   industryId           int not null,
   companyId            int not null,
   joinDate             date not null,
   expireDate           date not null,
   master               tinyint not null default 0,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_department                                        */
/*==============================================================*/
create table pss_department
(
   id                   int not null auto_increment,
   name                 varchar(50) not null,
   employeeId           int default 0,
   companyId            int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_employee                                          */
/*==============================================================*/
create table pss_employee
(
   id                   int not null auto_increment,
   age                  int default 0,
   birth                date default '2013-01-01',
   name                 varchar(20) not null,
   card                 varchar(20) default "",
   phone                varchar(30) default "",
   address              varchar(50) default "",
   status               int not null default 0,
   companyId            int not null,
   departmentId         int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_file                                              */
/*==============================================================*/
create table pss_file
(
   id                   int not null auto_increment,
   md5                  varchar(50) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_goods                                             */
/*==============================================================*/
create table pss_goods
(
   id                   int not null auto_increment,
   shortName            varchar(30) default "",
   name                 varchar(50) not null,
   englishName          varchar(50) default "",
   brandId              int not null default 0,
   sortId               int not null default 0,
   status               int not null default 0,
   companyId            int not null default 0,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_goods_brand                                       */
/*==============================================================*/
create table pss_goods_brand
(
   id                   int not null auto_increment,
   name                 varchar(50) not null,
   englishName          varchar(50) default "",
   logo                 varchar(50) default "",
   remark               varchar(300) default "",
   status               int not null default 0,
   createDate           datetime not null,
   sortId               int not null,
   companyId            int not null default 0,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_goods_defprop                                     */
/*==============================================================*/
create table pss_goods_defprop
(
   id                   int not null auto_increment,
   goodsId              int not null,
   propId               int not null,
   propValId            int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_goods_price                                       */
/*==============================================================*/
create table pss_goods_price
(
   id                   int not null auto_increment,
   skuId                int not null,
   price                double not null default 0,
   status               int not null default 0,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_goods_prop                                        */
/*==============================================================*/
create table pss_goods_prop
(
   id                   int not null,
   name                 varbinary(20) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_goods_propval                                     */
/*==============================================================*/
create table pss_goods_propval
(
   id                   int not null auto_increment,
   value                varchar(300) not null,
   skuId                int not null default 0,
   propId               int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_goods_sku                                         */
/*==============================================================*/
create table pss_goods_sku
(
   id                   int not null auto_increment,
   goodsId              int not null,
   skuName              varchar(50) not null,
   skuCode              varbinary(30) default "",
   barcode              varchar(30) default "",
   code                 varchar(20) not null,
   propStr              varchar(300) default "",
   priceId              int not null default 0,
   status               int not null default 0,
   companyId            int not null default 0,
   remark               varchar(300) default "",
   createDate           datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_goods_sort                                        */
/*==============================================================*/
create table pss_goods_sort
(
   id                   int not null auto_increment,
   name                 varchar(50) not null,
   parentId             int not null default 0,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_industry                                          */
/*==============================================================*/
create table pss_industry
(
   id                   int not null auto_increment,
   name                 varchar(50) not null,
   description          varchar(300) default "",
   sorts                varchar(100) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_inventory                                         */
/*==============================================================*/
create table pss_inventory
(
   id                   int not null auto_increment,
   skuId                int not null,
   serialId             int not null,
   num                  double not null default 0,
   inprice              double not null default 0,
   warehouseId          int not null,
   companyId            int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_menu                                              */
/*==============================================================*/
create table pss_menu
(
   id                   int not null auto_increment,
   name                 varchar(30) not null,
   url                  varchar(80) not null,
   parentId             int not null default 0,
   power                char(3) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_power                                             */
/*==============================================================*/
create table pss_power
(
   id                   int not null auto_increment,
   name                 varchar(30) not null,
   remark               varchar(300) default "",
   primary key (id)
);

/*==============================================================*/
/* Table: pss_receipt                                           */
/*==============================================================*/
create table pss_receipt
(
   id                   int not null auto_increment,
   serialId             int not null,
   createDate           datetime not null,
   checkDate            datetime not null,
   postedDate           datetime not null,
   totalMoney           double not null,
   customerId           int default 0,
   supplierId           int default 0,
   outWareId            int default 0,
   inWareId             int default 0,
   handleEmpId          int not null,
   checkEmpId           int not null,
   postedEmpId          int not null,
   status               int not null default 0,
   type                 int not null,
   rebate               double not null default 100,
   discount             double not null default 0,
   companyId            int not null,
   remark               varchar(300) default "",
   primary key (id)
);

/*==============================================================*/
/* Table: pss_receipt_config                                    */
/*==============================================================*/
create table pss_receipt_config
(
   id                   int not null auto_increment,
   needCheck            tinyint not null default 1,
   needDraft            tinyint not null default 1,
   serialLength         int not null default 4,
   receiptTypeId        int not null,
   receiptStyle         int not null default 0,
   companyId            int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_receipt_record                                    */
/*==============================================================*/
create table pss_receipt_record
(
   id                   int not null auto_increment,
   num                  double not null,
   skuId                int not null,
   inprice              double default 0,
   price                double default 0,
   totalMoney           double not null,
   receiptId            int not null,
   rebate               double not null default 100,
   discount             double not null default 0,
   remark               varchar(300) default "",
   primary key (id)
);

/*==============================================================*/
/* Table: pss_receipt_type                                      */
/*==============================================================*/
create table pss_receipt_type
(
   id                   int not null auto_increment,
   name                 varchar(30) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_relation                                          */
/*==============================================================*/
create table pss_relation
(
   id                   int not null auto_increment,
   name                 varchar(50) not null,
   contact              varchar(30) default "",
   phone                varchar(30) default "",
   fax                  varchar(30) default "",
   address              varchar(100) default "",
   remark               varchar(300) default "",
   type                 int not null,
   companyId            int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_relation_defset                                   */
/*==============================================================*/
create table pss_relation_defset
(
   id                   int not null auto_increment,
   price                double not null default 0,
   rebate               double not null default 100,
   discount             double not null default 0,
   skuId                int not null,
   companyId            int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_user                                              */
/*==============================================================*/
create table pss_user
(
   id                   int not null auto_increment,
   username             varchar(20) not null,
   password             varchar(50) not null,
   groupId              int not null,
   employeeId           int not null,
   companyId            int not null,
   powers               varchar(300) default "",
   createDate           datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_user_group                                        */
/*==============================================================*/
create table pss_user_group
(
   id                   int not null auto_increment,
   name                 varchar(30) not null,
   powers               varchar(300) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: pss_warehouse                                         */
/*==============================================================*/
create table pss_warehouse
(
   id                   int not null auto_increment,
   name                 varchar(50) not null,
   address              varchar(300) not null,
   companyId            int not null default 0,
   primary key (id)
);

