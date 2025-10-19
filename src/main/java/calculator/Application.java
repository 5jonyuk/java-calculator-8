package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력 주세요.\n");
        String input = Console.readLine();
        input = input.replace("\\n", "\n"); // 콘솔에서는 실제로 "\n"입력을 "\\n"로 인식하기에 replace 사용
        String regex;
        if (input.startsWith("//")) { // 커스텀 모드
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");

            String customDelimiter = input.substring(2, delimiterEndIndex);
            if (customDelimiter.isEmpty()) throw new IllegalArgumentException("커스텀 구분자가 없습니다.");

            regex = "[,:]" + "|" + Pattern.quote(customDelimiter); // Pattern.quote() 정규식에서 특수문자로 오해받지 않게 문자 그대로 인식시켜주는 함수
            input = input.substring(delimiterEndIndex + 1);
        } else { // 일반 모드
            regex = "[,:]";
        }
        String[] numbers = input.split(regex);
        for (String number : numbers) {
            if (number.isBlank()) throw new IllegalArgumentException("구분자 사이에 숫자가 없습니다.");
        }
        int result = 0;
        for (String number : numbers) {
            try {
                int value = Integer.parseInt(number.trim());
                if (value < 0) throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                result += value;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
        }
        System.out.println("결과 : " + result);
    }
}
