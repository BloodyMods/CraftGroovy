package atm.bloodworkxgaming.craftgroovy.integration.zenScript;

import crafttweaker.zenscript.CrTCompileEnvironment;
import stanhebben.zenscript.ZenTokener;

import java.io.IOException;

public class FakeZenTokener extends ZenTokener {
    public FakeZenTokener() throws IOException {
        super("TEST_CONTENT", new CrTCompileEnvironment(), "file_fallback.zs", true);
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}
