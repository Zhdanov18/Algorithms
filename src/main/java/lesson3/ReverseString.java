package lesson3;

import lesson3.deque.MyDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReverseString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while (!line.equals("end")) {
            line = br.readLine();
            System.out.println(reverse(line));
        }
    }

//проверим MyDeque, хотя можно переворачивать через класс MyStack
    public static String reverse(String line){
        MyDeque<Character> deque = new MyDeque<Character>(line.length());
        for (int i = 0; i < line.length(); i++)
            deque.insertLeft(line.charAt(i));
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty())
            result.append(deque.removeLeft());
        return result.toString();
    }
}
