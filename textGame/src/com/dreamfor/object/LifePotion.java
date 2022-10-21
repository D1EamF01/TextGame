package com.dreamfor.object;

import com.dreamfor.people.Gamer;

// 生命恢复药水
public class LifePotion extends Potion{
    /**
     * 生命恢复药水使用
     * 随机回复10 - 20生命值
     * @return true: 使用成功  false:使用失败
     */
    @Override
    public boolean useTo(Gamer gamer) {
        if(!useOut()){
            remainNumber--;
            int getLife = (int)(Math.random() * 10 + 10);
            // 随机回复量，10 - 20
            gamer.setLifeNumber(gamer.getLifeNumber() + getLife > gamer.getMaxLifeNumber() ? gamer.getMaxLifeNumber() : gamer.getLifeNumber() + getLife);
            return true;
        }
        return false;
    }

    public LifePotion() {
        this.objectName = "生命恢复药水（随机）";
        this.objectStory = "暗绿色玻璃瓶，\n" +
                "是冒险者的珍宝。\n" +
                "\n" +
                "借着平凡勇气积累天命，喝下去便能恢复血量。\n" +
                "\n" +
                "自古以来，冒险者总在各地不停探索，\n" +
                "而此也一直随之旅行。";
    }
}
