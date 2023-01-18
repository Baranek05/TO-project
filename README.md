# TO-project
Airport services management

Projekt uruchamiany jest poprzez wysyłanie wiadomości poprzez endpointy zawarte w klasach z "Controller" w nazwie.

GeneralManager ma możliwość wysłania wiadomości, czasu przeznaczonego na obsługę samolotu do wybranego przez siebie, dostępnego StandManagera.

StandManager ma możliwość wysłania wiadomości, czasu przeznaczonego na obsługę samolotu do wybranego przez siebie, dostępnego serwisu. Ponadto wysłanie opcji "finished" rozpoczyna procedurę obsługi lotu.

Poszczególne serwisy poprzez wysyłanie wiadomości finished, engines off albo ready przekazują następnemu w kolejce serwisowi, że może zacząć pracę, w kolejności:

Pilot (engines off) -> GeneralManager (send) -> StandManager  (send) -> StandManager (finished) -> LuggageService (finished) -> BoardingService (finished) -> TankingService (finished) -> CleaningService (finished) -> CateringService (finished) -> BoardingService (finished) -> LuggageService (finished) -> Pilot (ready) -> PushbackService (finished) -> Pilot
