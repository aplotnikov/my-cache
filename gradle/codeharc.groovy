ruleset {
    ruleset('rulesets/basic.xml')
    ruleset('rulesets/braces.xml')
    ruleset('rulesets/concurrency.xml')
    ruleset('rulesets/convention.xml') {
        TrailingComma(enabled: false)
    }
    ruleset('rulesets/design.xml') {
        Instanceof(enabled: false)
    }
    ruleset('rulesets/dry.xml') {
        DuplicateNumberLiteral(enabled: false)
        DuplicateStringLiteral(enabled: false)
        DuplicateListLiteral(enabled: false)
    }
    ruleset('rulesets/enhanced.xml')
    ruleset('rulesets/formatting.xml') {
        ClassJavadoc(enabled: false)
        SpaceAroundMapEntryColon(enabled: false)
        LineLength(enabled: false)
    }
    ruleset('rulesets/generic.xml')
    ruleset('rulesets/groovyism.xml')
    ruleset('rulesets/exceptions.xml')
    ruleset('rulesets/imports.xml')
    ruleset('rulesets/size.xml') {
        AbcMetric(enabled: false)
    }
    ruleset('rulesets/unnecessary.xml') {
        UnnecessaryBooleanExpression(enabled: false)
        UnnecessaryGetter(enabled: false)
    }
    ruleset('rulesets/unused.xml') {
        UnusedObject(enabled: false)
    }
    ruleset('rulesets/security.xml')
}