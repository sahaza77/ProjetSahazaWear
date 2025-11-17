package org.ldv.sahazawear.model.entity

import jakarta.persistence.*

@Entity
class LigneCommande(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    @Column(nullable = false)
    var quantite: Int,

    // ========== NOUVELLES RELATIONS ==========
    @ManyToOne
    @JoinColumn(name = "commande_id", nullable = false)
    var commande: Commande,

    @ManyToOne
    @JoinColumn(name = "variante_id", nullable = false)
    var variante: Variante
    // =========================================
)