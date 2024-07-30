package com.example.smartlab.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartlab.api.Repository
import com.example.smartlab.api.Result
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ViewModelMain(private val repository: Repository): ViewModel() {

    var codeBoolean by mutableStateOf(false)
    //Каналы данных
    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()
    fun sendCodeToEmail(email:String)
    {
        viewModelScope.launch {
            repository.sendCodeEmail(email).collect{
                when(it) {
                    /** Instanceof (is) - это оператор на языке java, здесь, в Kotlin, мы использовали is и !
                    это ключевые слова для выполнения операций, таких как instanceof,
                    то есть тип свойства доступен или нет, это функция, подобная способу проверки типа,
                    для проверки типа конкретного экземпляра или других различных переменных во время выполнения,
                    для разделения рабочего процесса.*/
                    is com.example.smartlab.api.Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }
                    is com.example.smartlab.api.Result.Success -> {
                        _showErrorToastChannel.send(false)
                    }
                }
            }
        }
    }
    fun SignIn(email: String, code: String) {
        viewModelScope.launch {
            repository.signInCode(email, code).collect {
                when (it) {
                    is Result.Error -> {
                       codeBoolean = false
                    }

                    is Result.Success -> {
                        codeBoolean = true
                    }
                }
            }
        }
    }
}