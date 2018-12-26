package until;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

public class GetWXOppenId {
	public static String[] load(String key) throws Exception
    {
        URL restURL = new URL("https://api.weixin.qq.com/sns/jscode2session?appid=wxcbe2035fdc5f64a7&secret=a7ae9a79e2c585d5375b904f26c79294&grant_type=authorization_code&js_code="+key);
        /*
         * �˴���urlConnection����ʵ�����Ǹ���URL������Э��(�˴���http)���ɵ�URLConnection�� ������HttpURLConnection
         */
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        //����ʽ
        conn.setRequestMethod("GET");
        //�����Ƿ��httpUrlConnection���룬Ĭ���������true; httpUrlConnection.setDoInput(true);
        conn.setDoOutput(true);
        //allowUserInteraction ���Ϊ true�����������û����������絯��һ����֤�Ի��򣩵��������жԴ� URL ���м�顣
        conn.setAllowUserInteraction(false);
        PrintStream ps = new PrintStream(conn.getOutputStream());
        ps.print("floor=first&year=2017&month=9&isLeader=N");
        ps.close();
        BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line,resultStr="";
        while(null != (line=bReader.readLine())){
        	resultStr +=line;
        }
        //System.out.println("���:"+resultStr);
        JSONObject res=JSONObject.fromObject(resultStr);
        String session_key=res.getString("session_key");
        String openid=res.getString("openid");
        //System.out.println("session_key:"+session_key+"  openID:"+openid);
        bReader.close();
        String[] result=new String[2];
        result[0]=session_key;
        result[1]=openid;
        return result;
    }
}
