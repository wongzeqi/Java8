package com.wjq.optional;
import org.junit.Test;
import java.util.Optional;
public class TestOptional2 {
    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }
    //方法优化
    public String getGirlName2(Boy boy){
        if(boy!=null){
            Girl girl = boy.getGirl();
            if(girl!=null){
                return girl.getName();
            }
        }
        return null;
    }
    //使用Optional这个类优化
    public String getGirlName3(Boy boy){
        Optional<Boy> boy2 = Optional.ofNullable(boy);
        return Optional.ofNullable(boy2.orElse(new Boy()).getGirl()).orElse(new Girl()).getName();
    }
    @Test
    public void test1(){
        String girlName = getGirlName(new Boy());//这里会发生空指针异常
        System.out.println(girlName);
    }
    @Test
    public void test2(){
        String girlName = getGirlName2(new Boy());//这里会发生空指针异常
        System.out.println(girlName);
    }
    @Test
    public void test3(){
        String girlName = getGirlName3(new Boy());//这里会发生空指针异常
        System.out.println(girlName);
    }
}
