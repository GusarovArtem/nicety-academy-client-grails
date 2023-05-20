package academy.utils.props.collector

import groovy.util.logging.Slf4j

import static academy.utils.constructs.Looper.loop

@Slf4j
class PropsCollector {

    private List<PropsCollectorNode> collected = []

    def propertyMissing(String name) {
        def node = new PropsCollectorNode(collected: name)
        collected << node
        node
    }

    def collectedProps() {
        collected.collect { node ->
            def currentNode = node
            def props = []
            loop {
                props << currentNode.collected
                currentNode = currentNode.next
            } until { !currentNode }
            props.join('.')
        }
    }
}