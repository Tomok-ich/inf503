import java.io.Serializable;

@GameState
// Отмечаем класс как сериализуемый
public class Game implements Serializable {
    private Double xPosition = 0.;
    private Double yPosition = 0.;
    private Integer level = 0;
    private Integer power = 100;
    public String gamerName;

    public Game() {
    }

    public Game(String gamerName) {
        this.gamerName = gamerName;
    }

    public Game(Double xPosition, Double yPosition, Integer level, Integer power) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.level = level;
        this.power = power;
    }

    public Double getXPosition() {
        return xPosition;
    }

    public void setXPosition(Double xPosition) {
        this.xPosition = xPosition;
    }

    public Double getYPosition() {
        return yPosition;
    }

    public void setYPosition(Double yPosition) {
        this.yPosition = yPosition;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    private Double getRadiusVector() {
        return Math.sqrt(xPosition * xPosition + yPosition * yPosition);
    }

    public String getGamerName() {
        return gamerName;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
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
