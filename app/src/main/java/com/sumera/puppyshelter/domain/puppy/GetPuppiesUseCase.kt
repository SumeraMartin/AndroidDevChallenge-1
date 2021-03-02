package com.sumera.puppyshelter.domain.puppy

import com.sumera.puppyshelter.data.store.PuppyStore
import com.sumera.puppyshelter.domain.base.UseCase
import com.sumera.puppyshelter.tools.debug.randomError
import com.sumera.puppyshelter.ui.data.Breed
import com.sumera.puppyshelter.ui.data.Puppy
import kotlinx.coroutines.delay

class GetPuppiesUseCase : UseCase<Unit, List<Puppy>>() {

    override suspend fun create(args: Unit): List<Puppy> {
//        delay(2000)
//        randomError()

        return PuppyStore.puppies
    }
}