package azimjon.com.coffeeshop

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecyclerViewItem(
    val imageres: Int,
    val name: String,
    val category: String,
    val price: String,
    val star: String
) : Parcelable