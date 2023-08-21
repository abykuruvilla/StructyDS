package com.kaby.ds.binarytree;

import java.io.PrintStream;

public class BinaryTreePrinter<T> {

    private final Node<T> tree;

    public BinaryTreePrinter(Node<T> tree) {
        this.tree = tree;
    }

    private String traversePreOrder(Node<T> root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        String pointerRight = "└──";
        String pointerLeft = (root.rightNode != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.leftNode, root.rightNode != null);
        traverseNodes(sb, "", pointerRight, root.rightNode, false);

        return sb.toString();
    }

    private void traverseNodes(StringBuilder sb, String padding, String pointer, Node<T> node,
                               boolean hasRightSibling) {

        if (node != null) {

            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.val);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.rightNode != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.leftNode, node.rightNode != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.rightNode, false);

        }

    }

    public void print(PrintStream os) {
        os.print("\n");
        os.print("\n");
        os.print(traversePreOrder(tree));
    }
}
