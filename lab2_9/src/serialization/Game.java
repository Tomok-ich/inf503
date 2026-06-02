package src.serialization;

import java.io.Serializable;
// Отмечаем класс как сериализуемый
public class Game implements Serializable {
    private Double xPosition;
    private Double yPosition;
    private Integer level;
    private Integer power;

    public Game() {
    }

    public Game(Double xPosition, Double yPosition, Integer level, Integer power) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.level = level;
        this.power = power;
    }

    public Double getxPosition() {
        return xPosition;
    }

    public void setxPosition(Double xPosition) {
        this.xPosition = xPosition;
    }

    public Double getyPosition() {
        return yPosition;
    }

    public void setyPosition(Double yPosition) {
        this.yPosition = yPosition;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

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
