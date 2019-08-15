package com.casado.rest.challenge.entity;

import com.casado.rest.challenge.exception.Validator.Market;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fi")
public class FinancialInstrument implements Serializable {

    @Column(name = "id", nullable = false, length = 10)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fi_name")
    @NotBlank(message = "Enter the FI's name")
    public String fiName;

    @Column(name = "fi_description")
    @NotBlank(message = "Enter the FI's description")
    public String fiDescription;

    @Market
    @NotEmpty(message = "Please provide a market name")
    @Column(name = "market")
    private String market;

    @OneToMany(mappedBy = "fi", fetch = FetchType.LAZY)
    private Set<OrderBook> orderBooks = new HashSet<>();

    public FinancialInstrument() {
    }

    public FinancialInstrument(@NotBlank(message = "Enter the Financial Instrument's name") String fiName,
                               @NotBlank(message = "Enter the Financial Instrument's description") String fiDescription) {
        this.fiName = fiName;
        this.fiDescription = fiDescription;
    }

    public FinancialInstrument(Long id,
                               @NotBlank(message = "Enter the Financial Instrument's name") String fiName,
                               @NotBlank(message = "Enter the Financial Instrument's description") String fiDescription) {
        this.fiName = fiName;
        this.fiDescription = fiDescription;
        this.id = id;
    }

    public FinancialInstrument(@NotBlank(message = "Enter the Financial Instrument's name") String fiName,
                               @NotBlank(message = "Enter the Financial Instrument's description") String fiDescription,
                               @NotBlank(message = "Enter the Market target") String market) {
        this.fiName = fiName;
        this.fiDescription = fiDescription;
        this.market = market;
    }

    public FinancialInstrument(Long id,
                               @NotBlank(message = "Enter the Financial Instrument's name") String fiName,
                               @NotBlank(message = "Enter the Financial Instrument's description") String fiDescription,
                               @NotBlank(message = "Enter the Market target") String market) {
        this.fiName = fiName;
        this.fiDescription = fiDescription;
        this.id = id;
        this.market = market;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFiName() {
        return fiName;
    }

    public void setFiName(String fiName) {
        this.fiName = fiName;
    }

    public String getFiDescription() {
        return fiDescription;
    }

    public void setFiDescription(String fiDescription) {
        this.fiDescription = fiDescription;
    }

    public Set<OrderBook> getOrderBooks() {
        return orderBooks;
    }

    public void setOrderBooks(Set<OrderBook> orderBooks) {
        this.orderBooks = orderBooks;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }
}
