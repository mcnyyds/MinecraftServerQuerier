import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class McSQ {
    static HttpURLConnection con;

    private static String getString(URL url) throws IOException {
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        return content.toString();
    }
    public static String MSGet(String host, int port) throws Exception {
        URL url = new URL("http://api.wer.plus/api/mcse?host=" + host + "&" + "port=" + port);
        return getString(url);
    }
    public static String MSGet(String host) throws Exception {
        URL url = new URL("http://api.wer.plus/api/mcse?host=" + host);
        return getString(url);
    }


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("host:port：");
        String[] temp = scanner.nextLine().split(":");
        System.out.println(MSGet(temp[0], Integer.parseInt(temp[1])));
    }
}
class MS{

    /**
     * code :
     * msg :
     * data : {"ver_name":"","serv_name":"","serv_ver":"","max_l":"","onl_l":"","serv_ping":"","serv_ico":""}
     */

    private int code;
    private String msg;
    private DataBean data;

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
         * ver_name :
         * serv_name :
         * serv_ver :
         * max_l :
         * onl_l :
         * serv_ping :
         * serv_ico :
         */

        private String ver_name;
        private String serv_name;
        private String serv_ver;
        private String max_l;
        private String onl_l;
        private String serv_ping;
        private String serv_ico;

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