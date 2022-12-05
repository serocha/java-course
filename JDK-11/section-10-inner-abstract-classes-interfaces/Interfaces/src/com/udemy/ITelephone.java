package com.udemy;
public interface ITelephone {
    // defines a signature, but none of the actual code
    // access modifiers can be specified within the classes themselves
    void powerOn();
    void dial(int phoneNumber);
    void answer();
    boolean callPhone(int phoneNumber);
    boolean isRinging();
}
