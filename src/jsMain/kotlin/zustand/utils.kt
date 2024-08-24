package zustand

fun <T> createAction(setter: StateUpdateSetter<T>, update: StateUpdate<T>): UpdateAction {
    return UpdateAction { setter(update) }
}

fun <T> StateUpdateSetter<T>.createAction(update: StateUpdate<T>): UpdateAction {
    return createAction(this, update)
}