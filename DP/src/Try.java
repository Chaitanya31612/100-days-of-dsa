public class Try {

    public int brokenCalc(int startValue, int target) {
        if(target <= 0)
            return (int)1e8;
        if(target == startValue)
            return 0;

        int op1 = Integer.MAX_VALUE, op2 = Integer.MAX_VALUE;
         if(target % 2 == 0)
        op1 = brokenCalc(startValue, target / 2);
        if(target % 2 != 0)
        op2 = brokenCalc(startValue, target + 1);
        return Math.min(op1, op2) + 1;
    }

    public static void main(String[] args) {
        Try t = new Try();
        System.out.println(t.brokenCalc(5, 8));
    }
}
