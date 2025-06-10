# Sherlock and the Valid String

[![]( https://img.shields.io/badge/Бодлогын_линк-blue)](https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?isFullScreen=true)

## Бодлогын тайлбар

Шерлокын тодорхойлсноор, тэмдэгт мөр нь дараах хоёр нөхцлийн аль нэгийг хангавал хүчинтэй гэж үзнэ:

1. Тэмдэгт мөр дэх бүх тэмдэгтүүд ижил тооны удаа давтагдсан байх.
2. Эсвэл зөвхөн 1 тэмдэгтийг 1 индекстээс устгаснаар үлдсэн тэмдэгтүүд ижил тооны удаа давтагдсан болох.

Тэмдэгт мөр s өгөгдсөн үед, энэ нь хүчинтэй эсэхийг шалгана. Хэрэв хүчинтэй бол YES, эсрэг тохиолдолд NO гэж буцаана.

**Жишээ:**

- s=abc: Хүчинтэй, учир нь давтамжууд {a:1,b:1,c:1}.
- s=abcc: Хүчинтэй, учир нь 1 c-г устгахад {a:1,b:1,c:1} болно.
- s=abccc: Хүчинтэй биш, учир нь 1 c-г устгахад {a:1,b:1,c:2} болно.

## Бодолт:

1. Тэмдэгт бүрийн давтамжийг тоолох:

- HashMap ашиглан тэмдэгт бүрийн давтамжийг тоолно.

```
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
```

2. Давтамжуудын хуваарилалтыг шалгах:

- Хэрэв бүх давтамжууд ижил байвал YES.
- Хэрэв давтамжуудын хуваарилалт дараах нөхцлийг хангаж байвал YES:

  - Зөвхөн нэг давтамж нь 1-ээр их байх ба бусад нь ижил байх.
  - Эсвэл нэг давтамж нь бусад бүх давтамжаас 1-ээр их байх.

- Бусад тохиолдолд NO.

```
        if (countMap.size() == 1) {
            return "YES";
        }
        if (countMap.size() == 2) {
            Iterator<Integer> it = countMap.keySet().iterator();
            int freq1 = it.next();
            int freq2 = it.next();
            int count1 = countMap.get(freq1);
            int count2 = countMap.get(freq2);
            
            if ((freq1 == 1 && count1 == 1) || (freq2 == 1 && count2 == 1)) {
                return "YES";
            }

            if ((freq1 - freq2 == 1 && count1 == 1) || (freq2 - freq1 == 1 && count2 == 1)) {
                return "YES";
            }
        }
        
        return "NO";
```

## Submit screenshot

![Submit](/images/37.submit.png)

