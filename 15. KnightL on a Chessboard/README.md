# KnightL on a Chessboard

[![]( https://img.shields.io/badge/Бодлогын_линк-blue)](https://www.hackerrank.com/challenges/knightl-on-chessboard/problem?isFullScreen=true)

## Бодлогын тайлбар

Бидэнд n×n хэмжээтэй шатрын самбар өгөгдсөн. Самбар дээрх KnightL(a, b) хөлөг нь дараах дүрмийн дагуу хөдөлнө:

- (x 1 ,y 1 ) байрлалаас ((x2​, y2​) руу x2 = x1 ± a ±a ба y2 = y1 ± b эсвэл x2 = x1 ± b ба y2 = y1 ± a гэсэн нөхцлөөр шилжиж болно.

KnightL(a, b) хөлөг (0,0) байрлалаас (n−1,n−1) байрлалд хүрэх хамгийн бага хөдөлгөөний тоог олох ёстой. Хэрэв хүрэх боломжгүй бол -1 гэж буцаана.

**Жишээ:**

n=5 үед KnightL(1, 2) хөлөг (0,0)-ээс (4,4) руу хамгийн багадаа 4 хөдөлгөөнөөр хүрч болно.

**Функцийн тодорхойлолт:**

knightlOnAChessboard функцийг гүйцээх шаардлагатай. Энэ функц нь дараах параметртэй:

- int n: шатрын самбарын хэмжээ

**Буцаах утга:**

List<List<Integer>>: (n−1)×(n−1) хэмжээтэй жагсаалт бөгөөд эхний мөр нь KnightL(1,1), KnightL(1,2), ..., KnightL(1,n-1)-ийн үр дүнг, хоёр дахь мөр нь KnightL(2,1), KnightL(2,2), ..., KnightL(2,n-1)-ийн үр дүнг агуулна.

**Оролтын формат:**

Ганц бүхэл тоо n.

**Хязгаарлалт:**

5≤n≤25

**Жишээ оролт:**

```
5
```

**Жишээ гаралт:**

```
4 4 2 8
4 2 4 4
2 4 -1 -1
8 4 -1 1
```

Тайлбар:

Эхний мөрөнд:

- KnightL(1,1): 4 хөдөлгөөн
- KnightL(1,2): 4 хөдөлгөөн
- KnightL(1,3): 2 хөдөлгөөн
- KnightL(1,4): 8 хөдөлгөөн

## Бодолт:

1. Бүх (a, b) хосыг шалгах: 1≤a,b<n бүх хосын хувьд BFS ашиглан хамгийн бага хөдөлгөөний тоог олно.

```
        List<List<Integer>> result = new ArrayList<>();
        for (int a = 1; a < n; a++) {
            List<Integer> row = new ArrayList<>();
            for (int b = 1; b < n; b++) {
                row.add(findMinMoves(n, a, b));
            }
```

2. BFS хэрэгжүүлэх: (0,0)-ээс эхлэн (n−1,n−1) хүртэлх хамгийн богино замыг олох.

```
    private static int findMinMoves(int n, int a, int b) {
        int[][] directions = {{a, b}, {a, -b}, {-a, b}, {-a, -b}, {b, a}, {b, -a}, {-b, a}, {-b, -a}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];

            if (x == n - 1 && y == n - 1) {
                return moves;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY, moves + 1});
                }
            }
        }
        return -1;
    }
```

3. Хүрэх боломжгүй тохиолдол: Хэрэв BFS дууссан ч (n−1,n−1)-д хүрээгүй бол -1 буцаана.

```
    public static List<List<Integer>> knightlOnAChessboard(int n) {
        List<List<Integer>> result = new ArrayList<>();
        for (int a = 1; a < n; a++) {
            List<Integer> row = new ArrayList<>();
            for (int b = 1; b < n; b++) {
                row.add(findMinMoves(n, a, b));
            }
            result.add(row);
        }
        return result;
    }
```

**Тайлбар:**

1. Бүх (a, b) хосын хувьд BFS ажиллуулах: knightlOnAChessboard функц нь бүх (a, b) хосын хувьд findMinMoves функцийг дуудаж, хамгийн бага хөдөлгөөний тоог олно.

2. BFS хэрэгжүүлэх: findMinMoves функц нь BFS ашиглан (0,0)-ээс (n−1,n−1) хүртэлх хамгийн богино замыг олдог. Хэрэв зам олдвол хөдөлгөөний тоог, олдохгүй бол -1 буцаана.

3. Үр дүнг хэвлэх: Олдсон үр дүнг хүснэгт хэлбэрээр хэвлэнэ.

## Submit screenshot

![Submit](/images/15.submit.png)

