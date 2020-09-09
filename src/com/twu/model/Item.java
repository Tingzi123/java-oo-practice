package com.twu.model;

public class Item{
    private int index;
    private String content;
    private int hot;
    private boolean isSuperItem;
    private boolean isBuyItem;
    private int money;

    public Item(int index, String content, int hot,boolean isSuperItem,boolean isBuyItem,int money) {
        this.index = index;
        this.content = content;
        this.hot = hot;
        this.isSuperItem = isSuperItem;
        this.isBuyItem = isBuyItem;
        this.money = money;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public boolean isSuperItem() {
        return isSuperItem;
    }

    public void setSuperItem(boolean superItem) {
        isSuperItem = superItem;
    }

    public boolean isBuyItem() {
        return isBuyItem;
    }

    public void setBuyItem(boolean buyItem) {
        isBuyItem = buyItem;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
