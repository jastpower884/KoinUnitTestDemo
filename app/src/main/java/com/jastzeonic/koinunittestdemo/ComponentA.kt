package com.jastzeonic.koinunittestdemo

class ComponentA(private val componentFunction: ComponentInterface) {

    fun getContent(): String {
        return componentFunction.getContent()
    }

}