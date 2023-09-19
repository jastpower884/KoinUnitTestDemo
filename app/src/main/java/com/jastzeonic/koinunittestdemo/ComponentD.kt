package com.jastzeonic.koinunittestdemo

class ComponentD(private val componentFunction: ComponentInterface) {

    fun getContent(): String {
        return componentFunction.getContent()
    }

}