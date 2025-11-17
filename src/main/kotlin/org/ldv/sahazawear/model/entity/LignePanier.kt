package org.ldv.sahazawear.model.entity

import jakarta.persistence.*

@Entity
class LignePanier(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    @Column(nullable = false)
    var quantite: Int,

    // ========== NOUVELLES RELATIONS ==========
    @ManyToOne
    @JoinColumn(name = "panier_id", nullable = false)
    var panier: Panier,

    @ManyToOne
    @JoinColumn(name = "variante_id", nullable = false)
    var variante: Variante
    // =========================================
)