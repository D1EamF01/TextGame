package com.dreamfor.people;

public class User extends Gamer {

    public User() {
    }

    @Override
    public boolean fight(Gamer g) {
        if (g == null) {
            System.out.println("未指定对象！");
            return false;
        }
        if (super.fight(g)) {
            System.out.println(name + "成功对" + g.name + "造成了伤害！");
//            g.speedNumber = (g.speedNumber - 1) <= 0 ? 1 : g.speedNumber - 1;
            return true;
        } else {
            System.out.println("我们未能击穿" + g.name + "的装甲!");
            return false;
        }
    }

    @Override
    public boolean defence(int damage) {
        if (super.defence(damage)) {
            System.out.println("啊哈，敌方未能击破我们的装甲！");
            return true;
        } else {
            System.out.println("报告！敌方火力太猛，请求支援！");
            if (die()) {
                System.out.println(name + "已阵亡！");
            }
            return false;
        }
    }
}
