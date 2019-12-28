package com.PiotrKlukowski.Cinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "id")
    @NotEmpty
    @Getter
    private Integer integer;

    @Column(name = "room_in_cinema_number")
    @NotEmpty
    @Getter
    @Setter
    private String roomInCinemaNumber;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    @Getter
    @Setter
    private Cinema cinema;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room", fetch = FetchType.EAGER)
    @Getter
    private Set<Seat> seats;
}
