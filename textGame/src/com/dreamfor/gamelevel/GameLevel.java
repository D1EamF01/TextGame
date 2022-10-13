package com.dreamfor.gamelevel;

import com.dreamfor.people.Gamer;

public interface GameLevel {
    /**
     * 随机生成一定数量的怪物，怪物数值随机
     * @param n，表示生成的怪物数量
     * @return 生成怪物成功则返回true，否则返回false
     */
    boolean createMonsters(int n);

    /**
     * 进入关卡的判断函数
     * @param g 与关卡交互的角色
     * @return 成功进入返回true，否则返回false
     */
    boolean getIn(Gamer g);

    /**
     * 退出关卡设定
     * @param g 与关卡交互的角色
     * @return 成功退出返回true，否则返回false
     */
    boolean getOut(Gamer g);

    /**
     * 生成当前关卡的详细数据
     * @return 由当前关卡中的数据组合而成的字符串
     */
    String showLevel();
}
