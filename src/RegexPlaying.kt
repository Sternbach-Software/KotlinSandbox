fun main() {
    for (i in 1 until 30) {
        val word = readLine() ?: ""
        println(word.onlyContainsLetters()
        )
    }
}
fun String.onlyContainsLetters(): Boolean {
    val regex = "^[A-Za-z ]*\$".toRegex()
    return regex.matches(this)
}