DROP TABLE IF EXISTS shedlock;

create table shedlock
(
    name varchar(64) not null,
    lock_until timestamp not null,
    locked_at timestamp not null,
    lock_by varchar(255) null,
    constraint shedlock_pk
        primary key (name)
);
