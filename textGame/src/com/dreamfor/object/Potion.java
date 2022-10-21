package com.dreamfor.object;

import com.dreamfor.people.Gamer;

// 药水
public abstract class Potion extends GameObjectConsumables{
    @Override
    public boolean createObjectByTips() {
        super.createObjectByTips();
        System.out.println("已生成一瓶药水");
        remainNumber++;
        return true;
    }

    public void getAPotion(){
        remainNumber++;
    }

    /**
     * 物品是否用尽判断
     * @return 用尽返回true，否则返回false
     */
    public boolean useOut(){
        return destroy();
    }

    /**
     * 药水使用
     * @param gamer 使用对象
     * @return true：使用成功 false：使用失败
     */
    public abstract boolean useTo(Gamer gamer);
}
