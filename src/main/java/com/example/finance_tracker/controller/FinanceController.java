package com.example.finance_tracker.controller;

import com.example.finance_tracker.model.FinanceRecord;
import com.example.finance_tracker.repository.FinanceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class FinanceController {

    @Autowired
    private FinanceRecordRepository repository;

    // View the finance records
    @GetMapping
    public String viewFinance(Model model) {
        List<FinanceRecord> records = repository.findAll();
        model.addAttribute("records", records);
        return "index";
    }

    // Show form to add new record
    @GetMapping("/add")
    public String addFinanceForm(Model model) {
        model.addAttribute("financeRecord", new FinanceRecord());
        return "add";
    }

    // Add new record
    @PostMapping("/add")
    public String saveFinance(@ModelAttribute FinanceRecord financeRecord) {
        repository.save(financeRecord);
        return "redirect:/";
    }

    // Show form to edit a record
    @GetMapping("/edit/{id}")
    public String editFinanceForm(@PathVariable("id") Long id, Model model) {
        FinanceRecord record = repository.findById(id).orElseThrow();
        model.addAttribute("financeRecord", record);
        return "edit";
    }

    // Update a record
    @PostMapping("/edit/{id}")
    public String updateFinance(@PathVariable("id") Long id, @ModelAttribute FinanceRecord financeRecord) {
        // Set the id explicitly because it will be updated
        financeRecord.setId(id);  // Ensures that the correct record is updated
        repository.save(financeRecord);  // Save the updated record to the database
        return "redirect:/";
    }

    // Delete a record
    @GetMapping("/delete/{id}")
    public String deleteFinance(@PathVariable("id") Long id) {
        repository.deleteById(id);  // Delete the record from the database
        return "redirect:/";
    }
}
