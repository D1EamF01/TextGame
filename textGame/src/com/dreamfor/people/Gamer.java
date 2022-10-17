package com.dreamfor.people;

import com.dreamfor.object.Armor;
import com.dreamfor.object.Weapon;

import java.util.Scanner;

public abstract class Gamer implements GamePeople, Comparable<Gamer>{
    protected String name;
    // 名称

    protected int age;
    // 年龄

    protected char sex;
    // 性别

    protected String bornLocation;
    // 出生地

    protected int maxLifeNumber;
    // 最大生命值

    protected int lifeNumber;
    // 生命值

    protected int maxPowerNumber;
    // 最大法力值

    protected int powerNumber;
    // 法力值

    protected int attackNumber;
    // 攻击力（初始）

    protected int defenceNumber;
    // 防御力（初始）

    protected int maxSpeedNumber;
    // 最大速度值

    protected int speedNumber;
    // 速度（初始固定），决定逃跑和闪避效果


    protected int checkPoint;
    // 当前所在关卡编号，平行上无检查点设定，后期可考虑


    protected Weapon weapon;
    // 武器

    protected Armor armor;
    // 防具


    /**
     * 闪避攻击判定
     * 闪避速度计算，理论两者数值越大，则闪避补偿越少，同时，对于速度值差距过大的补偿较为可观
     * @return 闪避结果，成功true：false
     */
    public boolean dodgeAttack(Gamer attacker, Gamer dodger){
        return attacker.speedNumber < (dodger.speedNumber + (int)(Math.random() * attacker.speedNumber / dodger.speedNumber));
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", bornLocation='" + bornLocation + '\'' +
                ", lifeNumber=" + lifeNumber +
                ", powerNumber=" + powerNumber +
                ", attackNumber=" + attackNumber +
                ", defenceNumber=" + defenceNumber +
                ", speedNumber=" + speedNumber +
                ", checkPoint=" + checkPoint +
                ", weapon=" + weapon +
                ", armor=" + armor +
                '}';
    }

    @Override
    public int compareTo(Gamer g){
        return g.speedNumber - this.speedNumber;
    }

    /**
     * 角色死亡判定
     * @return 死亡 true， 否则false
     */
    @Override
    public boolean die() {
        return lifeNumber <= 0 ? true : false;
    }

    @Override
    public boolean getOut(Gamer o) {
        if(o.speedNumber > speedNumber){
            return false;
        } else{
            return true;
        }
    }

    /**
     * 战斗函数
     * @param g 为攻击目标
     * @return 攻击成功返回true，否则返回false
     */
    @Override
    public boolean fight(Gamer g) {
        if(g != null){
            int damage = attackNumber;
            if(weapon != null){
                damage += weapon.getAttackNumber();
            }
            if(dodgeAttack(this,g) && (int)(Math.random() * this.speedNumber * 10) % (int)(Math.random() * g.speedNumber * 10) == 0) return false;
            return !g.defence(damage);
        } else{
            System.out.println("未指定对手，请重试");
            return false;
        }
    }

    /**
     * 防御函数，内部进行伤害计算
     * @param damage 是需要判定防御的伤害值
     * @return 防御成功返回true，否则返回false
     */
    @Override
    public boolean defence(int damage) {
        if ((armor != null && damage < armor.getDefenceNumber() + defenceNumber) || damage < defenceNumber) {
            if(armor != null) armor.setDurabilityNumber(armor.getDurabilityNumber() - 1);
            return true;
        } else {
            lifeNumber -= damage;
            return false;
        }
    }

    /**'
     * 输出现有角色状况
     * @return 返回现有角色状况,且每一层尾部增加回车
     */
    @Override
    public String show(){
        String temp = "";
        temp += name;
        if(this instanceof User) {
            temp += ", " + sex + " 今年" + age + "岁。\n";
//            if(sex != 0) temp += ", " + sex;
            if(bornLocation != null) temp += "来自于" + bornLocation + "\n";
        }
        temp += "攻击力:" + attackNumber + "\n防御力:" + defenceNumber + "\n速度:" + speedNumber + "\n当前生命值:" + lifeNumber + "\n当前法力值:" + powerNumber;
        if(weapon != null) temp += "\n武器:" + weapon.getObjectName();
        if(armor != null) temp += "\n防具:" + armor.getObjectName();
        return temp + "\n";
    }

    /**
     * 输出角色的属性值，不输出其余所有
     * @return 返回现有角色的各个属性值，为战斗而设置的函数
     */
    @Override
    public String showPlay(){
        String temp = "";
        temp += name + "\n";
        temp += "攻击力:" + attackNumber + "\n防御力:" + defenceNumber + "\n速度:" + speedNumber + "\n当前生命值:" + lifeNumber + "\n当前法力值:" + powerNumber;
        if(weapon != null) temp += "\n武器:" + weapon.getObjectName();
        if(armor != null) temp += "\n防具:" + armor.getObjectName();
        return temp + "\n";
    }

    /**
     * 非自定义生成，给当前对象赋予随机的数值
     * 生成范围：生命值，法力值，100-200
     * 攻击力，防御力，20-50
     * 速度，1-10
     * @return 赋值成功返回true，否则返回false
     */
    protected boolean getRamdomValueGamer(){
        if(lifeNumber == 0) this.lifeNumber = (int) (Math.random() * 100 + 100);
        if(powerNumber == 0) this.powerNumber = (int) (Math.random() * 100 + 100);
        if(attackNumber == 0) this.attackNumber = (int) (Math.random() * 30 + 20);
        if(defenceNumber == 0) this.defenceNumber = (int) (Math.random() * 30 + 20);
        if(speedNumber == 0) this.speedNumber = (int) (Math.random() * 7 + 3);
        maxLifeNumber = lifeNumber;
        maxPowerNumber = powerNumber;
        maxSpeedNumber = speedNumber;
        return true;
    }

    /**
     * 通过提示创建角色
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean getGamerInformationByTips(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入角色姓名：");
        this.name = sc.nextLine();
        System.out.printf("请输入角色年龄：");
        this.age = sc.nextInt();
        System.out.printf("请选择角色的性别：1.男， 2.女");
        this.sex = sc.nextInt() == 1 ? '男' : '女';
        System.out.printf("请输入角色出生地：");
        sc.nextLine();
        this.bornLocation = sc.nextLine();
        System.out.printf("是否指定角色所在层位？(输入角色所在层次以指定角色所在层次，初始为0层)：");
        int tempCheckPoint = sc.nextInt();
        this.checkPoint = tempCheckPoint == 0 ? 0 : tempCheckPoint;
        System.out.println("剩余角色具体属性将随机生成……");
        getRamdomValueGamer();
        return true;
    }

    public Gamer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getBornLocation() {
        return bornLocation;
    }

    public void setBornLocation(String bornLocation) {
        this.bornLocation = bornLocation;
    }

    public int getLifeNumber() {
        return lifeNumber;
    }

    public void setLifeNumber(int lifeNumber) {
        this.lifeNumber = lifeNumber;
    }

    public int getPowerNumber() {
        return powerNumber;
    }

    public void setPowerNumber(int powerNumber) {
        this.powerNumber = powerNumber;
    }

    public int getAttackNumber() {
        return attackNumber;
    }

    public void setAttackNumber(int attackNumber) {
        this.attackNumber = attackNumber;
    }

    public int getDefenceNumber() {
        return defenceNumber;
    }

    public void setDefenceNumber(int defenceNumber) {
        this.defenceNumber = defenceNumber;
    }

    public int getSpeedNumber() {
        return speedNumber;
    }

    public void setSpeedNumber(int speedNumber) {
        this.speedNumber = speedNumber;
    }

    public int getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(int checkPoint) {
        this.checkPoint = checkPoint;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public int getMaxLifeNumber() {
        return maxLifeNumber;
    }

    public void setMaxLifeNumber(int maxLifeNumber) {
        this.maxLifeNumber = maxLifeNumber;
    }

    public int getMaxPowerNumber() {
        return maxPowerNumber;
    }

    public void setMaxPowerNumber(int maxPowerNumber) {
        this.maxPowerNumber = maxPowerNumber;
    }
}
