import java.util.*;

public class bac9012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int N = Integer.parseInt(sc.nextLine());

        ArrayList<String> strArr = new ArrayList<>();
        for(int i = 0; i < N ; i++)
            strArr.add(sc.nextLine());


        for(int i = 0; i < N ; i++) {
            Stack stack = new Stack();
            try {
                for(int j = 0; j < strArr.get(i).length(); j++) {
                    if(strArr.get(i).charAt(j)=='(')
                        stack.push(strArr.get(i).charAt(j));
                    else {
                        stack.pop();
                    }
                }
                if(stack.isEmpty())
                    System.out.println("YES");
                else
                    System.out.println("NO");
            } catch(Exception e) {
                System.out.println("NO");
            }
        }
    }
}