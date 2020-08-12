create table Theator (
  theatorid int GENERATED ALWAYS AS IDENTITY not null,
  theatorname varchar(50) not null, 
  zipcode integer, 
  primary key (theatorid));

create table Movie (
  movieid int GENERATED ALWAYS AS IDENTITY not null,
  moviename varchar(50) not null, 
  description varchar(255),
  primary key (movieid));

create table MovieTime (
  theatorid int,
  movieid int,
  timeid int GENERATED ALWAYS AS IDENTITY not null,
  moviedate Date,
  startat time,
  duration varchar(25),
  primary key(theatorid, movieid, timeid),
  foreign key (movieid) references Movie,
  foreign key (theatorid) references Theator);

insert into Theator (theatorname, zipcode) 
values ('Cinemark Legacy and XD', 75025);

insert into Theator (theatorname, zipcode) 
values ('K9 Cinemas', 75025);

insert into Theator (theatorname, zipcode) 
values ('AMC Highland Village', 75028);

insert into Theator (theatorname, zipcode) 
values ('Moviehouse & Eatery', 76039);

insert into Theator (theatorname, zipcode)
values ('Studio Movie Grill', 75093);

insert into Movie (moviename, description)
values ('Tenet', 'John David Washington is the new Protagonist in
 Christopher Nolan’s original sci-fi action spectacle “Tenet.”');

insert into Movie (moviename, description)
values ('Unhinged', 'Rachel (Caren Pistorius) is running late to work when she 
has an altercation at a traffic light with a stranger (Crowe) whose life has left him feeling powerless and invisible.');

insert into Movie (moviename, description)
values ('The Broken Hearts Gallery', 'THE BROKEN HEARTS GALLERY follows the always unique Lucy 
(Geraldine Viswanathan), a 20-something art gallery assistant living in New York City, 
who also happens to be an emotional hoarder. ');

insert into Movie (moviename, description)
values ('Mulan', 'MULAN is the epic adventure of a fearless young woman
who masquerades as a man in order to fight Northern Invaders attacking China.');

insert into Movie (moviename, description)
values ('Cut Throat City', 'From director RZA comes the explosive CUT THROAT CITY, 
the story of four boyhood friends in New Orleans''  Lower Ninth Ward');

insert into MovieTime (theatorid, movieid, moviedate, startat, duration)
values (1, 1, '07/16/2020', '11:25:00', '1 HR 48 MIN');

insert into MovieTime (theatorid, movieid, moviedate, startat, duration)
values (1, 2, '07/16/2020', '15:25:21', '2 HR 37 MIN');

insert into MovieTime (theatorid, movieid, moviedate, startat, duration)
values (1, 3, '07/13/2020', '20:15:02', '1 HR 15 MIN');

insert into MovieTime (theatorid, movieid, moviedate, startat, duration)
values (2, 4, '07/16/2020', '23:14:12', '1 HR 32 MIN');

insert into MovieTime (theatorid, movieid, moviedate, startat, duration)
values (2, 5, '07/20/2020', '20:05:00', '1 HR 50 MIN');

insert into MovieTime (theatorid, movieid, moviedate, startat, duration)
values (3, 1, '07/01/2020', '19:12:13', '1 HR 48 MIN');

insert into MovieTime (theatorid, movieid, moviedate, startat, duration)
values (3, 5, '07/01/2020', '18:09:07', '1 HR 50 MIN');

insert into MovieTime (theatorid, movieid, moviedate, startat, duration)
values (4, 2, '07/14/2020', '14:35:09', '2 HR 37 MIN');

insert into MovieTime (theatorid, movieid, moviedate, startat, duration)
values (4, 3, '07/16/2020', '16:45:45', '1 HR 15 MIN');

insert into MovieTime (theatorid, movieid, moviedate, startat, duration)
values (4, 4, '07/18/2020', '10:10:10', '1 HR 32 MIN');


insert into Movietime (theatorid, movieid, moviedate, startat, duration)
values (5, 1, '08/01/2020', '06:22:10', '1 HR 59 MIN');

insert into Movietime (theatorid, movieid, moviedate, startat, duration)
values (5, 2, '08/02/2020', '07:22:10', '1HR 59 MIN');



 


