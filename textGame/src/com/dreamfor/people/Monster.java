package com.dreamfor.people;

import com.dreamfor.object.Armor;
import com.dreamfor.object.Weapon;

import java.util.ArrayList;

public class Monster extends Gamer{
    public static ArrayList<String> monsterNames = new ArrayList<String>(){
        {
            add("张三");
            add("李四");
            add("王麻子");
            add("cbc");
            add("ry");
        }
    };
    // 怪物名称生成静态变量

    @Override
    public boolean fight(Gamer g){
        if(g == null){
            System.out.println("未指定对象！");
            return false;
        }
        if(super.fight(g)){
            System.out.println(name + "嘶吼着对" + g.name + "造成了伤害！");
//            g.speedNumber = (g.speedNumber - 1) <= 0 ? 1 : g.speedNumber - 1;
            return true;
        } else {
            System.out.println(name + "未能对" + g.name + "造成伤害！");
            return false;
        }
    }

    @Override
    public boolean defence(int damage){
        if(super.defence(damage)){
            System.out.println("未能撕开" + name + "厚实的皮肉");
            return true;
        } else {
            System.out.println("成功撕裂" + name + "的保护，造成了伤害！");
            if(die()){
                System.out.println(name + "已阵亡！");
            }
            return false;
        }
    }

    /**
     * 创造一个随机怪物
     * 名字由monsterName中随机指定
     * 数值随机
     * 其余所有设定未设置
     */
    public void createRandomNameMonster(){
        this.name = Monster.monsterNames.get((int) (Math.random() * Monster.monsterNames.size())) + (int)(Math.random() * 1000);
        this.getRamdomValueGamer();

        this.speedNumber = (this.speedNumber % 5) <= 0 ? 1 : this.speedNumber % 5;
        // 速度值补正
        this.maxSpeedNumber = speedNumber;

        this.setSex(Math.random() > 0.5 ? '男' : '女');
        this.setAge((int)(Math.random() * 82 + 18));
    }

    public Monster() {
    }
}
