# Mr. X and His Shots

[![]( https://img.shields.io/badge/Бодлогын_линк-blue)](https://www.hackerrank.com/challenges/x-and-his-shots/problem?isFullScreen=false)

## Бодлогын тайлбар

Крикет тоглоом зохион байгуулагдахаар боллоо. Талбайг 1D хавтгайгаар дүрсэлсэн. Крикетчин Ноён X-д N дуртай цохилтууд байна. i-р цохилтын хүрээ Ai-ээс Bi хүртэл. Эсрэг багийн тоглогч бүр зөвхөн тодорхой хүрээнд л талбайд гарч чадна. i-р тоглогч Ci-ээс Di хүртэлх хүрээнд гарч чадна.

Si нь тоглогчийн хүчийг илэрхийлнэ, өөрөөр хэлбэл тухайн тоглогч хэдэн цохилтыг зогсоож чадах вэ.

Таны даалгавар бол бүх тоглогчдын хүчний нийлбэрийг олох явдал юм: (Σi=1 ^m ) Si.

**Тоглоомын Дүрэм:**

Тоглогч i-р цохилтыг зогсоож чадна, хэрэв тоглогчийн талбайлах хүрээ ба цохилтын хүрээ огтлолцож байвал.

![Submit](/images/33.1.png)

**Оролтын Формат:**

Эхний мөрөнд N ба M бүхэл тоонууд.\
Дараагийн N мөр бүрт Ai ба Bi тоонууд.\
Дараагийн M мөр бүрт Ci ба Di тоонууд.

**Гаралтын Формат:**

Бүх тоглогчдын хүчний нийлбэр.

**Хязгаарлалт:**

- 1 < N, M ≤ 10^5
- 1 ≤ Ai, Bi, Ci, Di ≤ 10^8

**Жишээ Оролт:**

```
4 4
1 2 
2 3
4 5
6 7
1 5
2 3
4 7
5 7
```

**Жишээ Гаралт:**

```
9
```

**Тайлбар:**

- Тоглогч 1: 1, 2, 3-р цохилтыг зогсоож чадна (3)
- Тоглогч 2: 1, 2-р цохилтыг зогсоож чадна (2)
- Тоглогч 3: 3, 4-р цохилтыг зогсоож чадна (2)
- Тоглогч 4: 3, 4-р цохилтыг зогсоож чадна (2)
Нийлбэр: 3 + 2 + 2 + 2 = 9

## Бодолт:

Энэ бодлогыг шийдэхийн тулд бид интервалуудын огтлолцлыг шууд шалгах аргыг ашиглах болно. Оронд нь интервалуудыг эрэмбэлээд хоёртын хайлт хийх аргаар бодно.

1. Интервалын огтлолцол: Хоёр интервал [A,B] ба [C,D] огтлолцох нөхцөл нь A <= D && C <= B юм.

```
    private static int countGreaterOrEqual(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return list.size() - left;
    }
```

2. Оновчтой арга: Бид цохилтын эхлэл (Ai) ба төгсгөл (Bi) цэгүүдийг тусад нь эрэмбэлээд, тоглогчийн хүрээнд [C,D] харгалзах Ai <= D ба Bi >= C нөхцлийг хоёртын хайлтаар шуурхай тоолно.

```
    private static int countLessOrEqual(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
```

3. Тооцоолол: Нийт огтлолцлын тоо = (Bi >= C байх тоо) + (Ai <= D байх тоо) - нийт цохилтын тоо.

```
        int total = 0;
        
        for (List<Integer> player : players) {
            int C = player.get(0);
            int D = player.get(1);
            
            int count1 = countGreaterOrEqual(ends, C);
            int count2 = countLessOrEqual(starts, D);
            int overlap = count1 + count2 - shots.size();
            
            total += overlap;
        }
        
        return total;
```


## Submit screenshot

![Submit](/images/33.submit.png)

