package com.udemy;

import java.util.List;

public interface ISaveable {

    void read(List<String> data); // modify data
    List<String> write(); // read data
}
