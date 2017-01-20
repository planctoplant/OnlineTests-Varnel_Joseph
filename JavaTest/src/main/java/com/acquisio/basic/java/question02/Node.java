package com.acquisio.basic.java.question02;

public class Node {
    String name;
    Node children[];

    public String getName() {
        return name;
    }

    public Node[] getChildren() {
        return children;
    }

    public Node(String name, Node... children) {
        this.name = name;
        if (children != null) {
            this.children = new Node[children.length];
            System.arraycopy(
                    children, 0, this.children, 0, children.length);
        }
    }
    
    public void printTree() {
        printStructure(children.length);
    }
    
    public void printName() {
        System.out.println(getName());
    }
    
    public void printStructure(int depth) {
        
        for(int i = 0; i < depth; i++) {
            System.out.print('.');
        }
        
        printName();
        
        if (children.length > 0) {
            for(int i = 0; i < children.length; i++) {
                
                if (children[i] != null) {
                    children[i].printStructure(depth + children.length);
                }
            }
        }
    }
}


