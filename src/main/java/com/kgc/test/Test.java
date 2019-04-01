package com.kgc.test;

import java.util.ArrayList;
import java.util.TreeSet;

public class Test {
    @org.junit.Test
    public void test1(){
        /*校验身份证：
        (1)、长度为18位
                (2)、前面17位必须为纯数字
                (3)、最后一位可以为X，也可以为数字
                (4)、不用校验出生日期等*/
        String str="123456789987654321";
        boolean b = str.matches("\\d{17}(X|\\d)");
        System.out.println(b);
    }
    @org.junit.Test
    public void test2(){
        /*校验QQ号码：
        (1)、长度为5-12位
                (2)、必须为纯数字
                (3)、第一个字母不能够为0*/
        String str="123451234567";
        boolean b = str.matches("[1-9]\\d{4,11}");
        System.out.println(b);
    }
    @org.junit.Test
    public void test3(){
        //验证手机号码1.第一个数字为“1”     2.第二个数字3,5,7,8,9中的一个    3.总共11位数
        String str="15987654321";
        boolean b = str.matches("1[35789]\\d{9}");
        System.out.println(b);
    }
    @org.junit.Test
    public void test4(){
        //去除相邻的同一字符，例如：挨挨，bbb，wwwwww
        String str = "abccdefjkkfdjkahfdjkspppabcdef&&abc吃饭饭";
         str = str.replaceAll("(.)\\1+", "$1");
        System.out.println(str);
    }
    @org.junit.Test
    public void test5(){
        String email = "abc123@11.com.cn";
        boolean b = email.matches("\\w{3,12}@(\\d{2,6}|[a-zA-Z]{2,6})(\\.[a-zA-Z]{2,3}){2,3}");
        System.out.println(b);
    }
    @org.junit.Test
    public void test6(){
        /**
         * 拔高：不要求全部掌握
         * 对ip地址归类: A.B.C.D  A-D的区间范围在：1~255之间
         * 102.254.38.12
         * 11.12.122.25
         * 123.123.45.12
         */
        String str = "102.254.38.102,11.102.122.205,123.123.405.12";
        str=str.replaceAll("(\\d+)","00$1");//都加上两个0
        str=str.replaceAll("0*(\\d{3})","$1");//保留后三位数
        String[] arr = str.split(",");
        TreeSet<String> set = new TreeSet<>();
        for(String a:arr){
            set.add(a);//加到treeSet排序
        }
        ArrayList<String> list = new ArrayList<>();
        set.forEach(item-> {
            item=item.replaceAll("0*(\\d+)","$1");//去掉数字前面的0
            list.add(item);//添加到list中，保留之前的排序顺序
        });
        list.forEach(i-> System.out.println(i));

    }
}
