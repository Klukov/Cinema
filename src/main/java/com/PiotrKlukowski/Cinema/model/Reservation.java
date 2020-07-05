package com.PiotrKlukowski.Cinema.model;

import com.PiotrKlukowski.Cinema.exception.ReservationIncorrectnessException;
import com.PiotrKlukowski.Cinema.typeList.Currency;
import com.PiotrKlukowski.Cinema.typeList.Discount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Getter
    private String id;

    @CreationTimestamp
    @Getter
    private ZonedDateTime creationTime;

    @UpdateTimestamp
    @Getter
    private ZonedDateTime lastUpdateTime;

    @Column(name = "final_price")
    @NotEmpty
    @Getter
    private BigDecimal finalPrice;

    @Column(name = "final_price_currency")
    @Enumerated(EnumType.STRING)
    @NotEmpty
    @Getter
    @Setter
    private Currency finalPriceCurrency;

    @Column(name = "discount")
    @Getter
    @Setter
    private String discountCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    @Getter
    @Setter
    private Buyer buyer;

    @OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY)
    @Getter
    @Setter
    private Set<Ticket> tickets = new HashSet<>();

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    @PrePersist
    private void prePersistFunction() {
        this.finalPrice = calculateFinalPrice();
    }

    @PreUpdate
    private void preUpdateFunction() {
        this.finalPrice = calculateFinalPrice();
    }

    private BigDecimal calculateFinalPrice() {
        if (this.finalPriceCurrency == null) {
            throw new ReservationIncorrectnessException("Lack of currency, cannot calculate final price");
        }
        BigDecimal price = new BigDecimal("0.0");
        for (Ticket ticket : tickets) {
            price = price.add(ticket.getTicketType().getPriceByCurrency(this.finalPriceCurrency));
        }
        return this.discountCode != null ?
                price.multiply(Discount.getDiscountFromCode(this.discountCode).getDiscountFactor()) : price;
    }
}
