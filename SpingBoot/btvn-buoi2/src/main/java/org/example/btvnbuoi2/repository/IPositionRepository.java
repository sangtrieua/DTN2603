package org.example.btvnbuoi2.repository;

import org.example.btvnbuoi2.entity.Position;
import org.example.btvnbuoi2.enums.PositionName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position,Integer> {
    boolean existsPositionByPositionName(PositionName positionName);

    Position findPositionByPositionName(PositionName positionName);
}
