package org.ldv.sahazawear.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Avis(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    @Column(nullable = false, length = 1000)
    var commentaire: String,

    @Column(nullable = false)
    var note: Int,

    @Column(nullable = false)
    var dateCreation: LocalDate,

    @Column(nullable = false)
    var dateModification: LocalDate,

    // Relation avec Produit
    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    var produit: Produit,

    // ========== NOUVELLE RELATION ==========
    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    var utilisateur: Utilisateur
    // =======================================
)