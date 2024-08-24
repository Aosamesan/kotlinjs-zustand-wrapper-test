package zustand

@Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
fun <TState> create(config: ZustandConfig<TState>, vararg middlewares: Middleware<TState>): CreateResult<TState> {
    var result = config

    for (middleware in middlewares) {
        result = middleware(result)
    }

    return createJs(result) as CreateResult<TState>
}