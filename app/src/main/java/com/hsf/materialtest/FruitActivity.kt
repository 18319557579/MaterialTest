package com.hsf.materialtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.hsf.materialtest.intent.People
import com.hsf.materialtest.intent.Person

class FruitActivity : AppCompatActivity() {

    val collapsingToolbar: CollapsingToolbarLayout by lazy {
        findViewById(R.id.collapsingToolbar)
    }
    val fruitImageView: ImageView by lazy {
        findViewById(R.id.fruitImageView)
    }
    val fruitContentText: TextView by lazy {
        findViewById(R.id.fruitContentText)
    }
    val fab: FloatingActionButton by lazy {
        findViewById(R.id.fab)
    }

    companion object {
        const val FRUIT_NAME = "fruit_name"
        const val FRUIT_IMAGE_ID = "fruit_image_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)

        val fruitName = intent.getStringExtra(FRUIT_NAME) ?: ""
        val fruitImageId = intent.getIntExtra(FRUIT_IMAGE_ID, 0)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsingToolbar.title = fruitName
        Glide.with(this).load(fruitImageId).into(fruitImageView)
        fruitContentText.text = generateFruitContent(fruitName)

        fab.setOnClickListener {
//            "RRR".showToast(this)
            R.string.app_name.showToast(this, Toast.LENGTH_LONG)

        }

        /*val person = Person().apply {
            name = "Tome"
            age = 29
        }
        val intent = Intent(this, FruitActivity::class.java)

        intent.putExtra("person_data", person)
        startActivity(intent)

        val person2 = intent.getSerializableExtra("person_data") as Person


        val people = People().apply {
            name = "tome"
            age=29
        }
        val intent2 = Intent(this, FruitActivity::class.java)
        intent2.putExtra("ttt", people)

        intent.getParcelableExtra<People>("ttt")*/
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun generateFruitContent(fruitName: String) = fruitName.repeat(500)
}