package org.example.btvnbuoi2.entity;


import jakarta.persistence.*;
import lombok.*;
import org.example.btvnbuoi2.enums.PositionName;

@Entity
@Table(name = "`position`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "position_name")
    @Enumerated(EnumType.STRING)
    private PositionName positionName;



    public void hienThiTheoDong () {
        System.out.printf("|%-15s|%-30s|\n", getPositionId(), getPositionName());

    }
}
