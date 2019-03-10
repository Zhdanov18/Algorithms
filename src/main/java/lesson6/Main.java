package lesson6;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int treeCount = 20;
        int maxDepth = 4;
        int min = -10;
        int max = 20;
        int counter = 0;

        TreeImpl<Integer>[] testTree = new TreeImpl[treeCount];
        Random value = new Random();

        for (int i = 0; i < treeCount; i++){
            testTree[i] = new TreeImpl<>();
            while (testTree[i].height() < maxDepth){
                testTree[i].add(value.nextInt(max - min + 1) + min);
            }
            if(!testTree[i].isBalanced()){
                counter++;
            }
        }
        System.out.println("Процент несбалансированных деревьев: " + counter * 100 / treeCount);
    }
}

// При имеющихся входных данных, процент несбалансированных деревьев составляет от 80 до 100

// Если быть честным, то выполнение данного практического задания свелось к разбору представленного
// Вами кода.
// Ваш совет в телеграме добавить к узлу поле глубина мне показался не самым удачным из-за
// необходимости при удалении не листового узла пробегать по всем потомкам и менять у них данное поле.
// Хотя, если оценивать быстродействие, то это будет несомненно быстрее, чем при каждом добавлении узла
// вычислять глубину с помощью рекурсии. При этом можно задуматься о соотношении количества
// операций на добавление и удаление.