package gui.server;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class FileManager {

    static void makeFiles(String spigotVersion, String Ram) throws IOException {
        moveFile(spigotVersion);
        makeFile("run.bat");
        makeRun(Ram);
        makeFile("server.properties");
        makeProperties();
        makeFile("eula.txt");
        makeEula();
    }

    static boolean findBuiltTools() throws IOException {

        if (new File("BuildTools").exists()) {
            return true;
        }
        else
            return false;

    }

    private static void moveFile(String spigotVersion) throws IOException {
        Path temp = Files.move
                (Paths.get("D:\\Servers\\Test\\BuildTools\\" + "spigot-" + spigotVersion + ".jar"),
                        Paths.get("D:\\Servers\\Test\\craftbukkit.jar"));

        System.out.println("File renamed and moved successfully");
    }

    private static void makeRun(String ram) throws IOException {
        FileWriter fileWriter = new FileWriter("run.bat");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("@echo off\n" +
                "java -Xms" + 1 + "G -Xmx" + ram + "G -XX:+UnlockExperimentalVMOptions -XX:MaxGCPauseMillis=50 -XX:+DisableExplicitGC " +
                "-XX:TargetSurvivorRatio=90 -XX:G1NewSizePercent=50 -XX:G1MaxNewSizePercent=80 -XX:InitiatingHeapOccupancyPercent=10 " +
                "-XX:G1MixedGCLiveThresholdPercent=50 -XX:+AggressiveOpts -jar craftbukkit.jar nogui\n" +
                "pause");
        printWriter.close();
    }

    private static void makeEula() throws IOException {
        FileWriter fileWriter = new FileWriter("eula.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("eula=true");
        printWriter.close();
    }

    private static void makeProperties() throws IOException {
        FileWriter fileWriter = new FileWriter("server.properties");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String properties = "spawn-protection=1\n" +
                "max-tick-time=60000\n" +
                "query.port=25565\n" +
                "server-name=" + "\n" +
                "generator-settings=\n" +
                "force-gamemode=false\n" +
                "allow-nether=true\n" +
                "enforce-whitelist=false\n" +
                "gamemode=survival\n" +
                "broadcast-console-to-ops=true\n" +
                "enable-query=false\n" +
                "player-idle-timeout=0\n" +
                "difficulty=normal\n" +
                "spawn-monsters=true\n" +
                "broadcast-rcon-to-ops=true\n" +
                "op-permission-level=4\n" +
                "pvp=true\n" +
                "snooper-enabled=true\n" +
                "level-type=default\n" +
                "hardcore=false\n" +
                "enable-command-block=false\n" +
                "max-players=10\n" +
                "network-compression-threshold=126\n" +
                "resource-pack-sha1=\n" +
                "max-world-size=29999984\n" +
                "function-permission-level=2\n" +
                "rcon.port=25575\n" +
                "server-port=25565\n" +
                "debug=false\n" +
                "server-ip=\n" +
                "spawn-npcs=true\n" +
                "allow-flight=false\n" +
                "level-name=world\n" +
                "view-distance=10\n" +
                "server-id=7\n" +
                "resource-pack=\n" +
                "spawn-animals=true\n" +
                "white-list=false\n" +
                "rcon.password=\n" +
                "generate-structures=true\n" +
                "online-mode=false\n" +
                "max-build-height=256\n" +
                "level-seed=\n" +
                "use-native-transport=true\n" +
                "prevent-proxy-connections=false\n" +
                "motd=" +
                "enable-rcon=false\n";
        printWriter.print(properties);

        printWriter.close();
    }

    private static void makeFile(String name) {
        try {
            File myObj = new File(name);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
