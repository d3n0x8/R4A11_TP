package controller

import android.icu.util.Calendar

class AgeCalculator {
    fun calculateAge(birthday: Int): Int {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        return currentYear - birthday
    }
}