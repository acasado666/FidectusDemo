package com.casado.rest.challenge.service;

import com.casado.rest.challenge.dao.FinancialInstrumentDao;
import com.casado.rest.challenge.entity.FinancialInstrument;
import com.casado.rest.challenge.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinancialInstrumentService {

    @Autowired
    FinancialInstrumentDao financialInstrumentDao;

    public List<FinancialInstrument> getFinancialInstruments() {
        return financialInstrumentDao.findAll();
    }


    public Optional<FinancialInstrument> getFinancialInstrumentById(Long financialInstrumentId) {
        boolean b = financialInstrumentDao.existsById(financialInstrumentId);
        if (!b) {
            throw new ResourceNotFoundException("FinancialInstrument with id " + financialInstrumentId + " not found");
        }
        return financialInstrumentDao.findById(financialInstrumentId);
    }
    public FinancialInstrument getFinancialInstrument(Long financialInstrumentId) {
        if (!financialInstrumentDao.existsById(financialInstrumentId)) {
            throw new ResourceNotFoundException("FinancialInstrument with id " + financialInstrumentId + " not found");
        }
        return new FinancialInstrument("as","as");
    }

    public FinancialInstrument createFinancialInstrument(FinancialInstrument financialInstrument) {
        return financialInstrumentDao.save(financialInstrument);

    }

    public FinancialInstrument updateFinancialInstrumentById(Long financialInstrumentId, FinancialInstrument financialInstrumentRequest) {
        if (!financialInstrumentDao.existsById(financialInstrumentId)) {
            throw new ResourceNotFoundException("FinancialInstrument with id " + financialInstrumentId + " not found");
        }
        Optional<FinancialInstrument> financialInstrument = financialInstrumentDao.findById(financialInstrumentId);

        if (!financialInstrument.isPresent()) {
            throw new ResourceNotFoundException("FinancialInstrument with id " + financialInstrumentId + " not found");
        }

        FinancialInstrument financialInstrument1 = financialInstrument.get();
        financialInstrument1.setFiName(financialInstrumentRequest.getFiName());
        financialInstrument1.setFiDescription(financialInstrumentRequest.getFiDescription());
        return financialInstrumentDao.save(financialInstrument1);

    }

    public ResponseEntity<Object> deleteFinancialInstrumentById(long financialInstrumentId) {
        if (!financialInstrumentDao.existsById(financialInstrumentId)) {
            throw new ResourceNotFoundException("FinancialInstrument with id " + financialInstrumentId + " not found");
        }

        financialInstrumentDao.deleteById(financialInstrumentId);

        return ResponseEntity.ok().build();

    }


}
