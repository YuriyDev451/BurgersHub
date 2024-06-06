package com.gukunov.burgershub.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gukunov.burgershub.common.Resource
import com.gukunov.burgershub.common.State
import com.gukunov.burgershub.domain.entity.BurgerItem
import com.gukunov.burgershub.domain.entity.BurgerResponse
import com.gukunov.burgershub.domain.uiModel.BurgerUIState
import com.gukunov.burgershub.domain.uiModel.mapper.BurgersToUIStateMapper
import com.gukunov.burgershub.domain.useCase.GetBurgerListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BurgerListViewModel @Inject constructor(
    private val getBurgerListUseCase: GetBurgerListUseCase,
    //private val mapper: BurgersToUIStateMapper
) : ViewModel() {
    val state: MutableStateFlow<State?> = MutableStateFlow(null)

    val burgers: MutableStateFlow<List<BurgerItem>?> = MutableStateFlow(null)


//    private var _burgers = MutableLiveData<List<BurgerItem>?>()
//    val burgers: LiveData<List<BurgerItem>?> = _burgers

    init {
        getBurgerList()
    }

    private fun getBurgerList() {
        viewModelScope.launch {
            getBurgerListUseCase.execute().collectLatest { burger ->
                when(burger){
                    is Resource.Error ->state.emit(State.error(burger.message))
                    is Resource.Loading ->state.emit(State.loading())
                    is Resource.Success ->{
                        state.emit(State.success())
                        burger.data.let {
                            //val result = it?.let { it1 -> mapper.map(it1) }
                            burgers.emit(it)
                        }
                    }
                }

//                val result = mapper.map(burger.data!!)
//               // _burgers.postValue(result)
//                _burgers.postValue(burger.data)
            }
        }
    }

}