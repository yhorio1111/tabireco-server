package com.yhorio.tabireco.domain.entity

import com.yhorio.tabireco.domain.vo.code.JpPrefectureCode
import com.yhorio.tabireco.domain.vo.id.TravelEventId
import com.yhorio.tabireco.domain.vo.id.TravelOverviewId
import com.yhorio.tabireco.domain.vo.id.ULID
import com.yhorio.tabireco.domain.vo.id.ulid


data class TravelOverview(
    override val id: TravelOverviewId,
    val travelEventIds: List<TravelEventId>,
    val destination: String,
    val prefectures: List<JpPrefectureCode>,
) : Entity<ULID> {
    companion object {
        fun of(
            travelEventIds: List<TravelEventId>,
            destination: String,
            prefectures: List<JpPrefectureCode>
        ): TravelOverview {
            return TravelOverview(
                TravelOverviewId(ulid()),
                travelEventIds,
                destination,
                prefectures
            )
        }
    }
    override fun isValid(): Boolean {
        return id.value.length == 26
    }
}
