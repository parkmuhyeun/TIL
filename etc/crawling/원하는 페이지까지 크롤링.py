import requests
from bs4 import BeautifulSoup
import pyautogui

search = pyautogui.prompt("검색어: ")
lastpage = pyautogui.prompt("몇 페이지: ")
pageNum = 1
for i in range(1, int(lastpage) * 10, 10):
    print(f"{pageNum}페이지 입니다.===========================")
    response = requests.get(f"https://search.naver.com/search.naver?where=news&sm=tab_jum&query={search}&start={i}")
    html = response.text
    soup = BeautifulSoup(html, 'html.parser')
    links = soup.select('.news_tit')
    for link in links:
        title = link.text # 태그 안에 텍스트요소를 가져옴
        url = link.attrs['href'] # href의 속성값을 가져온다
        print(title, url)
    pageNum += 1