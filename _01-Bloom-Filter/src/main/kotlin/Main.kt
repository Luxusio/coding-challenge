fun main() {

    val bloomFilter = BloomFilter<String>(
        listOf(
            { it.hashCode() },
            { it.hashCode() * 31 },
            { it.hashCode() * 31 * 31 }
        )
    )

    bloomFilter.add("Hello")
    bloomFilter.add("World")
    bloomFilter.add("Help me")

    println(bloomFilter.contains("Hello")) // true
    println(bloomFilter.contains("World")) // true
    println(bloomFilter.contains("Help me")) // true
    println(bloomFilter.contains("Not here")) // false
}
