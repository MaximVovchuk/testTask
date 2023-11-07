package com.botscrew.testTask.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "department_name")
    private String departmentName;
    @ManyToOne
    @JoinColumn(name = "head_of_department_id")
    private Lector headOfDepartment;
    @ManyToMany(mappedBy = "departments", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Lector> lectors;
}
