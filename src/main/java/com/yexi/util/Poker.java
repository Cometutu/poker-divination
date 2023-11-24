package com.yexi.util;

import com.yexi.constant.ColorEnum;
import com.yexi.constant.StatusEnum;
import com.yexi.constant.ValueEnum;

public class Poker {
    private ColorEnum color;
    private ValueEnum value;
    private StatusEnum status;

    public Poker(ColorEnum color, ValueEnum value, StatusEnum status) {
        this.color = color;
        this.value = value;
        this.status = status;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public ValueEnum getValue() {
        return value;
    }

    public void setValue(ValueEnum value) {
        this.value = value;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                color.getPic() + value.getValue() + status.getStatus() +
                '}';
    }

    public String print() {
        if (status.equals(StatusEnum.OBVERSE_SIDE)) {
            return "{*}";
        } else {
            return "{" +
                    color.getPic() + value.getCode() +
                    '}';
        }
    }

    public String printResult() {
        return "{" +
                color.getPic() + value.getValue() +
                '}';
    }
}
