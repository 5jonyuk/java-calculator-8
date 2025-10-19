package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력 주세요.\n");
        String input = Console.readLine();
        String[] numbers = input.split("[,:]");
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        System.out.println("결과 : " + result);
    }
}
