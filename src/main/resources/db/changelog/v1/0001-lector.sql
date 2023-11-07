create table "lector"
(
    "id"        bigserial            PRIMARY KEY,
    "full_name" varchar(90)          NOT NULL,
    "degree"    int                  NOT NULL,
    "salary"    numeric              NOT NULL
)