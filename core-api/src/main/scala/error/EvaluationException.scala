package pico.lexeval.core.api
package error

class EvaluationException(message: String, cause: Throwable = null)
  extends LexEvalException(message, cause)
