package com.yexi.constant;

public enum ColorEnum {
    SPADES("♠", 1),         //黑桃
    HEARTS("♥", 2),         //红桃
    CLUBS("♣", 3),          //梅花
    DIAMONDS("◇", 4);       //方片

    private final int value;
    private final String pic;

    ColorEnum(String pic, int value){
        this.value = value;
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public int getValue() {
        return value;
    }

    public static ColorEnum getByValue(int value){
        for (ColorEnum color : ColorEnum.values()) {
            if (color.value == value){
                return color;
            }
        }
        return null;
    }
}
