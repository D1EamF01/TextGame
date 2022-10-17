package com.dreamfor.playlink;

import com.dreamfor.gamelevel.GameLevelDemo;
import com.dreamfor.people.Gamer;
import com.dreamfor.people.Monster;

import java.util.*;

public abstract class PlayLink {
    /**
     * 关卡整体流程
     * @param gs 进入的关卡角色
     */
    public static void play(Gamer... gs){
            if(gs.length <= 0) return;
            ArrayList<Gamer> gamers = new ArrayList<>(gs.length);
            Collections.addAll(gamers, gs);

            ArrayList<GameLevelDemo> levels = GameLevelDemo.createLevelList();

            for (int i = 0; i < levels.size(); i++) {
                GameLevelDemo gameLevel = levels.get(i);
                // 取出关卡

                System.out.println("====================================================");
                System.out.println("本关卡名为：" +  gameLevel.getName());
                System.out.println("====================================================");
                // 输出当前关卡名

                ArrayList<Gamer> players = sortBySpeed(gameLevel, gamers);
                // 取得速度列表
                showPlayers(players);
                // 展示本关卡的所有角色（按照速度先后
                setAllGamersCheckPoint(players,gameLevel);
                // 重置所有角色存档点

                for (int i1 = 0; i1 < players.size() && gameLevel.getMonstersList().size() > 0 && gamers.size() > 0; i1 = (i1 + 1) % players.size()) {
                    Gamer gamer = players.get(i1);
                    if(gamer instanceof Monster){
                        Gamer fGamer = gamers.get((int)(Math.random() * gamers.size()));
                        if(gamer.fight(fGamer) ){
                           if(fGamer.die()){
                               players.remove(fGamer);
                               gamers.remove(fGamer);
                           }
                        } else {
                            // 反击
                            if(fGamer.fight(gamer)){
                                if(gamer.die()){
                                    players.remove(gamer);
                                    gameLevel.getMonstersList().remove(gamer);
                                }
                            }
                        }
                    } else{
                        Scanner sc = new Scanner(System.in);
                        ArrayList<Gamer> temp = new ArrayList<Gamer>(){
                            {
                                add(gamer);
                            }
                        };
                        System.out.println("你当前的角色状况为：");
                        showPlayers(temp);
                        // 展示当前角色状态

                        System.out.println("请选择" + gamer.getName() + "要进行的操作：");
                        System.out.println("1.攻击");
                        System.out.println("2.逃脱");
//                          System.out.println("3.使用道具");

                        int choose = sc.nextInt();
                        // 选择

                        switch (choose){
                            case 1:
                                ArrayList<Gamer> tempMonsters = new ArrayList<Gamer>(){
                                    {
                                        for (int i = 0; i < gameLevel.getMonstersList().size(); i++) {
                                            add(gameLevel.getMonstersList().get(i));
                                        }
                                    }
                                };
                                showPlayers(tempMonsters);
                                // 展示怪物状态

                                System.out.println("请选择你想攻击的怪物：");

                                int chooseMonster = sc.nextInt();
                                Gamer fGamer =  gameLevel.getMonstersList().get(chooseMonster - 1);
                                if(gamer.fight(fGamer) ){
                                    if(fGamer.die()){
                                        players.remove(fGamer);
                                        gameLevel.getMonstersList().remove(fGamer);
                                    }
                                } else {
                                    // 反击
                                    if(fGamer.fight(gamer)){
                                        if(gamer.die()){
                                            players.remove(gamer);
                                            gamers.remove(gamer);
                                        }
                                    }
                                }
                                System.out.println("进行一次攻击后" + gamer.getName() + "的状态为：");
                                showPlayers(temp);
                                break;
                            case 2:
                                for (int i2 = 0; i2 < gameLevel.getMonstersList().size(); i2++) {
                                    if(gamer.getOut(gameLevel.getMonstersList().get(i2))){
                                        players.remove(gamer);
                                        gamer.setCheckPoint(0);
                                        gamers.remove(gamer);
                                        break;
                                    }
                                }
                                break;
                        }
                    }
                }

                if(gamers.size()  <= 0){
                    System.out.println("战斗结束，全员死亡");
                    break;
                } else {
                    System.out.println("恭喜，成功通过" + gameLevel.getName() + "正在进入下一关……");
                    for (int i1 = 0; i1 < gamers.size(); i1++) {
                        gamers.get(i).setLifeNumber(gamers.get(i).getMaxLifeNumber());
                        gamers.get(i).setPowerNumber(gamers.get(i).getMaxPowerNumber());
                    }
                    System.out.println("生命法力已完全补充");
                    System.out.println("各角色状态如下：");
                    showPlayers(gamers);
                }
            }
    }



    /**
     * 设定所有角色的检查点
     * @param gamers 传入的可操作角色
     * @param gameLevelDemo 关卡
     */
    private static void setAllGamersCheckPoint(ArrayList<Gamer> gamers, GameLevelDemo gameLevelDemo){
        for (int i = 0; i < gamers.size(); i++) {
            gamers.get(i).setCheckPoint(gameLevelDemo.getGameLevelCheck());
        }
    }

    /**
     * 传入关卡和玩家列表，进行速度值排列
     * @param gameLevel 当前关卡
     * @param gamers 玩家角色列表
     * @return 速度值从大到小的有序数组列表
     */
    private static ArrayList<Gamer> sortBySpeed(GameLevelDemo gameLevel, List<Gamer> gamers){
        ArrayList<Gamer> players = new ArrayList();
        for (int i1 = 0; i1 < gameLevel.getMonstersList().size(); i1++) {
            players.add(gameLevel.getMonstersList().get(i1));
        }
        for (int i1 = 0; i1 < gamers.size(); i1++) {
            players.add(gamers.get(i1));
        }


        Collections.sort(players);

        return players;
    }

    /**
     * 展示Gamer类型数组列表的信息
     * @param players
     */
    public static void showPlayers(ArrayList<Gamer> players){
        for (int i1 = 0; i1 < players.size(); i1++) {
            System.out.println(players.get(i1).showPlay());
        }
    }

    private PlayLink() {
    }
}
