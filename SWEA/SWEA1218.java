package SWEA;

import java.io.*;
import java.util.Stack;

// 괄호 짝짓기
public class SWEA1218 {

    public static void main(String[] args) throws IOException {

        //System.setIn(new FileInputStream("input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack;

        for (int x = 1; x <= 10; x++) {

            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                stack.push(s.charAt(i));

                while (true) {
                    if (stack.size() > 1 && stack.get(stack.size()-2) == '{' && stack.get(stack.size()-1) == '}') {
                        stack.pop();
                        stack.pop();
                    } else if (stack.size() > 1 && stack.get(stack.size()-2) == '<' && stack.get(stack.size()-1) == '>') {
                        stack.pop();
                        stack.pop();
                    } else if (stack.size() > 1 && stack.get(stack.size()-2) == '[' && stack.get(stack.size()-1) == ']') {
                        stack.pop();
                        stack.pop();
                    } else if (stack.size() > 1 && stack.get(stack.size()-2) == '(' && stack.get(stack.size()-1) == ')') {
                        stack.pop();
                        stack.pop();
                    } else { break; }
                }
            }

            if (stack.size() > 0)
                System.out.printf("#%d %d\n", x, 0);
            else
                System.out.printf("#%d %d\n", x, 1);
        }
    }
}
