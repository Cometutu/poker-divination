package com.yexi.util;

import com.yexi.constant.ColorEnum;
import com.yexi.constant.StatusEnum;
import com.yexi.constant.ValueEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 构建组装poker
 */
public class PokerBuilder {

    public static List<Poker> getPokerWithoutJokerAndK() {
        List<Poker> cards = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {//4中花色
            for (int j = 1; j <= 12; j++) {//每个花色12张牌（1-9，JQ)
                cards.add(new Poker(ColorEnum.getByValue(i), ValueEnum.getByValue(j) , StatusEnum.getByValue(false)));
            }
        }
        return cards;
    }
}
