TiraLabra: SortingDemo
======================

Ohjelman päätarkoitus on vertailla aikoja eri algoritmien välillä satunnaisella syötteellä, mutta syötteen voi myös määrittää täysin itse.

Käynnistäminen
--------------------

Ohjelman voi käynnistää IDM ohjelmalla suoraan tai sitten avaamalla SortingDemo.jar Linuxin terminaalissa komennolla: java -jar SortingDemo.jar

Alkuvalikko
---------------

Ohjelman käynnistyessä avautuu vastaavanlainen alkuvalikko:

	1: Show Arrays On/Off
	2: Time comparison
	x: Stop the program

Tarkoituksena on kirjoittaa komentoriville kaksoispisteen takana oleva merkki terminaaliin ja painaa entteriä. 

1. Show Arrays On/Off valitsee, näytetäänkö aikavertailun aluksi generoitu taulukko ja lopuksi jokaisen algoritmin oma järjestetty kopio taulukosta. Tätä vaihtoehtoa ei kannata käyttää kovin isolla syötteellä tai koko komentori täytyy pelkästään alkuluvuista.

2. Time Comparison käynnistää ohjelman aikavertailuosion

Time Comparison
----------------------

valikko:

	Choose the algorithm you want to compare.
	Typing the number input again deselects the algorithm

	1: Merge sort
	2: Quicksort
	3: Heapsort
	s: Start with a new array
	r: Retry with previous array
	x: Back


	Visible arrays: Off
	Selected Algorithms: 



Vaihtoehdoilla 1, 2 ja 3 valitaan, mitä algoritmeja halutaan käsitellä. Valitsemalla luku uudestaan otetaan algoritmi pois testattavien joukosta. Valitut algoritmit tulostetaan ruudulle valikon alle näkyviin. Kun halutut algoritmit on valittu, annetaan joko syöte s tai r. Syöte s käynnistää uuden valikon, jossa luodaan taulukko järjestämisalgoritmeja varten. Syöte r kokeilee järjestystä uudelleen viimeksi luodulla taulukolla. Ohjelma ilmoittaa, jos yrität ajaa algoritmin luomatta sille ensin taulukkoa. Aikavertailun tulos tulostetaan komentoriville ja ohjelma palauttaa sinut alkuvalikkoon


Taulukon luonti
--------------------

	Choose input method for integers
	1: Select each number one by one
	2: Randomly generate a set amount
	x: Back

Ensimmäinen vaihtoehto antaa sinun luoda taulukon luvun luvulta. Ensin sinua pyydetään antamaan taulukon koko ja tämän jälkeen voit syöttää jokaisen luvun komentoriville yksi kerrallaan. Toinen vaihtoehto luo satunnaisen taulukon itse. Sinun tarvitsee ainoastaan syöttää taulukon koko. Kun valinnat on tehty, ohjelma käynnistää aikavertailun itsestään.


