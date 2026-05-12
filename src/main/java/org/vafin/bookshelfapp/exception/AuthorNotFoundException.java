package org.vafin.bookshelfapp.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id){
        super("Author with id " + id + " was not found");
    }

}
