package com.wjq.refrence;
//1.使用情境:当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用!
//2.方法引用，本质上就是Lambda表达式， 而ambda表达式作为函数式接口的实例。所以
//  方法引用，也是函数式接口的实例。
//3.使用格式: 类(或对象) ::方法名
//4.具体分为如下的三种情况
    //对象 :: 实例方法（非静态方法）
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestFunctionRefrence {
    //Consumer void accept(T t)
    //System.out void println(T t)
    @Test
    public void test1(){
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("北京");
        //采用方法的引用方式
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("北京");
    }


    //Supplier T get()
    //User String getUsername()
    //方法的“型状”是一样的
    @Test
    public void test2(){
        //使用lambda表达式
        User user = new User("wjq","123");
        Supplier<String> supplier = ()->user.getUsername();
        System.out.println(supplier.get());
        //使用方法的引用
        Supplier<String> supplier2 = user::getUsername;
        System.out.println(supplier2.get());
    }

    //以上的两个引用的方法 都是通过对象的引用来调用的 即调用的都是非静态的方法

    //类::静态方法
    //Comparator int compare(T t1,T t2)
    //Integer int compare(T t1,T t2)
    @Test
    public void test3(){
        Comparator<Integer> comparator = (t1,t2)->Integer.compare(t1,t2);
        System.out.println(comparator.compare(12,21));

        //采用方法引用的方式
        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(22, 21));
    }


    //Function中的     R apply (T t)
    //Math 中的     Long round (Double d)
    @Test
    public void test4(){
        Function<Double,Long> function = d->Math.round(d);
        Function<Double,Long> function2 = Math::round;
    }


    //情况三  类：实例方法
    //int compare(T o1, T o2);
    //int compareTo(Integer anotherInteger)  调用方式 : anInteger.compareTo(anotherInteger)
    //用  类::实例方法  这个比较特殊
    @Test
    public void test5(){
        //这个有点难度
        //Comparator<Integer> comparator = (t1,t2)->Integer.compareTo(t1,t2); //这一句报错
        Comparator<Integer> comparator = Integer::compareTo;
    }
}
