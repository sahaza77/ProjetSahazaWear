package org.ldv.sahazawear.model.entity

import jakarta.persistence.*

@Entity
class Variante(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    @Column(nullable = false)
    var stock: Int
)