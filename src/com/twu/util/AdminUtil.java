package com.twu.util;

import com.twu.model.Item;

import java.util.List;

public class AdminUtil extends Util{
    //添加超级热搜
    public void addSuperItem(String content, List<Item> items){
        Item item=new Item(items.size()+1,content,0,true,false,0);

        try {
            items.add(item);
        }catch (Exception e){
            System.out.println("添加失败"+e.getMessage());
        }
        System.out.println("添加成功！");
        System.out.println();
    }
}
