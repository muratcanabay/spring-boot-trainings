package com.muratcanabay.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "orders")
@Builder
@EqualsAndHashCode(of = {"id"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Order implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_order", allocationSize = 1)
    @GeneratedValue(generator = "seq_order", strategy = GenerationType.SEQUENCE)
    private Long id;

    @CreatedDate
    private Date createdAt;

    @Column(name = "user_order")
    private String order;

    @ManyToOne
    @JoinColumn(name = "user_order_id")
    private User user;

}
