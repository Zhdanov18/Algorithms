package lesson1;

public class Main {

    private static Integer binary_search(int[] list, int item){
        int low = 0;
        int high = list.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            int guess = list[mid];
            if(guess == item){
                return mid;
            }
            if(guess > item){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] my_list = {1, 3, 5, 7, 9};
        System.out.println(binary_search(my_list, 3));
        System.out.println(binary_search(my_list, -1));
    }
}
