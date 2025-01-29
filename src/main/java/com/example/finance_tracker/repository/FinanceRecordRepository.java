
package com.example.finance_tracker.repository;

import com.example.finance_tracker.model.FinanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceRecordRepository extends JpaRepository<FinanceRecord, Long> {
}
