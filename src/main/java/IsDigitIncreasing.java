public class IsDigitIncreasing {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int result = 0;
        result = isDigitIncreasing(7);
        result = isDigitIncreasing(36);
        result = isDigitIncreasing(984);
        result = isDigitIncreasing(7404);
        result = isDigitIncreasing(37);
    }

    static int isDigitIncreasing(int n) {
        int sum = 1, trac = 0, serise = 0;
        int gta = 1, len = 0, total = 0, res = 0;
        int org = n;
        if (n < 10)
            return 1;
        else {
            //calculate length base on given number
            while (0 < n) {
                len++;
                n = n / 10;
            }
            //=======================================

            for (gta = 1; gta <= 9; gta++) {
                for (int i = 0; i < len; i++) {
                    // ten calculation
                    while (trac < i) {
                        sum = sum * 10;
                        trac++;
                    }
                    //================

                    //serise make  //e.g:  1 + 11 , 2+22, 1+11+111
                    sum = sum * gta;
                    serise += sum;
                    total += serise;
                    //===============
                    trac = 0;
                    sum = 1;

                }

                if (org == total)
                    return 1;
                else {
                    serise = 0;
                    total = 0;
                    res = 0;
                }
            }
        }

        return res;
    }

}
