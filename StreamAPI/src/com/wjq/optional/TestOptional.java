package com.wjq.optional;

        import org.junit.Test;

        import java.util.Optional;

public class TestOptional {


    @Test
    public void test1(){
        Optional<Object> o1 = Optional.of(new Girl());



        Optional<Object> o2 = Optional.empty();

        Optional<Object> o3 = Optional.ofNullable(new Boy());

        //of方法必须不能为空
        Optional<Object> o4 = Optional.of(null);

//        public static <T> Optional<T> ofNullable(T value) {
//            return value == null ? empty() : of(value);
//        }
        //当不知道对象是否为空的时候使用此方法
        Optional<Object> o5 = Optional.ofNullable(null);
    }
}
