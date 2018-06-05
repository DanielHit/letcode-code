import java.util.Stack;

/**
 * @author Daniel
 * @date 29/05/2018
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]"));
        System.out.println(isValid("([)"));
    }

    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                if (isParenthest(stack.peek(), s.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(String.valueOf(s.charAt(i)));
                }
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }

        return stack.isEmpty();
    }

    private static boolean isParenthest(String peek, char c) {
        switch (peek) {
            case "{":
                return "}".equals(String.valueOf(c));

            case "(":
                return ")".equals(String.valueOf(c));
            case "[":
                return "]".equals(String.valueOf(c));
            default:
                return false;
        }
    }

}
