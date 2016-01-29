# dist_bloom (FHNW Modul Diskrete Stochastik)
Bonusaufgabe Bloom filter mit [guava-libraries Hashing-Funktion](http://docs.guava-libraries.googlecode.com/git-history/v11.0/javadoc/com/google/common/hash/Hashing.html)
##Definition
Ein Bloom-Filter ist eine probabilistische Datenstruktur, mit deren Hilfe sehr schnell festgestellt werden kann, welche Daten in einem Datenstrom schon einmal vorgekommen sind und welche erstmals auftreten. Hierzu wird mit einer geeigneten Zahl von Hash-Funktionen ein „Fingerabdruck“ des gelesenen Datensatzes in einer einzeiligen Hashtabelle hinterlassen. [Wikipedia](https://en.wikipedia.org/wiki/Bloom_filter)
##Funktionen
- Hinzufügen von Strings
- Prüfen ob String in Datenstruktur vorhanden ist (Achtung [falsch positive Ergebnisse](https://de.wikipedia.org/wiki/Beurteilung_eines_bin%C3%A4ren_Klassifikators#Wahrheitsmatrix:_Richtige_und_falsche_Klassifikationen) sind möglich!)
