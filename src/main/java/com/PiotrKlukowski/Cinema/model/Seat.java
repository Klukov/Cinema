package com.PiotrKlukowski.Cinema.model;

import com.PiotrKlukowski.Cinema.typeList.SeatType;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "seat",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"row_number", "column_number", "room_id"})})
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    @Getter
    private Room room;
}
