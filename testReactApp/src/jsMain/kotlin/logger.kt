import zustand.FunctionalMiddleware
import zustand.Middleware

fun <T> createLogger(): Middleware<T> {
    return FunctionalMiddleware { config ->
        { setter, getter, api ->
            config({ args ->
                console.log("> Old State :", getter())
                setter(args)
                console.log("> New State :", getter())
            }, getter, api)
        }
    }
}