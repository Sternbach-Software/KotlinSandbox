import java.io.File

fun main() {
    val homeFolder = File("C:\\Users\\shmue\\OneDrive\\Desktop\\Sefaria Texts (Excluding Talmud and Tanaitic texts)\\Tanach")
    val files = homeFolder.walk().toList().filter{it.extension=="txt" && it.name.contains("with")}
    println(files)
}