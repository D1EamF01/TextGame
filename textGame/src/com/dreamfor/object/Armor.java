package com.dreamfor.object;

public class Armor extends GameObjectDurability {
    private int defenceNumber;
    // 防御值

    /**
     * 使用防具，使用防具，返回防御值
     * @return 首先判定耐久度，如果没有耐久默认返回0点防御值，否则返回defenceNumber值
     */
    public int use() {
        if(this.destroy()) return 0;
        System.out.println("使用了" + objectName + "进行了防御");
        durabilityNumber--;
        destroy();
        return defenceNumber;
    }

    /**
     * 基于父类基础生成指定防具，防具数值在5-10之间随机
     * @return true
     */
    @Override
    public boolean createObjectByTips(){
        objectType = "防具";
        super.createObjectByTips();
        System.out.println("防具防御力已随机生成完毕");
        defenceNumber = (int)(Math.random() * 5 + 5);
        return true;
    }

    /**
     * 展示物品拥有的相关信息
     * @return 返回当前物品拥有的信息,且每一层尾部增加回车
     */
    @Override
    public String show() {
        return super.show() + "防御力：" + defenceNumber + "\n";
    }


    public Armor() {
    }

    public int getDefenceNumber() {
        return defenceNumber;
    }

    public void setDefenceNumber(int defenceNumber) {
        this.defenceNumber = defenceNumber;
    }
}
