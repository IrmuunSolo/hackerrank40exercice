# The Time in Words

[![]( https://img.shields.io/badge/Бодлогын_линк-blue)](https://www.hackerrank.com/challenges/the-time-in-words/problem?isFullScreen=false)

## Бодлогын тайлбар

Даалгаварт цагийг тоон хэлбэрээс үг хэлбэрт шилжүүлэх шаардлагатай байна. Жишээ болгон зарим цагийг үгээр хэрхэн илэрхийлэхийг харуулсан байна.

**Жишээ:**

```
5:00 → "five o’ clock"
5:01 → "one minute past five"
5:10 → "ten minutes past five"
5:15 → "quarter past five"
5:30 → "half past five"
5:40 → "twenty minutes to six"
5:45 → "quarter to six"
5:47 → "thirteen minutes to six"
5:28 → "twenty eight minutes past five"
```

**Дүрэм:**

- Хэрэв минут (m) 0 байвал "o’ clock" гэж хэлнэ.

- Хэрэв 1≤m≤30 бол "past" гэж хэрэглэнэ.

- Хэрэв m>30 бол "to" гэж хэрэглэнэ.

- "o’ clock" гэхдээ апостроф ба "clock" хооронд зай байгааг анхаарна уу.

**Функцийн тодорхойлолт:**

timeInWords функц нь дараах параметрүүдийг авна:

- int h: цаг
- int m: минут

Функц нь цагийг үгээр илэрхийлсэн мөрийг буцаана.

**Оролтын формат:**

Эхний мөрөнд цаг (h), хоёр дахь мөрөнд минут (m) байна.

**Хязгаарлалт:**

- 1≤h≤12
- 0≤m<60

**Жишээ оролт ба гаралт:**

&emsp;**Оролт:**

    5
    47

&emsp;**Гаралт:**

    "thirteen minutes to six"

&emsp;**Оролт:**

    3
    00

&emsp;**Гаралт:**

    "three o’ clock"

&emsp;**Оролт:**

    7
    15

&emsp;**Гаралт:**

```"quarter past seven"```

## Бодолт

Эхлээд надад оруулсан цифрийг шууд текст болгоход ашиглах массив хэрэгтэй. String массив үүсгэе.

```java
String[] numberWords = {
        "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", ...
```

Одоо харин минут нь 0-ээс 30 хооронд байхдаа " past " үгийг оруулдаг тул эхний 30 минутыг нэг switch case -д бичье. Онцгой тохиолдлууд болох:

- минут нь 0 бол "hour o' clock " хэвлэнэ.
- минут нь 1 бол " minute past " ашиглана.
- минут нь 15 бол " quarter past " ашиглана.
- минут нь 30 бол " half past " ашиглана.

```java
if(m <= 30){
            switch(m){
                case 0:
                    word = numberWords[h - 1] + " o' clock";
                    break;
                case 1:
                    word = "one minute past " + numberWords[h - 1];
                    break;
                case 15:
                    word = "quarter past " + numberWords[h - 1];
                    break;
                case 30:
                    word = "half past " + numberWords[h - 1];
                    break;
                default:
                    word = numberWords[m - 1] + " minutes past " + numberWords[h - 1];
                    break;
            }
        }
```

30-аас их минуттай байх үед " minutes to " үгийг оруулах тул 30 хойшох минутыг өөр switch case -д бичье. Онцгой тохиолдлууд болох:

- минут нь 45 бол " quarter to " ашиглана.
- минут нь 59 бол " one minute to " ашиглана.

```java
else if(m < 60){
            switch(m){
                case 45: 
                    word = "quarter to " + numberWords[h];
                    break;
                case 59:
                    word = "one minute to " + numberWords[h];
                    break;
                default:
                    word = numberWords[60 - m - 1] + " minutes to " + numberWords[h];
                    break;
            }
        }
```

Сүүлд нь функц маань цагийг үгээр илэрхийлсэн үр дүнг буцаана.

![1factorail](/images/timeInWordOutput.png)

## Submit screenshot

![1factorail](/images/timeInWords.png)