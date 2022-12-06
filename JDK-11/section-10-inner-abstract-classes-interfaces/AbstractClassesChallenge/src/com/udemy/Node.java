package com.udemy;

public class Node extends ListItem {

    public Node (Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return rightLink;
    }

    @Override
    ListItem setNext(ListItem next) {
        rightLink = next;
        return rightLink;
    }

    @Override
    ListItem previous() {
        return leftLink;
    }

    @Override
    ListItem setPrevious(ListItem previous) {
        leftLink = previous;
        return leftLink;
    }

    @Override
    int compareTo(ListItem item) {
        if (item != null) {
            // compare
            // returns positive if higher, negative if lower, 0 if equal
            return (this.getValue().toString()).compareTo(item.getValue().toString());
        } else {
            return -1; // if the (next) item is null, stop where you are
        }
    }
}
