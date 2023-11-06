package com.yhorio.tabireco.domain.entity

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.yhorio.tabireco.domain.type.TravelEventType
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.time.LocalDateTime
import java.util.stream.Stream

internal class TravelEventTest {
    @ParameterizedTest
    @ArgumentsSource(TravelEventTestCase::class)
    fun isValid(
        travelEventType: TravelEventType,
        eventTime: LocalDateTime,
        details: String,
    ) {
        val travelEvent = TravelEvent.of(
            travelEventType,
            eventTime,
            details,
        )

        assertThat(travelEvent.isValid()).isEqualTo(true)
    }

    private class TravelEventTestCase: ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.arguments(
                TravelEventType.FOOD,
                LocalDateTime.of(2023, 9, 18, 13, 0, 0, 0),
                "食べ物テスト"
            ),
            Arguments.arguments(
                TravelEventType.ONSEN,
                LocalDateTime.of(2023, 9, 19, 13, 0, 0 , 0),
                "温泉テスト"
            ),
            Arguments.arguments(
                TravelEventType.SIGHTSEEING,
                LocalDateTime.of(2023, 9, 19, 13, 0, 0 , 0),
                "観光テスト"
            ),
            Arguments.arguments(
                TravelEventType.OTHERS,
                LocalDateTime.of(2023, 9, 19, 13, 0, 0 , 0),
                "その他テスト"
            ),
        )
    }
}
