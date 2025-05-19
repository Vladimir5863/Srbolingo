package com.example.srbingo

// Potrebni importi za RecyclerView adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.srbingo.databinding.ItemLevelBinding

// Adapter za prikazivanje liste nivoa u RecyclerView-u
class LevelsAdapter(
    private val levels: List<Level>, // Lista nivoa za prikazivanje
    private val onLevelClick: (Level) -> Unit // Callback funkcija koja se poziva kada korisnik klikne na nivo
) : RecyclerView.Adapter<LevelsAdapter.LevelViewHolder>() {

    // ViewHolder klasa koja drži reference na view elemente za svaki nivo
    inner class LevelViewHolder(
        private val binding: ItemLevelBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        // Povezivanje podataka nivoa sa view elementima
        fun bind(level: Level) {
            binding.apply {
                levelNumberText.text = "Nivo ${level.number}"
                levelDescriptionText.text = level.description
                
                // Ažuriranje izgleda na osnovu stanja zaključavanja
                root.alpha = if (level.isLocked) 0.5f else 1.0f
                lockIcon.visibility = if (level.isLocked) View.VISIBLE else View.GONE
                
                // Postavljanje listener-a za klik na nivo
                root.setOnClickListener { onLevelClick(level) }
            }
        }
    }

    // Kreiranje novog ViewHolder-a
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelViewHolder {
        val binding = ItemLevelBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LevelViewHolder(binding)
    }

    // Povezivanje podataka sa ViewHolder-om na određenoj poziciji
    override fun onBindViewHolder(holder: LevelViewHolder, position: Int) {
        holder.bind(levels[position])
    }

    // Vraćanje ukupnog broja nivoa
    override fun getItemCount() = levels.size
} 