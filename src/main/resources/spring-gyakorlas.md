Az alábbi követelményeknek megfelelően találj ki egy domain modellt
és egy alkalmazást, ami rendelkezik a felsorolt jellemzőkkel.

Olvasd végig a feladatokat, hogy értsd, mire kell felkészíteni az 
appot.

Mindegy milyen sorrendben haladsz, a lényeg, hogy egy koherens egész
legyen a végeredmény. Egy korábbi lépésben írt kódrészletet nyugodtan
átírhatsz, kiegészíthetsz később, a lényeg, hogy a feladatsor végére
minden jellemző kipipálható legyen.

Minden részfeladatot kommitolj külön, hogy lekövethető legyen, miket
csináltál, hogyan. A branch neve/commit message utaljon a 
részfeladatra.

View réteg
==========

CRUD
----

- legyen egy űrlap adatfelvételre
- legyen űrlap validáció
  - https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#validation-beanvalidation
- legyen egy listázó képernyő
- legyen egy adatlap képernyő, ami egy listaelem adatait jeleníti meg
  egy szerkeszthető űrlapon
- legyen egy szerkesztés gomb a listaelemek mellett, ami a listaelem
  adatlapjára vezet
- legyen egy törlés gomb, ami egy törlés megerősítés képernyőre vezet,
  a törlés képernyőn legyen egy gomb, ami visszavezet az adatlapra
  és egy másik, ami töröl, majd átirányít a listára
  

Controller réteg
================

REST CRUD

- legyen egy restful api egy `/api` útvonal alatt
  - pl. `POST /api/gumimaci`

Service réteg
=============

Domain modell
- legyen legalább egy asszociáció két domain osztály között
- legyen legalább egy asszociáció, ahol az asszociációt egy harmadik
  osztály írja le
- legyen legalább egy kompozíció
- legyen legalább egy öröklődés
- legyen legalább egy strategy pattern

Adat réteg
==========

- OneToMany
- ManyToMany
- OneToOne
- Custom repository lekérdezések


