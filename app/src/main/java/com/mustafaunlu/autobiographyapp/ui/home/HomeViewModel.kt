package com.mustafaunlu.autobiographyapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafaunlu.autobiographyapp.data.NetworkResponse
import com.mustafaunlu.autobiographyapp.data.models.Person
import com.mustafaunlu.autobiographyapp.data.repository.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class ProgressBarState {
    LOADING,
    SUCCESS,
    ERROR,
}

@HiltViewModel
class HomeViewModel @Inject constructor(private val personRepository: PersonRepository) :
    ViewModel() {

    private val _personData = MutableLiveData<NetworkResponse<Person>>()
    val personData: LiveData<NetworkResponse<Person>>
        get() = _personData

    private val _progressBarState = MutableLiveData<ProgressBarState>()
    val progressBarState: LiveData<ProgressBarState>
        get() = _progressBarState

    init {
        getPersonData()
    }

    private fun getPersonData() {
        viewModelScope.launch(Dispatchers.IO) {
            personRepository.getPerson().collect { response ->
                when (response) {
                    is NetworkResponse.Loading -> {
                        _progressBarState.postValue(ProgressBarState.LOADING)
                        NetworkResponse.Loading
                    }
                    is NetworkResponse.Success -> {
                        _progressBarState.postValue(ProgressBarState.SUCCESS)
                        _personData.postValue(response)
                    }
                    is NetworkResponse.Error -> {
                        _progressBarState.postValue(ProgressBarState.ERROR)
                        NetworkResponse.Error(response.exception)
                    }
                }
            }
        }
    }
}
