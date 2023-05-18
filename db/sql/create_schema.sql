CREATE TABLE customer
(
    id          bigserial NOT NULL,
    name        varchar(40) NOT NULL,
    email       varchar(40) NOT NULL,
    CONSTRAINT pk_customer PRIMARY KEY ( id )
);

CREATE TABLE project
(
    id        uuid NOT NULL,
    name        varchar(20) NOT NULL,
    date_start  date NOT NULL,
    date_end    date NOT NULL,
    type        varchar(30) NOT NULL,
    budget      double precision NOT NULL,
    CONSTRAINT pk_project PRIMARY KEY (id)
);

CREATE TABLE task
(
    id          uuid NOT NULL,
    name        varchar(20) NOT NULL,
    description varchar(50) NOT NULL,
    date_end    timestamp NOT NULL,
    id_project  uuid NOT NULL,
    CONSTRAINT pk_task PRIMARY KEY (id),
    CONSTRAINT fk_project FOREIGN KEY (id_project) REFERENCES project (id)
);