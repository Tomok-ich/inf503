package src.databas;

import java.io.Serializable;
import java.util.Date;

public class Many implements Serializable {
    private Integer id;
    private byte type;  // 1 - доход, -1 расход
    private String name;
    private Date date;
    private Float summ;
    private String comment;

    public Many() {
    }

    public Many(Integer id, byte type, String name, Date date, Float summ, String comment) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.date = date;
        this.summ = summ;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public byte getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Float getSumm() {
        return summ;
    }

    public String getComment() {
        return comment;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSumm(Float summ) {
        this.summ = summ;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Many{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", summ=" + summ +
                ", comment='" + comment + '\'' +
                '}';
    }
}
