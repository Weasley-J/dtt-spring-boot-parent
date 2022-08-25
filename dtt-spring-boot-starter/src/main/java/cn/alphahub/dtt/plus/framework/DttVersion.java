package cn.alphahub.dtt.plus.framework;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.jar.Attributes;
import java.util.jar.JarFile;

/**
 * Get Dtt current version
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/19
 */
public final class DttVersion {

    private DttVersion() {
    }

    public static String getVersion() {
        return determineVersion();
    }

    private static String determineVersion() {
        final Package pkg = DttVersion.class.getPackage();
        if (null != pkg && null != pkg.getImplementationVersion()) {
            return pkg.getImplementationVersion();
        }
        URL srcLocation = DttVersion.class.getProtectionDomain().getCodeSource().getLocation();
        try {
            URLConnection connection = srcLocation.openConnection();
            if (connection instanceof JarURLConnection) {
                return getVersion(((JarURLConnection) connection).getJarFile());
            }
            try (JarFile jarFile = new JarFile(new File(srcLocation.toURI()))) {
                return getVersion(jarFile);
            }
        } catch (Exception ex) {
            return "";
        }
    }

    private static String getVersion(JarFile jarFile) throws IOException {
        return jarFile.getManifest().getMainAttributes().getValue(Attributes.Name.IMPLEMENTATION_VERSION);
    }
}
