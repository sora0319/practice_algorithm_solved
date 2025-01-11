import java.util.*;

public class ReportList {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = s.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
        System.out.println(Arrays.toString(answer));
    }
    private static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            HashMap<String, HashSet<String>> request = new HashMap<>(id_list.length);
            HashMap<String, Integer> warning = new HashMap<>(id_list.length);
            List<String> people = new ArrayList<>();
            List<Integer> result = new ArrayList<>();

            for(int i = 0; i < id_list.length; i++){
                request.put(id_list[i], new HashSet<>());
                warning.put(id_list[i], 0);
            }

            for(int i = 0; i < report.length; i++){
                String[] r = report[i].split(" ");
                HashSet temp = request.get(r[0]);
                if(!temp.contains(r[1])){
                    temp.add(r[1]);

                    request.put(r[0], temp);
                    warning.put(r[1], warning.get(r[1]) + 1);
                }

            }

            for(int i = 0; i < id_list.length; i++){
                if(warning.get(id_list[i]) >= k){
                    people.add(id_list[i]);
                }
            }

            for(int i = 0; i < id_list.length; i++){
                if(!request.containsKey(id_list[i])) {
                    result.add(0);
                    continue;
                }
                Set temp = request.get(id_list[i]);
                int cnt = 0;
                for(String p : people){
                    if(temp.contains(p)) cnt++;
                }
                result.add(cnt);
            }



            int[] answer = new int[result.size()];
            for(int i = 0; i < answer.length; i++){
                answer[i] = result.get(i);
            }
            return answer;
        }
    }
}
