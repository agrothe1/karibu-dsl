package com.github.vok.karibudsl

import com.vaadin.ui.Accordion
import com.vaadin.ui.Component
import com.vaadin.ui.HasComponents

class _Accordion : Accordion() {
    /**
     * Allows you to access the current tab from the DSL:
     * ```kotlin
     * tabSheet {
     *    // adding a component to tabsheet will create a tab for the component as well.
     *    label("Foo bar baz blah blah blah") {
     *      tab.caption = "Tab 1"
     *      tab.icon = VaadinIcons.TAB
     *    }
     * }
     * ```
     */
    @get:JvmName("getTab2")
    val (@VaadinDsl Component).tab: Tab get() = this@_Accordion.getTab(ttab@this) ?: throw IllegalStateException("${ttab@this} is not child of ${this@_Accordion}")
}

fun (@VaadinDsl HasComponents).accordion(block: _Accordion.()->Unit = {}) = init(_Accordion(), block)

