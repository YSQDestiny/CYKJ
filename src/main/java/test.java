/**
 * @author yangsq
 * @date 2018/7/2 17:17.
 */
public class test {



    public static void main(String[] args){

        String a = "财产综合险";
        String b = "财产综合险,财产一切险,财产基本险";
        String c = "团体意外险,雇主责任险,财产综合险,财产一切险,财产基本险";

        System.out.println(a.split(",").length);
        System.out.println(b.split(",").length);
        System.out.println(c.split(",").length);

        boolean isHave = false;
        for (String temp : a.split(",")){
            for (String temp2 : b.split(",")){
                if (temp.equals(temp2)){
                    isHave = true;
                    System.out.println(isHave);
                    return;
                }else {
                    isHave = false;
                }
            }
        }
        System.out.println(isHave);
    }

}
