package com.smfinance.datamodel.exceptions;

public class InvalidDataException extends DataModelException
{
    public InvalidDataException()
    {
    }
    
    public InvalidDataException(String message)
    {
        super(message);
    }
    
    public InvalidDataException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public InvalidDataException(Throwable cause)
    {
        super(cause);
    }
}
