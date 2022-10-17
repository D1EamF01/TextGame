package com.dreamfor.object;

public interface GameObject {
    /**
     * 展示物品拥有的相关信息
     *
     * @return 返回当前物品拥有的信息, 且每一层尾部增加回车
     */
    String show();

    /**
     * 判定物品是否损坏，或者使用掉
     *
     * @return
     */
    boolean destroy();

    /**
     * 根据提示补全物品信息
     *
     * @return true
     */
    boolean createObjectByTips();
}
