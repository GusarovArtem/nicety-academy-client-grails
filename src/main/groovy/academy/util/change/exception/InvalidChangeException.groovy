package academy.util.change.exception

class InvalidChangeException extends RuntimeException {

    final academy.util.entity.EntityChangedEvent changeEvent

    InvalidChangeException(String message, academy.util.entity.EntityChangedEvent changeEvent) {
        super(message)
        this.changeEvent = changeEvent
    }

}
