package priv.wjq.funcinterface;

//Lambda表达式的本质  作为函数式接口的一个实例
//什么是函数式接口   此接口中只有一个方法的接口

//
//Runable  Callable


//java8  在java.util.function包下定义了非常丰富的函数式接口

//Consumer<T>            void     accept(T t)        消费型接口
// Supplier<T>           T        get()              供给型接口
// Function<T,R>         R        apply(T t)         函数型接口
// Predicate<T>          boolean  test(T t)          断定型接口

public class TestFunctionalInterface {

    MyFunctionalInterface myFunctionalInterface = () -> {};

}


@FunctionalInterface//这中就是标记性注解
interface MyFunctionalInterface{
    void fun();
}