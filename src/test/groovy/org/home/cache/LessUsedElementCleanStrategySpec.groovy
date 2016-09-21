package org.home.cache

import org.home.cache.clean.LessUsedElementCleanStrategy
import spock.lang.Specification
import spock.lang.Subject

class LessUsedElementCleanStrategySpec extends Specification {
    @Subject
    LessUsedElementCleanStrategy<String> strategy = new LessUsedElementCleanStrategy<>()

    void "strategy should choose element which was used less"() {
        given:
        strategy.processesPutAction('key')
        and:
        strategy.processesPutAction('key1')
        and:
        strategy.processesGetAction('key')

        when:
        String result = strategy.choosesToRemove()

        then:
        result == 'key1'
    }

    void "IllegalStateException should be thrown when no usages"() {
        when:
        strategy.choosesToRemove()

        then:
        thrown(IllegalStateException)
    }

    void "strategy should skip not presented element from processing"() {
        given:
        strategy.processesPutAction('key')
        and:
        strategy.processesGetAction('key1')
        and:
        strategy.processesGetAction('key1')

        when:
        String result = strategy.choosesToRemove()

        then:
        result == 'key'
    }
}
