# Tesztelési jegyzőkönyv

2019.9.29. - Debrecen

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
T12 |A kilépés gombbal való kilépés | megerősítést vár | sikeres
T13 | TextField SQL injection Stringként |A megfelelő mezőbe beilleszti a script szövegét  |sikeres 
T14: |TextField SQL számként | Nem fogadja el |sikeres
T15:|Primary key violation | Érvénytelen érték hibaüzenetet dob | sikeres
T16: | Szöveg szám helyén | Érvénytelen érték hibaüzenetet dob | sikeres
T17: |A screenek vissza gombja (kivéve kölcsönzés) | A főmenübe visz | sikeres
T18: |Kölcsönzés screen vissza gombja | Tagválasztáshoz visz | sikeres
T19: |Új könyv kiválasztás | kattintva a fieldek kitöltödnek a választott rekord értékeivel | sikeres
T20: |Új tag kiválasztás | kattintva a fieldek kitöltödnek a választott rekord értékeivel | sikeres
T21: |Könyv törlése | kattintva a fieldek kitöltödnek a választott rekord értékeivel | sikeres
T22: |Tag törlése | kattintva a fieldek kitöltödnek a választott rekord értékeivel | sikeres
T23: | Tag módosítás | kattintásra a fieldek kitöltődnek a rekord értékeivel | sikeres
T24: | Könyv módosítás | kattintva a fieldek kitöltödnek a választott rekord értékeivel | sikeres
T25: | A könyv ID módosítása | disabled field | sikeres
T26: | A tag ID módosítása | disabled field | sikeres
T27: |A Kilépés menüpontra kattinva felugrik a Megerősítés ablak | Dialógis      |sikeres
T28: |A Megerősítés ablak | az OK gombra kattintva a programból ki lehet lépni| sikeres
T29: |A tag módosítása |nem lehet az ID-t megváltoztatni |sikeres
T30: |A könyv módosítása | nem lehet az ID-t megváltoztatni |sikers
T31: |A tag módosítása | nem lehet már létező ID-t megadni |sikeres
T32: |A könyv módosítása | lehet már létező ID-t megadni |sikeres
T33: |A tag módosítása | módosítás esetén muszáj minden field-et kitölteni |sikeres
T34: |A könyv módosítása | módosítás esetén muszáj minden field-et kitölteni |sikeres
T35: |A kölcsönzés | első megjelenő ablakban ki lehet választani a tagot aki könyvet szeretne kikölcsönözni |sikeres
T36: |A kikölcsönzés | második megjelenő ablakn hozzá lehet adni a kölcsönzött könyvek listájához egy könyvet |sikeres
T37: |A kikölcsönzés  | második megjelenő ablakján hozzá lehet adni a kölcsönzött könyvek listájához több könyvet |sikeres
T38: |Már kikölcsönzött könyv |A jelenleg kikölcsönzött könyvet más nem kölcsönözheti ki |sikeres
T39: |A tag vissza tud hozni könyvet a könyvtárba| megjelenik az elérhetőek közt és kikerül a tag kölcsönzéseiből |sikeres
