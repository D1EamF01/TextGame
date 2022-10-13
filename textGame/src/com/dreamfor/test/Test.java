package com.dreamfor.test;

import com.dreamfor.gamelevel.GameLevel;
import com.dreamfor.gamelevel.GameLevelDemo;
import com.dreamfor.gamelevel.NormalLevel;
import com.dreamfor.object.Armor;
import com.dreamfor.object.GameObject;
import com.dreamfor.object.Weapon;
import com.dreamfor.people.Gamer;
import com.dreamfor.people.Monster;
import com.dreamfor.people.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        System.out.println("=====================随机武器测试=====================");
//        Weapon w = new Weapon();
//        w.createObjectByTips();
//        System.out.println(w.show());
//
//        System.out.println("=====================随机防具测试=====================");
//        Armor a = new Armor();
//        a.createObjectByTips();
//        System.out.println(a.show());
//
//        System.out.println("=====================随机角色生成测试=====================");
//        User u = new User();
//        u.getGamerInformationByTips();
//        System.out.println(u.show());
//
//        System.out.println("=====================随机怪物生成测试=====================");
//        Monster m = new Monster();
//        m.createRandomNameMonster();
//        System.out.println(m.show());

//        System.out.println("=====================随机关卡生成测试=====================");
//        NormalLevel nl = new NormalLevel();
//        nl.createRandomNormalLevel((int)(Math.random() * 3) + 2);
//        System.out.println(nl.showLevel());

        System.out.println("=====================随机大批量关卡生成测试=====================");
        ArrayList<GameLevelDemo> levels = new ArrayList();
        NormalLevel gl;
        int levelNumber = (int)(Math.random() * 5 + 5);
        for (int i = 0; i < levelNumber; i++) {
            gl = new NormalLevel();
            gl.createRandomNormalLevel((int)(Math.random() * 3) + 2);
            gl.setGameLevelCheck(i);
            levels.add(gl);
        }

        for (int i = 0; i < levels.size(); i++) {
            System.out.println(levels.get(i).showLevel());
        }
    }
}
