package com.smfinance.datamodel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smfinance.datamodel.objects.UserFinance;

public interface UserFinanceRepository extends JpaRepository<UserFinance, String>
{
}
