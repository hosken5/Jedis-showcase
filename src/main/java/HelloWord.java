import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;
import static  java.lang.System.out ;
/**
 *
 */
public class HelloWord {

    private  static Jedis jedis = new Jedis("localhost");

    public static void main(String [] arg){
        HelloWord h =  new HelloWord() ;
        h.setTest();
        h.getTest();
        out.println() ;
    }


    public void getTest() {
        try {
            for (int i = 0; i < 100000; i++) {
                System.out.println(jedis.get("key" + i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testConn() {
        try {
            jedis.connect();
            jedis.ping();
            jedis.quit();
            out.println("连接成功！") ;
        } catch (JedisConnectionException e) {
            e.printStackTrace();
        }
    }

    public void setTest() {
        try {
            for (int i = 0; i < 100000; i++) {
                jedis.set("key" + i, "value" + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
