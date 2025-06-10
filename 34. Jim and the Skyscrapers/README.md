# Jim and the Skyscrapers

[![]( https://img.shields.io/badge/Бодлогын_линк-blue)](https://www.hackerrank.com/challenges/jim-and-the-skyscrapers/problem?isFullScreen=false)

## Бодлогын тайлбар

Жим HZ42 гэдэг шинэ нисдэг объект зохион бүтээсэн. HZ42 нь шүүгээтэй адилхан бөгөөд зөвхөг хэвтээ чиглэлд нисч чаддаг, орчны нөхцөлөөс үл хамааран. Нэг өдөр Жим Дубай хотын хамгийн өндөр өндөр байшингаас нисч, тодорхой зай туулж, ижил өндөртэй өөр байшин дээр бууж ирлээ! Гэхдээ харамсалтай нь саяхан шинэ өндөр байшингууд баригдсан байна.

**Бодлогын Тодорхойлолт**

Бидэнд N ширхэг өндөр байшин зүүнээс баруун тийш эгнэгдсэн байна. i-р байшингийн өндөр нь hi. Нислэгийн зам (i, j) (i ‡ j) хэлбэрээр тодорхойлогдох бөгөөд энэ нь Жим i байшингийн оройноос нисч, j байшин дээр бууна гэсэн үг. HZ42 зөвхөн хэвтээ чиглэлд нисдэг тул Жим hi өндөрт л байх болно. Иймд (i, j) зам хүчинтэй байхын тулд:

1. Бүх i, i+1, ..., j-1, j байшингуудын өндөр hi-ээс ихгүй байх ёстой
2. Эхлэх ба буух байшингуудын өндөр ижил байх ёстой (hi = hj)

**Оролтын Формат**

Эхний мөрөнд N - өндөр байшны тоо. Дараагийн мөрөнд N ширхэг зайгаар тусгаарлагдсан бүхэл тоонууд - байшингийн өндрүүд.

**Гаралтын Формат**

Хүчинтэй нислэгийн замын тоог хэвлэнэ.

**Хязгаарлалт**

1 ≤ N ≤ 3*10^5, байшингийн өндөр 1-ээс 10^6 хооронд.

**Жишээ Оролт 1**

```
6
3 2 1 2 3 3
```

**Жишээ Гаралт 1**

```
8
```

**Жишээ Оролт 2**

```
3
1 1000 1
```

**Жишээ Гаралт 2**

```
0
```

**Тайлбар**

Эхний жишээнд: (1,5), (1,6), (5,6), (2,4) болон эсрэг чиглэлийн замнууд (5,1), (6,1), (6,5), (4,2) нийт 8 зам хүчинтэй.

Хоёр дахь жишээнд: (1,3) ба (3,1) замнууд 1000 өндөртэй байшин байгаа учраас хүчинтэй биш.

## Бодолт

1. Өндрөөр бүлэглэх: Бид ижил өндөртэй байшингуудын индексийг мапаар бүлэглэнэ.

```
        Map<Integer, List<Integer>> heightToIndices = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            int h = arr.get(i);
            heightToIndices.putIfAbsent(h, new ArrayList<>());
            heightToIndices.get(h).add(i);
        }
```

2. Хүчинтэй хосыг шалгах: Ижил өндөртэй бүлэг бүр дэх бүх хос (i,j)-ийг шалгана.

```
        int total = 0;
        for (List<Integer> indices : heightToIndices.values()) {
            if (indices.size() < 2) continue;
            
            Stack<Integer> stack = new Stack<>();
            int count = 0;
```

3. Дунд өндөр шалгах: Хэрэв i ба j хооронд hi-ээс өндөр байшин байвал уг хосыг тооцохгүй.

```
    private static boolean hasHigherInBetween(List<Integer> arr, int a, int b) {
        int start = Math.min(a, b);
        int end = Math.max(a, b);
        int height = arr.get(a);
        
        for (int i = start + 1; i < end; i++) {
            if (arr.get(i) > height) {
                return true;
            }
        }
        return false;
    }
```

4. Хоёр чиглэлийг тооцох: (i,j) ба (j,i) хоёрыг тооцоход нийт тоог 2-оор үржүүлнэ.

```
            for (int i = 0; i < indices.size(); i++) {
                int currentIdx = indices.get(i);
                while (!stack.isEmpty() && hasHigherInBetween(arr, stack.peek(), currentIdx)) {
                    stack.pop();
                }
                count += stack.size();
                stack.push(currentIdx);
            }
            
            total += count * 2; // (i,j) and (j,i) pairs
        }
        return total;
```


## Submit screenshot

![Submit](/images/34.submit.png)

