package priv.wjq.lambda;

import org.junit.Test;

import java.util.Comparator;

public class LambdaTest {


    //test1为原来的写法
    @Test
    public void test1(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("......");
            }
        };
        r.run();
    }

    //test2 为Lambda的写发
    @Test
    public void test2(){
       Runnable r = () -> System.out.println(".......");
       r.run();
    }


    @Test
    public void test3(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare = com1.compare(12, 21);//12 比21 大吗  -1 1
        System.out.println(compare);
    }


    @Test
    public void test4(){
        //lambda表达式的写法
        Comparator<Integer> com1 = (o1,o2)-> Integer.compare(o1,o2);
        int compare = com1.compare(12, 21);//12 比21 大吗  -1 1
        System.out.println(compare);
    }

    @Test
    public void test5(){
        //方法引用的符合
        Comparator<Integer> com1 = Integer::compare;
        int compare = com1.compare(12, 21);//12 比21 大吗  -1 1
        System.out.println(compare);
    }
}
