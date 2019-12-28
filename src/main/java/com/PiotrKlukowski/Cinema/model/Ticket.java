package com.PiotrKlukowski.Cinema.model;

import com.PiotrKlukowski.Cinema.typeList.SeatType;
import com.PiotrKlukowski.Cinema.typeList.TicketStatus;
import com.PiotrKlukowski.Cinema.typeList.TicketType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Getter
    private String id;

    @Column(name = "row_number")
    @Getter
    @Setter
    private Integer row;

    @Column(name = "column_number")
    @Getter
    @Setter
    private Integer column;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name = "show_id")
    @Getter
    @Setter
    private Show show;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private TicketStatus ticketStatus;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    @Getter
    @Setter
    private Reservation reservation;
}
