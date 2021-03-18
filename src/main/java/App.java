public class App {
    Stack stack;

    public void doMethod (String input){
        stack = new Stack(input.length());
        StringBuilder sb1 = new StringBuilder();
        if (isValidParentheses(input)){
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if(ch != '[' && ch != ']') sb1.append(ch);
                if(ch == ']') {
                    StringBuilder sb2 = new StringBuilder(reverseTransformation(sb1.toString()));
                    sb1 = sb2;
                }
            }
        } else System.out.println("Вы ошиблись со скобками, запишите пожалуйста строку в формате: число[строка]");
        System.out.println(sb1.toString());
    }

    public String reverseTransformation(String input){
        int i;
        int n = 0;
        StringBuilder out = new StringBuilder();
        StringBuilder intermediateResult = new StringBuilder();
        for (i = input.length() - 1; i > -1; i--) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                n = ch - '0';
                break;
            }
        }
        for (int j = 1; j <= n; j++) {
            intermediateResult.append(input.substring(i + 1, input.length()));
        }
        out.append(input.substring(0, i)).append(intermediateResult.toString());
        return out.toString();
    }

    public boolean isValidParentheses(String input){
        stack = new Stack(input.length());
        for (int i = 0; i < stack.getSize(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '[':
                    stack.add(ch);
                    break;
                case ']':
                    if (!stack.isEmpty()) {
                        char topChar = stack.delete();
                        if (topChar != '[')
                            return false;
                    } else return false;
                    break;
                default:
                    break;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
