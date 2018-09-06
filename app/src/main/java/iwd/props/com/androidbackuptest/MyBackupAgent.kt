package iwd.props.com.androidbackuptest

import android.app.backup.*
import android.app.backup.SharedPreferencesBackupHelper
import iwd.props.com.androidbackuptest.data.SharedPrefsHelper


class MyBackupAgent : BackupAgentHelper() {
    override fun onCreate() {
        val helper = SharedPreferencesBackupHelper(this, SharedPrefsHelper.RECOVERED_SEED)
        addHelper(SharedPrefsHelper.MY_PREFS, helper)
    }
}