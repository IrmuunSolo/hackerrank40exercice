# The Bomberman Game

[![]( https://img.shields.io/badge/Бодлогын_линк-blue)](https://www.hackerrank.com/challenges/bomber-man/problem?isFullScreen=true)

## Бодлогын тайлбар

Бомбермен тэгш өнцөгт grid-т амьдардаг. Grid-ийн нүд бүрт бөмбөг байж болно, эсвэл хоосон байж болно.

**Бөмбөгний ажиллах зарчим:**

- Бөмбөг grid-ийн аль ч нүдэнд тавигдаж болно
- Бөмбөг тавигдсанаас хойш яг 3 секундын дараа дэлбэрнэ
- Дэлбэрэх үед тухайн бөмбөг болон түүний 4 хөрш нүднүүд (дээш, доош, зүүн, баруун) устгагдана
- Хэрэв хөрш нүдэнд бөмбөг байсан бол тэр бөмбөг дэлбэрэлгүй устгагдана (гинжин урвал үүсэхгүй)
- Бомбермен бөмбөгнөөс иммунитеттай тул чөлөөтэй хөдөлж чадна

**Бомбермен үйлдлүүд:**

- Эхний үе шат: Бомбермен grid-ийн зарим нүдэнд бөмбөг тавьдаг (анхны төлөв)
 -1 секундын дараа: Юу ч хийхгүй
- 2 секундын дараа: Бүх хоосон нүдэнд бөмбөг тавьдаг (бүх grid дүүрэн бөмбөгтэй болно)
- 3 секундын дараа: 3 секундын өмнө тавьсан бөмбөгнүүд дэлбэрнэ (Бомбермен ажиглалт хийнэ)
- Дараа нь 3, 4-р алхмуудыг үргэлжлүүлэн давтана

Анхаар: Бөмбөг бүгдийг нэгэн зэрэг тавих ба нэгэн зэрэг дэлбэрнэ.

**Оролт:**

- Эхний мөр: r (мөр), c (багана), n (секунд) тоонууд

- Дараагийн r мөр: Grid-ийг илэрхийлэх мөрүүд ('.' - хоосон, 'O' - бөмбөг)

**Гаралт:**

- n секундын дараах grid-ийн төлөв

**Хязгаарлалт:**

- 1 ≤ r, c ≤ 200

- 1 ≤ n ≤ 10^9

**Жишээ**

**Оролт:**

```
6 7 3
.......
...O...
...O...
.......
OO.....
OO.....
```

**Гаралт:**

```
OOO.OOO
OO...OO
OOO...O
..OO.OO
...OOOO
...OOOO
```

## Бодолт

Алгоритм:

- Хэрэв n == 1 бол анхны grid-ийг буцаана

```
        if (n == 1) return grid;
```

- Хэрэв n % 2 == 0 бол бүх нүд бөмбөгтэй grid буцаана

```
        if (n % 2 == 0) {
            return fillAll(grid);
        }
```

- Хэрэв n % 4 == 3 бол эхний дэлбэрэлтийн дараах grid буцаана

```
        List<String> firstDetonation = detonate(grid);
        
        if (n % 4 == 3) {
            return firstDetonation;
        }
```

- Хэрэв n % 4 == 1 бол хоёр дахь дэлбэрэлтийн дараах grid буцаана

```
        return detonate(firstDetonation);
    }

        private static List<String> fillAll(List<String> grid) {
        List<String> result = new ArrayList<>();
        String filledRow = "O".repeat(grid.get(0).length());
        for (int i = 0; i < grid.size(); i++) {
            result.add(filledRow);
        }
        return result;
    }
    
    private static List<String> detonate(List<String> grid) {
        int r = grid.size();
        int c = grid.get(0).length();
        char[][] result = new char[r][c];
        
        for (int i = 0; i < r; i++) {
            Arrays.fill(result[i], 'O');
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid.get(i).charAt(j) == 'O') {
                    result[i][j] = '.';
                    if (i > 0) result[i-1][j] = '.';
                    if (i < r-1) result[i+1][j] = '.';
                    if (j > 0) result[i][j-1] = '.';
                    if (j < c-1) result[i][j+1] = '.';
                }
            }
        }
        
        List<String> output = new ArrayList<>();
        for (char[] row : result) {
            output.add(new String(row));
        }
        return output;
    }
```

**Тайлбар:**

1. fillAll(): Бүх нүдийг бөмбөгтэй болгох функц

2. detonate(): Бөмбөг дэлбэрэх үйлдлийг гүйцэтгэх функц

3. bomberMan(): Үндсэн логик:

  - Хэрэв n=1 бол анхны grid буцаана

  - Хэрэв n тэгш бол бүх нүд бөмбөгтэй grid буцаана

  - Хэрэв n%4==3 бол эхний дэлбэрэлтийн дараах grid буцаана

  - Хэрэв n%4==1 бол хоёр дахь дэлбэрэлтийн дараах grid буцаана



## Submit screenshot

![Submit](/images/19.submit.png)

