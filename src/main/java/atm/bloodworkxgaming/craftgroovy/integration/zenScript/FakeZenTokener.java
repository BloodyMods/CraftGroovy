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
    public FakeZenTokener() throws IOException {
        super("TEST_CONTENT", new CrTCompileEnvironment(), "file_fallback.zs", true);
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    public static IEnvironmentGlobal globalEnv = GlobalRegistry.makeGlobalEnvironment(new HashMap<String, byte[]>());
    public static ZenTokener fakeZenTokener;
    public static CrTCompileEnvironment crtCompileEnv = new CrTCompileEnvironment();

    static {
        try {
            fakeZenTokener = new FakeZenTokener();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Token> getTokensFromString(String content) {
        List<Token> tokens = new ArrayList<>();
        try {
            ZenTokener fTokener = new ZenTokener(content, crtCompileEnv, "testttt.nonzs", false);
            while (fTokener.hasNext()) {
                tokens.add(fTokener.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tokens;
    }
}
