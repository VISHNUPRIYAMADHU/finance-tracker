
package com.example.finance_tracker.service;

import com.example.finance_tracker.model.Finance;
import com.example.finance_tracker.repository.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinanceService {

    @Autowired
    private FinanceRepository financeRepository;

    public List<Finance> getAllFinances() {
        return financeRepository.findAll();
    }

    public Optional<Finance> getFinanceById(Long id) {
        return financeRepository.findById(id);
    }

    public Finance saveFinance(Finance finance) {
        return financeRepository.save(finance);
    }

    public void deleteFinance(Long id) {
        financeRepository.deleteById(id);
    }
}

