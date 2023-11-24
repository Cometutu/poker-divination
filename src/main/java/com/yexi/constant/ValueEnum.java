package com.yexi.constant;

public enum ValueEnum {
    A("A", 1),
    _2("2", 2),
    _3("3", 3),
    _4("4", 4),
    _5("5", 5),
    _6("6", 6),
    _7("7", 7),
    _8("8", 8),
    _9("9", 9),
    _10("10", 10),
    J("J", 11),
    Q("Q", 12),
    K("K", 13),
    Joker("Joker", 15);

    private final int value;
    private final String code;

    ValueEnum(String code, int value){
        this.value = value;
        this.code = code;
    }

    public int getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

    public static ValueEnum getByValue(int value){
        for (ValueEnum color : ValueEnum.values()) {
            if (color.value == value){
                return color;
            }
        }
        return null;
    }
}
