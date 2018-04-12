package models;

import io.ebean.Model;

import java.math.BigInteger;

public class ErrorResponse extends Model {
    public BigInteger code;
    public String message;

    public static ErrorResponse NOT_FOUND;
    public static ErrorResponse BAD_REQUEST;
    public static ErrorResponse NOT_ACCEPTABLE;

    static{
        NOT_FOUND = new ErrorResponse();
        NOT_FOUND.message =  "Not Found";
        NOT_FOUND.code = new BigInteger("404");

        BAD_REQUEST = new ErrorResponse();
        BAD_REQUEST.message =  "Bad Request";
        BAD_REQUEST.code = new BigInteger("400");

        NOT_ACCEPTABLE = new ErrorResponse();
        NOT_ACCEPTABLE.message =  "Not Acceptable";
        NOT_ACCEPTABLE.code = new BigInteger("406");
    }
}