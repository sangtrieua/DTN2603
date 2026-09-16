package backend.service;

import entity.Postion;

import java.util.List;

public interface IPositionService {
    boolean kiemTraTonTaiPostionId(Integer positionId);
    Postion getPostionById(int positionId);

    List<Postion> getPostions();
}
