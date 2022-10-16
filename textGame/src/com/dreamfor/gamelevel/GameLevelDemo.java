package com.dreamfor.gamelevel;

import com.dreamfor.people.Gamer;
import com.dreamfor.people.Monster;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class GameLevelDemo implements GameLevel{


    protected String name;
    // 关卡名

    protected int monsterNumber;
    // 怪物数量

    protected ArrayList<Monster> monstersList;
    // 存放生成怪物的列表

    protected int gameLevelCheck;
    // 所在关卡

    /**
     * 创建当前关卡怪物的函数
     * @param n，表示生成的怪物数量
     * @return true
     */
    @Override
    public boolean createMonsters(int n) {
        this.initMonstersList();
        monstersList = new ArrayList<>();
        monsterNumber = n;
        Monster temp;
        for (int i = 0; i < monsterNumber; i++) {
            temp = new Monster();
            temp.createRandomNameMonster();
            temp.setCheckPoint(gameLevelCheck);
            monstersList.add(temp);
        }
        return true;
    }

    /**
     * 进入关卡的判断函数
     * @param g 与关卡交互的角色
     * @return 成功进入返回true，否则返回false
     */
    @Override
    public boolean getIn(Gamer g) {
        if(g == null || g.getCheckPoint() > gameLevelCheck)
            return false;
        g.setCheckPoint(gameLevelCheck);
        return true;
    }

    /**
     * 退出关卡设定
     * @param g 与关卡交互的角色
     * @return 成功退出返回true，否则返回false
     */
    @Override
    public boolean getOut(Gamer g) {
        if(g != null && g.getCheckPoint() == gameLevelCheck){
            g.setCheckPoint(0);
            return true;
        }
        return false;
    }

    /**
     * 生成当前关卡的详细数据
     * @return 由当前关卡中的数据组合而成的字符串
     */
    @Override
    public String showLevel(){
        String temp = "";
        if(this instanceof NormalLevel)
            temp += "关卡名：";
        else
            temp += "Boss关卡：";
        temp += name + "\n" + "关卡层数：" + gameLevelCheck + "\n";
        temp += "当前关卡怪物数量：" + monsterNumber + "\n";
        Scanner sc = new Scanner(System.in);

        String tempAsk = "";
        tempAsk += "请问是否需要列出" + "第" + gameLevelCheck + "层";
        if(this instanceof NormalLevel) tempAsk += "关卡：";
        else tempAsk += "Boss关：";
        tempAsk += "\"" + name + "\"的怪物情况？1:OK 2:No";
        System.out.println(tempAsk);

        int choose = sc.nextInt();
        while(choose != 1 && choose != 2){
            System.out.println("输入有误，请重新输入!");
            choose = sc.nextInt();
        }
        if(choose == 1){
            temp += "=====================\n";
            for (int i = 0; i < monstersList.size(); i++) {
                temp += monstersList.get(i).show();
                temp += "=====================\n";
            }
        }
        return temp;
    }

    /**
     * 创建一个完整的关卡，并返回关卡列表
     * @return 完整关卡列表（随机数量(2 - 5之间)随即关卡 + 一个boss关卡）
     */
    public static ArrayList<GameLevelDemo> createLevelList(){
        ArrayList<GameLevelDemo> levels = new ArrayList();
        NormalLevel gl;
        BossLevel bl = new BossLevel();
        int levelNumber = (int) (Math.random() * 5 + 5);
        for (int i = 0; i < levelNumber; i++) {
            gl = new NormalLevel();
            gl.createRandomNormalLevel((int) (Math.random() * 3) + 2);
            gl.setGameLevelCheck(i);
            levels.add(gl);
        }
        bl.setGameLevelCheck(levelNumber);
        bl.createRandomBossLevel();
        levels.add(bl);
        return levels;
    }

    /**
     * 初始化怪物列表
     */
    private void initMonstersList(){
        monstersList = null;
        monsterNumber = 0;
    }

    /**
     * 展示所有关卡信息，直接输出
     * @param levels 所有关卡的集合类
     */
    public static void showLevelsAll(ArrayList<GameLevelDemo> levels){
        for (int i = 0; i < levels.size(); i++) {
            System.out.println(levels.get(i).showLevel());
        }
    }

    public GameLevelDemo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonsterNumber() {
        return monsterNumber;
    }

    public void setMonsterNumber(int monsterNumber) {
        this.monsterNumber = monsterNumber;
    }

    public ArrayList<Monster> getMonstersList() {
        return monstersList;
    }

    public void setMonstersList(ArrayList<Monster> monstersList) {
        this.monstersList = monstersList;
    }

    public int getGameLevelCheck() {
        return gameLevelCheck;
    }

    public void setGameLevelCheck(int gameLevelCheck) {
        this.gameLevelCheck = gameLevelCheck;
    }
}
