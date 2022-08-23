# GazsoGergely


RECEPTKÖNYV
	-Étel (lekérhető belőle az Ország, összfehérje, összkalória, stb...)
	-Hozzavalo ()
	-Recept (tartalmazza az ételt, a hozzávalók sorrendjét, és egy utasítást)
	-Tápanyag (gramms field, calcCalories metódus)
	-Szénhidrát, Zsír, Fehérje (gramms field, calcCalories-t override-olja)

Felvételhez inkább 3-4 kül űrlap.


View réteg******************************************************************
CRUD
legyen egy űrlap adatfelvételre
	-űrlap 1 sora: Recept Id, Receptből az étel neve, tetszőleges számú hozzávaló (előre meg kell adni
		hany hozzavalóból fog állni, annyi sort kell generálni thymeleafben),
		minden hozzavalohoz mennyiseg.
		minden hozzvalot be kell írni szövegesen
		ha nincs olyan hozzávaló akkor fel lehessen venni a hozzávalót is
	-hozzávaló felvétele: név, szénhidrát, fehérje, zsír (kcal számított érték lesz)
legyen űrlap validáció
https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#validation-beanvalidation
	-min 2 dolgot validálni. Olyat ami a doksiban is benne van
legyen egy listázó képernyő
	-recepthez és hozzávalóhoz
legyen egy adatlap képernyő, ami egy listaelem adatait jeleníti meg egy szerkeszthető űrlapon
	-recepthez és hozzávalóhoz
legyen egy szerkesztés gomb a listaelemek mellett, ami a listaelem adatlapjára vezet
	-recepthez és hozzávalóhoz
legyen egy törlés gomb, ami egy törlés megerősítés képernyőre vezet, a törlés képernyőn legyen egy gomb, ami visszavezet az adatlapra és egy másik, ami töröl, majd átirányít a listára
	-recepthez és hozzávalóhoz
Controller réteg
REST CRUD

legyen egy restful api egy /api útvonal alatt
pl. POST /api/gumimaci
	-ezt majd legutoljára, valami adatot statisztikai adatot adjon vissza. Pl a 3 leginkább használt hozzávalót.
	- össektöhető a CustomRepository-val
Service réteg******************************************************************
Domain modell

legyen legalább egy asszociáció két domain osztály között
	-a Étel osztály egyik fieldje egy List<Hozzavalo>
legyen legalább egy asszociáció, ahol az asszociációt egy harmadik osztály írja le
	- Ez egy OneToOne-hoz fog kelleni: az Étel-t és a Hozzávalókat a Recept osztály köti össze, ami sorrendet ad és leírást
legyen legalább egy kompozíció
	-pl szoba nem tud az épületen kívül létezni
	-egy Tápanyag amikr létrejön mindig aegy Hozzavalóba kerül, vele együtt létezik és szűnik meg
legyen legalább egy öröklődés
	-Tápanyag osztályból öröklődik pl Fehérje, Zsír, Szénhidrát
legyen legalább egy strategy pattern
	-beadott paraméter szerint adott starta alapján (PL TZOJÁSMENTES) generáljon random kaját
	- egy konkrét osztály és azt adom át a strategynek ami miatt máshogy viselkedik
Adat réteg************************************************************************
OneToMany
	-1 Étel egy Ország tartozhat, de 1 Országhoz több Étel tartozhat
ManyToMany
	-1 Ételhez több hozzávaló tartozhat
	-1 hozzávalóhoz több Ételtartozhat
OneToOne
	- egy Ételhez egy Recept tartozhat. Egy Recept a Hozzavalok sorrendjét fogja definiálni, plusz egy uatsítások field-je is lesz,
		plusz lesz benne Étel field és 
Custom repository lekérdezések
	-kérd le az összes reggelit, amiben nincsen tojás