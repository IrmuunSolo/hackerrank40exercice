# Sparse Arrays

[![]( https://img.shields.io/badge/Бодлогын_линк-blue)](https://www.hackerrank.com/challenges/pairs/problem?isFullScreen=true)

## Бодлогын тайлбар

Энэ бодлогын зорилго нь өгөгдсөн текстүүдийн жагсаалтаас асуултын текстүүд хэдэн удаа гарч байгааг тоолох юм.

**Жишээ:**

**Оролт:**

```
stringList = ['ab', 'ab', 'abc']
queries = ['ab', 'abc', 'bc']
```

**Гаралт:**

```
[2, 1, 0]
```

**Тайлбар:**

- 'ab' 2 удаа гарч байна
- 'abc' 1 удаа гарч байна
- 'bc' 0 удаа гарч байна

**Функцийн тодорхойлолт**

matchingStrings функцийг гүйцээх шаардлагатай:

**Параметрүүд:**

- List<String> stringList: хайлт хийх текстийн жагсаалт
- List<String> queries: асуултын текстийн жагсаалт

**Буцаах утга:**

- List<Integer>: асуулт бүрт харгалзах тооллын үр дүн

**Оролтын формат**

- Эхний мөр: n (stringList-ийн урт)
- Дараагийн n мөр: stringList-ийн элементүүд
- Дараагийн мөр: q (queries-ийн урт)
- Дараагийн q мөр: queries-ийн элементүүд

**Хязгаарлалт**

- 1 ≤ n ≤ 1000
- 1 ≤ q ≤ 1000
- Текст бүрийн урт 20 тэмдэгтээс хэтрэхгүй

## Бодолт

1. Тоолуур үүсгэх: HashMap ашиглан текст бүрийн тоог хадгалах

```
        Map<String, Integer> countMap = new HashMap<>();
```

2. Тоолох: stringList-д байгаа текст бүрийг тоолж HashMap-д хадгалах

```
        for (String str : stringList) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }
        
```

3. Хариу үүсгэх: queries-ийн текст бүрийн тоог HashMap-ээс хайж үр дүнг үүсгэх

```
        List<Integer> results = new ArrayList<>();
        for (String query : queries) {
            results.add(countMap.getOrDefault(query, 0));
        }
        
        return results;
```

## Submit screenshot

![Submit](/images/21.submit.png)

