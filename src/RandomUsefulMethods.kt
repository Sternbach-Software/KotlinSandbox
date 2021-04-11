import java.util.regex.Matcher
import java.util.regex.Pattern

@Suppress("Unused")
class RandomUsefulMethods {
    /**
     * Requests input from the user by first printing [firstMessageToDisplay] and then calling readLine()
     * loops for input until the input matches the provided [regex], printing
     * */
    fun getValidatedInput(regex: Regex, firstMessageToDisplay: String, messageToDisplayOnError: String): String? {
        print("$firstMessageToDisplay: ")
        var input = readLine()
        while(input?.matches(regex)?.not() == true) /*doesn't match regex (written in a strange way to keep nullability)*/{
            print("$messageToDisplayOnError: ")
            input = readLine()
        }
        return input
    }

    /** @return index of pattern in s or -1, if not found
     */
    fun indexOf(pattern: Pattern, s: String?): Int {
        val matcher: Matcher = pattern.matcher(s)
        return if (matcher.find()) matcher.start() else -1
    }
}