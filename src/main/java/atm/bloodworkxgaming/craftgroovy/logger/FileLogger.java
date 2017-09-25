package atm.bloodworkxgaming.craftgroovy.logger;

import atm.bloodworkxgaming.craftgroovy.CraftGroovy;
import atm.bloodworkxgaming.craftgroovy.commands.ChatHelper;
import de.bloodworkxgaming.groovysandboxedlauncher.logger.ILogger;

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileLogger implements ILogger {
    private final Writer writer;
    private final PrintWriter printWriter;
    
    public FileLogger(String fileName) {
        moveOldLogs();

        File output = new File("logs/" + fileName);

        try {
            writer = new OutputStreamWriter(new FileOutputStream(output), "utf-8");
            printWriter = new PrintWriter(writer);
        } catch(UnsupportedEncodingException ex) {
            throw new RuntimeException("Unsupported Encoding Error while opening " + output);
        } catch(FileNotFoundException ex) {
            throw new RuntimeException("Could not open log file " + output);
        }
    }
    
    @Override
    public void logCommand(String message) {
        try {
            writer.write(cleanMessage(message) + "\n");
            writer.flush();
        } catch(IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public void logInfo(String message) {
        try {
            writer.write("[INFO] " + cleanMessage(message) + "\n");
            writer.flush();
        } catch(IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void logScript(String className, String message) {
        try {
            writer.write("[SCRIPT][" + className + "] " + cleanMessage(message) + "\n");
            writer.flush();
        } catch(IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void logWarning(String message) {
        try {
            writer.write("[WARNING] " + cleanMessage(message) + "\n");
            writer.flush();
        } catch(IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public void logError(String message) {
        logError(message, null);
    }
    
    @Override
    public void logError(String message, Throwable exception) {
        try {
            writer.write("[ERROR] " + cleanMessage(message) + "\n");
            if(exception != null) {
                exception.printStackTrace(printWriter);
            }
            writer.flush();
        } catch(IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void moveOldLogs(){
        File logsFolder = new File("logs");
        if (logsFolder.isDirectory()){
            File[] fileList = logsFolder.listFiles();
            if (fileList != null){
                File oldLogsFolder = new File("logs/craftgroovy_old/");
                oldLogsFolder.mkdir();

                for (File file : fileList) {
                    if (file.getName().equals("craftgroovy.log")){
                        try {
                            Date date = new Date(file.lastModified());
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
                            File to = new File(oldLogsFolder.getPath()  + "/craftgroovy_" + simpleDateFormat.format(date) + ".log");
                            Files.move(file.toPath(), to.toPath());
                        } catch (IOException e) {
                            CraftGroovy.error("Could not move old log file.", e);
                        }
                    }
                }
            }
        }

    }

    /**
     * Cleans up the message
     */
    public String cleanMessage(String message) {
        return message == null ? null : ChatHelper.removeFormattingCodes(message);
    }
}
