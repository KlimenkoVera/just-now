package ru.netology

//enum class NameOfTime {
//    Seconds, Minutes, Hours, Days
//}
const val MINUTE = 60
const val HOUR = 3_600
const val DAY = 86_400


fun main() {
    val result = agoToText(86500)
    println("был(а) в сети $result")
}


fun agoToText(
    secondsCount: Int
): String = when {
    (secondsCount < MINUTE) -> "только что"
    ((MINUTE + 1) < secondsCount && secondsCount < HOUR) -> "${amountOfTime(secondsCount)} минут назад"
    ((HOUR + 1) < secondsCount && secondsCount < DAY) -> "${amountOfTime(secondsCount)} часов назад"
    ((DAY + 1) < secondsCount && secondsCount < DAY * 2) -> "сегодня"
    ((DAY * 2 + 1) < secondsCount && secondsCount < DAY * 3) -> "вчера"
    else -> "давно"
}

fun amountOfTime(
    secondsCount: Int
): Int {

    return when {
        ((MINUTE + 1) < secondsCount && secondsCount < HOUR) -> secondsCount / MINUTE
        ((HOUR + 1) < secondsCount && secondsCount < DAY) -> secondsCount / HOUR

        else -> secondsCount
    }
}




