import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Daniel
 * @date 14/05/2018
 */

public class PlainTest {

    static final ReentrantLock l1 = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));

        System.out.println(PlainTest.class.getClassLoader());

        // app class loader 进行了加载
        System.out.println(PlainTest.class.getClassLoader().getParent());

        //
        System.out.println(PlainTest.class.getClassLoader().getParent().getParent());

        try {

            // 显示加载
            PlainTest.class.getClassLoader().loadClass("Base64Test");

            Class.forName("notefe");
        } catch (ClassNotFoundException e) {
            System.out.println("not find the base64Test class");
        }

        try {
            Thread.sleep(1000 * 10000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }


    }


}
