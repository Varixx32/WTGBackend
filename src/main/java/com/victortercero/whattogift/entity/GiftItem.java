package com.victortercero.whattogift.entity;

import com.victortercero.whattogift.entity.enums.ItemStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "gift_items")
public class GiftItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name= "list_id", nullable = false)
    private WishList wishList;

    @Column(nullable = false)
    private String name;

    @Column(name= "product_url", length = 1000)
    private String productUrl;

    @Column (name= "image_url", length = 1000)
    private String imageUrl;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column
    private ItemStatus itemStatus;

    @ManyToOne
    @JoinColumn(name = "reserved_by_user_id")
    private User reservedBy;

    @Column
    private LocalDateTime reservedAt;
    @Column
    private LocalDateTime purchasedAt;

}