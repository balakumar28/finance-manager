package com.smfinance.datamodel.exceptions;

public class DataModelException extends Exception
{
    public DataModelException()
    {
    }
    
    public DataModelException(String message)
    {
        super(message);
    }
    
    public DataModelException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public DataModelException(Throwable cause)
    {
        super(cause);
    }
}
