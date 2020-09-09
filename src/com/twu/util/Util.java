package com.twu.util;

import com.twu.model.Item;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Util {
    //查看热搜排行榜
    public void viewItems(List<Item> items){
        if (items==null||items.isEmpty()){
            System.out.println("热搜榜是空的，请添加热搜后再查看！");
            System.out.println();
            return;
        }

        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getIndex()-o2.getIndex();
            }
        });

        for (Item item:items) {
            System.out.println(item.getIndex()+" "+item.getContent()+" "+item.getHot());
        }
        System.out.println();
    }

    //添加热搜
    public void addItem(String content,List<Item> items){
        Item item=new Item(items.size()+1,content,0,false,false,0);

        try {
            items.add(item);
        }catch (Exception e){
            System.out.println("添加失败"+e.getMessage());
            System.out.println();
        }
        System.out.println("添加成功！");
        System.out.println();
    }
}
