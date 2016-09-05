import java.util.Stack;

public class BalancedParanthesisString {
    private static final char L_PAREN = '{';
    private static final char R_PAREN = '}';
    private static final char L_BRACE = '(';
    private static final char R_BRACE = ')';
    private static final char L_BRACKET = '[';
    private static final char R_BRACKET = ']';

    public static void main(String[] args) {
        String s = "[{ ()}]";
        System.out.println(isBalanced(s));
    }

    // if there is left bracket/parenthesis push that character to stack
    // and if you get right bracket/parenthesis pop character from stack and
    // compare for balance
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == L_PAREN) {
                stack.push(L_PAREN);
            } else if (s.charAt(i) == L_BRACE) {
                stack.push(L_BRACE);
            } else if (s.charAt(i) == L_BRACKET) {
                stack.push(L_BRACKET);
            } else if (s.charAt(i) == R_PAREN) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != L_PAREN) {
                    return false;
                }
            } else if (s.charAt(i) == R_BRACE) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != L_BRACE) {
                    return false;
                }
            } else if (s.charAt(i) == R_BRACKET) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != L_BRACKET) {
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }

}
