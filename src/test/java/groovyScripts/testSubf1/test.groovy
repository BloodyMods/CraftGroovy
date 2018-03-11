package groovyScripts.testSubf1

import groovy.transform.Field

import static groovyScripts.testSubf2.test.s2

@Field
static String s1 = "BlaBlaBla1"

println "Hi, I am a groovy test script in testSubf1"
println(s2)
// println(groovyScripts.test.str)
// println(groovyScripts.testSubf2.test.s1)

