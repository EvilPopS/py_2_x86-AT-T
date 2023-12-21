package main.java.evilpops.pyathome_2_x86.semantic_analyzer.exceptions;

import main.java.evilpops.pyathome_2_x86.log_handlers.exceptions.CompilationWarning;

public class ImplAndExplTypesNotCompatibleWarning extends CompilationWarning {
    public ImplAndExplTypesNotCompatibleWarning(String implicitType, String explicitType) {
        super(
                String.format(
                        "Variable has an implicit type '%s' and explicit type '%s'.\n\t" +
                            "This is not an error but it is not a good practice to have a variable with different 'developer given' and 'program given' types!",
                        implicitType, explicitType
                )
        );
    }

}
