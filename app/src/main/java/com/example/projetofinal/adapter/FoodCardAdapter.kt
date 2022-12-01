package com.example.projetofinal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofinal.ButtonClickListener
import com.example.projetofinal.R
import com.example.projetofinal.data.DataSource

// Adapter responsável por fornecer acesso ao DataSource, criar objetos ViewHolder e possibilitar a exibição pelo RecyclerView
class FoodCardAdapter(
    private val context: Context?,
    private val buttonClickListener: ButtonClickListener
) : RecyclerView.Adapter<FoodCardAdapter.FoodCardViewHolder>() {

    private val dataset = DataSource.foodItems.toMutableList()

    //ViewHolder que contém o layout de um item individual da lista
    inner class FoodCardViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val foodName: RadioButton = view.findViewById(R.id.food1)
        val foodCalories: TextView = view.findViewById(R.id.food1_calories)
    }

    // ------------------------------- Métodos chamados pelo RecyclerView -------------------------------

    //Método que cria e inicializa o ViewHolder e a View associada, mas não preenche o conteúdo da visualização
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodCardViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.vertical_list_item, parent, false)

        return FoodCardViewHolder(adapterLayout)
    }

    //Método para ver o tamanho do conjunto de dados
    override fun getItemCount(): Int {
        return dataset.size
    }

    //Método para associar um ViewHolder aos dados
    override fun onBindViewHolder(holder: FoodCardViewHolder, position: Int) {

        val item = dataset[position]

        holder.foodName.text = item.name
        holder.foodCalories.text =
            context?.getString(R.string.display_calories, item.caloriesToString())

        holder.foodName.setOnClickListener {
            buttonClickListener.onButtonClickListener(item.calories)
        }
    }


}