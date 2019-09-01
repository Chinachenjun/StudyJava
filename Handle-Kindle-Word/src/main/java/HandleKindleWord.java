import java.io.*;
import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandleKindleWord {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\chej\\Desktop\\编辑1"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\chej\\Desktop\\编辑1_new"));
        String s1;
        String pre_line="";
        while ((s1 = bufferedReader.readLine()) != null) {
            s1 = deleteInvalidWord(s1);
            if(!pre_line.matches("^\\s*\\z")){
                bufferedWriter.newLine();
            }
            if (!s1.matches("^\\s*\\z")) {
                bufferedWriter.write(s1);
                bufferedWriter.newLine();
            }
            pre_line=s1;
        }
        bufferedWriter.close();
    }

    public static String deleteInvalidWord(String s) {
        String s1 = s.replace(" ", "");
        s1 = s1.replaceAll("马俊昌\\.Java编程的逻辑\\(Java核心技术系列\\).+北京华章图文信息有限公司\\.Kindle版本\\.", "");
        return s1;
    }

}
