package com.sebastian.taskgroup.util.exceptions;

public class IdNotFoundException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Id no exist in %s";

    public IdNotFoundException(String tableName) {
        super(String.format(ERROR_MESSAGE, tableName));
    }
}