package com.PiotrKlukowski.Cinema.model;

import com.PiotrKlukowski.Cinema.typeList.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seat")
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

    @ManyToOne
    @JoinColumn(name = "room_id")
    @Getter
    private Room room;
}
