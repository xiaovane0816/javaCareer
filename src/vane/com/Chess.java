package vane.com;

/**
 * Created by wenshaobo on 2018/3/5.
 */
public class Chess {
    public static short b = 0;
    public static int GRIDW = 3;
    public static int HALF_BITS_LENGTH = 4;
    public static int FULLMASK =  255; // 11111111
    public static int LMASK =  (FULLMASK << HALF_BITS_LENGTH);   // 11110000
    public static int RMASK =  (FULLMASK >> HALF_BITS_LENGTH);   // 00001111
    public static int RGET(short b){
        return RMASK&b;
    }
    public static int LGET(short b) {
        return (LMASK&b) >> HALF_BITS_LENGTH;
    }
    public static int RSET(short b,int c) {
        b = (short) ((LMASK&b)|c);
        return b;
    }
    public static int LSET(short b, int c) {
        b = (short) ((RMASK&b)|(c<<HALF_BITS_LENGTH));
        return b;
    }

    public static void main(String[] args) {
        for(b = (short) LSET(b,1); LGET(b) <= GRIDW*GRIDW; b= (short) LSET(b,LGET(b)+1)){
            for(b = (short) RSET(b,1); RGET(b) <= GRIDW*GRIDW; b= (short) RSET(b,RGET(b)+1)){
                if(LGET(b) % GRIDW != RGET(b) %GRIDW){
                    System.out.printf("A = %d, B = %d \n",LGET(b),RGET(b));
                }
            }
        }
    }
}
