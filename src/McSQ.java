import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class McSQ {
    static HttpURLConnection con;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("输入0退出，输入host:port查询：");
            String temp_ = scanner.nextLine();
            if (Objects.equals(temp_,"0")) {
                break;
            }
            String[] temp = temp_.split(":");
            System.out.println(MSGetHttp(temp[0], temp[1]));
        }
    }

    private static String MSGetHttp(String host, String port) throws Exception {
        URL url = new URL("http://api.wer.plus/api/mcse?host="+host+"&"+"port="+port);
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

//        System.out.println(content.toString());
        return content.toString();
    }

    //把一个文件中的内容读取成一个String字符串
    public static String getStr(File jsonFile){
        String jsonStr = "";
        try {
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void dataExtraction () {

    }
}
class McSE {

    /**
     * code : 200
     * msg : success
     * data : {"ver_name":"Spigot1.14.4","serv_name":"None","serv_ver":"None","max_l":"50","onl_l":"1","serv_ping":"14ms","serv_ico":"None"}
     */

    private int code;   //状态码,200为成功，其他为错误
    private String msg; //成功返回success
    private DataBean data;  //所有服务器数据

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public DataBean getData() {
        return data;
    }
    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * ver_name : Spigot1.14.4
         * serv_name : None
         * serv_ver : None
         * max_l : 50
         * onl_l : 1
         * serv_ping : 14ms
         * serv_ico : None
         */

        private String ver_name;    //当前版本名称，获取失败则为空或None
        private String serv_name;   //服务器名称，获取失败则为空或None
        private String serv_ver;    //服务器版本，获取失败则为空或None
        private String max_l;   //支持最大承载人数，获取失败则为空或None
        private String onl_l;   //当前在线人数，获取失败则为空或None
        private String serv_ping;   //服务器延迟，获取失败则为空或None
        private String serv_ico;    //服务器图标，获取失败则为空或None

        public String getVer_name() {
            return ver_name;
        }
        public void setVer_name(String ver_name) {
            this.ver_name = ver_name;
        }
        public String getServ_name() {
            return serv_name;
        }
        public void setServ_name(String serv_name) {
            this.serv_name = serv_name;
        }
        public String getServ_ver() {
            return serv_ver;
        }
        public void setServ_ver(String serv_ver) {
            this.serv_ver = serv_ver;
        }
        public String getMax_l() {
            return max_l;
        }
        public void setMax_l(String max_l) {
            this.max_l = max_l;
        }
        public String getOnl_l() {
            return onl_l;
        }
        public void setOnl_l(String onl_l) {
            this.onl_l = onl_l;
        }
        public String getServ_ping() {
            return serv_ping;
        }
        public void setServ_ping(String serv_ping) {
            this.serv_ping = serv_ping;
        }
        public String getServ_ico() {
            return serv_ico;
        }
        public void setServ_ico(String serv_ico) {
            this.serv_ico = serv_ico;
        }
    }
}
