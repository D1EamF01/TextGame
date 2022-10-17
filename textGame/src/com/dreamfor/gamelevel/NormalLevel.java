package com.dreamfor.gamelevel;

import java.util.ArrayList;

public class NormalLevel extends GameLevelDemo {
    public static ArrayList<String> normalLevelNames = new ArrayList() {
        {
            add("不期而遇");
            add("落魄骑士");
            add("巡逻队");
            add("正义");
            add("与虫为伴");
        }
    };
    // 随机关卡名列表

    /**
     * 创造一个随机关卡
     * 名字由monsterName中随机指定
     * 数值随机
     * 其余所有设定未设置
     *
     * @param n 是指定生成关卡的怪物数量
     */
    public void createRandomNormalLevel(int n) {
        this.name = NormalLevel.normalLevelNames.get((int) (Math.random() * NormalLevel.normalLevelNames.size()));
        this.createMonsters(n);
    }
}
