public class First_Week {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8};

        rotation(array, 3,2);
    }

    public static void rotation(int[] array, int size, int degree) {
        if(degree == 0){
            for (int i = 0; i < 9; i++) {
                System.out.print(array[i]);
                if (i % 3 == 2) {
                    System.out.println();
                    continue;
                }
                System.out.print(",");
            }
        }
        if (degree == 1) {
            for (int i = 0; i < size; i++) {
                for (int j = size-1; j >= 0; j--) {
                    System.out.print(size * j + i);
                    if(j != 0) System.out.print(",");
                }
                System.out.println();
            }

        }
        if (degree == 2) {
            for (int i = 8; i >= 0; i--) {
                System.out.print(array[i]);
                if (i % 3 == 0) {
                    System.out.println();
                    continue;
                }
                System.out.print(",");
            }
        }
        if (degree == 3) {
            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= size; j++) {
                    System.out.print(size * j - i);
                    if(j != size) System.out.print(",");
                }
                System.out.println();
            }
        }
    }
}
// 시계방향 회전
