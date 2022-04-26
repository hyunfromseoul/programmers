import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class ProgrammersAddANumberThatDoesNotExist {

	public static void main(String[] args) {
		
		ProgrammersAddANumberThatDoesNotExist pa = new ProgrammersAddANumberThatDoesNotExist();
		Solution solution = pa.new Solution();
		int[] num = { 5,8,4,0,6,7,9 };
		
		System.out.println(solution.solution(num));
	}
	
	class Solution {
		public int solution(int[] numbers) {

			Arrays.sort(numbers);
			
			//Stream을 이용해서 int 배열 -> Integer 배열 변환
			Integer[] temp = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
			System.out.println("중복 제거 이전 값");
			System.out.println("> " + Arrays.toString(temp));
			
			//0~10 이외 값 삭제
			List<Integer> list = new ArrayList<Integer>(Arrays.asList(temp));
			
			Iterator<Integer> itr = list.iterator();
			while (itr.hasNext()) {
				Integer i = itr.next();
				System.out.println(i);
				
				if (i < 0 || i > 9) {
					System.out.println(i + "는 삭제됩니다.");
					itr.remove();
				}
			}
			
			System.out.println("0 ~ 10 제거된 값");
			System.out.println("> " + list);
			
			//중복값 삭제
			LinkedHashSet<Integer> set = new LinkedHashSet<>(list);
			System.out.println("중복 제거된 값");
			System.out.println("> " + set);

		
			Iterator<Integer> setItr = set.iterator();
			int result = 45;
			while (setItr.hasNext()) {
				result -= setItr.next();
			}
			
			System.out.println(result);
			
			int answer = result;
			return answer;
		}
	}
}
