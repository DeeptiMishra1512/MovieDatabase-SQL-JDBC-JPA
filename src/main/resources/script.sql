INSERT INTO MOVIES (title,runtime,genre,imdb_score,rating) VALUES('Howard the Duck',110, 'Sci-Fi',4.6,'PG');
 INSERT INTO MOVIES (title,runtime,genre,imdb_score,rating) VALUES('Lavalantula',83, 'HORROR',4.7,'TV-14');
 INSERT INTO MOVIES (title,runtime,genre,imdb_score,rating) VALUES('Starship Troopers',129, 'Sci-Fi',7.2,'PG-13');
 INSERT INTO MOVIES (title,runtime,genre,imdb_score,rating) VALUES('Waltz With Bashir',90, 'Documentary',8.0,'R');
 INSERT INTO MOVIES (title,runtime,genre,imdb_score,rating) VALUES('Spaceballs',96, 'COMEDY',7.1,'PG');
 INSERT INTO MOVIES (title,runtime,genre,imdb_score,rating) VALUES('Monsters Inc.',92, 'Animation',8.1,'G');
 INSERT INTO MOVIES (title,runtime,genre,imdb_score,rating) VALUES('Back To Future',96, 'Sci-Fi',7.1,'PG');
 INSERT INTO MOVIES (title,runtime,genre,imdb_score,rating) VALUES('Despicable Me 4',102, 'COMEDY',6.2,'PG');



Select * from movies where genre = 'Sci-Fi';

select * from Movies where imdb_score >= 6.5;

select * from movies where rating IN('G', 'PG') AND runtime < 100;

select genre, AVG(runtime) from movies group by genre,IMDB_Score having IMDB_Score >7.5;

update movies set rating = 'R' where title = 'Starship Troopers';

select ID, rating from movies where genre IN('HORROR' , 'Documentary');

select rating , AVG(IMDB_SCORE) AS AVG_IMDB, MAX(IMDB_SCORE) AS MAX_IMDB, MIN(IMDB_SCORE) AS MIN_IMDB from movies group by rating;

select rating , AVG(IMDB_SCORE) AS AVG_IMDB, MAX(IMDB_SCORE) AS MAX_IMDB, MIN(IMDB_SCORE) AS MIN_IMDB from movies group by rating having COUNT(*) >1;

delete from movies where rating = 'R';