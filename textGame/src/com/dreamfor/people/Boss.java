package com.dreamfor.people;

import java.util.ArrayList;

public class Boss extends Monster{
    public static ArrayList<String> bossNames = new ArrayList<String>(){
        {
            add("无声");
            add("狄克玛拉");
            add("Bubble");
            add("Plain");
            add("Knight");
        }
    };
    // Boss名称生成静态变量

    @Override
    public String show(){
        String temp = "Boss:";
        temp += super.showPlay();
        return temp;
    }

    /**
     * 创造一个随机boss，所有属性随机
     * 生命力和法力值皆为普通怪的十倍
     * 速度为普通怪的1 / 2
     */
    public void createRandomNameBoss(){
        this.createRandomNameMonster();
        this.name = Boss.bossNames.get((int) (Math.random() * Boss.bossNames.size()));
        this.getRamdomValueGamer();
        this.lifeNumber *= 10;
        this.powerNumber *= 10;
        this.speedNumber /= 2;
        this.setSex(Math.random() > 0.5 ? '男' : '女');
        this.setAge((int)(Math.random() * 820 + 180));
    }

    public Boss() {
    }
}
