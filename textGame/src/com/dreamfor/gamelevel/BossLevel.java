package com.dreamfor.gamelevel;

import com.dreamfor.people.Boss;

import java.util.ArrayList;

public class BossLevel extends GameLevelDemo{
    public static ArrayList<String> bossLevelNames = new ArrayList(){
        {
            add("拥抱大群");
            add("认知即重担");
            add("偏执泡影");
            add("平凡即喜乐");
            add("深海骑士");
        }
    };
    // 随机关卡名列表

    /**
     * 创造一个随机关卡
     * 名字由bossLevelNames中随机指定
     * 数值随机
     * 其余所有设定未设置
     */
    public void createRandomBossLevel(){
        this.name = BossLevel.bossLevelNames.get((int) (Math.random() * BossLevel.bossLevelNames.size()));
        this.monsterNumber = 1;
        Boss bs = new Boss();
        bs.createRandomNameBoss();
        this.monstersList = new ArrayList(){{
            add(bs);
        }};
    }
}
