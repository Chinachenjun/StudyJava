import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TestZipOutputStream {
    public static void main(String[] args) {

          File inFile = new File("F:/test/study_ue.txt");
          File zipFile = new File("F:/test/study_ue.zip");

        try {
            zip(inFile,zipFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zip(File inFile, File zipFile) throws IOException {
        ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFile)));

        try {
            if (!inFile.exists()) {
                throw new FileNotFoundException(inFile.getAbsolutePath());
            }
            inFile = inFile.getCanonicalFile();
            String rootPath = inFile.getParent();
            if (!rootPath.endsWith(File.separator)) {
                rootPath += File.separator;
            }
            addFileToZipOut(inFile, out, rootPath);
        } finally {
            out.close();
        }
    }

    public static void copy(InputStream input, OutputStream output) throws IOException {
        byte[] buf = new byte[4096];
        int bytesRead = 0;
        while ((bytesRead = input.read(buf)) != -1) {
            output.write(buf, 0, bytesRead);
        }
    }

    private static void addFileToZipOut(File file, ZipOutputStream out, String rootPath) throws IOException {

        String relativePath = file.getCanonicalPath().substring(rootPath.length());
        System.out.println(file.getCanonicalPath());
        relativePath = "fbf/";
        if (file.isFile()) {
            System.out.println(relativePath);
            out.putNextEntry(new ZipEntry(relativePath));
            InputStream in = new BufferedInputStream(new FileInputStream(file));
            try {
                copy(in, out);
            } finally {
                in.close();
            }
        } else {
            out.putNextEntry(new ZipEntry(relativePath + File.separator));
            for (File f : file.listFiles()) {
                addFileToZipOut(f, out, rootPath);
            }
        }
    }
}
