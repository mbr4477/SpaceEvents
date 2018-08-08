package usecases

interface IUseCase<T, R> {
    fun execute(input: T): R
}