CREATE SEQUENCE mv_actors_seq start with 100;

CREATE TABLE actors (
  actor_id bigint NOT NULL DEFAULT nextval('mv_actors_seq'),
  first_name varchar(200) DEFAULT NULL,
  last_name varchar(200) DEFAULT NULL,
  birth_date date DEFAULT NULL,
  rating real DEFAULT NULL,
  country varchar(200) DEFAULT NULL,
  PRIMARY KEY (actor_id)
);

ALTER SEQUENCE mv_actors_seq OWNED BY actors.actor_id;

INSERT INTO actors(actor_id, first_name, last_name, birth_date, rating, country)
VALUES
(1, 'Ricardo', 'Milos', '1977-11-11', 10.0, 'Brazil'),
(2, 'Billy', 'Herrington', '1969-07-14', 9.9, 'USA'),
(3, 'Van', 'Darkholme', '1972-10-24', 9.8, 'Vietnam');