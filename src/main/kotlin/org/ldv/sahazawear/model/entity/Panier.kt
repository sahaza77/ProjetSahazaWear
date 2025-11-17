package org.ldv.sahazawear.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Panier(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    @Column(nullable = false)
    var dateCreation: LocalDate,

    @Column(nullable = false)
    var dateModification: LocalDate,

    // Relation avec Utilisateur
    @OneToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    var utilisateur: Utilisateur,

    // ========== NOUVELLE RELATION ==========
    @OneToMany(mappedBy = "panier", cascade = [CascadeType.ALL], orphanRemoval = true)
    var lignes: MutableList<LignePanier> = mutableListOf()
    // =======================================
)