package com.example.csrfvulnerablespringapplication.controller;

import com.example.csrfvulnerablespringapplication.model.Transaction;
import com.example.csrfvulnerablespringapplication.model.TransferModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class BankController {

    Long totalAmount = 1000L;
    //create mutable list in one line
    List<Transaction> transactions = new ArrayList<>(Arrays.asList(new Transaction("Buddy", "100", "Dining out")));

    @GetMapping(path = {"/", "/home", "/transfer"})
    public String home(Model model) {
        model.addAttribute("totalAmount", totalAmount);
        model.addAttribute("recentTransactions", transactions);
        return "home.html";
    }

    @PostMapping("/transfer")
    public String transfer(@ModelAttribute("transfer") TransferModel transferModel, Model model) {
        int amount = Integer.parseInt(transferModel.getAmount().replaceAll("\\D+",""));
        log.info("Transfering {} to {}. Note: {}", transferModel.getAmount(), transferModel.getTo(), transferModel.getNote());
        transactions.add(new Transaction(transferModel.getTo(), transferModel.getAmount(), transferModel.getNote()));
        totalAmount = totalAmount - amount;
        model.addAttribute("balance", totalAmount);
        model.addAttribute("recentTransactions", transactions);
        return "success.html";
    }
}
