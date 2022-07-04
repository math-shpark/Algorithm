package silver.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Test {
   public static void main(String[] args) throws NumberFormatException, IOException {
      // 버퍼드리더로 입력받는다.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder(); // 출력을 위한 스트링빌더

      // 테스트케이스 수
      int T = Integer.parseInt(br.readLine());

      // 테스트케이스만큼 돌린다.
      for (int tc = 0; tc < T; tc++) {
         // 명령 받음
         String command = br.readLine();

         // 숫자의 개수
         int N = Integer.parseInt(br.readLine());
         // 덱 생성
         Deque<Integer> num = new LinkedList<>();

         // 숫자배열에서 숫자만 덱에 넣어준다.
         String arr = br.readLine();
         for (int i = 0; i < N; i++) {
            num.add(arr.charAt(2 * i + 1) - '0');
         }

         boolean error = false; // 에러가 났는지 안났는지
         boolean reverse = false; // 덱이 뒤집혔는지 아닌지

         // 명령의 길이만큼 돌린다.
         for (int i = 0; i < command.length(); i++) {
            // 명령이 R이라면
            if (command.charAt(i) == 'R') {
               // boolean reverse를 뒤집어
               reverse = !reverse;
            }
            // 명령이 D라면
            else {
               // 덱이 비었다면 에러처리하고 깨버려
               if (num.isEmpty()) {
                  sb.append("error").append('\n');
                  error = true;
                  break;
               }
               // 덱이 비어있지 않다면
               else {
                  // 뒤집혀있으면 맨 뒤 숫자를 제거하고
                  if (reverse) {
                     num.removeLast();
                  }
                  // 아니라면 첫 번째 숫자를 제거한다.
                  else {
                     num.removeFirst();
                  }
               }
            }
         }
         // 에러가 나지 않았다면 출력을 위한 스트링빌더 채우자
         if (!error) {
            sb.append('[');
            while (!num.isEmpty()) {
               // reverse라면 뒤에서부터, 아니라면 앞에서부터
               sb.append(reverse ? num.removeLast() : num.removeFirst());
               if (num.size() != 0) {
                  sb.append(',');
               }
            }
            sb.append(']').append('\n');
         }
      }
      // 출력
      System.out.println(sb);
   }
}
