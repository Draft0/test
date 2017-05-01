-- Table: public.roles

-- DROP TABLE public.roles;

CREATE TABLE public.roles
(
  id integer NOT NULL,
  name character(255) NOT NULL,
  CONSTRAINT roles_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.roles
  OWNER TO play;

-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
  id integer NOT NULL,
  email character(255) NOT NULL,
  password character(255) NOT NULL,
  date timestamp,
  CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.users
  OWNER TO play;
-- Table: public.user_roles

-- DROP TABLE public.user_roles;

CREATE TABLE public.user_roles
(
  user_id integer NOT NULL,
  role_id integer NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (user_role) REFERENCES roles (id),

 CONSTRAINT keys unique (user_id, role_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.user_roles
  OWNER TO play;

  --insert data

  INSERT INTO users VALUES (1, 'play', 'play');

  INSERT INTO roles VALUES (1,'ROLE_USER');
  INSERT INTO roles VALUES (2,'ROLE_ADMIN');

  INSERT INTO user_roles VALUES (1, 2);
