# Book Catalog API

API REST didattica per la gestione di un catalogo di libri in memoria. Il progetto consolida le basi di Spring Boot: controller, service, validazione e corretta costruzione delle risposte HTTP.

## Competenze dimostrate

- creazione di endpoint REST con Spring Web MVC;
- dependency injection tramite costruttore;
- separazione tra controller e service;
- validazione del modello con Jakarta Validation;
- utilizzo di `ResponseEntity` e header `Location`;
- ricerca tramite Stream API;
- controllo dei duplicati ISBN;
- gestione di dati monetari con `BigDecimal`.

## Funzionalità implementate

- catalogo iniziale con dieci libri;
- elenco completo;
- ricerca per identificativo;
- inserimento di un nuovo libro;
- assegnazione progressiva dell'identificativo;
- rifiuto di ISBN duplicati.

## Tecnologie

- Java 21
- Spring Boot 4.1
- Spring Web MVC
- Jakarta Validation
- Maven Wrapper

## Modello `Book`

| Campo | Tipo | Validazione |
|---|---|---|
| `id` | `Long` | assegnato dal service |
| `title` | `String` | obbligatorio |
| `author` | `String` | obbligatorio |
| `isbn` | `String` | obbligatorio e non duplicato |
| `price` | `BigDecimal` | maggiore di zero |
| `publicationDate` | `LocalDate` | non futura |

## Endpoint

| Metodo | Endpoint | Descrizione | Risposta principale |
|---|---|---|---|
| `GET` | `/books` | Elenca tutti i libri | `200 OK` |
| `GET` | `/books/{id}` | Recupera un libro | `200 OK` |
| `POST` | `/books` | Inserisce un libro | `201 Created` |

### Payload di esempio

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "978-0132350884",
  "price": 35.50,
  "publicationDate": "2008-08-01"
}
```

## Architettura

- `BookController`: espone gli endpoint;
- `BookService`: mantiene il catalogo e applica le regole;
- `Book`: rappresenta il dominio e le validazioni.

## Avvio

### Requisiti

- JDK 21

```bash
git clone https://github.com/fabiozagaria/book-catalog-api.git
cd book-catalog-api
./mvnw spring-boot:run
```

Su Windows utilizza `mvnw.cmd spring-boot:run`. Il servizio sarà disponibile su `http://localhost:8080`.

## Limiti attuali

- i dati vengono persi al riavvio;
- non sono esposti endpoint di modifica ed eliminazione;
- le eccezioni non sono ancora convertite in un modello di errore globale;
- non sono presenti DTO separati o test applicativi completi.

## Sviluppi successivi

- completare le operazioni CRUD;
- introdurre DTO e gestione centralizzata degli errori;
- aggiungere persistenza con JPA e MySQL;
- aggiungere test unitari e di integrazione.

## Autore

Fabio Zagaria — esercizio Spring Boot dedicato alle basi delle REST API.
