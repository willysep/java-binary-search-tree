
public class App {

    public static void main(String[] args) throws Exception {
        Integer[] list = {50, 20, 10, 15, 30, 40, 60, 70, 80};
        Tree tree = new Tree(list);
        tree.print(null);

        tree.searchNode(100);

        tree.deleteNode(100);

        tree.print(null);
    }
}
