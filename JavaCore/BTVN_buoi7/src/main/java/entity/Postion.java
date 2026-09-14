package entity;

import enums.PositionName;

public class Postion {
    private Integer postionId;
    private PositionName positionName;

    public Postion(Integer postionId, PositionName positionName) {
        this.postionId = postionId;
        this.positionName = positionName;
    }

    public Postion() {
    }

    public Integer getPostionId() {
        return postionId;
    }

    public void setPostionId(Integer postionId) {
        this.postionId = postionId;
    }

    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }
    public void hienThiTheoDong () {
        System.out.printf("|%-15s|%-30s|\n", getPostionId(), getPositionName());

    }
}
