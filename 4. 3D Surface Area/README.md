# 3D Surface Area

[![]( https://img.shields.io/badge/Бодлогын_линк-blue)](https://www.hackerrank.com/challenges/3d-surface-area/problem?isFullScreen=false)

## Бодлогын тайлбар

Мадисон бол тоглоомонд дуртай бяцхан охин. Түүний найз Мэйсон нь тоглоом үйлдвэрлэдэг үйлдвэрт ажилладаг. Мэйсонд H мөр, W багана бүхий A хэмжээтэй 2D самбар байна. Самбарын нүд бүр (i, j) координатаар тэмдэглэгдсэн байх ба A_{ij} тоо бичигдсэн байна. Тоглоомыг бүтээхийн тулд Мэйсон (i, j) нүд дээр A_{ij} ширхэг 1 × 1 × 1 хэмжээтэй шоо овоолно.

Өгөгдсөн самбарын A_{ij} утгууд дээр үндэслэн тоглоомын үнийг ол. Үнийг тоглоомын 3D гадаргуугийн талбайгаар тодорхойлно.

**Оролт**

Эхний мөрөнд H ба W хоёр бүхэл тоо зайгаар тусгаарлагдан өгөгдөнө. Эдгээр нь самбарын өндөр (мөр) ба өргөн (багана) юм.

Дараагийн H мөр бүрт W ширхэг бүхэл тоо зайгаар тусгаарлагдан өгөгдөнө. i дэх мөрийн j дэх тоо нь A_{ij}-ийг илэрхийлнэ.

**Хязгаарлалт**

- 1 ≤ H, W ≤ 100
- 1 ≤ A_{ij} ≤ 100

**Гаралт**

Тоглоомын үнийг (3D гадаргуугийн талбай) нэг мөрөнд хэвлэнэ.

**Жишээ**

Оролт:

```
1 1
1
```

Гаралт:

```
6
```

Тайлбар:

![LeetCode Screenshot](/images/4.cube.png)

- 1 × 1 × 1 хэмжээтэй шооны гадаргуугийн талбай 6 байна.

Оролт:

```
3 3
1 3 4
2 2 4
1 2 4
```

Гаралт:

    60

Тайлбар:

![LeetCode Screenshot](/images/4.area.png)

Гадаргуугийн талбайг тооцоолохдоо босоо, хэвтээ, урд, хойд талуудын нийлбэрийг авна.

## Функцийн Тайлбар

Энэхүү surfaceArea функц нь 2D хэлбэрээр өгөгдсөн шоо бүрчлэлийн 3D гадаргуугийн нийт талбайг тооцоолдог.

1. Оролтын утгуудын бэлтгэл:

- Самбарын өндөр (H) ба өргөн (W)-ийг уншина
- Самбарын нүд бүрийн утгыг уншиж, 2D жагсаалтанд хадгална

```
        int H = A.size();
        if (H == 0) return 0;
        int W = A.get(0).size();
        int total = 0;
```

2. Гадаргуугийн талбайн тооцоо:

    Нүд бүрийн хувьд:

- Дээд ба доод талын гадаргууг (2 нэгж) нэмнэ
- Хөрш зэргэлдээ нүднүүдтэй харьцуулан хажуу талуудын гадаргууг тооцно
- Ирмэгийн нүднүүдийн гадна талын гадаргууг бүрэн тооцдог

```
for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int height = A.get(i).get(j);
                // Top and bottom contribute 2 units if height > 0
                if (height > 0) {
                    total += 2;
                }
```
Нүүр гадаргуу

```
                if (i == 0) {
                    total += height;
                } else {
                    total += Math.max(0, height - A.get(i - 1).get(j));
                }
```

Хойд гадаргуу 
```
                if (i == H - 1) {
                    total += height;
                } else {
                    total += Math.max(0, height - A.get(i + 1).get(j));
                }
```
Зүүн гадаргуу
```
                if (j == 0) {
                    total += height;
                } else {
                    total += Math.max(0, height - A.get(i).get(j - 1));
                }
```
Баруун гадаргуу
```
                if (j == W - 1) {
                    total += height;
                } else {
                    total += Math.max(0, height - A.get(i).get(j + 1));
                }
            }
        }
```

3. Үр дүн:

Бүх нүднүүдийн гадаргуугийн нийлбэрийг буцаана

```
return total;
```

Submit screenshot

![LeetCode Screenshot](/images/3dsurfaceArea.png)