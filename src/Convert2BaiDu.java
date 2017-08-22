import java.io.*;

/**
 * Created by heyue on 2017/8/22.
 */
public class Convert2BaiDu {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("/Users/heyue/Downloads/小鹤双拼单字.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                //开始转换
                String newFormartData = formartDataOld(line);
                sb.append(newFormartData);
                sb.append("\n");
            }
            String json = sb.toString();
                System.out.println(json);

            createFile(json);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private static String formartDataOld(String otherDataJson) {
        String[] split = otherDataJson.split(",");
        String waitConvertStr = split[1];
        String[] realSplitStr = waitConvertStr.split("=");
        String convertedStr =realSplitStr[0]+"=1,"+realSplitStr[1];
        System.out.println(convertedStr);
        return convertedStr;
    }
    private static void createFile(String data) throws IOException {
        String resultdata = data.replace("\\", "");
//        System.out.println(resultdata);
        //生成文件
        FileWriter fileWriter = new FileWriter("/Users/heyue/Downloads/小鹤双拼单字百度版本.txt");//生成好之后必须 手动 复制到原文件里面 有文件属性
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(resultdata);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
