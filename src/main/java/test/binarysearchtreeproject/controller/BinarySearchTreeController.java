package test.binarysearchtreeproject.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.binarysearchtreeproject.domain.Tree;

@RestController
@RequestMapping("/api")
public class BinarySearchTreeController {

    private final Tree tree;

    public BinarySearchTreeController(Tree tree) {
        this.tree = tree;
    }

    @GetMapping(value = "/key", produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Tree> exportAsXML() {
        return ResponseEntity.ok().body(tree);
    }

    @GetMapping("/key/{key}")
    public ResponseEntity searchKey(@PathVariable int key) {
        return ResponseEntity.ok(tree.searchKey(key));
    }

    @PostMapping("/key/{key}")
    public ResponseEntity insertKey(@PathVariable int key) {
        tree.insert(key);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/key/{key}")
    public ResponseEntity deleteKey(@PathVariable int key) {
        tree.deleteKey(key);
        return ResponseEntity.ok().build();
    }
}
