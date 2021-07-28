package app;

public class RepeatApp {
    public static void main(String[] args) {
        if (args.length != 2){
            return;
        }
        System.out.println("Program powtarzający komunikat n razy:");
        String message = "";
        int count = 0;
        for(String arg: args){
            String[] split = arg.split("=");
            if (split.length != 2){
                return;
            }
            String parameterName = split[0];
            String parameterValue = split[1];
            if(parameterName.equals("-message")){
                message = parameterValue;
            }
            if(parameterName.equals("-count")){
                count = Integer.parseInt(parameterValue);
            }
        }
        System.out.println((message+"\n").repeat(count));
    }
}
