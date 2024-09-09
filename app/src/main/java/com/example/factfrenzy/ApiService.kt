package com.example.factfrenzy // Определяем пакет

import retrofit2.Call // Импортируем интерфейс для вызоды API
import retrofit2.http.GET // Импортируем аннотацию для GET-запросов
import retrofit2.http.Query // Импортируем аннотацию для параметров запроса

interface ApiService { // Интерфейс для работы с API
    @GET("random.json") // Указываем путь к API
    fun getRandomFact( // Функция для получения случайного факта
        @Query("language") language: String = "en" // Параметр запроса для языка, по умолчанию английский
    ): Call<RandomFact> // Возвращаем вызов для RandomFact
}