package com.example.lf_wannabe.managemybook.utils

import android.util.SparseArray
import java.util.HashMap

/**
 * Created by lf_wannabe on 08/11/2017.
 */
object CollectionsUtils {

    fun isEmpty(map: Map<*, *>?): Boolean {
        return map?.isEmpty() ?: true
    }

    fun isEmpty(list: List<*>?): Boolean {
        return list?.isEmpty() ?: true
    }


    fun <E> convertToMap(source: SparseArray<E>?): HashMap<Int, E> {
        val map = HashMap<Int, E>()
        if (source == null) {
            return map
        }
        val length = source.size()
        for (i in 0 until length) {
            map.put(source.keyAt(i), source.valueAt(i))
        }
        return map
    }

    fun size(vararg listArray: List<*>): Int {
        var sum = 0
        for (i in listArray.indices) {
            val list = listArray[i]
            if (list != null) {
                sum = sum + list.size
            }
        }
        return sum
    }
}
