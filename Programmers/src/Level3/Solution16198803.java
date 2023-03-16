package Level3;

//강크님 코드
public class Solution16198803 {
    public static int[] accSeq(int[] seq) {
        int n = seq.length;
        int acc = 0;
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 0; i < n; i++) {
            acc += seq[i];
            result[i + 1] = acc;
        }
        return result;
    }

    public long solution(int[] sequence) {
        int N = sequence.length;
        int[] pulse = new int[N];
        for (int i = 0; i < N; i++) {
            pulse[i] = (int) Math.pow(-1, i);
        }
        for(int i=0; i<N; i++){
            System.out.print(pulse[i] + " ");
        }
        System.out.println();
        int[] pulseSeq = new int[N];
        for (int i = 0; i < N; i++) {
            pulseSeq[i] = sequence[i] * pulse[i];
        }

        for(int i=0; i<N; i++){
            System.out.print(pulseSeq[i] + " ");
        }
        System.out.println();

        int[] pulseAcc = accSeq(pulseSeq);
        int maxPulseAcc = pulseAcc[0];
        int minPulseAcc = pulseAcc[0];
        for (int i = 1; i < N + 1; i++) {
            maxPulseAcc = Math.max(maxPulseAcc, pulseAcc[i]);
            minPulseAcc = Math.min(minPulseAcc, pulseAcc[i]);
        }

        for(int i=0; i<=N; i++){
            System.out.print(pulseAcc[i] + " ");
        }
        System.out.println();
        System.out.println(maxPulseAcc);
        System.out.println(minPulseAcc);
        return maxPulseAcc - minPulseAcc;
    }
}
