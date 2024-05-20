create table TRAINING_CENTER(
  ID int not null AUTO_INCREMENT,
  CENTER_NAME varchar(100) not null,
  CENTER_CODE varchar(100) not null,
  STUDENT_CAPACITY int not null,
  CONTACT_EMAIL varchar(100) not null,
  CONTACT_PHONE varchar(100) not null,
  COURSES varchar(500) not null,
  CREATED_ON DATE not null,
  ADDRESS_ID int not null,
  PRIMARY KEY ( ID )
);

create table ADDRESS(
  ID int not null AUTO_INCREMENT,
  FULL_ADDRESS varchar(500) not null,
  CITY varchar(100) not null,
  STATE varchar(100) not null,
  PIN int not null,
  PRIMARY KEY ( ID )
);