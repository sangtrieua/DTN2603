package org.example.btvnbuoi2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_name",nullable = false,length = 100,unique = true)
    private String departmentName;


    public void hienThiTheoDong(){

        System.out.printf("|%-15s|%-30s|\n",getDepartmentId(),getDepartmentName());

    }
}
