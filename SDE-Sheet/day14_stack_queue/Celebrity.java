package day14_stack_queue;

public class Celebrity {
    int celebrity(int M[][], int n)
    {
        for(int j = 0; j < n; j++) {
            boolean flag = true;
            for(int i = 0; i < n; i++) {
                if(i == j)
                    continue;

                if(M[i][j] != 1) {
                    flag = false;
                }
            }
            if(flag) {
                for(int i = 0; i < n; i++) {
                    if(M[j][i] == 1) {
                        flag = false;
                        break;
                    }
                }
                if(flag) return j;
            }
        }
        return -1;
    }
}
