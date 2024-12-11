package azimjon.com.coffeeshop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import azimjon.com.coffeeshop.databinding.CofesRecyclerviewItemBinding

class CofesRecyclerViewAdapter(
    private val list: List<RecyclerViewItem>
) : RecyclerView.Adapter<CofesRecyclerViewAdapter.MyGridViewHolder>() {

    private var recyclerViewListener: RecyclerViewListener? = null

    inner class MyGridViewHolder(val binding: CofesRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                recyclerViewListener?.onItemClick(adapterPosition)
            }
        }


        fun bind(item: RecyclerViewItem) {
            binding.coffeImage.setImageResource(item.imageres)
            binding.coffeName.text = item.name
            binding.categoryCaffe.text = item.category
            binding.price.text = item.price
            binding.star.text = item.star
        }
    }

    fun setListener(listener: RecyclerViewListener) {
        recyclerViewListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyGridViewHolder {
        return MyGridViewHolder(
            CofesRecyclerviewItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyGridViewHolder, position: Int) {
        holder.bind(list[position])
    }
}