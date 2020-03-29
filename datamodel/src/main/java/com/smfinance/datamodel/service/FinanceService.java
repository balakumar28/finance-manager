package com.smfinance.datamodel.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.smfinance.datamodel.exceptions.DataModelException;
import com.smfinance.datamodel.exceptions.InvalidDataException;
import com.smfinance.datamodel.exceptions.ObjectNotFoundException;
import com.smfinance.datamodel.objects.FinanceType;
import com.smfinance.datamodel.objects.Periodicity;
import com.smfinance.datamodel.objects.User;
import com.smfinance.datamodel.objects.UserFinance;
import com.smfinance.datamodel.repositories.PaymentsRepository;
import com.smfinance.datamodel.repositories.UserFinanceRepository;

public class FinanceService
{
    @Autowired
    private UserFinanceRepository financeRepository;
    @Autowired
    private PaymentsRepository paymentsRepository;
    
    private UserService userService;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");
    
    public FinanceService()
    {
        this(new UserService());
    }
    
    public FinanceService(UserService userService)
    {
        this.userService = userService;
    }
    
    public UserFinance getFinance(String id) throws DataModelException
    {
        Optional<UserFinance> finance = financeRepository.findById(id);
        if(!finance.isPresent())
            throw new ObjectNotFoundException(id);
        
        return finance.get();
    }
    
    public void makeNewLending(String userId, double principal, double interestRate, double term, Periodicity instalmentType, String disburseDate, String commenceDate, FinanceType financeType,
                               User guarantorId, byte[] supprtDoc)
    {
    
    }
    
    public void closeFinance(String financeId) throws DataModelException
    {
        closeFinance(financeId, Calendar.getInstance().getTime().toString());
    }
    
    public void closeFinance(String financeId, String closeDate) throws DataModelException
    {
        closeFinance(getFinance(financeId), closeDate);
    }
    
    public void closeFinance(UserFinance finance) throws DataModelException
    {
        closeFinance(finance, Calendar.getInstance().getTime().toString());
    }
    
    public void closeFinance(UserFinance finance, String closeDate) throws DataModelException
    {
        finance.setDateOfClosure(new Date(parseDate(closeDate)));
    }
    
    private long parseDate(String date) throws DataModelException
    {
        try
        {
            return dateFormat.parse(date).getTime();
        }
        catch(ParseException e)
        {
            throw new InvalidDataException(date + ". Use " + dateFormat.toPattern());
        }
    }
    
    public void makePayment(String financeId, double amount) throws DataModelException
    {
        makePayment(getFinance(financeId), amount);
    }
    
    public void makePayment(UserFinance financeId, double amount)
    {
    
    }
}
