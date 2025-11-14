package org.ldv.sahazawear.model.dao

import org.ldv.sahazawear.model.entity.Commande
import org.springframework.data.jpa.repository.JpaRepository

interface CommandeDAO : JpaRepository<Commande, Long> {
}