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
         * 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类 的子类HttpURLConnection
         */
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        //请求方式
        conn.setRequestMethod("GET");
        //设置是否从httpUrlConnection读入，默认情况下是true; httpUrlConnection.setDoInput(true);
        conn.setDoOutput(true);
        //allowUserInteraction 如果为 true，则在允许用户交互（例如弹出一个验证对话框）的上下文中对此 URL 进行检查。
        conn.setAllowUserInteraction(false);
        PrintStream ps = new PrintStream(conn.getOutputStream());
        ps.print("floor=first&year=2017&month=9&isLeader=N");
        ps.close();
        BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line,resultStr="";
        while(null != (line=bReader.readLine())){
        	resultStr +=line;
        }
        //System.out.println("结果:"+resultStr);
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
