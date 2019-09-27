# TRYHARD
# Követelményspecifikáció

## Bevezetés

Egy kisvárosi könyvkölcsönző viszonylag nagy forgalommal jár, a helyiek 
inkább kölcsönzik a könyveiket vásárlás helyett. A hely kifejezetten 
könyvtár hangulatú, a könyveket is könyvekben tartják nyilván. Napjainkban
azonban a jól bevált módszerek új kihívásokkal és vetélytársakkal néznek 
szembe a számítógépek személyében. Éppen ezért a kölcsönző vezetése is 
úgy döntött, hogy alkalmazkodik az új követelményeknek, és egy gyors és 
hatékony számítógépes rendszert vezet be.

## Jelenlegi helyzet

A könyvtár többszáz taggal rendelkezik, és büszkén mondhatjuk el magunkról,
hogy a könyvbázisunk is gyorsan növekszik. Ennek a gyors méretű növekedésnek a negatív oldala
viszont az, hogy az adminisztráció mértéke is jelentősen megugrik, mivel a könyveinket
is nyilván kell tartanunk nagy méretű indexekben, valamint a tagjainkat is, hogy a
kölcsönzéseik esetén fellépő esetleges problémák esetén értesíteni tudjuk őket
(például lejárt határidő, megrongálódott könyv). A rengeteg papírmunkán egyszerűsíthetne
egy közös informatikai rendszer, amelyet minden dolgozónk elérhet,
és megfelelően módosíthat.

## Vágyálom rendszer


Szeretnénk a papír ceruza rendszernél hatékonyabb rendszert beüzemeltetni,
ami meggyorsítja a folyamatainkat, és megkönnyíti munkatársaink munkáját. 
A munkaállomáson már található számítógé,mely szükség esetén interneteléréssel
 is rendelkezik. Ezen gépre szeretnénk egy szoftvert, amiben nyilvántarthatnánk
 a könyveinket, illetve az ahhoz kapcsolódó folyamatokat. Szeretnénk a könyveken 
 kívül az ügyfeleinket is legalábbis beazonosítható szinten nyilvántartani. Továbbá
 az egyes ügyfelek kölcsönzéseit, valamint azok határidejét is. Ez segíthet abban,
 hogy ne kelljen percekig a sorok közt keresni az épp nem rendelkezésre álló könyvet.
 A célunk, hogy a korábbi analóg módszert teljesen felválthassa a digitális.

## Jelenlegi üzleti folyamatok

Jelenleg a könyvtár rendszere a klasszikus papír alapú nyilvántartás
segítségével működik. Az ügyfeleink könyvtári tag kártyával tudják igénybe
venni a könyvtár szolgáltatásait illetve, az ügyfelek több oldalas listán
vannak rendszerezve. Ez az ügyfelek ilyen módon való rendszerezése már egy
kis vagy közepes tag létszámmal rendelkező könyvtár esetében is káosz lehet.
Egy könyv kikölcsönzése esetén az ügyfél kap egy lapot amin a visszahozás
dátuma szerepel viszont ha más is ki akarja kölcsönözni ugyanazt a könyvet
ami jelenleg kikölcsönzés alatt áll akkor a könyvtárosnak végig kell néznie
a könyvtár aktuális részét ,hogy a könyv megtalálható-e. A könyvtárosnak azzal 
is nagyon nehéz dolga van ,hogy a kikölcsönzött könyvek visszahozási határidejét
nyomon kövesse illetve ha valaki elfelejtkezik a könyv visszahozásáról azt
értesítse a késedelméről és annak következményeiről. A jelenlegi üzleti folyamatok
elavultnak bizonyulnak.

## Igényelt üzleti folyamatok modellje

Könyvtár szeretné kiküszöbölni a jelenlegi analóg rendszer általi nehézségeket
így, mint minden kisebb-nagyobb cég ők is követik digitalizációt.Igényeik szerint
több funkciós platform lenne, mely teljes mértékben felváltaná a mostani rendszert.
A program funkciói között szerepel a legtöbb jelenlegi folyamat digitális változata.
Nem ragaszkodnak az online adatbázishoz továbbá a lokális hálózaton való adat eléréshez.
Megelégednek egy önálló gépen működő programmal. A rendszer képes kell, hogy legyen 
egy adott könyvről több adat tárolására is, hogy éppen kinél van, meddig van nála és, 
hogy mikor esedékes a könyvtárba való vissza hozatala. Emellett igen fontos lenne a 
könnyű kezelhetőség és egyben átláthatóság a felhasználók számára.



## Követelménylista

* Egy rendszer mely nyílvántartja a forgalomban lévő könyveket.
* A rendszer képes legyen egy adott elemről több adatot is tárolni.
* A nyilvántartásba lehtővé kell tenni a meglévő elemek módosítását, törlését
   és új elem létrehozását.
* A rendszer képes legyen kiválogatni a tételeket különböző szempontok alapján.
* Legyen lehetősége az alap felhasználónak is lekérdezést végrehajtani.
* A program egyszerűen kezelhető és letisztult képi világgal rendelkezzen.


