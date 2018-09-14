package pe.edu.upc.catchup.viewControllers.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import pe.edu.upc.catchup.R
import pe.edu.upc.catchup.viewControllers.fragments.FavoritesFragment
import pe.edu.upc.catchup.viewControllers.fragments.HomeFragment
import pe.edu.upc.catchup.viewControllers.fragments.SettingsFragment
import pe.edu.upc.catchup.viewControllers.fragments.SourcesFragment

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener navigateTo(item)
    }
    /*
    * patron adapter: conecta elementos incompatibles, vinculo entre lo que se va a presentar y los datos (layyout)*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_home
    }

    private fun fragmentFor(item: MenuItem): Fragment {
        when (item.itemId) {
            R.id.navigation_home -> {
                return HomeFragment()
            }
            R.id.navigation_sources -> {
                return SourcesFragment()
            }
            R.id.navigation_favorites -> {
                return FavoritesFragment()
            }
            R.id.navigation_settings -> {
                return SettingsFragment()
            }
        }
        return HomeFragment()
    }

    //reemplazar la vista por otro frangmento
    private fun navigateTo(item: MenuItem): Boolean {
        item.setChecked(true)
        return supportFragmentManager
                .beginTransaction()
                .replace(R.id.content, fragmentFor(item))
                .commit() > 0
    }
}