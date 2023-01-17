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
kierownik stanowiska, pilot, serwis bagażowy, serwis cateringowy, serwis sprzątający, 
serwis boardingowy, serwis wypychający, serwis tankujący.
2) Wzorce strukturalne: Fasada

   Wzorce behawioralne: Stan, Metoda Szablonowa, Iterator
   
   Wzorce kreacyjne: Builder, Singleton
   
3) Metoda szablonowa - utworzenie abstract flight state zawierającego metody poszczególnych stanów. Konkretne stany nadpisują metodę która dotyczy ich stanu np.          PilotState nadpisuje metodę landed(). Jeżeli metoda zostanie użyta w innym stanie pojawia się błąd.
          
   Stan - utworzenie stanu dla każdego etapu działania poszczególnych serwisów, utworzenie kolejności zdarzeń - jeżeli aiport service posiada konkretny stan nie możemy w    nim wywołać działań dla innch stanów
          
   Fasada - stworzenie rekordu zawierającego wszystkie serwisy dla danego lotu, które przechowywane są w airport service
   
   Builder - budowanie obiektu zawierającego informacje o rodzaju pracy do wykonania
   
   Singleton - bazy danych zdefiniowane jako @Component 
   
   Iterator - użycie do przechodzenia po liście WorkOrders w celu znalezienia prac spełniających kryteria 
          iteracji (po numerze lotu) 
