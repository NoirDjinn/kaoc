package util

fun getResourceAsText(path: String): String {
    return object {}.javaClass.getResource(path).readText()
}

fun getUrlByYearAndDays(day: Int, year: Int): String {
    return "/${year}/${day.toString().padStart(2, '0')}.txt"
}

fun getInputForDay(day: Int, year: Int): String {
    val url = getUrlByYearAndDays(day, year)
    return getResourceAsText(url)
}