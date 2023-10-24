package baseball.ball;

import baseball.random.EasyPick;
import baseball.random.Pick;
import baseball.random.RandomUtil;
import java.util.List;

public class Ball {
    private static final Ball instance = new Ball();

    private final RandomUtil randomUtil = Pick.getInstance();

    private Ball(){

    }

    public static Ball getInstance(){
        return instance;
    }

    private List<Integer> target;

    public List<Integer> updateTarget(){
        target = null;

        return target = randomUtil.getBallNumber();
    }

    public List<Integer> getTarget(){
        return target;
    }

    public Result checkNumber(int num){
        int nBall = 0, nStrike = 0;

        char[] arr = String.valueOf(num).toCharArray();
        if(arr.length!=3) throw new IllegalArgumentException();

        for(int i=0; i<3; i++){
            int temp = arr[i]-48;
            if(target.contains(temp)){
                if(target.indexOf(temp)==i){
                    nStrike ++;
                }else{
                    nBall ++;
                }
            }
        }
        return new Result(nBall,nStrike);
    }

}
