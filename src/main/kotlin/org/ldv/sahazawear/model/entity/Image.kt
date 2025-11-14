package org.ldv.sahazawear.model.entity

import jakarta.persistence.*

@Entity
class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    @Column(nullable = false)
    var chemin: String,

    @Column(nullable = false)
    var estPrincipale: Boolean
)