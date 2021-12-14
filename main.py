import requests
from bs4 import BeautifulSoup
import pathlib
import os
import csv
import json
import sys

a = 0
tl = []

def dulieu(link):
    try:
        #sys.stdout = codecs.getwriter('utf_8')(sys.stdout)
        #sys.stdin = codecs.getreader('utf_8')(sys.stdin)
        global a, t1
        a=a+1

        response = requests.get(link)
        soup = BeautifulSoup(response.content, "html.parser")

        t= soup.find('div', class_='header-content width_common')
        labels = t.find_all('a')
 
        if len(labels) == 1:
            label = labels[0].get('data-medium')[5:]
        else :
            label = labels[1].get('data-medium')[5:]

        timestamp =  t.find('span', class_='date').text

        title = soup.find('h1', class_='title-detail').text

        contents = soup.findAll('p', class_='Normal')
        content = ''
        for i in range(0, len(contents)-1):
            content += contents[i].text + ' '
        obj = {
            "url" : link ,
            "label" : label , 
            "timestamp" : timestamp , 
            "title": title ,
            "content" : content
        }
        
        t="D:/Python/Crawl_vnexpress/data/news"+str(a)+'.json'
        p = pathlib.Path(t)
        p.touch()
        with open(t, 'w', encoding='utf-8') as myfile:
            json.dump(obj, myfile, ensure_ascii=False, indent=4)
    except:
        print(link)


def get_link3(linkc):
    try:
        response = requests.get(linkc)
        soup = BeautifulSoup(response.content, "html.parser")
        titles = soup.find_all('h3', class_='title-news')
        links = [link.find('a').attrs["href"] for link in titles]
        for link in links:
            dulieu(link)
    except:
        print(linkc+'sai')

def get_link2(linkc):
    try:
        response = requests.get(linkc)
        soup = BeautifulSoup(response.content, "html.parser")
        titles = soup.find_all('h2', class_='title-news')
        links = [link.find('a').attrs["href"] for link in titles]
        for link in links:
            dulieu(link)
    except:
        print(linkc+'sai')

try:
    os.mkdir('D:/Python/Crawl_vnexpress/data')
except OSError:
    print('Failed creating the directory')
else:
    print('Directory created')


links2 = [
    'https://vnexpress.net/thoi-su/chinh-tri',
    'https://vnexpress.net/thoi-su/dan-sinh',
    'https://vnexpress.net/thoi-su/giao-thong',
    'https://vnexpress.net/kinh-doanh/doanh-nghiep',
    'https://vnexpress.net/kinh-doanh/chung-khoan',
    'https://vnexpress.net/kinh-doanh/bat-dong-san',
    'https://vnexpress.net/kinh-doanh/bao-hiem',
    'https://vnexpress.net/khoa-hoc/phat-minh',
    'https://vnexpress.net/khoa-hoc/ung-dung',
    'https://vnexpress.net/giai-tri/phim',
    'https://vnexpress.net/giai-tri/nhac',
    'https://vnexpress.net/giai-tri/sach',
    'https://vnexpress.net/phap-luat/ho-so-pha-an',
    'https://vnexpress.net/giao-duc/du-hoc',
    'https://vnexpress.net/giao-duc/tuyen-sinh',
    'https://vnexpress.net/suc-khoe/khoe-dep',
    'https://vnexpress.net/so-hoa/san-pham',
    'https://vnexpress.net/oto-xe-may/thi-truong',
    'https://vnexpress.net/bong-da'
]

links3 = [

]
try:
    for link in links2:
        for i in range(2, 102):
            get_link2(link+'-p'+str(i))

    # for link in links3:
    #     for i in range(2, 42):
    #         get_link3(link+'-p'+str(i))
    #         print(1)
except:
    print('1')