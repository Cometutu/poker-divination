package com.yexi.game;

import com.yexi.constant.StatusEnum;
import com.yexi.util.Poker;
import com.yexi.util.PokerBuilder;
import com.yexi.util.PokerHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 每月运势
 * 初始化扑克牌 剔除大小王 四张k
 * 洗牌三次
 * 发牌 依次发牌12组 每组4张
 * 取出第一组第一张（倒扣下标0为第一张） 根据扑克数字放置到对应牌组 取出当前牌组第一张 循环当前流程 当第一组全开时终止
 * 打印当前开牌顺序
 * 输出游戏结果
 */
public class MonthFortune {

    //打印初始化后的牌组
    public static void main(String[] args) {
        System.out.println("每月运势占卜开始运行：----------");

        //占卜结果
        ArrayList<Integer> result = new ArrayList<>();

        //初始化牌组
        List<Poker> cards = PokerBuilder.getPokerWithoutJokerAndK();
        System.out.println("初始化牌组：----------");
        System.out.println(cards);

        //洗牌
        System.out.println("洗牌第一次：----------");
        PokerHelper.shuffle(cards);
        System.out.println(cards);
        System.out.println("洗牌第二次：----------");
        PokerHelper.shuffle(cards);
        System.out.println(cards);
        System.out.println("洗牌第三次：----------");
        PokerHelper.shuffle(cards);
        System.out.println(cards);

        //将cards依次存入12个list中
        List<List<Poker>> lists = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < cards.size(); i++) {
            lists.get(i % 12).add(cards.get(i));
        }
        System.out.println("将牌分发至12个月卡组：----------");
        printCards(lists);
        //取出第一组第一张，将状态修改为正面
        Poker poker = lists.get(0).get(0);
        System.out.println("取出第一组第一张：" + poker);
        lists.get(0).remove(poker);

        //判断第一张卡牌数字，将其从第一组中移除，放入对应数值月份牌组，取出对应数值月份牌组第一张翻开，重复这个过程直到第一组被完全翻开
        reverseCards(lists,poker,result);

        System.out.println("翻开所有卡组：----------");
        printCards(lists);

        //计算占卜结果
        calculateResult(lists);

        //打印占卜结果：
        System.out.println("占卜运势顺序依次为："+result);
    }



    /**
     * 翻开对应的卡片
     * 判断传入卡牌数字，修改状态为正面，将其放入对应数值月份牌组末尾
     * 取出对应数值月份牌组第一张翻开，将其从当前月份卡组中移除
     * 重复这个过程直到第一组被完全翻开
     */
    private static void reverseCards(List<List<Poker>> lists,Poker poker,ArrayList<Integer> result) {
        System.out.println("当前翻开卡牌为："+poker.printResult());
        //判断第一组卡牌是否被完全翻开 如果完全翻开则直接退出
        if (lists.get(0).stream().allMatch(p -> p.getStatus().equals(StatusEnum.REVERSE_SIDE))){
            return;
        }

        //判断卡牌数值，将状态修改为正面，将卡牌加入对应数值的牌组
        poker.setStatus(StatusEnum.REVERSE_SIDE);
        lists.get(poker.getValue().getValue() -1).add(poker);
        //取出对应数组卡组的第一张
        Poker temp = lists.get(poker.getValue().getValue() - 1).get(0);
        lists.get(poker.getValue().getValue() - 1).remove(temp);
        //判断对应卡组月份卡牌是否全开，如果全开则加入占卜结果集合
        if (lists.get(poker.getValue().getValue() -1).stream().allMatch(p -> p.getStatus().equals(StatusEnum.REVERSE_SIDE))){
            result.add(poker.getValue().getValue());
        }
        //递归执行整个过程
        reverseCards(lists,temp,result);
    }

    /**
     * 打印当前卡组
     * @param lists 当前卡组list
     */
    private static void printCards(List<List<Poker>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            System.out.println("第"+(i+1)+"组牌：");
            System.out.println(lists.get(i).stream().map(Poker::print).collect(Collectors.toList()));
        }
    }

    /**
     * 计算占卜结果
     * 打印所有已经完全翻开的卡组对应的月份
     * @param lists 月份卡组
     */
    private static void calculateResult(List<List<Poker>> lists) {
        System.out.println("开始计算占卜结果：----------");
        for (int i = 0; i < lists.size(); i++) {
            List<Poker> monthList = lists.get(i);
            if (monthList.stream().allMatch(poker -> poker.getStatus().equals(StatusEnum.REVERSE_SIDE))){
                System.out.println("第"+(i+1) + "月已经完全翻开："+ monthList.stream().map(Poker::print).collect(Collectors.toList()));
            }
        }
        System.out.println("-------------------------");
    }
}
