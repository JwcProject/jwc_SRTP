package edu.cqu.no1.exception;

/**
 * Created by ZKQ on 2015/5/26.
 */
public class ExistMultiUserException extends Exception {
    public ExistMultiUserException(String username) {
        super("username: "+username+" user have more than one record");
    }
}
