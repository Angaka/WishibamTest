package com.projects.venom04.wishibamtest.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Venom on 31/05/2018.
 */
class DateHelper {
    companion object {
        fun formatStringDate(stringDate: String): String {
            val sdfOriginal = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
            val sdf = SimpleDateFormat("MMMM dd, yyyy | hh:mm", Locale.getDefault())
            val date = sdfOriginal.parse(stringDate)
            return sdf.format(date)
        }
    }
}