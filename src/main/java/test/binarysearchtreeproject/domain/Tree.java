package test.binarysearchtreeproject.domain;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class Tree {

    private static final int NOT_FOUND_VALUE = -1;

    @Getter
    private Node root;

    public void insert(int key) {
        root = insert(root, key);
    }

    public int searchKey(int searchValue) {
        return searchKey(root, searchValue, 0);
    }

    public void deleteKey(int key) {
        this.root = deleteKey(root, key);
    }

    private Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (root.getKey() > key) {
            root.setLeft(insert(root.getLeft(), key));
        } else if (root.getKey() < key) {
            root.setRight(insert(root.getRight(), key));
        }
        return root;
    }

    private int searchKey(Node root, int searchValue, int distance) {
        if (root == null) {
            return NOT_FOUND_VALUE;
        }
        int rootKey = root.getKey();
        if (rootKey == searchValue) {
            return distance;
        }
        distance++;
        return rootKey > searchValue ? searchKey(root.getLeft(), searchValue, distance) : searchKey(root.getRight(), searchValue, distance);
    }

    private Node deleteKey(Node root, int key) {
        if (root == null) {
            return null;
        }
        int rootKey = root.getKey();
        if (key > rootKey) {
            root.setRight(deleteKey(root.getRight(), key));
        } else if (key < rootKey) {
            root.setLeft(deleteKey(root.getLeft(), key));
        }
        if (key == rootKey && hasNoChild(root)) {
            return null;
        }
        return root;
    }

    private boolean hasNoChild(Node node) {
        return node.getRight() == null && node.getLeft() == null;
    }
}
