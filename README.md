# Reflection-Based vs. No Reflection Validation in Java

## Автор

- Дяченко Данііл
- Група ІО-25

## Опис проєкту

Цей проект порівнює два підходи до валідації в Java: валідацію з використанням рефлексії та типізовану валідацію. Метою є демонстрація різниці в продуктивності та стилі реалізації між цими двома підходами.
У цьому проекті ми досліджуємо, як валідація з використанням рефлексії дозволяє перевіряти поля об'єкта динамічно під час виконання, і порівнюємо її з типізованою валідацією, де кожен клас перевіряє свої поля явно через логіку конструктора. 
Порівняння включає в себе метрики продуктивності, такі як час валідації.

## Ключові поняття
'Валідація з використанням рефлексії:' використовує рефлексію Java для динамічного огляду та валідації полів класу під час виконання, часто за допомогою анотацій.
'Типізована валідація:' залежить від логіки конструктора класу або явно написаних методів для валідації полів, забезпечуючи типову безпеку та перевірку під час компіляції.

## Основні класи

### `NotNull`

Анотація для перевірки, що поле не має бути `null`.

### `StringLength`

Анотація для перевірки довжини String. Приймає параметри:

- `min` — мінімальна довжина рядка (за замовчуванням `0`).
- `max` — максимальна довжина рядка (за замовчуванням `Integer.MAX_VALUE`).

### `MaxValue`

Анотація для перевірки, що значення числового поля не перевищує певного максимуму. Приймає параметр:

- `value` — максимальне значення.

### `MinValue`

Анотація для перевірки, що значення числового поля не менше певного мінімуму. Приймає параметр:

- `value` — мінімальне значення.

### `Validator`

Клас, що реалізує валідацію об'єктів через рефлексію. Перевіряє всі анотації, застосовані до полів об'єкта, і викликає відповідні методи валідації.

### Демонстраційні класи

1. **`Gamer`**  
   Поля:
    - `username`(тип: String, перевірка на null).
    - `age`(тип: int, перевірка на мінімальне значення 12 та максимальне значення 100).

2. **`Item`**  
   Поля:
    - `title`(тип: String, перевірка на null).
    - `description` (тип: String, перевірка на довжину від 3 до 100 символів).

3. **`Plane`** (без рефлексії)  
   Поля:
    - `model` (тип: String, перевірка на null та на довжину від 3 до 25 символів).
    - `year`(тип: int, перевірка на діапазон від 1970 до 2024 років).
  
### Типізовані класи

1. **`TypedGamer`**  
   Поля:
    - `username`(тип: String, перевірка на null).
    - `age`(тип: int, перевірка на мінімальне значення 12 та максимальне значення 100).

2. **`TypedItem`**  
   Поля:
    - `title`(тип: String, перевірка на null).
    - `description` (тип: String, перевірка на довжину від 3 до 100 символів).

3. **`TypedPlane`** (без рефлексії)  
   Поля:
    - `model` (тип: String, перевірка на null та на довжину від 3 до 25 символів).
    - `year`(тип: int, перевірка на діапазон від 1970 до 2024 років).

### Демонстраційний клас

Демонстраційний клас DemoExecution реалізує основну логіку порівняння двох підходів до валідації — через рефлексію і без неї. 
Клас надає приклад використання як рефлексивної валідації, так і типізованої валідації для трьох різних класів: Gamer, Item і Plane.

Основні кроки:

1. У методі main спочатку запускається валідація для класів через рефлексію за допомогою класу Validator.

2. Потім відбувається виконання тієї ж валідації, але без використання рефлексії, де кожен клас самостійно перевіряє свої поля в конструкторах.

3. У кінці виводяться результати порівняння часу виконання обох варіантів валідації.


## Продуктивність

Вимірюється час виконання для обох варіантів валідації (через рефлексію та без неї) і порівнюється, щоб показати накладні витрати на продуктивність при використанні рефлексії.

## Очікувані результати

Використання рефлексії для валідації має серйозні накладні витрати на продуктивність у порівнянні з традиційною статичною валідацією (як у типізованих класах), де перевірка полів здійснюється без використання рефлексії.
Проєкт демонструє різницю в часі виконання між валідацією через рефлексію та без неї.

# Як запустити проект

1. Клонувати репозиторій:
   ```bash
   git clone https://github.com/Daniil-Dyachenko/JavaAdvancedSoftwareLab1
   
2. Перейти в директорію проекту у кореневу папку
3. Виконати команди Maven для збірки проекту:
   ```bash
   mvn clean install
   mvn dependency:resolve
4. Запустити головний клас Main вручну через IDE, або виконати команду:
   ```bash
   mvn exec:java -Dexec.mainClass="org.example.DemoExecution"

# Вимоги до середовища

1.Java 11 або новіша версія.

2.Maven для управління залежностями та збіркою проєкту.
