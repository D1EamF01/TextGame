package com.dreamfor.object;

import com.dreamfor.people.Gamer;

// 法力药剂
public class PowerPotion extends Potion{
    /**
     * 法力药剂使用
     * 随机回复法力为20 - 50
     * @return true: 使用成功  false:使用失败
     */
    @Override
    public boolean useTo(Gamer gamer) {
        if(!useOut()){
            remainNumber--;
            int getPower = (int)(Math.random() * 30 + 20);
            // 随机回复量，20 - 50
            gamer.setPowerNumber(gamer.getPowerNumber() + getPower > gamer.getMaxPowerNumber() ? gamer.getMaxPowerNumber() : gamer.getPowerNumber() + getPower);
            return true;
        }
        return false;
    }
}
