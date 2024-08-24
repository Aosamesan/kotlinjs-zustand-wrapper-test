package states

import createLogger
import js.objects.jso
import zustand.UpdateAction
import zustand.create
import zustand.createAction
import kotlin.js.json

external interface CounterState {
    var count: Int
    var increment: UpdateAction
    var decrement: UpdateAction
}

val useCounterState = create<CounterState>({ setter, _, _ ->
    jso {
        count = 0
        increment = setter.createAction { state ->
            json("count" to state.count + 1)
        }
        decrement = setter.createAction { state ->
            json("count" to state.count - 1)
        }
    }
}, createLogger())