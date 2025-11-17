package org.ldv.sahazawear.model.entity

import jakarta.persistence.*

@Entity
class Variante(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    @Column(nullable = false)
    var stock: Int,

    // Relations principales
    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    var produit: Produit,

    @ManyToOne
    @JoinColumn(name = "taille_id", nullable = false)
    var taille: Taille,

    @ManyToOne
    @JoinColumn(name = "couleur_id", nullable = false)
    var couleur: Couleur,

    // Relations inverses
    @OneToMany(mappedBy = "variante", fetch = FetchType.LAZY)
    var lignesPanier: MutableList<LignePanier> = mutableListOf(),

    // ========== NOUVELLE RELATION ==========
    @OneToMany(mappedBy = "variante", fetch = FetchType.LAZY)
    var lignesCommande: MutableList<LigneCommande> = mutableListOf()
    // =======================================
)