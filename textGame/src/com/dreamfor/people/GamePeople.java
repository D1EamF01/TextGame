package com.dreamfor.people;

public interface GamePeople {
    // g为攻击目标，内部进行伤害计算，成功攻击返回true，未成功攻击返回false

    /**
     * 战斗函数
     * @param g 为攻击目标
     * @return 攻击成功返回true，否则返回false
     */
    boolean fight(Gamer g);

    // 内部进行伤害计算, 成功防御返回true，未成功返回false

    /**
     * 防御函数，内部进行伤害计算
     * @param damage 是需要判定防御的伤害值
     * @return 防御成功返回true，否则返回false
     */
    boolean defence(int damage);

    //后续增加道具类使用
//    void useObject(GameObject o);


    // 逃跑，根据速度决定，逃跑成功返回true，否则返回false
    boolean getOut(Gamer o);

    // 死亡返回true，未死亡返回false
    boolean die();

    /**'
     * 输出现有角色状况
     * @return 返回现有角色状况,且每一层尾部增加回车
     */
    String show();

    /**
     * 通过提示创建角色
     * @return 创建成功返回true，否则返回false
     */
    boolean getGamerInformationByTips();
}
