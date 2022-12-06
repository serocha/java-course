package com.udemy;

public class MyLinkedList implements NodeList {

    private ListItem root;

    public MyLinkedList (ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem item) {
        // if empty
        if (root == null) {
            root = item;
            return true;
        }

        ListItem currentItem = root;
        // start working down the line
        while (currentItem != null) {
            if (currentItem.compareTo(item) < 0) {
                if (currentItem.next() != null) {
                    // if smaller, and not at end, keep going
                    currentItem = currentItem.next();
                } else {
                    // we're at the end; assign next and prev links and stop
                    currentItem.setNext(item).setPrevious(currentItem);
                    return true;
                }
            } else if (currentItem.compareTo(item) > 0) {
                // item is bigger than currentItem
                if (currentItem.previous() != null) {
                    // not at head, insert link to item ahead of current item and set up other links
                    currentItem.previous().setNext(item).setPrevious(currentItem.previous());
                    item.setNext(currentItem).setPrevious(item);
                } else {
                    // item becomes the head
                    item.setNext(root).setPrevious(item);
                    root = item;
                }
                return true;
            } else {
                System.out.println(item.getValue() + " is already present, not added.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        // similar as add
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }

        ListItem currentItem = root;
        while (currentItem != null) {
            if (currentItem.compareTo(item) == 0) {
                if (currentItem == root) {
                    root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (currentItem.compareTo(item) < 0) {
                currentItem = currentItem.next();
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
