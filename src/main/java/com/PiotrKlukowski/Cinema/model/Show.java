package com.PiotrKlukowski.Cinema.model;

import com.PiotrKlukowski.Cinema.typeList.AudioType;
import com.PiotrKlukowski.Cinema.typeList.Language;
import com.PiotrKlukowski.Cinema.typeList.SeatType;
import com.PiotrKlukowski.Cinema.typeList.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "show", indexes = {@Index(columnList = "room_id"), @Index(columnList = "start_time")})
public class Show {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Getter
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    @Getter
    @Setter
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    @Getter
    @Setter
    private Movie movie;

    @Column(name = "start_time", nullable = false)
    @Getter
    @Setter
    private LocalDateTime startTime;

    @Column(name = "audio_language")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Language audioLanguage;

    @Column(name = "audio_type")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private AudioType audioType;

    @Column(name = "subtitles_language")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Language subtitlesLanguage;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "show", fetch = FetchType.LAZY)
    @Getter
    private Set<Ticket> tickets = new HashSet<>();

    @PrePersist
    private void prePersist() {
       //createTicketsForShow();
    }

    private void createTicketsForShow() {
        Set<Ticket> newTickets = new HashSet<>();
        this.room.getSeats().forEach(seat -> {
            if (!seat.getSeatType().equals(SeatType.NOT_EXIST)) {
                newTickets.add(Ticket.builder()
                        .show(this)
                        .column(seat.getColumn())
                        .row(seat.getRow())
                        .seatType(seat.getSeatType())
                        .ticketStatus(TicketStatus.FREE)
                        .build());
            }
        });
        this.tickets = newTickets;
    }
}
