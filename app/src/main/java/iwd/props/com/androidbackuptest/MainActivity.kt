package iwd.props.com.androidbackuptest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import android.app.backup.BackupManager
import iwd.props.com.androidbackuptest.data.DataManager
import iwd.props.com.androidbackuptest.data.SharedPrefsHelper
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {
    lateinit var dataManager: DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        dataManager = DataManager(SharedPrefsHelper(this))

        fab.setOnClickListener { dataManager.saveSeed(seed_phrase.text.toString()) }
        fab2.setOnClickListener { recovered.text = dataManager.getSeed() }
    }

    override fun onPause() {
        BackupManager(this).dataChanged() // creates and enqueues a backup
        super.onPause()
    }
}
