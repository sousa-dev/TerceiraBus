from bs4 import BeautifulSoup
values = []
stops = []
# Retrive value from option tag in select tag
soup = BeautifulSoup(open("stops.html"), "html.parser")
select = soup.find("select")
options = select.find_all("option")
for option in options:
    values.append(option["value"])
    stops.append(option.text.strip().replace("\t", "").replace("\n", "").replace("\r", ""))

print(values)
print(stops)

# Stop("João Bom", Location(37.895577553977084, -25.787295651866142))
with open("/home/sousa/Documents/SMB/TerceiraBus/scripts/kt/stops.kt", "w") as f:
    for stop in stops:
        f.write(f"Stop(\"{stop}\", Location(0.0, 0.0))\n")
