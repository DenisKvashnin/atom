# Парсеры Rusprofile и RAEX

Получение сведений об образовательных организациях по ОКВЭД 2 85 с сайта [Rusprofile](https://www.rusprofile.ru/codes/850000), а также ТОП-100 вузов и школ с сайта RAEX.

Итогом работы является создание файла с расширением `csv`, в котором
будут собраны образовательные организации и данные о них.


## Установка и запуск

Требуется установленный интерпретатор языка *Python 3*.

### Настройка окружения

Находясь в корневой директории проекта выполнить в терминале следующие команды:

**Linux:**

```bash
python3 -m venv env
. env/bin/activate
pip install -r requirements.txt
```

**Windows**

```cmd
python -m venv env
env\Scripts\activate
pip install -r requirements.txt
```

### Запуск

Собрать данные с Rusprofile

```bash
python main.py
```

Собрать данные с RAEX

```bash
python raex.py
```

## Пример CSV

🚧WIP🚧

