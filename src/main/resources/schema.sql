DROP TABLE if EXISTS userplayer;
CREATE TABLE userplayer (
  username VARCHAR (55) PRIMARY KEY,
  treasure int(10),
  password VARCHAR(70) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1);

DROP TABLE if EXISTS authorities;
CREATE TABLE authorities (
  authority_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (authority_id),
  UNIQUE KEY uni_username_role (role,username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES userplayer (username));


DROP TABLE if EXISTS game;
CREATE TABLE game (
  game_id int(11) NOT NULL AUTO_INCREMENT,
  total_bet int(10) NOT null,
  won TINYINT NOT null ,
  prize int(8) NOT null ,
  player VARCHAR (55),
  constraint fk_player FOREIGN KEY (player) REFERENCES userplayer (username));
