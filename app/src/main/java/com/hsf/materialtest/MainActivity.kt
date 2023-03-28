package com.hsf.materialtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.hsf.materialtest.util.BasicUtils
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {


    private val fruits = mutableListOf(Fruit("Apple", R.drawable.apple),
        Fruit("Banana", R.drawable.banana),
        Fruit("Orange", R.drawable.orange),
        Fruit("Watermelon", R.drawable.watermelon),
        Fruit("Pear", R.drawable.pear),
        Fruit("Grape", R.drawable.grape),
        Fruit("Pineapple", R.drawable.pineapple),
        Fruit("Str", R.drawable.strawberry),
        Fruit("che", R.drawable.cherry),
        Fruit("man", R.drawable.mango))

    val fruitList = ArrayList<Fruit>()

//    private val myBar : Toolbar by lazy {
//        findViewById(R.id.tool_bar)
//    }
    private val theDrawerLayout : DrawerLayout by lazy {
        findViewById(R.id.drawerLayout)
    }

    private val navView: NavigationView by lazy {
        findViewById(R.id.navView)
    }

    private val fab: FloatingActionButton by lazy {
        findViewById(R.id.fab)
    }

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recyclerView)
    }

    private val swipeRefresh: SwipeRefreshLayout by lazy {
        findViewById(R.id.swipeRefresh)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        setSupportActionBar(myBar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        navView.setCheckedItem(R.id.navCall)
        navView.setNavigationItemSelectedListener {
            Log.d("Daisy", "点击了${it}")
            Toast.makeText(this, "nihao ", Toast.LENGTH_SHORT).show()
            theDrawerLayout.closeDrawers()
            true
        }

        fab.setOnClickListener {
/*            Snackbar.make(myBar, "Data deleted", Snackbar.LENGTH_SHORT)
                .setAction("Undo") {
                    Toast.makeText(this, "回滚", Toast.LENGTH_SHORT).show()
                }
                .show()*/


/*            myBar.showSnackbar("展示时间", "查询") {
                "是否是夜间模式${BasicUtils.isDarkTheme(this)}".showToast(this)
            }*/
        }

        Log.d("Daisy", "onCreate调用")

        initFruits()
        val layoutManager = GridLayoutManager(this, 2)
        val fruitAdapter = FruitAdapter(this, fruitList)
        recyclerView.let {
            it.layoutManager = layoutManager
            it.adapter = fruitAdapter
        }

        swipeRefresh.setColorSchemeResources(R.color.purple_200)
        swipeRefresh.setOnRefreshListener {
            refreshFruits(fruitAdapter)
        }
    }

    private fun refreshFruits(adapter: FruitAdapter) {
        thread {
            Thread.sleep(2000)
            runOnUiThread {
                initFruits()
                adapter.notifyDataSetChanged()
                swipeRefresh.isRefreshing = false
            }
        }
    }

    private fun initFruits() {
        fruitList.clear()
        repeat(50) {
            val index = (0 until fruits.size).random()
            fruitList.add(fruits[index])
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.d("Daisy", "onCreateOptionsMenu调用")

        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.backup -> Toast.makeText(this, "点击备份", Toast.LENGTH_SHORT).show()
            R.id.delete -> Toast.makeText(this, "点击了删除", Toast.LENGTH_SHORT).show()
            R.id.settings -> theDrawerLayout.openDrawer(GravityCompat.END)
            android.R.id.home -> theDrawerLayout.openDrawer(GravityCompat.START)
        }

        return true
    }
}