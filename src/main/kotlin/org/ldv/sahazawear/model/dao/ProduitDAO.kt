package org.ldv.sahazawear.model.dao

import org.ldv.sahazawear.model.entity.Produit
import org.springframework.data.jpa.repository.JpaRepository

interface ProduitDAO : JpaRepository<Produit, Long> {
}