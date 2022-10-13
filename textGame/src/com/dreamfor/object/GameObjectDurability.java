package com.dreamfor.object;

import java.util.Scanner;

// 耐久品
public abstract class GameObjectDurability extends GameObjectDemo{
    protected int durabilityNumber;
    // 物品耐久度

    /**
     * 耐久度物品使用后后，产生物品损坏判定
     * @return 损坏则返回true，否则返回false
     */
    @Override
    public boolean destroy() {
        if(durabilityNumber <= 0){
            System.out.println(objectName + "损坏了！");
            return true;
        }
        return false;
    }

    /**
     * 基于父类进行耐久度物品生成，耐久度随机范围为5 - 10
     * @return true
     */
    @Override
    public boolean createObjectByTips(){
        super.createObjectByTips();
        System.out.println("耐久度已随机生成完毕");
        durabilityNumber = (int)(Math.random() * 5) + 5;
        return true;
    }

    /**
     * 展示物品拥有的相关信息
     * @return 返回当前物品拥有的信息,且每一层尾部增加回车
     */
    @Override
    public String show() {
        return super.show() + "耐久度：" + durabilityNumber + "\n";
    }

    public GameObjectDurability() {
    }

    public int getDurabilityNumber() {
        return durabilityNumber;
    }

    public void setDurabilityNumber(int durabilityNumber) {
        this.durabilityNumber = durabilityNumber;
    }
}
