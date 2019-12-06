import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree<E extends Comparable> {

    // class attributes
    private TNode<E> root;

    // default constructor
    public Tree() {
        root = null;
    }

    // constructor with root parameter
    public Tree(TNode<E> root) {
        this.root = root;
    }

    // constructor with initial list
    public Tree(E... list) {
        // if passing empty list
        if (list == null || list.length <= 0) {
            this.root = null;
            return;
        }

        for (int i = 0; i < list.length; i++) {
            this.insert(list[i]);
        }
    }

    public TNode<E> getRoot() {
        return this.root;
    }

    // find an element
    public TNode<E> find(E key) {
        TNode<E> current = root;

        while (current != null && !current.getData().equals(key)) {
            if (key.compareTo(current.getData()) < 0)
                current = current.getLeft();
            else
                current = current.getRight();

            if (current == null)
                return null;
        }
        return current;
    }

    // find an element recursivley
    public TNode<E> findR(E key, TNode<E> root) {

        if (root == null) {
            return null;
        }

        if (key.compareTo(root.getData()) < 0) {
            return findR(key, root.getLeft());
        }

        if (key.compareTo(root.getData()) > 0) {
            return findR(key, root.getRight());
        }

        return root;

    }

    public void insert(E elm) {
        TNode<E> newNode = new TNode<E>(elm);

        if (root == null) {
            root = newNode;
            return;
        }

        TNode<E> current = root;
        TNode<E> parent;
        while (true) {
            parent = current;
            if (elm.compareTo(current.getData()) < 0) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(newNode);
                    return;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                    return;
                }
            }
        }

    }

    @Override
    public String toString() {
        return this.toStringInOrderR(this.root);
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
        case 1:
            System.out.print("\nPreorder traversal: ");
            System.out.println(this.toStringPreOrderR(root));
            break;
        case 2:
            System.out.print("\nInorder traversal:  ");
            System.out.println(this.toStringPreOrderR(root));
            break;
        case 3:
            System.out.print("\nPostorder traversal: ");
            System.out.println(this.toStringPreOrderR(root));
            break;
        }
        System.out.println();
    }

    public boolean delete(E key) {
        TNode<E> current = root;
        TNode<E> parent = root;
        boolean isLeftChild = true;

        while (!current.getData().equals(key)) {
            parent = current;
            if (key.compareTo(current.getData()) < 0) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            if (current == null)
                return false;
        }

        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.setLeft(null);
            else
                parent.setRight(null);
        }

        else if (current.getRight() == null)
            if (current == root)
                root = current.getLeft();
            else if (isLeftChild)
                parent.setLeft(current.getLeft());
            else
                parent.setRight(current.getLeft());

        else if (current.getLeft() == null)
            if (current == root)
                root = current.getRight();
            else if (isLeftChild)
                parent.setLeft(current.getRight());
            else
                parent.setRight(current.getRight());

        else {

            TNode<E> successor = getSuccessor(current);

            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.setLeft(successor);
            else
                parent.setRight(successor);

            successor.setLeft(current.getLeft());
        }

        return true;
    }

    private TNode<E> getSuccessor(TNode<E> delNode) {
        TNode<E> successorParent = delNode;
        TNode<E> successor = delNode;
        TNode<E> current = delNode.getRight();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }

        if (successor != delNode.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(delNode.getRight());
        }
        return successor;
    }

    public String toStringInOrderR(TNode<E> root) {
        String output = "";

        if (root == null)
            return "";

        output += toStringInOrderR(root.getLeft());
        output += root.getData().toString() + " ";
        output += toStringInOrderR(root.getRight());

        return output;
    }

    public String toStringPreOrderR(TNode<E> root) {
        String output = "";

        if (root == null)
            return "";

        output += root.getData().toString() + " ";
        output += toStringPreOrderR(root.getLeft());
        output += toStringPreOrderR(root.getRight());

        return output;
    }

    public String toStringPostOrderR(TNode<E> root) {
        String output = "";

        if (root == null)
            return "";

        output += toStringPostOrderR(root.getLeft());
        output += toStringPostOrderR(root.getRight());
        output += root.getData().toString() + " ";

        return output;
    }

    public String toStringInOrderN() {
        String output = "";

        Stack<TNode<E>> stack = new Stack<TNode<E>>();
        TNode<E> current = this.root;

        while (current != null || stack.size() > 0) {

            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }

            current = stack.pop();
            output += current.getData() + " ";

            current = current.getRight();
        }
        return output;
    }

    public String toStringIPreOrderN() {
        String output = "";

        Stack<TNode<E>> stack = new Stack<TNode<E>>();
        TNode<E> current = root;

        stack.push(current);

        while (current != null || stack.size() > 0) {

            current = stack.pop();
            output += current.getData() + " ";

            while (current.getRight() != null) {
                stack.push(current.getRight());
            }

            while (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }
        return output;
    }

    public String toStringLevelOrder(TNode<E> startNode) {
        String output = "";
        Queue<TNode<E>> queue = new LinkedList<TNode<E>>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            TNode<E> tempNode = queue.poll();
            output += tempNode.getData() + " ";
            if (tempNode.getLeft() != null)
                queue.add(tempNode.getLeft());
            if (tempNode.getRight() != null)
                queue.add(tempNode.getRight());
        }
        return output;
    }

    public String toStringPostOrderN() {
        TNode<E> node = this.root;
        String output = "";
        Stack<TNode<E>> S = new Stack<TNode<E>>();

        // Check for empty tree
        if (node == null)
            return output;
        S.push(node);
        TNode<E> prev = null;
        while (!S.isEmpty()) {
            TNode<E> current = S.peek();

            if (prev == null || prev.getLeft() == current || prev.getRight() == current) {
                if (current.getLeft() != null)
                    S.push(current.getLeft());
                else if (current.getRight() != null)
                    S.push(current.getRight());
                else {
                    S.pop();
                    output += current.getData() + " ";
                }

            } else if (current.getLeft() == prev) {
                if (current.getRight() != null)
                    S.push(current.getRight());
                else {
                    S.pop();
                    output += current.getData() + " ";
                }

            } else if (current.getRight() == prev) {
                S.pop();
                output += current.getData() + " ";
            }

            prev = current;
        }

        return output;
    }

    public String toStringPreOrderN() {
        TNode<E> node = this.root;
        String output = "";
         if (node == null) { 
            return output; 
        } 
  
        Stack<TNode<E>> nodeStack = new Stack<TNode<E>>(); 
        nodeStack.push(node); 
  
        while (nodeStack.empty() == false) { 
              
            TNode<E> temp = nodeStack.peek(); 
            output += temp.getData() + " "; 
            nodeStack.pop();
  
            if (temp.getRight() != null) { 
                nodeStack.push(temp.getRight()); 
            } 
            if (temp.getLeft() != null) { 
                nodeStack.push(temp.getLeft()); 
            } 
        }

        return output;
    }

    public void displayTree() {
        System.out.println(this.toString());
    }

    public boolean depthFirst(E key, TNode<E> n) {
        Stack<TNode<E>> stack = new Stack<TNode<E>>();
        boolean found = false;
        if (n != null) {
            
            stack.push(n);
            do {
                System.out.println(stack);
                TNode<E> node = stack.pop();
                if (node.getData().compareTo(key) == 0)
                    found = true;
                else {
                    if(node.getRight() != null)
                        stack.push(node.getRight());
                    if(node.getLeft() != null)
                        stack.push(node.getLeft());
                }
            } while (!found && !stack.isEmpty());
        }
        return found;
    }

    public E min() {
        if (this.root == null) {
            return null;
        }

        TNode<E> node = this.root;
        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node.getData();
    }

    public E max() {
        if (this.root == null) {
            return null;
        }

        TNode<E> node = this.root;
        while (node.getRight() != null) {
            node = node.getRight();
        }

        return node.getData();
    }

    public void displayMinMax() {
        System.out.println("the elements: " + this.toString());
        System.out.println("the max: " + this.max());
        System.out.println("the min: " + this.min());
    }

}