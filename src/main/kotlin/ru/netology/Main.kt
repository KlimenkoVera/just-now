package ru.netology

const val MINUTE = 60
const val HOUR = 3_600
const val DAY = 86_400


fun main() {


    val result = agoToText(4650)
    println("был(а) в сети $result")
}


fun agoToText(
    secondsCount: Int
): String = when {
    (secondsCount < MINUTE) -> "только что"
    ((MINUTE + 1) < secondsCount && secondsCount < HOUR) -> "${amountOfTime(secondsCount)} ${endingOfWord(secondsCount)} назад"
    ((HOUR + 1) < secondsCount && secondsCount < DAY) -> "${amountOfTime(secondsCount)} ${endingOfWord(secondsCount)} назад"
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

fun endingOfWord(
    secondsCount: Int
): String {
    return when {
        ((MINUTE + 1) < secondsCount && secondsCount < HOUR) ->
            when {
                (amountOfTime(secondsCount) % 10 === 1 && amountOfTime(secondsCount) % 100 !== 11) -> "минуту"
                (amountOfTime(secondsCount) % 10 === 2 || amountOfTime(secondsCount) % 10 === 3 || amountOfTime(
                    secondsCount
                ) % 10 === 4) -> "минуты"
                else -> "минут"
            }
        ((HOUR + 1) < secondsCount && secondsCount < DAY) ->
            when {
                (amountOfTime(secondsCount) % 10 === 1 && amountOfTime(secondsCount) % 100 !== 11) -> "час"
                (amountOfTime(secondsCount) % 10 === 2 || amountOfTime(secondsCount) % 10 === 3 || amountOfTime(
                    secondsCount
                ) % 10 === 4) -> "часа"
                else -> "часов"
            }
        else -> ""
    }
}



