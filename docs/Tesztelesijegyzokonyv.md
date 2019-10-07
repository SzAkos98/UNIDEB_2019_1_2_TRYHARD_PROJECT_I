# Tesztelési jegyzőkönyv

2019.9.29. - Debrecen


Kód  |Leírás                                                           |Eredmény
-----|-----------------------------------------------------------------|--------
T01: | A program elindítása                                            |sikeres
T02: |Az adatbázisból egy létező könyvre való rákeresés                |sikeres
T03: |Az adatbázisból egy nem létező könyvre való rákeresés            |sikeres
T04: |Egy könyv hozzáadása az adatbázishoz                             |sikeres
T05: |Egy könyv állapotának kikölcsönzöttről való átállítása elérhetőre|sikeres
T06: |Egy könyv állapotának elérhetőről való átállítása kikölcsönzöttre|sikeres
T07: |Egy tag felvétele a tagok adatbázisába                           |sikeres
T08: |Egy tag eltávolítása a tagok adatbázisából                       |sikeres
T09: |Egy könyv kikölcsönzése                                          |sikeres
T10: |Több könyv kikölcsönzése                                         |sikeres
T11: |Egy könyv kitörlése a könyvek adatbázisából                      |sikeres
T12: |A Kilépés menüpontra kattinva felugrik a Megerősítés ablak       |sikeres
T13: |A Megerősítés ablakon belül az OK gombra kattintva a programból ki lehet lépni |sikeres
T14: |A tag módosítása menüpont alatt nem lehet az ID-t megváltoztatni |sikeres
T15: |A könyv módosítása menüpont alatt nem lehet az ID-t megváltoztatni |sikers
T16: |A tag módosítása menüpont alatt nem lehet már létező ID-t megadni |sikeres
T17: |A könyv módosítása menüpont alatt nem lehet már létező ID-t megadni |sikeres
T18: |A tag módosítása menüpont alatt módosítás esetén muszáj minden field-et kitölteni |sikeres
T19: |A könyv módosítása menüpont alatt módosítás esetén muszáj minden field-et kitölteni |sikeres
T20: |A kölcsönzés menüpont első megjelenő ablakjában ki lehet választani a tagot aki könyvet szeretne kikölcsönözni |sikeres
T21: |A kikölcsönzés menüpont második megjelenő ablakján hozzá lehet adni a kölcsönzött könyvek listájához egy könyvet |sikeres
T22: |A kikölcsönzés menüpont második megjelenő ablakján hozzá lehet adni a kölcsönzött könyvek listájához több könyvet |sikeres
T23: |A jelenleg kikölcsönzött könyvet más nem kölcsönözheti ki |sikeres
T24: |A tag vissza tud hozni könyvet a könyvtárba |sikeres
Kód  |Leírás                                                           |Elvárt viselkedés |Eredmény
-----|-----------------------------------------------------------------|------------------|--------
T01: | A program elindítása                                            |A program hiba nélkl indul|sikeres
T02: |Az adatbázisból egy létező könyvre való rákeresés                |A könyv megtalálható az adatbázisban|sikeres
T03: |Az adatbázisból egy nem létező könyvre való rákeresés            |Szellem rekord nincs az adatbázisban|sikeres
T04: |Egy könyv hozzáadása az adatbázishoz                             |A rekord megjelenik a felületen|sikeres
T05: |Egy könyv állapotának kikölcsönzöttről való átállítása elérhetőre|A könyv megjelenik az elérhetőek közt|sikeres
T06: |Egy könyv állapotának elérhetőről való átállítása kikölcsönzöttre|A könyv megjelenik a tag kölcsönzései közt és eltűnik az elérhetőből|sikeres
T07: |Egy tag felvétele a tagok adatbázisába                           |Az új tag megjelenik a DB-ben|sikeres
T08: |Egy tag eltávolítása a tagok adatbázisából                       |A tag nem jelenik meg többet a DB-ben|sikeres
T09: |Egy könyv kikölcsönzése                                          |A könyv megjelenik a kölcsönző tagnál és kikerül az elérhetőből|sikeres
T10: |Több könyv kikölcsönzése                                         |A könyvek mind kikölcsönződnek (fentebb)|sikeres
T11: |Egy könyv kitörlése a könyvek adatbázisából                      |A könyv többet nem jelenik meg a DB-ben|sikeres
T12: |A program a bezárásra kattintva megerősítést vár|Dialógus felugrik|sikeres
T13: |Nem megerősített kilépés| Fut tovább |sikeres
T14 | Megerősített kilépés | A program leáll | sikeres
T15 |A kilépés gombbal való kilépés | megerősítést vár | sikeres
T16 | TextField SQL injection Stringként |A megfelelő mezőbe beilleszti a script szövegét  |sikeres 
T17: |TextField SQL számként | Nem fogadja el |sikeres
T18:|Primary key violation | Érvénytelen érték hibaüzenetet dob | sikeres
T18: | Szöveg szám helyén | Érvénytelen érték hibaüzenetet dob | sikeres
T19: |A screenek vissza gombja (kivéve kölcsönzés) | A főmenübe visz | sikeres
T20: |Kölcsönzés screen vissza gombja | Tagválasztáshoz visz | sikeres
T21: |Új könyv kiválasztás | kattintva a fieldek kitöltödnek a választott rekord értékeivel | sikeres
T22: |Új tag kiválasztás | kattintva a fieldek kitöltödnek a választott rekord értékeivel | sikeres
T23: |Könyv törlése | kattintva a fieldek kitöltödnek a választott rekord értékeivel | sikeres
T24: |Tag törlése | kattintva a fieldek kitöltödnek a választott rekord értékeivel | sikeres
T25: | Tag módosítás | kattintásra a fieldek kitöltődnek a rekord értékeivel | sikeres
T26: | Könyv módosítás | kattintva a fieldek kitöltödnek a választott rekord értékeivel | sikeres
T27: | A könyv ID módosítása | disabled field | sikeres
T28: | A tag ID módosítása | disabled field | sikeres
