package atm.bloodworkxgaming.craftgroovy.integration.zenScript;

import crafttweaker.zenscript.CrTCompileEnvironment;
import crafttweaker.zenscript.GlobalRegistry;
import stanhebben.zenscript.ZenTokener;
import stanhebben.zenscript.compiler.IEnvironmentGlobal;
import stanhebben.zenscript.parser.Token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FakeZenTokener extends ZenTokener {
    public static final String fileName = "CG_bracket_resolver.nonzs";
    public static IEnvironmentGlobal globalEnv = GlobalRegistry.makeGlobalEnvironment(new HashMap<>());
    public static ZenTokener fakeZenTokener;
    public static CrTCompileEnvironment crtCompileEnv = new CrTCompileEnvironment();

    static {
        try {
            fakeZenTokener = new FakeZenTokener();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FakeZenTokener() throws IOException {
        super("TEST_CONTENT", crtCompileEnv, fileName, true);
    }

    public static List<Token> getTokensFromString(String content) {
        List<Token> tokens = new ArrayList<>();
        try {
            ZenTokener fTokener = new ZenTokener(content, crtCompileEnv, fileName, false);
            while (fTokener.hasNext()) {
                tokens.add(fTokener.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tokens;
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}
