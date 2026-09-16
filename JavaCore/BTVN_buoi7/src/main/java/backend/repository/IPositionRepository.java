package backend.repository;

import entity.Postion;

import java.util.List;

public interface IPositionRepository {
    boolean kiemTraTonTaiPostionId(Integer positionId);

    Postion getPostionById(int positionId);

    List<Postion> getPostions();
}
