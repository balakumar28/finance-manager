package com.smfinance.datamodel.objects;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "payments")
public class Payments implements Serializable
{
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String paymentId;
    @JoinColumn(referencedColumnName = "financeId")
    private UserFinance financeId;
    private Date dateOfPayment;
    private double amount;
    
    public String getPaymentId()
    {
        return paymentId;
    }
    
    public void setPaymentId(String paymentId)
    {
        this.paymentId = paymentId;
    }
    
    public UserFinance getFinanceId()
    {
        return financeId;
    }

    public void setFinanceId(UserFinance financeId)
    {
        this.financeId = financeId;
    }
    
    public Date getDateOfPayment()
    {
        return dateOfPayment;
    }
    
    public void setDateOfPayment(Date dateOfPayment)
    {
        this.dateOfPayment = dateOfPayment;
    }
    
    public double getAmount()
    {
        return amount;
    }
    
    public void setAmount(double amount)
    {
        this.amount = amount;
    }
    
    @Override
    public String toString()
    {
        return "Payments{" +
                "payment_id=" + paymentId +
                ", finance_id=" + financeId +
                ", date_of_payment=" + dateOfPayment +
                ", amount=" + amount +
                '}';
    }
}
