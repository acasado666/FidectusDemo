package com.casado.rest.challenge.dao;

import com.casado.rest.challenge.entity.FinancialInstrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialInstrumentDao extends JpaRepository<FinancialInstrument, Long> {

}
