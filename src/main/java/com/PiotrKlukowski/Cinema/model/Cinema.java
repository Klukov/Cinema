package com.PiotrKlukowski.Cinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String name;

    @Column(name = "city", nullable = false)
    @Getter
    @Setter
    private String city;

    @Column(name = "postal_code", nullable = false)
    @Getter
    @Setter
    private String postalCode;

    @Column(name = "address", nullable = false)
    @Getter
    @Setter
    private String address;

    @Column(name="phone_number", nullable = false)
    @Getter
    @Setter
    private String phoneNumber;

    @Column(name="email", nullable = false)
    @Getter
    @Setter
    private String email;

    @Column(name="time_zone", nullable = false)
    @Getter
    @Setter
    private String timeZoneName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cinema", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @Getter
    @Setter
    private Set<Room> cinemaRooms = new HashSet<>();
}
