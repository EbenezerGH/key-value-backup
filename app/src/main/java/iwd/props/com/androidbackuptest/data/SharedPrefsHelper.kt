package iwd.props.com.androidbackuptest.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class SharedPrefsHelper constructor(context: Context) {
    companion object {
        const val MY_PREFS = "MY_PREFS"
        const val RECOVERED_SEED = "RECOVERED_SEED"
    }

    //private val gson = Gson()
    private var sharedPrefs: SharedPreferences
    private var context: Context

    init {
        sharedPrefs = context.getSharedPreferences(MY_PREFS, MODE_PRIVATE)
        this.context = context
    }

    fun clear() {
        sharedPrefs.edit().clear().apply()
    }

    fun setSeedPhrase(seed: String) {
        sharedPrefs.edit().putString(RECOVERED_SEED, seed).apply()
    }

    fun getSeedPhrase(): String {
        return sharedPrefs.getString(RECOVERED_SEED, "null")
    }
}
