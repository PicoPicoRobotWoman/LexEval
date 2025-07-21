package pico.lexeval.core.api
package error

class LexerException(message: String, cause: Throwable = null)
  extends LexEvalException(message, cause)
