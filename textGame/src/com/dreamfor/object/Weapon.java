package com.dreamfor.object;

public class Weapon extends GameObjectDurability {
    // 武器攻击数值
    private int attackNumber;

    public Weapon() {
    }

    /**
     * 使用武器，返回造成的伤害
     *
     * @return 首先判定耐久度，如果没有耐久默认返回1点伤害，否则返回attackNumber值
     */
    public int use() {
        // 如果武器没有耐久，默认造成1点伤害
        if (this.destroy()) return 1;
        System.out.println("使用了" + objectName + "进行了攻击！");
        durabilityNumber--;
        destroy();
        return attackNumber;
    }

    /**
     * 基于父类基础生成指定武器，武器伤害在10-20之间随机
     *
     * @return true
     */
    @Override
    public boolean createObjectByTips() {
        objectType = "武器";
        super.createObjectByTips();
        System.out.println("武器伤害已随机生成完毕");
        attackNumber = (int) (Math.random() * 10 + 10);
        return true;
    }

    /**
     * 展示物品拥有的相关信息
     *
     * @return 返回当前物品拥有的信息, 且每一层尾部增加回车
     */
    @Override
    public String show() {
        return super.show() + "攻击力：" + attackNumber + "\n";
    }

    public int getAttackNumber() {
        return attackNumber;
    }

    public void setAttackNumber(int attackNumber) {
        this.attackNumber = attackNumber;
    }
}
