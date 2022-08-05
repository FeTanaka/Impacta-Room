package br.com.impacta.room.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.impacta.room.data.models.Comida
import br.com.impacta.room.databinding.ComidaItemBinding

class ComidaAdapter(val listaComida: List<Comida>, val acao: (Int) -> Unit): RecyclerView.Adapter<ComidaAdapter.ComidaViewHolder>() {

    inner class ComidaViewHolder(val binding: ComidaItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComidaViewHolder {
        val binding = ComidaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComidaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComidaViewHolder, position: Int) {
        val comida = listaComida[position]
        holder.binding.comida = comida
        holder.binding.root.setOnClickListener { acao(comida.id) }
    }

    override fun getItemCount(): Int {
        return listaComida.size
    }
}