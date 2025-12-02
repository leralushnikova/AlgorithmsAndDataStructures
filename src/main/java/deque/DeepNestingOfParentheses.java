package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
Проверка глубокой вложености скобок. Работает через Deque
 */
public class DeepNestingOfParentheses {

    public static void main(String[] args) throws IOException {
        Deque<Character> deque = new ArrayDeque<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        for (int i = 0; i < str.length(); i++) {
            deque.add(str.charAt(i));
        }

        long depth = 0;
        long maxDepth = 0;

        while (!deque.isEmpty()) {
            char first = deque.pollFirst();

            if(first == '(') {
                depth ++;
                maxDepth = Math.max(maxDepth, depth);
            }
            if(first == ')') depth--;
        }

        System.out.println(maxDepth);
    }
}
