/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/7/25 17:49:46                           */
/*==============================================================*/


drop table if exists psi_company;

drop table if exists psi_department;

drop table if exists psi_emp_sales;

drop table if exists psi_employee;

drop table if exists psi_file;

drop table if exists psi_goods;

drop table if exists psi_goods_brand;

drop table if exists psi_goods_defprop;

drop table if exists psi_goods_price;

drop table if exists psi_goods_prop;

drop table if exists psi_goods_propval;

drop table if exists psi_goods_sku;

drop table if exists psi_goods_sort;

drop table if exists psi_industry;

drop table if exists psi_inventory;

drop table if exists psi_menu;

drop table if exists psi_power;

drop table if exists psi_receipt;

drop table if exists psi_receipt_config;

drop table if exists psi_receipt_record;

drop table if exists psi_receipt_type;

drop table if exists psi_relation;

drop table if exists psi_relation_defset;

drop table if exists psi_user;

drop table if exists psi_user_group;

drop table if exists psi_warehouse;

/*==============================================================*/
/* Table: psi_company                                           */
/*==============================================================*/
create table psi_company
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
/* Table: psi_department                                        */
/*==============================================================*/
create table psi_department
(
   id                   int not null auto_increment,
   name                 varchar(50) not null,
   employeeId           int default 0,
   companyId            int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: psi_emp_sales                                         */
/*==============================================================*/
create table psi_emp_sales
(
   id                   int not null auto_increment,
   receiptId            int not null,
   num                  double not null,
   money                double not null,
   primary key (id)
);

/*==============================================================*/
/* Table: psi_employee                                          */
/*==============================================================*/
create table psi_employee
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
/* Table: psi_file                                              */
/*==============================================================*/
create table psi_file
(
   id                   int not null auto_increment,
   md5                  varchar(50) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: psi_goods                                             */
/*==============================================================*/
create table psi_goods
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
/* Table: psi_goods_brand                                       */
/*==============================================================*/
create table psi_goods_brand
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
/* Table: psi_goods_defprop                                     */
/*==============================================================*/
create table psi_goods_defprop
(
   id                   int not null auto_increment,
   goodsId              int not null,
   propId               int not null,
   propValId            int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: psi_goods_price                                       */
/*==============================================================*/
create table psi_goods_price
(
   id                   int not null auto_increment,
   skuId                int not null,
   price                double not null default 0,
   status               int not null default 0,
   primary key (id)
);

/*==============================================================*/
/* Table: psi_goods_prop                                        */
/*==============================================================*/
create table psi_goods_prop
(
   id                   int not null,
   name                 varbinary(20) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: psi_goods_propval                                     */
/*==============================================================*/
create table psi_goods_propval
(
   id                   int not null auto_increment,
   value                varchar(300) not null,
   skuId                int not null default 0,
   propId               int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: psi_goods_sku                                         */
/*==============================================================*/
create table psi_goods_sku
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
/* Table: psi_goods_sort                                        */
/*==============================================================*/
create table psi_goods_sort
(
   id                   int not null auto_increment,
   name                 varchar(50) not null,
   parentId             int not null default 0,
   companyId            int not null default 0,
   primary key (id)
);

/*==============================================================*/
/* Table: psi_industry                                          */
/*==============================================================*/
create table psi_industry
(
   id                   int not null auto_increment,
   name                 varchar(50) not null,
   description          varchar(300) default "",
   sorts                varchar(100) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: psi_inventory                                         */
/*==============================================================*/
create table psi_inventory
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
/* Table: psi_menu                                              */
/*==============================================================*/
create table psi_menu
(
   id                   int not null auto_increment,
   name                 varchar(30) not null,
   url                  varchar(80) not null,
   parentId             int not null default 0,
   power                char(3) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: psi_power                                             */
/*==============================================================*/
create table psi_power
(
   id                   int not null auto_increment,
   name                 varchar(30) not null,
   code                 char(3) not null,
   remark               varchar(300) default "",
   primary key (id)
);

/*==============================================================*/
/* Table: psi_receipt                                           */
/*==============================================================*/
create table psi_receipt
(
   id                   int not null auto_increment,
   serialId             int not null,
   createDate           datetime not null,
   checkDate            datetime not null,
   postedDate           datetime not null,
   totalMoney           double not null default 0,
   totleNum             double not null default 0,
   customerId           int default 0,
   supplierId           int default 0,
   outWareId            int default 0,
   inWareId             int default 0,
   handleEmps           varchar(100) not null,
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
/* Table: psi_receipt_config                                    */
/*==============================================================*/
create table psi_receipt_config
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
/* Table: psi_receipt_record                                    */
/*==============================================================*/
create table psi_receipt_record
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
/* Table: psi_receipt_type                                      */
/*==============================================================*/
create table psi_receipt_type
(
   id                   int not null auto_increment,
   name                 varchar(30) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: psi_relation                                          */
/*==============================================================*/
create table psi_relation
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
/* Table: psi_relation_defset                                   */
/*==============================================================*/
create table psi_relation_defset
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
/* Table: psi_user                                              */
/*==============================================================*/
create table psi_user
(
   id                   int not null auto_increment,
   username             varchar(20) not null,
   password             varchar(50) not null,
   groupId              int not null,
   employeeId           int not null default 0,
   companyId            int not null,
   powers               varchar(300) default "",
   status               int not null default 0,
   createDate           datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: psi_user_group                                        */
/*==============================================================*/
create table psi_user_group
(
   id                   int not null auto_increment,
   name                 varchar(30) not null,
   powers               varchar(300) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: psi_warehouse                                         */
/*==============================================================*/
create table psi_warehouse
(
   id                   int not null auto_increment,
   name                 varchar(50) not null,
   address              varchar(300) not null,
   companyId            int not null default 0,
   primary key (id)
);

