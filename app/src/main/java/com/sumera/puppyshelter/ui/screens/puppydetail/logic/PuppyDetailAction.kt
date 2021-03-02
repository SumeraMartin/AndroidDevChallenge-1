package com.sumera.puppyshelter.ui.screens.puppydetail.logic

import com.sumera.puppyshelter.coreactor.action.Action

sealed class PuppyDetailAction : Action<PuppyDetailState>

object BackButtonClickedAction : PuppyDetailAction()
