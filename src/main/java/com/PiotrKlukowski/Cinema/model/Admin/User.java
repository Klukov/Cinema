package com.PiotrKlukowski.Cinema.model.Admin;

import com.PiotrKlukowski.Cinema.model.Buyer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User extends Buyer {

    @Column(name = "name")
    @NotEmpty
    @Getter
    @Setter
    private String userName;

    @Column(name = "passwordHash")
    @NotEmpty
    @Getter
    @Setter
    private String passwordHash;
}
