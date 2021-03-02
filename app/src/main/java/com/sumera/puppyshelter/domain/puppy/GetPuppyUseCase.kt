package com.sumera.puppyshelter.domain.puppy

import com.sumera.puppyshelter.data.store.PuppyStore
import com.sumera.puppyshelter.domain.base.UseCase
import com.sumera.puppyshelter.ui.data.Puppy

class GetPuppyUseCase : UseCase<String, Puppy>() {
    override suspend fun create(args: String): Puppy {
        return PuppyStore.puppies.find { it.id == args } ?: error("Unexpected state")
    }
}
