package main.java.evilpops.pyathome_2_x86.exceptions.compilation.warnings;

import main.java.evilpops.pyathome_2_x86.log_handler.exceptions.CompilationError;

public class ImplicitAndExplicitTypesNotCompatibleWarning extends CompilationError {
    public ImplicitAndExplicitTypesNotCompatibleWarning(String implicitType, String explicitType) {
        super(
                String.format(
                        "Variable has an implicit type '%s' and explicit type '%s'.\n\t",
                        implicitType, explicitType
                )
        );
    }

}
