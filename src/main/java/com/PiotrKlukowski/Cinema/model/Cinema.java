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
@Table(name = "cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "name")
    @NotEmpty
    @Getter
    @Setter
    private String name;

    @Column(name = "city")
    @NotEmpty
    @Getter
    @Setter
    private String city;

    @Column(name = "postal_code")
    @NotEmpty
    @Getter
    @Setter
    private String postalCode;

    @Column(name = "address")
    @NotEmpty
    @Getter
    @Setter
    private String address;

    @Column(name="phone_number")
    @NotEmpty
    @Getter
    @Setter
    private String phoneNumber;

    @Column(name="email")
    @NotEmpty
    @Getter
    @Setter
    private String email;

    @Column(name="time_zone")
    @NotEmpty
    @Getter
    @Setter
    private String timeZoneName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cinema", fetch = FetchType.EAGER)
    @Getter
    private Set<Room> cinemaRooms;
}
