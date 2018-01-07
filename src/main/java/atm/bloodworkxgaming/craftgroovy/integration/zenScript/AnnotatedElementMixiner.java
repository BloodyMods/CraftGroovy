package atm.bloodworkxgaming.craftgroovy.integration.zenScript;

import atm.bloodworkxgaming.craftgroovy.CGConfig;
import atm.bloodworkxgaming.craftgroovy.CraftGroovy;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.PrintWriter;
import java.util.Set;

public abstract class AnnotatedElementMixiner {
    private String annotationName;
    private String fileName;

    public AnnotatedElementMixiner(Class<?> annoClass, String fileName) {
        this.annotationName = annoClass.getCanonicalName();
        this.fileName = fileName;
    }


    public void manageMixin(ASMDataTable dataTable){
        Set<ASMDataTable.ASMData> asmDataSet = dataTable.getAll(annotationName);
        PrintWriter writer = null;

        try {
            File file;
            if (CGConfig.getCustomScriptPaths().length > 0) {
                file = new File(CGConfig.getCustomScriptPaths()[0], fileName + ".gdsl");
            } else {
                file = new File( fileName + ".gdsl");
            }
            writer = new PrintWriter(file);

            doMixin(asmDataSet, writer);
        } catch (Exception e) {
            CraftGroovy.error("Error while writing to operators.gdsl", e);
        } finally {
            if (writer != null) writer.flush();
            IOUtils.closeQuietly(writer);
        }

    }

    protected abstract void doMixin(Set<ASMDataTable.ASMData> dataSet, PrintWriter writer);

}
