package uz.abbosbek.myfragmentdaynamic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.abbosbek.myfragmentdaynamic.databinding.ActivityMainBinding
import uz.abbosbek.myfragmentdaynamic.fragments.BlankFragment
import uz.abbosbek.myfragmentdaynamic.fragments.BlankFragment2

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var blankFragment: BlankFragment
    private lateinit var blankFragment2: BlankFragment2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var fragmentManager = supportFragmentManager

        blankFragment = BlankFragment()
        blankFragment2 = BlankFragment2()

        binding.apply {
            btnAdd.setOnClickListener {
                fragmentManager.beginTransaction()
                    .add(R.id.my_container, blankFragment)
                    .addToBackStack(blankFragment.toString())
                    .commit()
            }

            btnRemove.setOnClickListener {
                fragmentManager.beginTransaction()
                    .remove(blankFragment)
                    .remove(blankFragment2)
                    .addToBackStack(blankFragment.toString())
                    .commit()
            }
            btnReplace.setOnClickListener {
                fragmentManager.beginTransaction()
                    .replace(R.id.my_container, blankFragment2)
                    .replace(R.id.my_container, blankFragment)
                    .addToBackStack(blankFragment.toString())
                    .commit()
            }
            btnHide.setOnClickListener {
                fragmentManager.beginTransaction()
                    .hide(blankFragment)
                    .hide(blankFragment2)
                    .addToBackStack(blankFragment.toString())
                    .commit()
            }
            btnShow.setOnClickListener {
                fragmentManager.beginTransaction()
                    .show(blankFragment)
                    .show(blankFragment2)
                    .addToBackStack(blankFragment.toString())
                    .commit()
            }
        }
    }
}