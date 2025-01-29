
package com.example.finance_tracker.repository;

import com.example.finance_tracker.model.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceRepository extends JpaRepository<Finance, Long> {
}
