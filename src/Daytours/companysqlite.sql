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
	, Cname VARCHAR(30) NOT NULL // customername
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
INSERT INTO TOUR VALUES('Gullni hringurinn', 01, 6, date('2020-06-09'), 'Suðurland', 19990, 0, NULL, 'Komdu og sjáðu Gullfoss og Geysir!...' );
INSERT INTO TOUR VALUES('Jökulsárlón', 02, 6, date('2020-07-13'),'Suðurland', 19990, 0, NULL, 'Upplifðu lón með jökulbrotum' );
INSERT INTO TOUR VALUES('Snorkla í Silfru', 03);
INSERT INTO TOUR VALUES('Dynjandi',04, 10, date('2020-05-26'), 'Vestfirðir', 14990, 0, NULL, 'Foss');

//test
INSERT INTO REVIEW VALUES('notandi', 'hér er mitt review.');
INSERT INTO BOOKING VALUES(333, 'Palli', '821-1234', '5555-4565-2345', ['Gullni hringurinn'], 1, 'Suðugata 2', NULL, );
END;


