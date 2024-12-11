package azimjon.com.coffeeshop

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.ArrayList

class CoffesViewPagerAdapter(
    activity: FragmentActivity,
    val list: List<String>,
    private var list2: List<RecyclerViewItem>
) : FragmentStateAdapter(activity) {

    private val fragmentIdMap = mutableMapOf<Int, Long>()

    init {
        generateIds()
    }

    override fun getItemCount(): Int = list.size

    fun updateItems(newItems: List<RecyclerViewItem>) {
        list2 = newItems
        generateIds()
        notifyDataSetChanged()
    }

    override fun getItemId(position: Int): Long {
        return fragmentIdMap[position] ?: position.toLong()
    }

    override fun containsItem(itemId: Long): Boolean {
        return fragmentIdMap.containsValue(itemId)
    }

    private fun generateIds() {
        fragmentIdMap.clear()
        list.forEachIndexed { index, _ ->
            fragmentIdMap[index] = list[index].hashCode().toLong()
        }
    }

    override fun createFragment(position: Int): Fragment {
        val filteredList = ArrayList(list2.filter {
            list[position] == "All Coffee" || it.category == list[position]
        })

        return CoffesListFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList("key", filteredList)
            }
        }
    }
}
