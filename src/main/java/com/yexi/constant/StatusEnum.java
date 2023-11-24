package com.yexi.constant;

public enum StatusEnum {
    OBVERSE_SIDE( false,"反"),
    REVERSE_SIDE(true, "正");

    private final boolean value;
    private final String status;

    StatusEnum(boolean value,String status){
        this.value = value;
        this.status = status;
    }

    public boolean isValue() {
        return value;
    }

    public String getStatus() {
        return status;
    }

    public static StatusEnum getByValue(boolean value){
        for (StatusEnum status : StatusEnum.values()) {
            if (status.value == value){
                return status;
            }
        }
        return null;
    }
}
