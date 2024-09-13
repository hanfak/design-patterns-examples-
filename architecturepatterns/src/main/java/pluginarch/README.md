Compile and jar the plugins
```java
javac HelloPlugin.java -d out
jar cf plugins/hello-plugin.jar -C out .
```
ensure the jar is in the plugins folder

compile and run the app

```java
javac MainApplication.java PluginLoader.java Plugin.java
java MainApplication
```