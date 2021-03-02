package com.sumera.puppyshelter.data.store

import com.sumera.puppyshelter.ui.data.Breed
import com.sumera.puppyshelter.ui.data.Puppy

object PuppyStore {

    private const val puppyDescription = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like). Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like). Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."

    val puppies = listOf(
        Puppy(
            id = "0",
            name = "Little tommy",
            breed = Breed.POODLE,
            imageUrl = "https://i2.wp.com/readysetpuppy.com/wp-content/uploads/2019/09/How-to-Prepare-your-House-for-the-Arrival-of-a-New-Poodle-Puppy.jpg?fit=1000%2C669&ssl=1",
            ageWeeks = 8,
            distanceKm = 2.2f,
            description = puppyDescription,
        ),
        Puppy(
            id = "1",
            name = "Charlie",
            breed = Breed.POODLE,
            imageUrl = "https://www.thevetonfourth.com/wp-content/uploads/2020/06/Poodle-Puppy.jpg",
            ageWeeks = 13,
            distanceKm = 15.8f,
            description = puppyDescription,
        ),
        Puppy(
            id = "2",
            name = "Teddy",
            breed = Breed.GOLDEN_RETRIEVER,
            imageUrl = "https://marshallspetzone.com/blog/wp-content/uploads/2017/01/6.jpg",
            ageWeeks = 20,
            distanceKm = 1.8f,
            description = puppyDescription,
        ),
        Puppy(
            id = "3",
            name = "max",
            breed = Breed.GERMAN_SHEPHERD,
            imageUrl = "https://www.petshopsguide.com/wp-content/uploads/training-a-German-shepherd-puppy-1024x683.jpeg",
            ageWeeks = 7,
            distanceKm = 1.8f,
            description = puppyDescription,
        ),
        Puppy(
            id = "4",
            name = "Coco",
            breed = Breed.BULLDOG,
            imageUrl = "https://www.purina.com.au/-/media/project/purina/main/breeds/puppies/puppy-bulldog.jpg",
            ageWeeks = 15,
            distanceKm = 9.8f,
            description = puppyDescription,
        ),
        Puppy(
            id = "5",
            name = "Ruby",
            breed = Breed.BEAGLE,
            imageUrl = "https://www.pets4homes.co.uk/images/articles/5458/large/ten-things-you-need-to-know-about-the-beagle-dog-breed-before-you-buy-one-5d1a406d6ab2a.jpg",
            ageWeeks = 9,
            distanceKm = 45.6f,
            description = puppyDescription,
        ),
        Puppy(
            id = "6",
            name = "Oscar",
            breed = Breed.PUG,
            imageUrl = "https://blog.mystart.com/wp-content/uploads/MyWhippet_5df7b31c9b09fde2703fbe2c-1-e1587412238178.jpeg",
            ageWeeks = 13,
            distanceKm = 23.6f,
            description = puppyDescription,
        ),
        Puppy(
            id = "7",
            name = "Milo",
            breed = Breed.DOGE,
            imageUrl = "https://i.kym-cdn.com/entries/icons/original/000/013/564/doge.jpg",
            ageWeeks = 8,
            distanceKm = 23f,
            description = puppyDescription,
        ),
        Puppy(
            id = "8",
            name = "Ollie",
            breed = Breed.POINTER,
            imageUrl = "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/01132221/Pointer-puppy-in-a-field.jpg",
            ageWeeks = 4,
            distanceKm = 10f,
            description = puppyDescription,
        ),
    )
}
