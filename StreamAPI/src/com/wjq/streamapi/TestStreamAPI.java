package com.wjq.streamapi;
//filter(Predicate p)-接收 Lambda，从流中排除某些元素。
//limit(n)-截断流 ，使其元素不超过给定数量。
//skip(n)一跳过元素 ，返回个扔掉了前n个元素的流。若流中元素不足n个,则返回一个空流。与limit(n)互补
//distinct)--筛选 ，通过流所生成元素的hashCode0和equals0去除重复元素


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI {
    public static List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("wjq","123",24,"男"));
        users.add(new User("zf","3123",25,"女"));
        users.add(new User("ppx","123",64,"男"));
        users.add(new User("rng","123",44,"男"));
        users.add(new User("ig","123",34,"男"));
        users.add(new User("fpx","123",54,"男"));
        users.add(new User("glf","123",74,"女"));
        users.add(new User("g2","123",84,"男"));
        users.add(new User("jkl","123",29,"男"));
        users.add(new User("kzq","123",2,"男"));

        return users;
    }

    //赛选 与切片  将users中 大于 24岁的User对象找出来
    @Test
    public void test1(){
        List<User> users = getUsers();
        Stream<User> stream = users.stream();
        stream.filter(user -> user.getAge()>24).forEach(System.out::println);
    }



    @Test
    public void test2(){
        List<User> users = getUsers();
        Stream<User> stream = users.stream();
        //截断
        stream.limit(3).forEach(System.out::println);//获取前三个
    }

    @Test
    public void test3(){
        List<User> users = getUsers();
        Stream<User> stream = users.stream();
        //截断
        stream.skip(3).forEach(System.out::println);//跳过前三个
    }




    //distinct方法将会按照hashCode和equals方法进行判断并且去重
    @Test
    public void test4(){
        List<User> users = getUsers();
        Stream<User> stream = users.stream();
        //截断
        users.addAll(getUsers());
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("----------------------");
        //Stream<User> stream = users.stream();
        stream.distinct().forEach(System.out::println);

        //stream.distinct();
    }
}


