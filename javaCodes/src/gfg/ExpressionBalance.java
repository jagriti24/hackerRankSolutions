package gfg;

import java.util.Stack;

public class ExpressionBalance {


    public static Integer balance(String input){
        System.out.println(input);

        if(input.length()%2 != 0){
            return -1;
        }

        Stack<Character> stack = new Stack<>();

       for(int i = 0; i< input.length(); i++){

           if( input.charAt(i) == '}'  && !stack.empty()){
               if(stack.peek() == '{')
                   stack.pop();
           }
           else {
               stack.push(input.charAt(i));
           }
       }
       int originalStackLength = stack.size();

       int x = 0;
       while(!stack.isEmpty() && stack.peek()=='{'){
           stack.pop(); x++;
       }

      return  (originalStackLength/2) + (x%2);
    }


    public static void main(String[] args) {

        String input = new String("}{{{}}}{{{");
        Integer reversals =  balance(input);

        System.out.println("No of Reversals :"+ reversals);
    }
}
