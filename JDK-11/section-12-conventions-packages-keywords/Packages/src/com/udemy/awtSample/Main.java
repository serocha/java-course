package com.udemy.awtSample;

// this is just a quick showcase of utilizing packages to take advantage of functionality

// import org.w3c.dom.Node; --> only one import can be used for a single class name
public class Main {

    public static void main(String[] args) {
        //Node node = null; // the package is not imported if you use the full class name instead

        MyWindow myWindow = new MyWindow("Complete Java");
        myWindow.setVisible(true);
    }
}
