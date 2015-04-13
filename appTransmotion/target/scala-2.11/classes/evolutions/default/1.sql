# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table piece_route (
  id                        integer not null,
  nombre_estacion11         varchar(255),
  nombre_estacion12         varchar(255),
  nombre_bus1               varchar(255),
  tiempo                    integer,
  congestion                integer,
  constraint pk_piece_route primary key (id))
;

create sequence piece_route_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists piece_route;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists piece_route_seq;

