create database BTL
go
use BTL
go

CREATE TABLE Users (
    UserID INT PRIMARY KEY,
    Username VARCHAR(50) NOT NULL,
    Password VARCHAR(50) NOT NULL,
)
create table Courses (
    CouId varchar(10) primary key,
    CourseName varchar(100),
    CourseDescription varchar(50),
	Credits int
)
create table Students (
    StuId int identity primary key,
    StudentName varchar(100),
	Gender bit,
	Email varchar(255),
    DateOfBirth date,
    Address varchar(255),
    PhoneNumber varchar(15),
	CouId varchar(10) foreign key references Courses(CouId)
)

CREATE TABLE Classes (
    ClassId INT PRIMARY KEY,
    ClassName VARCHAR(100) NOT NULL,
    CouId varchar(20) foreign key references Courses(CouId)
)
CREATE TABLE Labs (
    Id INT PRIMARY KEY,
    LabName VARCHAR(255),
    ClassId INT FOREIGN KEY REFERENCES Classes(ClassId)
)

CREATE TABLE Activities (
    ActivityId INT PRIMARY KEY,

    ActivityName VARCHAR(100) NOT NULL,
    ActivityDate DATE,
       ClassId INT FOREIGN KEY REFERENCES Classes(ClassId)
)

CREATE TABLE Schedules (
    ScheduleId INT PRIMARY KEY,
    Date DATE,
    StartTime TIME,
    EndTime TIME,
    Room VARCHAR(50),
    ClassId INT FOREIGN KEY REFERENCES Classes(ClassId)
)
insert into Users values (1,'Admin','12345')
select * from Users

insert into Courses values ('ss','PHP','Lap trinh web PHP',1)

insert into Courses values ('ee','Laravel','Lap trinh web Laravel',2)

insert into Courses values ('tt','Node Js','Lap trinh web Node Js',3)

insert into Courses values ('qq','JAVA','Lap trinh web Java',4)
select * from Courses

insert into Students values('Truong Tho',1,'tho@gmail.com','2002-1-1','Gia Lam- Ha Noi','089788786','ss')
insert into Students values('Do Dai',1,'dai@gmail.com','2001-11-14','Dong Thanh-Ha Noi','088776565','ee')
insert into Students values('Lung Linh',0,'linh@gmail.com','1998-1-14','Soc Son- Ha Noi','087877665','tt')
insert into Students values('Do Quyen',0,'Quyen@gmail.com','1999-4-3','Bao Loc-Da lat','0765456622','qq')
select * from Students


insert into Classes values(1,'C2208G',1)
select * from Classes

insert into Labs values (1,'lab2',1)
select * from Labs

insert into Activities values(1,'Do An','2012-1-12',1)
select * from Activities

insert into Schedules values(1,'2023-1-12','13:30','17:00','Phong 2',1)
select * from Schedules