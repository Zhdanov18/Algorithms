package lesson5;

public class Extent {

    public static double doExtent(double number, double degree){
        if(degree == 0 && number == 0){
            throw new IllegalArgumentException();
        }
        if(degree == 0){
            if(number > 0)
                return 1;
            else
                return -1;
        }
        if (degree == 1){
            return number;
        }
        if(degree < 0){
            return 1 / number * doExtent(number, degree + 1);
        }
        return number * doExtent(number, degree - 1);
    }

    public static void main(String[] args) {
        System.out.println(doExtent(2, 3));
        System.out.println(doExtent(2, -3));
        System.out.println(doExtent(-2, -3));
        System.out.println(doExtent(-2, -4));
        System.out.println(doExtent(-2, 0));
        System.out.println(doExtent(0, 0));
    }
}

//        8.0
//        0.125
//        0.125
//        -0.0625
//        -1.0
//        Exception in thread "main" java.lang.IllegalArgumentException
//        at lesson5.Extent.doExtent(Extent.java:7)
//        at lesson5.Extent.main(Extent.java:30)