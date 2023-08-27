package com.yhorio.tabireco.domain.vo.id

import de.huxhorn.sulky.ulid.ULID

@JvmInline
value class TravelEventId(override val value: ULID) : EntityId<ULID>
