package com.wjq.stream;
//        Stream 自己不会存储元素。
//        Stream 不会改变源对象。相反，他们会返回-一个持有结果的新Stream。
//        Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
//3. Stream 执行流程
//    ①Stream的实例化
//    ②一系列的中间操作(过滤、 映射、...)
//    ③终止操作
//4.说明:
//    4.1 - -个中间操作链，对数据源的数据进行处理
//    4.2一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用

//四种创建Stream对象的方式
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
public class TestStreamAPI {
    //方式一 通过集合 创建
    //Java8中的Collection接口被扩展，提供了两个获取流的方法:
//        ●default Stream<E> stream() :返回一个顺序流
//        ●default Stream<E> parallelStream():返回一个并行流
    @Test
    public void test1() {
        List<String> list = Arrays.asList("北京", "上海", "广州", "银川", "上饶", "张家界");
        Stream<String> stream = list.stream();//返回的是一个串行流
        Stream<String> parallelStream = list.parallelStream();//获取的是并行流
    }
    //方式二 通过数组 创建
    @Test
    public void test2() {
        ////调用Arrays类的static <T>* Stream<T> stream(T[] array): 返回- -个流
        Stream<String> stream = Arrays.stream(new String[]{"北京", "上海", "广州", "银川", "上饶", "张家界"});

    }

    //方式三 通过Stream自己通过的静态方法of() 创建
    @Test
    public void test3() {
        Stream<String> stream = Stream.of("北京", "上海", "广州", "银川", "上饶", "张家界");
    }


    //方式四 创建无限流
    @Test
    public void test4() {
        //迭代
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)

        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);

        // 生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}