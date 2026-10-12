package org.example.btvnbuoi2.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "email", unique = true, nullable = false,length = 100)
    private String email;

    @Column(name = "username", unique = true, nullable = false,length = 100)
    private String userName;

    @Column(name = "fullname",  nullable = false,length = 100)
    private String fullName;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne()
    @JoinColumn(name = "position_id")
    private Position position;

    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private LocalDate createDate;




    public void hienThiTheoDong(){
        System.out.printf("|%-10s|%-35s|%-15s|%-20s|%-10s|%-10s|%-20s|\n",this.accountId,this.email,this.userName,this.fullName,this.department.getDepartmentId(),this.position.getPositionId(),this.createDate);

    }


}
