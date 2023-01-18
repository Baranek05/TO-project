# TO-project
Airport services management

Projekt uruchamiany jest poprzez wysyłanie wiadomości poprzez endpointy zawarte w klasach z "Controller" w nazwie.

GeneralManager ma możliwość wysłania wiadomości, czasu przeznaczonego na obsługę samolotu do wybranego przez siebie, dostępnego StandManagera.

StandManager ma możliwość wysłania wiadomości, czasu przeznaczonego na obsługę samolotu do wybranego przez siebie, dostępnego serwisu. Ponadto wysłanie opcji "start" rozpoczyna procedurę obsługi lotu.

Poszczególne serwisy poprzez wysyłanie wiadomości finished, engines off albo ready przekazują następnemu w kolejce serwisowi, że może zacząć pracę, w kolejności:

Pilot (engines off) -> GeneralManager (send) -> StandManager (start) -> BoardingService (finished) -> LuggageService (finished) ->  CleaningService (finished) -> TankingService (finished) -> CateringService (finished) -> LuggageService (finished) -> BoardingService (finished) -> Pilot (ready) -> PushbackService (finished) -> Pilot
