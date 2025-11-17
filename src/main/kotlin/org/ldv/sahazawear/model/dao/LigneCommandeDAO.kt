package org.ldv.sahazawear.model.dao

import org.ldv.sahazawear.model.entity.LigneCommande
import org.springframework.data.jpa.repository.JpaRepository

interface LigneCommandeDAO : JpaRepository<LigneCommande, Long> {
}