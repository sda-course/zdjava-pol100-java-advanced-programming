# Tworzenie paczki jar

## Plik MANIFEST.MF
W katalogu `META-INF` nale¿y umieœciæ plik manifestu, w którym jednym z najwa¿niejszych elementów jest okreœlenie
punktu wejœcia. Przyk³adowa treœæ:
```
Manifest-Version: 1.0
Created-By: 1.7.0_06 (Oracle Corporation)
Main-Class: nazwaKlasy
```
W miejscu `nazwaKlasy` nale¿y wpisaæ nazwê klasy z metod¹ `main`. Ta klasa zostanie za³adowana jako pierwsza i 
program zacznie siê od wykonania jej metody `main`.

## Dodanie pluginu w <code>pom.xml</code>
Dodanie tego pluginu powoduje, ¿e Maven tworzy plik manifestu ze wskazan¹ klas¹ stanowi¹ca punkt wejœcia.

```xml
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>3.2.0</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>app.CityApp</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
        </plugins>
    </build>
```
W sekcji <code><mainClass>paczka.Klasa</mainClass></code> nale¿y wpisaæ klasê, która zawiera metodê `main`.

## Okreœlenie metody `packaging` w `pom.xml`
```xml
<project>
    <packaging>jar</packaging>
    ...
</project>
```


## Kompilacja i tworzenie paczki
Dla skonfigurowanego projektu Maven nale¿y wywo³aæ cel (View-->Tool Windows-->Maven, ikona z liter¹ M - Execute Maven goal):
```text
    mvn package
```
To spowoduje, ¿e zostanie utworzony plik `artifatId-version.jar` w katalogu `target`.

## Uruchomienie
W konsoli systemu operacyjnego np. `cmd.exe` wpisujemy polecenie uruchamiaj¹ce paczkê `jar`.

```text
java -jar paczka.jar
```

Aby uzyskaæ poprawne kodowanie znaków w UTF-8 (Java koduje znaki w UTF-16) nale¿y dodaæ prze³¹cznik:
```text
java -jar -Dfile.encoding=UTF-8 paczka.jar
```

W przypdaku pow³ok, które interpretuj¹ znak kropki nale¿y prze³¹cznik podaæ w cudzys³owiu.
```text
java -jar "-Dfile.encoding=UTF-8" paczka.jar
```



