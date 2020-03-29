package com.smfinance.datamodel.exceptions;

public class ObjectNotFoundException extends DataModelException
{
    public ObjectNotFoundException()
    {
    }
    
    public ObjectNotFoundException(String message)
    {
        super(message);
    }
    
    public ObjectNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public ObjectNotFoundException(Throwable cause)
    {
        super(cause);
    }
}
