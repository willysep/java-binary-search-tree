public class Tree {
    Node root;

    Tree(Integer[] list) {
        for (int i = 0; i < list.length; i++) {
            if (i == 0) {
                this.root = new Node(list[0]);
            } else {
                insert(this.root, list[i]);
            }
        }
    }

    private Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        /* return the (unchanged) node pointer */
        return root;
    }

    private String rePrintString(Node root) {
        String result = "";
        if (root.left != null || root.right != null) {
            result += "(";
            if (root.left != null) {
                result += root.left.data.toString() + rePrintString(root.left);
            }
            result += ",";
            if (root.right != null) {
                result += root.right.data.toString() + rePrintString(root.right);
            }
            result += ")";
        }
        return result;
    }

    public void print(Node node) {
        String result = "";
        if (node == null) {
            result = this.root.data.toString();
            result += rePrintString(root);
        } else {
            result = node.data.toString();
            result += rePrintString(node);
        }
        System.out.println(result);
    }

    private Node search(Integer data, Node node) {
        if (node.data == data) {
            return node;
        }

        if (data < node.data) {
            return search(data, node.left);
        }

        if (data > node.data) {
            return search(data, node.right);
        }

        return null;
    }

    public void searchNode(Integer data) {
        Node a = search(data, this.root);
        if (a == null)
            System.out.println("Not Found");
        else
            print(a);
    }

    private Node delete(Integer data, Node node) {
        if (node.data == data) {
            return node;
        }

        if (data < node.data) {
            return search(data, node.left);
        }

        if (data > node.data) {
            return search(data, node.right);
        }

        return null;
    }
}
