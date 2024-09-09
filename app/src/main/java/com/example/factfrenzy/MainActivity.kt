package com.example.factfrenzy // Определяем пакет

import android.os.Bundle // Импортируем класс для работы с жизненным циклом Activity
import android.widget.Button // Импортируем класс для работы с кнопками
import android.widget.TextView // Импортируем класс для работы с текстовыми полями
import androidx.activity.viewModels // Импортируем для получения ViewModel
import androidx.appcompat.app.AppCompatActivity // Импортируем базовый класс для Activity
import kotlinx.coroutines.* // Импортируем корутины для работы с асинхронным кодом

class MainActivity : AppCompatActivity() { // Определяем класс MainActivity, наследующий AppCompatActivity

    private val viewModel: FactViewModel by viewModels() // Инициализируем ViewModel для управления состоянием
    private var isUpdatingFacts: Boolean = true // Переменная для управления циклом обновления фактов
    private lateinit var job: Job // Переменная для хранения корутины

    override fun onCreate(savedInstanceState: Bundle?) { // Переопределяем метод onCreate
        super.onCreate(savedInstanceState) // Вызываем метод родительского класса
        setContentView(R.layout.activity_main) // Устанавливаем разметку для этой Activity

        val factTextView: TextView = findViewById(R.id.factTextView) // Находим TextView по ID
        val updateButton: Button = findViewById(R.id.updateButton) // Находим кнопку по ID

        // Наблюдаем за изменениями в factText и обновляем TextView при изменении
        viewModel.factText.observe(this) {
            factTextView.text = it // Устанавливаем полученный текст в TextView
        }

        viewModel.getRandomFact() // Получаем первый факт сразу при запуске

        job = CoroutineScope(Dispatchers.Main).launch { // Создаем корутину на главном потоке
            while (isUpdatingFacts) { // Запускаем бесконечный цикл, пока isUpdatingFacts == true
                delay(5000) // Задержка на 5 секунд перед обновлением факта
                viewModel.getRandomFact() // Запрашиваем новый факт
            }
        }

        // Устанавливаем слушатель нажатий для кнопки
        updateButton.setOnClickListener {
            // Переключаем состояние обновления фактов и изменяем текст кнопки
            isUpdatingFacts = !isUpdatingFacts
            updateButton.text = if (isUpdatingFacts) "Остановить обновление" else "Возобновить обновление"
        }
    }

    override fun onDestroy() { // Переопределяем метод onDestroy
        super.onDestroy() // Вызываем метод родительского класса
        job.cancel() // Отменяем корутину при уничтожении Activity
    }
}