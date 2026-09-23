package backend.controller;

import backend.service.IPositionService;
import backend.service.impl.PositionServiceImpl;
import entity.Postion;

import java.util.List;

public class PostionController {
    IPositionService positionService;
    public PostionController() {
        positionService=new PositionServiceImpl();
    }
    public boolean kiemTraTonTaiPostionId(Integer positionId) {
        return positionService.kiemTraTonTaiPostionId(positionId);
    }
    public Postion getPostionById(int positionId){
        return positionService.getPostionById(positionId);
    }

    public List<Postion> getPostions() {
        return positionService.getPostions();
    }
}
