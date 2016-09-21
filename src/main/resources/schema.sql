create table if not exists race_time (
    racer_id integer not null,
    timestamp timestamp not null,
    time bigint not null,
    primary key (racer_id, timestamp)
);