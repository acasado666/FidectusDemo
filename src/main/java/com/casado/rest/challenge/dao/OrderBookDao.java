package com.casado.rest.challenge.dao;
;
import com.casado.rest.challenge.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBookDao extends JpaRepository<OrderBook, Long> {

}
