package com.dreamfor.playlink;

import com.dreamfor.gamelevel.GameLevelDemo;
import com.dreamfor.people.Gamer;

import java.util.ArrayList;
import java.util.Collections;

public abstract class PlayLink {
    /**
     * 关卡整体流程
     * @param gamers 进入的关卡角色数量
     */
    public static void play(Gamer... gamers){
            if(gamers.length <= 0) return;

            ArrayList<GameLevelDemo> levels = GameLevelDemo.createLevelList();

            for (int i = 0; i < levels.size(); i++) {
                GameLevelDemo gameLevel = levels.get(i);
                ArrayList<Gamer> players = sortBySpeed(gameLevel, gamers);
                showPlayers(players);


                break;

            }
    }

    private static ArrayList<Gamer> sortBySpeed(GameLevelDemo gameLevel, Gamer[] gamers){
        ArrayList<Gamer> players = new ArrayList();
        for (int i1 = 0; i1 < gameLevel.getMonstersList().size(); i1++) {
            players.add(gameLevel.getMonstersList().get(i1));
        }
        for (int i1 = 0; i1 < gamers.length; i1++) {
            players.add(gamers[i1]);
        }
        Collections.sort(players);
        return players;
    }

    public static void showPlayers(ArrayList<Gamer> players){
        for (int i1 = 0; i1 < players.size(); i1++) {
            System.out.println(players.get(i1).toString());
        }
    }

    private PlayLink() {
    }
}
