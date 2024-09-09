package com.example.adapterbottomnavdrawer

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.adapterbottomnavdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private lateinit var shared:SharedPreferences

   lateinit var toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toggle=ActionBarDrawerToggle(this@MainActivity,binding.main,R.string.open,R.string.close)
        binding.main.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayShowHomeEnabled(true)






        shared=getSharedPreferences("MyAppPref",Context.MODE_PRIVATE)
        var editor=shared.edit()


        var value=shared.getString("theme","")

        if(value=="dark")
        {
            ///code dark theme
        }
        else if(value=="light")
        {
            ///code of light theme
        }


binding.btnSave.setOnCheckedChangeListener(
        {  name,IsChecked->

if(IsChecked==true)
{
    editor.putString("theme","dark")
}
            else
{
    editor.putString("theme","light")
}
editor.commit()
        })





        binding.nav.setNavigationItemSelectedListener { menu->
            if(menu.itemId==R.id.home){
                replaceFargment(HomeFragment())
                binding.main.closeDrawers()
                true
            }
            else if (menu.itemId==R.id.Search){
                replaceFargment(SearchFragment())
                binding.main.closeDrawers()
                true

            }
            else if (menu.itemId==R.id.Me){
                replaceFargment(MeFragment())
                binding.main.closeDrawers()
                true
            }
            else false
        }


         binding.bn.setOnItemSelectedListener { menu->
          if(menu.itemId==R.id.home) {
              replaceFargment(HomeFragment())
              true
          }
             else if (menu.itemId==R.id.Search){
                 replaceFargment(SearchFragment())
              true
          } else if (menu.itemId==R.id.Me){
                 replaceFargment(MeFragment())
              true
          }
             else false
         }

    }

    private fun replaceFargment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().replace(R.id.fl,fragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuu,menu)

        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==R.id.Search)
        {
            replaceFargment(SearchFragment())
            Toast.makeText(this@MainActivity, "Search", Toast.LENGTH_SHORT).show()
            return  true
        }
      else if(item.itemId==R.id.home)
        {
            replaceFargment(HomeFragment())
            Toast.makeText(this@MainActivity, "Home", Toast.LENGTH_SHORT).show()
            return  true
        }
      else if(item.itemId==R.id.Me)
        {
            replaceFargment(MeFragment())
            Toast.makeText(this@MainActivity, "Me", Toast.LENGTH_SHORT).show()
            return  true
        }
        else
            return super.onOptionsItemSelected(item)
    }

}