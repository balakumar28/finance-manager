package com.smfinance.datamodel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smfinance.datamodel.objects.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, String>
{
}
