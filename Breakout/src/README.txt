#=====================#
# READ ME - Breakout  #
#=====================#
# Autor: Rico Brase   #
#---------------------#

Inhalt:
1. Spielanleitung
	1.1 Das Spiel
	1.2 Das *.bomap-Format
2. To-Do
	2.1 Geplante Funktionen
	2.2 Bugs & weitere Fehler
3. Hinweise
4. Quellenangaben

#---------------------#

1. Spielanleitung
	1.1 Das Spiel
		1.1.1 Map Laden
			Um eine Map zu laden, klicken Sie im Men� "Spielen" auf den Knopf "Klicken, um Map zu laden...".
			Nun �ffnet sich ein Men�, um eine Mapdatei aus dem Dateisystem zu �ffnen.
			
			Sollten Sie keine eigene Mapdatei besitzen, so klicken Sie einfach auf "Map Laden", um die mitgelieferte Standardmap zu laden.
			
			Mit der Option "Map-Ordner �ffnen" sollte sich Ihr Dateimanager �ffnen und eine einzelne *.bomap-Datei anzeigen.
			Diese Datei k�nnen Sie nun, den Formatsregeln (siehe X.X) entsprechend, anpassen, um Ihr eigenes Spielfeld zu erzeugen.
			
		1.1.2 Die Grundlagen des Spiels
			Das Spielfeld enth�lt drei f�r den Spielablauf relevante Objekte:
				- Die Bl�cke
				- Der Ball
				- Das Paddle
				
			Sie steuern die horizontale Bewegung des Paddles mit der horizontalen Bewegung der Maus (evtl. auch beliebiges Maus-Ersatz-Eingabger�t).
			Um den Ball vom Paddle zu l�sen, dr�cken Sie die Leertaste/Spacebar. Der Ball wird sich nun in einer geraden Bewegung nach oben bewegen,
			bis dieser auf einen Block oder den Displayrand trifft.
			
			Der Ball prallt sowohl von den Bl�cken (au�er mit dem "Flame"-PowerUp, siehe "PowerUps"), den Displayw�nden (Ausnahme: der untere Spielfeldrand)
			und von dem	Paddle ab. Ber�hrt der Ball den unteren Spielfeldrand, so verlieren Sie ein Leben und m�ssen den Ball wieder vom Paddle abschie�en.
			
			Sie verlieren das Spiel, sollten Sie alle Ihre Leben verlieren.
			
			Ber�hren Sie einen Block mit dem Ball, so wird dieser besch�digt. Dies zeigt sich anhand einer Farb�nderung, wobei es insgesamt f�nf m�gliche
			Farbstufen gibt:
				- T�rkis: Der Block kann noch 1mal getroffen werden.
				- Gr�n: Der Block kann noch 2mal getroffen werden.
				- Gelb: Der Block kann noch 3mal getroffen werden.
				- Rot: Der Block kann noch 4mal getroffen werden.
				- Transparent/unsichtbar: Der Block wurde bereits zerst�rt und kann nicht weiter besch�digt werden.
				
			Sie gewinnen das Spiel, sollten Sie alle Bl�cke auf die transparente Farbstufe bringen k�nnen/sollten Sie alle Bl�cke zerst�ren k�nnen.
			
			Mit einem Druck auf die Escape-Taste ("Esc") kehrt man jederzeit in das Hauptmen� zur�ck.
			!! Hinweis !! Der aktuelle Spielstand geht verloren! Es kann lediglich eine neue Runde gestartet werden.
			
		1.1.3 PowerUps
			Bei dem Besch�digen von Bl�cken besteht die Chance, dass ein PowerUp erscheint. Hierbei gibt es drei verscheidene PowerUps, die auftauchen k�nnen:
				- "Flame"-PowerUp: Der Ball f�rbt sich rot, zerst�rt einen ber�hrten Block mit einem Treffer und prallt nicht von diesem ab.
					- Dauer: 5s
				- "Paddle"-PowerUp: Die Breite des Paddles verdoppelt sich, wodurch das Treffen des Balls und das gleichzeitige Einsammeln von PowerUps erleichtert wird.
					- Dauer: 5s
				- "Health"-PowerUp: Erh�ht die Lebensanzahl des Spielers um 1.
			
			Wird ein PowerUp nicht eingesammelt, so verf�llt dieses.
	
	1.2 Das *.bomap-Format
		Das *.bomap-Format ist das spielinterne Dateiformat, um Maps laden zu k�nnen.
		Ebenfalls ist es m�glich, dass Spieler sich benutzerdefnierte Maps anlegen, allerdings fehlt (derzeit) die M�glichkeit einer grafischen Oberfl�che zur
		Maperstellung, daher muss auf beliebige (UTF-8 kompatible) Texteditoren zur�ckgegriffen werden.
		
		Um eine g�ltige *.bomap-Datei f�r "Breakout" zu erstellen, m�ssen folgende Punkte beachtet werden:
			- Kommentare werden mit einem beliebigen Nicht-Ziffer-Zeichen (alles au�er 0-9) begonnen.
				- Kommentare m�ssen nicht "geschlossen" werden, sondern sind zeilenweise g�ltig.
			- Startet eine Zeile mit einer Ziffer, so wird diese als Blockangabe behandelt:
				- Format: xPos;yPos;breakCount
					- xPos: Die x-Position des Blockes im Mapgitter (m�gl. Werte: 0-9)
					- yPos: Die y-Position des Blockes im Mapgitter (m�gl. Werte: 0-14)
					- breakCount: Die Farbstufe des Blockes
						- T�rkis: 1
						- Gr�n: 2
						- Gelb: 3
						- Rot: 4
						
2. To-Do
	2.1 Geplante Funktionen
		Es sind folgende Funktionen f�r zuk�nftige Updates geplant:
			- vern�nftige Versionierung des Spiels
			- Vom Spieler �nderbare Optionen
				- u.A. Option zum Ausblenden der Debug-Infos.
			- weitere PowerUps
				--> dadurch Senkung der Spawnchancen anderer PowerUps
			- Verbesserung des *.bomap-Formats, um gravierende Fehler und Exceptions, die durch falsche Eingaben entstehen zu minimieren
			
	2.2 Bugs & weitere Fehler
		Folgende Fehler sind derzeit bekannt:
			- Manchmal m�ssen Men�buttons mehrmals bet�tigt werden, um eine Wirkung zu zeigen.
			- Trifft der Ball einen Block an der linken oder rechten Kante kann es passieren, dass der gesamte Block sofort zerst�rt wird.
			- Wird der Ball mit dem Paddle von der Seite her "gerammt", kann es passieren, dass der Ball zwischen dem Paddle und dem unteren
			  Bildschirmrand hin und her springt (ohne Abzug von Leben).
			  
			- In einzelnen F�llen kann es bei einem vergr��erten Paddle dazu kommen, dass der Ball sich nur noch gerade nach oben und unten bewegt.
				--> Probleml�sung: Spiel/Runde neustarten.
		
3. Hinweise
	Dieses Spiel wurde im Rahmen einer Projektarbeit des Informatikunterrichtes im Semester 12.2 begonnen, wird jedoch auch �ber den Abgabetermin hinaus
	weiter programmiert.
	
	Soweit wie m�glich, wird auf bereits existierenden Code verzichtet, einzig und allein die Maus- und Tastaturhandler, sowie das JFrame und das JPanel
	(und dazugeh�rige Klassen) sind bereits	durch Sun Microsystems/Oracle erstellte Klassen.
	
	Der Quellcode des Projektes "Breakout" ist auf Github.com unter folgender Adresse verf�gbar:
	http://github.com/RicoBrase/Breakout
	
	Alle Grafiken, sofern nicht unter 4. angef�hrt, wurden von Rico Brase erstellt.
	
	Der geheime Bonus ist eine Referenz auf diverse Twitch.tv-Streamer und hat keinen Nutzen - er dient lediglich als "EasterEgg".
	
4. Quellenverweise
	"GOTY": https://static-cdn.jtvnw.net/emoticons/v1/32207/3.0
	"TENOFTEN": https://static-cdn.jtvnw.net/emoticons/v1/29569/3.0
	"DAN": http://fc02.deviantart.net/fs70/f/2014/259/7/1/dancreep_rs1_by_juliacassian-d7ze287.png
	"WAFFLE": https://static-cdn.jtvnw.net/emoticons/v1/24594/3.0
	
#---------------------#
		