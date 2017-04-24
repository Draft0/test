
# --- First database schema

# --- !Ups
create table Account (
id bigint not null,
mail varchar(255),
password varchar(255),
date_creation timestamp,
constraint id_Account primary key (id));

create sequence Account_seq start with 1000;

# --- !Downs
SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists Account;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists Account_seq;

