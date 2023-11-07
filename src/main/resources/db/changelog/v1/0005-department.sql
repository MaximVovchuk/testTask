create table "department"
(
    "id"                        bigserial            PRIMARY KEY,
    "department_name"           varchar(90)          NOT NULL,
    "head_of_department_id"     bigint,
    FOREIGN KEY ("head_of_department_id") REFERENCES lector ("id") ON DELETE SET NULL
)