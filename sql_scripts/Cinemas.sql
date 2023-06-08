CREATE SEQUENCE mv_cinema_seq start with 100;
CREATE SEQUENCE mv_hall_seq start with 100;
CREATE SEQUENCE mv_seat_seq start with 100;

CREATE TABLE cinemas (
  cinema_id bigint NOT NULL DEFAULT nextval('mv_cinema_seq'),
  name varchar(200) DEFAULT NULL,
  address varchar(200) DEFAULT NULL,
  telephone varchar(12) DEFAULT NULL,
  PRIMARY KEY (cinema_id)
);

CREATE TABLE halls (
  hall_id bigint NOT NULL DEFAULT nextval('mv_hall_seq'),
  cinema_id bigint NOT NULL,
  hall_colour varchar(20) DEFAULT NULL,
  number_of_seats SMALLINT DEFAULT NULL,
  PRIMARY KEY (hall_id),
  FOREIGN KEY (cinema_id) REFERENCES cinemas(cinema_id)
);

CREATE TABLE seats (
  seat_id bigint NOT NULL DEFAULT nextval('mv_seat_seq'),
  seat_number SMALLINT NOT NULL,
  seat_type varchar(20) DEFAULT NULL,
  hall_id bigint NOT NULL ,
  is_booked boolean DEFAULT NULL,
  PRIMARY KEY (seat_id),
  FOREIGN KEY (hall_id) REFERENCES halls(hall_id)
);

ALTER SEQUENCE mv_cinema_seq OWNED BY cinemas.cinema_id;
ALTER SEQUENCE mv_hall_seq OWNED BY halls.hall_id;
ALTER SEQUENCE mv_seat_seq OWNED BY seats.seat_id;

INSERT INTO cinemas (cinema_id, name, address, telephone)
VALUES
(1, 'Best cinema for best movies', 'Kazakhstan, Almaty c., flex st., 228', '88005553535');

INSERT INTO halls (hall_id, cinema_id, hall_colour, number_of_seats)
VALUES
(1, 1, 'Red', 100),
(2, 1, 'Blue', 200);

INSERT INTO seats (seat_id, seat_number, seat_type, hall_id)
VALUES
(1, 1, 'VIP', 1),
(2, 2, 'Regular', 1),
(3, 3, 'Regular', 1),
(4, 4, 'Regular', 1),
(5, 5, 'VIP', 1),
(7, 7, 'VIP', 1),
(8, 1, 'VIP', 2),
(9, 2, 'VIP', 2),
(10, 3, 'VIP', 2),
(11, 4, 'VIP', 2),
(12, 5, 'Regular', 2),
(13, 6, 'Regular', 2);
