package test.binarysearchtreeproject.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

    private int key;
    private Node left;
    private Node right;

    public Node(int value) {
        this.key = value;
    }
}
