CREATE SEQUENCE mv_movie_seq start with 100;
CREATE SEQUENCE mv_movieactor_seq start with 100;

CREATE TABLE movie (
  movie_id bigint NOT NULL DEFAULT nextval('mv_movie_seq'),
  name varchar(200) DEFAULT NULL,
  rating real DEFAULT NULL,
  release_year date DEFAULT NULL,
  country varchar(200) DEFAULT NULL,
  director varchar(200) DEFAULT NULL,
  description varchar(500) DEFAULT NULL,
  PRIMARY KEY (movie_id)
);

CREATE TABLE movie_actor (
    movie_actor_id bigint NOT NULL DEFAULT nextval('mv_movieactor_seq'),
    movie_id bigint NOT NULL,
    actor_id bigint NOT NULL,
    PRIMARY KEY (movie_actor_id),
    FOREIGN KEY (movie_id) REFERENCES movie(movie_id),
    FOREIGN KEY (actor_id) REFERENCES actors(actor_id)
);

ALTER SEQUENCE mv_movie_seq OWNED BY movie.movie_id;
ALTER SEQUENCE mv_movieactor_seq OWNED BY movie_actor.movie_actor_id;

INSERT INTO movie(movie_id, name, rating, release_year, country, director, description)
VALUES
(1, 'Leather Guys', 9.9, '2000-11-11', 'USA', 'BestDirector', 'Leather guys having leather issues'),
(2, 'Best Flex', 10.0, '2010-11-11', 'Japan', 'The best flexer', 'Ricardo giving his best flex'),
(3, 'Best Gachi', 9.9,'2010-11-11', 'Japan', 'The best flexer', 'Best flex sequel');

INSERT INTO movie_actor(movie_actor_id, movie_id, actor_id)
VALUES
(1, 1, 2),
(2, 1, 3),
(3, 2, 1),
(4, 3, 1);
