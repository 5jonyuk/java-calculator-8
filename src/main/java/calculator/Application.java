package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력 주세요.\n");
        String input = Console.readLine();
        input = input.replace("\\n","\n"); // 콘솔에서는 실제로 "\n"입력을 "\\n"로 인식하기에 replace 사용
        String regex;

        if (input.startsWith("//")) { // 커스텀 모드
            int delimiterEndIndex = input.indexOf("\n");
            String customDelimiter = input.substring(2, delimiterEndIndex);
            regex = "[,:]|" + Pattern.quote(customDelimiter);
            input = input.substring(delimiterEndIndex + 1);
        }
        else { // 일반 모드
            regex = "[,:]";
        }
        String[] numbers = input.split(regex);
        int result = 0;
        for (String number : numbers) {
             result += Integer.parseInt(number);
        }
        System.out.println("결과 : " + result);
    }
}
