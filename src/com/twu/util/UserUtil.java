package com.twu.util;

import com.twu.model.Item;
import com.twu.model.User;

import java.util.List;

public class UserUtil extends Util{
    //给热搜事件投票
    public void voteForItem(String content, int votes, List<Item> items, User user){
        try {
            for (Item item:items) {
                if(item.getContent().equals(content)){
                    if (item.isSuperItem()){
                        item.setHot(item.getHot()+votes*2);
                    }
                    item.setHot(item.getHot()+votes);

                    //重置排名
                    int end=item.getIndex();
                    int start=-1;
                    for (int i=0;i<end;i++){
                        if (items.get(i).getHot()<item.getHot()){
                            start=items.get(i).getIndex();
                            break;
                        }
                    }

                    if (start!=-1){
                        item.setIndex(items.get(start).getIndex());
                        for (int j=start;j<end;j++){
                            items.get(j).setIndex(items.get(j).getIndex()-1);
                        }
                    }
                }
                break;
            }
            user.setVotes(user.getVotes()-votes);
        }catch (Exception e){
            System.out.println("投票失败"+e.getMessage());
            System.out.println();
        }

        System.out.println("投票成功！");
        System.out.println();
    }

    //购买热搜
    public void buyItem(String content,int number,int money,List<Item> items){
        for (Item item:items) {
            if (item.getIndex()==number){
                if (item.isBuyItem()){
                    if (item.getMoney()>money){
                        System.out.println("购买失败!");
                        return;
                    }
                }


            }
        }
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
