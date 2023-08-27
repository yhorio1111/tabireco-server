package com.yhorio.tabireco.domain.entity

import com.yhorio.tabireco.domain.type.TravelEventType
import com.yhorio.tabireco.domain.vo.id.TravelEventId
import de.huxhorn.sulky.ulid.ULID
import java.time.LocalDateTime


data class TravelEvent(
    override val id: TravelEventId,
    val travelEventType: TravelEventType,
    val eventTime: LocalDateTime,
    val details: String,
) : Entity<ULID> {
    fun of(travelEventType: TravelEventType, eventTime: LocalDateTime, details: String): TravelEvent {
        val ulid = ULID()
        return TravelEvent(
            id = TravelEventId(ulid),
            travelEventType = travelEventType,
            eventTime = eventTime,
            details = details
        )
    }
    override fun isValid(): Boolean {
        return id.value.toString().length == 26
    }
}
