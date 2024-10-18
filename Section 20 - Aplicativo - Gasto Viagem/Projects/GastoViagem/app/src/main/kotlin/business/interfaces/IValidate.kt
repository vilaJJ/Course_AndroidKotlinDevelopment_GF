package business.interfaces

internal interface IValidate<T, R> {
    fun validate(value: T): R
}