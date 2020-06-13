package com.PiotrKlukowski.Cinema.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "buyer")
public class Buyer {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Getter
    private String id;

    @Column(name = "first_name")
    @NotEmpty
    @Getter
    @Setter
    private String firstName;

    @Column(name = "second_name")
    @Getter
    @Setter
    private String secondName;

    @Column(name = "last_name")
    @NotEmpty
    @Getter
    @Setter
    private String lastName;

    @Column(name = "email")
    @Getter
    @Setter
    private String email;

    @Column(name = "phone_number")
    @Getter
    @Setter
    private String phoneNumber;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY)
    @Getter
    private Set<Reservation> reservations = new HashSet<>();
}
