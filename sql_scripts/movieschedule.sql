CREATE SEQUENCE mv_schedule_seq start with 100;
CREATE SEQUENCE mv_user_seq start with 100;
CREATE SEQUENCE mv_ticket_seq start with 100;

CREATE TABLE movie_schedule (
  schedule_id bigint NOT NULL DEFAULT nextval('mv_schedule_seq'),
  movie_id bigint NOT NULL,
  hall_id bigint NOT NULL,
  movie_date date NOT NULL,
  movie_time time NOT NULL,
  price INTEGER,
  PRIMARY KEY (schedule_id),
  FOREIGN KEY (movie_id) REFERENCES movie(movie_id),
  FOREIGN KEY (hall_id) REFERENCES halls(hall_id)
);

CREATE TABLE users(
  user_id bigint NOT NULL DEFAULT nextval('mv_user_seq'),
  username varchar(200) UNIQUE,
  first_name varchar(200) NOT NULL,
  last_name varchar(200) DEFAULT NULL,
  password varchar(256) NOT NULL,
  role varchar(128) NOT NULL,
  birth_date date DEFAULT NULL,
  telephone varchar(12) DEFAULT NULL,
  email varchar(200) NOT NULL,
  PRIMARY KEY (user_id)
);

CREATE TABLE tickets(
  ticket_id bigint NOT NULL DEFAULT nextval('mv_ticket_seq'),
  user_id bigint NOT NULL,
  schedule_id bigint NOT NULL,
  seat_id bigint NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (schedule_id) REFERENCES movie_schedule(schedule_id),
  FOREIGN KEY (seat_id) REFERENCES seats(seat_id)
);

ALTER SEQUENCE mv_schedule_seq OWNED BY movie_schedule.schedule_id;
ALTER SEQUENCE mv_user_seq OWNED BY users.user_id;
ALTER SEQUENCE mv_ticket_seq OWNED BY tickets.ticket_id;