package lesson7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Орел", "Курск");
        graph.addEdges("Воронеж", "Липецк", "Саратов", "Курск");

        graph.bfs("Москва");
        graph.showPath("Липецк", "Орел");
        graph.showPath("Липецк", "Тамбов");
        graph.showPath("Липецк", "Рязань");
        graph.showPath("Тула", "Тамбов");
    }
}

//        Vertex{label='Москва'}
//        Vertex{label='Тула'}
//        Vertex{label='Рязань'}
//        Vertex{label='Калуга'}
//        Vertex{label='Липецк'}
//        Vertex{label='Тамбов'}
//        Vertex{label='Орел'}
//        Vertex{label='Воронеж'}
//        Vertex{label='Саратов'}
//        Vertex{label='Курск'}
//        Липецк Воронеж Курск Орел
//        Липецк Воронеж Саратов Тамбов
//        Липецк Тула Москва Рязань
//        Тула Москва Рязань Тамбов
// Ваш совет с добавлением поля показался скучным, а так решил закрепить рекурсию )