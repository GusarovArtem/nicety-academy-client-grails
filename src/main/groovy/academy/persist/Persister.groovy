package academy.persist

import academy.domain.DomainService
import academy.domain.persist.impl.PersisterPersistingTrait
import academy.util.change.ChangesSquasher
import academy.util.entity.EntitiesChangedEvent
import academy.util.entity.EntityChangedEvent
import groovy.util.logging.Slf4j

import javax.annotation.concurrent.NotThreadSafe

import static academy.util.construct.Collections.notEmpty

@Slf4j
@NotThreadSafe
class Persister implements PersisterPersistingTrait {

    private DomainService domainService

    private List<EntityChangedEvent> changes = []

    private long nestLevel = 0

    def changed = false

    def <T> T within(Closure<T> closure) {
        changed = false
        def existingEvent = forgeEvent()
        try {
            nestLevel++
            def closureResult = this.with closure
            changed = forgeEvent().differs(existingEvent)
            closureResult
        } finally {
            nestLevel--
        }
    }

    boolean rootFinished() {
        nestLevel == 0
    }

    boolean hasChanges() {
        notEmpty changes
    }

    def flush() {
        changes = ChangesSquasher.squashedChanges(changes)
        forgeEvent()
    }

    private EntitiesChangedEvent forgeEvent() {
        new EntitiesChangedEvent(changes: changes)
    }

    @Override
    DomainService domainService() {
        domainService
    }

    @Override
    def addChange(EntityChangedEvent event) {
        changes << event
    }

}