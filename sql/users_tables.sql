CREATE TABLE dict_role
(
  id          SMALLINT NOT NULL,
  description VARCHAR  NOT NULL,
  CONSTRAINT dict_role_pkey PRIMARY KEY (id)
);

CREATE TABLE users
(
  id          SERIAL       NOT NULL,
  login       VARCHAR(125) NOT NULL UNIQUE,
  password    VARCHAR(125) NOT NULL,
  description VARCHAR      NULL,
  disabled    BOOLEAN      NOT NULL DEFAULT FALSE,
  CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE user_role
(
  user_id INT      NOT NULL,
  role_id SMALLINT NOT NULL,
  CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id),
  CONSTRAINT user_role_user_fkey FOREIGN KEY (user_id)
  REFERENCES users (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT user_role_role_fkey FOREIGN KEY (role_id)
  REFERENCES dict_role (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);