package wael.emy.notebook.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.bottom_bar.*
import wael.emy.notebook.R
import wael.emy.notebook.fragments.HomeFragment
import wael.emy.notebook.fragments.MoreFragment
import wael.emy.notebook.fragments.MyBooksFragment
import wael.emy.notebook.fragments.SearchFragment

class HomeActivity : AppCompatActivity() {
    lateinit var fragments:Array<Fragment>
    private val maxPosition:Int = 3
    private var previousID:Int = maxPosition

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigateToFragment(maxPosition - 1)
        bottom_navigation.setNavigationChangeListener { _, position ->
            navigateToFragment(position)
        }
    }

    private fun navigateToFragment(id: Int) {
        fragments = arrayOf(
            MoreFragment(),
            MyBooksFragment(),
            SearchFragment(),
            HomeFragment()
        )
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (previousID <= id)
            transaction.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            )
        else
            transaction.setCustomAnimations(
                R.anim.enter_from_left,
                R.anim.exit_to_right,
                R.anim.enter_from_right,
                R.anim.exit_to_left
            )
        transaction.replace(R.id.frameLayout, fragments[id]).commit()
        previousID = id
    }
}
