import java.util.*

class BloomFilter<T>(
    private val hashFunctions: List<(T) -> Int>,
    private val bitSetSize: Int = 1_000_000,
) {
    private val bitSet = BitSet(bitSetSize)

    fun add(element: T) {
        hashFunctions.forEach {
            bitSet.set((it(element) and Int.MAX_VALUE) % bitSetSize)
        }
    }

    fun contains(element: T): Boolean =
        hashFunctions.all { bitSet.get((it(element) and Int.MAX_VALUE) % bitSetSize) }
}
