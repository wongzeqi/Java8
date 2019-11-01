package priv.wjq.lambda;


//lambda表达式的使用
//举例(o1,o2) -> Integer.compare(o1,o2)
// (o1,o2)  接口中抽象方法的形参列表（这里使用了类型推断)
// ->  lambda操作符
// -> 右边  lambda体   其实就是重写的抽象方法的方法体

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

// 分六种情况  介绍Lambda

//Lambda 表达式本质是一个对象
public class LambdaTest1 {
    //语法格式一： 无参数  无返回值
    //public abstract void run();
    @Test
    public void test1(){
        Runnable r = () -> System.out.println(".......");
        r.run();
    }


    //语法格式二   有参数 但是没有返回值
    //语法格式三   类型可以省略  根据泛型进行类型推断
    //语法格式四   形参只有一个参数  小括号也可以省略
    @Test
    public void test2(){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                //具体方法实现方法
                System.out.println(s);
            }
        };
        consumer.accept("谎言和誓言的区别是什么呢");


        //Consumer<String> consumer1 = (String s) -> System.out.println(s);
        Consumer<String> consumer1 = s -> System.out.println(s);
        consumer1.accept("一个是听的人当真的，一个是说的人当真了");
    }


    //语法格式五：Lambda 需要两个或者两个以上的参数  多条执行语句  并且可能有返回值
    @Test
    public void test3(){
        //lambda表达式的写法
        //方法实现中只有一条语句的时候
        Comparator<Integer> com = (o1,o2)-> Integer.compare(o1,o2);
        Comparator<Integer> com2 = (o1,o2)-> o1.compareTo(o2);
        //方法实现中存在多条语句
        Comparator<Integer> com3 = (o1,o2)-> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        int compare = com.compare(12, 21);
        System.out.println(compare);
    }

    //语法格式六： 当Lambda体中只有一条语句时  return 与大括号都可以省略

    //案例 ：见上面


}
