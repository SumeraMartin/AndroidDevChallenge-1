package com.sumera.puppyshelter.ui.screens.puppydetail.logic

import com.sumera.puppyshelter.coreactor.CoreactorViewModel
import com.sumera.puppyshelter.coreactor.log.impl.ConsoleLogger
import com.sumera.puppyshelter.data.base.Result
import com.sumera.puppyshelter.domain.puppy.GetPuppyUseCase
import com.sumera.puppyshelter.ui.data.Puppy
import com.sumera.puppyshelter.ui.navigation.Navigator
import kotlinx.coroutines.launch

class PuppyDetailCoreactor : CoreactorViewModel<PuppyDetailState, PuppyDetailAction>() {

    private val getPuppiesUseCase = GetPuppyUseCase()

    override val initialState = PuppyDetailState.DEFAULT

    override val logger = ConsoleLogger<PuppyDetailState>(tag = "PuppyDetailCoreactor")

    lateinit var navigator: Navigator

    lateinit var puppyId: String

    override fun onCreate() {
        launch {
            loadPuppy()
        }
    }

    override fun onAction(action: PuppyDetailAction) {
        when (action) {
            BackButtonClickedAction -> navigateBack()
        }
    }

    private suspend fun loadPuppy() {
        val result = getPuppiesUseCase.execute(puppyId)
        val puppy = (result as Result.Success<Puppy>).data
        emitReducer { it.copy(puppy = puppy) }
    }

    private fun navigateBack() {
        navigator.navigateBack()
    }
}