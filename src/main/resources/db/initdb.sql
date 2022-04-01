CREATE SEQUENCE  if not exists  premieres_id_seq;

CREATE TABLE  if not exists  premieres (
    id BIGINT  NOT null default nextval('premieres_id_seq'::regclass),
    name VARCHAR(200) not NULL,
    description VARCHAR(500) not NULL,
    ageCategory INT not NULL,
    numberOfSeats INT not NULL,
    PRIMARY KEY (id)
    );