package com.smfinance.datamodel.objects;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_finances")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserFinanceBase implements Serializable
{
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    protected String financeId;
    @JoinColumn(referencedColumnName = "userId")
    protected User userId;
    protected double principal;
    protected double interestRate;
    protected double term;
    protected Periodicity instalmentType;
    protected Date dateOfCommencement;
    protected Date dateOfDisbursement;
    protected FinanceType finance_type;
    protected double instalmentAmount;
    protected double remainingPrincipal;
    protected Date dateOfClosure;
    
    public String getFinanceId()
    {
        return financeId;
    }
    
    public void setFinanceId(String financeId)
    {
        this.financeId = financeId;
    }
    
    public User getUserId()
    {
        return userId;
    }
    
    public void setUserId(User userId)
    {
        this.userId = userId;
    }
    
    public double getPrincipal()
    {
        return principal;
    }
    
    public void setPrincipal(double principal)
    {
        this.principal = principal;
    }
    
    public double getInterestRate()
    {
        return interestRate;
    }
    
    public void setInterestRate(double interestRate)
    {
        this.interestRate = interestRate;
    }
    
    public double getTerm()
    {
        return term;
    }
    
    public void setTerm(double term)
    {
        this.term = term;
    }
    
    public Periodicity getInstalmentType()
    {
        return instalmentType;
    }
    
    public void setInstalmentType(Periodicity instalmentType)
    {
        this.instalmentType = instalmentType;
    }
    
    public Date getDateOfCommencement()
    {
        return dateOfCommencement;
    }
    
    public void setDateOfCommencement(Date dateOfCommencement)
    {
        this.dateOfCommencement = dateOfCommencement;
    }
    
    public Date getDateOfDisbursement()
    {
        return dateOfDisbursement;
    }
    
    public void setDateOfDisbursement(Date dateOfDisbursement)
    {
        this.dateOfDisbursement = dateOfDisbursement;
    }
    
    public FinanceType getFinance_type()
    {
        return finance_type;
    }
    
    public void setFinance_type(FinanceType finance_type)
    {
        this.finance_type = finance_type;
    }
    
    public double getInstalmentAmount()
    {
        return instalmentAmount;
    }
    
    public void setInstalmentAmount(double instalmentAmount)
    {
        this.instalmentAmount = instalmentAmount;
    }
    
    public double getRemainingPrincipal()
    {
        return remainingPrincipal;
    }
    
    public void setRemainingPrincipal(double remainingPrincipal)
    {
        this.remainingPrincipal = remainingPrincipal;
    }
    
    public Date getDateOfClosure()
    {
        return dateOfClosure;
    }
    
    public void setDateOfClosure(Date dateOfClosure)
    {
        this.dateOfClosure = dateOfClosure;
    }
    
    @Override
    public String toString()
    {
        return "UserFinancesBase{" +
                ", userId=" + userId +
                ", principal=" + principal +
                ", interest_rate=" + interestRate +
                ", term=" + term +
                ", dateOfCommencement=" + dateOfCommencement +
                ", dateOfDisbursement=" + dateOfDisbursement +
                ", instalmentAmount=" + instalmentAmount +
                ", remainingPrincipal=" + remainingPrincipal +
                '}';
    }
}
