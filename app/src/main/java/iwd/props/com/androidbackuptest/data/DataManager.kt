package iwd.props.com.androidbackuptest.data

class DataManager constructor(sharedPrefsHelper: SharedPrefsHelper) {

    private var sharedPrefs: SharedPrefsHelper = sharedPrefsHelper

    fun clear() {
        sharedPrefs.clear()
    }

    fun saveSeed(seed: String) {
        sharedPrefs.setSeedPhrase(seed)
    }

    fun getSeed(): String {
        return sharedPrefs.getSeedPhrase()
    }
}