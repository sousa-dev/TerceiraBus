import requests
from itertools import product
import time

ids = [2,3,6,4,8,34,9,1,10,11,12,13,14,15,16,5,7,17,18,19,24,25,26,27,28,29,30,20,21,23,31,32,33]


headers =  {
    "User-Agent": "Mozilla/5.0 (X11; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/114.0",
    "Accept": "application/json",
    "Accept-Language": "en-US,en;q=0.5",
    "X-Requested-With": "XMLHttpRequest",
    "X-Request": "JSON",
    "Content-type": "application/x-www-form-urlencoded; charset=utf-8"
}

with requests.Session() as session:
    for x, y in product(ids, repeat=2):
        if x == y:
            continue
        print(x,y)
    
        r = session.post("http://www.evt.pt/inc/ajax/evt.php", headers=headers, data={
            "id_cartoes_zonas_inic": x,
            "id_cartoes_zonas_fin": y,
            "id_accao_ajax": 2,
            "idContentorRetorno": "contentorHorarios"
        })
        print(r.json()['html'])
        time.sleep(1)
        