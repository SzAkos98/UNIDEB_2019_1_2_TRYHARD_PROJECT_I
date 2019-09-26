

# TRYHARD  
## Rendszerterv  
  
  
A korábbiakban elkészült Követelmény specifkácó és Funkcionális specifikáció  
alapján az alábbiakban a szoftver Rnedszertervét ismertetjük.  
  
  
### 1. A projekt tervezete  
  
  
A szoftver egy kisvárosi könyvkölcsönző működését hivatott elősegíteni.  
Célja az analóg rendszer digitálisra cserélése. Adminisztratív és egyébb  
feladatok ellátása számítógépes környezetben. A cél platformunk a kölcsönző  
tulajdonában lévő számítógépek mely Linux alapú operációs rendszer futtatnak,  
név szerint az Ubuntut. A megvalósítás miatt a program alkalmas lehet más  
operációs rendszer alatti futtatásra is, de ez nem elsődleges célja a  
fejlesztésnek. A gépek hardverje 8 GB DDR4 -es RAMból, egy Intel  
Core i7-8750H 2.20GHz típusú processzorból és egy NVIDIA GeForce GTX 1060  
típusú videókártyából állnak. A gépek számára biztosítvav van a stabil 10Mb/s  
sávszélességű internet elérés. A gépeket a kölcsönző dolgozói használhatják.  
Szándékunkban áll többféle jogosultságokkal rendelkező felhasználókat  
implementálni, és az adatbázist több munkaállomásról is eléhetővé tenni  
a helyi hálózaton. A rendszer felépítése egy szerver-kliens alapokra épülő  
modell, egy közös H2 adatbázis motorral rendelkező adatbázison, amely  
tárolja az elérhető könyveket, illetve az ügyfelek alapvetően szükséges  
adatait. Mivel a rendszerünket az első fázisban nem készítjük fel a külső  
támadások kivédésére, csak belső, tűzfallal elzárt privát hálózaton javasoljuk  
a használatát. Ezzel megelőzhetjük a személyes adatok kiszivárgását.  
Emiatt a felhasználási mód miatt jelenleg az ügyfelek számára csak közvetett  
regisztráció elérhető, így a GDPR tájékoztatót javasolt papir alapon 1  
példányban hitelesítve tárolnim illetve egyet az ügyfélnek adni, így  
megfelelő bizonyító erővel bír problémák felmerülésekor. A rendszer ezen  
megvalósításában alkalmas az megfelelő rekordok lekérdezésére, módosítására,  
törlésére. Ezen funkciók elosztására a különböző jogosultságú felhasználók  
közt később térünk ki.  
  
### 2. A rendszer felépítése  
  
  
A kiszolgáló egy Tomcat szerver lesz, amely eléri a szervergépen lévő  
adatbázist, feldolgozza a kéréseket, majd végrehajtja a megfelelő módosításokat  
az adatokon. Mivel a rendszer belső privát hálózaton működik, a jelen  
iterációban jelszó hashelést nem tervezünk implementálni a felhasználói  
loginoknál, ezért későbbi webes felhasználás esetén ez rendkívüli fontosságú  
feladat. Mivel a rendszer a szerveren fut, a programból gyakorlatilag egy  
példány szükséges a szerveren, a többi gép a böngészőből éri el a felületet.  
Az adatbázis kapcsolathoz szükséges egy adatbázis connection osztály,  
amely létrehozza, fenntartja, és zárja az adatbáziskapcsolatot.  
 A funkciókhoz szükség van servlet osztályokra, amelyek felelnek a megfelelő  
kérések felépítéséért. A felhasználóval való kommunikációt html-ben íródott  
interface valósítja meg, ezek praktikusan külső fájlokból, és forrásból  
módosított részekből állnak. Ennek a megoldásnak köszönhetően a felhasználók  
használhatnak saját megjelenési stílusokat is, a böngészőn keresztül. Az  
adatbázis miatt a rendszer egy esetleges szerver leállás után is perzisztens  
marad, és a szolgáltatás is visszaáll újraindítást követően, így az esetleges  
folyamatban lévő tranzakciókat leszámítva az adatok nem vesznek el.  
 Az adatbázisnak két lényegi táblája a könyveket, és az ügyfeleket tartalmazza.  
A kölcsönzés megvalósításához szükség van egy kapcsolótáblára is, amelynek  
rekordjai egy egy kölcsönzési folyamatot ábrázolnak, a kölcsönző azonosítójával,  
a kölcsönzött könyv azonosítójával,valamint a kölcsönzési dátummal, és a  
határidővel, visszahozási dátummal. A könyvek táblában eltároljuk a példány  
azonosítóját, könyvtári azonosítóját (ami nem unique), címét, szerzőjét,  
kiadóját, kiadás évét, illetve hogy épp elérhető-e. Az tag táblában az  
adott személy kereszt és vezetéknevét, születési dátumát, lakcímét,  
illetve az egyedi azonosítóját tároljuk. A törlés a foreign keyek miatt  
az adott rekord azonosítóján kívüli értékeinek NULL-ra állításával történik,  
mivel nem szeretnénk, hogy egy esetleges tag vagy könyv törlése után az ID-jük  
felszabaduljon, mert így valótlan kölcsönzési adatok is keletkezhetnének.  
 A html-ben megvalósított UI-ban ha megadjuk egy könyvnek az azonosításához  
szügséges információkat akkor a program visszaadja ,hogy a könyv megtalálható-e  
a könyvtár könyveit tároló adatbázisában, illetve jelenleg ki van-e kölcsönözve  
vagy kikölcsönözhető. Ha egy könyvet egy tag kikölcsönöz akkor lehetőség nyílik,  
a könyv elérhetőségének értékét megváltoztatni.  
A program tartalmazni fog egy olyan mezőt is ahol ha megadjuk egy tag azonosí-  
tásához szügséges információkat akkor az applikáció meg tudja mondani azt, hogy  
az illető tagja-e a könyvtárnak, továbbá meg lesz a lehetőség arra is ,hogy  
hozzáadjunk a könyvtári tagok listájához olyan embert is aki még nem tag.  
További funkció lesz például ,hogy a könyvtárosnak lehetősége nyílik a program  
segítségével ellenőrízni ,hogy a könyvet mikor kölcsönözték ki illetve  
a könyvtári tagnak meddig lesz esedékes visszahozni, illetve megtekinthető  
lesz az is ,hogy ki által lett kikölcsönözve a könyv.     
 A program megírásához css-t is fogunk alkalmazni mint wiew-ért felelős  
technológiát. Itt a program megírása során egy egyszerű, átlátható és  
szép desing létrehozását tűztük ki célul.  
A program controller részének a megvalósításához Java Servlet technológiát  
fogunk használni. A servlethez alapvetően szügséges könyvtárak listája a   
teljesség igénye nélkül:  
java.io.*;  
javax.servlet.*;  
javax.servlet.http.*;  
A servlet class-nak mindenképp ki kell majd terjesztenie a HttpServlet osztályt.  
A maven-be is szügséges felvenni dependency-ként a servletet illetve a H2 adatbázist:  

 
```xml  
<!-- https://mvnrepository.com/artifact/javax.servlet/servlet-api -->  
<dependency>  
 <groupId>javax.servlet</groupId> <artifactId>servlet-api</artifactId> <version>2.5</version> <scope>provided</scope></dependency>  
-------------  
<!-- https://mvnrepository.com/artifact/com.h2database/h2 -->  
<dependency>  
 <groupId>com.h2database</groupId> <artifactId>h2</artifactId> <version>1.4.197</version> <scope>test</scope></dependency>  
  
```
-------------  
```xml  
Illetve a tomcatet is fel kell venni plugin-ként:  
<plugin>  
 <groupId>org.apache.tomcat.maven</groupId> <artifactId>tomcat7-maven-plugin</artifactId> <version>2.2</version></plugin>  
  
```  
  
Könyv        | Kölcsönzés   |Tag  
------------| --------------|---------  
   ID Primary key|KolcsonzesID PRIMARY KEY, UNIQUE |unique INTEGER           
   LibID VARCHAR  |KonyvID FOREIGN KEY(KONYV.ID) INTEGER  |  Vezeteknev VARCHAR                         
   Szerzo VARCHAR |TagID FOREIGN KEY(TAG.ID) INTEGER  |   Keresztnev VARCHAR                     
   Cim  VARCHAR   | KolcsonzesDatum  DATE  |   Születési datum  DATE                     
   Kiado VARCHAR  |  |   Lakcim VARCHAR                    
   KiadasEve DATE |Hatarido DATE     |                     
   Elerheto BOOLEAN|VisszahozasDatum DATE        |   
  
### A HTML használata a felhasználói felület elrendezéséhez  
  
A HTML UI használatával A HTML UI használatával lehetővé teszi a bonyolult   
felhasználói felületek elhelyezését minimális zavarral; nagyszerű feladat az UI   
felépítésének és elrendezésének elválasztása az üzleti logikától; könnyű írni;   
és könnyen karbantartható illetve sok alkalmazás képes kiaknázni a HTML adta  
táblázatós és egyszerűbb lehetőségeit.Az UI modell mellett az  űrlapmezőket   
a végfelhasználóhoz is elrendezzük. Ez által könnyedén képesek leszünk  az   
adatbázisban H2 konzolos alkalmazás segítségével könyvtárban kölcsönzésre    
használható könyveket illetve az opcionális erre a célra felvet tagokat   
adatbázisát is. Amikor az UI Model varázsló segítségével modellt generálunk   
egy specifikációból, akkor  egy HTML 'snippet' fájlt is kapunk, amelyet   
felhasználhatunk az űrlapmezők elrendezésére. A  és   
 (cellák) címkéket használjuk a specifikáción belüli mezők elrendezésének  
megszervezésére.  A címkék barátságos nevet / feliratot adnak a vezérléshez.  
Az címkék felhasználói felület elemekhez használhatók,  
például a jelölőnégyzetekhez és a legördülő listákhoz.  Az címkék nagy   
szövegterületekhez használhatók.  A <div class = "bbui-formák-mezőkészlet-oszlop">   
címkék az űrlapmezők több oszlopba rendezésére szolgálnak, míg a   
<div class = "bbui-formák-tabs-main"> címkék az űrlapmezők tabulátorokba rendezésére szolgálnak .  
Használhatunk egy # MAP # elnevezési konvenciót az adat-specifikus metaadat-értékek   
leképezéséhez a HTML alapú felhasználói felületen. Az alábbiakban a címkét   
és annak id = "# MAP # NAME_caption" attribútumát használjuk a NAME űrlapa feliratának  
 megjelenítéséhez egy címkén  

 
/*  
ÚJRATERVEZETT RENDSZERTERV  
  
### Bevezetés  

A rendszerterv elkészítésének célja az ,hogy a program fejlesztőinek pontos,  
részletes és szaknyelvet tartalmazó leírás legyen a kezében ami kitér a  
rendszerrel kapcsolatos összes fontos szakmai kérdésre.
A szoftver egy kisvárosi könyvkölcsönző működését hivatott elősegíteni.
Célja az analóg rendszer digitálisra cserélése ennek következtében a könyvtár
 fenetarthatóságát képes növelni és a dolgozok munkáját meggyorsítani . 
 Adminisztratív és  könyv kölcsönzés és egyéb feladatok ellátása számítógépes 
 környezetben. A cél platformunk a kölcsönző tulajdonában lévő számítógépek mely 
 Linux alapú operációs rendszer futtatnak, név szerint az Ubuntut. A megvalósítás 
 miatt a program alkalmas lehet más operációs rendszer alatti futtatásra is, de 
 ez nem elsődleges célja afejlesztésnek. A gépek hardverje 8 GB DDR4 -es RAMból, egy Intel
Core i7-8750H 2.20GHz típusú processzorból és egy NVIDIA GeForce GTX 1060
típusú videokártyából állnak. A gépek számára biztosítva van a stabil 10Mb/s
sávszélességű internet elérés. Ez által a megfelelő infrastruktúra kiégetésével 
 megvan teremtve a megfelelő hátér ,hogy a dolgozok lehető legjobb hatásfokkal 
 képesek legyenek használni a szoftvert.  A rendszer felé pitése egy szerver-kliens 
 alapokra épülő modell,egy közös H2 adatbázis motorral rendelkező adatbázison, 
 amelytárolja az elérhető könyveket, illetve az ügyfelek alapvetően szükséges 
 adatait amely az "egyszerű és  egyben nagyszerű " elv alapján lesz elkészítve 
 ,hogy a könyvtárban dolgozók rövid tanulmányozás után képesek legyek átlátni a 
 szoftver és kényelmesen tudják használni azt.Ezért a tervezet szerint olyan 
 programozási nyelvet használunk ami megkönnyítői ennek a szoftvernek a leghatékonyabb
 le kódolását. Erről bővében a Fejlesztő eszközök menüpontban térünk ki. 
 A digitalizálás hatására sokall átláthatóbb kezelhetőbb és biztonságosabb lesz 
 az új rendszer a régihez képest.
   
  
### A rendszer célja  

A rendszer célja a könyvtár adminisztrációs munkájának megkönnyítése amit  
a programunk egy JavaFX felhasználói felülettel és SQL adatbázis rendszerrel  
szeretne elérni.  
  
  
### Projekt terv  
  
### Projektszerepkörök, felelősségek  
  
  
###  Projektmunkások és felelősségeik  
  
  
### Ütemterv  
A követelmény specifikációnak, funkcionális specifikációnak és a rendszertervnek  
legkésőbb 2019.09.26-ra kész kell lennie. Ezt követi majd a programsorok   
megírása amelynek a program átadására, vagyis 2019.09.30 a határideje.  
  
### Mérföldkövek  
  
A program elkészítésének fő mérföldkövei:  
- A Trelloban való regisztráció illetve a használatának elkezdése  
- A git repository elkészítése  
- A tagok git-re való regisztrációja illetve a projekthez felvétele  
- A követelményspecifikáció elkészítése  
- A funckionális specifikáció elkészítése  
- A rendszerterv elkészítése  
- A program JavaFX UI-jának elkészítése  
- A program adatbázisának elkészítése  
- A program controllerének elkészítése  
- A program tesztelése  
- A program bemutatása a megrendelőnek  
  
###  Üzleti szereplők  
  
A programot az éppen munkaidőben jelenlévő könyvtáros fogja használni.  
A könyvtár összes alkalmazottjának, akik ebben a munkakörben dolgoznak  
megvan a végzettsége és a tudása ahoz ,hogy TRYHARD csapat által készített  
programot magabiztosan képes legyen használni.  
  
###  Üzleti folyamatok  
  
Egy könyvtári tag bemegy a könyvtárba      A könyvtári tag felkeresi az éppen ott    
azzal a céllal,hogy könyvet szeretne   --> tartózkodó könyvári dolgozót aki képes az -->  
kikölcsönözni              általunk készített programot használni  
  
A könyvtári alkalmazott megnézi a program    Ha megtalálható  A tagok tájékoztatják a visszahozás dátumáról    
segítségével, hogy a kikölcsönözni kívánt    ---------------> majd távozhat a könyvel, továbbá a könyvtári alkalmazott  
könyv megtalálható-e a könyvtárban                            a könyv állapotát a programban átállítja nem   
   |                       kikölcsönzöttről kikölcsönzöttre  
   | Ha nem található meg a könyvtárban  
   |  
   ˇ  
A könyvtári alkalmazott tájékoztatja a tagot   
,hogy a könyv jelenleg nem áll rendelkezésre  
  
  
###  Üzleti entitások  
  
Az üzletben résztvevő entitások:  
- A programot használó könyvtári alkalmazott  
- A könyvtárban regisztrált tagok  
- A könyvtárban még nem regisztrált, de majd regisztráló tagok  
  
  
### Követelmények  
  
### Funkcionális követelmények  
  
  
###  Nemfunkcionális követelmények  
  
  
  
### Funkcionális terv  
  
 ### Rendszerszereplők  
  
### Rendszerhasználati esetek és lefutásaik  
  
  
### Határosztályok  
  
  
### Menü-hierarchiák  
  
  
### Képernyőtervek  
  
  
### Fizikai környezet  
  
### Vásárolt softwarekomponensek és külső rendszerek  
  
A gépek hardverje 8 GB DDR4 -es RAMból, egy Intel  
Core i7-8750H 2.20GHz típusú processzorból és egy NVIDIA GeForce GTX 1060  
típusú videókártyából állnak.  
  
### Hardver és hálózati topológia  
  
### Fizikai alrendszerek  
  
  
### Fejlesztő eszközök  
A projekt során használt fejlszetői eszközök:  
-Java  
-Tomcat  
-Maven  
-SQL  
### Keretrendszer  
  
-Java FX  
  
### Absztrakt domain modell  
  
### Domain specifikáció, fogalmak  
  
###  Absztrakt komponensek, ezek kapcsolatai  
  
  
### Architekturális terv  
  
### Egy architekturális tervezési minta  
  
A projekt során a az MVC(model-view-controller) modellt fogjuk alkalmazni.  
  
### Az alkalmazás rétegei, fő komponensei, ezek kapcsolatai  
  
### Rendszer bővíthetősége  
  
### Biztonsági funkciók  
  
  
  
### Adatbázis terv  
  
#### Logikai adatmodell  
  
Könyv        | Kölcsönzés   |Tag  
------------| --------------|---------  
   ID Primary key|KolcsonzesID PRIMARY KEY, UNIQUE |unique INTEGER           
   LibID VARCHAR  |KonyvID FOREIGN KEY(KONYV.ID) INTEGER  |  Vezeteknev VARCHAR                         
   Szerzo VARCHAR |TagID FOREIGN KEY(TAG.ID) INTEGER  |   Keresztnev VARCHAR                     
   Cim  VARCHAR   | KolcsonzesDatum  DATE  |   Születési datum  DATE                     
   Kiado VARCHAR  |  |   Lakcim VARCHAR                    
   KiadasEve DATE |Hatarido DATE     |                     
   Elerheto BOOLEAN|VisszahozasDatum DATE        |   
### Implementációs terv  
  
### Perzisztencia-osztályok  
  
  
### Üzleti logika osztályai  
  
  
### Kliensoldal osztályai  
  
  
  
### Tesztterv  
Kód|Leírás|  
----|---  
T01:| A program elindítása  
T02: |Az adatbázisból egy létező könyvre való rákeresés  
T03: |Az adatbázisból egy nem létező könyvre való rákeresés  
T04: |Egy könyv hozzáadása az adatbázishoz  
T05: |Egy könyv állapotának kikölcsönzöttről való átállítása elérhetőre  
T06: |Egy könyv állapotának elérhetőről való átállítása kikölcsönzöttre  
T07: |Egy tag felvétele a tagok adatbázisába  
T08: |Egy tag eltávolítása a tagok adatbázisából