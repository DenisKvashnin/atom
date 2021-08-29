from itertools import cycle
import logging
import os


class Proxy():

    def __init__(self) -> None:
        self._proxy_list = []
        self._proxy_cycle = cycle(self._proxy_list)

    def get_list_from_net(self) -> None:
        # https://www.proxy-list.download/api/v1/get?type=http&country=RU
        # https://proxylist.geonode.com/api/proxy-list?limit=50&page=1&sort_by=lastChecked&sort_type=desc&country=RU&protocols=http%2Chttps
        # https://www.proxyscan.io/api/proxy?last_check=9800&country=ru&uptime=50&ping=2500&limit=10&type=http,https
        ...
        self._proxy_cycle = cycle(self._proxy_list)

    def get_list_from_file(self) -> None:
        """
        Получение списка прокси из файла
        """
        try:
            with open('proxy_list.txt', 'r', encoding='utf-8') as f:
                self._proxy_list = [c.replace('\r', '').replace('\n', '') for c in f.readlines() if len(c) > 4]
        except FileNotFoundError:
            print('Файл с прокси не найден. Создайте proxy_list.txt')
        self._proxy_cycle = cycle(self._proxy_list)

    def get(self) -> str:
        """
        Получение нового прокси
        В процессе выполняется проверка работоспособности прокси, что может занимать время (3 сек/шт).
        `return` - строка вида IP:PORT
        """
        if len(self._proxy_list) > 0:
            try:
                response = 1
                while response != 0:
                    proxy = next(self._proxy_cycle)
                    response = os.system('ping -c 1 -w3 ' + proxy + ' > /dev/null 2>&1') # пингуем прокси, вдруг лежит
                    return {
                    "http": proxy,
                    "https": proxy
                    }
            except StopIteration:
                logging.error('Список новых прокси пуст. Возврат в начало.')
                print('Список новых прокси пуст. Возврат в начало.')
                self._proxy_cycle = cycle(self._proxy_list)
        return {
        "http": '',
        "https": ''
        } # Надо что-то другое вернуть
