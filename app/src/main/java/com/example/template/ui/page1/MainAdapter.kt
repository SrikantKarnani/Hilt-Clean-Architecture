package com.example.template.ui.page1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.template.data.model.Cocktail
import com.example.template.databinding.CocktailRowBinding

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var cocktailList = listOf<Cocktail>()

    interface OnClickListener {
        fun onCocktailClick(cocktail: Cocktail, position: Int)
    }

    fun setCocktailList(cocktailList: List<Cocktail>) {
        this.cocktailList = cocktailList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding =
            CocktailRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val vh = MainViewHolder(itemBinding)
        return vh
    }

    override fun getItemCount(): Int {
        return cocktailList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(cocktailList[position], position)
        }
    }

    private inner class MainViewHolder(val binding: CocktailRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Cocktail, position: Int) = with(binding) {
            Glide.with(binding.imgCocktail).load(item.image).centerCrop().into(imgCocktail)
            txtTitulo.text = item.name
            txtDescripcion.text = item.description
        }
    }
}