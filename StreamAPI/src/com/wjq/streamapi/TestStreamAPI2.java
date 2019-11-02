package com.wjq.streamapi;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//map(Function f)-_接收一 个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成个新的元素。
//练习:获取员工姓名长度大于3的员工的姓名。
//flatMap(Function f)-接收一 个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
public class TestStreamAPI2 {
    //map
    @Test
    public void test1(){
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        Stream<String> stream = list.stream();
        stream.map(str->str.toUpperCase()).forEach(System.out::println);
    }

    //获取名字长度大于2的所有名字
    //获取名字长度大于2的所有员工???
    @Test
    public void test2(){
        List<User> users = TestStreamAPI.getUsers();
        Stream<User> stream = users.stream();
        stream.map(User::getUsername).filter(name -> name.length()>2).forEach(System.out::println);
    }

    //flatMap
    //接收一个函数（Function接口的实例）作为参数
    // 将流中的每一个值都转换成流  然后将所有的流连接起来
    @Test
    public void test3(){
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        list2.add(list1);
        //list2.addAll(list2);
        System.out.println(list2);
    }
    //测试flatMap 和 map 的区别
    @Test
    public void test4(){
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        list.stream().map(TestStreamAPI2::fromStringToStream).forEach(s->s.forEach(System.out::println));

        System.out.println();

        list.stream().flatMap(TestStreamAPI2::fromStringToStream).forEach(System.out::println);
    }

    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return  list.stream();
    }
}
