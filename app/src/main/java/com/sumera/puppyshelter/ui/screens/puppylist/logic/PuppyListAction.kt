package com.sumera.puppyshelter.ui.screens.puppylist.logic

import com.sumera.puppyshelter.coreactor.action.Action
import com.sumera.puppyshelter.ui.data.Breed
import com.sumera.puppyshelter.ui.data.Puppy
import com.sumera.puppyshelter.ui.screens.puppylist.logic.state.PuppyListState

sealed class PuppyListAction : Action<PuppyListState>

data class OnBreedFilterToggleAction(val breed: Breed) : PuppyListAction()

data class OnPuppyClickedAction(val puppy: Puppy) : PuppyListAction()

object OnTryAgainClickAction : PuppyListAction()
