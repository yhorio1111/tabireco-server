package com.yhorio.tabireco.domain.entity

import com.yhorio.tabireco.domain.type.TravelEventType
import com.yhorio.tabireco.domain.vo.id.TravelEventId
import com.yhorio.tabireco.domain.vo.id.ULID
import com.yhorio.tabireco.domain.vo.id.ulid
import java.time.LocalDateTime


data class TravelEvent(
    override val id: TravelEventId,
    val travelEventType: TravelEventType,
    val eventTime: LocalDateTime,
    val details: String,
) : Entity<ULID> {
    companion object {
        fun of(travelEventType: TravelEventType, eventTime: LocalDateTime, details: String): TravelEvent {
            return TravelEvent(
                id = TravelEventId(ulid()),
                travelEventType = travelEventType,
                eventTime = eventTime,
                details = details
            )
        }
    }
    override fun isValid(): Boolean {
        return id.value.length == 26
    }
}
