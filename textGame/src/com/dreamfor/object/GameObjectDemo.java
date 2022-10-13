package com.dreamfor.object;

import java.util.Scanner;

// 通用物品模板
public abstract class GameObjectDemo implements GameObject{
    protected String objectName;
    // 物品名称
    protected String objectStory;
    // 物品故事
    protected String objectType = "物品";

    /**
     * 展示物品拥有的相关信息
     * @return 返回当前物品拥有的信息,且每一层尾部增加回车
     */
    @Override
    public String show() { return objectName + ": " + objectStory + "\n";}

    /**
     * 根据提示创造物品，需要输入物品名和物品故事
     * @return true
     */
    @Override
    public boolean createObjectByTips(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入" + objectType +"名称：");
        objectName = sc.nextLine();
        System.out.printf("请输入" + objectType + "的相关故事：");
        objectStory = sc.nextLine();
        return true;
    }

    public GameObjectDemo() {
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectStory() {
        return objectStory;
    }

    public void setObjectStory(String objectStory) {
        this.objectStory = objectStory;
    }
}
