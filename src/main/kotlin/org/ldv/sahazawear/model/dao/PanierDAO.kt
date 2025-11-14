package org.ldv.sahazawear.model.dao

import org.ldv.sahazawear.model.entity.Panier
import org.springframework.data.jpa.repository.JpaRepository

interface PanierDAO : JpaRepository<Panier, Long> {
}