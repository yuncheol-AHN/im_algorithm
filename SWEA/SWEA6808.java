package SWEA;

import java.io.*;
import java.util.*;

// 규영이와 인영이의 카드게임
public class SWEA6808 {
    static List<Integer> computerList;
    static List<Integer> playerList;
    static int winsCount = 0;
    static int losesCount = 0;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int x = 1; x <= T; x++) {
            st = new StringTokenizer(br.readLine());
            computerList = new ArrayList<>();
            playerList = new ArrayList<>();
            winsCount = 0;
            losesCount = 0;
            boolean[] sel = new boolean[9];

            for (int i = 0; i < 9; i++)
                computerList.add(Integer.parseInt(st.nextToken()));

            for (int i = 1; i <= 18; i++) {
                if (!computerList.contains(i))
                    playerList.add(i);
            }

            //System.out.println(computerList);
            //System.out.println(playerList);

            //높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻고,
            //낮은 수가 적힌 카드를 낸 사람은 아무런 점수도 얻을 수 없다.

            recursive(0, 0, 0, sel);
            System.out.printf("#%d %d %d\n", x, losesCount, winsCount);
        }
    }
    private static void recursive (int idx, int playerPoint, int computerPoint, boolean[] sel) {

        if (playerPoint > 153) {
            winsCount++;
            return;
        }

        if (idx == 9) {
            if (playerPoint > computerPoint)
                winsCount++;
            else if (playerPoint < computerPoint)
                losesCount++;
            return;
        }

        for (int i = 0; i < 9; i++) {

            if (sel[i] == false) {
                sel[i] = true;
                if (playerList.get(i) > computerList.get(idx)) {
                    recursive(idx+1, playerPoint + (playerList.get(i) + computerList.get(idx)), computerPoint, sel);
                } else if (playerList.get(i) < computerList.get(idx)) {
                    recursive(idx+1, playerPoint, computerPoint + (playerList.get(i) + computerList.get(idx)), sel);
                }
                sel[i] = false;
            }
        }
    }
}