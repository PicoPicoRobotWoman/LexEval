package pico.lexeval.core.api
package error

abstract class LexEvalException(message: String, cause: Throwable = null)
  extends RuntimeException(message, cause)
