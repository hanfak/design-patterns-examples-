package pluginarch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class JarCreator {
    public static void createJars() {
        String baseDir = "architecturepatterns/target/classes";
        String packagePath = "/pluginarch/plugins";
        String sourceDirectoryPath = baseDir + packagePath; // Path to compiled class files
        String outputDirectoryPath = "architecturepatterns/src/main/java" + packagePath; // Output JAR file path

        // Create the output directory if it doesn't exist
        File outputDir = new File(outputDirectoryPath);
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        try {
            createJarsForEachClass(sourceDirectoryPath, outputDirectoryPath, baseDir);
            System.out.println("JAR files created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createJarsForEachClass(String sourceDir, String outputDir, String baseDir) throws IOException {
        File sourceDirFile = new File(sourceDir);
        if (!sourceDirFile.exists()) {
            throw new IllegalArgumentException("Source directory doesn't exist: " + sourceDir);
        }

        List<File> classFiles = new ArrayList<>();
        findClassFiles(sourceDirFile, classFiles);

        if (classFiles.isEmpty()) {
            System.out.println("No class files found in the directory.");
            return;
        }

        for (File classFile : classFiles) {
            String className = getPluginClassName( new File(baseDir), classFile); // Get the full class name including the package
            String jarFilePath = outputDir + "/" + className.substring(className.lastIndexOf('.') + 1) + ".jar"; // Class name as jar

            createJarForClass(classFile, className, jarFilePath);
            System.out.println("Created JAR: " + jarFilePath);
        }
    }

    // Method to find all class files recursively
    private static void findClassFiles(File dir, List<File> classFiles) {
        Stack<File> stack = new Stack<>();
        stack.push(dir);
        while (!stack.isEmpty()) {
            File aDir = stack.pop();
            File[] files = aDir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        stack.push(file);
                    } else if (file.getName().endsWith(".class")) {
                        classFiles.add(file);
                    }
                }
            }
        }
        // recursive method
/*        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    findClassFiles(file, classFiles);
                } else if (file.getName().endsWith(".class")) {
                    classFiles.add(file);
                }
            }
        }*/
    }

    // Dynamically construct the fully qualified class name (with package) based on the directory structure
    private static String getPluginClassName(File baseDir, File classFile) throws IOException {
        String basePath =  baseDir.getCanonicalPath();
        String classFilePath = classFile.getCanonicalPath();
        if (!classFilePath.startsWith(basePath)) {
            throw new IllegalArgumentException("Class file is not in the base directory.");
        }
        String relativePath = classFilePath.substring(basePath.length() + 1);
        return relativePath.replace(File.separatorChar, '.').replace(".class", "");
    }


    private static void createJarForClass(File classFile, String className, String jarFilePath) throws IOException {
        // Create a Manifest object
        Manifest manifest = new Manifest();
        Attributes attributes = manifest.getMainAttributes();
        attributes.put(Attributes.Name.MANIFEST_VERSION, "1.0");
        attributes.put(Attributes.Name.MAIN_CLASS, className);  // Add the class name as the Main-Class

        try (FileOutputStream fos = new FileOutputStream(jarFilePath);
             JarOutputStream jos = new JarOutputStream(fos, manifest)) {  // Pass the manifest to the JarOutputStream

            // Add the class file to the JAR
            String entryName = classFile.getName();
            JarEntry jarEntry = new JarEntry(entryName);
            jos.putNextEntry(jarEntry);

            // Write the content of the class file
            try (FileInputStream fis = new FileInputStream(classFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    jos.write(buffer, 0, bytesRead);
                }
            }

            jos.closeEntry();
        }
    }
}
