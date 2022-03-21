drop table if exists halls;
CREATE TABLE halls(
                      id SERIAL PRIMARY KEY,
                      seats integer not null);
drop table if exists movies;
CREATE TABLE movies(
                      id SERIAL PRIMARY KEY,
                      title varchar(50) not null,
                      year integer not null,
                      restriction integer not null,
                      description varchar(1000) not null,
                      poster varchar(1000));