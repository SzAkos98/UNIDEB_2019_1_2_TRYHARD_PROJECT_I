# TRYHARD
# Funkcionális specifikáció


## Bevezetés

Egy kisvárosi könyvkölcsönző viszonylag nagy forgalommal jár, a helyiek
inkább kölcsönzik a könyveiket vásárlás helyett. A hely kifejezetten
könyvtár hangulatú, a könyveket is könyvekben tartják nyilván. Napjainkban
azonban a jól bevált módszerek új kihívásokkal és vetélytársakkal néznek
szembe a számítógépek személyében. Éppen ezért a kölcsönző vezetése is
úgy döntött, hogy alkalmazkodik az új követelményekhez, és egy gyors és
hatékony számítógépes rendszert vezet be. Erre az igényre alapozva
terveztük meg a programot, hogy a felvetett problémákra gyors és praktikus
megoldást nyújthasson, és hasznos eszköz legyen a kölcsönző mindennapjaiban.


## Használati esetek


A Követelmény specifikáció 'Követelménylista' című bekezdése alapján az
egyes pontok kifejtésére kerül sor ebben a fejezetben.



* A programmal lehetőséget szeretnénk nyújtani a felhasználók
   kölcsönzéseinek nyilvántartására. Továbbá a kölcsönzőben dolgozó
   személyzet számára szeretnénk átláthatóbbá tenni az adminisztrációt.

* Az egyes tételekről (melyek a mi esetünkben a kölcsönözhető könyvek)
   szeretnénk a lehető legtöbb információt eltárolni. A könyvek címét,
   szerzőjet, megjelenésének dátumát, kölcsönzési státuszát (ki van-e
   kölcsönözve vagy sem), a kivétel időpontját és a kölcsön lejáratának
   dátumát.

* A dinamikusan változó nyilvántartás lehetőséget kínál ,hogy ez által új 
   tagokat vehessen fel a könyvtár vagy az esetlegesen megszűnő tagságokat könnyen
   és egyszerűen képes legyen kitörölni, vagy ha egy felhasználónak megváltoznak
   az adatai akkor azt a lehető legegyszerűbben képes legyen a dolgozó módosítani.
   A könyvek listáját is könnyedséggel lehet változtatni, hogy éppen bent van-e a
   könyvtárban a könyv vagy sem. Illetve ,hogy melyik tagnál helyezkedik el. Az új
   könyvek felvételét is lelehet bonyolítani vagy a megrongált sérült könyveket
   is könnyedén ki lehet vonni az adatbázisból.

* A program segítséget nyújt ,hogy a felhasználó különböző szempontok alapján
   mint pl: kölcsönzés dátuma szerint tudja csökkenő vagy növekvő sorendbe 
   listázni a kivett könyveket. Így könnyedén látható ,hogy ki az akinek esedékes
   a könyv visszahozása a könyvtárba. De ide tartozik ,hogy leellenőrizhesse
   akár a könyvtárban dolgozó, hogy adott szerzőhöz milyen művek kapcsolódnak
   és éppen kint vannak egy tagnál vagy kivehetők-e.

* A szoftverben az egyik legfontosabb „funkció” az nem más mint ,hogy egyszerű 
   könnyen kezelhető és átlátható legyen a felhasználók számára.

## Jelenlegi helyzet

A mostani analóg, vagyis papír és ceruzán alapuló könyvtár megérett arra a szintre,
hogy modernizálja magát és belépjen a huszadik századba. Ez által meggyorsítva
a mostani rendszert. Így a későbbiekben képes lehet tartani a versenyt és kiszolgálni a 
könyvtárba járó közönséget. Mert így képesek lesznek a könyvtárban dolgozók villám
gyorsan lekérdezni az adatbázisból, hogy az adott könny része-e a könyvtárnak. Bent 
van-e a könyv, illetve ha kint van egy tagnál akkor az illetőnek mikor esedékes a könyv 
vissza hozatala. Ezek a folyamatok eddig hosszú perceket vettek el mind a könyvtáros
és mind a tag idejéből. Ami a mostani világban már tarthatatlan. Így kényszerből is
muszáj megváltozni a könyvtárnak a jelenlegi rendszert.

## A rendszernek NEM célja

* A tagok számára felületet biztosítani a kölcsönzéseik listázására, vagy
   bármilyen kölcsönzőbeli adatuk elérésére.

* Webes környezetben való alkalmazásra, interneten keresztüli elérésre, mivel
   a könyvtár jelenleg nincs felkészítve az esetleges interneten felmerülő veszélyekre.
   
* Figyelmeztetést küldeni annak a tagnak akinek lejárt a kölcsönzési ideje vagy
   közelít a határidő végéhez

## Jelenlegi üzleti folyamatok modellje

A tagok és a könyvek listáját egy relációs adatbázis váltja ki, amelyben ezek az
adatok tökéletesen tárolhatóak, és különböző szűrőkkel gyorsan lekérdezhetőek.
 A menüből választhatóak ki az alapvető tevékenységek.

 - A Könyvtáros felhasználó menüje:
    * Kölcsönzés
    * Új tag
    * Új könyv
    * Tag adatainak szerkesztése
    * Könyv adatainak szerkesztése
    * Tag törlése
    * Könyv törlése
    * Kilépés
    
 A kölcsönzési folyamat megkezdésekor a 'Kölcsönzés' menüponot választva a könyvtáros megadja
a kölcsönző nevét és a könyv azonosítóját, ezt a rendszer eltárolja, majd megjeleníti a
 kölcsönzési határidőt, amit a könyvtáros így megadhat a tagnak. Ugyan ez a menüpont 
 használható a vissza hozott könyvek adminisztrálására is. Az 'Új tag' és az 'Új könyv' menüpontokon
 keresztül tud a felhasználó új "elemeket" felvenni az adatbázisba. A 'Tag adatainak szerkesztése'
 és a 'Könyv adatainak szerkesztése' menüpontok használhatóak az "elemek" adatinak módosítására az
 adatbázisban. A 'Tag törlése' és a 'Könyv törlése' menüpontok használhatók tételek törlésére az
 adatbázisból. A 'Kilépés' menüponttal zárható be a program.

**Folyamatleírás a jelenlegi üzleti folyamatok szemléltetésere:**

A könyvtári tag besétál a könyvtárba könyv kölcsönzési céllal.
Felkeresi a könyvtár egy kölcsönzését felelős alkalmazottját.
A tag elmondja a könyvtárosnak, hogy milyen könyvet vagy könyveket szeretne kikölcsönözni.

Elérető a könyv?

Igen: A könyvtáros átadja a tagnak a könyvet és felírja ,hogy a könyvet kiadta, illetve
tájékoztatást ad a visszahozás dátumáról

Nem: A könyvtáros tájékoztatást ad arról ,hogy a könyv mikor lesz ismét elérhető.
Ha nem érhető el a könyvtárban akkor nem juthat hozzá a tag a könyvhet a könyvtárban.

## Igényelt üzleti folyamatok


A program alapvetően egy főmenűből, és a menüből nyitható funkció képernyőkből
áll. A főmenüből elérhető az összes funkció, valamint a kilépési lehetőség.
A program célja, hogy gyakorlatilag egy adatbázis előnyeit SQL utasítások
használata nélkül élvezhessük. Így a fontosabb funkciók használatára kell lehetőséget
biztosítanunk a userek számára.

A következő funkciók a fontosabbak:
   - lekérdezés
   - létrehozás
   - módosítás
   - törlés

Ezen funkciókat kivezetjük a grafikus felhasználói interfacere, így
egyszerűen a használat a felhasználók számára.
 Mivel az adott folyamat megszabja melyik táblának az elemeit használjuk,
így csak a szűréssel kell törődnünk.
A lekérdezés esetén gyakorlatilag a könyv kölcsönzés funkciót értjük, ekkor
a kapcsoló táblába helyezünk el érték párokat.
A létrehozás az új könyv/új tag regisztrálásának felel meg, ekkor a megfelelő
táblába illesztünk be új rekordokat, tehát a mezők kitöltésére biztosítunk lehetőséget.
A módosítás papíron sokkal körülményesebb, de a rendszerben csak ki kell választani a
módosítandó rekordot, és átírni a módosítani kívánt értéket.
A törlés nagyon hasonló folyamat a módosításhoz, viszont itt a kijelölt rekord minden
értékét nullra állítjuk, az azonosítóján kívül.

**Folyamatleírás az igényelt üzleti folyamatok szemléltetésére:**

A könyvtári tag besétál a könyvtárba könyv kölcsönzési céllal.
Majd felkeresi a könyvtár egy kölcsönzését felelős alkalmazottját.
A tag elmondja a könyvtárosnak, hogy milyen könyvet vagy könyveket szeretne kikölcsönözni.

_Elérhető a könyv?_

Igen: A könyvtáros átállitja a könyvet elérhetőről kikölcsönzöttre és közli 
a taggal ,hogy mikorra kell visszahozni a könyvet.

Nem: A könyvtáros közli a taggal, hogy a könyv sajnos nem elérhető ebben a könyvtárban.



## Képernyőtervek

A képernyőknek vannak közös elemei, ezek a navigációs gombok, melyek aktiválják
az adott funkciót, illetve visszalépnek a menübe.

A jelen esetben a kölcsönzőben szükség van:

   - #### Főmenü
        
    Kölcsönzés
    Új tag
    Új könyv
    Tag módosítás
    Könyv módosítás
    Tag törlés
    Könyv törlés
    Kilépés
   
   - #### Kölcsönzési folyamat indítása
      
      Szükség van az adott könyv/ek és a kölcsönző tag rekordjaira is, ezért
      mindkettőre külön külön szűrni tudni kell.
      + A tag adataira szűrő mezők
      + A taghoz tartozó szűrt választható rekordok listája
      + A könyv szűrői
      + A könyvek közti találatok a szűrések alapján
      + Az épp hozzáadandó könyvek listája

   - #### Új könyv felvétele
   
        + A rekordok táblázatos formában
        + A rekord attribútumainak megfelelő számú szöveges mező,
        + navigációs gombok.
   
   - #### Új tag felvétele
   
        + A rekordok táblázatos formában
        + A rekord attribútumainak megfelelő számú szöveges mező,
        + navigációs gombok.
        
   -  #### Meglévő könyv módosítása
   
         + A rekordok táblázatos formában
         + A rekord attribútumainak megfelelő számú szöveges mező,
         + navigációs gombok.      
   
   -  #### Meglévő tag módosítása
   
         + A rekordok táblázatos formában
         + A rekord attribútumainak megfelelő számú szöveges mező,
         + navigációs gombok.  
            
   - #### Meglévő könyv törlése
        Külön képernyőn a véletlen törlések elkerülésére. A törléshez rá
        kell szűrni a rekordra vagy kiválasztani a táblázatból.
        + A képernyő egy táblázatos reprezentációából áll a rekordoknak,
        + a lekérdező szűrők szövegmezői
        + navigációs gombok.
   
   - #### Meglévő tag törlése
        Külön képernyőn a véletlen törlések elkerülésére. A törléshez rá
        kell szűrni a rekordra vagy kiválasztani a táblázatból.
        + A képernyő egy táblázatos reprezentációából áll a rekordoknak,
        + a lekérdező szűrők szövegmezői
        + navigációs gombok.
