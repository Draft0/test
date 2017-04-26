
# --- public Shema


# --- !Ups

 create table user (
 id                 bigint NOT NULL,
 mail               varchar(255),
 password           varchar(255),
 date_creation      timestamp,
 primary key (id))
;

# --- !Downs

drop table user;


