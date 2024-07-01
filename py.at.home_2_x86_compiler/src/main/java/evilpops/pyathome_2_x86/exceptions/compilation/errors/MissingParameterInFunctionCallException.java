package main.java.evilpops.pyathome_2_x86.exceptions.compilation.errors;


import main.java.evilpops.pyathome_2_x86.log_handler.exceptions.CompilationError;

public class MissingParameterInFunctionCallException extends CompilationError {
    public MissingParameterInFunctionCallException(String paramName) {
        super(
                String.format(
                        "Parameter '%s' missing from function call!",
                        paramName
                )
        );
    }

}
