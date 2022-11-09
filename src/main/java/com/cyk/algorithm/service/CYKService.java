package com.cyk.algorithm.service;

import com.cyk.algorithm.DTO.CaseDTO;
import com.cyk.algorithm.model.CYK;
import com.cyk.algorithm.util.CYKParser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CYKService {
    public boolean solve(CaseDTO caseDto) {
        CYK cyk = new CYK(new CYKParser().grammarParser(caseDto.getGrammar()),caseDto.getText());
        String answer = cyk.fillMatrixAndAnswer();
        return answer.equals("Generates");
    }
}
