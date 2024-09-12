package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.сustomExeptions;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}