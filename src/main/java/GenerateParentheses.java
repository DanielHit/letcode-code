import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel
 * @date 29/05/2018
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(4));
    }


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(n, n, "", res);
        return res;
    }

    void helper(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            res.add(out);
            return;
        }

        helper(left - 1, right, out + "(", res);
        helper(left, right - 1, out + ")", res);
    }

}
