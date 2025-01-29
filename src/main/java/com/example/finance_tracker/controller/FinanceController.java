
package com.example.finance_tracker.controller;

import com.example.finance_tracker.model.Finance;
import com.example.finance_tracker.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/finances")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @GetMapping
    public List<Finance> getAllFinances() {
        return financeService.getAllFinances();
    }

    @GetMapping("/{id}")
    public Optional<Finance> getFinanceById(@PathVariable Long id) {
        return financeService.getFinanceById(id);
    }

    @PostMapping
    public Finance addFinance(@RequestBody Finance finance) {
        return financeService.saveFinance(finance);
    }

    @PutMapping("/{id}")
    public Finance updateFinance(@PathVariable Long id, @RequestBody Finance finance) {
        Optional<Finance> existingFinance = financeService.getFinanceById(id);
        if (existingFinance.isPresent()) {
            Finance financeToUpdate = existingFinance.get();
            financeToUpdate.setCategory(finance.getCategory());
            financeToUpdate.setAmount(finance.getAmount());
            return financeService.saveFinance(financeToUpdate); // Save the updated finance record
        }
        return null; // Return null if the record wasn't found
    }

    @DeleteMapping("/{id}")
    public void deleteFinance(@PathVariable Long id) {
        financeService.deleteFinance(id);
    }
}
