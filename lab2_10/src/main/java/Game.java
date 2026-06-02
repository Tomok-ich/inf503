import java.io.Serializable;

public class Game implements Serializable {

    @Transient
    private Double xPosition;

    @PrintNullValueAs("null")
    private Double yPosition;

    private Integer level = 0;

    @Transient
    private Integer power = 100;

    @PrintByGetter
    @PrintNullValueAs("unknown")
    public String gamerName;

    public Game() {
    }

    public Game(String gamerName) {
        this.gamerName = gamerName;
    }

    public Game(Double xPosition,
                Double yPosition,
                Integer level,
                Integer power) {

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

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getGamerName() {
        return gamerName;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }

    private Double getRadiusVector() {
        return Math.sqrt(xPosition * xPosition +
                yPosition * yPosition);
    }

    @Override
    public String toString() {
        return "Game{" +
                "xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", level=" + level +
                ", power=" + power +
                ", gamerName='" + gamerName + '\'' +
                '}';
    }
}