# Count Luck

[![]( https://img.shields.io/badge/Бодлогын_линк-blue)](https://www.hackerrank.com/challenges/count-luck/problem?isFullScreen=true)

## Бодлогын тайлбар

Рон болон Хермиона нар шидэт ой дотор зөөвөрлөгч хайж байгаад замдаа алдсан. Тэд N×M хэмжээтэй тор хэлбэртэй ойд байгаа бөгөөд энэ торын нүд бүр нь хоосон (.) эсвэл модоор (X) хаагдсан байна. Тэд зөвхөн хоосон нүднүүдээр дамжин зүүн, баруун, дээш, доош хөдөлж чадна. Тэдний эхлэх нүд нь M, харин зөөвөрлөгч нь ∗-аар тэмдэглэгдсэн байна. Хермиона замдаа салаалсан замаар явахдаа өөрийн саваагаа чиглүүлэх шаардлагатай болдог. Рон түүний саваа чиглүүлэх тоо k байна гэж таамагласан. Түүний таамаг зөв эсэхийг шалгах хэрэгтэй.

**Функцийн тодорхойлолт:**

countLuck функцийг гүйцээх шаардлагатай. Энэ функц нь дараах параметрүүдтэй:

- matrix: торын мөрүүдийг агуулсан жагсаалт
- k: Ронын таамагласан саваа чиглүүлэх тоо

**Буцаах утга:**

- String: "Impressed" (Ронын таамаг зөв) эсвэл "Oops!" (буруу)

**Оролтын формат:**

Эхний мөрөнд тестийн тоо t өгөгдөнө.

Дараагийн t тест бүрийн хувьд:

- Эхний мөрөнд n ба m (торын мөр, баганын тоо)
- Дараагийн n мөр бүрт m урттай мөр (торын мөр)
- Сүүлийн мөрөнд k (Ронын таамаг)

**Хязгаарлалт:**

- 1≤t≤10
- 1≤n,m≤100
- 0≤k≤10000
- Торонд яг нэг M ба нэг ∗ байна.
- M-ээс ∗-руу яг нэг зам байна.

**Жишээ оролт:**

```
3
2 3
*.M
.X.
1
4 11
.X.X....X
.X*.X..XXX.X
.XX.X.XM...
.....XXXX.
3
4 11
.X.X....X
.X*.X..XXX.X
.XX.X.XM...
.....XXXX.
4
```

**Жишээ гаралт:**

```
Impressed
Impressed
Oops!
```

Тайлбар:

1. Эхний тест: Саваа 1 удаа чиглүүлсэн тул "Impressed".
2. Хоёр дахь тест: Саваа 3 удаа чиглүүлсэн тул "Impressed".
3. Гурав дахь тест: Саваа 3 удаа чиглүүлсэн (k=4) тул "Oops!".

## Бодолт:

1. Өгөгдлийг унших
- Матрицын хэмжээг n (мөр), m (багана) хэлбэрээр авна.
- Матрицыг уншиж, M (эхлэл цэг) болон * (порткей) байгаа байршлыг хадгална.

```
    int n = matrix.size();
    int m = matrix.get(0).length();

    char[][] grid = new char[n][m];
    int startX = -1, startY = -1;
```

2. Path Finding (Нэг замтай BFS/DFS)
- M цэгээс эхэлж, зөвхөн ., * тэмдэгтэй эсүүдээр явж * рүү хүрнэ.
- Энэ үед зөвхөн нэг зам байгаа гэдэг нь баталгаатай учраас DFS эсвэл BFS аль нь ч болно.
- Замаа хадгалахын тулд parent эсвэл path list ашиглана.

```
private static int dfs(char[][] grid, boolean[][] visited, int x, int y) {
    if (grid[x][y] == '*') return 0;

    visited[x][y] = true;
    int[] dx = {-1, 1, 0, 0};  
    int[] dy = {0, 0, -1, 1};

    List<int[]> nextMoves = new ArrayList<>();

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i], ny = y + dy[i];
        if (isValid(grid, visited, nx, ny)) {
            nextMoves.add(new int[]{nx, ny});
        }
    }

    for (int[] move : nextMoves) {
        int waves = dfs(grid, visited, move[0], move[1]);
        if (waves != -1) {
            return nextMoves.size() > 1 ? waves + 1 : waves;
        }
    }

    return -1; // not found
}
```

3. Wand Wave тоолох
- Замаа дагаж явах үед сонголттой хэсгүүдийг тоолно.
- Сонголттой гэдэг нь тухайн цэгээс 2 эсвэл түүнээс олон чиглэлд цааш явах боломжтой үед юм.

```
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i], ny = y + dy[i];
        if (isValid(grid, visited, nx, ny)) {
            nextMoves.add(new int[]{nx, ny});
        }
    }

    for (int[] move : nextMoves) {
        int waves = dfs(grid, visited, move[0], move[1]);
        if (waves != -1) {
            return nextMoves.size() > 1 ? waves + 1 : waves;
        }
    }

    return -1; 
```


## Submit screenshot

![Submit](/images/17.submit.png)

