package org.ldv.sahazawear.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Produit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    @Column(nullable = false)
    var nom: String,

    @Column(nullable = false, length = 1000)
    var description: String,

    @Column(nullable = false)
    var prix: Double,

    @Column(nullable = false)
    var categorie: String,

    @Column(nullable = false)
    var dateCreation: LocalDate,

    @Column(nullable = false)
    var dateModification: LocalDate,

    // ========== NOUVELLES RELATIONS ==========
    @OneToMany(mappedBy = "produit", cascade = [CascadeType.ALL], orphanRemoval = true)
    var variantes: MutableList<Variante> = mutableListOf(),

    @OneToMany(mappedBy = "produit", cascade = [CascadeType.ALL], orphanRemoval = true)
    var images: MutableList<Image> = mutableListOf(),

    @OneToMany(mappedBy = "produit", cascade = [CascadeType.ALL], orphanRemoval = true)
    var avis: MutableList<Avis> = mutableListOf()
    // =========================================
)