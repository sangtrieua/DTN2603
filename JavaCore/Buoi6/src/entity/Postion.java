package entity;

public class Postion {
    private int postionId;
    private String positionName;

    public Postion(int postionId, String positionName) {
        this.postionId = postionId;
        this.positionName = positionName;
    }

    public Postion() {
    }

    public int getPostionId() {
        return postionId;
    }

    public void setPostionId(int postionId) {
        this.postionId = postionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
    public void hienThiTheoDong () {
        System.out.printf("|%-15s|%-30s|\n", getPostionId(), getPositionName());

    }
}
