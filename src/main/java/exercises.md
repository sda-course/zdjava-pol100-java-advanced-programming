#Ćwiczenie 1
Korzystając z `PersonRepository` utwórz listę osób:
1. z imionami złożonymi z trzech liter,
2. z imionami zaczynającymi się literą `K` i kończącymi się literą `a`
3. o wadze powyżej 75,
4. o wadze między 45 a 65 włącznie,
5. osób urodzonych w maju,
6. osób urodzony w latach 1995-2000
7. osób z męskim imieniem i wadze równej ostatnim dwóm cyfrom roku urodzenia np. Karol 1978-10-10 78,00
#Ćwiczenie 2
Korzystając z `CityRepository` sprawdź, czy:
1. istnieje jakieś miasto o nazwie składającej się z 4 wyrazów.
2. istnieje jakieś miasto o populacji, która składa się z tych samych cyfr np. 2222, 4444444 itd.
3. wszystkie miasta mają nazwę o długości co najmniej 3 znaków,
4. wszystkie miasta mają populację co najmniej 500.
#Ćwiczenie 3
Korzystając z `PersonRepository` utwórz listę:
1. imion wielkimi literami,
2. wag zaokrąglonych do liczby całkowitej, 
3. obiektów klasy `Period`, które są okresem od urodzin do dnia obecnego (`Period.between(date1, date2)`),
4. listę stałych typu wyliczeniowego Sex (zadeklaruj taki typ ze stałymi MALE i FEMALE) adekwatnie płci (na podstawie imion),
5. listę wskaźników BMI jako iloraz weight / height * height.
#Ćwiczenie 4
Korzystając z `PersonRepository` oblicz:
1. ile jest kobiet,
2. sumę wag osób urodzonych przed 1990 rokiem,
3. najmniejszy wzrost osób z imieniem `Karol`,
4. największą wagę.
Korzystając z `CityRepository` oblicz:
5. sumę populacji miast polskich,
6. liczbę miast w USA.
#Ćwiczenie 5
Korzystając z `CityRepository` stwórz:
1. mapę z kluczem w postaci kodu kraju i wartością równą licznie miast w tym kraju,
2. znajdź pierwsze miasto z populacją powyżej 5 mln,
3. znajdź jakiekolwiek miasto, którego nazwa składa się z 3 znaków.