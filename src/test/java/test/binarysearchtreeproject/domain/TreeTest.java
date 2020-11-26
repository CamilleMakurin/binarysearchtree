package test.binarysearchtreeproject.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class TreeTest {

    private Tree tree;

    @Before
    public void setUp() throws Exception {
        tree = new Tree();
    }

    @Test
    public void testInsert_onlyRoot() {
        tree.insert(3);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(3))));
        assertThat(tree, hasProperty("root", hasProperty("right", nullValue())));
        assertThat(tree, hasProperty("root", hasProperty("left", nullValue())));
    }

    @Test
    public void testInsert_hasLeftChild() {
        tree.insert(5);
        tree.insert(4);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(5))));
        assertThat(tree, hasProperty("root", hasProperty("right", nullValue())));

        assertThat(tree, hasProperty("root",
                hasProperty("left", hasProperty("key", equalTo(4)))));
    }

    @Test
    public void testInsert_hasRightChild() {
        tree.insert(5);
        tree.insert(6);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(5))));
        assertThat(tree, hasProperty("root", hasProperty("left", nullValue())));

        assertThat(tree, hasProperty("root",
                hasProperty("right", hasProperty("key", equalTo(6)))));
    }

    @Test
    public void testInsert_hasLeftAndRightChild() {
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(5))));
        assertThat(tree, hasProperty("root",
                hasProperty("right", hasProperty("key", equalTo(6)))));
        assertThat(tree, hasProperty("root",
                hasProperty("left", hasProperty("key", equalTo(4)))));
    }

    @Test
    public void testInsert_hasLeftChildWithLeftChild() {
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(5))));
        assertThat(tree, hasProperty("root", hasProperty("right", nullValue())));

        assertThat(tree, hasProperty("root",
                hasProperty("left", hasProperty("key", equalTo(4)))));
        assertThat(tree, hasProperty("root",
                hasProperty("left",
                        hasProperty("left", hasProperty("key", equalTo(3))))));
        assertThat(tree, hasProperty("root",
                hasProperty("left", hasProperty("right", nullValue()))));
    }

    @Test
    public void testInsert_hasLeftChildWithRightChild() {
        tree.insert(6);
        tree.insert(4);
        tree.insert(5);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(6))));
        assertThat(tree, hasProperty("root", hasProperty("right", nullValue())));
        assertThat(tree, hasProperty("root",
                hasProperty("left", hasProperty("key", equalTo(4)))));
        assertThat(tree, hasProperty("root",
                hasProperty("left",
                        hasProperty("right", hasProperty("key", equalTo(5))))));
        assertThat(tree, hasProperty("root",
                hasProperty("left", hasProperty("left", nullValue()))));
    }

    @Test
    public void testInsert_hasLeftChildWithRightAndLeftChild() {
        tree.insert(7);
        tree.insert(4);
        tree.insert(5);
        tree.insert(2);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(7))));
        assertThat(tree, hasProperty("root", hasProperty("right", nullValue())));

        assertThat(tree, hasProperty("root",
                hasProperty("left", hasProperty("key", equalTo(4)))));
        assertThat(tree, hasProperty("root",
                hasProperty("left",
                        hasProperty("right", hasProperty("key", equalTo(5))))));
        assertThat(tree, hasProperty("root",
                hasProperty("left",
                        hasProperty("left", hasProperty("key", equalTo(2))))));
    }


    @Test
    public void testInsert_hasRightChildWithLeftChild() {
        tree.insert(5);
        tree.insert(7);
        tree.insert(6);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(5))));
        assertThat(tree, hasProperty("root", hasProperty("left", nullValue())));

        assertThat(tree, hasProperty("root",
                hasProperty("right", hasProperty("key", equalTo(7)))));
        assertThat(tree, hasProperty("root",
                hasProperty("right",
                        hasProperty("left", hasProperty("key", equalTo(6))))));
        assertThat(tree, hasProperty("root",
                hasProperty("right", hasProperty("right", nullValue()))));
    }

    @Test
    public void testInsert_hasRightChildWithRightChild() {
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(5))));
        assertThat(tree, hasProperty("root", hasProperty("left", nullValue())));

        assertThat(tree, hasProperty("root",
                hasProperty("right", hasProperty("key", equalTo(6)))));
        assertThat(tree, hasProperty("root",
                hasProperty("right",
                        hasProperty("right", hasProperty("key", equalTo(7))))));
        assertThat(tree, hasProperty("root",
                hasProperty("right", hasProperty("left", nullValue()))));
    }

    @Test
    public void testInsert_hasRightChildWithRightAndLeftChild() {
        tree.insert(4);
        tree.insert(7);
        tree.insert(8);
        tree.insert(5);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(4))));
        assertThat(tree, hasProperty("root", hasProperty("left", nullValue())));
        assertThat(tree, hasProperty("root",
                hasProperty("right", hasProperty("key", equalTo(7)))));
        assertThat(tree, hasProperty("root",
                hasProperty("right",
                        hasProperty("right", hasProperty("key", equalTo(8))))));
        assertThat(tree, hasProperty("root",
                hasProperty("right",
                        hasProperty("left", hasProperty("key", equalTo(5))))));
    }

    @Test
    public void testInsert_InsertDuplicate() {
        tree.insert(5);
        tree.insert(6);
        tree.insert(6);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(5))));
        assertThat(tree, hasProperty("root", hasProperty("left", nullValue())));
        assertThat(tree, hasProperty("root",
                hasProperty("right", hasProperty("key", equalTo(6)))));
        assertThat(tree, hasProperty("root",
                hasProperty("right", hasProperty("right", nullValue()))));
        assertThat(tree, hasProperty("root",
                hasProperty("right", hasProperty("left", nullValue()))));
    }

    @Test
    public void testSearch_root() {
        tree.insert(5);
        assertThat(tree.searchKey(5), is(0));
    }

    @Test
    public void testSearch_distance1() {
        tree.insert(5);
        tree.insert(6);
        assertThat(tree.searchKey(6), is(1));
    }

    @Test
    public void testSearch_distance2() {
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        assertThat(tree.searchKey(5), is(2));
    }

    @Test
    public void testSearch_notFound() {
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        assertThat(tree.searchKey(9), is(-1));
    }

    @Test
    public void testDelete() {
        tree.insert(4);
        tree.deleteKey(4);
        assertThat(tree, hasProperty("root", nullValue()));
    }

    @Test
    public void testDelete_deleteLeftChild() {
        tree.insert(4);
        tree.insert(3);
        tree.deleteKey(3);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(4))));
        assertThat(tree, hasProperty("root", hasProperty("right", nullValue())));
        assertThat(tree, hasProperty("root", hasProperty("left", nullValue())));
    }

    @Test
    public void testDelete_deleteRightChild() {
        tree.insert(4);
        tree.insert(6);
        tree.deleteKey(6);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(4))));
        assertThat(tree, hasProperty("root", hasProperty("right", nullValue())));
        assertThat(tree, hasProperty("root", hasProperty("left", nullValue())));
    }

    @Test
    public void testDelete_deleteLeftChildOfRightChild() {
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        tree.deleteKey(5);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(4))));
        assertThat(tree, hasProperty("root", hasProperty("left", nullValue())));
        assertThat(tree, hasProperty("root", hasProperty("right", hasProperty("key", equalTo(6)))));
        assertThat(tree, hasProperty("root", hasProperty("right",
                hasProperty("left", nullValue()))));
        assertThat(tree, hasProperty("root", hasProperty("right",
                hasProperty("right", nullValue()))));
    }

    @Test
    public void testDelete_deleteRightChildOfLeftChild() {
        tree.insert(6);
        tree.insert(4);
        tree.insert(5);
        tree.deleteKey(5);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(6))));
        assertThat(tree, hasProperty("root", hasProperty("right", nullValue())));
        assertThat(tree, hasProperty("root", hasProperty("left", hasProperty("key", equalTo(4)))));
        assertThat(tree, hasProperty("root", hasProperty("left",
                hasProperty("left", nullValue()))));
        assertThat(tree, hasProperty("root", hasProperty("left",
                hasProperty("right", nullValue()))));
    }

    @Test
    public void testDelete_deleteNonExisting() {
        tree.insert(4);
        tree.insert(3);
        tree.deleteKey(9);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(4))));
        assertThat(tree, hasProperty("root", hasProperty("right", nullValue())));
        assertThat(tree, hasProperty("root", hasProperty("left", hasProperty("key", equalTo(3)))));
    }

    @Test
    public void testDelete_deleteNodeWithChilds() {
        tree.insert(4);
        tree.insert(3);
        tree.deleteKey(4);
        assertThat(tree, hasProperty("root", hasProperty("key", equalTo(4))));
        assertThat(tree, hasProperty("root", hasProperty("right", nullValue())));
        assertThat(tree, hasProperty("root", hasProperty("left", hasProperty("key", equalTo(3)))));
    }

}