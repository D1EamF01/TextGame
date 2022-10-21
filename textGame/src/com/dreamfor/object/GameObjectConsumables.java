package com.dreamfor.object;

// 消耗品
public abstract class GameObjectConsumables extends GameObjectDemo{
    protected int remainNumber;
    // 使用次数

    public GameObjectConsumables() {
    }

    /**
     * 物品剩余数量的判断，物品消耗完毕返回true，反之返回false
     * @return
     */
    @Override
    public boolean destroy() {
        return remainNumber <= 0 ? true : false;
    }

    /**
     * 基于父类进行消耗物品生成，使用次数固定+1
     * @return true
     */
    @Override
    public boolean createObjectByTips() {
        super.createObjectByTips();
        remainNumber++;
        return true;
    }

    /**
     * 展示物品拥有的相关信息
     * @return 返回当前物品拥有的信息, 且每一层尾部增加回车
     */
    @Override
    public String show() {
        return super.show() + "剩余数量：" + remainNumber + "\n";
    }

    public int getRemainNumber() {
        return remainNumber;
    }

    public void setRemainNumber(int remainNumber) {
        this.remainNumber = remainNumber;
    }
}
