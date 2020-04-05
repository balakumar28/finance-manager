package com.smfinance.datamodel.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user_finance_extras")
@PrimaryKeyJoinColumn
public class UserFinance extends UserFinanceBase  implements Serializable
{
    @JoinColumn(referencedColumnName = "userId")
    private User guarantor;
    private byte[] supportDocument;
    @OneToMany(mappedBy = "paymentId", cascade = CascadeType.ALL)
    private List<Payments> payments = new ArrayList<>();
    
    public User getGuarantor()
    {
        return guarantor;
    }
    
    public void setGuarantor(User guarantor)
    {
        this.guarantor = guarantor;
    }
    
    public byte[] getSupportDocument()
    {
        return supportDocument;
    }

    public void setSupportDocument(byte[] supportDocument)
    {
        this.supportDocument = supportDocument;
    }
    
    public List<Payments> getPayments()
    {
        return payments;
    }
    
    public void setPayments(List<Payments> payments)
    {
        this.payments = payments;
    }
    
    @Override
    public String toString()
    {
        return "UserFinances{" +
                "finance_id=" + financeId +
                ", guarantor=" + guarantor +
                ", support_document=" + Arrays.toString(supportDocument) +
                ", userId=" + userId +
                ", principal=" + principal +
                ", interest_rate=" + interestRate +
                ", term=" + term +
                ", date_of_commencement=" + dateOfCommencement +
                ", date_of_dispursement=" + dateOfDisbursement +
                ", instalment_amount=" + instalmentAmount +
                ", remaining_principal=" + remainingPrincipal +
                '}';
    }
}
