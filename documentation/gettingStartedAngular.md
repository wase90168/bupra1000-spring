# Getting Started (Angular)

## Setup
Zu Beginn müssen die zwei Repositories von Github geklont werden. Dazu gibt man folgende zwei Befehle in die Kommandozeile ein:
* git clone https://github.com/wase90168/bupra1000-spring.git
* git clone https://github.com/wase90168/bupra1000-angular.git

Sobald diese zwei Repositories erfolgreich geklont wurden, müssen diese in einer passenden Entwicklungsumgebung (z.B. IntelliJ IDEA) geöffnet werden.

Bevor das Projekt gestartet werden kann, ist darauf zu achten, dass sich das Projekt bupra1000-spring im Run-Modus befinden [(Anleitung)](gettingStartedSpring.md). Weitere Infos zu den Setup-Schritten dieser zwei Projekte sind in den Readme-Files der Repositories auffindbar:
* https://github.com/FlorianReinprecht/AngularFightersAuth/blob/master/README.md
* https://github.com/FlorianReinprecht/AngularFighterAPI/blob/master/README.md

**Folgendes muss installiert sein, um die Anwendungen nutzen zu können:**
* [Java 8 JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Node.js LTS v8.9.1](https://nodejs.org/en/) (nicht Version 9!)


**Um den Start des Frontend-Projekts zu ermöglichen ist die Eingabe folgender Befehle im Terminal notwendig:**
* npm install
* npm i webpack --save-dev
* npm start

Um das Projekt im Browser anzeigen zu lassen, muss http://localhost:4200/ aufgerufen werden.
