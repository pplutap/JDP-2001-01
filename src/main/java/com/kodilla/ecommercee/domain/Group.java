package com.kodilla.ecommercee.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "products_groups")
@Data
@NoArgsConstructor
public class Group {

    public Group(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "group_id")
    private Long id;

    @Column(name = "group_name")
    private String name;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            fetch = FetchType.LAZY
    )
    private List<Product> products;
}
