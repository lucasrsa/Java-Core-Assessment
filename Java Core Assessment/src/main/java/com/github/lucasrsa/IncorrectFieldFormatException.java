package com.github.lucasrsa;

public class IncorrectFieldFormatException extends Exception{

    public IncorrectFieldFormatException() {
        this("The given value does not match the expected format");
    }

    public IncorrectFieldFormatException(String message) {
        super(message);
    }
}
