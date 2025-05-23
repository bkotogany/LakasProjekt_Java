
# LakasProjekt

Ez a Java projekt egy JSON fájl alapján elemzi a budapesti eladó használt lakásokat.

## Követelmények
- Java 8 vagy újabb
- Gson könyvtár (gson-2.10.1.jar): https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar

## Használat
1. Töltsd le a gson-2.10.1.jar fájlt és másold be a `gson/` mappába.
2. Fordítsd le a forrást:
   javac -cp gson/gson-2.10.1.jar src/Main.java
3. Futtasd a programot:
   java -cp gson/gson-2.10.1.jar:src Main

(Mac/Linux rendszeren `:` jelet használj, Windows-on `;` kell!)
