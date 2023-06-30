import requests
import time
import random
from bs4 import BeautifulSoup

SLEEP_TIME = [1,1,1,1,1,1,2,2,2,2,4,3,3,3,3,3,3,5,5,4,4,6,7,8,9,10]

# carreiras = ['33', '6', '7', '8', '9', '10', '11', '12', '13', '21', '23', '15', '14', '16', '17', '18', '29', '30', '19', '20', '1']
# percursos = range(1, 1001)
# horarios = range(1000, 10001)
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

# WEEKDAYS
for type_of_day in ['weekdays', 'sabado', 'domingo']:
  paragens_tempos = []
  with open('resources/options-'+type_of_day, 'r') as f:
      options = f.read().splitlines()
      #Get all indexes of 'idContentorRetorno: idPercursoGrafico'
      indexes = [i for i, x in enumerate(options) if x == 'idContentorRetorno: idPercursoGrafico']
    
      for i in range(1,len(indexes)+1):
          #TODO: Check if last value from the list is being used
          print(f'{i}/{len(indexes)} - ' + type_of_day)
          option = []
          if i == len(indexes):
             option = options[indexes[i-1]:]
          else:
             option = options[indexes[i-1]:indexes[i]]
          option = [x.split(': ')[1] for x in option]
          data = {
              'idContentorRetorno': option[0],
              'id_accao_ajax': option[1],
              'id_carreiras': option[2],
              'id_percursos': option[3],
              'id_horarios': option[4],
          }
          if len(option) == 6:
              data['id_periodos'] = option[5]

          response = requests.post('http://www.evt.pt/inc/ajax/evt.php', headers=headers, data=data)
          response_json = response.json()
          soup = BeautifulSoup(response_json["html"], 'html.parser')
          extremos = soup.find_all("div", {"class": "nomePercursoGraficoExtremo"})
          paragens = [extremos[0].text] 
          paragens += [div.text for div in soup.find_all("div", {"class": "nomePercursoGrafico"})]
          paragens += [extremos[-1].text]
          tempos = [div.text for div in soup.find_all("div", {"class": "tempoPercursoGrafico"})] 
          paragens_tempos.append(list(zip(paragens, tempos)))
          # Append to file
          with open('resources/paragens_tempos_'+type_of_day, 'a') as f:
              for paragem_tempo in paragens_tempos[-1]:
                  f.write(f'{paragem_tempo[0]}:{paragem_tempo[1]};')
              f.write('\n')
          time.sleep(random.choice(SLEEP_TIME))

  print(type_of_day+" DONE")
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
