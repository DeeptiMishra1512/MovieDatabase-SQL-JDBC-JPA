# SQL Worksheet

Proceed through the sections below, testing out the queries shown and observing the result. Use the included H2 console to run your queries. Feel free to experiment with your own variations on these queries. This will help to build your familiarity with the process of working with SQL queries.

## Clauses

Select Clause  
From Clause

#### Insert people into People table

```SQL
INSERT INTO PEOPLE (LAST_NAME, FIRST_NAME, MOBILE, BIRTHDAY)
VALUES ('Smith', 'John', '230-4293', '1973-01-23');
```

Following the example, insert at least three other people into the table.

#### Selecting all rows from table 

```SQL
SELECT * FROM PEOPLE;
```

#### Updating rows

Update firstname for person whose id is 1

```SQL
UPDATE PEOPLE SET FIRST_NAME = 'TONY' WHERE ID = 1;
```

Update mobile where last names are Smith

```SQL
UPDATE PEOPLE SET MOBILE = '152-9854' WHERE LAST_NAME = 'Smith';
```

Update multiple columns with multiple conditions

```SQL
UPDATE people SET birthday = '1955-01-25' 
WHERE 
	last_name = 'Smith' 
	AND id = 4;
```

```SQL
UPDATE people SET mobile = '333-3333', last_name = 'Johnson' 
WHERE first_name = 'Noelle' OR first_name = 'Raj';
```

## Basic Functions

```SQL
SELECT * FROM PEOPLE;
```

```SQL
SELECT COUNT(HOMEPHONE) FROM HOMES;
```

```SQL
SELECT HOMENUMBER FROM HOME WHERE ID = 1;
```

```SQL
SELECT COUNT(*) FROM HOME;
```

```SQL
SELECT COUNT(DISTINCT last_name) FROM PEOPLE;
```

```SQL
SELECT  SUM(ID), AVG(ID) FROM PEOPLE;
```

```SQL
SELECT SUM(ID) AS sum, AVG(ID) AS avg FROM PEOPLE;
```

```SQL
SELECT MIN(birthday) FROM PEOPLE;
```

## Strings

```SQL
SELECT UPPER (FRIST_NAME), LOWER(LAST_NAME) FROM PEOPLE;
```

```SQL
SELECT REPLACE(LAST_NAME, 'a', '1') FROM PEOPLE;
```

```SQL
SELECT LAST_NAME FROM PEOPLE;
```

```SQL
INSERT INTO people (FIRST_NAME, LAST_NAME, MOBILE) 
VALUES ('Otto', 'Von Count', '656-6548');
```

```SQL
SELECT CONCAT(FIRST_NAME, LAST_NAME) FROM people
WHERE LAST_NAME = 'Smith'
```

```SQL
SELECT CONCAT(first_name, ' ', last_name) 
FROM people 
WHERE last_name = 'Smith'
```

```SQL
SELECT CONCAT_WS(' ',first_name, last_name, mobile) 
FROM people WHERE last_name= 'Smith'
```

```SQL
SELECT HOMENUMBER, LEFT(HOMENUMBER, 3), RIGHT(HOMENUMBER, 2) FROM HOME
```

```SQL
SELECT LENGTH(address), CHAR_LENGTH(address) FROM HOME;
```

```SQL
CREATE TABLE length_test (string varchar(10) );
```

```SQL
INSERT INTO length_test VALUES ('$'),('€');
```

```SQL
SELECT string, LENGTH(string), CHAR_LENGTH(string) FROM length_test
```

## Compare

```SQL
SELECT first_name, last_name, YEAR(birthday) FROM people WHERE birthday >= '1970-07-06' AND birthday<='1987-07-06';
```

```SQL
SELECT first_name, birthday FROM people WHERE first_name='Thomas' OR first_name='Raj' OR first_name='Sheeri';
```

```SQL
SELECT first_name, birthday FROM people WHERE first_name IN ('Noelle', 'Thomas', 'Raj');
```

#### Wild Cards

```SQL
SELECT first_name FROM PEOPLE WHERE RIGHT(first_name,1)='e';
```

```SQL
SELECT first_name FROM people WHERE first_name LIKE '%j'; 
```

```SQL
SELECT first_name FROM people WHERE first_name LIKE '%o%';
```

```SQL
SELECT first_name FROM people WHERE first_name NOT LIKE '%o%';
```

```SQL
SELECT COUNT(*) FROM PEOPLE
```

```SQL
SELECT last_name, COUNT(*) FROM people GROUP BY last_name;
```

```SQL
SELECT last_name, GROUP_CONCAT(mobile) FROM PEOPLE GROUP BY last_name;
```

```SQL
SELECT last_name, GROUP_CONCAT(mobile SEPARATOR ' and ') FROM people GROUP BY last_name;
```

```SQL
SELECT last_name, GROUP_CONCAT(mobile SEPARATOR ' and ') FROM people GROUP BY last_name  HAVING COUNT(*)>1;
```

```SQL
SELECT last_name, GROUP_CONCAT(mobile SEPARATOR ' and ') FROM people WHERE last_name != 'Cabral' GROUP BY last_name  HAVING COUNT(*)>1;
```

#### Sorting 

```SQL
SELECT first_name, birthday FROM people ORDER BY birthday;
```

```SQL
SELECT first_name, birthday FROM people ORDER BY birthday DESC;
```

```SQL
SELECT first_name, last_name FROM people ORDER BY last_name, first_name;
```

```SQL
SELECT first_name, birthday FROM people ORDER BY birthday DESC LIMIT 3;
```

```SQL
SELECT first_name, MONTHNAME(birthday) as mon, birthday FROM people ORDER BY MONTH(birthday);
```

```SQL
SELECT last_name, COUNT(*) FROM  people GROUP BY last_name;
```

```SQL
SELECT last_name, COUNT(*) FROM  people GROUP BY last_name ORDER BY NULL;
```

## Inserting and Replacing Records

```SQL
INSERT INTO people (first_name, last_name, birthday, home_id)
	VALUES
	('John', 'Smith', '1998-04-07', 4),
	('Maya', 'Wasserman' , NULL, 4),
	('Paul', 'Thompson', '1996-05-27', 1);
```

#### Replace

```SQL
DELETE FROM people WHERE first_name='Maya';
```

```SQL
SELECT * FROM people;
```

```SQL
MERGE INTO people (first_name, last_name, birthday, home_id)
	VALUES
	('John', 'Sharma', '1998-04-07', 1),
	('Paul', 'Sharma', '1996-05-27', 4),
	('Maya', 'Wasserman', '1900-01-05',1);
```


## JOIN

```SQL
INSERT INTO people (first_name, last_name, birthday)
	VALUES ('Eli', 'Kramer', '1984-01-15');
```
	
	
```SQL
SELECT * FROM people;
```

```SQL
SELECT * FROM home;
```

```SQL
SELECT p.first_name, h.address 
FROM PEOPLE p
INNER JOIN HOME h  on (p.HOME_ID = h.ID)
```

```SQL
SELECT first_name, last_name
FROM PEOPLE p
INNER JOIN HOME h  on (p.HOME_ID = h.HOME_ID)
WHERE p.HOME_ID = 1
```

```SQL
SELECT p.*, h.address, h.homenumber
FROM PEOPLE p
INNER JOIN HOME h  on (p.HOME_ID = h.HOME_ID)
WHERE p.first_name  LIKE '%e%'
```

##### Exercise:

Devise a report
	show all the people in your address table
	only if you know their birthday
	show name, address and birthday
	order by month, so January birthdays are first

Devise a report
	Output all information for all people and their home information


	
## UNION

The UNION operator is used to combine the result-set of two or more SELECT statements.

Notice that each SELECT statement within the UNION must have the same number of columns. The columns must also have similar data types. Also, the columns in each SELECT statement must be in the same order.

SELECT _column\_name(s)_ FROM table1
	UNION
SELECT _column\_name(s)_ FROM table2;

Note: The UNION operator selects only distinct values by default. To allow duplicate values, use the ALL keyword with UNION.

SELECT _column\_name(s)_ FROM table1
	UNION ALL
SELECT _column\_name(s)_ FROM table2;

##### Example

```SQL
SELECT HOME_ID FROM People
UNION
SELECT HOME_ID FROM Home
ORDER 	BY HOME_ID; 
```

```SQL
SELECT HOME_ID FROM People
UNION ALL
SELECT HOME_ID FROM Home
ORDER 	BY HOME_ID; 
```



