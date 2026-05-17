package com.victortercero.whattogift.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "wish_lists")
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User owner;

    @Column(name = "share_code", nullable = false, unique = true, length = 12)
    private String shareCode;

    @Column(name = "target_size", nullable = false)
    private Integer targetSize = 10;

    @OneToMany(mappedBy = "wishList", cascade = CascadeType.ALL)
    private List<UserInterest> interests;

    @OneToMany(mappedBy = "wishList", cascade = CascadeType.ALL)
    private List<GiftItem> items;
}