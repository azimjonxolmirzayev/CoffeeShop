package azimjon.com.coffeeshop

import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import azimjon.com.coffeeshop.databinding.ActivityDescriptionBinding

class DescriptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image = intent.getIntExtra("img", 0) // Resurs identifikatori sifatida
        val name = intent.getStringExtra("name")
        val category = intent.getStringExtra("category")
        val star = intent.getStringExtra("star")
        val price = intent.getStringExtra("price")

        binding.cofepicture.setImageResource(image)
        binding.category.text = category
        binding.star.text = star
        binding.priceTv.text = price
        binding.name.text = name

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

//        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
//        radioGroup.setOnCheckedChangeListener { _, checkedId ->
//            when (checkedId) {
//                R.id.radioSmall -> {
//                    // "S" tanlangan
//                }
//                R.id.radioMedium -> {
//                    // "M" tanlangan
//                }
//                R.id.radioLarge -> {
//                    // "L" tanlangan
//                }
//            }
//        }

    }
}