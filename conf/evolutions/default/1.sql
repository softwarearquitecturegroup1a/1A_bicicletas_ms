# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table bicicleta (
  serial                        bigint auto_increment not null,
  marca                         varchar(255),
  color                         varchar(255),
  ubicacion						varchar(255),
  estado						varchar(255),
  constraint pk_bicicleta primary key (serial)
);


# --- !Downs

drop table if exists bicicleta;

