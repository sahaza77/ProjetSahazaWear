package org.ldv.sahazawear.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Commande(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    @Column(nullable = false)
    var dateCommande: LocalDate,

    @Column(nullable = false)
    var dateCreation: LocalDate,

    @Column(nullable = false)
    var dateModification: LocalDate,

    @Column(nullable = false)
    var montantTotal: Double,

    @Column(nullable = false)
    var statut: String,

    // ========== NOUVELLES RELATIONS ==========
    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    var utilisateur: Utilisateur,

    @OneToMany(mappedBy = "commande", cascade = [CascadeType.ALL], orphanRemoval = true)
    var lignes: MutableList<LigneCommande> = mutableListOf()
    // =========================================
)