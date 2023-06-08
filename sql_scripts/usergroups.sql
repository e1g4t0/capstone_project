CREATE SEQUENCE mv_usergroup_seq start with 100;

CREATE TABLE user_group (
  user_group_id BIGINT NOT NULL DEFAULT nextval('mv_usergroup_seq'),
  username VARCHAR(128) NOT NULL UNIQUE,
  auth_group VARCHAR(128) NOT NULL,
  PRIMARY KEY(user_group_id),
  FOREIGN KEY(username) REFERENCES users(username),
);

CREATE TABLE

ALTER SEQUENCE mv_usergroup_seq OWNED BY user_group.user_group_id;