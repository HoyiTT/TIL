# BeautifulSoup

BeautifulSoup는 HTML과 XML 파일로부터 데이터를 뽑아내기 위한 파이썬 라이브러리이다. 여러분이 선호하는 해석기와 함께 사용하여 일반적인 방식으로 해석 트리를 항해, 검색, 변경할 수 있다. 주로 프로그래머의 수고를 덜어준다. 

``` python
import requests
from bs4 import BeautifulSoup

url = "http://www.ggdorm.or.kr/home/main_kr/main.php?ctt=../contents_kr/m_5_5&mc=1|5|1"
html = requests.get(url)


soup = BeautifulSoup(html.text, 'html.parser')
print(soup.select_one('tbody > tr > td'))

title = soup.select('tbody > tr > td')
print(title)
```

위는 BeautifulSoup의 사용 예시 이다.

Select_one()은 하나의 태그만을 가져오는 함수이다. Select()는 여러개의 태그를 가져오는 함수이다.