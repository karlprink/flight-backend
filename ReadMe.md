# CGI Proovitöö - Flight API
Domeeni klassides FlightDTO, SeatBookingDTO, SeatDTO ja entity klassides Seat, Flight, SeatBooking kasutasin Lombokit, mis loob Java klassi koos setterite ja getteritega. Repository klassides kasutasin extend JpaRepository, mis pakub mugavaid meetodeid andmebaasiga suhtlemiseks.

Andmebaasi täitmiseks klassis FillSeatsWithData kasutasin AI abi, ise muutsin ainult tingimusi, mille põhjal istmele mingi väärtus antakse. AI-d kasutasin ka CSS disainis.

Kogu töö peale kulus umbes 30-35 tundi. Polnud varem kokku puutunud enamus vahenditega, mida kasutasin rakenduse loomiseks. Vaatasin internetist näidiseid, videosid ja suhtlesin ka mõne inimesega, kes on valdkonnaga rohkem kursis.

Kõige enesekindlamalt tundsin end backendi kirjutamisel. Suurem osa koodist ja lahendustest, mis on front endis, õppisin lahendamise käigus.

## Lokaalne käivitamine (dockeri väliselt)
Rakenduse kävitamiseks on vaja kõigepealt tööle panna andmebaas:

1. ``docker-compose up -d database``

Seejärel saab käivitada flight-api kas IntelliJ kaudu või käsurealt:

2. `` .\gradlew bootrun``


## Dockeris käivitamine
Backend rakenduse saab käima panna dockeris. Selleks on vaja jooksutada root kaustas käsud:

1. ``docker build -t flight-api .`` Jar fail on `/jar` kaustas

2. ``docker-compose up -d``


#### Autor: Karl Prink