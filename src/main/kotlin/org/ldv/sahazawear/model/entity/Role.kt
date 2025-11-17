package org.ldv.sahazawear.model.entity

import jakarta.persistence.*

@Entity
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    @Column(nullable = false, unique = true)
    var nom: String,

    // ========== RELATION INVERSE (optionnelle) ==========
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    var utilisateurs: MutableList<Utilisateur> = mutableListOf()
    // ====================================================
)