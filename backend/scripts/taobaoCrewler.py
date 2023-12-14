import json
import random
from time import sleep

import requests
from selenium.webdriver import Chrome
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
import http.client
import json


def get_data():
    chrome_options = Options()
    chrome_options.add_argument(
        'user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36')

    driver = Chrome(options=chrome_options)

    elements = {
        "all_goods": "/html/body/div[6]/div/div/div/div",
        "goods_name": "/html/body/div[6]/div/div/div/div/div[1]/a/div[2]/div[1]",
        "goods_price": "/html/body/div[6]/div/div/div/div/div[1]/a/div[3]/span",
        "goods_url": "/html/body/div[6]/div/div/div/div/div[1]/a/div[1]/img"
    }

    driver.get("https://taobao.com")

    goods_div = driver.find_element(By.XPATH, elements["all_goods"])

    res = {}
    while True:
        i = 0
        driver.execute_script(f"window.scrollBy(0, 5000);")
        goods = goods_div.find_elements(By.XPATH, "./div")
        for good in goods:
            good_name = good.find_element(By.XPATH, "./a/div[2]/div[1]").text
            good_price = good.find_element(By.XPATH, "./a/div[3]/span").text
            good_url = good.find_element(By.XPATH, "./a/div[1]/img").get_property("src")
            res[good_name] = {"goods_name": good_name, "goods_price": good_price, "goods_url": good_url}
            print(f"当前商品数：{len(res)}")
        sleep(0.5)
        # 保存到Json文件
        with open("taobao.json", "w") as f:
            json.dump(res, f, ensure_ascii=False)

categories=['美食','居家']
url = "http://localhost:8888/api/backstage/goods/add"
def insert_data():
    conn = http.client.HTTPSConnection("localhost", 8888)
    # 读取taobao.json里面的所有字典
    with open("taobao.json", "r") as f:
        data = json.load(f)
        for good in data.values():
            print(good)
            if good["goods_url"] == 'https://g.alicdn.com/s.gif':
                continue
            payload = json.dumps({
                "title": good["goods_name"],
                "coverUrl": good["goods_url"],
                "detailUrl": good["goods_url"],
                "shopId": "1731161000700416000",
                "category": random.choice(categories),
                "price": float(good["goods_price"][1:]),
                "stock": 99
            })
            headers = {
                'User-Agent': 'Apifox/1.0.0 (https://apifox.com)',
                'Content-Type': 'application/json',
                'Accept': '*/*',
                'Host': 'localhost:8888',
                'Connection': 'keep-alive'
            }

            response = requests.request("POST", url, headers=headers, data=payload)

            print(response.text)


if __name__ == '__main__':
    insert_data()
