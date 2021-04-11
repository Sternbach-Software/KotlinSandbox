package diffing

import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

fun main() {
   val shiurCategoryPage = ShiurCategoryPage::class.parameters()
   val shiurFullPage = ShiurFullPage::class.parameters()
   val ShiurQuickSeriesShiurPage = ShiurQuickSeriesShiurPage::class.parameters()
   val ShiurSearchResultsPage = ShiurSearchResultsPage::class.parameters()
   val ShiurSpeakerPage = ShiurSpeakerPage::class.parameters()
    val totalList = listOf(
        shiurCategoryPage,
            shiurFullPage,
            ShiurQuickSeriesShiurPage,
            ShiurSearchResultsPage,
            ShiurSpeakerPage
    )
    val totalListNames = listOf(
        "shiurCategoryPage",
        "shiurFullPage",
        "ShiurQuickSeriesShiurPage",
        "ShiurSearchResultsPage",
        "ShiurSpeakerPage"
    )
//    processParams(totalList, totalListNames)
    val list = mutableListOf<String>()
val x = totalList.flatten().map{it.toLowerCase()}
    val freqMap = getFreqMap(x)
    for(pair in freqMap){
        if(pair.value==5) list.add(pair.key)
    }
    println(list)
    /*    fun countOccurrences(s: List<String>, ch: String): Int {
        var counter = 0
        for (c in s) {
            if (c == ch) {
                counter++
            }
        }
        return counter
    }*/
}
fun getFreqMap(chars: List<String>): Map<String, Int> {
    val freq: MutableMap<String, Int> = HashMap()
    for (c in chars) {
        freq.putIfAbsent(c, 0)
        freq[c] = freq[c]!! + 1
    }
    return freq
}
private fun processParams(
    totalList: List<List<String>>,
    totalListNames: List<String>
) {
    for (list in totalList) {
        for (parameter in list) {
            for (list1 in totalList) {
                if (list1 != list && parameter in list1) {
                    println(
                        "$parameter of ${totalListNames[totalList.indexOf(list)]} is in ${
                            totalListNames[totalList.indexOf(
                                list1
                            )]
                        }"
                    )
                }
            }
        }
    }
}

fun <T : Any> KClass<T>.parameters():List<String>{
    val mutableList = mutableListOf<String>()
    this.primaryConstructor?.parameters?.forEach {
        it.name?.let { it1 ->
            mutableList.add(
                it1
            )
        }
    }
    return mutableList.toList()
}