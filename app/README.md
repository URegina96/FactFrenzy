`Fact Frenzy` — это Android-приложение, которое позволяет пользователям получать случайные факты через удобный интерфейс. Приложение использует API для извлечения случайных фактов и имеет возможность автоматически обновлять информацию через заданные интервалы времени. Пользователи могут управлять обновлением фактов с помощью кнопки.

## Функциональность
- Получение случайного факта из [Useless Facts API](https://uselessfacts.jsph.pl/).
- Автоматическое обновление фактов каждые 5 секунд (можно отключить).
- Интуитивно понятный пользовательский интерфейс с использованием Material Design.

## Стек технологий
- **Kotlin**: основной язык программирования.
- **Android Jetpack**: использование компонентов таких как ViewModel и LiveData для управления состоянием и UI.
- **Coroutines**: для обработки асинхронных задач и управления потоками.
- **Retrofit**: для выполнения HTTP-запросов к API и обработки JSON-ответов.
- **Material Design**: для создания современного и удобного интерфейса.

## Архитектура

### Основные классы
1. **MainActivity**: Главный экран приложения, содержащий интерфейс для отображения фактов и кнопку для управления обновлением фактов.
2. **FactViewModel**: ViewModel для управления состоянием приложения и извлечения фактов из API.
3. **RandomFact**: Класс данных для структурирования фактов, полученных из API.
4. **ApiService**: Интерфейс для определения методов доступа к API.

### Компоненты UI
- `CoordinatorLayout`: основной контейнер для UI-элементов.
- `CardView`: используется для отображения факта с эффектом тени и закругленными углами.
- `TextView`: элемент для отображения текста факта.
- `Button`: для управления обновлением фактов; меняет свое состояние в зависимости от действия пользователя.

## Установка
1. Склонируйте репозиторий:
   ```bash
   git clone https://github.com/username/fact-frenzy.git
   ```
2. Откройте проект в Android Studio.
3. Запустите Gradle синхронизацию.
4. Запустите приложение на эмуляторе или устройстве.

## Системные требования
- Android SDK 24 (Nougat) или выше.
- Android Studio.

## Важные зависимости
```kotlin
dependencies {
    implementation("androidx.core:core-ktx:1.12.0") // Core библиотеки
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2") // ViewModel
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2") // LiveData
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3") // Корутины
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3") // Корутины для Android
    implementation("com.squareup.retrofit2:retrofit:2.10.0") // Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.10.0") // Gson конвертер
    implementation("com.google.android.material:material:1.12.0") // Material Design
    implementation("androidx.appcompat:appcompat:1.7.0") // Поддержка старых версий
}
```

