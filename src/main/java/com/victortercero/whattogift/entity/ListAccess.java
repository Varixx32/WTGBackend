package com.victortercero.whattogift.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "list_access")
public class ListAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "list_id" , nullable = false)
    private WishList wishList;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "accessor_user_id" , nullable = false)
    private User accessor;

    @Column(name = "accessed_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime accessedAt;
}
