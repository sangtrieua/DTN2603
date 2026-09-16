package backend.service.impl;

import backend.repository.IPositionRepository;
import backend.repository.impl.PositionRepositoryImpl;
import backend.service.IPositionService;
import entity.Postion;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    IPositionRepository positionRepository ;
    public PositionServiceImpl() {
        positionRepository = new PositionRepositoryImpl();
    }
    @Override
    public boolean kiemTraTonTaiPostionId(Integer positionId) {
        return positionRepository.kiemTraTonTaiPostionId(positionId);
    }

    @Override
    public Postion getPostionById(int positionId) {
        return positionRepository.getPostionById(positionId);
    }

    @Override
    public List<Postion> getPostions() {
        return positionRepository.getPostions();
    }

}
