package org.ldv.sahazawear.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Utilisateur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    @Column(nullable = false)
    var nom: String,

    @Column(nullable = false, unique = true)
    var email: String,

    @Column(nullable = false)
    var mdp: String,

    @Column(nullable = false)
    var dateCreation: LocalDate,

    @Column(nullable = false)
    var dateModification: LocalDate,

    // Relation avec Role
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    var role: Role,

    // Relation avec Panier
    @OneToOne(mappedBy = "utilisateur", cascade = [CascadeType.ALL])
    var panier: Panier? = null,

    // ========== NOUVELLES RELATIONS ==========
    @OneToMany(mappedBy = "utilisateur", cascade = [CascadeType.ALL])
    var commandes: MutableList<Commande> = mutableListOf(),

    @OneToMany(mappedBy = "utilisateur", cascade = [CascadeType.ALL])
    var avis: MutableList<Avis> = mutableListOf()
    // =========================================
)