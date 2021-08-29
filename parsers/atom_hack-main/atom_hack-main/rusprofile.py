import csv
import logging
from pprint import pprint
import sys

from lxml import etree
import requests

from proxy import Proxy


class RusprofileParser():
    """
    Парсер Rusprofile.ru
    """
    def __init__(self) -> None:
        """
        Создание нового объекта парсера
        """
        self.home_url = 'https://www.rusprofile.ru/codes/850000'
        self.headers = {
            'authority': 'www.rusprofile.ru',
            'pragma': 'no-cache',
            'cache-control': 'no-cache',
            'sec-ch-ua': '"Chromium";v="92", " Not A;Brand";v="99", "Google Chrome";v="92"',
            'sec-ch-ua-mobile': '?0',
            'dnt': '1',
            'upgrade-insecure-requests': '1',
            'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36',
            'accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9',
            'sec-fetch-site': 'same-origin',
            'sec-fetch-mode': 'navigate',
            'sec-fetch-user': '?1',
            'sec-fetch-dest': 'document',
            f'referer': '{self.home_url}',
            'accept-language': 'ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7',
            'cookie': 'screen_for_ad=desktop; sessid=cf15ea59c2662ac7d109c53701be6736', # hackathon style)))
            'sec-gpc': '1'
        }

        self._proxy = {}
        self.proxy = Proxy()
        self.proxy.get_list_from_file()

        self.page_count = 0
        self.org_count = 0

        self.to_csv = []

        self.url_gen = self.page_url_gen()

        self._client = requests.session()

        logging.basicConfig(filename='app.log', filemode='a', level=logging.DEBUG, format='[%(levelname)s]%(asctime)s - %(message)s', datefmt='%d-%m-%YT%H:%M:%SZ%z')
        logging.debug('Создан объект парсера')

    def get_page(self, url:str, headers:str) -> str:
        """
        Получение текста запрашиваемой страницы

        `return` - строка с html страницы
        """
        try:
            # res = '' # debug
            res = self._client.get(url, headers=headers, timeout=1, proxies=self._proxy)
        except requests.exceptions.TooManyRedirects:
            print('Слишком много редиректов при попытке получения данных.')
            print('Вероятная причина: проблемы с cookies')
            logging.warning(f'Слишком много редиректов. URL: {url}')
            return ''
        except (requests.exceptions.ConnectionError, requests.exceptions.ConnectTimeout):
            print('Проблемы с конектом (Connect Error, Connect Timeout).')
            logging.warning(f'Проблемы с конектом (Connect Error, Connect Timeout). URL: {url}')
            return ''
        except Exception as excptn:
            print(excptn)

        return res.text

    def get_stats(self):
        page = ''
        # page = self.get_page(self.home_url, self.headers)
        # with open('start.html', 'w', encoding='utf-8') as f:
        #     f.write(page)
        with open('start.html', 'r', encoding='utf-8') as f:
            page = f.read()
        try:
            html_page = etree.HTML(page)
            self.page_count = int(html_page.xpath('//*[@id="main"]/div/div[2]/div[3]/div/*/ul/li[6]/a/text()')[0])
            self.org_count = int(html_page.xpath('//*[@id="main"]/div/div[2]/div[3]/div/*/div/span/text()')[-1].split(' ')[-1])
            print(f'Количество страниц: {self.page_count}')
            logging.info(f'Количество страниц: {self.page_count}')
            print(f'Количество организаций по данному коду: {self.org_count}')
            logging.info(f'Количество организаций по данному коду: {self.org_count}')
        except IndexError:
            print('Ошибка при парсинге статистики')
            logging.error('Ошибка при парсинге статистики')

    def page_url_gen(self):
        for page in range(1, self.page_count+1):
            yield f'https://www.rusprofile.ru/codes/850000/{page}/'

    def get_orgs_from_page(self, page_url:str):
        temp_to_csv = []
        page = ''
        # page = self.get_page(self.home_url, self.headers)
        # with open('page1.html', 'w', encoding='utf-8') as f:
        #     f.write(page)
        with open('start.html', 'r', encoding='utf-8') as f:
            page = f.read()
        try:
            html_page = etree.HTML(page)
            # Название организации
            temp_to_csv.append([f.replace('  ','').replace('\n','') for f in html_page.xpath('//*[@id="main"]/div/div[2]/div[3]/div/div[*]/div[1]/a/text()')])
            # ОКВЭД
            # temp_to_csv.append(html_page.xpath('//*[@id="main"]/div/div[2]/div[3]/div/div[*]/div[4]/dl/dd/text()'))
            # ИНН
            # temp_to_csv.append(html_page.xpath('//*[@id="main"]/div/div[2]/div[3]/div/div[*]/div[3]/dl[1]/dd/text()'))
            # ОГРН
            # temp_to_csv.append(html_page.xpath('//*[@id="main"]/div/div[2]/div[3]/div/div[*]/div[3]/dl[2]/dd/text()'))
            # Адрес
            temp_to_csv.append([f.replace('  ','').replace('\n','') for f in html_page.xpath('//*[@id="main"]/div/div[2]/div[3]/div/div[*]/address/text()')])
            # Должность управляющего
            # temp_to_csv.append(html_page.xpath('//*[@id="main"]/div/div[2]/div[3]/div/div[*]/div[2]/dl/dt/text()'))
            # ФИО управляющего
            # temp_to_csv.append(html_page.xpath('//*[@id="main"]/div/div[2]/div[3]/div/div[*]/div[2]/dl/dd/text()'))
            # URL
            temp_to_csv.append(['https://www.rusprofile.ru' + f for f in html_page.xpath('//*[@id="main"]/div/div[2]/div[3]/div/div[*]/div[1]/a/@href')])
            # with open('res.txt', 'w', encoding='utf-8') as f:
            #     for i in zip(*temp_to_csv):
            #         f.write(', '.join(i)+'\n')
            for i in zip(*temp_to_csv):
                self.to_csv.append(list(i))
        except IndexError:
            print(f'Ошибка при парсинге страницы: {page_url}')
            logging.error(f'Ошибка при парсинге страницы: {page_url}')

    def check_orgs(self):
        for x in range(len(self.to_csv)):
            page_url = self.to_csv[x][-1]
            self._proxy = self.proxy.get()
            page = self.get_page(page_url, self.headers)
            try:
                html_page = etree.HTML(page)
                # Полное название организации
                self.to_csv[x].append(html_page.xpath('//*[@id="anketa"]/div[1]/div/div[1]/text()')[0])
                # Дата регистрации
                self.to_csv[x].append(html_page.xpath('//*[@id="anketa"]/div[2]/div[1]/div[1]/div[2]/dl/dd/text()')[0])
                # Должность руководителя
                self.to_csv[x].append(html_page.xpath('//*[@id="anketa"]/div[2]/div[1]/div[3]/span[2]/text()')[0])
                # ФИО руководителя
                temp_name = html_page.xpath('//*[@id="anketa"]/div[2]/div[1]/div[3]/span[3]/text()')
                if len(temp_name) != 0:
                    self.to_csv[x].append(temp_name[0])
                else:
                    self.to_csv[x].append(html_page.xpath('//*[@id="anketa"]/div[2]/div[1]/div[3]/span[3]/a/span/text()')[0])
                # Номер телефона
                temp_tel = html_page.xpath('//*[@id="anketa"]/div[2]/div[2]/div[3]/div[1]/div/span[2]/a/text()')
                if len(temp_tel) != 0:
                    self.to_csv[x].append(temp_tel[0].replace('-','').replace('(','').replace(')','').replace('-','').replace(' ',''))
                else:
                    self.to_csv[x].append('')
                # Email
                temp_mail = html_page.xpath('//*[@id="anketa"]/div[2]/div[2]/div[3]/div[2]/div/span[2]/a/text()')
                if len(temp_mail) != 0:
                    self.to_csv[x].append(temp_mail[0].replace('(','').replace(')','').replace(' ',''))
                else:
                    self.to_csv[x].append('')
                # Сайт
                temp_site = html_page.xpath('//*[@id="anketa"]/div[2]/div[2]/div[3]/div[3]/div/span[2]/a/@href')
                if len(temp_site) != 0:
                    self.to_csv[x].append(temp_site[0])
                else:
                    self.to_csv[x].append('')
                # Основной ОКВЭД
                self.to_csv[x].append(html_page.xpath('//*[@id="anketa"]/div[2]/div[2]/div[1]/span[2]/span/text()')[0].replace('(','').replace(')',''))
                # ИНН
                self.to_csv[x].append(int(html_page.xpath('//*[@id="clip_inn"]/text()')[0]))
                # КПП
                self.to_csv[x].append(int(html_page.xpath('//*[@id="clip_kpp"]/text()')[0]))
                # ОГРН
                self.to_csv[x].append(int(html_page.xpath('//*[@id="clip_ogrn"]/text()')[0]))
                # ОКПО
                self.to_csv[x].append(int(html_page.xpath('//*[@id="clip_okpo"]/text()')[0]))
                # ОКАТО
                self.to_csv[x].append(int(html_page.xpath('//*[@id="clip_okato"]/text()')[0]))
                # ОКТМО
                self.to_csv[x].append(int(html_page.xpath('//*[@id="clip_oktmo"]/text()')[0]))
                # ОКФС
                self.to_csv[x].append(int(html_page.xpath('//*[@id="clip_okfs"]/text()')[0]))
                # ОКОГУ
                self.to_csv[x].append(int(html_page.xpath('//*[@id="clip_okogu"]/text()')[0]))

                # print(f'{self.to_csv[x]}')

            except IndexError as e:
                print(f'Ошибка при парсинге страницы организации: {page_url}')
                # print(e.with_traceback())
                logging.error(f'Ошибка при парсинге страницы организации: {page_url}')

    def walk_all_pages(self):
        for page in self.p.url_gen:
            self.get_orgs_from_page(page)

    def save_to_csv(self):
        with open('res.csv', "w", newline="", encoding='utf-8') as file:
            writer = csv.writer(file, delimiter=',',
                            quotechar="'", quoting=csv.QUOTE_NONNUMERIC)
            writer.writerows(self.to_csv)


# p = RusprofileParser()
# p.get_stats()
# p.get_orgs_from_page('https://www.rusprofile.ru/codes/850000/')
# p.check_orgs()
# p.save_to_csv()
