package azimjon.com.coffeeshop

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import azimjon.com.coffeeshop.databinding.CoffesListFragmentBinding

class CoffesListFragment() : Fragment() {

    private var _binding: CoffesListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CoffesListFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val items = arguments?.getParcelableArrayList<RecyclerViewItem>("key")?.toList()

        val recyclerview = binding.cofesRecyclerView

        val adapter = CofesRecyclerViewAdapter(items!!)

        recyclerview.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerview.adapter = adapter

        adapter.setListener(object : RecyclerViewListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(requireContext(), "Click $position", Toast.LENGTH_SHORT).show()
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}