package br.com.impacta.room.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Comida(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "nome_comida") var nomeComida: String,
    var origem: String,
    var calorias: Int,
    var tipo: String
) {
    fun getCaloriasString() = this.calorias.toString()
}