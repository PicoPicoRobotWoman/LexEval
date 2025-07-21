package pico.lexeval.core.api
package error

class TokenDefinitionException(message: String, cause: Throwable = null)
  extends LexEvalException(message, cause)
