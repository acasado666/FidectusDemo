package com.casado.rest.challenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "order_book")
public class OrderBook implements Serializable {

    @Column(name = "id", nullable = false, length = 10)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotBlank(message = "Enter a title of the Order Book ")
    private String titleBook;

    @Column(name = "description")
    @NotBlank(message = "Enter a description ")
    private String descriptionBook;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", updatable=false, nullable = false, insertable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private FinancialInstrument fi;


    public OrderBook() {
    }

    public OrderBook(@NotBlank(message = "Enter a title of the Order Book ") String titleBook,
                     @NotBlank(message = "Enter a description ") String descriptionBook,
                     FinancialInstrument fi) {
        this.titleBook = titleBook;
        this.descriptionBook = descriptionBook;
        this.fi = fi;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return descriptionBook;
    }

    public void setDescription(String descriptionBook) {
        this.descriptionBook = descriptionBook;
    }

    //getter Method to get the FI's  name
    @JsonIgnore
    public void setFI(FinancialInstrument fi) {
        this.fi = fi;
    }
    
    @JsonIgnore
    public void getFI(FinancialInstrument fi) {
        this.fi = fi;
    }

    public String getTitle() {
        return titleBook;
    }

    public void setTitle(String titleBook) {
        this.titleBook = titleBook;
    }

    public void save(OrderBook orderBook) {
    }
}