package org.ldv.sahazawear.model.dao

import org.ldv.sahazawear.model.entity.LignePanier
import org.springframework.data.jpa.repository.JpaRepository

interface LignePanierDAO : JpaRepository<LignePanier, Long> {
}