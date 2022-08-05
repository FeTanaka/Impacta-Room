package br.com.impacta.room.data.local.dao

import androidx.room.*
import br.com.impacta.room.data.models.Comida

@Dao
interface ComidaDao {

    @Insert
    suspend fun inserir(comida:Comida)

    @Update
    suspend fun atualizar(comida: Comida)

    @Delete
    suspend fun deletar(comida: Comida)

    @Query("SELECT * FROM comida")
    suspend fun buscarTodas(): List<Comida>

    @Query("SELECT * FROM comida WHERE id = :id")
    suspend fun buscarComidaPorId(id: Int): Comida

}