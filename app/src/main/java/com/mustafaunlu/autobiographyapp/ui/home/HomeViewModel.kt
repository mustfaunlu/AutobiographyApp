package com.mustafaunlu.autobiographyapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafaunlu.autobiographyapp.data.NetworkResponse
import com.mustafaunlu.autobiographyapp.data.models.Person
import com.mustafaunlu.autobiographyapp.data.repository.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val personRepository: PersonRepository) :
    ViewModel() {

    private val _personData = MutableLiveData<NetworkResponse<Person>>()
    val personData: LiveData<NetworkResponse<Person>>
        get() = _personData

    init {
        getPersonData()
    }

    private fun getPersonData() {
        viewModelScope.launch {
            personRepository.getPerson().collect { response ->
                when (response) {
                    is NetworkResponse.Success -> {
                        Log.i("HomeViewModel", "getPersonData: ${response.result}")
                        _personData.value = response
                    }
                    is NetworkResponse.Error -> {
                        NetworkResponse.Error(response.exception)
                    }
                    is NetworkResponse.Loading -> {
                        NetworkResponse.Loading
                    }
                }
            }
        }
    }
}
