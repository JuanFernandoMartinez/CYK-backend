package com.cyk.algorithm.controller;

import com.cyk.algorithm.DTO.CaseDTO;
import com.cyk.algorithm.DTO.StatusDTO;
import com.cyk.algorithm.service.CYKService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CYKController {
    private CYKService service;

    @CrossOrigin(origins = "*")
    @PostMapping
    public StatusDTO TestString(@RequestBody CaseDTO caseDTO) {

        return new StatusDTO(service.solve(caseDTO));
    }
}
