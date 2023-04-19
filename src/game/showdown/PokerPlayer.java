package game.showdown;

public abstract class PokerPlayer extends game.Player<Card> {

    private Integer point = 0;

    public abstract void nameHimself();

    public void gainPoint(Integer addedPoint) {
        this.setPoint(this.point + addedPoint);
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getPoint() {
        return point;
    }
}
