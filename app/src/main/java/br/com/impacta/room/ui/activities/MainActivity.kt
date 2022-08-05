package br.com.impacta.room.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.impacta.room.R
import br.com.impacta.room.data.local.database.AppDatabase

class MainActivity : AppCompatActivity() {

    val db: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}