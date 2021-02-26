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

import java.util.Locale

data class Dog(
    val id: Int,
    val age: String,
    val name: String,
    val breed: Breed,
    val sex: Sex
)

enum class Breed {
    LABRADOR_RETRIEVER,
    GERMAN_SHEPHERD,
    GOLDEN_RETRIEVER,
    FRENCH_BULLDOG,
    BULLDOG,
    POODLE,
    BEAGLE,
    ROTTWEILER,
    GERMAN_SHORTHAIRED_POINTER,
    PEMBROKE_WELSH_CORGI,
    DACHSHUND,
    YORKSHIRE_TERRIER,
    AUSTRALIAN_SHEPHERD,
    BOXER,
    SIBERIAN_HUSKY;

    fun asString(): String {
        return this.name.toLowerCase(Locale.getDefault()).replace('_', ' ')
    }
}

enum class Sex {
    MALE,
    FEMALE;

    fun asString(): String {
        return this.name.toLowerCase(Locale.getDefault())
    }
}
