CREATE TABLE TOUR
	( Name VARCHAR(30) NOT NULL
	, TourID INT NOT NULL
	, Length INT //í klst
	, Date DATE
	, Location VARCHAR(20)[] NOT NULL
	, Price DOUBLE
	, ParticipantNum INT
	, Review VARCHAR(30)[]
	, TourInfo VARCHAR(200)
	, PRIMARY KEY(TourID)
	, FOREIGN KEY(Review) REFERENCES Review(ReviewText)
	  DEFERRABLE INITIALLY DEFERRED
	);
CREATE TABLE REVIEW
	( Uname VARCHAR(30)
	, ReviewText VARCHAR(15) NOT NULL
	, PRIMARY KEY(Uname)
	);

CREATE TABLE BOOKING
	( BookingID INT
	, Bname VARCHAR(30) NOT NULL
	, PhoneNo VARCHAR(30) NOT NULL
	, CardNo VARCHAR(30)
	, Tours VARCHAR(30)[] NOT NULL
	, HotelPickup BIT
	, HotelAddress VARCHAR(30)
	, Participants VARCHAR(30)[]
	, PRIMARY KEY(BookingID)
	, FOREIGN KEY(Tours) REFERENCES Tour(Name)
	);


PRAGMA foreign_keys=ON;
BEGIN;
INSERT INTO TOUR VALUES();
INSERT INTO TOUR VALUES('Gullni hringurinn', 01, 6, date('2020-06-09'), 'Suðurland', 19990, 0, '', 'Komdu og sjáðu Gullfoss og Geysir!...' );
INSERT INTO TOUR VALUES('Jökulsárlón', 02, 6, date('2020-07-13'),'Suðurland', 19990, 0, '', 'Upplifðu lón með jökulbrotum' );
INSERT INTO TOUR VALUES('Snorkla í Silfru', 03);
INSERT INTO TOUR VALUES('Dynjandi',04, 10, date('2020-05-26'), 'Vestfirðir', 14990, 0, '', 'Foss');
INSERT INTO REVIEW VALUES();
INSERT INTO BOOKING VALUES();



INSERT INTO EMPLOYEE VALUES('James','E','Borg','888665555',date('1937-11-10'),'450 Stone, Houston, TX','M',55000,NULL,1);
INSERT INTO DEPARTMENT VALUES('Headquarters',1,'888665555',date('1981-06-19'));
END;
BEGIN;
INSERT INTO EMPLOYEE VALUES('Franklin','T','Wong','333445555',date('1955-12-08'),'638 Voss, Houston, TX','M',40000,'888665555',5);
INSERT INTO DEPARTMENT VALUES('Research',5,'333445555',date('1988-05-22'));
END;
BEGIN;
INSERT INTO EMPLOYEE VALUES('Jennifer','S','Wallace','987654321',date('1941-06-20'),'291 Berry, Bellaire, TX','F',43000,'888665555',4);
INSERT INTO DEPARTMENT VALUES('Administration',4,'987654321',date('1995-01-01'));
END;

INSERT INTO DEPT_LOCATIONS VALUES(1,'Houston');
INSERT INTO DEPT_LOCATIONS VALUES(4,'Stafford');
INSERT INTO DEPT_LOCATIONS VALUES(5,'Bellaire');
INSERT INTO DEPT_LOCATIONS VALUES(5,'Sugarland');
INSERT INTO DEPT_LOCATIONS VALUES(5,'Houston');
INSERT INTO EMPLOYEE VALUES('John','B','Smith','123456789',date('1965-01-09'),'731 Fondren, Houston, TX','M',30000,'333445555',5);
INSERT INTO EMPLOYEE VALUES('Alicia','J','Zelaya','999887777',date('1968-01-19'),'3321 Castle, Spring, TX','F',25000,'987654321',4);
INSERT INTO EMPLOYEE VALUES('Ramesh','K','Narayan','666884444',date('1962-09-15'),'975 Fire Oak, Humble, TX','M',38000,'333445555',5);
INSERT INTO EMPLOYEE VALUES('Joyce','A','English','453453453',date('1972-07-31'),'5631 Rice, Houston, TX','F',25000,'333445555',5);
INSERT INTO EMPLOYEE VALUES('Ahmad','V','Jabbar','987987987',date('1969-03-29'),'980 Dallas, Houston, TX','M',25000,'987654321',4);
INSERT INTO PROJECT VALUES('ProductX',1,'Bellaire',5);
INSERT INTO PROJECT VALUES('ProductY',2,'Sugarland',5);
INSERT INTO PROJECT VALUES('ProductZ',3,'Houston',5);
INSERT INTO PROJECT VALUES('Computerization',10,'Stafford',4);
INSERT INTO PROJECT VALUES('Reorganization',20,'Houston',1);
INSERT INTO PROJECT VALUES('Newbenefits',30,'Stafford',4);
INSERT INTO WORKS_ON VALUES('123456789',1,32.5);
INSERT INTO WORKS_ON VALUES('123456789',2,7.5);
INSERT INTO WORKS_ON VALUES('666884444',3,40.0);


--INSERT INTO WORKS_ON VALUES('888665555',20,NULL); -- �l�glegt: Hours m� ekki vera NULL
INSERT INTO WORKS_ON VALUES('888665555',20,0.0);
INSERT INTO DEPENDENT VALUES('333445555','Alice','F',date('1986-04-05'),'Daughter');
INSERT INTO DEPENDENT VALUES('333445555','Theodore','M',date('1983-10-25'),'Son');
INSERT INTO DEPENDENT VALUES('333445555','Joy','F',date('1958-05-03'),'Spouse');
INSERT INTO DEPENDENT VALUES('987654321','Abner','M',date('1942-02-28'),'Spouse');
INSERT INTO DEPENDENT VALUES('123456789','Michael','M',date('1988-01-04'),'Son');
INSERT INTO DEPENDENT VALUES('123456789','Alice','F',date('1988-12-30'),'Daughter');
INSERT INTO DEPENDENT VALUES('123456789','Elizabeth','F',date('1967-05-05'),'Spouse');
