import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        //128. Longest Consecutive Sequence
        //Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
        //
        //You must write an algorithm that runs in O(n) time.

        int[] nums = {100, 4, 200, 1, 3, 2};
        Solution sol = new Solution(); // Agora é possível criar a instância
        int resultado = sol.longestConsecutive(nums);
        System.out.println("Maior sequência consecutiva: " + resultado);
    }

    static class Solution { // Tornando a classe estática
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int maiorSequencia = 0;

            for (int num : set) {
                if (!set.contains(num - 1)) { // Se não há um número menor antes dele
                    int atual = num;
                    int sequenciaAtual = 1;

                    while (set.contains(atual + 1)) {
                        atual++;
                        sequenciaAtual++;
                    }

                    maiorSequencia = Math.max(maiorSequencia, sequenciaAtual);
                }
            }

            return maiorSequencia;
        }
    }
}
