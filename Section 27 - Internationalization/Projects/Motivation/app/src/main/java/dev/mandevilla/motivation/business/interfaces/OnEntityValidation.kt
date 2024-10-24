package dev.mandevilla.motivation.business.interfaces

internal interface OnEntityValidation<Type, Result> {
    fun validate(value: Type): Result
}