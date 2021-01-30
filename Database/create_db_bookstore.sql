Use Master
Go
Create database BookStore
Go
Use BookStore
Go
CREATE TABLE Employee (
  Id       int IDENTITY NOT NULL, 
  FullName nvarchar(100) NULL, 
  Gender   bit NOT NULL, 
  Birthday date NULL, 
  Address  nvarchar(255) NULL, 
  Email    nvarchar(50) NULL, 
  Phone    nvarchar(15) NULL, 
  Salary   float(15) NULL, 
  Username nvarchar(50) NULL, 
  Password nvarchar(50) NULL, 
  PRIMARY KEY (Id));
CREATE TABLE Customer (
  Id             int IDENTITY NOT NULL, 
  CustomerTypeId int NOT NULL, 
  FullName       nvarchar(100) NULL, 
  Gender         bit NOT NULL, 
  Birthday       date NULL, 
  Address        nvarchar(255) NULL, 
  Email          nvarchar(50)NOT NULL UNIQUE, 
  Phone          nvarchar(15) NULL, 
  PRIMARY KEY (Id));
CREATE TABLE CustomerType (
  Id   int IDENTITY NOT NULL, 
  Type nvarchar(100) NULL, 
  PRIMARY KEY (Id));
CREATE TABLE Book (
  Isbn           int IDENTITY NOT NULL, 
  AuthorId       int NOT NULL, 
  PublisherId    int NOT NULL, 
  BookCategoryId int NOT NULL, 
  BookName       nvarchar(100) NULL, 
  Price          float(15) NOT NULL, 
  PictureThumb   nvarchar(100) NULL, 
  PublishYear    int NOT NULL, 
  Language       nvarchar(100) NULL, 
  Status         int NULL, 
  Discount       float(10) NOT NULL, 
  TotalPage      int NOT NULL, 
  Description    nvarchar(255) NULL, 
  PRIMARY KEY (Isbn));
CREATE TABLE BookCategory (
  Id   int IDENTITY NOT NULL, 
  Name nvarchar(100) NULL, 
  PRIMARY KEY (Id));
CREATE TABLE Author (
  Id       int IDENTITY NOT NULL, 
  Name     nvarchar(100) NULL, 
  Birthday date NULL, 
  Email    nvarchar(50) NULL, 
  Phone    nvarchar(15) NULL, 
  PRIMARY KEY (Id));
CREATE TABLE Publisher (
  Id      int IDENTITY NOT NULL, 
  Name    nvarchar(100) NULL, 
  Address nvarchar(100) NULL, 
  Email   nvarchar(50) NULL, 
  Phone   nvarchar(15) NULL, 
  PRIMARY KEY (Id));
CREATE TABLE OrderInfo (
  Id         int IDENTITY NOT NULL, 
  EmployeeId int , 
  CustomerId int NOT NULL, 
  OrderDate  varchar(100) NULL, 
  PRIMARY KEY (Id));
CREATE TABLE OrderDetail (
  BookIsbn        int , 
  OrderId         int , 
  TransactionDate varchar(80) NOT NULL, 
  Quantity        int NOT NULL, 
  Note            nvarchar(255) NULL, 
 PRIMARY KEY (BookIsbn,OrderId));
CREATE TABLE Account (
  Username   varchar(50) NOT NULL, 
  Password   varchar(50) NULL, 
  CustomerId int NOT NULL, 
  PRIMARY KEY (Username));
ALTER TABLE Customer ADD CONSTRAINT FKCustomer670752 FOREIGN KEY (CustomerTypeId) REFERENCES CustomerType (Id);
ALTER TABLE Book ADD CONSTRAINT FKBook308999 FOREIGN KEY (BookCategoryId) REFERENCES BookCategory (Id);
ALTER TABLE Book ADD CONSTRAINT FKBook221707 FOREIGN KEY (PublisherId) REFERENCES Publisher (Id);
ALTER TABLE Book ADD CONSTRAINT FKBook666529 FOREIGN KEY (AuthorId) REFERENCES Author (Id);
ALTER TABLE OrderDetail ADD CONSTRAINT FKOrderDetai762072 FOREIGN KEY (OrderId) REFERENCES [OrderInfo] (Id);
ALTER TABLE OrderDetail ADD CONSTRAINT FKOrderDetai572182 FOREIGN KEY (BookIsbn) REFERENCES Book (Isbn);
ALTER TABLE OrderInfo ADD CONSTRAINT FKOrder556775 FOREIGN KEY (CustomerId) REFERENCES Customer (Id);
ALTER TABLE OrderInfo ADD CONSTRAINT FKOrder900062 FOREIGN KEY (EmployeeId) REFERENCES Employee (Id);
ALTER TABLE Account ADD CONSTRAINT FKAccount437921 FOREIGN KEY (CustomerId) REFERENCES Customer (Id);

