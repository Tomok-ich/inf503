import java.io.Serializable;
// Отмечаем класс как сериалезуемый
public class Game implements Serializable {
    private Double xPosition;
    private Double yPosition;
    private Integer level;

    public Game() {
    }

    public Game(Double xPosition, Double yPosition, Integer level, Integer power) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.level = level;
        this.power = power;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getyPosition() {
        return yPosition;
    }

    public void setyPosition(Double yPosition) {
        this.yPosition = yPosition;
    }

    public Double getxPosition() {
        return xPosition;
    }

    public void setxPosition(Double xPosition) {
        this.xPosition = xPosition;
    }

    private Integer power;

    @Override
    public String toString() {
        return "Game{" +
                "xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", level=" + level +
                ", power=" + power +
                '}';
    }
}
