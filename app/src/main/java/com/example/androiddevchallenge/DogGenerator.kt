/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import java.util.Date
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit

object DogGenerator {

    private val dogNames = listOf(
        "Charlie",
        "Max",
        "Buddy",
        "Oscar",
        "Milo",
        "Archie",
        "Ollie",
        "Toby",
        "Jack",
        "Teddy",
        "Bella",
        "Molly",
        "Coco",
        "Ruby",
        "Lucy",
        "Bailey",
        "Daisy",
        "Rosie",
        "Lola",
        "Frankie",
        "Abigail",
        "Abe",
        "Ada",
        "Albert",
        "Addy",
        "Alexander",
        "Adelaide",
        "Bernadette",
        "Clara",
        "Daniel",
        "Clarabelle",
        "Darius",
        "Clarissa",
        "Davis",
        "Clementine",
        "Davy",
        "Cleo",
        "Dexter",
        "Coco",
        "Dixon",
        "Constance",
        "Domingo",
        "Cora",
        "Donnie",
        "Coral",
        "Earl",
        "Daisy",
        "Easton",
        "Darlene",
        "Edger",
        "Delilah",
        "Edison",
        "Dolores",
        "Edmund",
        "Doris",
        "Edward",
        "Dorothea",
        "Jasper",
        "Hedy",
        "Jefferson",
        "Helen",
        "John",
        "Holly",
        "Jonas",
        "Ida",
        "Joseph",
        "Irene",
        "Kendrick",
        "Iris",
        "Kent",
        "Isabella",
        "Lambert",
        "Isadora",
        "Lance",
        "Ivy",
        "Lane",
        "Jacqueline",
        "Langston",
        "Jane",
        "Lawrence",
        "Joan",
        "Lemuel",
        "Jocelyn",
        "Leo",
        "Josephine",
        "Leonard",
        "Joy",
        "Leroy",
        "Joyce",
        "Lewis",
        "Judith",
        "Liam",
        "Julia",
        "Lincoln",
        "Juliana",
        "Llewellyn",
        "June",
        "Luther",
        "Katherine",
        "Mack",
        "Kay",
        "Maguire",
        "Kitty",
        "Malcolm",
        "Lady",
        "Martin",
        "Lassie",
        "Mason",
        "Layne",
        "Maverick",
        "Leona",
        "Max",
        "Lila",
        "Maximilian",
        "Lilibeth",
        "Maxwell",
        "Lillian",
        "McKinley",
        "Lily",
        "Mercer",
        "Lizette",
        "Meyer",
        "Lois",
        "Michael",
        "Lola",
        "Milburn",
        "Loretta",
        "Miles",
        "Lorraine",
        "Miller",
        "Louisa",
        "Milo",
        "Louise",
        "Milton",
        "Lucia",
        "Monroe",
        "Lucille",
        "Morton",
        "Lucinda",
        "Murphy",
        "Lucy",
        "Murray",
        "Luella",
        "Napoleon",
        "Lula",
        "Nelson",
        "Mabel",
        "Newton",
        "Madeline",
        "Niles",
        "Mae",
        "Norman",
        "Maisie",
        "Norris",
        "Mamie",
        "Oakley",
        "Mara",
        "Oliver",
        "Margaret",
        "Orson",
        "Marge",
        "Oscar",
        "Marianne",
        "Otis",
        "Marilyn",
        "Otto",
        "Marjorie",
        "Overton",
        "Maryella",
        "Owen",
        "Matilda",
        "Park",
        "Maude",
        "Parker",
        "Maura",
        "Parley",
        "May",
        "Percival",
        "Mazie",
        "Percy",
        "Melanie",
        "Phillip",
    )

    private fun generateDogs(): Map<Int, Dog> {
        return (0..10).map {
            it to generateDog(it)
        }.toMap()
    }

    val dogs: Map<Int, Dog> = generateDogs()

    private fun generateDog(id: Int): Dog {
        val currentTime = System.currentTimeMillis()
        return Dog(
            id,
            generateAge(
                Date(currentTime - TimeUnit.DAYS.toMillis(365 * 4)),
                Date(currentTime - TimeUnit.DAYS.toMillis(28))
            ),
            generateRandomName(),
            generateRandomBreed(),
            generateRandomSex()
        )
    }

    private fun generateAge(from: Date, to: Date): String {
        val random = ThreadLocalRandom.current().nextLong(from.time, to.time)
        val birthday = Date(random)
        val ageInDays = TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - birthday.time)
        return when {
            ageInDays < 31 -> "$ageInDays days"
            ageInDays < 350 -> "${ageInDays / 31} months"
            ageInDays < 700 -> "1 year"
            else -> "${ageInDays / 350} years"
        }
    }

    private fun generateRandomName(): String {
        return dogNames.random()
    }

    private fun generateRandomBreed(): Breed {
        return Breed.values().random()
    }

    private fun generateRandomSex(): Sex {
        return Sex.values().random()
    }
}
