package chanbo.com.sampleproject.ui.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import business.chanbo.com.sampleproject.BR
import business.chanbo.com.sampleproject.R
import business.chanbo.com.sampleproject.databinding.ActivityMainBinding
import chanbo.com.sampleproject.ui.base.BaseActivity
import chanbo.com.sampleproject.ui.movie.MovieFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    NavigationView.OnNavigationItemSelectedListener,
    HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingFragmentInjector

    override fun getLayoutId(): Int = R.layout.activity_main

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: MainViewModel
        get() = injectViewModel(MainViewModel::class.java)

    override fun onInitView(savedInstanceState: Bundle?) {

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        switchFragment(MovieFragment.newInstance())

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragment, fragment.tag)
            .commit()
    }
}
