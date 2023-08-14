package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1873 {
    static char[][] board;
    static int R;
    static int C;
    public static void main(String[] args) throws IOException {
        
        // 입력 세팅
        // System.setIn(new FileInputStream("input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int xx = 1; xx <= T; xx++) {
            
            // 행, 열, 필드 변수 생성
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            board = new char[R][C];
            
            // 필드 구성
            for (int r = 0; r < R; r++) {
                String s = br.readLine();
                for (int c = 0; c < C; c++) {
                    board[r][c] = s.charAt(c);
                }
            }
            
            // 전차 행동 변수
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            
            int[] cl;   // 전차 위치 변수
            for (int i = 0; i < n; i++) {

                int move = s.charAt(i);
                cl = checkTank(board);  // 탱크 위치 체크 메소드
                switch (move) {
                    case 'S':
                        shooting(cl[0], cl[1]); // 대포 발사 메소드
                        break;
                    case 'U':
                        moving(cl[0], cl[1], 'U');  // 전차 움직임 메소드
                        break;
                    case 'R':
                        moving(cl[0], cl[1], 'R');
                        break;
                    case 'D':
                        moving(cl[0], cl[1], 'D');
                        break;
                    case 'L':
                        moving(cl[0], cl[1], 'L');
                        break;
                    default:
                        break;
                }
            }

            System.out.printf("#%d ", xx);
            print();
        }
    }
    
    private static int[] checkTank(char[][] board) {
        int[] locate = new int[2];
        int R = board.length;
        int C = board[0].length;

        Loop:
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == '^' || board[r][c] == 'v' || board[r][c] == '<' || board[r][c] == '>') {
                    locate = new int[] { r, c };
                    break Loop;
                }
            }
        }

        return locate;
    }

    private static void shooting(int cr, int cc) {
        if (board[cr][cc] == '^') {
            while (--cr >= 0) {
                if (board[cr][cc] == '*') {
                    board[cr][cc] = '.';
                    break;
                } else if (board[cr][cc] == '#') {
                    break;
                }
            }
        } else if (board[cr][cc] == '>') {
            while (++cc < C) {
                if (board[cr][cc] == '*') {
                    board[cr][cc] = '.';
                    break;
                } else if (board[cr][cc] == '#') {
                    break;
                }
            }
        } else if (board[cr][cc] == 'v') {
            while (++cr < R) {
                if (board[cr][cc] == '*') {
                    board[cr][cc] = '.';
                    break;
                } else if (board[cr][cc] == '#') {
                    break;
                }
            }
        } else if (board[cr][cc] == '<') {
            while (--cc >= 0) {
                if (board[cr][cc] == '*') {
                    board[cr][cc] = '.';
                    break;
                } else if (board[cr][cc] == '#') {
                    break;
                }
            }
        }
    }

    private static void moving(int cr, int cc, char m) {

        switch (m) {
            case 'U':
                if (cr-1 >= 0 && board[cr-1][cc] == '.') {
                    board[cr - 1][cc] = '^';
                    board[cr][cc] = '.';
                } else {
                    board[cr][cc] = '^';
                }
                break;
            case 'R':
                if (cc+1 < C && board[cr][cc+1] == '.') {
                    board[cr][cc + 1] = '>';
                    board[cr][cc] = '.';
                } else {
                    board[cr][cc] = '>';
                }
                break;
            case 'D':
                if (cr+1 < R && board[cr+1][cc] == '.') {
                    board[cr + 1][cc] = 'v';
                    board[cr][cc] = '.';
                } else {
                    board[cr][cc] = 'v';
                }
                break;
            case 'L':
                if (cc-1 >= 0 && board[cr][cc-1] == '.') {
                    board[cr][cc - 1] = '<';
                    board[cr][cc] = '.';
                } else {
                    board[cr][cc] = '<';
                }
                break;
            default:
                break;
        }
    }

    private static void print() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(board[r][c]);
            }
            System.out.println();
        }
    }
}
