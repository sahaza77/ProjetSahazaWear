package org.ldv.sahazawear.model.dao

import org.ldv.sahazawear.model.entity.Image
import org.springframework.data.jpa.repository.JpaRepository

interface ImageDAO : JpaRepository<Image, Long> {
}