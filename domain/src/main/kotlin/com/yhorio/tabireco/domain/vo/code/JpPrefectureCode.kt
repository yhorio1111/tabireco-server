package com.yhorio.tabireco.domain.vo.code

enum class JpPrefectureCode(
    override val code: String,
    val displayName: String
) : AreaCode {
    UNKNOWN("00", "不明"),
    HOKKAIDO("01", "北海道"),
    AOMORI("02", "青森"),
    IWATE("03", "岩手"),
    MIYAGI("04", "宮城"),
    AKITA("05", "秋田"),
    YAMAGATA("06", "山形"),
    FUKUSHIMA("07", "福島"),
    IBARAKI("08", "茨城"),
    TOCHIGI("09", "栃木"),
    GUNMA("10", "群馬"),
    SAITAMA("11", "埼玉"),
    CHIBA("12", "千葉"),
    TOKYO("13", "東京"),
    KANAGAWA("14", "神奈川"),
    NIIGATA("15", "新潟"),
    TOYAMA("16", "富山"),
    ISHIKAWA("17", "石川"),
    FUKUI("18", "福井"),
    YAMANASHI("19", "山梨"),
    NAGANO("20", "長野"),
    GIFU("21", "岐阜"),
    SHIZUOKA("22", "静岡"),
    AICHI("23", "愛知"),
    MIE("24", "三重"),
    SHIGA("25", "滋賀"),
    KYOTO("26", "京都"),
    OSAKA("27", "大阪"),
    HYOGO("28", "兵庫"),
    NARA("29", "奈良"),
    WAKAYAMA("30", "和歌山"),
    TOTTORI("31", "鳥取"),
    SHIMANE("32", "島根"),
    OKAYAMA("33", "岡山"),
    HIROSHIMA("34", "広島"),
    YAMAGUCHI("35", "山口"),
    TOKUSHIMA("36", "徳島"),
    KAGAWA("37", "香川"),
    EHIME("38", "愛媛"),
    KOUCHI("39", "高知"),
    FUKUOKA("40", "福岡"),
    SAGA("41", "佐賀"),
    NAGASAKI("42", "長崎"),
    KUMAMOTO("43", "熊本"),
    OITA("44", "大分"),
    MIYAZAKI("45", "宮崎"),
    KAGOSHIMA("46", "鹿児島"),
    OKINAWA("47", "沖縄");

    override fun isUnknown(): Boolean {
        return this == UNKNOWN
    }

    companion object {
        fun getByCode(code: String): JpPrefectureCode {
            return values().find { it.code == code } ?: UNKNOWN
        }
    }
}