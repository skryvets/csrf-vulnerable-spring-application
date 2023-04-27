package com.example.csrfvulnerablespringapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferModel {
    private String amount;
    private String to;
    private String note;
}
