package org.ldv.sahazawear.model.entity

import jakarta.persistence.*

@Entity
class Couleur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    @Column(nullable = false)
    var nom: String,

    @Column(nullable = false, unique = true)
    var codeHexadecimal: String
)
