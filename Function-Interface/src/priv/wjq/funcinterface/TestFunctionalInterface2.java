package priv.wjq.funcinterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
public class TestFunctionalInterface2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("北京","天津","东京");
        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s.contains("京")) {
                    return true;
                }
                return false;
            }
        });

        //lambda写法
        List<String> list2 = filterString(list, s -> s.contains("京"));

        System.out.println(list1);
        System.out.println(list2);

    }

    //编写一个过滤字符串的方法  要求过滤规则由用户来自定义
    public static List<String> filterString(List<String> list, Predicate<String> pre){
        List<String> filteredList = new ArrayList<>();
        for (String s : list) {
            if(pre.test(s)){
                filteredList.add(s);
            }
        }
        return filteredList;
    }
}


