package com.mobwaysolutions.appdi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val _errorTitulo = MutableLiveData<String?>()
    val errorTitulo: LiveData<String?> = _errorTitulo

    private val _errorPreco = MutableLiveData<String?>()
    val errorPreco: LiveData<String?> = _errorPreco

    private val _statusTela = MutableLiveData<MainInteractions>()
    val statusTela: LiveData<MainInteractions> = _statusTela


    fun saveService(entity: ServicoEntity) {
        _statusTela.value = MainInteractions.Loading
        if (validateValues(entity)) {
            mainRepository.inserir(entity)
            _statusTela.value = MainInteractions.Success
        } else {
            _statusTela.value = MainInteractions.Error(
                "Erro desconhecido",
                Exception("Erro ao tentar se conectar ao server")
            )
        }
    }

    private fun validateValues(entity: ServicoEntity): Boolean {
        _errorTitulo.value = null
        _errorPreco.value = null
        if (entity.titulo?.isEmpty() == true) {
            _errorTitulo.value = "Titulo invalido"
            return false
        }
        if (entity.preco?.isEmpty() == true) {
            _errorPreco.value = "Preço invalido"
            return false
        }
        return true
    }


}