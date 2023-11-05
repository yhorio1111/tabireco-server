package com.yhorio.tabireco.domain.vo.id

import de.huxhorn.sulky.ulid.ULID as ULIDGen

private val ulidGen = object : ThreadLocal<ULIDGen>() {
    override fun initialValue() = ULIDGen()
}

typealias ULID = String
fun ulid(): ULID = ulidGen.get().nextULID()
