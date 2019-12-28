package com.PiotrKlukowski.Cinema.model.Admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "permissions")
public class Permission {

    @Id
    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "description")
    @NotEmpty
    @Getter
    @Setter
    private String description;
}
