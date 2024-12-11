package azimjon.com.coffeeshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import azimjon.com.coffeeshop.databinding.HomeLayoutBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment() : Fragment() {

    private var _binding: HomeLayoutBinding? = null
    private val binding get() = _binding!!

    val list = listOf("All Coffee", "Machiato", "Americano", "Milkly")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeLayoutBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = arrayListOf(
            RecyclerViewItem(R.drawable.coffee1, "Caffe Mocha", "Latte", "\$ 4.53", "4.8"),
            RecyclerViewItem(R.drawable.coffee2, "Espresso", "Machiato", "\$ 3.50", "4.7"),
            RecyclerViewItem(R.drawable.coffee3, "White coup", "Milkly", "\$ 4.00", "4.6"),
            RecyclerViewItem(R.drawable.coffee4, "Cappuccino", "Americano", "\$ 4.20", "4.9"),
            RecyclerViewItem(R.drawable.coffee4, "Coffes", "Americano", "\$ 4.20", "4.9")
        )
        val coffesviewpageradapter = CoffesViewPagerAdapter(requireActivity(), list, items)
        binding.coffesViewPager.adapter = coffesviewpageradapter


        binding.coffesViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                val currentCoffee = list[position]

                val filteredItems = if (currentCoffee == "All Coffee") {
                    items
                } else {
                    items.filter { it.category == currentCoffee }
                }

                (binding.coffesViewPager.adapter as? CoffesViewPagerAdapter)?.updateItems(
                    filteredItems
                )

            }
        })




        TabLayoutMediator(binding.tablayout, binding.coffesViewPager) { tab, position ->
            tab.text = list[position]
        }.attach()


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}