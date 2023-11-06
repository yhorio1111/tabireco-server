package com.yhorio.tabireco.domain.entity

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.yhorio.tabireco.domain.vo.code.JpPrefectureCode
import com.yhorio.tabireco.domain.vo.id.TravelEventId
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class TravelOverviewTest {
    @ParameterizedTest
    @ArgumentsSource(TravelOverviewTestCase::class)
    fun isValid(
        travelEventIds: List<TravelEventId>,
        destination: String,
        prefectures: List<JpPrefectureCode>
    ) {
        val travelOverview = TravelOverview.of(
            travelEventIds,
            destination,
            prefectures
        )

        assertThat(travelOverview.isValid()).isEqualTo(true)
    }

    private class TravelOverviewTestCase: ArgumentsProvider {
        val DUMMY_TRAVEL_EVENT_ID_1 = "01234567890123456789abcdef"
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.arguments(
                listOf(DUMMY_TRAVEL_EVENT_ID_1),
                "草津温泉",
                listOf(JpPrefectureCode.GUNMA)
            ),
            Arguments.arguments(
                emptyList<TravelEventId>(),
                "どっか",
                emptyList<JpPrefectureCode>()
            ),
            Arguments.arguments(
                emptyList<TravelEventId>(),
                "温泉",
                listOf(JpPrefectureCode.TOYAMA, JpPrefectureCode.ISHIKAWA, JpPrefectureCode.FUKUI)
            )
        )
    }
}