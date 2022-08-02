create table person(
    id integer not null ,
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    primary key(id)
);

INSERT INTO person(id, name, location, birth_date) values (1, 'komble', 'chrelashvili', CURRENT_TIMESTAMP());
INSERT INTO person(id, name, location, birth_date) values (2, 'batoni', 'tavadishvili', CURRENT_TIMESTAMP());