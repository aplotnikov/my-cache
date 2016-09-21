package org.home.cache

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
class CacheSpec extends Specification {
    @Subject
    Cache<String, String> cache = new Cache<>()

    void "cache should contain '#value' if the value was put into cache with '#key' key"() {
        given:
        cache.put(key, value)

        when:
        String result = cache.get(key)

        then:
        result == value

        where:
        key    | value
        'key'  | 'value'
        'key1' | 'value1'
    }

    void "cache should return null when no value for provided key is presented"() {
        when:
        String result = cache.get('key')

        then:
        !result
    }

    void "cache value should be replaced with second put"() {
        given:
        cache.put('key', 'value')

        when:
        String result = cache.get('key')

        then:
        result == 'value'

        when:
        cache.put('key', 'new value')
        and:
        String newResult = cache.get('key')

        then:
        newResult == 'new value'
    }
}
