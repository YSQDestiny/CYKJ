import java.util.ArrayList;
import java.util.List;

/**
 * @author yangsq
 * @date 2018/7/2 17:17.
 */
public class test {



    public static void main(String[] args){

        List<String> list = new ArrayList<>();
        list.add("a");
        boolean test = false;
        if (list != null & list.size() > 0){
            test = true;
        }
        System.out.println(test);
    }

}
