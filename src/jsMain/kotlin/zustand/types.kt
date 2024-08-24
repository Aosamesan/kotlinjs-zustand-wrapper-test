package zustand

typealias StateUpdate<T> = (state: T) -> dynamic
typealias StateGetter<T> = () -> T
typealias StateUpdateSetter<T> = (update: StateUpdate<T>) -> Unit
typealias ZustandConfig<T> = (setter: StateUpdateSetter<T>, getter: StateGetter<T>, api: dynamic) -> T

external interface CreateResult<T> {
    @JsName("call")
    operator fun <TDerived> invoke(stateSelector: (T) -> TDerived): TDerived
}

external interface Middleware<T> {
    @JsName("call")
    operator fun invoke(config: ZustandConfig<T>): ZustandConfig<T>
}

fun interface FunctionalMiddleware<T> : Middleware<T>

fun interface UpdateAction {
    fun update()
    operator fun invoke() = update()
}