create database Vehicle_Management;
use  Vehicle_Management;

create table Vehicle(RegNO char(10) primary key not NULL,RegDate date default NULL,Owner varchar(30) default NULL, Address varchar(50));
create table Offence(Offence_code int(3) primary key not NULL,Off_desc varchar(30) default NULL,Challan_Amt int(4) default NULL);
create table Challan(Challan_No int(11)primary key not null, Ch_Date date not null, RegNo char(10), Offence int(3),foreign key (RegNo) references Vehicle(RegNo),foreign key (Offence) references Offence(Offence_code));

select min(RegDate) as "First",max(RegDate) as "Last" from Vehicle;
/*Q19*/
select max(RedDate) ,min(RegDate) from Vehicle;

/*Q20*/
select count(Challan_No) from Challan group by Ch_Date;

/*Q21*/
select count(Challan_No) from Challan group by Offence;

/*Q22*/
select count(Reg_No) from Vehicle where Reg_No like "__6C%";

/*Q23*/
select count(challan_no) from challan where offence_code=(select offence_code from offence where off_desc='Driving without License');

/*Q24*/
select Challan_No,Ch_date,RegNo,challan.Offence_code,Offence_Desc from challan join offence
 using(offence_code ) where ch_date='2010-04-03';

/*Q25*/
select RegNo, count(Challan_No)from challan  group by RegNo having count(Challan_No)>1;

/*Q26*/
select * from vehicle,challan,offence where vehicle.RegNo=challan.RegNo and challan.Offence_code=offence.offence_code ;