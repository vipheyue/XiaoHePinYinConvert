import java.io.*;

/**
 * Created by heyue on 2017/8/22.
 */
public class Filter4Word2BaiDu {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("/Users/heyue/Documents/Work/intellijSpace/XiaoHePinYinConvert/files/小鹤全码表.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                //开始转换
//                System.out.println(line);

//                testShow(line);
                String newFormartData = formartDataOld(line);
                if (!newFormartData.isEmpty()) {
                    sb.append(newFormartData);
                    sb.append("\n");
                }
            }
            createFile(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private static String testShow(String otherDataJson) {
        String[] split = otherDataJson.split(",");
        if (split[1].length() == 2 && 3 == split[0].length()) {
            //en=1,恩恩
            String convertedStr = split[0] + "=1," + split[1];
            System.out.println(convertedStr);
            return convertedStr;
        }
        return "";
    }

    private static String formartDataOld(String otherDataJson) {
        String[] split = otherDataJson.split(",");
        if (split[1].length() != 1 && split[1].length() == split[0].length()) {
            //en=1,恩恩
            String convertedStr = split[0] + "=1," + split[1];
//            System.out.println(convertedStr);
            return convertedStr;
        } else {
            return "";
        }
    }

    private static void createFile(String data) throws IOException {
        String resultdata = data.replace("\\", "");
//        System.out.println(resultdata);
        //生成文件
        FileWriter fileWriter = new FileWriter("/Users/heyue/Downloads/小鹤234字超级简码.txt");//生成好之后必须 手动 复制到原文件里面 有文件属性
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(resultdata);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
