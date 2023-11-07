CREATE TABLE lector_department
(
    lector_id bigint,
    department_id bigint,
    PRIMARY KEY (lector_id, department_id),
    FOREIGN KEY (lector_id) REFERENCES lector (id),
    FOREIGN KEY (department_id) REFERENCES department (id)
);