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