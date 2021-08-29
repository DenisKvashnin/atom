import json
import html as classic_html
import logging
import re
import sys

from lxml import html
from lxml import etree
import requests


class RaexParser():
    """
    Парсер Raex-rr.com
    """
    def __init__(self) -> None:
        """
        Создание нового объекта парсера
        """
        self.headers = {
            'authority': 'raex-rr.com',
            'pragma': 'no-cache',
            'cache-control': 'no-cache',
            'sec-ch-ua': '"Chromium";v="92", " Not A;Brand";v="99", "Google Chrome";v="92"',
            'sec-ch-ua-mobile': '?0',
            'dnt': '1',
            'upgrade-insecure-requests': '1',
            'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36',
            'accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9',
            'sec-fetch-site': 'cross-site',
            'sec-fetch-mode': 'navigate',
            'sec-fetch-user': '?1',
            'sec-fetch-dest': 'document',
            'accept-language': 'ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7',
            'sec-gpc': '1'
        }
        # url = 'https://raex-rr.com/education/universities/rating_of_universities_of_russia'
        self.result = {}

        logging.basicConfig(filename='app_raex.log', filemode='a', level=logging.DEBUG, format='[%(levelname)s]%(asctime)s - %(message)s', datefmt='%d-%m-%YT%H:%M:%SZ%z')
        logging.debug('Создан объект парсера RAEX')

    def get(self, url:str) -> None:
        """
        Получение рейтинга
        """
        self.result.clear()
        self.result = {}
        edu_pos = []
        edu_name = []

        self.response = requests.get(url, headers=self.headers, timeout=1)

        page_code = html.fromstring(self.response.text)

        edu_pos_result = page_code.xpath('//*[@id="carouselExampleIndicators"]/div/div[*]/div[1]/div/span[2]') # Позиции
        if not edu_pos_result:
            logging.error('Не удалось получить рейтинг учебных заведений')
            sys.exit(0)
        for element in edu_pos_result:
            e = etree.tostring(element).decode('utf-8')
            edu_pos.append(e)

        edu_name_result = page_code.xpath('//*[@id="carouselExampleIndicators"]/div/div[*]/div[3]/div/h3/a') # Названия
        if not edu_name_result:
            logging.error('Не удалось получить названия учебных заведений')
            sys.exit(0)
        for element in edu_name_result:
            e = etree.tostring(element).decode('utf-8')
            edu_name.append(e)

        for x in range(len(edu_pos_result)):
            current_edu = re.sub(r'\<[^>]*\>', '', etree.tostring(edu_name_result[x]).decode('utf-8'))
            self.result[x+1] = classic_html.unescape(current_edu)
        logging.info('Рейтинг успешно получен')
        # print(self.result)

    def save_json(self, filename:str) -> None:
        """
        Запись рейтинга в выходной json файл
        """
        with open(filename, "w", encoding='utf-8') as write_file:
            json.dump(self.result, write_file, indent=4)
        logging.info(f'Результат записан в файл {filename}')

r = RaexParser()
r.get('https://raex-rr.com/education/universities/rating_of_universities_of_russia')
r.save_json("uni.json")
r.get('https://raex-rr.com/education/schools/russian_schools/rating_of_schools_by_graduates_competitiveness')
r.save_json("sch.json")
