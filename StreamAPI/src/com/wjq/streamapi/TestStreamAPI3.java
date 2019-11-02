package com.wjq.streamapi;


//排序操作

import org.junit.Test;

import javax.jws.soap.SOAPMessageHandlers;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//两种方式
// sorted（Comparator com）
// sorted（）
public class TestStreamAPI3 {


    @Test
    public void test1() {
        List<Integer> integers = Arrays.asList(1, 23, 42, 243, 232, 3433, 434, 3232, 42, 32, 42, 32, 42, 4221, 143535);
        integers.stream().sorted().forEach(System.out::println);

        //抛异常  java.lang.ClassCastException: com.wjq.streamapi.User cannot be cast to java.lang.Comparable
        List<User> users = TestStreamAPI.getUsers();
        users.stream().sorted().forEach(System.out::println);
        System.out.println();
        List<User> users1 = TestStreamAPI.getUsers();
        users1.stream().sorted((e1 ,e2)->Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);
        System.out.println();
        users1.stream().sorted((e1 ,e2)->{
            int value = Integer.compare(e1.getAge(),e2.getAge());
            if(value!=0){
                return value;
            }else {
                return e1.getUsername().compareTo(e2.getUsername());
            }
        }).forEach(System.out::println);
    }
}