package com.twu.util;

import com.twu.model.Item;
import com.twu.model.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserUtil extends Util{
    //给热搜事件投票
    public void voteForItem(String content, int votes, List<Item> items,User user){
        boolean isFind=false;
        try {
            for (Item item:items) {
                if(item.getContent().equals(content)){
                    isFind=true;

                    if (item.isSuperItem()){
                        item.setHot(item.getHot()+votes);
                    }
                    item.setHot(item.getHot()+votes);

                    user.setVotes(user.getVotes()-votes);
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("投票失败"+e.getMessage());
            System.out.println();
        }

        if (!isFind){
            System.out.println("投票失败：该热搜事件不存在！");
            System.out.println();
        }else{
            System.out.println("投票成功！");
            System.out.println();
        }
    }

    //购买热搜
    public void buyItem(String content,int number,int money,List<Item> itemList,List<Item> itemBuyList){
        Item newItem=new Item(number,content,0,false,true,money);

        boolean isFind=false;
        Item removeItem=null;

        for (Item item:itemList) {
            if (item.getContent().equalsIgnoreCase(content)){
                isFind=true;
                newItem.setSuperItem(item.isSuperItem());
                removeItem=item;
                break;
            }
        }

        if (!isFind){
            System.out.println("该热搜事件不存在，请先创建该热搜！");
            return;
        }

        if (itemBuyList==null||itemBuyList.isEmpty()){
            itemBuyList.add(newItem);
        }else if (!(itemBuyList.contains(newItem))){
            itemBuyList.add(newItem);
        }else{
            for (Item itemTmp:itemBuyList) {
                if (itemTmp.getIndex()==number){
                    if (itemTmp.getMoney()>money){
                        System.out.println("购买失败!");
                        return;
                    }
                    itemBuyList.remove(itemTmp);
                    itemBuyList.add(newItem);
                }
            }
        }
        if (removeItem!=null){
            itemList.remove(removeItem);
        }

        Collections.sort(itemBuyList, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getIndex()-o2.getIndex();
            }
        });
        System.out.println("购买成功");
    }

    //判断user是否注册过
    public User IsSingUp(String username,List<User> users){
        for (User user:users){
            if (user.getName().equals(username)){
                return user;
            }
        }

        User tmp=new User(username,10);
        users.add(tmp);
        return tmp;
    }
}
