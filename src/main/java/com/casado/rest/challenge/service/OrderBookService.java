package com.casado.rest.challenge.service;

import com.casado.rest.challenge.dao.FinancialInstrumentDao;
import com.casado.rest.challenge.dao.OrderBookDao;
import com.casado.rest.challenge.entity.FinancialInstrument;
import com.casado.rest.challenge.entity.OrderBook;
import com.casado.rest.challenge.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderBookService {

    @Autowired
    OrderBookDao orderBookDao;

    @Autowired
    FinancialInstrumentDao financiaInstrumentDao;

    public List<OrderBook> getAllBooks() {
        return orderBookDao.findAll();
    }


    public Optional<OrderBook> getBookById(Long orderBookId) {
        if (!orderBookDao.existsById(orderBookId)) {
            throw new ResourceNotFoundException("OrderBook with id " + orderBookId + " not found");
        }
        return orderBookDao.findById(orderBookId);
    }


    public OrderBook createBook(Long fiId, OrderBook orderBook) {
        Set<OrderBook> orderBooks = new HashSet<>();
        FinancialInstrument fi1 = new FinancialInstrument();

        Optional<FinancialInstrument> byId = financiaInstrumentDao.findById(fiId);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("FinancialInstrument with id " + fiId + " does not exist");
        }
        FinancialInstrument fi = byId.get();

        //OrderBooktie FinancialInstrument to OrderBook
        orderBook.setFI(fi);

        OrderBook orderBook1 = orderBookDao.save(orderBook);
        //tie OrderBook to FinancialInstrument
        orderBooks.add(orderBook1);
        fi1.setOrderBooks(orderBooks);

        return orderBook1;

    }

    public OrderBook updateBookById(Long orderBookId, OrderBook orderBookRequest) {
        if (!orderBookDao.existsById(orderBookId)) {
            throw new ResourceNotFoundException("OrderBook with id " + orderBookId + " not found");
        }
        Optional<OrderBook> orderBook = orderBookDao.findById(orderBookId);

        if (!orderBook.isPresent()) {
            throw new ResourceNotFoundException("OrderBook with id " + orderBookId + " not found");
        }

        OrderBook orderBook1 = orderBook.get();
        orderBook1.setDescription(orderBookRequest.getDescription());
        orderBook1.setTitle(orderBookRequest.getTitle());

        return orderBookDao.save(orderBook1);
    }

    public ResponseEntity<Object> deleteBookById(long orderBookId) {
        if (!orderBookDao.existsById(orderBookId)) {
            throw new ResourceNotFoundException("OrderBook with id " + orderBookId + " not found");
        }

        orderBookDao.deleteById(orderBookId);

        return ResponseEntity.ok().build();

    }
}
