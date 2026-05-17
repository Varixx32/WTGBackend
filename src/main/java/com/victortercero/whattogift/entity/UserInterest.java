package com.victortercero.whattogift.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_interests")
public class UserInterest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id", nullable = false)
    private WishList wishList;

    @Column(nullable = false, length = 100)
    private String keyword;
}