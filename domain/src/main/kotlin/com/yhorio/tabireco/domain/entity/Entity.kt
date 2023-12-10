package com.yhorio.tabireco.domain.entity

import com.yhorio.tabireco.domain.vo.id.EntityId

interface Entity<T> {
    val id: EntityId<T>

    fun isValid(): Boolean
}
