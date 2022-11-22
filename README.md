# TO-project
Airport services management
System zarządzania obsługą lotniska
1) System ma na celu usprawnianie obsługi naziemnej lotniska. 
Będzie to aplikacja typu klient-serwer, w której pracownicy 
o poszczególnych rolach będą mieli możliwość komunikacji ze 
sobą za pomocą GUI poprzez serwer. Funkcjonalności, jakie 
przewidujemy to synchronizacja pracy, informacje, jak ma 
zostać ona wykonana, potwierdzenie wykonania pracy, 
odliczanie czasu do odlotu maszyny. 
Role pracowników dostępnych w systemie to kierownik naczelny, 
kierownik stanowiska, serwis bagażowy, serwis cateringowy, serwis sprzątający, 
serwis boardingowy, serwis wypychający, serwis tankujący, serwis "follow me".
2) Wzorce strukturalne: Most, Dekorator 
   Wzorce behawioralne: Obserwator, Polecenie
3) Most - utworzenie hierarchii klas, np. Klasa samolot bedzie przechowywala odniesienie do odpowiedniego obiektu klasy Linie lotnicze, np. LOT, Lufthansa etc
   Dekorator - utworzenie dekoratora, który opakowujac obiekty ułatwi przesyłanie informacji na lotnisku wieloma kanałami jednocześnie np. w przypadku opóźnienia lotu
   Obserwator - ulatwienie publikacji komunikatów do wszystkich odbiorców, poprzez dodanie mechanizmu subskrypcji do klasy wysyłającej komunikaty
   Polecenie - stworzenie łącza pomiędzy obiektami interfejsu użytkownika i logiki biznesowej, tworzenie kolejki poleceń
