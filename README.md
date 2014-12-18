Maisto bankas
=============

[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/apuokenas/MaistoBankas?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

`PI;N` (angl. `TL;DR`)

Maisto produktų apskaitos programėlė "Maisto bankas": subalansuota "Maisto banko" savanoriams, bet tinka ir "Maltiečių ordino" virtuvių šefams bei kebabinių gaspadinėms!

Programėlė "Maisto bankas" yra licencijuota pagal ["Apache License"](http://choosealicense.com/licenses/apache-2.0) sąlygas, vadinasi, programinę įrangą galima laisvai:
* Naudoti bet kokiu tikslu.
* Modifikuoti.
* Platinti (tiek originalią, tiek modifikuotą versijas).
Vienintelė ribojanti sąlyga - privaloma išsaugoti autorines teises ir atsišaukimą (jei toks yra) bei nereikalauti jokių autorinių honorarų.

### Projekto techniniai niuansai

Šiame dokumente galite susipažinti, kaip vyksta programėlės tobulinimas, apauginant ją nauju funkcionalumu ir koreguojant ar atsisakant senesnio, nebeatitinkančio vartotojų poreikių (arba bankrutavus kokiam nors API teikėjui).

Idėjų semtasi iš kyborgų korifėjaus Viliaus Kraujučio 2014 m. vasarį "Vinted" patalpose vestų ["Android" mokymų](https://plus.google.com/u/0/events/c24nklguv5saguo9sj29mpbuo7g) mokymų, kurių metu buvo šnekučiuojamasi programuotojams skirtoje tarnyboje ["Gitter"](https://gitter.im).

### Programavimo aplinkos įdiegimas

Jei norite prisidėti, tobulinant aplikaciją, turite lokaliai įsidiegti:

* Naujausią oficialią integruotą "Android" programavimo aplinką ["Android Studio"](http://developer.android.com/sdk/index.html).
* Projekto *buildinimo* automatizavimo įrankį ["Gradle" (v2.2.1)](http://services.gradle.org/distributions/gradle-2.2.1-all.zip).
* Programavimui "Java" kalba skirtą priemonę ["Java SE Development Kit 8"](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).

### "Android" programėlės generavimas

Pasinaudojus "Android Studio" vedliu, iš "GitHub" kodo versijavimo sistemos galima parsiųsti programėlės struktūrą:

VCS --> Checkout from Version Control... --> GitHub.

Atsidariusiame lange į "Vcs Version URL" laukelį įveskite:
`https://github.com/apuokenas/MaistoBankas.git`,
o kaip "Parent Directory" nurodykite vietinį aplanką, kuriame talpinsite projekto failus.

P. S. Savo mašinoje reikia turėti git.exe bylą, kurios adresas įvedamas per "Settings" meniu:

File --> Settings --> Version Control --> Git.

Lauke "Path to Git executable" nurodomas kelias iki minėto failo. Pvz., jei esate "Windows" vartotojas:

C:\Users\[Vartotojas]\AppData\Local\GitHub\PortableGit_[40_raidžių_ir_skaičių]\bin\git.exe.

Kodo modifikacijas ir susijusius komentarus galite peržiūrėti "GitHub" [pakeitimų įrašuose](https://github.com/apuokenas/MaistoBankas/commits).

### `Layout` komponentai pagrindiniame `fragment`'e

* Mygtukas "Nustatymai", atidarantis produktų rinkimo (parduotuvės) arba valgių gaminimo vietos informacijos suvedimo `fragment`'ą.
* Mygtukas "Skenuoti".
* Sąrašas (`ListView`) nuskenuotų prekių išvedimui į ekraną.

## "Nustatymų" `fragment`'o pridėjimas

Tai paprasta forma, kurioje randami keli įvesties laukeliai:

* Miestas
* Adresas
* Parduotuvės pavadinimas
* Savanorio vardas

Ir, žinoma, *mygelis* "Išsaugoti".

## Brūkšninio kodo skenerio implementavimas

Brūkšninius kodus skenuoja kita į "Knygų Kalėdas" integruota programėlė - ["ZXing"](https://github.com/zxing/zxing) (dar žinoma kaip "Zebra Crossing").
Skenavimas vykdomas, naudojantis `Intent`'u.
Instrukcijas, kaip visa tai integruoti, galite rasti [čia](https://github.com/zxing/zxing/wiki/Scanning-Via-Intent).

## `Activity` gyvavimo ciklo registravimas

Siekdamas geriau suprasti `Activity` ir `Fragment` gyvavimo ciklus (angl. *lifecycle*), peržiūrėjau atitinkamą [diagramą](http://developer.android.com/training/basics/activity-lifecycle/starting.html), kuria remiantis, įdėjau `Log.d()` komandas į `BaseActivity` šiuose metoduose:
* OnCreate()
* OnStart()
* OnResume()
* OnPause()
* OnStop()
* OnDestroy()

## `Fragment`'ų gyvavimo ciklo registravimas

nalogiškai `Activity` gyvavimo ciklo *loginimo* atvejui, pasidariau `Fragment` gyvavimo ciklo registravimą.
Apie `Fragment` gyvavimo ciklus galima pasiskaityti [oficialioje "Google" dokumentacijoje](http://developer.android.com/guide/components/fragments.html)

Taigi reikia susikurti `BaseFragment` pagrindinę klasę, kurioje patalpinti *loginimo* metodai:
* onAttach()
* onCreate()
* onCreateView()
* onActivityCreated()
* onStart()
* onResume()
* onPause()
* onStop()
* onDestroyView()
* onDestroy()
* onDetach()

## Duomenų bazės, skirtos saugoti brūkšninius kodus, integravimas

Funkcionalumas įgyvendintas, pasitelkus ["ORM Lite"](http://ormlite.com/sqlite_java_android_orm.shtml).

### Duomenų modelio kūrimas

## Saugotina informacija

Prekė `Item`:

* `barcode` - prekės brūkšninis kodas
* `name` - prekės pavadinimas
* `price` - prekės kaina
* `weight` - prekės svoris (bnors fizikiškai tiksliau būtų vadint mase)
* `image_url` - prekės nuotrauka

Nuskenuota prekė `ScannedItem`:

* `id` - unikalus konkretų skenavimą identifikuojantis numeris
* `barcode` - prekės brūkšninis kodas
* `time` - skenavimo laikas
* `place` - skenavimo vieta
* `volunteer` - savanoris (taip pat gali būti virtuvės šefas ar namų šeimininkė, priklausomai nuo aplinkybių, kuriomis naudojama aplikacija)

### Naujai skenuojamų produktų išsaugojimas duomenų bazėje

Sukuriamas ir duomenų bazėn patalpinamas naujas `ScannedItem` objektas.

Apie tai, kaip susikurti "ORM Lite" duomenų bazės `Helper` klasę, galima sužinoti iš šių šaltinių:
* [ORM naudojimas kartu su "Android" operacine sistema](http://ormlite.com/javadoc/ormlite-core/doc-files/ormlite_4.html#Use-With-Android)
* [ORM taikymo "Android'e" pavyzdžiai](http://ormlite.com/android/examples)
* [Konkretus taikomasis pavyzdys "GitHub'e"](https://github.com/j256/ormlite-examples/blob/master/android/HelloAndroid/src/com/example/helloandroid/DatabaseHelper.java)

Pasinaudojant `Helper` klase, įrašas išsaugomas duomenų bazėje.

### Irašų, išsaugotų duomenų bazėje, rodymas

## Atvaizduojamas nuskenuotų prekių sąrašas vis atnaujinamas naujais įrašais iš duomenų bazės

* `MainFragment`'e `onResume` metode iškviečiama `dbHelper.getScannedItemDao().queryForAll()` funkcija.
* Sąrašas bus atvaizduotas, sukūrus naują adapterį.
* Sąrašo eilutės vaizduojamos sukurtame `layout`'e (kol kas - tik su `TextView`, skirtu ekranan išvesti brūkšninį kodą).

## Nuskenuotos prekės informacijos rodymas

* Duomenys apie maisto produktą gaunami ir atitinkamas duomenų modelis sukuriamas, naudojant REST klientą ["Retrofit"](http://square.github.io/retrofit).
* Prekės informacijos talpinimas duomenų bazėje.
* Prekės informacijos pavaizdavimas sąraše.
* Prekės paveiksliukas rodomas, pasitelkus paveikslėlių siuntimo ir kešavimo (talpinimo į podėlį) biblioteką ["Picasso"](http://square.github.io/picasso).
* Rodoma papildoma prekės informacija.
* `Nustatymai` mygtukas įtrauktas į meniu.
* `Skenuoti` mygtukas centruojamas apačioje.
* Naujausi nuskenuoti įrašai rodomi viršuje.
* Kai kur naudojama animacija.

Ne pagal "Material Design" principus sukurtos vartotojo sąsajos pavyzdys:
![2014-03-29 14 37 12](https://cloud.githubusercontent.com/assets/1859636/2558559/b9318ae4-b74f-11e3-8705-30dfbd4ab074.png)
