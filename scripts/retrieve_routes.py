from bs4 import BeautifulSoup
values = []
routes = []
# Retrive value from option tag in select tag
soup = BeautifulSoup(open("routes.html"), "html.parser")
select = soup.find("select")
options = select.find_all("option")
for option in options:
    values.append(option["value"])
    routes.append(option.text.strip().replace("\t", "").replace("\n", "").replace("\r", ""))
# Remove first element
values.pop(0)
routes.pop(0)
temp = []
for route in routes:
    route_id = route.split("-")[0]
    route_name = route.replace(route_id+"-", "").strip()
    temp.append((route_id, route_name))
routes = temp    

print(values)
print(routes)
