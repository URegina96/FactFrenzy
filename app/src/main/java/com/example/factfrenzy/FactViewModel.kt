package com.example.factfrenzy // Определяем пакет

import androidx.lifecycle.LiveData // Импортируем класс для работы с LiveData
import androidx.lifecycle.MutableLiveData // Импортируем класс для работы с изменяемой LiveData
import androidx.lifecycle.ViewModel // Импортируем класс ViewModel
import retrofit2.Call // Импортируем интерфейс для вызодов API
import retrofit2.Callback // Импортируем интерфейс для обработки асинхронных ответов
import retrofit2.Retrofit // Импортируем класс для создания Retrofit
import retrofit2.converter.gson.GsonConverterFactory // Импортируем конвертер для работы с JSON

class FactViewModel : ViewModel() { // Определяем класс ViewModel

    private val _factText = MutableLiveData<String>() // Создаем изменяемую LiveData для хранения текста факта
    val factText: LiveData<String> get() = _factText // Создаем доступ к факту как LiveData

    private val apiService: ApiService // Объявляем переменную для API сервиса

    init { // Конструктор инициализации
        val retrofit = Retrofit.Builder() // Создаем объект Retrofit
            .baseUrl("https://uselessfacts.jsph.pl/") // Устанавливаем базовый URL
            .addConverterFactory(GsonConverterFactory.create()) // Устанавливаем конвертер для JSON
            .build() // Создаем объект Retrofit

        apiService = retrofit.create(ApiService::class.java) // Создаем экземпляр API сервиса
    }

    fun getRandomFact() { // Функция для получения случайного факта
        apiService.getRandomFact().enqueue(object : Callback<RandomFact> { // Вызываем API и устанавливаем Callback
            override fun onResponse(call: Call<RandomFact>, response: retrofit2.Response<RandomFact>) { // Обрабатываем ответ
                if (response.isSuccessful) { // Проверяем успешность ответа
                    _factText.postValue(response.body()?.text ?: "Факты отсутствуют") // Обновляем текст факта
                } else {
                    _factText.postValue("Ошибка при извлечении факта") // Сообщаем об ошибке
                }
            }

            override fun onFailure(call: Call<RandomFact>, t: Throwable) { // Обрабатываем ошибку сети
                _factText.postValue("Сбой сети") // Сообщаем о сбое сети
            }
        })
    }
}