package br.com.impacta.room.data.repositories

import br.com.impacta.room.data.local.database.AppDatabase
import br.com.impacta.room.data.models.Comida

class ComidaRepository(private val appDatabase: AppDatabase) {

    private val comidaDao = appDatabase.comidaDao()

    suspend fun inserir(comida: Comida) {
        comidaDao.inserir(comida)
    }

    suspend fun atualizar(comida: Comida) {
        comidaDao.atualizar(comida)
    }

    suspend fun deletar(comida: Comida) {
        comidaDao.deletar(comida)
    }

    suspend fun buscarTodas(): List<Comida> {
        return comidaDao.buscarTodas()
    }

    suspend fun buscarComidaPorId(id: Int): Comida {
        return comidaDao.buscarComidaPorId(id)
    }

}