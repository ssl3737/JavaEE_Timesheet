CREATE DATABASE inventory;

GRANT ALL PRIVILEGES ON inventory.* TO stock@localhost IDENTIFIED BY 'check';
GRANT ALL PRIVILEGES ON inventory.* TO stock@"%" IDENTIFIED BY 'check';

USE inventory;

DROP TABLE IF EXISTS Inventory;
CREATE TABLE Inventory (EmployeeID int, FName TINYTEXT, LName TINYTEXT, Password TINYTEXT, Username TINYTEXT, SuperUser BOOLEAN);

INSERT INTO Inventory VALUES (1,"Charlotte","Cooper","1234","supervisor1",'1');
INSERT INTO Inventory VALUES (2,"Shelley","Burke","1234","supervisor2",'1');
INSERT INTO Inventory VALUES (3,"Regina","Murphy","1234","supervisor3",'1');
INSERT INTO Inventory VALUES (4,"Regina","Murphy","1234","employee1",'0');
INSERT INTO Inventory VALUES (5,"Yoshi","Nagase","1234","employee8",'0');
INSERT INTO Inventory VALUES (6,"Soran","Shim","1234","employee7",'0');
INSERT INTO Inventory VALUES (7,"Calvin","Lee","1234","employee6",'0');
INSERT INTO Inventory VALUES (8,"Yoshi","Mon","1234","employee5",'0');
INSERT INTO Inventory VALUES (9,"Mike","Yu","1234","employee4",'0');
INSERT INTO Inventory VALUES (10,"Simson","Barbe","1234","employee3",'0');
INSERT INTO Inventory VALUES (11,"Shally","Shon","1234","employee2",'0');

DROP TABLE IF EXISTS Inventory2;
CREATE TABLE Inventory2 (EmployeeID int, WeekDate DATE, ProjectID TINYTEXT, WorkPackage TINYTEXT, Sat int, Sun int, Mon int, Tue int, Wed int, Thu int, Fri int, Notes TINYTEXT);

INSERT INTO Inventory2 VALUES (1, '2015-11-13',"132","AA123",0,0,2,3,8,3,3,"Requested by Soran");
INSERT INTO Inventory2 VALUES (2, '2015-11-13',"132","AA123",0,0,2,3,5,8,3,"Requested by Soran");
INSERT INTO Inventory2 VALUES (3, '2015-11-13',"132","AA123",0,0,2,3,4,7,3,"a");
INSERT INTO Inventory2 VALUES (1, '2015-11-6',"132","AA123",0,0,2,3,8,3,3,"Requested by Soran");
INSERT INTO Inventory2 VALUES (2, '2015-11-6',"132","AA123",0,0,2,3,5,8,3,"Requested by Soran");
INSERT INTO Inventory2 VALUES (3, '2015-11-6',"132","AA123",0,0,2,3,4,7,3,"");
INSERT INTO Inventory2 VALUES (4, '2015-11-6',"132","AA123",0,0,2,4,3,3,3,"");
INSERT INTO Inventory2 VALUES (5, '2015-11-13',"132","AA123",0,0,2,3,4,3,3,"");
INSERT INTO Inventory2 VALUES (6, '2015-11-13',"132","AA123",0,0,2,4,0,3,3,"");
INSERT INTO Inventory2 VALUES (7, '2015-11-13',"132","AA123",0,0,2,3,0,3,3,"");
INSERT INTO Inventory2 VALUES (8, '2015-11-13',"132","AA123",0,0,2,3,0,7,3,"Requested by Tracy");
INSERT INTO Inventory2 VALUES (9, '2015-11-13',"132","AA123",0,0,2,3,6,3,7,"");
INSERT INTO Inventory2 VALUES (10, '2015-11-13',"132","AA123",0,0,2,5,3,3,3,"");
INSERT INTO Inventory2 VALUES (11, '2015-11-13',"132","AA123",0,0,2,5,3,3,3,"");
INSERT INTO Inventory2 VALUES (1, '2015-10-30',"132","AA123",0,0,2,5,3,3,3,"Requested by Soran");
INSERT INTO Inventory2 VALUES (2, '2015-10-30',"132","AA123",0,0,2,5,3,3,7,"");
INSERT INTO Inventory2 VALUES (3, '2015-10-30',"132","AA123",0,0,2,5,3,3,3,"");
INSERT INTO Inventory2 VALUES (4, '2015-10-30',"132","AA123",0,0,2,6,3,3,3,"");
INSERT INTO Inventory2 VALUES (5, '2015-10-30',"132","AA123",0,0,2,3,8,8,4,"");
INSERT INTO Inventory2 VALUES (6, '2015-10-30',"132","AA123",0,0,2,3,8,3,3,"");
INSERT INTO Inventory2 VALUES (7, '2015-10-30',"132","AA123",0,0,2,3,7,7,3,"");
INSERT INTO Inventory2 VALUES (8, '2015-10-30',"132","AA123",0,0,2,3,7,3,3,"");
INSERT INTO Inventory2 VALUES (9, '2015-10-30',"132","AA123",0,0,2,3,3,5,3,"Requested by Tracy");

