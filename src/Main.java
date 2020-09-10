import com.twu.model.Item;
import com.twu.model.User;
import com.twu.util.AdminUtil;
import com.twu.util.UserUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Item> itemList=new LinkedList<>();
        List<Item> itemBuyList=new LinkedList<>();
        List<User> userList=new LinkedList<>();

        while(true){
            System.out.println("欢迎来到热搜排行榜，您是？");
            System.out.println("1 用户");
            System.out.println("2 管理员");
            System.out.println("3 退出");

            Scanner sc=new Scanner(System.in);
            int num=sc.nextInt();

            switch (num){
                case 1:
                    boolean isFlag1=true;
                    System.out.println("请输入您的昵称：");
                    String name=sc.next();
                    System.out.println();

                    while(isFlag1){
                        System.out.println("您好"+name+"，您可以：");
                        System.out.println("1 查看热搜排行榜");
                        System.out.println("2 给热搜事件投票");
                        System.out.println("3 购买热搜");
                        System.out.println("4 添加热搜");
                        System.out.println("5 退出");
                        System.out.println();

                        UserUtil userUtil=new UserUtil();

                        //IsSingUp()判断name是否之前注册过
                        User user=userUtil.IsSingUp(name,userList);

                        int tab=sc.nextInt();

                        switch (tab){
                            case 1:
                                userUtil.viewItems(itemList,itemBuyList);
                                break;
                            case 2:
                                System.out.println("请输入您要投票的热搜事件的名字：");
                                String contentName=sc.next();
                                System.out.println("请输入您要投票的热搜的票数：(您目前还有"+user.getVotes()+"票)");
                                int votes=sc.nextInt();
                                if (votes>10){
                                    System.out.println("投票失败，您只有10票！");
                                    System.out.println();
                                    break;
                                }
                                userUtil.voteForItem(contentName,votes,itemList,user);
                                break;
                            case 3:
                                System.out.println("请输入您要购买的热搜事件的名字：");
                                String buyContentName=sc.next();
                                System.out.println("请输入您要购买的热搜排名：");
                                int number=sc.nextInt();
                                System.out.println("请输入您要购买的热搜金额：");
                                int money=sc.nextInt();
                                System.out.println();
                                userUtil.buyItem(buyContentName,number,money,itemList,itemBuyList);
                                break;
                            case 4:
                                System.out.println("请输入您要添加的热搜事件的名字：");
                                String content=sc.next();
                                System.out.println();
                                userUtil.addItem(content,itemList);
                                break;
                            case 5:
                                isFlag1=false;
                                break;
                            default:
                                isFlag1=false;
                        }
                    }
                    break;

                case 2:
                    boolean isFlag2=true;

                    System.out.println("请输入您的昵称：");
                    String adminName=sc.next();

                    while(!adminName.equals("admin")){
                        System.out.println("昵称错误，请重新输入！");
                        adminName=sc.next();
                    }

                    System.out.println("请输入您的密码：");
                    String password=sc.next();

                    while(!password.equals("123456")){
                        System.out.println("密码错误，请重新输入！");
                        password=sc.next();
                    }

                    while(isFlag2){
                        System.out.println("您好"+adminName+"，您可以：");
                        System.out.println("1 查看热搜排行榜");
                        System.out.println("2 添加热搜");
                        System.out.println("3 添加超级热搜");
                        System.out.println("4 退出");

                        AdminUtil adminUtil=new AdminUtil();
                        int adminTab=sc.nextInt();

                        switch (adminTab){
                            case 1:
                                adminUtil.viewItems(itemList,itemBuyList);
                                break;
                            case 2:
                                System.out.println("请输入您要添加的热搜事件的名字：");
                                String content=sc.next();
                                adminUtil.addItem(content,itemList);
                                break;
                            case 3:
                                System.out.println("请输入您要添加的超级热搜事件的名字：");
                                String superContent=sc.next();
                                adminUtil.addSuperItem(superContent,itemList);
                                break;
                            case 4:
                                isFlag2=false;
                                break;
                            default:
                                isFlag2=false;
                        }
                    }
                    break;

                case 3:
                    return;
                default:
                    return;
            }
        }
    }
}
