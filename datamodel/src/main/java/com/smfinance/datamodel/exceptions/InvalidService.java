package com.smfinance.datamodel.exceptions;

public class InvalidService extends DataModelException
{
    public InvalidService()
    {
    }
    
    public InvalidService(String message)
    {
        super(message);
    }
    
    public InvalidService(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public InvalidService(Throwable cause)
    {
        super(cause);
    }
}
