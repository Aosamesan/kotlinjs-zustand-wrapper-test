import react.ChildrenBuilder
import react.FC
import react.PropsWithChildren
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.section
import states.useCounterState
import web.dom.document

fun main() {
    createRoot(document.getElementById("root")!!).render(App.create())
}

val App = FC {
    Counter()
}

val Counter = FC {
    val store = useCounterState { state -> state }

    section {
        h1 { +"Current Count: ${store.count}" }
        button {
            onClick = { store.increment() }
            +"Increment"
        }
        button {
            onClick = { store.decrement() }
            +"Decrement"
        }
    }
}