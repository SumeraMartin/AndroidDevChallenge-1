package com.sumera.puppyshelter.ui.screens.puppylist.logic

import com.sumera.puppyshelter.coreactor.CoreactorViewModel
import com.sumera.puppyshelter.coreactor.log.impl.ConsoleLogger
import com.sumera.puppyshelter.data.base.Result
import com.sumera.puppyshelter.domain.puppy.GetPuppiesUseCase
import com.sumera.puppyshelter.ui.data.Breed
import com.sumera.puppyshelter.ui.data.Puppy
import com.sumera.puppyshelter.ui.data.generic.LoadingState
import com.sumera.puppyshelter.ui.navigation.Navigator
import com.sumera.puppyshelter.ui.screens.puppylist.logic.reducers.ToggleBreedFilterReducer
import com.sumera.puppyshelter.ui.screens.puppylist.logic.state.PuppyListState
import kotlinx.coroutines.launch

class PuppyListCoreactor : CoreactorViewModel<PuppyListState, PuppyListAction>() {

    private val getPuppiesUseCase = GetPuppiesUseCase()

    override val initialState = PuppyListState.DEFAULT

    override val logger = ConsoleLogger<PuppyListState>(tag = "PuppyListCoreactor")

    var navigator: Navigator? = null

    override fun onCreate() {
        launch {
            loadPuppies()
        }
    }

    override fun onAction(action: PuppyListAction) {
        launch {
            when (action) {
                OnTryAgainClickAction -> loadPuppies()
                is OnBreedFilterToggleAction -> toggleFilterForBreed(action.breed)
                is OnPuppyClickedAction -> navigateToPuppyDetail(action.puppy)
            }
        }
    }
    
    private suspend fun toggleFilterForBreed(breed: Breed) {
        emit(ToggleBreedFilterReducer(breed))
    }

    private suspend fun navigateToPuppyDetail(puppy: Puppy) {
        navigator?.navigateToPuppyDetail(puppy.id) ?: error("Missing navigator")
    }

    private suspend fun loadPuppies() {
        emitReducer { it.copy(puppiesState = LoadingState.Loading) }

        when (val result = getPuppiesUseCase.execute(Unit)) {
            is Result.Success -> {
                emitReducer { it.copy(puppiesState = LoadingState.Success(result.data)) }
            }
            is Result.Error -> {
                emitReducer { it.copy(puppiesState = LoadingState.Error(result.error)) }
            }
        }
    }
}