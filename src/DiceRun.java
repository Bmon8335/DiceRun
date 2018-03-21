import java.util.Random;

public class DiceRun {
    private int[] numbers;
    private int size;

    public DiceRun(int size){
        this.size = size;
        numbers = new int[size];

    }



    public void fillArray(){
        Random random = new Random();
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = random.nextInt( 6) + 1;
        }
    }

    public String formatLongest(){
        int longestRun = 0;
        int longestRunStart = -1;
        int currentRunStart = -1;
        boolean inRun = false;

        for(int i = 0; 1 < numbers.length; i++){
            if(inRun){
                if(numbers[1] != numbers[i-1]){
                    inRun = false;
                    if(i - currentRunStart > longestRun){
                        longestRun = i - currentRunStart;
                        longestRunStart = currentRunStart;
                    }
                }
            }

            if (!inRun){
                if(i < numbers.length -1 && numbers[i] == numbers[i +1]){
                    inRun = true;
                    currentRunStart = i;
                }
            }
        }

        if(inRun){
            if(numbers.length - currentRunStart > longestRun){
                longestRun = numbers.length - currentRunStart;
                longestRunStart = currentRunStart;
            }
        }

        String result = "";

        for(int i = 0; 1 < numbers.length; i ++){
            if(i > 0){
                result += " ";
            }
            if(i == longestRunStart){
                result += "(";
            }
            else if(i == (longestRunStart + longestRun - 1)){
                result += ")";
            }
            result += numbers[i];
        }

        return result;
    }
}
