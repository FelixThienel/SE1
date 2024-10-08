# Übung 1
## Aufgabe 1
### 1
Ich habe das Problem mit Hilfe einer Factory-Klasse gelöst. Dieses Designpattern könnte vor allem später, wenn man mehrere verschiedene Translator hat von Vorteil sein, da man so nur eine Methode hat mit der man alle beliebigen Translators erzeugen kann.
### 3
Durch eine separate Testklasse kann man einerseits seinen Code überprüfen andererseits sind die Tests getrennt und sind nicht in einem Release-Build enthalten.

Der Sinn der Äquivalenzklassen ist, dass man alle gleichen Reaktionen (Antworten, Ergebnisse) für verschiedene Eingaben zusammenfässt, sodass man nicht jede mögliche Eingabe testen muss, sondern nur jeweils einen Repräsentanten der Klassen.

Der Test ist auf der Klasse des Clients nur erschwert möglich, da hier kein Ergebnis zurückgegeben wird, sondern es direkt auf der Konsole ausgegeben wird. Somit müsste man für einen Test den Inhalt der Konsole auslesen und vergleichen.