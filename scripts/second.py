import requests
from bs4 import BeautifulSoup

routes = ['33', '6', '7', '8', '9', '10', '11', '12', '13', '21', '23', '15', '14', '16', '17', '18', '29', '30', '19', '20', '1']

headers = {
    'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/114.0',
    'Accept': 'application/json',
    'Accept-Language': 'en-US,en;q=0.5',
    'Accept-Encoding': 'gzip, deflate',
    'X-Requested-With': 'XMLHttpRequest',
    'X-Request': 'JSON',
    'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
    'Origin': 'http://www.evt.pt',
    'Connection': 'keep-alive',
    'Referer': 'http://www.evt.pt/simulador/',
    'Cookie': 'PHPSESSID=8iq2dqt7hbqkm3sfcpr1uteni6'
}

data = {
  'idContentorRetorno': 'idPercursoGrafico',
  'id_accao_ajax': '7',
  'id_carreiras': '14',
  'id_percursos': '331',
  'id_horarios': '3934'
}

response = requests.post('http://www.evt.pt/inc/ajax/evt.php', headers=headers, data=data)
response_json = response.json()
print(response_json["html"])
soup = BeautifulSoup(response_json["html"], 'html.parser')
extremos = soup.find_all("div", {"class": "nomePercursoGraficoExtremo"})
paragens = [extremos[0].text] 
paragens += [div.text for div in soup.find_all("div", {"class": "nomePercursoGrafico"})]
paragens += [extremos[-1].text]
tempos = [div.text for div in soup.find_all("div", {"class": "tempoPercursoGrafico"})] 
paragens_tempos = list(zip(paragens, tempos))

print(paragens_tempos)


# curl 'http://www.evt.pt/inc/ajax/evt.php' --compressed 
# -X POST -H 'User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/114.0' 
# -H 'Accept: application/json' -H 'Accept-Language: en-US,en;q=0.5' 
# -H 'Accept-Encoding: gzip, deflate' -H 'X-Requested-With: XMLHttpRequest' 
# -H 'X-Request: JSON' -H 'Content-type: application/x-www-form-urlencoded; charset=utf-8' 
# -H 'Origin: http://www.evt.pt' -H 'Connection: keep-alive' 
# -H 'Referer: http://www.evt.pt/simulador/' -H 'Cookie: PHPSESSID=8iq2dqt7hbqkm3sfcpr1uteni6' 
# --data-raw 'idContentorRetorno=idPercursoGrafico&id_accao_ajax=7&id_carreiras=7&
# id_percursos=331&id_horarios=3934'
