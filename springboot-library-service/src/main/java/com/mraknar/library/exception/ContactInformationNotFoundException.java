package com.mraknar.library.exception;

public class ContactInformationNotFoundException extends RuntimeException{

    public ContactInformationNotFoundException(){
        super("Contact information not found");
    }

}
