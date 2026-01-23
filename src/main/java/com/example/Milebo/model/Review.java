package com.example.Milebo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "bill_id"),
            @JoinColumn(name = "product_id")
    })
    private BillDetails billDetails;

    private Integer rating;
    private String comment;
    private String status;
}

