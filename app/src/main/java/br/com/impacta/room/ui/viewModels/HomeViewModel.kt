package br.com.impacta.room.ui.viewModels

import androidx.lifecycle.*
import br.com.impacta.room.data.local.database.AppDatabase
import br.com.impacta.room.data.models.Comida
import br.com.impacta.room.data.repositories.ComidaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(appDatabase: AppDatabase): ViewModel() {

    private val _listaComida: MutableLiveData<List<Comida>> = MutableLiveData(listOf())
    val listaComida: LiveData<List<Comida>> = _listaComida
    private val _comida: MutableLiveData<Comida?> = MutableLiveData(null)
    val comida: LiveData<Comida?> = _comida

    private val repository: ComidaRepository = ComidaRepository(appDatabase)

    fun getComidas() {
        viewModelScope.launch(Dispatchers.IO) {
            _listaComida.postValue(repository.buscarTodas())
        }
    }

    fun criarComida(comida: Comida) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.inserir(comida)
        }
    }

    fun recuperaComida(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
           _comida.postValue(repository.buscarComidaPorId(id))
        }
    }

    fun atualizaComida(comida: Comida) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.atualizar(comida)
        }
    }

    fun deletaComida(comida: Comida) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletar(comida)
        }
    }

}

class HomeViewModelFactory(private val appDatabase: AppDatabase): ViewModelProvider.Factory {
     override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(appDatabase) as T
        }
        throw IllegalArgumentException()
    }
}