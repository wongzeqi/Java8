package com.wjq.construcator;
import com.wjq.refrence.User;
import org.junit.Test;
import java.util.function.Function;
import java.util.function.Supplier;
public class TestConstrucatorRefrence {
    @Test
    public void test1(){
        Supplier<User> sup = new Supplier<User>() {
            @Override
            public User get() {
                return new User();
            }
        };
        Supplier<User> sup1 = () -> new User();
        Supplier<User> sup2 = User::new;
        //此处调用的是User类中的带参数的构造器
        MySupplier<String,User> mysup = User::new;
    }

    //Function R apply(T t)
    @Test
    public void test2(){
        Function<String,User> func = username ->new User(username);
        Function<String,User> func1 = User::new;
        User wjq = func1.apply("wjq");
    }

}

interface MySupplier<T,V>{
    V get(T t1,T t2);
}
