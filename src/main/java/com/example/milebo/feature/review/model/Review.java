package com.example.milebo.feature.review.model;

import com.example.milebo.feature.order.model.OrderDetail;
import com.example.milebo.feature.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "Review",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"user_id", "order_id", "product_id"}
        )
)
public class Review {

    @Id
    @Column(length = 10)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "order_id", referencedColumnName = "order_id"),
            @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    })
    private OrderDetail orderDetail;

    private Integer rating;

    @Column(length = 300)
    private String comment;

    private LocalDateTime createdDate;

    @Column(length = 20)
    private String status;
}


