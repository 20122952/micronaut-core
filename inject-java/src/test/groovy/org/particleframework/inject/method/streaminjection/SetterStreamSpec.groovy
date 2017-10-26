package org.particleframework.inject.method.streaminjection

import org.particleframework.context.BeanContext
import org.particleframework.context.DefaultBeanContext
import spock.lang.Specification

class SetterStreamSpec extends Specification {
    void "test injection via method that takes a stream"() {
        given:
        BeanContext context = new DefaultBeanContext()
        context.start()

        when:
        B b =  context.getBean(B)

        then:
        b.all != null
        b.all.size() == 2
        b.all.contains(context.getBean(AImpl))
        b.another.count() == 2
        b.another2.count() == 2
    }
}