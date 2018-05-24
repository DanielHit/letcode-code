import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Daniel
 * @date 16/05/2018
 */
public class Parser {


    public Date parse(String s) throws ParseException {
        // 并发执行 parse操作

        // 每次在并发执行的时候, 都新建一个parse类进行操作
        return new SimpleDateFormat("yyyy-mm-dd").parse(s);
    }

    public static void main(String[] args) {
        final Parser parser = new Parser();

        try {
            System.out.println(parser.parse("2017-06-23").getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        parser.parse("2017-06-23");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
